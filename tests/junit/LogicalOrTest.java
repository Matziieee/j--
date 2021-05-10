package junit;

import pass.LogicalOr;
import junit.framework.TestCase;


public class LogicalOrTest extends TestCase{

    private LogicalOr logicalOr;

    protected void setUp() throws Exception{
        super.setUp();
        logicalOr = new LogicalOr();
    }
    
    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testOr() {
        this.assertEquals(true, logicalOr.or(false, true));
        this.assertEquals(true, logicalOr.or(true, false));
        this.assertEquals(false, logicalOr.or(false, false));
        this.assertEquals(true,logicalOr.or(true, true));
    }
}
