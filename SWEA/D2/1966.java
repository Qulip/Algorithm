import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[][] Results = new int[T][];
        int[] Amounts = new int[T];

        for(int test_case=1; test_case<=T; test_case++)
        {
            Amounts[test_case-1] = sc.nextInt();
            Results[test_case-1] = new int[Amounts[test_case-1]];
            for(int i = 0; i<Amounts[test_case-1]; i++)
            {
                Results[test_case-1][i]=sc.nextInt();
            }
            Arrays.sort(Results[test_case-1]);
        }
        for(int test_case=1; test_case<=T; test_case++)
        {
            System.out.print("#"+test_case);
            for(int i = 0; i<Amounts[test_case-1];i++)
            {
                System.out.print(" "+Results[test_case-1][i]);
            }
            System.out.println();
        }
    }
}

//STRING BUILDER
//BUFFER READER