package pass;

import java.lang.System;

public class UnaryPlus {
    public int uPlus(int x){
        return +x;
    }

    public static void main(String[] args){
        int a = +10;
        int b = -10;
        System.out.println("a should be 10 and is : " + a);
        System.out.println("b should be -10 and is : " + b);
    }
}
