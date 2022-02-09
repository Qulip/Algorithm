package swea.d220209.d4_1210;
//Solved : 22/02/09

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new FileReader("res/swea/input_d4_1210.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] arr;
        for(int T =1; T<=10; T++){
            arr = new int[100][100];
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int nowR=100, nowC=100;
            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j]==2){
                        nowR=i;
                        nowC=j;
                    }
                }
            }

            while(nowR>0){
                //System.out.println(nowR+" "+nowC);
                nowR--;
                boolean chk = false;
                if(nowC!=0){
                    while(nowC>0){
                        if(arr[nowR][nowC-1]==1) {
                            chk = true;
                            nowC--;
                        }else break;
                    }
                }
                if(!chk&&nowC<100){
                    while(nowC<99){
                        if(arr[nowR][nowC+1]==1){
                            nowC++;
                        }else break;
                    }
                }
            }
            sb.append("#").append(T).append(" ").append(nowC).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
