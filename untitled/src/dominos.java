import java.util.Scanner;

public class dominos {



    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
       int m= sc.nextInt();
       int n=sc.nextInt();
       if(m%2==0||n%2==0){
           System.out.println(m*n/2);
       }else{
           System.out.println((m-1)*n/2 +(n-1)/2);
       }
    }
}
