package beak11651;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        Point[] points = new Point[T];
        int x,y;
        for(int i =0; i<T; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x,y);
        }
        Arrays.sort(points);
        for(int i=0; i<points.length; i++){
            sb.append(points[i]);
        }
        System.out.print(sb);
    }
}
class Point implements Comparable<Point>{
    private int x;
    private int y;
    Point(){
        x=0;
        y=0;
    }
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int compareTo(Point b){
        if(this.y-b.getY()!=0){
            return this.y-b.getY();
        }else {
            return this.x-b.getX();
        }
    }
    public String toString(){
        return this.x+" "+this.y+"\n";
    }
}