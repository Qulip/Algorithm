//https://school.programmers.co.kr/learn/courses/30/lessons/118666
//Solved : 22/12/15

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"AN", "CF", "MJ", "RT", "NA"},
                new int[]{5, 3, 2, 7, 5}
        ));
        System.out.println(solution(
                new String[]{"TR", "RT", "TR"},
                new int[]{7, 1, 3}
        ));
    }

    public static final char[][] TYPE = new char[][]{{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> score = init();

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i] - 4;
            if (choice < 0) {
                char c = survey[i].charAt(0);
                int s = score.get(c);
                score.put(c, s + Math.abs(choice));
            } else if (choice > 0) {
                char c = survey[i].charAt(1);
                int s = score.get(c);
                score.put(c, s + choice);
            }
        }

        for(int i=0; i<TYPE.length; i++) {
            int score1 = score.get(TYPE[i][0]);
            int score2 = score.get(TYPE[i][1]);
            if(score1 >= score2) {
                answer.append(TYPE[i][0]);
            }else {
                answer.append(TYPE[i][1]);
            }
        }

        return answer.toString();
    }

    public static Map<Character, Integer> init() {
        Map<Character, Integer> score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);
        return score;
    }
}