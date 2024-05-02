package com.example.Inventario_Service.rabit_client;

import com.example.Inventario_Service.manager.ActionRouter;
import com.mycompany.utilities.request.RequestFormat;
import com.mycompany.utilities.response.ResponseFormat;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQClient {

    private final ActionRouter actionRouter;

    public RabbitMQClient(ActionRouter actionRouter) {
        this.actionRouter = actionRouter;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public ResponseFormat consume(@Payload RequestFormat request) throws Exception {
        ResponseFormat responseFormat = new ResponseFormat();
        try {
            responseFormat = actionRouter.route(request);
        } catch (Exception ex) {
            responseFormat.setResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseFormat.setContent(ex.getMessage());
        }
        return responseFormat;
    }
}
