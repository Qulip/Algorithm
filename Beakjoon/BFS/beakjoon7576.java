package beak7576;
//https://www.acmicpc.net/problem/7576

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        int[][] arr = new int[N][M];    //위치별 일수

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);

            }
        }
        //----------------- 입력 부 ------------------
        BFS(arr, N, M);
    }

    public static void BFS(int[][] arr, int N, int M) {
        Queue<beak7576.DOT> q = new LinkedList<beak7576.DOT>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1)
                    //익은 토마토가 있는 모든 위치를 큐에 담는다.
                    q.add(new beak7576.DOT(i, j));
            }
        }

        while (!q.isEmpty()) {
            //익은 토마토의 상하좌우는 다음에 익기 때문에 큐에 담아야한다.
            beak7576.DOT dot = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                //범위 밖 패스
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                //다음 위치가 익지 않은 토마토가 아니면 패스
                if (arr[nextX][nextY] != 0) {
                    continue;
                }
                //최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1 을 해줘야한다.
                arr[nextX][nextY] = arr[dot.x][dot.y] + 1;
                q.add(new beak7576.DOT(nextX, nextY));
            }
            //print(arr, N, M); // 농장 전체 출력
            //System.out.println();
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    //토마토가 모두 익지 못한 상황이라면 -1 을 출력한다.
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        //그렇지 않다면 최대값을 출력한다.
        System.out.println(max - 1);

    }
    //농장을 전체 보여주는 함수
    public static void print(int[][] arr, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class DOT {
    int x;
    int y;

    DOT(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


/*

public class Main {
    static int m;
    static int n;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int all_tomato = 0;
    static int all_box = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=-1){
                    all_box++;
                }
                if(map[i][j]==1){
                    q.add(new int[]{i, j});
                    all_tomato++;
                }
            }
        }
        int time;
        if(all_tomato==all_box){
            time=0;
        } else {
            time=0;
            while (true) {
                Queue<int[]> tmp = bfs(q);
                time++;
                if(tmp.isEmpty()){
                    if(all_tomato!=all_box){
                        time = -1;
                    }
                    break;
                }
            }
        }
        System.out.println(time);
    }

    public static Queue<int[]> bfs(Queue<int[]> q){
        Queue<int[]> new_que = new LinkedList<>();
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i=0; i<4; i++){
                int nextX = x + dr[i];
                int nextY = y + dc[i];
                if(nextX>=0 && nextY>=0 && nextX<n && nextY<m){
                    //System.out.println(nextX+" "+nextY);
                    if(map[nextX][nextY]==0) {
                        map[nextX][nextY] = 1;
                        all_tomato++;
                    }
                }
            }
        }
        return new_que;
    }
}

6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
    out : 8
 */