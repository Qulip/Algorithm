package beakjoon.d220217.q1987;
//https://www.acmicpc.net/problem/1987
//Solved : 22/02/17
import java.util.*;
import java.io.*;

public class Main {
    static int rst;
    static boolean[] chk;
    static char[][] map;
    static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        chk = new boolean[26];
        map = new char[R][C];
        rst = 0;
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        chk[map[0][0]-'A'] = true;
        move(0,0,1);
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
    static void move(int r, int c, int dist){
        rst = rst > dist ? rst : dist;
        for(int i=0; i<4; i++){
            if(r+d[i][0]<0||r+d[i][0]>=map.length||c+d[i][1]<0||c+d[i][1]>= map[0].length) continue;    //배열 없음 안감
            if(!chk[map[r+d[i][0]][c+d[i][1]]-'A']){                                                    //아에 안본 알파벳이면
                chk[map[r+d[i][0]][c+d[i][1]]-'A'] = true;                                              //다음거 봤다
                move(r+d[i][0],c+d[i][1],dist+1);
                chk[map[r+d[i][0]][c+d[i][1]]-'A'] = false;                                             //다 보고왔으니 해제
            }
        }
    }
}
