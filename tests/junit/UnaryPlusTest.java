package junit;

import junit.framework.TestCase;
import pass.UnaryPlus;

public class UnaryPlusTest extends TestCase{
    
    private UnaryPlus unaryPlus;

    protected void setUp() throws Exception{
        super.setUp();
        unaryPlus =  new UnaryPlus();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testBitAnd() {
        this.assertEquals(5, unaryPlus.uPlus(-5));
        this.assertEquals(10, unaryPlus.uPlus(-10));
        this.assertEquals(1,unaryPlus.uPlus(1));
    }
}
