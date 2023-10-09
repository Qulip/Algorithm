import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] map;
	public static List<Location> player;
	public static int[] exit;
	public static int playTime;

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		playTime = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		player = new ArrayList<>();
		exit = new int[2];
		int totalMove = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			player.add(new Location(r - 1, c - 1));
		}

		st = new StringTokenizer(br.readLine());
		exit[0] = Integer.parseInt(st.nextToken()) - 1;
		exit[1] = Integer.parseInt(st.nextToken()) - 1;

		int time = 0;

		while (time < playTime) {
			System.out.println("Player Move");
			for (int i = 0; i < player.size(); i++) {
				Location loc = player.get(i);
				int dist = getDist(loc.r, loc.c);
				for (int j = 0; j < 4; j++) {
					if (isValid(N, loc.r + dr[j], loc.c + dc[j])
						&& dist > getDist(loc.r + dr[j], loc.c + dc[j])) {
						System.out.print(loc.r + " " + loc.c + " -> " + (loc.r + dr[j]) + " " + (loc.c + dc[j]));
						loc.move(dr[j], dc[j]);
						if (loc.isExit(exit)) {
							System.out.print(" OUT");
							totalMove += loc.move;
							player.remove(i);
							i--;
						}
						System.out.println();
						break;
					}
				}
			}
			if (player.size() == 0) {
				break;
			}
			findAndRotate();
			time++;

			System.out.println("AfterRotate");
			System.out.println("Player");
			for (Location loc : player) {
				System.out.println(loc.r + " " + loc.c);
			}
			System.out.println("Exit");
			System.out.println(exit[0] + " " + exit[1]);
			System.out.println();
		}

		for (Location loc : player) {
			totalMove += loc.move;
		}

		sb.append(totalMove).append("\n").append(exit[0] + 1).append(" ").append(exit[1] + 1);

		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	public static boolean isValid(int N, int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N && map[r][c] == 0;
	}

	public static void findAndRotate() {
		int[] point = new int[2];
		int best = Integer.MAX_VALUE;
		for (Location loc : player) {
			int maxLength = getMaxLength(loc);
			if (maxLength < best) {
				best = maxLength;
				point = getPoint(loc);
			} else if (maxLength == best) {
				int[] nowPoint = getPoint(loc);
				if (point[0] == nowPoint[0]) {
					if (point[1] > nowPoint[1]) {
						point = nowPoint;
					}
				} else {
					point = nowPoint;
				}
			}
		}
		rotate(point[0], point[1], best + 1);
	}

	public static void rotate(int r, int c, int dist) {
		System.out.println("Rotate");
		System.out.println(r + " " + c + " " + dist);
		int[][] next = new int[dist][dist];
		for (int i = 0; i < dist; i++) {
			for (int j = 0; j < dist; j++) {
				if (map[r + i][c + j] > 0) {
					next[j][dist - i - 1] = map[r + i][c + j] - 1;
				}
			}
		}
		for (int i = 0; i < dist; i++) {
			// System.out.println(Arrays.toString(next[i]));
			for (int j = 0; j < dist; j++) {
				map[r + i][c + j] = next[i][j];
			}
		}
		int nExit1 = exit[0] - r;
		int nExit2 = exit[1] - c;
		exit[0] = r + nExit2;
		exit[1] = c + dist - nExit1 - 1;

		for (Location loc : player) {
			if (loc.isIn(r, c, dist)) {
				int nr = loc.r - r;
				int nc = loc.c - c;
				loc.r = r + nc;
				loc.c = c + dist - nr - 1;
			}
		}
	}

	public static int[] getPoint(Location loc) {
		int[] point = new int[2];
		int maxLength = getMaxLength(loc);
		if (loc.r <= exit[0] && loc.c <= exit[1]) {
			point[0] = exit[0] - maxLength;
			point[1] = exit[1] - maxLength;
		} else if (loc.r <= exit[0]) {
			point[0] = exit[0] - maxLength;
			point[1] = exit[1];
		} else if (loc.c <= exit[1]) {
			point[0] = exit[0];
			point[1] = exit[1] - maxLength;
		} else {
			point[0] = exit[0];
			point[1] = exit[1];
		}

		if (point[0] < 0) {  //1, 3분면 일경우 나가는 경우 존재
			point[0] = 0;
		}
		if (point[1] < 0) {
			point[1] = 0;
		}
		if (point[0] + maxLength >= map.length) {
			point[0] = map.length - maxLength - 1;
		}
		if (point[1] + maxLength >= map.length) {
			point[1] = map.length - maxLength - 1;
		}
		return point;
	}

	public static int getDist(int r, int c) {
		return Math.abs(exit[0] - r) + Math.abs(exit[1] - c);
	}

	public static int getMaxLength(Location loc) {
		return Math.max(Math.abs(exit[0] - loc.r), Math.abs(exit[1] - loc.c));
	}

	static class Location {
		public int r;
		public int c;
		public int move;

		public boolean isIn(int x, int y, int l) {
			return r >= x && r < x + l && c >= y && c < y + l;
		}

		public void move(int dr, int dc) {
			r += dr;
			c += dc;
			move++;
		}

		public boolean isExit(int[] exit) {
			return r == exit[0] && c == exit[1];
		}

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
			this.move = 0;
		}
	}
}