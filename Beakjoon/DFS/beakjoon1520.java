import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Main {
	static int M, N;			//결과, 가로, 세로 변수
	static int[][] map;				//지형 배열
	static boolean[][] visited;
	static long[][] distance;
	static int[] dr = {-1,0,1,0}, dc= {0,1,0,-1};	//사방 탐색을 위한 배열

	public static void main(String[] args) throws Exception{
		System.setIn(Files.newInputStream(Paths.get("res/input.txt")));	//파일인풋 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		distance = new long[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//BFS탐색(메모리 초과)
		// BFS();

		//DFS탐색
		long rst = DFS(0,0);

		bw.write(Long.toString(rst));
		bw.close();
		br.close();
	}
	static long BFS() {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[]{0,0});			//무조건 출발 위치는 0,0이므로 0,0부터 시작
		long rst = 0;
		while(!que.isEmpty()) {
			int[] now = que.poll();			//현재 위치 배열
			int h = map[now[0]][now[1]];	//현재 위치의 높이

			for(int i=0; i<4; i++) {		//사방 탐색
				int nr = now[0]+dr[i];		//다음 가로, 세로
				int nc = now[1]+dc[i];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;	//배열 밖일경우 확인X
				if(h>map[nr][nc]) {						//내리막일경우
					if(nr==N-1 && nc==M-1) {			//목적지 도착시 큐에 넣지 않고, 결과만 증가시켜준다.
						rst++;
						continue;
					}
					que.add(new int[] {nr,nc});			//다음 탐색을 위하여 큐에 다음위치 추가
				}
			}
		}
		return rst;
	}

	static long DFS(int r, int c) {
		if(r==N-1 && c==M-1) {
			return 1L;
		}
		if(visited[r][c]) {
			return distance[r][c];
		}

		long rst = 0;

		int h = map[r][c];	//현재 위치의 높이

		for(int i=0; i<4; i++) {		//사방 탐색
			int nr = r+dr[i];		//다음 가로, 세로
			int nc = c+dc[i];
			if(nr<0||nr>=N||nc<0||nc>=M) continue;	//배열 밖일경우 확인X
			if(h>map[nr][nc]) {						//내리막일경우
				rst += DFS(nr,nc);
			}
		}
		visited[r][c] = true;
		distance[r][c] = rst;
		return rst;
	}
}
