package me.ttting.netty.server.http;

import io.netty.handler.codec.http.HttpMethod;

/**
 * Created by titengjiang
 */
public interface PatternRegister {
    void register(String urlPattern, HttpMethod method, HttpRequestExecutor handler);

    HttpRequestExecutor getRequestHandler(String urlPattern, HttpMethod method);
}
