package pass;

import java.lang.System; 

public class InitialisationBlocksStatic {


    public static int x;
    int someInteger;
    int otherInteger;

    public InitialisationBlocksStatic(int number){
        someInteger = number;
    }

    
    static {
        x = 10;

    }

    public int z;




    public static void main(String[] args){


        System.out.println(x);
    }
}
