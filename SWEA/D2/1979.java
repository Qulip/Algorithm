import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[][] Numbers = new int[16][16];
        int[] Results = new int[T];

        for(int a=0; a<15;a++)
        {
            for(int b = 0; b<15; b++)
            {
                Numbers[a][b] = -1;
            }
        }
        for(int test_case = 1; test_case<=T; test_case++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int i = 0; i<x; i++)
            {
                for(int j=0; j<x; j++)
                {
                    Numbers[i][j] = sc.nextInt();
                }
            }

            int flag = 1;
            Results[test_case-1]=0;
            for(int i=0; i<x; i++)
            {
                for(int j=0;j<x-y+1;j++)
                {
                     if(Numbers[i][j]==1)
                     {
                         flag=1;
                         if(j==0)
                         {
                             if(Numbers[i][y]==1)
                             {
                                 flag=0;
                             }
                             else
                             {
                                 for (int k = 0; k < y; k++)
                                 {
                                     if (Numbers[i][k] <= 0)
                                     {
                                         flag = 0;
                                     }
                                 }
                             }
                         }
                         else
                         {
                             if(Numbers[i][j+y]==1)
                             {
                                 flag=0;
                             }
                             else if(Numbers[i][j-1]==1)
                             {
                                 flag = 0;
                             }
                             else
                             {
                                 for(int k = j; k<j+y;k++)
                                 {
                                     if(Numbers[i][k]<=0)
                                     {
                                         flag=0;
                                     }
                                 }
                             }
                         }
                         if(flag==1)
                         {
                             Results[test_case-1]++;
                         }
                     }
                    if(Numbers[j][i]==1)
                    {
                        flag=1;
                        if(j==0)
                        {
                            if(Numbers[y][i]==1)
                            {
                                flag=0;
                            }
                            else
                            {
                                for (int k = 0; k < y; k++)
                                {
                                    if (Numbers[k][i] <= 0)
                                    {
                                        flag = 0;
                                    }
                                }
                            }
                        }
                        else
                        {
                            if(Numbers[j+y][i]==1)
                            {
                                flag=0;
                            }
                            else if(Numbers[j-1][i]==1)
                            {
                                flag = 0;
                            }
                            else
                            {
                                for(int k = j; k<j+y;k++)
                                {
                                    if(Numbers[k][i]<=0)
                                    {
                                        flag=0;
                                    }
                                }
                            }
                        }
                        if(flag==1)
                        {
                            Results[test_case-1]++;
                        }

                    }
                }
            }
        }

        for(int test_case=1; test_case<=T; test_case++)
        {
            System.out.println("#"+test_case+" "+Results[test_case-1]);
        }
    }
}
