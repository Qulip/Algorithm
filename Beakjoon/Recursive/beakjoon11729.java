package beakjoon.q11729;
//https://www.acmicpc.net/problem/11729     하노이 탑 이동순서

import java.io.*;

public class Main {
    public static BufferedWriter bw;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(move(num,1, 3)));;
        bw.write("\n");
        bw.write(sb.toString());
        bw.close();
    }
    public static int move(int now_size, int now_loc, int next_loc){
        if(now_size==1){
            sb.append(now_loc).append(" ").append(next_loc).append("\n");
            return 1;
        }
        int time=0;
        if(now_loc+next_loc==3){
            time+=move(now_size-1, now_loc, 3);
        }else if(now_loc+next_loc==4){
            time+=move(now_size-1, now_loc, 2);
        }else{
            time+=move(now_size-1, now_loc, 1);
        }
        sb.append(now_loc).append(" ").append(next_loc).append("\n");
        time++;
        if(now_loc+next_loc==3){
            time+=move(now_size-1, 3, next_loc);
        }else if(now_loc+next_loc==4){
            time+=move(now_size-1, 2, next_loc);
        }else{
            time+=move(now_size-1, 1, next_loc);
        }
        return time;
    }
}
