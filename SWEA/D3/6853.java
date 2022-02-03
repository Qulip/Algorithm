package swea6853;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int[] x = new int[2];
            int[] y = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[0] = Integer.parseInt(st.nextToken());
            y[0] = Integer.parseInt(st.nextToken());
            x[1] = Integer.parseInt(st.nextToken());
            y[1] = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            int[] rst = new int[3];
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int chk_x = Integer.parseInt(st.nextToken());
                int chk_y = Integer.parseInt(st.nextToken());

                if(chk_x>x[0]&&chk_x<x[1]&&chk_y>y[0]&&chk_y<y[1]){
                    rst[0]++;
                } else if(chk_x<x[0]||chk_x>x[1]||chk_y<y[0]||chk_y>y[1]){
                    rst[2]++;
                } else {
                    rst[1]++;
                }
            }
            sb.append("#"+tc+" "+rst[0]+" "+rst[1]+" "+rst[2]+"\n");
        }
        System.out.print(sb);
    }
}
/*
1
0 0 2 2
4
-1 -1
0 0
1 1
2 2

 */