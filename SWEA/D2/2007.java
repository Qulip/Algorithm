import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        String[] Words = new String[T];
        int[] Results = new int[T];

        for(int test_case = 1; test_case<=T; test_case++)
        {
            Results[test_case-1] = 0;
            Words[test_case-1] = sc.next();
            char[] Letter = Words[test_case-1].toCharArray();
            for(int i=Letter.length/2; i>0; i--)
            {
                int flag = 1;
                for(int j = 0; j<i; j++)
                {
                    if(Letter[j]!=Letter[j+i])
                    {
                        flag =0;
                    }
                }
                if(flag==1)
                {
                    Results[test_case-1] = i;
                }
            }
        }
        for(int test_case = 1; test_case<=T; test_case++)
        {
            System.out.println("#"+test_case+" "+Results[test_case-1]);
        }

    }
}
