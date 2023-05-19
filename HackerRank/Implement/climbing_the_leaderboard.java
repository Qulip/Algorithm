import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here
		List<Integer> rst = new LinkedList<>();

		int idx = 1;
		int rank = 1;
		int before = ranked.get(0);

		for(int i = player.size()-1; i>=0; i--) {
			int score = player.get(i);

			if(before <= score) {
				rst.add(0, rank);
				continue;
			}

			while(idx < ranked.size()) {
				System.out.println("while");
				if(before > ranked.get(idx)) {
					rank++;
					before = ranked.get(idx);
				}

				if(ranked.get(idx) <= score) {
					break;
				}
				idx++;
				if(idx == ranked.size()) {
					rank++;
				}
			}

			rst.add(0, rank);
		}

		return rst;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> result = Result.climbingLeaderboard(ranked, player);

		bufferedWriter.write(
			result.stream()
				.map(Object::toString)
				.collect(joining("\n"))
				+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
