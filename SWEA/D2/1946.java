import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        String temp;
        char[] words;
        for(int i=1; i<=tc; i++){
            int time=0;
            temp = Integer.toString(i);
            words = temp.toCharArray();
            for(int j=0; j<words.length; j++){
                if(words[j]=='3'||words[j]=='6'||words[j]=='9'){
                    time++;
                }
            }
            if(time>0){
                for(int j=0; j<time; j++){
                    sb.append("-");
                }
            }else{
                sb.append(temp);
            }
            sb.append(" ");
        }
        System.out.print(sb);
    }
}