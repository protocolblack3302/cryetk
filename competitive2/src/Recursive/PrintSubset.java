package Recursive;

import java.util.Scanner;

class PrintSubsets{
    static Scanner sc=new Scanner(System.in);

    public static void printTargetSumSubsets(int[] arr,int idx, String set, int sos, int tar) {
if(idx==arr.length) {
    if (sos == tar) {
        System.out.println(set);
        return;
    }
return;

}
            printTargetSumSubsets(arr,idx+1,set+arr[idx]+" ",sos+arr[idx],tar);
            printTargetSumSubsets(arr,
                    idx+1,set,sos,tar);

    }

    public static void main(String[] args) throws Exception {

        int[] arr = new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        printTargetSumSubsets(arr,0,"",0,sc.nextInt());

    }
}