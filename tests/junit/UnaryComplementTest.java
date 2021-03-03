package junit;

import junit.framework.TestCase;
import pass.UnaryComplement;

public class UnaryComplementTest extends TestCase {

    private UnaryComplement unaryComplement;

    protected void setUp() throws Exception{
        super.setUp();
        unaryComplement =  new UnaryComplement();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testBitAnd() {
        this.assertEquals(unaryComplement.reverse(5), -6);
        this.assertEquals(unaryComplement.reverse(10), -11);
        this.assertEquals(unaryComplement.reverse(20), -21);
        this.assertEquals(unaryComplement.reverse(-20), 19);
    }
}
