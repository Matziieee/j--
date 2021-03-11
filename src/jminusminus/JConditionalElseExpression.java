package jminusminus;

public class JConditionalElseExpression extends JExpression{

    private JStatement lhs;
    private JStatement rhs;

    public JConditionalElseExpression(int line, JExpression lhs, JExpression rhs) {
        super(line);
        this.lhs = lhs;
        this.rhs = rhs;
    }

public JExpression analyze(Context context){
    return this;
}

public void writeToStdOut(jminusminus.PrettyPrinter p){
    p.printf("<Then>\n");
    p.indentRight();
    lhs.writeToStdOut(p);
    p.indentLeft();
    p.printf("</Then>\n");
    p.printf("<Else>\n");
    p.indentRight();
    rhs.writeToStdOut(p);
    p.indentLeft();
    p.printf("</Else>\n");
};

public void codegen(CLEmitter emitter){

}
}