//https://www.acmicpc.net/problem/17825
//Solved : 22/04/08

import java.util.*;
import java.io.*;

class Main{
    static int[][] player = new int[4][2];
    static int[] dice = new int[10];
    static int[][] map = {{0,13,16,19,25,30,35,40},{0,22,24,25,30,35,40},{0,28,27,26,25,30,35,40}};
    static int rst = 0;
    static boolean[] same = new boolean[2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<10; i++) dice[i] = Integer.parseInt(st.nextToken());

        DFS(0,0);

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }

    static void DFS(int turn, int score){
        rst = rst > score ? rst : score;
        if(turn==10){
            return;
        }
        for(int i=0; i<4; i++){
            if(player[i][0]==-1) continue;
            boolean flag = true;
            for(int j=0; j<i; j++){
                if(player[i][0]==player[j][0]){
                    flag = false;
                    break;
                }
            }
            if(!flag) return;

            int[][] tmp = new int[4][2];
            for(int z=0; z<4; z++) tmp[z] = player[z].clone();

            if(player[i][1]!=0 || (player[i][1]==0&&player[i][0]==5) || player[i][0]==10 || player[i][0]==15){
                if(player[i][1]!=0){
                    int next = player[i][0] + dice[turn];
                    if(next>=map[player[i][1]-1].length){
                        player[i][0] = -1;
                        player[i][1] = 0;
                        DFS(turn+1, score);
                        for(int z=0; z<4; z++) player[z] = tmp[z].clone();
                    }
                    else {
                        for (int k = 0; k < 4; k++) {
                            if (player[i][1] == player[k][1] && player[i][0] == next) {
                                flag = false;
                                break;
                            }
                        }
                        boolean ch25 = false;
                        boolean ch40 = false;
                        if((player[i][1]==1&&next==4) || (player[i][1]==2&&next==3) || (player[i][1]==3&&next==5)){
                            if(same[0]) flag = false;
                            else{
                                ch25 = true;
                                same[0] = true;
                            }
                        }
                        if((player[i][1]==1&&next==7) || (player[i][1]==2&&next==6) || (player[i][1]==3&&next==7)){
                            if(same[1]) flag = false;
                            else{
                                ch40 = true;
                                same[1] = true;
                            }
                        }
                        if (flag) {
                            player[i][0] = next;
                            DFS(turn + 1, score+map[player[i][1]-1][next]);
                            for (int z = 0; z < 4; z++) player[z] = tmp[z].clone();
                        }
                        if(ch25) same[0] = false;
                        if(ch40) same[1] = false;
                    }
                } else {
                    int next = dice[turn];
                    int num = player[i][0]/5;
                    for(int k=0; k<4; k++){
                        if(player[i][1]==num && player[i][0]==next){
                            flag = false;
                            break;
                        }
                    }
                    boolean ch25 = false;
                    if((num==1&&next==4) || (num==2&&next==3) || (num==3&&next==5)){
                        if(same[0]) flag = false;
                        else{
                            ch25 = true;
                            same[0] = true;
                        }
                    }
                    if(flag) {
                        player[i][0] = next;
                        player[i][1] = num;
                        DFS(turn+1, score+map[num-1][next]);
                        for(int z=0; z<4; z++) player[z] = tmp[z].clone();
                    }
                    if(ch25) same[0] = false;
                }
            } else {                                                                //겉을 도는경우
                int next = player[i][0] + dice[turn];
                if(next>20){
                    player[i][0] = -1;
                    DFS(turn+1, score);
                    for(int z=0; z<4; z++) player[z] = tmp[z].clone();
                    continue;
                }
                for(int k=0; k<4; k++){
                    if(player[i][1]==0 && player[i][0]==next){
                        flag = false;
                        break;
                    }
                }
                if(next==20&&same[1]) flag=false;
                if(flag) {
                    player[i][0] = next;
                    DFS(turn+1, score+next*2);
                    for(int z=0; z<4; z++) player[z] = tmp[z].clone();
                }
            }
        }
    }
}
