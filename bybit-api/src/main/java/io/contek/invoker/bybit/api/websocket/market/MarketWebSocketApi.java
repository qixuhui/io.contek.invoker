package io.contek.invoker.bybit.api.websocket.market;

import io.contek.invoker.bybit.api.websocket.WebSocketApi;
import io.contek.invoker.commons.api.actor.IActor;
import io.contek.invoker.commons.api.websocket.WebSocketContext;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class MarketWebSocketApi extends WebSocketApi {

  private final Map<String, OrderBook25Channel> orderBook25Channels = new HashMap<>();
  private final Map<String, OrderBook200Channel> orderBook200Channels = new HashMap<>();
  private final Map<String, TradeChannel> tradeChannels = new HashMap<>();

  public MarketWebSocketApi(IActor actor, WebSocketContext context) {
    super(actor, context);
  }

  public OrderBook25Channel getOrderBook25Channel(String symbol) {
    synchronized (orderBook25Channels) {
      return orderBook25Channels.computeIfAbsent(
          symbol,
          k -> {
            OrderBook25Channel result = new OrderBook25Channel(k);
            attach(result);
            return result;
          });
    }
  }

  public OrderBook200Channel getOrderBook200Channel(String symbol) {
    synchronized (orderBook200Channels) {
      return orderBook200Channels.computeIfAbsent(
          symbol,
          k -> {
            OrderBook200Channel result = new OrderBook200Channel(k);
            attach(result);
            return result;
          });
    }
  }

  public TradeChannel getTradeChannel(String symbol) {
    synchronized (tradeChannels) {
      return tradeChannels.computeIfAbsent(
          symbol,
          k -> {
            TradeChannel result = new TradeChannel(k);
            attach(result);
            return result;
          });
    }
  }
}
