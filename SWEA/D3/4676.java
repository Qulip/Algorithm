import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc = 1; tc<=T; tc++)
        {
            LinkedList<Character> Words = new LinkedList<>();
            String Letter = sc.next();
            char[] temp = Letter.toCharArray();
            for(int i = 0; i<temp.length; i++)
            {
                Words.add(temp[i]);
            }
            int H = sc.nextInt();
            int[] x = new int[H];
            for(int i=0; i<H; i++)
            {
                x[i] = sc.nextInt();
            }
            Arrays.sort(x);
            for(int i=x.length-1;i>=0;i--)
            {
                if(x[i]==0)
                {
                    Words.addFirst('-');
                }
                else
                {
                    Words.add(x[i],'-');
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<Words.size(); i++)
            {
                System.out.print(Words.get(i));
            }
            System.out.println();
        }
    }
}
