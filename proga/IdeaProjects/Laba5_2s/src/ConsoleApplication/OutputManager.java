package ConsoleApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputManager {
    private DataOutputStream writer;

    public OutputManager() {
        writer = new DataOutputStream(new BufferedOutputStream(System.out));
    }

    public  void setOutputFile(String path) throws IOException {
        File file = new File(path);
        writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }

    public void write(String s){
        try {
            byte[] buffer = s.getBytes(StandardCharsets.UTF_8);
            writer.write(buffer, 0, buffer.length);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLn(String s){
        write(s + "\n");
    }
}
