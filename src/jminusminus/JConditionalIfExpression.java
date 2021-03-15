package jminusminus;

public class JConditionalIfExpression extends JExpression{

        /** Test expression. */
    private JExpression condition;

        /** Then clause. */
    private JStatement expr;

    public JConditionalIfExpression(int line, JExpression condition, JExpression expr) {
        super(line);
        this.condition = condition;
        this.expr = expr;
    }

    public JExpression analyze(Context context){
        type = Type.INT;
        return this;
    }

    public void writeToStdOut(jminusminus.PrettyPrinter p){
        p.printf("<JConditionalIfExpression>\n");
        p.indentRight();
        p.printf("<Condition>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Condition>\n");
        expr.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JConditionalIfExpression>\n");
    };

    public void codegen(CLEmitter emitter){

    }
}