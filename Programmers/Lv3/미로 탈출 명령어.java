import java.util.HashMap;
import java.util.Map;

class Solution {
    public static final String impossible = "impossible";
    public static String[][][] map;

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
        System.out.println(solution(2, 2, 1, 1, 2, 2, 2));
        System.out.println(solution(3, 3, 1, 2, 3, 3, 4));
    }

    public static Map<Integer, String> dirStr = new HashMap<>() {{
        put(0, "d");
        put(1, "l");
        put(2, "r");
        put(3, "u");
    }};

    public static int[][] dir = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new String[n][m][k+1];
        DFS(n, m, x-1, y-1, r-1, c-1, k, "");
        return map[r-1][c-1][0] != null ? map[r-1][c-1][0] : impossible;
    }

    public static void DFS(int n, int m, int x, int y, int r, int c, int k, String dirs) {
        if (k == 0 && x == r && y == c) {
            map[x][y][0] = dirs;
            return;
        }
        if (k == 0) {
            map[x][y][0] = impossible;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(map[x][y][k] != null) {
                return;
            }
            int nr = x + dir[i][0];
            int nc = y + dir[i][1];
            if(isOut(n,m,nr,nc)) {
                continue;
            }
            if (map[nr][nc][k - 1] == null) {
                DFS(n, m, nr, nc, r, c, k - 1, dirs + dirStr.get(i));
            }
            if(!map[nr][nc][k-1].equals(impossible)) {
                map[x][y][k] = dirs + dirStr.get(i);
            }
        }
        map[x][y][k] = impossible;
    }

    public static boolean isOut(int n, int m, int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }
}