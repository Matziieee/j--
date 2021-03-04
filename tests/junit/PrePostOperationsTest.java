package junit;

import junit.framework.TestCase;
import pass.PrePostOperations;

public class PrePostOperationsTest extends TestCase {

    private PrePostOperations prePostOperations;

    protected void setUp() throws Exception{
        super.setUp();
        prePostOperations =  new PrePostOperations();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testPreAndPost() {
        this.assertEquals(prePostOperations.postIncrease(5),6);
        this.assertEquals(prePostOperations.preDecrease(10),9);
    }
}
