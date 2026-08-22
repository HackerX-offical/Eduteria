package org.mozilla.javascript.ast;

import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class XmlElemRef extends XmlRef {
    private AstNode indexExpr;
    private int lb;
    private int rb;

    public XmlElemRef() {
        this.lb = -1;
        this.rb = -1;
        this.type = 78;
    }

    public XmlElemRef(int i) {
        super(i);
        this.lb = -1;
        this.rb = -1;
        this.type = 78;
    }

    public XmlElemRef(int i, int i2) {
        super(i, i2);
        this.lb = -1;
        this.rb = -1;
        this.type = 78;
    }

    public AstNode getExpression() {
        return this.indexExpr;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.indexExpr = astNode;
        astNode.setParent(this);
    }

    public int getLb() {
        return this.lb;
    }

    public void setLb(int i) {
        this.lb = i;
    }

    public int getRb() {
        return this.rb;
    }

    public void setRb(int i) {
        this.rb = i;
    }

    public void setBrackets(int i, int i2) {
        this.lb = i;
        this.rb = i2;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (isAttributeAccess()) {
            sb.append("@");
        }
        if (this.namespace != null) {
            sb.append(this.namespace.toSource(0));
            sb.append("::");
        }
        sb.append(Constants.AES_PREFIX);
        sb.append(this.indexExpr.toSource(0));
        sb.append(Constants.AES_SUFFIX);
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            if (this.namespace != null) {
                this.namespace.visit(nodeVisitor);
            }
            this.indexExpr.visit(nodeVisitor);
        }
    }
}
