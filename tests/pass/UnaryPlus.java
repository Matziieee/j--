package pass;

import java.lang.System;

public class UnaryPlus {
    public int uPlus(int x){
        return +x;
    }

    public static void main(String[] args){
        int result = +(10*-1);
        System.out.println("+ (10*-1) = " + result);
    }
}
