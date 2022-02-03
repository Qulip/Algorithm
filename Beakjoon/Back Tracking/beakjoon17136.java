package beak17136;
//https://www.acmicpc.net/problem/17136

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] left = {0,5,5,5,5,5};
    static int rst = 0;
    static int out = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[10][10];
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fill_paper(0, -1);
        System.out.println(out);
    }

    static void fill_paper(int x, int y) {
        int[] next = chk_next(x, y);
        if(next[0]==10){
            if(out<0){
                out = rst;
            }else{
                out = out>rst ? rst:out;
            }
            //System.out.println("Fill All! "+out);
            return;
        }
        int size = 1;
        if (chk_2(next[0], next[1])) {
            size++;
            if (chk_3(next[0], next[1])) {
                size++;
                if (chk_4(next[0], next[1])) {
                    size++;
                    if (chk_5(next[0], next[1])) {
                        size++;
                    }
                }
            }
        }
        for(int i=size; i>0; i--){
            fill_zero(next[0], next[1], i);
            left[i]--;
            rst++;/*
            System.out.println(next[0]+" "+next[1]+" "+i+"     "+rst);
            for(int asd = 0; asd<10; asd++){
                for(int asdf = 0; asdf<10; asdf++){
                    System.out.print(map[asd][asdf]+" ");
                }
                System.out.println();
            }*/
            if(left[i]<0){
                rst--;
                left[i]++;
                fill_one(next[0], next[1], i);
                return;
            }
            fill_paper(next[0], next[1]);
            /*if(tmp){
                return true;
            }*/
            fill_one(next[0], next[1], i);
            rst--;
            left[i]++;
            //System.out.println("Back!!");
        }
        return;
    }
    static boolean chk_2(int x,int y){
        if(x>8||y>8){
            return false;
        }
        return map[x][y + 1] == 1 && map[x + 1][y] == 1 && map[x + 1][y + 1] == 1;
    }

    static boolean chk_3(int x,int y){
        if(x>7||y>7){
            return false;
        }
        return map[x][y + 2] == 1 && map[x + 1][y + 2] == 1 && map[x + 2][y + 2] == 1 && map[x + 2][y] == 1 && map[x + 2][y + 1] == 1;
    }

    static boolean chk_4(int x,int y){
        if(x>6||y>6){
            return false;
        }
        return map[x][y + 3] == 1 && map[x + 1][y + 3] == 1 && map[x + 2][y + 3] == 1 && map[x + 3][y+3] == 1 && map[x + 3][y + 2] == 1 && map[x + 3][y + 1] == 1 && map[x + 3][y] == 1;
    }

    static boolean chk_5(int x, int y){
        if(x>5||y>5){
            return false;
        }
        return map[x][y + 4] == 1 && map[x + 1][y + 4] == 1 && map[x + 2][y + 4] == 1 && map[x + 3][y + 4] == 1 && map[x + 4][y + 4] == 1 && map[x + 4][y + 3] == 1 && map[x + 4][y + 2] == 1 && map[x + 4][y + 1] == 1 && map[x + 4][y] == 1;
    }

    static void fill_zero(int r, int c, int size){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                map[i][j] = 0;
            }
        }
    }

    static void fill_one(int r, int c, int size){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                map[i][j] = 1;
            }
        }
    }

    public static int[] chk_next(int r,int c){
        int[] next= new int[2];
        for(int i=r; i<10; i++){
            if(i==r){
                for(int j=c+1; j<10; j++){
                    if(map[i][j]==1){
                        next[0] = i;
                        next[1] = j;
                        return next;
                    }
                }
            }else{
                for(int j=0; j<10; j++){
                    if(map[i][j]==1){
                        next[0] = i;
                        next[1] = j;
                        return next;
                    }
                }
            }
        }
        next[0] = 10;
        next[1] = 10;
        return next;
    }
}
