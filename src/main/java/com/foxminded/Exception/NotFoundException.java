package com.foxminded.Exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Integer id) {
        super("Could not find " + id);
    }
}
