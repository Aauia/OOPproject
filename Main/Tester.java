package Main;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) {
    System.out.println(Data.INSTANCE.managers);
        try {
            (new Managing()).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
