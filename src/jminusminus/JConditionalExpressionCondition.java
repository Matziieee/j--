package jminusminus;
import static jminusminus.CLConstants.*;

public class JConditionalExpressionCondition extends JExpression{

        /** Test expression. */
    private JExpression condition;

        /** Then clause. */
    private JExpression expr;

    public JConditionalExpressionCondition(int line, JExpression condition, JExpression expr) {
        super(line);
        this.condition = condition;
        this.expr = expr;
    }

    public JExpression analyze(Context context){

        condition = condition.analyze(context);
        condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        expr.analyze(context);
        type = expr.type();
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
        expr.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JConditionalExpression>\n");
    };

    public void codegen(CLEmitter emitter){
        JConditionalExpressionExpression expression = (JConditionalExpressionExpression) expr;
        String endLabel = emitter.createLabel();
        String elseLabel = emitter.createLabel();
        condition.codegen(emitter, elseLabel, false);
        expression.codegenThen(emitter);
        emitter.addBranchInstruction(GOTO, endLabel);
        emitter.addLabel(elseLabel);
        expression.codegenElse(emitter);
        emitter.addLabel(endLabel);
    }
}