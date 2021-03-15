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

    public void assignmentOperationsTest() {
        this.assertEquals(aOps.plus(5, 3),8);
        this.assertEquals(aOps.plus(5, -3),2);
        this.assertEquals(aOps.plus(-25, 13),-12);
        this.assertEquals(aOps.minus(5, 3),2);
        this.assertEquals(aOps.minus(5, -3),8);
        this.assertEquals(aOps.minus(-25, 13),-38);
        this.assertEquals(aOps.star(5, 3),15);
        this.assertEquals(aOps.star(5, -3),-15);
        this.assertEquals(aOps.star(-25, 13),-325);
        this.assertEquals(aOps.div(6, 3),2);
        this.assertEquals(aOps.div(6, -3),-2);
        this.assertEquals(aOps.div(25, 13),1);


    }
}
