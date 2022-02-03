package beak10828;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack<String> pro = new Stack<>();
        String[] order_set = {"push", "pop", "size", "empty", "top"};
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            String num = null;
            if(st.hasMoreTokens()) {
                num = st.nextToken();
            }
            int order_num = 0;
            while(true){
                if(order.equals(order_set[order_num])){
                    break;
                }
                order_num++;
            }
            switch (order_num){
                case 0:
                    pro.push(num);
                    break;
                case 1:
                    if(pro.size()==0){
                        sb.append("-1\n");
                    }else{
                        sb.append(pro.pop()+"\n");
                    }
                    break;
                case 2:
                    sb.append(pro.size()+"\n");
                    break;
                case 3:
                    if(pro.size()==0){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case 4:
                    if(pro.size()==0){
                        sb.append("-1\n");
                    }else{
                        sb.append(pro.peek()+"\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
