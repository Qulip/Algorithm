import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=T; tc++) {
            int result = 0;
            int day = sc.nextInt();
            int hour = sc.nextInt();
            int min = sc.nextInt();

            result = min-11+(hour-11)*60+(day-(11))*24*60;
            if(result>=0) {
                sb.append("#"+tc+" "+result+"\n");
            } else {
                sb.append("#"+tc+" -1"+"\n");
            }
        }
        System.out.print(sb);
    }
}
