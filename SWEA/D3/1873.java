package swea1873;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static char[][] map;
    static int tankx, tanky;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map = new char[y][x];
            String temp;
            for(int i=0; i<y; i++){
                temp = input.readLine();
                map[i] = temp.toCharArray();
                for(int j=0; j<map[i].length; j++){
                    if(map[i][j]=='^'||map[i][j]=='>'||map[i][j]=='v'||map[i][j]=='<'){
                        tanky = i;
                        tankx = j;
                    }
                }
            }
            int time = Integer.parseInt(input.readLine());
            temp = input.readLine();
            char[] move = temp.toCharArray();
            for(int i=0; i<time; i++){
                switch (move[i]){
                    case 'U':
                        Up();
                        break;
                    case 'D':
                        Down();
                        break;
                    case 'L':
                        Left();
                        break;
                    case 'R':
                        Right();
                        break;
                    case 'S':
                        Shoot();
                        break;
                }
            }
            sb.append("#"+tc+" ");
            for(int i=0; i< map.length; i++){
                for(int j=0; j<map[i].length; j++){
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
    static void Shoot(){
        char tank = map[tanky][tankx];
        switch (tank){
            case '^':
                VBullet(-1);
                break;
            case '>':
                HBullet(1);
                break;
            case 'v':
                VBullet(1);
                break;
            case '<':
                HBullet(-1);
                break;
        }
    }
    static void VBullet(int y){
        int time = 1;
        int pos = 0;
        while(true){
            pos = tanky+(y*time);
            if(pos<0||pos>=map.length){
                break;
            } else if(map[pos][tankx]=='*'){
                map[pos][tankx]='.';
                break;
            } else if(map[pos][tankx]=='#'){
                break;
            }
            time++;
        }
    }
    static void HBullet(int x){
        int time = 1;
        int pos = 0;
        while(true){
            pos = tankx+(x*time);
            if(pos<0||pos>=map[tanky].length){
                break;
            } else if(map[tanky][pos]=='*'){
                map[tanky][pos]='.';
                break;
            } else if(map[tanky][pos]=='#'){
                break;
            }
            time++;
        }
    }
    static void Up(){
        if(tanky>0&&map[tanky-1][tankx] == '.'){
            map[tanky][tankx] = '.';
            map[tanky-1][tankx] = '^';
            tanky = tanky-1;
        }else {
            map[tanky][tankx] = '^';
        }
    }
    static void Down(){
        if(tanky<map.length-1&&map[tanky+1][tankx] == '.'){
            map[tanky][tankx] = '.';
            map[tanky+1][tankx] = 'v';
            tanky = tanky+1;
        }else {
            map[tanky][tankx] = 'v';
        }
    }
    static void Left(){
        if(tankx>0&&map[tanky][tankx-1] == '.'){
            map[tanky][tankx] = '.';
            map[tanky][tankx-1] = '<';
            tankx = tankx-1;
        }else {
            map[tanky][tankx] = '<';
        }
    }
    static void Right(){
        if(tankx<map[tanky].length-1&&map[tanky][tankx+1] == '.'){
            map[tanky][tankx] = '.';
            map[tanky][tankx+1] = '>';
            tankx = tankx+1;
        }else {
            map[tanky][tankx] = '>';
        }
    }
}
