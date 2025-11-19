package triangle.optimiser;

import triangle.abstractSyntaxTrees.Program;
import triangle.abstractSyntaxTrees.commands.*;
import triangle.abstractSyntaxTrees.expressions.*;
import triangle.abstractSyntaxTrees.declarations.*;
import triangle.abstractSyntaxTrees.types.TypeDeclaration;
import triangle.abstractSyntaxTrees.visitors.CommandVisitor;
import triangle.abstractSyntaxTrees.visitors.ExpressionVisitor;
import triangle.abstractSyntaxTrees.visitors.ProgramVisitor;
import triangle.abstractSyntaxTrees.visitors.DeclarationVisitor;
import triangle.abstractSyntaxTrees.formals.*;
import triangle.abstractSyntaxTrees.visitors.FormalParameterVisitor;

public class StatCounter implements CommandVisitor<Void, Void>, ExpressionVisitor<Void, Void>,
        ProgramVisitor<Void, Void>, DeclarationVisitor<Void, Void>, FormalParameterVisitor<Void, Void> {

    private int intCount = 0;
    private int charCount = 0;

    public int getIntegerExpressionCount() {
        return intCount;
    }

    public int getCharacterExpressionCount() {
        return charCount;
    }


    // Program Visitor
    @Override
    public Void visitProgram(Program ast, Void arg) {
        if (ast.C != null)
            ast.C.visit(this, null);
        return null;
    }

    // Expression Visitors
    @Override
    public Void visitIntegerExpression(IntegerExpression ast, Void arg) {
        intCount++;
        return null;
    }

    @Override
    public Void visitCharacterExpression(CharacterExpression ast, Void arg) {
        charCount++;
        return null;
    }

    @Override
    public Void visitBinaryExpression(BinaryExpression ast, Void arg) {
        if (ast.E1 != null) ast.E1.visit(this, null);
        if (ast.E2 != null) ast.E2.visit(this, null);
        return null;
    }

    @Override
    public Void visitUnaryExpression(UnaryExpression ast, Void arg) {
        if (ast.E != null) ast.E.visit(this, null);
        return null;
    }

    @Override
    public Void visitIfExpression(IfExpression ast, Void arg) {
        if (ast.E1 != null) ast.E1.visit(this, null);
        if (ast.E2 != null) ast.E2.visit(this, null);
        if (ast.E3 != null) ast.E3.visit(this, null);
        return null;
    }

    @Override
    public Void visitLetExpression(LetExpression ast, Void arg) {
        if (ast.D != null) ast.D.visit(this, null);
        if (ast.E != null) ast.E.visit(this, null);
        return null;
    }

    @Override public Void visitCallExpression(CallExpression ast, Void arg) { return null; }
    @Override public Void visitEmptyExpression(EmptyExpression ast, Void arg) { return null; }
    @Override public Void visitVnameExpression(VnameExpression ast, Void arg) { return null; }
    @Override public Void visitArrayExpression(ArrayExpression ast, Void arg) { return null; }
    @Override public Void visitRecordExpression(RecordExpression ast, Void arg) { return null; }


    // Command Visitors
    @Override
    public Void visitAssignCommand(AssignCommand ast, Void arg) {
        if (ast.E != null) ast.E.visit(this, null);
        return null;
    }

    @Override
    public Void visitSequentialCommand(SequentialCommand ast, Void arg) {
        if (ast.C1 != null) ast.C1.visit(this, null);
        if (ast.C2 != null) ast.C2.visit(this, null);
        return null;
    }

    @Override
    public Void visitIfCommand(IfCommand ast, Void arg) {
        if (ast.E != null) ast.E.visit(this, null);
        if (ast.C1 != null) ast.C1.visit(this, null);
        if (ast.C2 != null) ast.C2.visit(this, null);
        return null;
    }

    @Override
    public Void visitWhileCommand(WhileCommand ast, Void arg) {
        if (ast.E != null) ast.E.visit(this, null);
        if (ast.C != null) ast.C.visit(this, null);
        return null;
    }

    @Override
    public Void visitLoopWhileCommand(LoopWhileCommand ast, Void arg) {
        if (ast.C1 != null) ast.C1.visit(this, null);
        if (ast.E != null) ast.E.visit(this, null);
        if (ast.C2 != null) ast.C2.visit(this, null);
        return null;
    }

    @Override
    public Void visitLetCommand(LetCommand ast, Void arg) {
        if (ast.C != null) ast.C.visit(this, null);
        return null;
    }

    @Override public Void visitCallCommand(CallCommand ast, Void arg) { return null; }
    @Override public Void visitEmptyCommand(EmptyCommand ast, Void arg) { return null; }


    // Declaration Visitors
    @Override
    public Void visitConstDeclaration(ConstDeclaration ast, Void arg) {
        if (ast.E != null) ast.E.visit(this, null);
        return null;
    }

    @Override public Void visitVarDeclaration(VarDeclaration ast, Void arg) { return null; }

    @Override
    public Void visitFuncDeclaration(FuncDeclaration ast, Void arg) {
        if (ast.E != null) ast.E.visit(this, null);
        return null;
    }

    @Override
    public Void visitProcDeclaration(ProcDeclaration ast, Void arg) {
        if (ast.C != null) ast.C.visit(this, null);
        return null;
    }

    @Override
    public Void visitSequentialDeclaration(SequentialDeclaration ast, Void arg) {
        if (ast.D1 != null) ast.D1.visit(this, null);
        if (ast.D2 != null) ast.D2.visit(this, null);
        return null;
    }

    @Override public Void visitTypeDeclaration(TypeDeclaration ast, Void arg) { return null; }
    @Override public Void visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Void arg) { return null; }
    @Override public Void visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Void arg) { return null; }

    // Parameter Visitors
    @Override public Void visitConstFormalParameter(ConstFormalParameter ast, Void arg) { return null; }
    @Override public Void visitFuncFormalParameter(FuncFormalParameter ast, Void arg) { return null; }
    @Override public Void visitProcFormalParameter(ProcFormalParameter ast, Void arg) { return null; }
    @Override public Void visitVarFormalParameter(VarFormalParameter ast, Void arg) { return null; }
}