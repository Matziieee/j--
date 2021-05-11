package jminusminus;
import static jminusminus.CLConstants.*;

public class JTernaryExpression extends JExpression {
    private JExpression condition;
    private JExpression expr1, expr2;


    public JTernaryExpression(int line, JExpression condition, JExpression expr1, JExpression expr2) {
        super(line);
        this.condition = condition;
        this.expr1 = expr1;
        this.expr2 = expr2;

    }

    public JExpression analyze(Context context){
        condition = condition.analyze(context);
        condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        expr1.analyze(context);
        expr2.analyze(context);
        expr1.type().mustMatchExpected(line(), expr2.type());
        type = expr1.type();
        return this;
    }

    public void writeToStdOut(jminusminus.PrettyPrinter p){
        p.printf("<JConditionalExpression>\n");
        p.indentRight();
        p.printf("<Condition>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Condition>\n");
        p.print("<Expressions>\n");
        p.indentRight();
        expr1.writeToStdOut(p);
        expr2.writeToStdOut(p);
        p.indentLeft();
        p.print("</Expressions>\n");
        p.indentLeft();
        p.printf("</JConditionalExpression>\n");
    };

    public void codegen(CLEmitter emitter){
        String endLabel = emitter.createLabel();
        String elseLabel = emitter.createLabel();
        condition.codegen(emitter, elseLabel, false);
        expr1.codegen(emitter);
        emitter.addBranchInstruction(GOTO, endLabel);
        emitter.addLabel(elseLabel);
        expr2.codegen(emitter);
        emitter.addLabel(endLabel);
    }
}
