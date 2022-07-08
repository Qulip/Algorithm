import java.util.*;
import java.io.*;

class Brackets{
    static Map<Character,  Character> bracket;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./res/test.txt"));
        bracket = new HashMap<>();
        bracket.put('(',')');
        bracket.put('{','}');
        bracket.put('[',']');
        System.out.println("EX01 : " + solution("(([{(()())}])")+"\n");
        System.out.println("EX01 : " + solution("((((((((((((())))))))))))")+"\n");
        System.out.println("EX02 : " + solution(br.readLine())+"\n");
        System.out.println("EX03 : " + solution("(()))")+"\n");
        System.out.println("EX04 : " + solution("(])")+"\n");
        System.out.println("EX05 : " + solution("(()))")+"\n");
        System.out.println("EX06 : " + solution("(])")+"\n");
        System.out.println("EX06 : " + solution("({{{}})")+"\n");
    }

    static int solution(String str){
        float beforeTime = System.currentTimeMillis();
        int answer;
        int errPoint = findError(str);
        char errBracket = str.charAt(errPoint);
        System.out.println("STRING : "+str);
        System.out.println("ERROR POINT : "+errPoint);
        System.out.println("ERROR BRACKET : "+errBracket);
        System.out.print("Bracket Points : ");
        if(bracket.containsKey(errBracket)){
            answer = openBracket(str, errPoint, errBracket);
        }else{
            answer = closeBracket(str, errPoint, errBracket);
        }

        float afterTime = System.currentTimeMillis();
        float secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("\n시간차이(m) : "+secDiffTime);
        System.out.println("시작시간(m) : "+beforeTime/10000000);
        System.out.println("종료시간(m) : "+afterTime/10000000);
        System.out.println();
        return answer;
    }
    static int openBracket(String str, int errPoint, char errBracket){
        int answer = 0;
        int[] brackets = new int[3];
        char setBracket = bracket.get(errBracket);
        for(int i = errPoint; i<str.length(); i++){
            char now = str.charAt(i);
            int idx = getIdx(now);
            if(now=='(' || now=='{' || now=='[') brackets[idx]++;
            else {
                brackets[idx]--;
                if(brackets[idx]<0) break;
            }

            if(errBracket == now || setBracket == now){
                boolean chk = true;
                for(int j=0; j<3; j++){
                    if(j != idx){
                        if(brackets[j] != 0){
                            chk = false;
                            break;
                        }
                    }
                }
                if(chk){
                    System.out.print(i+" ");
                    answer++;
                }
            }
        }

        return answer;
    }
    static int closeBracket(String str, int errPoint, char errBracket){
        int answer = 0;
        int[] brackets = new int[3];
        char setBracket = errBracket==')' ? '(' : errBracket=='}' ? '{' : ']';
        for(int i = errPoint; i>=0; i--){
            char now = str.charAt(i);
            int idx = getIdx(now);
            if(now=='(' || now=='{' || now=='[') brackets[idx]++;
            else {
                brackets[idx]--;
                if(brackets[idx]>0) break;
            }

            if(errBracket == now || setBracket == now){
                boolean chk = true;
                for(int j=0; j<3; j++){
                    if(j != idx){
                        if(brackets[j] != 0){
                            chk = false;
                            break;
                        }
                    }
                }
                if(chk){
                    System.out.print(i+" ");
                    answer++;
                }
            }
        }

        return answer;
    }
    static int findError(String str){
        Stack<Character> stack = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(bracket.containsKey(c)){
                stack.push(c);
                idx.push(i);
            }else{
                if(stack.size()>0) {
                    char t = stack.pop();
                    int num = idx.pop();
                    if (c != bracket.get(t)) {
                        if(stack.size()>0  && c == bracket.get(stack.pop())) return num;
                        else return i;
                    }
                }else{
                    return i;
                }
            }
        }
        return 0;
    }
    static int getIdx(char now){
        int idx = 0;
        if(now=='{' || now=='}') idx = 1;
        else if (now=='[' || now==']') idx = 2;
        return idx;
    }
}