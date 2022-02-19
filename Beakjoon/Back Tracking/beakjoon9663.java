package beakjoon.d220219.q9663;
//https://www.acmicpc.net/problem/9663
//Solved : 22/02.19

import java.io.*;

public class Main {
    static int rst = 0;
    static int[] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new int[N];

        nQueen(N, 0);

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }

    static void nQueen(int N, int idx){
        if(N==idx){
            rst++;
            return;
        }
        loop:for(int i=0; i<N; i++){
            for(int j=0; j<idx; j++){
                if(i==map[j]-(idx-j)||i==map[j]||i==map[j]+(idx-j)) continue loop;
            }
            map[idx] = i;
            nQueen(N, idx+1);
            map[idx] = 0;
        }
    }
}
