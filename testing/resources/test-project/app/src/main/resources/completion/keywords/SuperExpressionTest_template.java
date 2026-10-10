package dev.mutwakil.test;

class Base {
}

public class Main extends Base {

    String value() {
        return @@cursor@@ super.toString();
    }

}