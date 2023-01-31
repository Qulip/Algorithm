//https://softeer.ai/practice/info.do?idx=1&eid=1256
//solved : 23/01/31

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static class Superior {
        Queue<Integer> left;
        Queue<Integer> right;

        Superior() {
            left = new LinkedList<>();
            right = new LinkedList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("./res/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rst = 0;
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Superior[][] tree = new Superior[H][];
        for (int i = 0; i < H; i++) {
            tree[i] = new Superior[(int) Math.pow(2, i)];
            for (int j = 0; j < tree[i].length; j++) {
                tree[i][j] = new Superior();
            }
        }

        Queue<Integer>[] employee = new Queue[(int) Math.pow(2, H)];

        for (int i = 0; i < employee.length; i++) {
            st = new StringTokenizer(br.readLine());
            employee[i] = new LinkedList<>();
            for (int j = 0; j < K; j++) {
                employee[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int day = 1; day <= R; day++) {
            if (day % 2 == 0) {
                if (!tree[0][0].right.isEmpty()) {
                    rst += tree[0][0].right.poll();
                }
            } else {
                if (!tree[0][0].left.isEmpty()) {
                    rst += tree[0][0].left.poll();
                }
            }
            for (int i = 0; i < H - 1; i++) {
                for (int j = 0; j < tree[i].length; j++) {
                    if (day % 2 == 0) {
                        if (!tree[i + 1][j * 2].right.isEmpty()) {
                            tree[i][j].left.add(tree[i + 1][j * 2].right.poll());
                        }
                        if (!tree[i + 1][(j * 2) + 1].right.isEmpty()) {
                            tree[i][j].right.add(tree[i + 1][(j * 2) + 1].right.poll());
                        }
                    } else {
                        if (!tree[i + 1][j * 2].left.isEmpty()) {
                            tree[i][j].left.add(tree[i + 1][j * 2].left.poll());
                        }
                        if (!tree[i + 1][(j * 2) + 1].left.isEmpty()) {
                            tree[i][j].right.add(tree[i + 1][(j * 2) + 1].left.poll());
                        }
                    }
                }
            }
            for (int i = 0; i < tree[H - 1].length; i++) {
                if (!employee[i * 2].isEmpty()) {
                    tree[H - 1][i].left.add(employee[i * 2].poll());
                }
                if (!employee[(i * 2) + 1].isEmpty()) {
                    tree[H - 1][i].right.add(employee[(i * 2) + 1].poll());
                }
            }
        }

        bw.write(Integer.toString(rst));
        br.close();
        bw.close();
    }
}