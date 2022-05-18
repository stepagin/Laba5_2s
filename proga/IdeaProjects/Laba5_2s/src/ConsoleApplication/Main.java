package ConsoleApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static String read(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        if( args.length > 0 || true) interpreter.readCollectionFromFile("saved_collection");
        interpreter.run();


    }
}
