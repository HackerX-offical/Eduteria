package org.mozilla.javascript.ast;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AstNode extends Node implements Comparable<AstNode> {
    private static Map<Integer, String> operatorNames;
    protected int length;
    protected AstNode parent;
    protected int position;

    public abstract String toSource(int i);

    public abstract void visit(NodeVisitor nodeVisitor);

    static {
        HashMap map = new HashMap();
        operatorNames = map;
        map.put(52, "in");
        operatorNames.put(32, "typeof");
        operatorNames.put(53, "instanceof");
        operatorNames.put(31, "delete");
        operatorNames.put(90, Constants.SEPARATOR_COMMA);
        operatorNames.put(104, ":");
        operatorNames.put(105, "||");
        operatorNames.put(106, "&&");
        operatorNames.put(107, "++");
        operatorNames.put(108, "--");
        operatorNames.put(9, "|");
        operatorNames.put(10, "^");
        operatorNames.put(11, "&");
        operatorNames.put(12, "==");
        operatorNames.put(13, "!=");
        operatorNames.put(14, "<");
        operatorNames.put(16, ">");
        operatorNames.put(15, "<=");
        operatorNames.put(17, ">=");
        operatorNames.put(18, "<<");
        operatorNames.put(19, ">>");
        operatorNames.put(20, ">>>");
        operatorNames.put(21, MqttTopic.SINGLE_LEVEL_WILDCARD);
        operatorNames.put(22, "-");
        operatorNames.put(23, "*");
        operatorNames.put(24, MqttTopic.TOPIC_LEVEL_SEPARATOR);
        operatorNames.put(25, "%");
        operatorNames.put(26, "!");
        operatorNames.put(27, "~");
        operatorNames.put(28, MqttTopic.SINGLE_LEVEL_WILDCARD);
        operatorNames.put(29, "-");
        operatorNames.put(46, "===");
        operatorNames.put(47, "!==");
        operatorNames.put(91, "=");
        operatorNames.put(92, "|=");
        operatorNames.put(94, "&=");
        operatorNames.put(95, "<<=");
        operatorNames.put(96, ">>=");
        operatorNames.put(97, ">>>=");
        operatorNames.put(98, "+=");
        operatorNames.put(99, "-=");
        operatorNames.put(100, "*=");
        operatorNames.put(101, "/=");
        operatorNames.put(102, "%=");
        operatorNames.put(93, "^=");
        operatorNames.put(127, "void");
    }

    public static class PositionComparator implements Comparator<AstNode>, Serializable {
        private static final long serialVersionUID = 1;

        @Override // java.util.Comparator
        public int compare(AstNode astNode, AstNode astNode2) {
            return astNode.position - astNode2.position;
        }
    }

    public AstNode() {
        super(-1);
        this.position = -1;
        this.length = 1;
    }

    public AstNode(int i) {
        this();
        this.position = i;
    }

    public AstNode(int i, int i2) {
        this();
        this.position = i;
        this.length = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getAbsolutePosition() {
        int position = this.position;
        for (AstNode parent = this.parent; parent != null; parent = parent.getParent()) {
            position += parent.getPosition();
        }
        return position;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setBounds(int i, int i2) {
        setPosition(i);
        setLength(i2 - i);
    }

    public void setRelative(int i) {
        this.position -= i;
    }

    public AstNode getParent() {
        return this.parent;
    }

    public void setParent(AstNode astNode) {
        AstNode astNode2 = this.parent;
        if (astNode == astNode2) {
            return;
        }
        if (astNode2 != null) {
            setRelative(-astNode2.getPosition());
        }
        this.parent = astNode;
        if (astNode != null) {
            setRelative(astNode.getPosition());
        }
    }

    public void addChild(AstNode astNode) {
        assertNotNull(astNode);
        setLength((astNode.getPosition() + astNode.getLength()) - getPosition());
        addChildToBack(astNode);
        astNode.setParent(this);
    }

    public AstRoot getAstRoot() {
        AstNode parent = this;
        while (parent != null && !(parent instanceof AstRoot)) {
            parent = parent.getParent();
        }
        return (AstRoot) parent;
    }

    public String toSource() {
        return toSource(0);
    }

    public String makeIndent(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public String shortName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(InstructionFileId.DOT) + 1);
    }

    public static String operatorToString(int i) {
        String str = operatorNames.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Invalid operator: " + i);
    }

    @Override // org.mozilla.javascript.Node
    public boolean hasSideEffects() {
        int type = getType();
        if (type == 30 || type == 31 || type == 37 || type == 38 || type == 50 || type == 51 || type == 56 || type == 57 || type == 82 || type == 83 || type == 107 || type == 108) {
            return true;
        }
        switch (type) {
            case -1:
            case 35:
            case 65:
            case 73:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 130:
            case 131:
            case 132:
            case 133:
            case 135:
            case 136:
            case 140:
            case 141:
            case 142:
            case 143:
            case 154:
            case 155:
            case 159:
            case 160:
                return true;
            default:
                switch (type) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        return true;
                    default:
                        switch (type) {
                            case 69:
                            case 70:
                            case 71:
                                return true;
                            default:
                                switch (type) {
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    protected void assertNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("arg cannot be null");
        }
    }

    protected <T extends AstNode> void printList(List<T> list, StringBuilder sb) {
        int size = list.size();
        int i = 0;
        for (T t : list) {
            sb.append(t.toSource(0));
            int i2 = i + 1;
            if (i < size - 1) {
                sb.append(", ");
            } else if (t instanceof EmptyExpression) {
                sb.append(Constants.SEPARATOR_COMMA);
            }
            i = i2;
        }
    }

    public static RuntimeException codeBug() throws RuntimeException {
        throw Kit.codeBug();
    }

    public FunctionNode getEnclosingFunction() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof FunctionNode)) {
            parent = parent.getParent();
        }
        return (FunctionNode) parent;
    }

    public Scope getEnclosingScope() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof Scope)) {
            parent = parent.getParent();
        }
        return (Scope) parent;
    }

    @Override // java.lang.Comparable
    public int compareTo(AstNode astNode) {
        if (equals(astNode)) {
            return 0;
        }
        int absolutePosition = getAbsolutePosition();
        int absolutePosition2 = astNode.getAbsolutePosition();
        if (absolutePosition < absolutePosition2) {
            return -1;
        }
        if (absolutePosition2 < absolutePosition) {
            return 1;
        }
        int length = getLength();
        int length2 = astNode.getLength();
        if (length < length2) {
            return -1;
        }
        if (length2 < length) {
            return 1;
        }
        return hashCode() - astNode.hashCode();
    }

    public int depth() {
        AstNode astNode = this.parent;
        if (astNode == null) {
            return 0;
        }
        return astNode.depth() + 1;
    }

    protected static class DebugPrintVisitor implements NodeVisitor {
        private static final int DEBUG_INDENT = 2;
        private StringBuilder buffer;

        public DebugPrintVisitor(StringBuilder sb) {
            this.buffer = sb;
        }

        public String toString() {
            return this.buffer.toString();
        }

        private String makeIndent(int i) {
            int i2 = i * 2;
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        @Override // org.mozilla.javascript.ast.NodeVisitor
        public boolean visit(AstNode astNode) {
            int type = astNode.getType();
            String strTypeToName = Token.typeToName(type);
            this.buffer.append(astNode.getAbsolutePosition()).append("\t");
            this.buffer.append(makeIndent(astNode.depth()));
            this.buffer.append(strTypeToName).append(" ");
            this.buffer.append(astNode.getPosition()).append(" ");
            this.buffer.append(astNode.getLength());
            if (type == 39) {
                this.buffer.append(" ").append(((Name) astNode).getIdentifier());
            }
            this.buffer.append("\n");
            return true;
        }
    }

    @Override // org.mozilla.javascript.Node
    public int getLineno() {
        if (this.lineno != -1) {
            return this.lineno;
        }
        AstNode astNode = this.parent;
        if (astNode != null) {
            return astNode.getLineno();
        }
        return -1;
    }

    public String debugPrint() {
        DebugPrintVisitor debugPrintVisitor = new DebugPrintVisitor(new StringBuilder(1000));
        visit(debugPrintVisitor);
        return debugPrintVisitor.toString();
    }
}
