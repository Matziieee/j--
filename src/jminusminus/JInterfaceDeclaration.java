package jminusminus;

import java.util.ArrayList;

import com.sun.jdi.Method;

import static jminusminus.CLConstants.*;

class JInterfaceDeclaration extends JAST implements JTypeDecl{
    /** Class modifiers. */
    private ArrayList<String> mods;

    /** Class name. */
    private String name;

    /** Class block. */
    private ArrayList<JMember> interfaceBlock;

    /** Super class type. */
    private Type superType;

    /** This class type. */
    private Type thisType;

    /** Context for this class. */
    private ClassContext context;

    /** Whether this class has an explicit constructor. */
    private boolean hasExplicitConstructor;

    public JInterfaceDeclaration(int line, ArrayList<String> mods, String name, Type superType, ArrayList<JMember> interfaceBlock) {
        super(line);
        this.mods = mods;
        this.name = name;
        this.superType = superType;
        this.interfaceBlock = interfaceBlock;
        hasExplicitConstructor = false;
    }

    public void declareThisType(Context context) {
        String qualifiedName = JAST.compilationUnit.packageName() == "" ? name
                : JAST.compilationUnit.packageName() + "/" + name;
        CLEmitter partial = new CLEmitter(false);
        partial.addClass(mods, qualifiedName, Type.OBJECT.jvmName(), null,
                false); // Object for superClass, just for now
        thisType = Type.typeFor(partial.toClass());
        context.addType(line, thisType);
    }

    /**
     * Returns the class name.
     * 
     * @return the class name.
     */

    public String name() {
        return name;
    }

    /**
     * Returns the class' super class type.
     * 
     * @return the super class type.
     */

    public Type superType() {
        return superType;
    }

    /**
     * Returns the type that this class declaration defines.
     * 
     * @return the defined type.
     */

    public Type thisType() {
        return thisType;
    }
    
    /**
     * Pre-analyzes the members of this declaration in the parent context.
     * Pre-analysis extends to the member headers (including method headers) but
     * not into the bodies.
     * 
     * @param context
     *            the parent (compilation unit) context.
     */
    public void preAnalyze(Context context) {
        this.context = new ClassContext(this,context);

        superType = superType.resolve(this.context);

        thisType.checkAccess(line,superType);
        if (superType.isFinal()) {
            JAST.compilationUnit.reportSemanticError(line,
                    "Cannot extend a final type: %s", superType.toString());
        }

         // Create the (partial) class
         CLEmitter partial = new CLEmitter(false);

         // Add the class header to the partial class
         String qualifiedName = JAST.compilationUnit.packageName() == "" ? name
                 : JAST.compilationUnit.packageName() + "/" + name;
         partial.addClass(mods, qualifiedName, superType.jvmName(), null, false);
 
         // Pre-analyze the members and add them to the partial
         // class
         for (JMember member : interfaceBlock) {
             //Begin hack
             if(member instanceof JMethodDeclaration){
                JMethodDeclaration method = (JMethodDeclaration) member;
                method.isInInterface = true;
             }
             //End hack
             member.preAnalyze(this.context, partial);
             if (member instanceof JConstructorDeclaration
                     && ((JConstructorDeclaration) member).params.size() == 0) {
                    JAST.compilationUnit.reportSemanticError(line,
                        "Interfaces can't have constructors", superType.toString());
             }
         }
 
         // Add the implicit empty constructor?
         if (!hasExplicitConstructor) {
             //codegenPartialImplicitConstructor(partial);
         }
 
         // Get the Class rep for the (partial) class and make it
         // the
         // representation for this type
         Type id = this.context.lookupType(name);
         if (id != null && !JAST.compilationUnit.errorHasOccurred()) {
             id.setClassRep(partial.toClass());
         }
    }

    /**
     * Performs semantic analysis on the class and all of its members within the
     * given context. Analysis includes field initializations and the method
     * bodies.
     * 
     * @param context
     *            the parent (compilation unit) context. Ignored here.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JAST analyze(Context context) {
        //analyze all members
        for (JMember member : interfaceBlock) {
            ((JAST) member).analyze(this.context);
        }
        //Ensure that there are only methods
        for (JMember member : interfaceBlock) {
            if (member instanceof JFieldDeclaration) {
                JAST.compilationUnit.reportSemanticError(line,
                "Interfaces can't have fields", superType.toString());
            }
            if(member instanceof JMethodDeclaration){
                JMethodDeclaration method = (JMethodDeclaration) member;
                if(method.body != null){
                    JAST.compilationUnit.reportSemanticError(line,
                    "Methods in interfaces cant have bodies", superType.toString());
                }
            }

        }
        return this;
    }

    /**
     * Generates code for the class declaration.
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
        String qualifiedName = JAST.compilationUnit.packageName() == "" ? name
        : JAST.compilationUnit.packageName() + "/" + name;
        output.addClass(mods, qualifiedName, superType.jvmName(), null, false);

        ArrayList<String> mods = new ArrayList<String>();
        mods.add("public");
        output.addMethod(mods, "<init>", "()V", null, false);
        output.addNoArgInstruction(ALOAD_0);
        output.addMemberAccessInstruction(INVOKESPECIAL, superType.jvmName(),
                "<init>", "()V");

        // Return
        output.addNoArgInstruction(RETURN);
    }

    /**
     * {@inheritDoc}
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JInterfaceDeclaration line=\"%d\" name=\"%s\""
                + " super=\"%s\">\n", line(), name, superType.toString());
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
        if (interfaceBlock != null) {
            p.println("<InterfaceBlock>");
            p.indentRight();
            for (JMember member : interfaceBlock) {
                ((JAST) member).writeToStdOut(p);
            }
            p.indentLeft();
            p.println("</InterfaceBlock>");
        }
        p.indentLeft();
        p.println("</JInterfaceDeclaration>");
    }

}
