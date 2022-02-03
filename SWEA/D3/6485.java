package swea6485;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int n = Integer.parseInt(br.readLine());
            int[][] bus = new int[n][2];
            for(int i = 0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                bus[i][0] = Integer.parseInt(st.nextToken());
                bus[i][1] = Integer.parseInt(st.nextToken());
            }
            int p = Integer.parseInt(br.readLine());
            int[] c = new int[p];
            int[] rst = new int[p];
            for(int i=0; i<p; i++){
                c[i] = Integer.parseInt(br.readLine());
            }
            for(int i=0; i<n; i++){
                for(int j = 0; j<p; j++){
                    if(bus[i][0]<=c[j]&&c[j]<=bus[i][1]){
                        rst[j]++;
                    }
                }
            }
            sb.append("#"+tc+" ");
            for(int i=0; i<p; i++){
                sb.append(rst[i]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
1
2
1 3
2 5
5
1
2
3
4
5

 */