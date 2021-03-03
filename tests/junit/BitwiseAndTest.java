package junit;

import junit.framework.TestCase;
import pass.BitwiseAnd;

public class BitwiseAndTest extends TestCase {

    private BitwiseAnd bitwiseAnd;

    protected void setUp() throws Exception{
        super.setUp();
        bitwiseAnd =  new BitwiseAnd();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testBitAnd() {
        this.assertEquals(bitwiseAnd.and(5, 3),1);
        this.assertEquals(bitwiseAnd.and(10, 6),2);
        this.assertEquals(bitwiseAnd.and(20, 12),4);
    }
}
