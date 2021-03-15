package others;

import java.util.Scanner;

public class things_tester {
    public static Scanner sc = new Scanner(System.in);

    public static int cost(char[][] arr, int m, int n, int x, int y) {
        int cost = 0;
        for (int i = 1; i <= m; i++) {
            if (n == 1 && arr[i][1] == '.') {
                cost += x;
                arr[i][1] = '*';
                continue;
            }
            for (int j = 1; j <= n; j++) {

                if ((arr[i][j] == '.' && (j + 1 <= n) && arr[i][j + 1] == '.')) {
                    if (2 * x <= y) {
                        cost += 2 * x;
                        arr[i][j] = '*';
                        arr[i][j + 1] = '*';
                    } else {
                        cost += y;
                        arr[i][j] = '*';
                        arr[i][j + 1] = '*';
                    }
                } else if (arr[i][j] == '.') {
                    cost += x;
                    arr[i][j] = '*';
                }
            }

        }

        return cost;
    }

    public static void main(String[] args) {
        int cases = sc.nextInt();
        while (cases != 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();

            char[][] arr = new char[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                String s = sc.nextLine();
                for (int j = 0; j <n; j++) {
                	arr[i+1][j+1]=s.charAt(j);
                }
            }
            System.out.println(cost(arr, m, n, x, y));

            cases--;

        }
    }
}