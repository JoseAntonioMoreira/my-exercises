package io.codeforall.bootcamp.exceptions;

public class FileNotFoundException extends FileException{

    public FileNotFoundException() {
        super("File not found");
    }

}
