import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int n,l,rst;
    static int[] kcal, grade;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            kcal = new int[n];
            grade = new int[n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                grade[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());
            }
            rst = 0;
            dfs(0,0, 0);
            sb.append("#"+tc+" "+rst+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(int now_kcal,int now_grade, int depth){
        if(now_kcal > l){
            return;
        }
        if(depth == n){
            rst = Math.max(rst, now_grade);
            return;
        }
        dfs(now_kcal+kcal[depth], now_grade+grade[depth], depth+1);
        dfs(now_kcal, now_grade, depth+1);
    }
}
/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400

 */
