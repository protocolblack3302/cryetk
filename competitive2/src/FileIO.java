import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileIO {
    final static int bufferSize = 1024;

    public static void ReadFile(File file) {

        for (int i = 4; i <= 64; i *= 2) {
            byte[] buffer = new byte[bufferSize * i];
            try (InputStream inputStream = new FileInputStream(file);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath().replace(".mp4", "") + "2.mp4"));
            ) {

                long startTime = System.currentTimeMillis();
                int length;
                while((length=bufferedInputStream.read(buffer,0,1024*i))>0){
                    bufferedOutputStream.write(buffer, 0, bufferSize * i);
                }
                bufferedOutputStream.flush();
                long finishTime = System.currentTimeMillis();
                long diffTime = finishTime - startTime;
                System.out.println(Files.deleteIfExists(Path.of(file.getAbsolutePath().replace(".mp4", "") + "2.mp4")));
                System.out.println("Time for " + i + " byte buffer is " + diffTime + " milisecond");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        File file = new File(sc.nextLine());
        ReadFile(file);


    }

}
