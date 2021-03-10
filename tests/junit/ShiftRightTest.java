package junit;

import junit.framework.TestCase;
import pass.ShiftRight;

public class ShiftRightTest extends TestCase{
    private ShiftRight shiftRight;

    protected void setUp() throws Exception{
        super.setUp();
        shiftRight = new ShiftRight();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testShiftRight(){
        this.assertEquals(shiftRight.shiftRight(1101,2),1110);
        this.assertEquals(shiftRight.shiftRight(1100,3),1001);
        this.assertEquals(shiftRight.shiftRight(10110011,1),110110011);
    }


}