package swea8104;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] grades = new int[k];
            int people = n*k;
            for(int i=0; i<people; i++) {
                int left = i % k;
                int qout = i / k;
                if (qout % 2 == 1) {
                    grades[k-left-1] = grades[k-left-1] + i + 1;
                } else {
                    grades[left] = grades[left] + i + 1;
                }
            }
            sb.append("#"+tc+" ");
            for(int i=0; i<k; i++){
                sb.append(grades[i]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
