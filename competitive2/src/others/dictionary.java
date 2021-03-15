package others;

import java.util.Scanner;


public class dictionary {






        public static void main(String[] args){


            Scanner sc=new Scanner(System.in);
            String a=sc.nextLine().toLowerCase();
            String b=sc.nextLine().toLowerCase();
            int counter=0;
            for(int i=0;i<a.length();i++){
               int x=a.charAt(i);

               int y=b.charAt(i);

               if(y-x!=0){
                   counter=counter+(x-y);
                   break;
               }


            }
            if(counter<0){
                System.out.println(-1);
            }else if(counter>0){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }


