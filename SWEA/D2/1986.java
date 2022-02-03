import java.util.Scanner;

public class Solution {
    public static void main(String arc[])
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] Numbers = new int[T];
        int[] Results = new int[T];
        for(int test_case = 1; test_case <= T; test_case++)
        {
            Numbers[test_case-1] = sc.nextInt();
            Results[test_case-1] = 0;
        }

        for(int test_case = 1; test_case <= T; test_case++)
        {
            for(int i = 1; i<=Numbers[test_case-1]; i++)
            {
                if(i%2==0)
                {
                    Results[test_case-1] = Results[test_case-1]-i;
                }
                else
                {
                    Results[test_case-1] = Results[test_case-1]+i;
                }
            }
            System.out.println("#"+test_case+" "+Results[test_case-1]);
        }
    }
}
