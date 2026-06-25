import java.io.*;
import java.util.Scanner;

public class BufferedIOEx {
    public static void main(String[] args) {
        FileReader fin = null;
        Scanner scanner = new Scanner(System.in);
        int c;
        try {
            fin = new FileReader("c:\\Temp\\test2.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while ((c = fin.read()) != -1) {
                out.write(c);
            }

            scanner.nextLine();
            out.flush();
            fin.close();
            out.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
