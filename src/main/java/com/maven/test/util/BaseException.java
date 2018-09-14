package com.maven.test.util;

import com.fasterxml.jackson.databind.ser.Serializers;

public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }
}
