package pass;


import java.lang.System;

public class PrePostOperations {
    public int preIncrease(int x){
        ++x;
        return x;
    }
    public int postIncrease(int x){
        x++;
        return x;
    }

    public int preDecrease(int x){
        --x;
        return x;
    }

    public int postDecrease(int x){
        x--;
        return x;
    }


    public static void main(String[] args){
        int x = 4;
        System.out.print("--4 -> Expected: 3 Actual: " + --x );

        x = 4;
        System.out.print("4++ -> Expected: 4 Actual: " + x++ );
        System.out.print("4++ part 2 -> Expected: 5 Actual: " + x );

    }
    
}

