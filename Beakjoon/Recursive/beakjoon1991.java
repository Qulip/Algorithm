package beakjoon.q1991;
//https://www.acmicpc.net/problem/1991
//22/02/04

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        char[][] tree = new char[t][2];
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            char now = st.nextToken().charAt(0);
            tree[now-'A'][0] = st.nextToken().charAt(0);
            tree[now-'A'][1] = st.nextToken().charAt(0);
        }
        sb.append(preOrder(tree, 'A')).append("\n").append(inOrder(tree, 'A')).append("\n").append(postOrder(tree, 'A'));
        bw.write(sb.toString());
        bw.close();
    }
    public static String preOrder(char[][] tree, char now){
        StringBuilder sb = new StringBuilder();
        sb.append(now);
        if(tree[now-'A'][0] != '.'){
            sb.append(preOrder(tree, tree[now-'A'][0]));
        }
        if(tree[now-'A'][1] != '.'){
            sb.append(preOrder(tree, tree[now-'A'][1]));
        }
        return sb.toString();
    }
    public static String inOrder(char[][] tree, char now){
        StringBuilder sb = new StringBuilder();
        if(tree[now-'A'][0] != '.'){
            sb.append(inOrder(tree, tree[now-'A'][0]));
        }
        sb.append(now);
        if(tree[now-'A'][1] != '.'){
            sb.append(inOrder(tree, tree[now-'A'][1]));
        }
        return sb.toString();
    }
    public static String postOrder(char[][] tree, char now){
        StringBuilder sb = new StringBuilder();
        if(tree[now-'A'][0] != '.'){
            sb.append(postOrder(tree, tree[now-'A'][0]));
        }
        if(tree[now-'A'][1] != '.'){
            sb.append(postOrder(tree, tree[now-'A'][1]));
        }
        sb.append(now);
        return sb.toString();
    }
}
