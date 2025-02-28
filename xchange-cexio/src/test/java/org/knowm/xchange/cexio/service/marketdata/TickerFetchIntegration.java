package org.knowm.xchange.cexio.service.marketdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.BeforeClass;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.cexio.CexIOExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.instrument.Instrument;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.marketdata.params.CurrencyPairsParam;
import org.knowm.xchange.service.marketdata.params.InstrumentsParams;

/** @author timmolter */
public class TickerFetchIntegration {

  private static Exchange exchange;

  @BeforeClass
  public static void setup() {
    exchange = ExchangeFactory.INSTANCE.createExchange(CexIOExchange.class);
  }

  @Test
  public void tickerFetchTest() throws Exception {
    MarketDataService marketDataService = exchange.getMarketDataService();
    Ticker ticker = marketDataService.getTicker(new CurrencyPair("BTC", "USD"));
    System.out.println(ticker.toString());
    assertThat(ticker).isNotNull();
  }

  @Test
  public void tickerFetchAllTest() throws Exception {
    Set<Instrument> allCurrencyPairs = exchange.getExchangeMetaData().getInstruments().keySet();

    List<Ticker> tickers =
        exchange.getMarketDataService().getTickers((InstrumentsParams) () -> allCurrencyPairs);
    Set<Instrument> currencyPairsInTickers =
        tickers.stream().map(Ticker::getCurrencyPair).collect(Collectors.toSet());

    assertEquals(
        "The number of currency pairs should be the same as the requested number of currency pairs",
        allCurrencyPairs.size(),
        currencyPairsInTickers.size());
    assertTrue(
        "Returned currency pairs should be the same as the requested",
        currencyPairsInTickers.containsAll(allCurrencyPairs));
  }

  @Test
  public void tickerFetchSomeTest() throws Exception {
    Set<CurrencyPair> someCurrencyPairs = new HashSet<>();
    someCurrencyPairs.add(new CurrencyPair("BTC", "USD"));
    someCurrencyPairs.add(new CurrencyPair("BTC", "EUR"));

    List<Ticker> tickers =
        exchange.getMarketDataService().getTickers((CurrencyPairsParam) () -> someCurrencyPairs);
    Set<CurrencyPair> currencyPairsInTickers =
        tickers.stream().map(Ticker::getCurrencyPair).collect(Collectors.toSet());

    assertEquals(
        "The number of currency pairs should be the same as the requested number of currency pairs",
        someCurrencyPairs.size(),
        currencyPairsInTickers.size());
    assertTrue(
        "Returned currency pairs should be the same as the requested",
        currencyPairsInTickers.containsAll(someCurrencyPairs));
  }

  @Test
  public void tickerFetchNoneTest() throws Exception {
    List<Ticker> tickers =
        exchange.getMarketDataService().getTickers((CurrencyPairsParam) Collections::emptySet);
    Set<CurrencyPair> currencyPairsInTickers =
        tickers.stream().map(Ticker::getCurrencyPair).collect(Collectors.toSet());

    assertEquals(
        "The number of currency pairs should be the same as the requested number of currency pairs",
        0,
        currencyPairsInTickers.size());
  }
}
