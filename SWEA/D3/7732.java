import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            int[] now = new int[3];
            int[] pro = new int[3];
            for (int i = 0; i < 2; i++) {
                String time = sc.next();
                StringTokenizer st = new StringTokenizer(time, ":");
                for (int j = 0; j < 3; j++) {
                    if (i == 0) {
                        now[j] = Integer.parseInt(st.nextToken());
                    }
                    else {
                        pro[j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            int tmp = 0;
            if (pro[2] >= now[2]) {
                pro[2] = pro[2] - now[2];
            } else {
                pro[2] = 60 + pro[2] - now[2];
                tmp = -1;
            }

            if (pro[1] >= now[1]) {
                pro[1] = pro[1] - now[1]+tmp;
                tmp=0;
                if(pro[1]<0)
                {
                    pro[1]=pro[1]+60;
                    tmp = -1;
                }
            } else {
                pro[1] = 60 + pro[1] - now[1]+tmp;
                tmp = -1;
            }

            if (pro[0] >= now[0]) {
                pro[0] = pro[0] - now[0]+tmp;
                if(pro[0]<0) {
                    pro[0]=pro[0]+24;
                }
            } else {
                pro[0] = 24 + pro[0] - now[0]+tmp;
            }
            System.out.println("#"+tc+" "+String.format("%02d",pro[0])+":"+String.format("%02d",pro[1])+":"+String.format("%02d",pro[2]));
        }
    }
}