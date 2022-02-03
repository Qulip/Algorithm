import java.io.*; //DP문제에서 수가 급격하게 커질경우 LONG확인!\
//https://www.acmicpc.net/problem/2193

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[][] dp = new long[num+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2; i<=num; i++){
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[num][0]+dp[num][1]);
    }
}
