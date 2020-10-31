import java.util.Scanner;

public class beautiful_maxtrix {


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=0,b=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(sc.nextInt()!=0){
                    a=i;
                    b=j;
                }

            }

        }
        System.out.println(Math.abs(a-2)+Math.abs(b-2));
    }
}
