import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] prices = new int[n];
            int temp = 0;
            while(temp<n){
                StringTokenizer st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    prices[temp] = Integer.parseInt(st.nextToken());
                    temp++;
                }
            }
            int nums = 0;
            long money = 0;
            long profit = 0;
            int i = n-1;
            while(i>0){
                //System.out.println("1st "+i);
                int iprice = prices[i];
                int iday = i;
                if(iprice<=prices[i-1]){
                    i--;
                    continue;
                }
                while(iprice>prices[i-1]){
                    //System.out.println("2nd "+i);
                    i--;
                    if(i<=0){
                        break;
                    }
                }
                if(i>=0){
                    for(int j=i; j<iday; j++){
                        money=money+prices[j];
                        nums++;
                        //System.out.println(money+" "+prices[j]);
                    }
                    profit = profit + ((long) iprice *nums) - money;
                }
                nums = 0;
                money = 0;
            }
            sb.append("#"+tc+" "+profit+"\n");
        }
        System.out.println(sb);
    }
}
