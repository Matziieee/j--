package jminusminus;

import static jminusminus.CLConstants.*;

class JLiteralDouble extends JExpression{

    // String representation of double
    private String text;

    public JLiteralDouble(int line, String text){
        super(line);
        this.text = text;
    }

    // Analyze and codegen for doubles
    public JExpression analyze(Context context){
        // Implement later
        return this;
    }

    public void codegen(CLEmitter output){
        // Implement later
    }

    // Print to stdout
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JLiteralDouble line=\"%d\" type=\"%s\" " + "value=\"%s\"/>\n",
                line(), ((type == null) ? "" : type.toString()), text);
    }

}