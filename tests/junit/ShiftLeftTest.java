package junit;

import junit.framework.TestCase;
import pass.ShiftLeft;

public class ShiftLeftTest extends TestCase{
  private ShiftLeft shiftLeft;
  
  protected void setUp() throws Exception{
    super.setUp();
    shiftLeft = new ShiftLeft();
  }
  
  protected void tearDown() throws Exception{
    super.tearDown();
  }
  
  public void testShiftLeft(){
    this.assertEquals(shiftLeft.shiftLeft(1010<<1),0101);
    this.assertEquals(shiftLeft.shiftLeft(1010<<2),1010);
    this.assertEquals(shiftLeft.shiftLeft(10101100<<1),01011001);
  }
}
    
