//Write a program non-recursive and recursive program to calculate Fibonacci numbers and analyze their
//time and space complexity.

import java.util.*;

public class daa1 {
    public static int recursivecnt;
    public static int iterativecnt;
    public static int DPcnt;

    public static int recursive(int n){
        recursivecnt++;
        if(n<=1){
            return n;
        }
        return recursive(n-1)+recursive(n-2);
    }

    public static void iterative(int n){
        int a = 0,b = 1, c= 0;
        if(n > 0){
            System.out.print(a+" ");
        }
        if(n > 1){
            System.out.print(b+" ");
        }
        for(int i=2;i<n;i++){
            iterativecnt++;
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static int FibDP(int n,int[] dp){
        if (dp[n] != -1) return dp[n];

        DPcnt++;
        if (n <= 1) {
            return dp[n] = n;
        }
        return dp[n] = FibDP(n - 1, dp) + FibDP(n - 2, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        System.out.print("Recursive Fibonacci series: ");
        for(int i=0;i<n;i++){
            System.out.print(recursive(i)+" ");
        }
        System.out.println();
        System.out.println("Recursive step count: "+recursivecnt);

        System.out.print("Iterarive Fibonacci series: ");
        iterative(n);
        System.out.println("Iterative step count: "+iterativecnt);

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.print("DP Fibonacci series: ");
        for(int i=0;i<n;i++){
            System.out.print(FibDP(i,dp)+" ");
        }
        System.out.println();
        System.out.println("DP cnt: "+DPcnt);

        sc.close();
    }
}
