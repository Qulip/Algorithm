package swea.d220222.d4_7465;
//Solved : 22/02/22

import java.util.*;
import java.io.*;

public class Solution {
    static int N, M;
    static int[] parentOf, rank;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int rst=0;
            parentOf = new int[N+1];
            rank = new int[N+1];
            for(int i = 1; i <= N; i++) parentOf[i] = i;
            for(int i = 1; i <= M; i++){
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for(int i = 1; i <= N; i++) if(parentOf[i]==i) rst++;
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int find(int x){
        if(parentOf[x] == x) return x;
        return parentOf[x] = find(parentOf[x]);
    }

    static void union(int x, int y){
        int parentOfX = find(x), parentOfY = find(y);
        if(rank[parentOfX] < rank[parentOfY]){
            parentOf[parentOfX] = parentOfY;
            return;
        }
        if(rank[parentOfX] == rank[parentOfY]) rank[parentOfY]++;
        parentOf[parentOfY] = parentOfX;
    }
}
