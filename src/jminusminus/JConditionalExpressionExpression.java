package jminusminus;

public class JConditionalExpressionExpression extends JExpression{

    private JExpression lhs;
    private JExpression rhs;

    public JConditionalExpressionExpression(int line, JExpression lhs, JExpression rhs) {
        super(line);
        this.lhs = lhs;
        this.rhs = rhs;
    }

public JExpression analyze(Context context){
    lhs = (JExpression) lhs.analyze(context);
    rhs = (JExpression) rhs.analyze(context);
    if(rhs.type() != lhs.type()){
        JAST.compilationUnit.reportSemanticError(line(),
                    "right hand and left hand MUST have same type, found " + rhs.type() + " and " + lhs.type());
        type = Type.ANY;
    }
    else{
        type = rhs.type();
    }
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