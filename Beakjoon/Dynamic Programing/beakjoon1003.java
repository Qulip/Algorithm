import java.io.*;
//https://www.acmicpc.net/problem/1003

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] times = new int[n + 1][2];
            if(n==0){
                sb.append("1 0\n");
            } else if(n==1){
                sb.append("0 1\n");
            }else {
                times[0][0]=1;
                times[1][1]=1;
                for (int i = 2; i <= n; i++) {
                    times[i][1] = times[i - 1][1] + times[i - 2][1];
                    times[i][0] = times[i - 1][0] + times[i - 2][0];
                }
                sb.append(times[n][0]+" "+times[n][1] + "\n");
            }
        }
        System.out.println(sb);
    }
}
/*
3
0
1
3

 */