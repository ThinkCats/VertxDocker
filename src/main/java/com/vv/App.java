package com.vv;

import io.vertx.core.Vertx;

/**
 * Created by wl on 11/1/16.
 */
public class App {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MyVerticle.class.getName());
    }
}
