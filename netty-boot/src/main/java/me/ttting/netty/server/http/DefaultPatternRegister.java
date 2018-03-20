package me.ttting.netty.server.http;

import io.netty.handler.codec.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by titengjiang
 */
public class DefaultPatternRegister implements PatternRegister {
    private Map<String, HttpRequestExecutor> urlPatternHandlers= new HashMap<>();

    public void register(String urlPattern, HttpMethod method, HttpRequestExecutor handler) {
        String patternKey = createPatternKey(urlPattern, method);
        synchronized (this) {
            if (urlPatternHandlers.put(patternKey, handler) != null)
                throw new MultipleRegisterException(patternKey + "did register, Please check the HttpRequestHandler config");
        }
    }

    String createPatternKey(String urlPattern, HttpMethod method) {
        return method.name() + "@" + urlPattern;
    }

    public HttpRequestExecutor getRequestHandler(String urlPattern, HttpMethod method) {
        return urlPatternHandlers.get(createPatternKey(urlPattern, method));
    }
}
