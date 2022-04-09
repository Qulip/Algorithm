//https://www.acmicpc.net/problem/14890
//Solved : 22/04/08

import java.util.*;
import java.io.*;

class Main{
    static int N, X, rst;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        rst = 0;
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            chkR(i);
            chkC(i);
        }

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
    static void chkR(int c){
        int idx = 1;
        int height = map[0][c];
        boolean[] used = new boolean[N];
        while (idx<N){
            int diff = height-map[idx][c];
            if(diff>1||diff<-1) return;
            else if(diff==1){
                for(int i=1; i<X; i++){
                    if(idx+i>=N||map[idx][c]!=map[idx+i][c]) return;
                }
                for(int i=0; i<X; i++){
                    used[idx+i] = true;
                }
            }else if(diff==-1){
                for(int i=1; i<=X; i++){
                    if(idx-i<0||map[idx][c]+diff!=map[idx-i][c]||used[idx-i]) return;
                }
            }
            height = map[idx][c];
            idx++;
        }
        rst++;
    }

    static void chkC(int r){
        int idx = 1;
        int height = map[r][0];
        boolean[] used = new boolean[N];
        while (idx<N){
            int diff = height-map[r][idx];
            if(diff>1||diff<-1) return;
            else if(diff==1){
                for(int i=1; i<X; i++){
                    if(idx+i>=N||map[r][idx]!=map[r][idx+i]) return;
                }
                for(int i=0; i<X; i++){
                    used[idx+i] = true;
                }
            }else if(diff==-1){
                for(int i=1; i<=X; i++){
                    if(idx-i<0||map[r][idx]+diff!=map[r][idx-i]||used[idx-i]) return;
                }
            }
            height = map[r][idx];
            idx++;
        }
        rst++;
    }
}