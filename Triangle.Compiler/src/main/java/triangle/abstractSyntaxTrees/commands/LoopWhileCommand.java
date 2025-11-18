package triangle.abstractSyntaxTrees.commands;

import triangle.abstractSyntaxTrees.expressions.Expression;
import triangle.abstractSyntaxTrees.visitors.CommandVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

public class LoopWhileCommand extends Command {

    public Command C1;
    public Expression E;
    public Command C2;

    public LoopWhileCommand(Command c1AST, Expression eAST, Command c2AST, SourcePosition pos) {
        super(pos);
        C1 = c1AST;
        E = eAST;
        C2 = c2AST;
    }

    public <TArg, TResult> TResult visit(CommandVisitor<TArg, TResult> v, TArg arg) {
        return v.visitLoopWhileCommand(this, arg);
    }
}