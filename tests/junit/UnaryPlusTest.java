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
        this.assertEquals(unaryPlus.uPlus(-5),5);
        this.assertEquals(unaryPlus.uPlus(-10),10);
        this.assertEquals(unaryPlus.uPlus(1),1);
    }
}
