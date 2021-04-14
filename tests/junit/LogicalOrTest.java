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
        this.assertEquals(logicalOr.or(true, false),false);
        this.assertEquals(logicalOr.or(false, false),false);
        this.assertEquals(logicalOr.or(true, true),true);
    }
}
