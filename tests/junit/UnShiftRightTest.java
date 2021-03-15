package junit;

import junit.framework.TestCase;
import pass.UnShiftRight;

public class UnShiftRightTest extends TestCase{
    private UnShiftRight unShiftRight;

    protected void setUp() throws Exception{
        super.setUp();
        unShiftRight = new UnShiftRight();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testUnShiftRight(){
        this.assertEquals(unShiftRight.unShiftRight(5,2),1);
        this.assertEquals(unShiftRight.unShiftRight(-5,2),1073741822);
        this.assertEquals(unShiftRight.unShiftRight(3,2),0);
    }

}