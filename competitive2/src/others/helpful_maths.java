package others;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class helpful_maths {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String calc=sc.nextLine();
        String[] arr=calc.split("[+]");
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]).append("+");
        }
        System.out.println(sb.substring(0,sb.length()-1));




    }
}
