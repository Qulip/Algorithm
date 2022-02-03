import java.util.Scanner;

public class Solution {
    static int result;
    static int[] field;

    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            int x = sc.nextInt();
            field = new int[x];
            result = 0;
            NQueen(x,0);
            sb.append("#"+tc+" "+result);
            System.out.println(sb);
        }
    }

    public static void NQueen(int x, int pos) {
        boolean posok;
        if(pos == x)
        {
            result++;
            return;
        }
        for (int i = 0; i < x; i++) {
            posok = true;
            for(int j=0; j<pos; j++)
            {
                if(field[j]==i||i==field[j]+(pos-j)||i==field[j]-(pos-j))   //아래 직선, 우대각, 좌대각에 있는지 확인
                {
                    posok=false;
                    break;
                }
            }
            if(posok)
            {
                field[pos] = i;
                NQueen(x,pos+1);
            }
        }
    }
}
