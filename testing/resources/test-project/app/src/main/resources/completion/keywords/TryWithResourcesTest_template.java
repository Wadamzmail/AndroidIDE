package dev.mutwakil.test;

public class Main {

    public void test() {
        try (@@cursor@@ AutoCloseable resource = null) {
        } catch (Exception e) {
        }
    }

}