package beakjoon.d220216.q1992;
//https://www.acmicpc.net/problem/1992
//Solved : 22/02/16

import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = tmp.charAt(j)-'0';
            }
        }

        com(N, 0,0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void com(int size, int r, int c){
        //System.out.println(size+" "+r+" "+c);
        if(size==1){
            sb.append(arr[r][c]);
            return;
        }
        if(chkSame(size, r, c)){
            sb.append(arr[r][c]);
            return;
        }
        int[][] points = new int[][]{{r,c},{r,c+size/2},{r+size/2,c},{r+size/2,c+size/2}};
        //System.out.println(sb.toString());
        sb.append("(");
        for(int i=0; i<4; i++) {
            com(size / 2, points[i][0], points[i][1]);
        }
        sb.append(")");
    }

    static boolean chkSame(int size, int r, int c){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(arr[i][j]!=arr[r][c]) return false;
            }
        }
        return true;
    }
}
