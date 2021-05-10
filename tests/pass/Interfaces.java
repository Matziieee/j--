package pass;

public interface Interfaces {
    public int mustIncludeThis();
}


public class ImplementingClass implements Interfaces {
    public int mustIncludeThis(){
        return 2;
    }
    
}