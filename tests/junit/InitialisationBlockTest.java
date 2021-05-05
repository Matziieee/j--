package junit;

import junit.framework.TestCase;
import pass.InitialisationBlocks;

public class InitialisationBlockTest extends TestCase {

    private InitialisationBlocks initBlock;

    protected void setUp() throws Exception{
        super.setUp();
        initBlock =  new InitialisationBlocks(21);
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testInitBlocks() {
        this.assertEquals(initBlock.otherInteger, 10);
        
    }
}
