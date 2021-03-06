package io.contek.invoker.bitmex.api.rest.market;

import io.contek.invoker.bitmex.api.common._MarketStats;
import io.contek.invoker.bitmex.api.rest.market.GetStats.Response;
import io.contek.invoker.commons.api.actor.IActor;
import io.contek.invoker.commons.api.rest.RestContext;
import io.contek.invoker.commons.api.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;

@NotThreadSafe
public final class GetStats extends MarketRestRequest<Response> {

  GetStats(IActor actor, RestContext context) {
    super(actor, context);
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v1/stats";
  }

  @Override
  protected RestParams getParams() {
    return RestParams.empty();
  }

  @NotThreadSafe
  public static final class Response extends ArrayList<_MarketStats> {}
}
