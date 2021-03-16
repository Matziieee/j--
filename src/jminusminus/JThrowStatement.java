package jminusminus;

import static jminusminus.CLConstants.*;

class JThrowStatement extends JStatement{

    // The expression to throw
    private JExpression throwEx;

    // AST for throw statement
    public JThrowStatement(int line, JExpression throwEx){
        super(line);
        this.throwEx = throwEx;
    }

    public JStatement analyze(Context context) {
        // Implement later
        return this;
    }


    public void codegen(CLEmitter output) {
        // Implement later
    }

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JThrowStatement line=\"%d\">\n", line());
        p.indentRight();
        throwEx.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JThrowStatement>\n");
    }

}