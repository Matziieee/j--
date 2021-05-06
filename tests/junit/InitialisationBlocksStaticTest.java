package junit;

import junit.framework.TestCase;
import pass.InitialisationBlocksStatic;

public class InitialisationBlocksStaticTest extends TestCase {

    private InitialisationBlocksStatic initBlock;

    protected void setUp() throws Exception{
        super.setUp();
        initBlock = new InitialisationBlocksStatic(21);
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testInitBlocksStatic() {
        this.assertEquals(InitialisationBlocksStatic.x, 10);
        
    }
}
