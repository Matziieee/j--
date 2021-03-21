package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;


/**
 * Empty Class that should be used for creation of initialisation blocks
 * @param line
 * @param mods
 * @param body
    */  

public class JInitialisationBlocksDeclaration extends JAST implements JMember {

    public JInitialisationBlocksDeclaration(int line, ArrayList<String> mods, JBlock body)
    {
        super(line);
        // this.mods = mods;
        // this.body = body;
        // this.isAbstract = mods.contains("abstract");
        // this.isStatic = mods.contains("static");
        // this.isPrivate = mods.contains("private");
    }
    
    public void preAnalyze(Context context, CLEmitter partial) {

    }

    public JAST analyze(Context context) {
        return null;
    }

    public void writeToStdOut(PrettyPrinter p){

    }

    public void codegen(CLEmitter output) {
        // for (JStatement statement : statements) {
        //     statement.codegen(output);
        // }
    }

}
