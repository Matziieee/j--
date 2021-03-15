package junit;

import junit.framework.TestCase;
import pass.BitwiseXor;

public class BitwiseXorTest extends TestCase {

    private BitwiseXor bitwiseXor;

    protected void setUp() throws Exception{
        super.setUp();
        bitwiseXor =  new BitwiseXor();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testBitXor() {
        this.assertEquals(bitwiseXor.xor(16, 7),23);
        this.assertEquals(bitwiseXor.xor(2, 103),101);
        this.assertEquals(bitwiseXor.xor(20, 12),24);
    }
}