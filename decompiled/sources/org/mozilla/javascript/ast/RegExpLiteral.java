package org.mozilla.javascript.ast;

import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes10.dex */
public class RegExpLiteral extends AstNode {
    private String flags;
    private String value;

    public RegExpLiteral() {
        this.type = 48;
    }

    public RegExpLiteral(int i) {
        super(i);
        this.type = 48;
    }

    public RegExpLiteral(int i, int i2) {
        super(i, i2);
        this.type = 48;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        assertNotNull(str);
        this.value = str;
    }

    public String getFlags() {
        return this.flags;
    }

    public void setFlags(String str) {
        this.flags = str;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sbAppend = new StringBuilder().append(makeIndent(i)).append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(this.value).append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        String str = this.flags;
        if (str == null) {
            str = "";
        }
        return sbAppend.append(str).toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
