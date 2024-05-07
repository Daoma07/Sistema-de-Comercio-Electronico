package com.example.Api_Gateway.controller;

import com.example.Api_Gateway.rabbit_client.RabbitMQClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.utilities.dto.ProductoDto;
import com.mycompany.utilities.dto.ProductoTallaDto;
import com.mycompany.utilities.dto.UsuarioDto;
import com.mycompany.utilities.request.RequestFormat;
import com.mycompany.utilities.response.ResponseFormat;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("api/product")
public class GatewayProductoController {

    private RabbitMQClient rabbitMQClient;

    @Autowired
    private ObjectMapper objectMapper;

    public GatewayProductoController(RabbitMQClient rabbitMQClient) {
        this.rabbitMQClient = rabbitMQClient;
    }

    @PostMapping("/register")
    public ResponseFormat servicioRegister(@RequestBody ProductoDto productoDto) throws JsonProcessingException {
        String jsonusuario = objectMapper.writeValueAsString(productoDto);
        RequestFormat requestFormat = new RequestFormat(jsonusuario, "create-product");
        return rabbitMQClient.sendMessageInventario(requestFormat);
    }

    @GetMapping("/readTallas")
    public ResponseFormat servicioReadTallas() throws JsonProcessingException {
        RequestFormat requestFormat = new RequestFormat("", "read-tallas");
        return rabbitMQClient.sendMessageInventario(requestFormat);
    }

    @GetMapping("/readCategorias")
    public ResponseFormat servicioReadCategorias() throws JsonProcessingException {
        RequestFormat requestFormat = new RequestFormat("", "read-categorias");
        return rabbitMQClient.sendMessageInventario(requestFormat);
    }

    @GetMapping("/readEstilos")
    public ResponseFormat servicioReadEstilos() throws JsonProcessingException {
        RequestFormat requestFormat = new RequestFormat("", "read-estilos");
        return rabbitMQClient.sendMessageInventario(requestFormat);
    }

}
