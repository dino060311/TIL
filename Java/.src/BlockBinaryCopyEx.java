import java.io.*;

public class BlockBinaryCopyEx {
    public static void main(String[] args) {
        File src = new File("c:\\Temp\\srcimg.jpg");
        File dest = new File("c:\\Temp\\copyimg.jpg");

        long start = System.currentTimeMillis();
        try {
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);

            byte[] buf = new byte[1024 * 10];
            while (true) {
                int n = fi.read(buf);
                fo.write(buf, 0, n);
                if (n < buf.length)
                    break;
            }
            fi.close();
            fo.close();
            long end = System.currentTimeMillis();
            double seconds = (end - start) / 1000.0;
            System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
            System.out.println("복사 시간은 " + seconds + "초입니다.");
        } catch (IOException e) {
            System.out.println("파일 복사 오류");
        }
    }
}
