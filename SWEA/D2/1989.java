import java.util.Scanner;

public class Solution {
    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        String[] words = new String[T];
        for (int test_case = 1; test_case <= T; test_case++) {
            words[test_case - 1] = sc.next();
        }
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int flag = 1;
            char[] CHAR = words[test_case-1].toCharArray();
            for(int i=0; i<=CHAR.length/2; i++)
            {
                if(CHAR[i]!=CHAR[CHAR.length-1-i])
                {
                    flag = 0;
                }
            }
            System.out.println("#"+test_case+" "+flag);
        }
    }
}