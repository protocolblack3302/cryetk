package others;

import java.util.Scanner;

public class PepCodeRotations {


        public static void main(String []args){

            Scanner sc=new Scanner(System.in);

            int number = sc.nextInt();
            int rotations =sc.nextInt();


            int temp=number;
            int digits=0;
            while(temp>0){
                temp=temp/10;
                digits++;
            }

            rotations=rotations%digits;
            if(rotations<0){
                rotations=rotations+digits;
            }


            if(rotations>0){
                int old_left=number/(int)Math.pow(10,rotations);
                int old_right=number%(int)Math.pow(10,rotations);
                int new_number = old_right*(int)Math.pow(10,digits-rotations)+
                        old_left;
                System.out.println(new_number);

            }


        }
    }

