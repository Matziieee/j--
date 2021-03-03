package pass;


import java.lang.System;

public class UnaryComplement {
    public int reverse(int x){
        return ~x;
    }

    public static void main(String[] args){
        int res = ~5;
        System.out.println("~5 = " + res);
    }
    
}

