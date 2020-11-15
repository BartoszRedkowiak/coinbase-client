package com.example.coinbaselistener.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Instrument {
    BTCUSD("BTC-USD"),
    BTCEUR("BTC-EUR"),
    ETHUSD("ETH-USD"),
    ETHEUR("ETH-EUR");


    private String coinbaseFormat;

    Instrument(String coinbaseFormat) {
        this.coinbaseFormat = coinbaseFormat;
    }

    @JsonCreator
    public static Instrument forValue(String value){
        for (Instrument instrument : values()){
            if (instrument.coinbaseFormat.equals(value)){
                return instrument;
            }
        }
        return null;
    }


}
