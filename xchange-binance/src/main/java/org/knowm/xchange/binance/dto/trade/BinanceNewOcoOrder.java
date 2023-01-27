package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BinanceNewOcoOrder {

    public final String symbol;
    public final long orderId;
    public final String clientOrderId;

    public BinanceNewOcoOrder(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("clientOrderId") String clientOrderId) {
        super();
        this.symbol = symbol;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
    }
}
