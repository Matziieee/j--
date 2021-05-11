package junit;

import junit.framework.TestCase;
import pass.AssignmentOperations;

public class AssignmentOperationTest extends TestCase {

    private AssignmentOperations aOps;

    protected void setUp() throws Exception{
        super.setUp();
        aOps =  new AssignmentOperations();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testAssignmentOperations() {
        this.assertEquals(aOps.plus(5, 3),8);
        this.assertEquals(aOps.plus(5, -3),2);
        this.assertEquals(aOps.plus(-25, 13),-12);
        this.assertEquals(aOps.minus(5, 3), 2);
        this.assertEquals(aOps.minus(5, -3),8);
        this.assertEquals(aOps.minus(-25, 13),-38);
        this.assertEquals(aOps.star(5, 3),15);
        this.assertEquals(aOps.star(5, -3),-15);
        this.assertEquals(aOps.star(-25, 13),-325);
        this.assertEquals(aOps.div(6, 3),2);
        this.assertEquals(aOps.div(6, -3),-2);
        this.assertEquals(aOps.div(25, 13),1);
        this.assertEquals(aOps.rem(7, 2), 1);
        this.assertEquals(aOps.rem(11, 3), 2);
        this.assertEquals(aOps.rem(2137, 2000), 137);




    }
}
