package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BinanceNewOcoOrderList {

    /** Desired response type for BinanceNewOcoOrder. */
    public enum NewOrderResponseType {
        ACK,
        RESULT,
        FULL
    }

    public final long orderListId;
    public final String contingencyType;
    public final String listStatusType;
    public final String listOrderStatus;
    public final String listClientOrderId;
    public final long transactionTime;
    public final String symbol;

    public final List<BinanceNewOcoOrder> orders;
    public final List<BinanceNewOcoOrderReport> orderReports;

    public BinanceNewOcoOrderList(
            @JsonProperty("orderListId") long orderListId,
            @JsonProperty("contingencyType") String contingencyType,
            @JsonProperty("listStatusType") String listStatusType,
            @JsonProperty("listOrderStatus") String listOrderStatus,
            @JsonProperty("listClientOrderId") String listClientOrderId,
            @JsonProperty("transactionTime") long transactionTime,
            @JsonProperty("symbol") String symbol,
            @JsonProperty("orders") List<BinanceNewOcoOrder> orders,
            @JsonProperty("orderReports") List<BinanceNewOcoOrderReport> orderReports) {
        super();
        this.orderListId = orderListId;
        this.contingencyType = contingencyType;
        this.listStatusType = listStatusType;
        this.listOrderStatus = listOrderStatus;
        this.listClientOrderId = listClientOrderId;
        this.transactionTime = transactionTime;
        this.symbol = symbol;
        this.orders = orders;
        this.orderReports = orderReports;
    }
}
