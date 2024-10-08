package io.codeforall.bootcamp.exceptions;

public class NotEnoughPermissionsException extends FileException{

    public NotEnoughPermissionsException() {
        super("Not enough permissions");
    }


}
