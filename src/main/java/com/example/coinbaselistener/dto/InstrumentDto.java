package com.example.coinbaselistener.dto;

import com.example.coinbaselistener.constant.ChannelType;
import com.example.coinbaselistener.constant.Instrument;
import com.example.coinbaselistener.dto.serializers.CustomInstantDeserializer;
import com.example.coinbaselistener.dto.serializers.CustomInstantSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"instrument", "bid", "ask", "last", "time"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentDto {
    private ChannelType type;
    private Long tradeId;
    private Long sequence;
    private Instant time;
    private Instrument instrument;
    private Double last;
    private String side;
    private Double lastSize;
    private Double bid;
    private Double ask;

    @JsonIgnore
    public ChannelType getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(ChannelType type) {
        this.type = type;
    }

    @JsonIgnore
    public Long getTradeId() {
        return tradeId;
    }

    @JsonProperty("trade_id")
    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    @JsonIgnore
    public Long getSequence() {
        return sequence;
    }

    @JsonProperty("sequence")
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @JsonProperty("time")
    @JsonSerialize(using = CustomInstantSerializer.class)
    public Instant getTime() {
        return time;
    }

    @JsonProperty("time")
    @JsonDeserialize(using = CustomInstantDeserializer.class)
    public void setTime(Instant time) {
        this.time = time;
    }

    @JsonProperty("instrument")
    public Instrument getInstrument() {
        return instrument;
    }

    @JsonProperty("product_id")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @JsonProperty("last")
    public Double getLast() {
        return last;
    }

    @JsonProperty("price")
    public void setLast(Double last) {
        this.last = last;
    }

    @JsonIgnore
    public String getSide() {
        return side;
    }

    @JsonProperty("side")
    public void setSide(String side) {
        this.side = side;
    }

    @JsonIgnore
    public Double getLastSize() {
        return lastSize;
    }

    @JsonProperty("last_size")
    public void setLastSize(Double lastSize) {
        this.lastSize = lastSize;
    }

    @JsonProperty("bid")
    public Double getBid() {
        return bid;
    }

    @JsonProperty("best_bid")
    public void setBid(Double bid) {
        this.bid = bid;
    }

    @JsonProperty("ask")
    public Double getAsk() {
        return ask;
    }

    @JsonProperty("best_ask")
    public void setAsk(Double ask) {
        this.ask = ask;
    }
}
