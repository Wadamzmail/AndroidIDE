package dev.mutwakil.test;

public class Main {

    public void test() {
        Exception exception = new Exception();

        @@cursor@@ throw exception;
    }

}