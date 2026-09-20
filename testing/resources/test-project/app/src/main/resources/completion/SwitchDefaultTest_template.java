package dev.mutwakil.test;

public class Main {

    public void test(int value) {
        switch (value) {
            case 1:
                break;

            @@cursor@@
            default:
                break;
        }
    }

}