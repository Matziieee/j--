package junit;

import junit.framework.TestCase;

import pass.Interfaces;
import pass.ImplementingClass;

public class InterfaceTest extends TestCase{

    
    private Interfaces inter;

    protected void setUp() throws Exception{
        super.setUp();
        inter =  new ImplementingClass();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testImplements() {
        this.assertEquals(inter.mustIncludeThis(),2);
    }
    
}
