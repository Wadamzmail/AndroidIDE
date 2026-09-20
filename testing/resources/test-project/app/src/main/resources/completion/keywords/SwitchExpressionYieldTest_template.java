package dev.mutwakil.test;

public class Main {

    public int test(int value) {
        return switch (value) {
            case 1 -> {
                @@cursor@@
                yield 1;
            }
            default -> 0;
        };
    }

}