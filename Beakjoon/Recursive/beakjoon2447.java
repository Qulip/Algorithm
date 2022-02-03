package beakjoon.q2447;
//https://www.acmicpc.net/problem/2447      // 별찍기 - 10

import java.io.*;

public class Main {

    public static char[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new char[num][num];
        print(num, 0, 0);
        StringBuilder sb = new StringBuilder();
        for(char[] i:arr){
            for(char j : i){
                sb.append(j);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void print(int size, int row, int col) {
        if(size==3){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==1 && j==1){
                        arr[row+i][col+j]=' ';
                        continue;
                    }
                    arr[row+i][col+j] = '*';
                }
            }
            return;
        }
        for(int i=0; i<size; i+=size/3){
            for(int j=0; j<size; j+=size/3){
                if(i==size/3&&j==size/3){
                    blank(size/3, row+i, col+j);
                    continue;
                }
                print(size/3,row+i,col+j);
            }
        }
    }
    public static void blank(int size, int row, int col){
        if(size==3){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    arr[row+i][col+j] = ' ';
                }
            }
            return;
        }
        for(int i=0; i<size; i+=size/3){
            for(int j=0; j<size; j+=size/3){
                blank(size/3,row+i,col+j);
            }
        }
    }
}
