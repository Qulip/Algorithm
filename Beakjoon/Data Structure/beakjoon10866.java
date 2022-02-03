package beak10866;
//https://www.acmicpc.net/problem/10866

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        Deque<String> dq = new ArrayDeque<>();
        String[] order_names = {"push_front","push_back", "pop_front", "pop_back", "size", "empty", "front", "back"};
        for(int i=0; i<t; i++) {
            int order_num = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            String num = null;
            if(st.hasMoreTokens()){
                num = st.nextToken();
            }
            while(true) {
                if (order.equals(order_names[order_num])){
                    break;
                }
                order_num++;
            }
            order_num++;
            switch (order_num){
                case 1:
                    dq.addFirst(num);
                    break;
                case 2:
                    dq.addLast(num);
                    break;
                case 3:
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(dq.pop()+"\n");
                    }
                    break;
                case 4:
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(dq.pollLast()+"\n");
                    }
                    break;
                case 5:
                    sb.append(dq.size()+"\n");
                    break;
                case 6:
                    if(dq.isEmpty()){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case 7:
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(dq.peekFirst()+"\n");
                    }
                    break;
                case 8:
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(dq.peekLast()+"\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
