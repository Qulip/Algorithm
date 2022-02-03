import java.util.Scanner;

public class Solution {
    static int Temp = 0;
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int Results;

        for(int test_case = 1; test_case<=T; test_case++)
        {
            int x = sc.nextInt();
            Results = 1;
            for(int i = 1; i<=x/2; i++)
            {
                Adding(i,x);
                if(Temp==x)
                {
                    Results++;
                }
                Temp = 0;
            }
            System.out.println("#"+test_case+" "+Results);
        }
    }
    public static void Adding(int x, int y)
    {
        Temp = Temp+x;
        if(y>Temp)
        {
            Adding(x+1, y);
        }
    }
}

/*
다른 사람의 해답

import java.util.Scanner;

public class Solution {
    static int div, cnt, N, sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            div = 2;    //나누기
            cnt = 1;    //정답 갯수
            sum = 1;    //수에 따라 큰 값에서 빼야하는 양

            while ((N - sum)/div >= 1){     //만약 빼고 남은 값이 나누어 지면
                if((N - sum)%div != 0) {    //안나누어 떨어지면
                    sum += div;             //빼야할값에 나눌값 더하기
                    div++;                  //다음 나눌값 설정
                    continue;               //while 복귀
                }
                else {                      //나누어 진다면
                    sum += div;             //위 동일
                    div++;                  //위 동일
                    cnt++;                  //정답이므로 갯수 추가
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}

*/