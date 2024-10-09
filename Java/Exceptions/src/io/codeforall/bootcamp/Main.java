package io.codeforall.bootcamp;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager(1);

        fileManager.login();

        try {
            fileManager.createFile("hello");
            fileManager.getFile("hello");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
