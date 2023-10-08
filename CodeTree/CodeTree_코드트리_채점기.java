import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        playTime = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        player = new ArrayList<>();
        exit = new int[2];

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
            player.add(new Location(r, c));
        }

        st = new StringTokenizer(br.readLine());
        exit[0] = Integer.parseInt(st.nextToken());
        exit[1] = Integer.parseInt(st.nextToken());

        int time = 0;

        while (time < playTime) {
            for (int i = 0; i < player.size(); i++) {
                Location loc = player.get(i);
                int dist = Math.abs(exit[0] - loc.r) + Math.abs(exit[1] - loc.c);
                for (int j = 0; j < 4; j++) {
                    if (isValid(N, loc.r + dr[j], loc.c + dc[j])
                            && dist > Math.abs(exit[0] - (loc.r + dr[j])) + Math.abs(exit[1] - (loc.c + dc[j]))) {
                        loc.move(dr[0], dc[1]);
                        if(loc.isExit(exit)) {
                            player.remove(i);
                            i--;
                        }
                        break;
                    }
                }
            }
            time++;
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static class Location {
        public int r;
        public int c;

        public boolean isIn(int x, int y, int l) {
            return r >= x && r <= x + l && c >= y && c <= y + l;
        }

        public void move(int dr, int dc) {
            r += dr;
            c += dc;
        }

        public boolean isExit(int[] exit) {
            return r == exit[0] && c == exit[1];
        }

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isValid(int N, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N && map[r][c] == 0;
    }
}