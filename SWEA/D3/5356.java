import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc =1; tc<=T; tc++)
        {
            char[][] AllWords = new char[5][15];
            for(int i=0; i<5; i++)
            {
                String Word = sc.next();
                char[] temp = Word.toCharArray();
                for(int j = 0; j<temp.length; j++)
                {
                    AllWords[i][j]=temp[j];
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<15;i++)
            {
                for(int j=0; j<5;j++)
                {
                    if(AllWords[j][i]==0) {
                        continue;
                    }
                    System.out.print(AllWords[j][i]);
                }
            }
            System.out.println();
        }
    }
}
