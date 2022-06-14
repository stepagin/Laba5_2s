package consoleapplication;

import java.io.*;
enum ReadMode {console, file}

public class InputManager {
    private BufferedReader reader;
    private ReadMode readMode = ReadMode.console;

    public InputManager() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setInputFile(String filepath) throws IOException {
        File file = new File(filepath);
        this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        readMode = ReadMode.file;
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public boolean hasNext() {
        try {
            if (reader.ready() || readMode == ReadMode.console)
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ready() {
        try {
            return reader.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String readNext(){
        StringBuilder stringBuilder = new StringBuilder();
        char c;
        try {
            while (readMode != ReadMode.file || hasNext()) {
                c = (char) reader.read();
                if (c == '\n') break;
                if (c == '\r') continue;
                if (Character.isWhitespace(c) && stringBuilder.length() != 0) break;
                stringBuilder.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String readAllFile() throws IOException {
        StringBuilder builder = new StringBuilder();
        while (hasNext()) {
            builder.append(reader.readLine() + '\n');
        }
        return builder.toString();
    }


}
