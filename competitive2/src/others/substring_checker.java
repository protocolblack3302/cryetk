package others;

public class substring_checker {
    //RECURSIVE LCS
    // static int m, n;
    //  static int[][] result=new int[6][6];
    static String[][] observe;
    static int[][] result;
// //
//   static int lcs_naive(String x,String y,int n,int m){
//        if(n==0||m==0){
//            return 0;

//        }
//        else if(x.charAt(n-1)==y.charAt(m-1)){
//            return 1+lcs(x,y,n-1,m-1);

//        }
//        else{
//            return Math.max(lcs(x,y,n-1,m),lcs(x,y,n,m-1));
//        }
//    }


      static int count(String a, String b, int m, int n) 
    { 
        // If both first and second string is empty, 
        // or if second string is empty, return 1 
        if ((m == 0 && n == 0) || n == 0) 
            return 1; 
      
        // If only first string is empty and  
        // second string is not empty, return 0 
        if (m == 0) 
            return 0; 
      
        // If last characters are same 
        // Recur for remaining strings by 
        // 1. considering last characters of  
        // both strings 
        // 2. ignoring last character of  
        // first string 
        if (a.charAt(m - 1) == b.charAt(n - 1)) 
            return count(a, b, m - 1, n - 1) + 
                   count(a, b, m - 1, n); 
        else
            // If last characters are different,   
            // ignore last char of first string  
            // and recur for  remaining string 
            return count(a, b, m - 1, n); 
    } 

    public static int lcs(String x,String y,int m,int n){
            result = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;


                }else {
                    result[i][j] = -1;

                }
            }

        }

        return lcs_dp(x,y,m,n);
    }

   static int lcs_dp(String x,String y,int m,int n){
       if(n==0||m==0){
           return 0;

       }

       if(result[m][n]!=-1){
           return result[m][n];
       }
       else if(x.charAt(m-1)==y.charAt(n-1)){
           result[m][n]= 1+lcs_dp(x,y,m-1,n-1);
           return result[m][n];

       }
       else{
           result[m][n]=Math.max(lcs_dp(x,y,m-1,n),lcs_dp(x,y,m,n-1));
           return result[m][n];
       }
   }

 //iterative printing lcs algo
    // static void print_lcs_itr(String[][] observe, String x, int m, int n) {
    //     if (m == 0 || n == 0) {
    //         return;
    //     }
    //     if (observe[m][n].equals("go_diagonal")) {

    //         print_lcs_itr(observe, x, m - 1, n - 1);
    //         System.out.println(x.charAt(m-1));

    //     } else if (observe[m][n].equals("go_Up")) {
    //         print_lcs_itr(observe, x, m - 1, n);

    //     } else {
    //         print_lcs_itr(observe, x, m, n - 1);
    //     }

    // }

    // static int lcs_itr(String x, String y) {
    //     m = x.length();
    //     n = y.length();
    //     observe = new String[m + 1][n + 1];
    //     result = new int[m + 1][n + 1];
    //     for (int i = 0; i <= m; i++) {
    //         for (int j = 0; j <= n; j++) {
    //             if (i == 0 || j == 0) {
    //                 result[i][j] = 0;


    //             }else {
    //                 result[i][j] = -1;

    //             }
    //         }

    //     }

    //         for (int i = 1; i <= m; i++) { //fill rows leaving index 0
    //             for (int j = 1; j <= n; j++) { //fill column leaving index 0

    //                 if (x.charAt(i - 1) == y.charAt(j - 1)) { //string starts from 0 to length-1
    //                     observe[i][j] = "go_diagonal";
    //                     result[i][j] = 1 + result[i - 1][j - 1];

    //                 } else if (result[i - 1][j] >= result[i][j - 1]) {
    //                     observe[i][j] = "go_up";
    //                     result[i][j] = result[i - 1][j];


    //                 } else {
    //                     observe[i][j] = "go_back";
    //                     result[i][j] = result[i][j - 1];

    //                 }

    //             }
    //         }

    //     print_lcs_itr(observe, x, m, n);
    //     return result[m][n];
    // }


}
