package junit;

import pass.ConditionalExpression;
import junit.framework.TestCase;

public class ConditionalExpressionTest extends TestCase {
    private ConditionalExpression condExp;

    protected void setUp() throws Exception{
        super.setUp();
        condExp =  new ConditionalExpression();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testCondExpression() {
        this.assertEquals(condExp.conditional(true, 1, 2),1);
        this.assertEquals(condExp.conditional(false, 1, 2),2);
    }
}
