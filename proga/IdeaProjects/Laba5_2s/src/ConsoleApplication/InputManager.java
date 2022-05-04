package ConsoleApplication;

import java.io.*;

enum ReadMode { console, file }

public class InputManager {
    private DataInputStream reader;
    private ReadMode readMode = ReadMode.console;

    public InputManager() {
        reader = new DataInputStream(new BufferedInputStream(System.in));
    }

    public void setInputFile(String filepath) throws IOException {
        File file = new File(filepath);
        this.reader = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );


        readMode = ReadMode.file;
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public boolean hasNext() {
        try {
            if (reader.available() > 0 || readMode == ReadMode.console)
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String readNext(){
//        StringBuilder stringBuilder = new StringBuilder();
        try {
//            while (true) {
//                if (readMode == ReadMode.file && !hasNext()) break;
//                char c = reader.readChar();
//                if (c == '\r') continue;
//                if (c == '\n') break;
//                if (stringBuilder.length() != 0 && Character.isWhitespace(c)) break;
//                stringBuilder.append(c);
//            }
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return stringBuilder.toString();
        return null;
    }

    public String readAllFile() throws IOException {
        StringBuilder builder = new StringBuilder();
        while (hasNext()) {
            char c = reader.readChar();
            builder.append(c);
        }
        return builder.toString();
    }
}
