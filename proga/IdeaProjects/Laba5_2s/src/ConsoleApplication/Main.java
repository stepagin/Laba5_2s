package ConsoleApplication;

import java.io.*;
import java.util.*;

public class Main {
    public static void f() {
        f(false);
    }

    public static void f(boolean ask){
        if (ask){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) throws IOException {
        f();
        f(true);
    }
}
