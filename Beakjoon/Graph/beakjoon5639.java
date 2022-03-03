//https://www.acmicpc.net/problem/5639
//Solved : 22/03/03

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
            if(n==null) break;              //종료 시점을 안알려줘 Null 입력시 종료
            root.put(Integer.parseInt(n));
        }

        print(root);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void print(Node n){      //후위 순회이므로 작은것, 큰것, 그리고 본인 순서로 출력
        if(n==null) return;

        print(n.small);
        print(n.big);
        sb.append(n.num).append("\n");
    }
}

class Node{             //노드 클래스
    int num;            //현재 위치의 숫자
    Node small,big;     //우측, 좌측 작은 값들

    Node(int num){      //노드 클래스 생성자
        this.num = num;
    }

    public void put(int n){
        if(n > num){                                    //추가하려는 값이 현재 노드 보다 크면 우측에 추가
            if(big == null) big = new Node(n);          //우측에 노드가 비었다면 새로 생성
            else this.big.put(n);                       //그렇지 않다면 새로 들어가 위치 확인
        }else{
            if(small == null) small = new Node(n);      //값이 작으므로 좌측인것 제외하고 위와 동일
            else this.small.put(n);
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
        tree.put(root, new int[]{0,0});                 //이어진 노드가 없으면 {0,0}
        String n;

        while(true){
            n = br.readLine();
            if(n==null) break;
            int number = Integer.parseInt(n);
            int parent = root;                                              //루트부터 탐색하기 위하여 선언
            tree.put(number, new int[]{0,0});                               //새 노드가 생겼으니 Map에 추가
            while(true){
                int[] node = tree.get(parent);                              //노드에 연결된 가지 배열
                    if(number > parent){                                    //현재 노드보다 클 경우 우측만 확인
                    if(node[1]==0){                                         //비어있다면
                        tree.put(parent, new int[]{node[0], number});       //우측 배열 수정 후 탈출
                        break;
                    }else{
                        parent = node[1];                                   //이미 값이 있다면 더 들어가 탐색
                    }
                }else{                                                      //방향만 다르고 위와 동일
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
        int[] arr = tree.get(root);             //루트에 따라 Map에서 가지검색
        if(arr[0]==0&&arr[1]==0){ㅁ
            sb.append(root).append("\n");       //만약 더 이상 가지가 없다면 본인 출력 후 종료
            return;
        }
        if(arr[0]!=0) print(arr[0]);            //좌측에 가지가 있다면 좌측 탐색
        if(arr[1]!=0) print(arr[1]);            //우측도 마찬가지
        sb.append(root).append("\n");           //이후 본인 출력
    }
}
 *///https://www.acmicpc.net/problem/5639
//Solved : 22/03/03

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
            if(n==null) break;              //종료 시점을 안알려줘 Null 입력시 종료
            root.put(Integer.parseInt(n));
        }

        print(root);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void print(Node n){      //후위 순회이므로 작은것, 큰것, 그리고 본인 순서로 출력
        if(n==null) return;

        print(n.small);
        print(n.big);
        sb.append(n.num).append("\n");
    }
}

class Node{             //노드 클래스
    int num;            //현재 위치의 숫자
    Node small,big;     //우측, 좌측 작은 값들

    Node(int num){      //노드 클래스 생성자
        this.num = num;
    }

    public void put(int n){
        if(n > num){                                    //추가하려는 값이 현재 노드 보다 크면 우측에 추가
            if(big == null) big = new Node(n);          //우측에 노드가 비었다면 새로 생성
            else this.big.put(n);                       //그렇지 않다면 새로 들어가 위치 확인
        }else{
            if(small == null) small = new Node(n);      //값이 작으므로 좌측인것 제외하고 위와 동일
            else this.small.put(n);
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
        tree.put(root, new int[]{0,0});                 //이어진 노드가 없으면 {0,0}
        String n;

        while(true){
            n = br.readLine();
            if(n==null) break;
            int number = Integer.parseInt(n);
            int parent = root;                                              //루트부터 탐색하기 위하여 선언
            tree.put(number, new int[]{0,0});                               //새 노드가 생겼으니 Map에 추가
            while(true){
                int[] node = tree.get(parent);                              //노드에 연결된 가지 배열
                    if(number > parent){                                    //현재 노드보다 클 경우 우측만 확인
                    if(node[1]==0){                                         //비어있다면
                        tree.put(parent, new int[]{node[0], number});       //우측 배열 수정 후 탈출
                        break;
                    }else{
                        parent = node[1];                                   //이미 값이 있다면 더 들어가 탐색
                    }
                }else{                                                      //방향만 다르고 위와 동일
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
        int[] arr = tree.get(root);             //루트에 따라 Map에서 가지검색
        if(arr[0]==0&&arr[1]==0){ㅁ
            sb.append(root).append("\n");       //만약 더 이상 가지가 없다면 본인 출력 후 종료
            return;
        }
        if(arr[0]!=0) print(arr[0]);            //좌측에 가지가 있다면 좌측 탐색
        if(arr[1]!=0) print(arr[1]);            //우측도 마찬가지
        sb.append(root).append("\n");           //이후 본인 출력
    }
}
 *///https://www.acmicpc.net/problem/5639
//Solved : 22/03/03

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
            if(n==null) break;              //종료 시점을 안알려줘 Null 입력시 종료
            root.put(Integer.parseInt(n));
        }

        print(root);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void print(Node n){      //후위 순회이므로 작은것, 큰것, 그리고 본인 순서로 출력
        if(n==null) return;

        print(n.small);
        print(n.big);
        sb.append(n.num).append("\n");
    }
}

class Node{             //노드 클래스
    int num;            //현재 위치의 숫자
    Node small,big;     //우측, 좌측 작은 값들

    Node(int num){      //노드 클래스 생성자
        this.num = num;
    }

    public void put(int n){
        if(n > num){                                    //추가하려는 값이 현재 노드 보다 크면 우측에 추가
            if(big == null) big = new Node(n);          //우측에 노드가 비었다면 새로 생성
            else this.big.put(n);                       //그렇지 않다면 새로 들어가 위치 확인
        }else{
            if(small == null) small = new Node(n);      //값이 작으므로 좌측인것 제외하고 위와 동일
            else this.small.put(n);
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
        tree.put(root, new int[]{0,0});                 //이어진 노드가 없으면 {0,0}
        String n;

        while(true){
            n = br.readLine();
            if(n==null) break;
            int number = Integer.parseInt(n);
            int parent = root;                                              //루트부터 탐색하기 위하여 선언
            tree.put(number, new int[]{0,0});                               //새 노드가 생겼으니 Map에 추가
            while(true){
                int[] node = tree.get(parent);                              //노드에 연결된 가지 배열
                    if(number > parent){                                    //현재 노드보다 클 경우 우측만 확인
                    if(node[1]==0){                                         //비어있다면
                        tree.put(parent, new int[]{node[0], number});       //우측 배열 수정 후 탈출
                        break;
                    }else{
                        parent = node[1];                                   //이미 값이 있다면 더 들어가 탐색
                    }
                }else{                                                      //방향만 다르고 위와 동일
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
        int[] arr = tree.get(root);             //루트에 따라 Map에서 가지검색
        if(arr[0]==0&&arr[1]==0){ㅁ
            sb.append(root).append("\n");       //만약 더 이상 가지가 없다면 본인 출력 후 종료
            return;
        }
        if(arr[0]!=0) print(arr[0]);            //좌측에 가지가 있다면 좌측 탐색
        if(arr[1]!=0) print(arr[1]);            //우측도 마찬가지
        sb.append(root).append("\n");           //이후 본인 출력
    }
}
 */