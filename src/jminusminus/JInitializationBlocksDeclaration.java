package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;


/**
 * Empty Class that should be used for creation of Initialization blocks
 * @param line
 * @param mods
 * @param body
    */  

public class JInitializationBlocksDeclaration extends JMethodDeclaration implements JMember {

    /** Defining class */
    JClassDeclaration definingClass;

    public JInitializationBlocksDeclaration(int line, ArrayList<String> mods, JBlock body)
    {
        // TODO: make sure that everything is in order here
        // super(line, mods, "Initialization block" + Integer.toString(line), Type.VOID, new ArrayList<JFormalParameter>(), body); 
        super(line, mods, "Initialization block" + Integer.toString(line), Type.VOID, new ArrayList<JFormalParameter>(), body); 
    }
    
    public void preAnalyze(Context context, CLEmitter partial) {
        super.preAnalyze(context, partial);
        if (isAbstract) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Initialization block cannot be declared abstract");
        }
        if (isPrivate) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Initialization block cannot be declared private");
        }
        if (mods.contains("public")) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Initialization block cannot be declared public");
        }
        if (mods.contains("protected")) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Initialization block cannot be declared protected");
        }

    }

    public JAST analyze(Context context) {
        definingClass = (JClassDeclaration) (context.classContext()
                                                    .definition());
        MethodContext methodContext = new MethodContext(context,
                                                        isStatic,
                                                        returnType);
        this.context = methodContext;

        if (!isStatic) {
            // Offset 0 is used to address "this".
            this.context.nextOffset();
        }
        if (body != null) {
            body = body.analyze(this.context);
        }
        return this;
    }

    public void partialCodegen(Context context, CLEmitter partial) {

    }

    public void codegen(CLEmitter output) {

    }


    public void writeToStdOut(PrettyPrinter p){
        p.printf("<JInitializationBlockDeclaration line=\"%d\" " + "name=\"%s\">\n",
                line(), name);
        p.indentRight();
        if (context != null) {
            context.writeToStdOut(p);
        }
        if (mods != null) {
            p.println("<Modifiers>");
            p.indentRight();
            for (String mod : mods) {
                p.printf("<Modifier name=\"%s\"/>\n", mod);
            }
            p.indentLeft();
            p.println("</Modifiers>");
        }
        if (body != null) {
            p.println("<Body>");
            p.indentRight();
            body.writeToStdOut(p);
            p.indentLeft();
            p.println("</Body>");
        }
        p.indentLeft();
        p.println("</JInitializationBlockDeclaration>");
    }

}
