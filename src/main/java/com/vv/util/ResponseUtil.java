package com.vv.util;

import io.vertx.core.http.HttpServerResponse;

/**
 * Created by wl on 11/1/16.
 */
public class ResponseUtil {
    public static HttpServerResponse json(HttpServerResponse response){
        response.putHeader("content-type","application/json");
        return response;
    }
}
