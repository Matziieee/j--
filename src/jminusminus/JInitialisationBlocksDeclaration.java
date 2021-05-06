package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;


/**
 * Empty Class that should be used for creation of initialisation blocks
 * @param line
 * @param mods
 * @param body
    */  

public class JInitialisationBlocksDeclaration extends JMethodDeclaration implements JMember {

    /** Defining class */
    JClassDeclaration definingClass;

    public JInitialisationBlocksDeclaration(int line, ArrayList<String> mods, JBlock body)
    {
        // TODO: make sure that everything is in order here
        // super(line, mods, "Initialisation block" + Integer.toString(line), Type.VOID, new ArrayList<JFormalParameter>(), body); 
        super(line, mods, "Initialisation block" + Integer.toString(line), Type.VOID, new ArrayList<JFormalParameter>(), body); 
    }
    
    public void preAnalyze(Context context, CLEmitter partial) {
        super.preAnalyze(context, partial);
        if (isAbstract) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Initialisation block cannot be declared abstract");
        }
        // Generate the method with an empty body (for now)
        // NOTE: from method, not constructor, might be wrong
        // partialCodegen(context, partial);
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

        // Probably here might be the place to init the variables

        // // Declare the parameters. We consider a formal parameter 
        // // to be always initialized, via a function call.
        // for (JFormalParameter param : params) {
        //     LocalVariableDefn defn = new LocalVariableDefn(param.type(), 
        //         this.context.nextOffset());
        //     defn.initialize();
        //     this.context.addEntry(param.line(), param.name(), defn);
        // }
        if (body != null) {
            body = body.analyze(this.context);
        }
        return this;
    }

    public void partialCodegen(Context context, CLEmitter partial) {
        // Generate a method with an empty body; need a return to
        // make the class verifier happy.
        partial.addMethod(mods, name, descriptor, null, false);


        // Add implicit RETURN
        partial.addNoArgInstruction(RETURN);
    }

    public void codegen(CLEmitter output) {
        // output.addMethod(mods, "<init>", descriptor, null, false);

        // And then the body
        body.codegen(output);
        output.addNoArgInstruction(RETURN);
    }


    public void writeToStdOut(PrettyPrinter p){
        p.printf("<JInitialisationBlockDeclaration line=\"%d\" " + "name=\"%s\">\n",
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
        p.println("</JInitialisationBlockDeclaration>");
    }

}
