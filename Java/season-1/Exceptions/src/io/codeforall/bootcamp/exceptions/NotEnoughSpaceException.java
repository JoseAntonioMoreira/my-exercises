package io.codeforall.bootcamp.exceptions;

public class NotEnoughSpaceException extends FileException{

    public NotEnoughSpaceException() {
        super("Not enough space");
    }

}
