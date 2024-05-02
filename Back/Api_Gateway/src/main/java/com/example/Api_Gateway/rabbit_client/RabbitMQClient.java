package com.example.Api_Gateway.rabbit_client;

import com.mycompany.utilities.request.RequestFormat;
import com.mycompany.utilities.response.ResponseFormat;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQClient {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.usuario.routing.key}")
    private String usuarioRoutingKey;

    @Value("${rabbitmq.inventario.routing.key}")
    private String inventarioRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQClient(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public ResponseFormat sendMessageUsuario(RequestFormat request) {
        try {
            return (ResponseFormat) rabbitTemplate.convertSendAndReceive(
                    exchange,
                    usuarioRoutingKey,
                    request);

        } catch (Exception e) {
            return null;
        }
    }

    public ResponseFormat sendMessageInventario(RequestFormat request) {
        try {
            return (ResponseFormat) rabbitTemplate.convertSendAndReceive(
                    exchange,
                    inventarioRoutingKey,
                    request);

        } catch (Exception e) {
            return null;
        }
    }
}
