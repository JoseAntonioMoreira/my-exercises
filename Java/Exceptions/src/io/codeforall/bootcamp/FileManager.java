package io.codeforall.bootcamp;

import io.codeforall.bootcamp.exceptions.FileException;
import io.codeforall.bootcamp.exceptions.NotEnoughPermissionsException;
import io.codeforall.bootcamp.exceptions.NotEnoughSpaceException;

public class FileManager {

    private boolean logged;
    private File[] files;

    public FileManager(int numberOfStorage) {
        logged = false;
        files = new File[numberOfStorage];
    }

    public void login() {
        logged = true;
    }

    public void logout() {
        logged = false;
    }

    public File getFile(String fileName) throws FileException {
        if (logged) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().equals(fileName)) {
                    return files[i];
                }
            }
            throw new io.codeforall.bootcamp.exceptions.FileNotFoundException();
        }
        throw new NotEnoughPermissionsException();
    }

    public void createFile(String fileName) throws FileException {
        if (logged) {
            for (int i = 0; i < files.length; i++) {
                if (files[i] == null) {
                    files[i] = new File(fileName);
                    return;
                }
            }
            throw new NotEnoughSpaceException();
        }
        throw new NotEnoughPermissionsException();
    }
}
