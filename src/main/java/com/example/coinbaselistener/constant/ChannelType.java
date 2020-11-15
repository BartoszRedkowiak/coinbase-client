package com.example.coinbaselistener.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChannelType {

    @JsonProperty("subscriptions") SUBSCRIPTIONS,
    @JsonProperty("ticker") TICKER,
    @JsonProperty("status") STATUS,
    @JsonProperty("heartbeat") HEARTBEAT,
    @JsonProperty("l2update") L2UPDATE,
    @JsonProperty("snapshot") SNAPSHOT;

}
