package swea3282;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] v = new int[n];
            int[] c = new int[n];
            int[] best = new int[k+1];
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<n; i++){
                for(int j=k; j>=v[i]; j--){
                    best[j] = (best[j]<c[i]+best[j-v[i]] ? c[i]+best[j-v[i]]:best[j]);
                    //best[j] = Math.max(best[j], c[i]+best[j-v[i]]);
                }
            }
            sb.append("#"+tc+" "+best[k]+"\n");
        }
        System.out.print(sb);
    }
}
/*
1
4 5
1 2
3 2
4 4
2 3

 */