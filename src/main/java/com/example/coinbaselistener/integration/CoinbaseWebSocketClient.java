package com.example.coinbaselistener.integration;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
@Log4j2
public class CoinbaseWebSocketClient {

    @Value("${coinbase.websocket.url}")
    private String url;

    @Autowired
    WebSocketHandler sessionHandler;

    @Bean
    public WebSocketClient webSocketClient() {
        WebSocketClient client = new StandardWebSocketClient();
        client.doHandshake(sessionHandler, url);
        log.info("Established a websocket handshake with " + url);
        return client;
    }

}
