import java.util.Arrays;

class Solution {
	public static int BEST;
	public static int[] result;

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(
		// 	solution(5, new int[] {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})
		// ));
		// System.out.println(Arrays.toString(
		// 	solution(1, new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})
		// ));
		System.out.println(Arrays.toString(
			solution(9, new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})
		));
		// System.out.println(Arrays.toString(
		// 	solution(10, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})
		// ));
	}

	public static int[] solution(int n, int[] info) {
		int[] answer = new int[] {-1};
		int apeachScore = 0;
		BEST = 0;
		result = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

		for (int i = 0; i < 11; i++) {
			if (info[i] >= 1) {
				apeachScore += 10 - i;
			}
		}

		if (n == 1) {
			if (apeachScore < 10) {
				answer = new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			}
			return answer;
		}

		dfs(apeachScore, 0, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, info, n, 10);

		if (BEST == 0) {
			return answer;
		}

		return result;
	}

	public static void dfs(int apeachScore, int ryanScore, int[] ryan, int[] apeach, int arrow, int score) {
		if (score == 0) {
			if (arrow > 0) {
				ryan[10] = arrow;
			}
			if (ryanScore - apeachScore > BEST) {
				result = ryan.clone();
				BEST = ryanScore - apeachScore;

			}
			if (ryanScore - apeachScore == BEST) {
				for (int i = 10; i >= 0; i--) {
					if (ryan[i] > result[i]) {
						result = ryan.clone();
						BEST = ryanScore - apeachScore;
						break;
					}
					if(ryan[i] < result[i]) {
						break;
					}
				}
			}
			if (arrow > 0) {
				ryan[10] = 0;
			}
			return;
		}

		int idx = 10 - score;

		if (arrow > apeach[idx]) {
			ryan[idx] = apeach[idx] + 1;
			arrow -= apeach[idx] + 1;
			ryanScore += score;
			if (apeach[idx] != 0) {
				apeachScore -= score;
			}
			dfs(apeachScore, ryanScore, ryan, apeach, arrow, score - 1);
			arrow += ryan[idx];
			ryan[idx] = 0;
			ryanScore -= score;
			if (apeach[idx] != 0) {
				apeachScore += score;
			}
		}
		dfs(apeachScore, ryanScore, ryan, apeach, arrow, score - 1);
	}
}