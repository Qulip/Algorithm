import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            int[] nums = new int[10];
            int sum = 0;
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int i=0; i<10; i++){
                nums[i] = Integer.parseInt(st.nextToken());
                sum = sum + nums[i];
            }
            Arrays.sort(nums);
            sum = sum-nums[0]-nums[9];
            int result = sum/8;
            if((sum%8)*2>=8){
                result++;
            }
            sb.append("#"+tc+" "+result+'\n');
        }
        System.out.println(sb);
    }
}