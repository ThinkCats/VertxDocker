package com.vv;

import com.vv.util.ResponseUtil;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Created by wl on 11/1/16.
 */
public class MyVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> fut) {
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.route("/").handler(r -> r.response().end("index!"));
        router.route("/hello").produces("application/json").handler(r -> {
            Model model = new Model("hello","world");
            ResponseUtil.json(r.response()).end(Json.encode(model));
        });
        server.requestHandler(router::accept).listen(8000, result -> {
            if (result.succeeded()) {
                fut.complete();
            } else {
                fut.fail(result.cause());
            }
        });
    }
}

class Model {
    private String name;
    private String msg;

    public Model(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}