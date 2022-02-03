package swea7964;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            int city = sc.nextInt();
            int limit = sc.nextInt();
            int result=0;
            boolean[] map = new boolean[limit];
            int loc=0;
            for(int i=0; i<city; i++){
                int move = -1;
                int temp = sc.nextInt();
                if(temp == 1){
                    map[loc]=true;
                }else{
                    map[loc]=false;
                }
                loc++;
                if(loc==limit||i==city-1){
                    for(int j=0; j<loc;j++){
                        if(map[j]){
                            move=j;
                        }
                    }
                    if(move==-1){
                        result++;
                        loc=0;
                    }else{
                        for(int j=0; j<limit-move-1; j++){
                            map[j]=map[move+1];
                        }
                        loc = limit-move-1;
                    }
                }
            }
            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.print(sb);
    }
}
/*
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            int city = sc.nextInt();
            int limit = sc.nextInt();
            int result=0;
            boolean[] map = new boolean[city+1];
            map[0]=true;
            for(int i=0; i<city; i++){
                int temp = sc.nextInt();
                if(temp ==1){
                    map[i+1]=true;
                }
            }
            int loc=0;
            while(loc<city){
                int move = 0;
                for(int i=1; i<=limit;i++){
                    if(loc+i==city+1){
                        break;
                    }
                    if(map[loc+i]){
                        move=i;
                    }
                }
                if(move==0){
                    result++;
                    loc=loc+limit;
                }else {
                    loc=loc+move;
                }
            }
            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.print(sb);
    }
}
 */