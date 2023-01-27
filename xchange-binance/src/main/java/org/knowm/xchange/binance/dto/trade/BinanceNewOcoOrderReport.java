package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class BinanceNewOcoOrderReport {

    public final String symbol;
    public final long orderId;
    public final long orderListId;
    public final String clientOrderId;
    public final long transactTime;
    public final BigDecimal price;
    public final BigDecimal origQty;
    public final BigDecimal executedQty;
    public final BigDecimal cumulativeQuoteQty;
    public final OrderStatus status;
    public final TimeInForce timeInForce;
    public final OrderType type;
    public final OrderSide side;

    public final BigDecimal stopPrice;
    public final long workingTime;

    public BinanceNewOcoOrderReport(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("orderListId") long orderListId,
            @JsonProperty("clientOrderId") String clientOrderId,
            @JsonProperty("transactTime") long transactTime,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("origQty") BigDecimal origQty,
            @JsonProperty("executedQty") BigDecimal executedQty,
            @JsonProperty("cumulativeQuoteQty") BigDecimal cumulativeQuoteQty,
            @JsonProperty("status") OrderStatus status,
            @JsonProperty("timeInForce") TimeInForce timeInForce,
            @JsonProperty("type") OrderType type,
            @JsonProperty("side") OrderSide side,
            @JsonProperty("stopPrice") BigDecimal stopPrice,
            @JsonProperty("workingTime") long workingTime) {
        super();
        this.symbol = symbol;
        this.orderId = orderId;
        this.orderListId = orderListId;
        this.clientOrderId = clientOrderId;
        this.transactTime = transactTime;
        this.price = price;
        this.origQty = origQty;
        this.executedQty = executedQty;
        this.cumulativeQuoteQty = cumulativeQuoteQty;
        this.status = status;
        this.timeInForce = timeInForce;
        this.type = type;
        this.side = side;
        this.stopPrice = stopPrice;
        this.workingTime = workingTime;
    }
}
