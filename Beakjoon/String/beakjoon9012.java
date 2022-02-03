package beak9012;
//https://www.acmicpc.net/problem/9012

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int T = Integer.parseInt(br.readLine());
      for(int tc = 0; tc<T; tc++){
          String temp = br.readLine();
          char[] vps = temp.toCharArray();
          if(vps.length%2==1){//||vps[0]==')'||vps[vps.length-1]=='('
              sb.append("NO\n");
          }else{
              int bracket = 0;
              boolean chk = true;
              for(int i=0; i<vps.length; i++){
                  if(vps[i]=='('){
                      bracket++;
                  }else{
                      bracket--;
                  }
                  if(bracket<0){
                      chk = false;
                      break;
                  }
              }
              if(chk&&bracket==0){
                  sb.append("YES\n");
              } else {
                  sb.append("NO\n");
              }
          }
      }
      System.out.println(sb);
    }
}
