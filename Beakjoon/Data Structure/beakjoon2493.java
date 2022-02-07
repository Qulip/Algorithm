package beakjoon.q2493;
//https://www.acmicpc.net/problem/2493
//Solved : 22/02/07

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<num; i++){
            int now = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= now) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                sb.append("0 ");
            }
            stack.push(new int[]{i+1, now});
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
/*
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int[] tower = new int[num];
        int[] rst = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer[]> left1 = new Stack<>();
        Stack<Integer[]> left2 = new Stack<>();
        for(int i=0; i<num; i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(tower));
        for(int i=num-1; i>=0; i--){
            int put = 0;
            if(left1.isEmpty()){
                put = 1;
                while(!left2.isEmpty()){
                    //System.out.println("left2 size : "+left2.size()+" "+left1.size());
                    Integer[] bef = left2.pop();
                    if(bef[1]<=tower[i]){
                        //System.out.println("left2 "+bef[0]+" "+bef[1]+" "+tower[i]+" "+i);
                        rst[bef[0]] = i+1;
                    }else{
                        left1.push(bef);
                    }
                }
                //System.out.println("left2 : "+left2.size()+" "+left1.size()+" "+i);
            }else{
                put = 2;
                while(!left1.isEmpty()){
                    //System.out.println("left1 size : "+left1.size()+" "+left2.size());
                    Integer[] bef = left1.pop();
                    //System.out.println("left1 "+bef[0]+" "+bef[1]+" "+tower[i]+" "+i);
                    if(bef[1]<=tower[i]){
                        rst[bef[0]] = i+1;
                    }else{
                        left2.push(bef);
                    }
                }
                //System.out.println("left1 : "+left1.size()+" "+left2.size()+" "+i);
            }
            if(i>0) {
                if (tower[i] <= tower[i - 1]) {
                    rst[i] = i;
                } else {
                    if (put == 1) {
                        left1.push(new Integer[]{i, tower[i]});
                    } else {
                        left2.push(new Integer[]{i, tower[i]});
                    }
                }
            }
            //System.out.println("end : "+left1.size()+" "+left2.size());
        }
        for(int i : rst){
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
 */