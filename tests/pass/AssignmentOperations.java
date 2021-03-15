package pass;


import java.lang.System;

public class AssignmentOperations {
    public int plus(int x, int y){
        x += y;
        return x;
    }
    // public int star(int x, int y){
    //     x *= y;
    //     return x;
    // }
    // public int minus(int x, int y){
    //     x -= y;
    //     return x;
    // }
    // public int div(int x, int y){
    //     x /= y;
    //     return x;
    // }

    public static void main(String[] args){
        int res = 6;
        // int res2 = 6;
        // int res3 = 6;
        // int res4 = 6;

        res += 2;
        // res2 *= 2;
        // res3 -= 2;
        // res4 /= 2;

        System.out.println("6 += 2" + res);
        // System.out.println("6 *= 2" + res2);
        // System.out.println("6 -= 2" + res3);
        // System.out.println("6 /= 2" + res4);
    }
    
}
