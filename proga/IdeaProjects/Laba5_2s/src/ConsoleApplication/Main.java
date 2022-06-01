package ConsoleApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {

    public static String read(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
        String filepath = System.getenv("lab5_2s_inputFilename");
        Interpreter interpreter = new Interpreter();
//        interpreter.run();
        if( filepath != null ) interpreter.readCollectionFromFile(filepath);
        interpreter.run();

    }
}
