import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[][][] Results = new int[T][][];
        int[] Amounts = new int[T];
        ArrayList<Integer> temp = new ArrayList<>();

        for(int test_case=1; test_case<=T; test_case++)
        {
            Amounts[test_case-1] = sc.nextInt();
            Results[test_case-1] = new int[Amounts[test_case-1]][Amounts[test_case-1]];
            for(int i=0; i<Amounts[test_case-1];i++)
            {
                for(int j=0; j<Amounts[test_case-1];j++)
                {
                    Results[test_case-1][i][j]=sc.nextInt();
                }
            }
            for(int i=0; i<Amounts[test_case-1];i++)
            {
                int A=0,B=0,C = 0;
                for(int j=0; j<Amounts[test_case-1]; j++)
                {
                    A = A + Results[test_case-1][j][i]*(int)Math.pow(10,j);
                    B = B + Results[test_case - 1][Amounts[test_case - 1] - i - 1][j]*(int)Math.pow(10,j);
                    C = C + Results[test_case - 1][j][Amounts[test_case - 1] - i - 1] * (int)Math.pow(10,Amounts[test_case-1]-j-1);
                }
                temp.add(A);
                temp.add(B);
                temp.add(C);
            }
            for(int i=0; i<Amounts[test_case-1];i++)
            {
                for(int j=0; j<3;j++)
                {
                    Results[test_case - 1][i][j] = temp.get(i*3+j);
                }
            }
            temp.clear();
        }
        for(int test_case=1; test_case<=T; test_case++)
        {
            System.out.println("#"+test_case);
            for(int i=0; i<Amounts[test_case-1];i++)
            {
                for(int j=0; j<3;j++)
                {
                    switch (Amounts[test_case-1])
                    {
                        case 3:
                            System.out.print(String.format("%03d",Results[test_case-1][i][j])+" ");
                            break;
                        case 4:
                            System.out.print(String.format("%04d",Results[test_case-1][i][j])+" ");
                            break;
                        case 5:
                            System.out.print(String.format("%05d",Results[test_case-1][i][j])+" ");
                            break;
                        case 6:
                            System.out.print(String.format("%06d",Results[test_case-1][i][j])+" ");
                            break;
                        case 7:
                            System.out.print(String.format("%07d",Results[test_case-1][i][j])+" ");
                            break;
                    }

                }
                System.out.println();
            }

        }
    }
}
