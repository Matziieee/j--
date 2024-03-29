// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package junit;

import java.io.File;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
import pass.*;

/**
 * JUnit test suite for running the j-- programs in tests/pass.
 */

public class JMinusMinusTestRunner {

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(HelloWorldTest.class);
        suite.addTestSuite(FactorialTest.class);
        suite.addTestSuite(GCDTest.class);
        suite.addTestSuite(SeriesTest.class);
        suite.addTestSuite(ClassesTest.class);
        suite.addTestSuite(DivisionTest.class);
        suite.addTestSuite(RemainderTest.class);
        suite.addTestSuite(BitwiseOrTest.class);
        suite.addTestSuite(BitwiseXorTest.class);
        suite.addTestSuite(BitwiseAndTest.class);
        suite.addTestSuite(UnaryComplementTest.class);
        suite.addTestSuite(UnaryPlusTest.class);
        suite.addTestSuite(MultilineCommentTest.class);
        suite.addTestSuite(ShiftLeftTest.class);
        suite.addTestSuite(ShiftRightTest.class);
        suite.addTestSuite(UnShiftRightTest.class);
        suite.addTestSuite(PrePostOperationsTest.class);
        suite.addTestSuite(AssignmentOperationTest.class);
        suite.addTestSuite(LogicalOrTest.class);
        suite.addTestSuite(InterfaceTest.class);
        suite.addTestSuite(ConditionalExpressionTest.class);
        suite.addTestSuite(InitialisationBlockTest.class);
        suite.addTestSuite(InitialisationBlocksStaticTest.class);
        return suite;
    }

    /**
     * Runs the test suite using the textual runner.
     */

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

}
