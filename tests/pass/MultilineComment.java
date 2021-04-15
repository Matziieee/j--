package pass;

import java.lang.System; 

public class MultilineComment {
    public boolean pass(){
        /*
        mmumbl 
        return false;
        */
        return true;
    }


    public static void main(String[] args){

        /*
        // Error if not commented
        System.out.println("Multiline comments does not work!");
        Totally wrong statement that would give you syntax error if not commented out

        */

        System.out.println("Nicely done");
    }
}
