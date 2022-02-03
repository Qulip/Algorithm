import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] Results = new int[T];
        int[][] Array = new int[15][15];

        for(int test_case = 1; test_case<=T; test_case++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Results[test_case-1] = 0;
            for(int i=0; i<x; i++)
            {
                for(int j=0; j<x; j++)
                {
                    Array[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<=x-y; i++)
            {
                for(int j=0; j<=x-y; j++)
                {
                    int temp = 0;
                    for(int k=i; k<i+y;k++)
                    {
                        for(int l = j; l<j+y;l++)
                        {
                            temp=temp+Array[k][l];
                        }
                    }
                    if(Results[test_case-1]<temp)
                    {
                        Results[test_case-1] = temp;
                    }
                }
            }
        }

        for(int test_case = 1; test_case<=T; test_case++)
        {
            System.out.println("#"+test_case+" "+Results[test_case-1]);
        }
    }
}
