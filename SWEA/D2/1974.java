import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] Results = new int[T];
        int[][] Sudoku = new int[9][9];
        for(int test_case =  1; test_case<=T; test_case++)
        {
            for(int i=0; i<9;i++)
            {
                for(int j=0; j<9; j++)
                {
                    Sudoku[i][j]=sc.nextInt();
                }
            }
            Results[test_case-1] = 1;
            for(int i=0; i<9;i++)
            {
                int x=0;
                int y=0;
                for(int j=0; j<9;j++)
                {
                    x = x + Sudoku[i][j];
                    y = y + Sudoku[j][i];
                }
                if(x!=45||y!=45)
                {
                    Results[test_case-1]=0;
                }
            }
            if(Results[test_case-1]!=0)
            {
                for(int i = 0; i<9;i=i+3)
                {
                    for(int j=0; j<9; j=j+3)
                    {
                        int x=0;
                        for(int k = i; k<i+3; k++)
                        {
                            for(int l = j; l<j+3; l++)
                            {
                                x = x+Sudoku[k][l];
                            }
                        }
                        if(x!=45)
                        {
                            Results[test_case-1]=0;
                            break;
                        }
                    }
                }
            }
        }
        for(int test_case =1; test_case<=T; test_case++)
        {
            System.out.println("#"+test_case+" "+Results[test_case-1]);
        }
    }
}
