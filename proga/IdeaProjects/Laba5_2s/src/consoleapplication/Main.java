package consoleapplication;

import java.io.*;
import consoleapplication.readers.simpleReaders.StringReader;

public class Main {

    public static String read(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
//        InputManager inputManager = new InputManager();
//        OutputManager outputManager = new OutputManager();
//        while (true)
//        System.out.println(new StringReader(inputManager, outputManager, true).setLengthUpperBound(3).read());

        String filepath = System.getenv("lab5_2s_inputFilename");
        Interpreter interpreter = new Interpreter();
        if (filepath != null) interpreter.readCollectionFromFile(filepath);
        interpreter.run();

    }
}
