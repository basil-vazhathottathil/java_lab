package basil_vazhathottathil;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileException {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("input.txt");
            fw = new FileWriter("output.txt");

            char[] data = new char[100];
            int bytes = fr.read(data);

            fw.write(data, 0, bytes);
            System.out.println("Data entered");
            
            fw.flush();
            fr.close();
            fw.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}