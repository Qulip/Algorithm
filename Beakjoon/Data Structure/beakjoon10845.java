package beak10845;
//https://www.acmicpc.net/problem/10845

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Queue<String> pro = new LinkedList<>();
        String[] order_set = {"push", "pop", "size", "empty", "front","back"};
        int last = 0;
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            String num = null;
            if(st.hasMoreTokens()) {
                num = st.nextToken();
                last = Integer.parseInt(num);
            }
            int order_num = 0;
            while(true){
                if(order.equals(order_set[order_num])){
                    break;
                }
                order_num++;
            }
            switch (order_num){
                case 0:                             //push
                    pro.offer(num);
                    break;
                case 1:                             //pop
                    if(pro.size()==0){
                        sb.append("-1\n");
                    }else{
                        sb.append(pro.poll()+"\n");
                    }
                    break;
                case 2:                             //size
                    sb.append(pro.size()+"\n");
                    break;
                case 3:                             //empty
                    if(pro.isEmpty()){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case 4:                             //front
                    if(pro.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(pro.peek()+"\n");
                    }
                    break;
                case 5:                             //back
                    if(pro.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(last+"\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
