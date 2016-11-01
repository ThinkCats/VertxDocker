package com.vv;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * Created by wl on 11/1/16.
 */
public class MyVerticle extends AbstractVerticle{
    @Override
    public void start(Future<Void> fut){
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.route().handler(r -> r.response().end("hello!"));
        server.requestHandler(router::accept).listen(8000, result -> {
           if (result.succeeded()){
              fut.complete();
           }else {
               fut.fail(result.cause());
           }
        });
    }
}
