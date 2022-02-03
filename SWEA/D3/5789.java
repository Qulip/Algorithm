import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc = 1; tc<=T; tc++)
        {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            int[] List = new int[N];
            for(int i=0; i<Q; i++)
            {
                int L = sc.nextInt();
                int R = sc.nextInt();
                for(int j = L-1; j<=R-1;j++)
                {
                    List[j]=i+1;
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<N; i++)
            {
                System.out.print(List[i]+" ");
            }
            System.out.println();
        }
    }
}
