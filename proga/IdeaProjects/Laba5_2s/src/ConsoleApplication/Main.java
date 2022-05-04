package ConsoleApplication;

import ConsoleApplication.person.Person;
import ConsoleApplication.readers.complexReaders.PersonReader;
import ConsoleApplication.readers.simpleReaders.FloatReader;
import ConsoleApplication.readers.simpleReaders.IntegerReader;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        interpreter.run();
//        File file = new File("src/ConsoleApplication/file.txt");
//        DataInputStream reader = null;
//        try {
//            reader = new DataInputStream(
//                    new BufferedInputStream(
//                            new FileInputStream(file)
//                    )
//            );
//            System.out.println(reader.readLine());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}
