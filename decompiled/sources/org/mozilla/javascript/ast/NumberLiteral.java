package org.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes10.dex */
public class NumberLiteral extends AstNode {
    private double number;
    private String value;

    public NumberLiteral() {
        this.type = 40;
    }

    public NumberLiteral(int i) {
        super(i);
        this.type = 40;
    }

    public NumberLiteral(int i, int i2) {
        super(i, i2);
        this.type = 40;
    }

    public NumberLiteral(int i, String str) {
        super(i);
        this.type = 40;
        setValue(str);
        setLength(str.length());
    }

    public NumberLiteral(int i, String str, double d2) {
        this(i, str);
        setDouble(d2);
    }

    public NumberLiteral(double d2) {
        this.type = 40;
        setDouble(d2);
        setValue(Double.toString(d2));
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        assertNotNull(str);
        this.value = str;
    }

    public double getNumber() {
        return this.number;
    }

    public void setNumber(double d2) {
        this.number = d2;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sbAppend = new StringBuilder().append(makeIndent(i));
        String str = this.value;
        if (str == null) {
            str = "<null>";
        }
        return sbAppend.append(str).toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
