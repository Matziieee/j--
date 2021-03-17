package pass;

import java.lang.System; 

public class InitialisationBlocksStatic {


    static int x;
    int otherInteger;


    static {
        x = 10;

    }

    public int z;




    public static void main(String[] args){


        System.out.println(x);
    }
}
