//https://www.acmicpc.net/problem/5639
//Solved : 22/03/03

import java.util.*;
import java.io.*;


class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String n;
        while(true){
            n = br.readLine();
            if(n==null||n.equals("")) break;
            root.insert(Integer.parseInt(n));
        }

        print(root);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void print(Node n){
        if(n==null) return;

        print(n.small);
        print(n.big);
        sb.append(n.num).append("\n");
    }
}

class Node{
    int num;
    Node small,big;
    Node(int num){
        this.num = num;
    }

    public Node(int num, Node small, Node big) {
        this.num = num;
        this.small = small;
        this.big = big;
    }

    public void insert(int n){
        if(n > num){
            if(big == null) big = new Node(n);
            else this.big.insert(n);
        }else{
            if(small == null) small = new Node(n);
            else this.small.insert(n);
        }
    }
}

/*
class Main{
    static Map<Integer, int[]> tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tree = new HashMap<>();
        int root = Integer.parseInt(br.readLine());
        tree.put(root, new int[]{0,0});
        String n;

        while(true){
            n = br.readLine();
            if(n==null||n.equals("")) break;
            int number = Integer.parseInt(n);
            int parent = root;
            tree.put(number, new int[]{0,0});
            while(true){
                int[] node = tree.get(parent);
                if(number > parent){
                    if(node[1]==0){
                        tree.put(parent, new int[]{node[0], number});
                        break;
                    }else{
                        parent = node[1];
                    }
                }else{
                    if(node[0]==0){
                        tree.put(parent, new int[]{number, node[1]});
                        break;
                    }else{
                        parent = node[0];
                    }
                }
            }
        }

        print(root);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void print(int root){
        int[] arr = tree.get(root);
        if(arr[0]==0&&arr[1]==0){
            sb.append(root).append("\n");
            return;
        }
        if(arr[0]!=0) print(arr[0]);
        if(arr[1]!=0) print(arr[1]);
        sb.append(root).append("\n");
    }
}
 */