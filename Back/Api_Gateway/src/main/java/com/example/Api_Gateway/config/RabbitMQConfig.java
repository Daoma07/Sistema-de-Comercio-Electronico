package com.example.Api_Gateway.config;

import java.util.List;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.usuario.queue.name}")
    private String usuarioQueue;

    @Value("${rabbitmq.usuario.routing.key}")
    private String usuarioRoutingKey;

    @Value("${rabbitmq.inventario.queue.name}")
    private String inventarioQueue;

    @Value("${rabbitmq.inventario.routing.key}")
    private String inventarioRoutingKey;

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue usuarioQueue() {
        return new Queue(usuarioQueue);
    }

    @Bean
    public Queue inventarioQueue() {
        return new Queue(inventarioQueue);
    }

    @Bean
    public Binding usuarioBinding() {
        return BindingBuilder.bind(usuarioQueue())
                .to(exchange())
                .with(usuarioRoutingKey);
    }

    @Bean
    public Binding inventarioBinding() {
        return BindingBuilder.bind(inventarioQueue())
                .to(exchange())
                .with(inventarioRoutingKey);
    }

    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of("com.mycompany.utilities.dto.*",
                "com.mycompany.utilities.request.*",
                "com.mycompany.utilities.response.*"));
        return converter;
    }
}