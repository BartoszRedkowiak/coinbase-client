package com.example.coinbaselistener.integration;

import com.example.coinbaselistener.constant.ChannelType;
import com.example.coinbaselistener.dto.InstrumentDto;
import com.example.coinbaselistener.service.InstrumentCrudService;
import com.example.coinbaselistener.util.SubscriptionMessageReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

@Component
@Log4j2
public class CoinbaseTickerSessionHandler implements WebSocketHandler {

    @Autowired
    SubscriptionMessageReader subscriptionMessageReader;

    @Autowired
    InstrumentCrudService instrumentService;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String message = subscriptionMessageReader.asString();
        session.sendMessage(new TextMessage(message));
        log.info("Subscribing with message: \n" + message);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info(message.getPayload());
        InstrumentDto instrument = mapper.readValue((String) message.getPayload(), InstrumentDto.class);
        if ( instrument.getType() != ChannelType.SUBSCRIPTIONS){
            instrumentService.saveInstrument(instrument);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error(exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Connection closed. Reason: " + closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {
        return true;
    }
}
