package junit;

import junit.framework.TestCase;
import pass.MultilineComment;

public class MultilineCommentTest extends TestCase {

    private MultilineComment multilineComment;

    protected void setUp() throws Exception{
        super.setUp();
        multilineComment =  new MultilineComment();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void testBitOr() {
        this.assertTrue(multilineComment.pass());
    }
}