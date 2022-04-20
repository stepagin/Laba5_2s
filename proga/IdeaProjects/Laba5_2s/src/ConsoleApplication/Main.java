package ConsoleApplication;

import ConsoleApplication.readers.simpleReaders.IntegerReader;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputManager im= new InputManager();
        OutputManager om = new OutputManager();
        IntegerReader a = new IntegerReader(im, om);
        Integer integer = a.read("число типа");
        System.out.println(integer);


    }
}
