//Problem: https://codeforces.com/problemset/problem/166/E

import java.util.Scanner;

public class Main
{
	
	static final int mod = 1000000007;
    static final int N = 10000002;
    static int [][]dp = new int[2][N];
    public static void main(String[] args) {
        int ans = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[1][0] = 1;
        for (int steps = 1; steps < N; steps++) {
            dp[1][steps] = (3*dp[0][steps-1])%mod;
            dp[0][steps] = (2*dp[0][steps-1] + dp[1][steps-1])%mod;
        }

        System.out.println(dp[1][n]);
        
	}
}