package pass;

import java.lang.System; 

public class BitwiseXor {
    public int xor(int x, int y){
        return x ^ y;
    }

    public static void main(String[] args){
        int res = 12 ^ 20;
        System.out.println("10 ^ 3 = " + res);
    }
}
