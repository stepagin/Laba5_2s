package ConsoleApplication;

import java.io.*;

public class OutputManager {
    private BufferedWriter writer;

    public OutputManager() {
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public  void setOutputFile(String path) throws IOException {
        File file = new File(path);
        writer = new BufferedWriter(new FileWriter(file));
    }

    public void write(String s){
        try {
            writer.write(s);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLn(String s){
        write(s + "\n");
    }
}
