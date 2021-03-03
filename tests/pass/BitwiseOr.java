package pass;


import java.lang.System;

public class BitwiseOr {
    public int or(int x, int y){
        return x | y;
    }

    public static void main(String[] args){
        int res = 12 | 5;
        System.out.println("12 | 5 = " + res);
    }
    
}
