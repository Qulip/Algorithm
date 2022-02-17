package beakjoon.d220215.q15683;
//https://www.acmicpc.net/problem/15683
//Solved : 22/02/15

/*
1. CCTV의 위치, 종류 찾기
2. 모든 CCTV의 방향을 하나씩 변경해가며 최소 사각지대 찾기
3. 1,3,4번 CCTV는 4방향 다 검색, 2번 CCTV는 상하, 좌우 2방향만 검색, 5번 CCTV는 십자방향 검색
 */

import java.util.*;
import java.io.*;

public class Main {
    static int N,M;                         //가로, 세로
    static int[][] office;                  //지도 배열
    static int rst = Integer.MAX_VALUE;     //결과 값
    static int[][] cctv;                    //cctv의 위치 배열
    static int cctv_num;                    //총 cctv 숫자
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());       //가로 입력
        M = Integer.parseInt(st.nextToken());       //세로 입력
        cctv = new int[8][2];                       //cctv 배열 선언
        cctv_num = 0;                               //cctv 갯수 확인
        office = new int[N][M];                     //지도 배열 선언

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j]>0&&office[i][j]<6){             //만약 cctv인 경우 cctv 배열에 저장
                    cctv[cctv_num][0] = i;
                    cctv[cctv_num][1] = j;
                    cctv_num++;
                }
            }
        }

        blind_spot(0);

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }

    static void blind_spot(int idx){
        if(idx==cctv_num){
            int blind=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(office[i][j]==0) blind++;
                }
            }
            rst = rst < blind ? rst : blind;
            return;
        }
        int cctv_num = office[cctv[idx][0]][cctv[idx][1]];

        if(cctv_num==1||cctv_num==3||cctv_num==4){
            for(int i=1; i<=4; i++){                                        //CCTV종류가 1,3,4인 경우(상,우,하,좌)
                cctv_type(cctv[idx][0],cctv[idx][1], cctv_num, i,-1);
                blind_spot(idx+1);
                cctv_type(cctv[idx][0],cctv[idx][1], cctv_num, i,1);
            }
        }else if(cctv_num==2){                                              //CCTV종류가 2인 경우(상하, 좌우)
            for(int i=1; i<=2; i++){
                cctv_type(cctv[idx][0],cctv[idx][1], cctv_num, i,-1);
                blind_spot(idx+1);
                cctv_type(cctv[idx][0],cctv[idx][1], cctv_num, i,1);
            }
        }else{                                                              //CCTV종류가 5인 경우
            cctv_type(cctv[idx][0],cctv[idx][1], cctv_num, 1,-1);
            blind_spot(idx+1);
            cctv_type(cctv[idx][0],cctv[idx][1], cctv_num, 1,1);
        }
    }

    static void look(int r, int c, int dist, int x){       //현재 위치에서 방향별로 최대로 직진하며 감시 확인
        if(dist == 1){                                      //상(1)
            for(int i=r-1; i>=0; i--){
                if(office[i][c]==6) break;
                else if(office[i][c]<=0) office[i][c]+=x;   //cctv가 보면 -1, 안보게 되면 +1
            }
        }else if(dist == 2){                              //우(2)
            for(int i=c+1; i<M; i++){
                if(office[r][i]==6) break;
                else if(office[r][i]<=0) office[r][i]+=x;   //cctv가 보면 -1, 안보게 되면 +1
            }
        }else if(dist == 3){                              //하(3)
            for(int i=r+1; i<N; i++){
                if(office[i][c]==6) break;
                else if(office[i][c]<=0) office[i][c]+=x;   //cctv가 보면 -1, 안보게 되면 +1
            }
        }else{                                              //좌(4)
            for(int i=c-1; i>=0; i--){
                if(office[r][i]==6) break;
                else if(office[r][i]<=0) office[r][i]+=x;   //cctv가 보면 -1, 안보게 되면 +1
            }
        }
    }

    static void cctv_type(int r, int c, int type, int dist, int x){
        //CCTV종류에 따른 방향으로 모두 보고 있는지 체크
        if(type==1){                            //1번 cctv
            look(r,c,dist,x);
        }else if(type==2){                      //2번 cctv
            look(r,c,dist,x);
            if(dist+2>4) look(r,c,dist-2,x);
            else look(r,c,dist+2,x);
        }else if(type==3){                      //3번 cctv
            look(r,c,dist,x);
            if(dist+1>4) look(r,c,1,x);
            else look(r,c,dist+1,x);
        } else if(type==4){                      //4번 cctv
            look(r,c,dist,x);
            if(dist-1>0) look(r,c,dist-1,x);
            else look(r,c,4,x);
            if(dist+1>4) look(r,c,1,x);
            else look(r,c,dist+1,x);
        }else{                                   //5번 cctv
            look(r,c,1,x);
            look(r,c,2,x);
            look(r,c,3,x);
            look(r,c,4,x);
        }
    }

    /*
    static void install_cctv(int idx, int r, int c){
        if((r==N&&c==0)||idx==8){
            blind_spot(0);
            return;
        }if(c==M-1){
            install_cctv(idx,r+1,0);
            return;
        }
        int nextr=r, nextc=c+1;
        if(office[nextr][nextc]==0) {
            cctv[cctv_num][0] = nextr;
            cctv[cctv_num][1] = nextc;
            cctv_num++;
            office[nextr][nextc]=5;
            install_cctv(idx + 1, nextr, nextc);
            cctv_num--;
            cctv[cctv_num][0] = 0;
            cctv[cctv_num][1] = 0;
            office[nextr][nextc]=0;
        }
        install_cctv(idx, nextr, nextc);
    }
*/
}