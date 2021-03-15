package others;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComboGen {

    public static void readFileInList() {
        String filein = "/Users/protocolblack/Desktop/sites/untitled.txt";
        String fileout="/Users/protocolblack/Desktop/sites/a.txt";
        Path path = Paths.get(filein);


       try (PrintWriter pw= new PrintWriter(new FileWriter(fileout,false))) {

           Files.lines(path).filter(t->t.contains("@")).forEach(pw::println);
        } catch (IOException e) {
e.printStackTrace();
        }

        }

    public static void main(String[] args) {
readFileInList();

    }

}
