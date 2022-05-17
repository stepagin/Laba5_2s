package ConsoleApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static String read(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        interpreter.run();

//        try {
//            DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("testout.txt")));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println(reader.ready());
//            for(int i = 0; i < 3; ++i){
//                String text = Main.read(reader) + '\n';
//                byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
//                writer.write(buffer, 0, buffer.length);
//            }
//            writer.flush();
//            System.out.println(reader.ready());
//            System.out.println(reader.read());
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());;
//        }
    }
}
