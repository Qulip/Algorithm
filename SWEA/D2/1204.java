import java.io.*;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            int[] time = new int[101];
            int num = Integer.parseInt(input.readLine());
            int i=0;
            while(i<1000){
                StringTokenizer st = new StringTokenizer(input.readLine());
                while(st.hasMoreTokens()){
                    int temp = Integer.parseInt(st.nextToken());
                    time[temp]++;
                    i++;
                }
            }
            int result=0;
            num=0;
            for(int j=0;j<time.length; j++){
                if(num<=time[j]){
                    num=time[j];
                    result=j;
                }
            }
            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.println(sb);
    }
}
