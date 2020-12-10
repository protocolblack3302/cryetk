import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NextRound {




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int key = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            list.add(sc.nextInt());
        }

        int counter=0;
        for(int i=0;i< list.size();i++){
            if(list.get(key-1)<=list.get(i)&&list.get(i)>0){
                counter++;
            }
        }
        System.out.println(counter);



    }}
