package me.ttting.netty.server.http;

/**
 * Created by titengjiang
 */
public class MultipleRegisterException  extends RuntimeException{
    public MultipleRegisterException() {
        super();
    }

    public MultipleRegisterException(String message) {
        super(message);
    }
}
