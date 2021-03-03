package junit;

import junit.framework.TestCase;
import pass.BitwiseOr;

public class BitwiseOrTest extends TestCase {

    private BitwiseOr bitwiseOr;

    protected void setUp() throws Exception{
        super.setUp();
        bitwiseOr =  new BitwiseOr();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testBitOr() {
        this.assertEquals(bitwiseOr.or(16, 7),23);
        this.assertEquals(bitwiseOr.or(2, 103),103);
        this.assertEquals(bitwiseOr.or(20, 12),28);
    }
}
