package io.github.gefangshuai.exception;

/**
 * model 持久化异常
 * Created by gefangshuai on 2015/11/10.
 */
public class ModelPersistentException extends RuntimeException{

    public ModelPersistentException(String message) {
        super(message);
    }
}
