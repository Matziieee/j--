package pass;


import java.lang.System;

public class BitwiseAnd {
    public int and(int x, int y){
        return x & y;
    }

    public static void main(String[] args){
        int res = 5 & 3;
        System.out.println("5 & 3 = " + res);
    }
    
}

