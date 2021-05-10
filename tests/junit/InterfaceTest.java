package junit;

import junit.framework.TestCase;

import pass.ImplementingClass;

public class InterfaceTest extends TestCase{

    
    private ImplementingClass imp;

    protected void setUp() throws Exception{
        super.setUp();
        imp =  new ImplementingClass();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testImplements() {
        this.assertEquals(imp.mustIncludeThis(),2);
    }
    
}
