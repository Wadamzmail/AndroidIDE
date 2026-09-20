package dev.mutwakil.test;

public class Main {

    public void test(Object lock) {
        @@cursor@@ synchronized (lock) {
        }
    }

}