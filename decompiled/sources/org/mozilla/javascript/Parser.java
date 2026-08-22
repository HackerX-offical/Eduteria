package org.mozilla.javascript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.ArrayComprehension;
import org.mozilla.javascript.ast.ArrayLiteral;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.BreakStatement;
import org.mozilla.javascript.ast.CatchClause;
import org.mozilla.javascript.ast.Comment;
import org.mozilla.javascript.ast.ConditionalExpression;
import org.mozilla.javascript.ast.ContinueStatement;
import org.mozilla.javascript.ast.DestructuringForm;
import org.mozilla.javascript.ast.DoLoop;
import org.mozilla.javascript.ast.ElementGet;
import org.mozilla.javascript.ast.EmptyExpression;
import org.mozilla.javascript.ast.EmptyStatement;
import org.mozilla.javascript.ast.ErrorNode;
import org.mozilla.javascript.ast.ExpressionStatement;
import org.mozilla.javascript.ast.ForInLoop;
import org.mozilla.javascript.ast.ForLoop;
import org.mozilla.javascript.ast.FunctionCall;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.GeneratorExpression;
import org.mozilla.javascript.ast.GeneratorExpressionLoop;
import org.mozilla.javascript.ast.IdeErrorReporter;
import org.mozilla.javascript.ast.IfStatement;
import org.mozilla.javascript.ast.InfixExpression;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.KeywordLiteral;
import org.mozilla.javascript.ast.Label;
import org.mozilla.javascript.ast.LabeledStatement;
import org.mozilla.javascript.ast.LetNode;
import org.mozilla.javascript.ast.Loop;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NewExpression;
import org.mozilla.javascript.ast.NumberLiteral;
import org.mozilla.javascript.ast.ObjectLiteral;
import org.mozilla.javascript.ast.ObjectProperty;
import org.mozilla.javascript.ast.ParenthesizedExpression;
import org.mozilla.javascript.ast.PropertyGet;
import org.mozilla.javascript.ast.RegExpLiteral;
import org.mozilla.javascript.ast.ReturnStatement;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.StringLiteral;
import org.mozilla.javascript.ast.SwitchCase;
import org.mozilla.javascript.ast.SwitchStatement;
import org.mozilla.javascript.ast.ThrowStatement;
import org.mozilla.javascript.ast.TryStatement;
import org.mozilla.javascript.ast.UnaryExpression;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;
import org.mozilla.javascript.ast.WhileLoop;
import org.mozilla.javascript.ast.WithStatement;
import org.mozilla.javascript.ast.XmlDotQuery;
import org.mozilla.javascript.ast.XmlElemRef;
import org.mozilla.javascript.ast.XmlExpression;
import org.mozilla.javascript.ast.XmlLiteral;
import org.mozilla.javascript.ast.XmlMemberGet;
import org.mozilla.javascript.ast.XmlPropRef;
import org.mozilla.javascript.ast.XmlRef;
import org.mozilla.javascript.ast.XmlString;
import org.mozilla.javascript.ast.Yield;

/* JADX INFO: loaded from: classes10.dex */
public class Parser {
    public static final int ARGC_LIMIT = 65536;
    static final int CLEAR_TI_MASK = 65535;
    private static final int GET_ENTRY = 2;
    private static final int METHOD_ENTRY = 8;
    private static final int PROP_ENTRY = 1;
    private static final int SET_ENTRY = 4;
    static final int TI_AFTER_EOL = 65536;
    static final int TI_CHECK_LABEL = 131072;
    boolean calledByCompileFunction;
    CompilerEnvirons compilerEnv;
    private int currentFlaggedToken;
    private Comment currentJsDocComment;
    private LabeledStatement currentLabel;
    Scope currentScope;
    ScriptNode currentScriptOrFn;
    private int currentToken;
    private boolean defaultUseStrictDirective;
    private int endFlags;
    private IdeErrorReporter errorCollector;
    private ErrorReporter errorReporter;
    private boolean inDestructuringAssignment;
    private boolean inForInit;
    protected boolean inUseStrictDirective;
    private Map<String, LabeledStatement> labelSet;
    private List<Jump> loopAndSwitchSet;
    private List<Loop> loopSet;
    protected int nestingOfFunction;
    private boolean parseFinished;
    private int prevNameTokenLineno;
    private int prevNameTokenStart;
    private String prevNameTokenString;
    private List<Comment> scannedComments;
    private char[] sourceChars;
    private String sourceURI;
    private int syntaxErrorCount;
    private TokenStream ts;

    private static final boolean nowAllSet(int i, int i2, int i3) {
        return (i & i3) != i3 && (i2 & i3) == i3;
    }

    private static class ParserException extends RuntimeException {
        static final long serialVersionUID = 5882582646773765630L;

        private ParserException() {
        }
    }

    public Parser() {
        this(new CompilerEnvirons());
    }

    public Parser(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    public Parser(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.compilerEnv = compilerEnvirons;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter) errorReporter;
        }
    }

    void addStrictWarning(String str, String str2) {
        int i;
        int i2;
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            i = tokenStream.tokenBeg;
            i2 = this.ts.tokenEnd - this.ts.tokenBeg;
        } else {
            i = -1;
            i2 = -1;
        }
        addStrictWarning(str, str2, i, i2);
    }

    void addStrictWarning(String str, String str2, int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2);
        }
    }

    void addWarning(String str, String str2) {
        int i;
        int i2;
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            i = tokenStream.tokenBeg;
            i2 = this.ts.tokenEnd - this.ts.tokenBeg;
        } else {
            i = -1;
            i2 = -1;
        }
        addWarning(str, str2, i, i2);
    }

    void addWarning(String str, int i, int i2) {
        addWarning(str, null, i, i2);
    }

    void addWarning(String str, String str2, int i, int i2) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, this.ts.getLineno(), this.ts.getLine(), this.ts.getOffset());
        }
    }

    void addError(String str) {
        addError(str, this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
    }

    void addError(String str, int i, int i2) {
        addError(str, null, i, i2);
    }

    void addError(String str, String str2) {
        addError(str, str2, this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
    }

    void addError(String str, int i) {
        addError(str, Character.toString((char) i), this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
    }

    void addError(String str, String str2, int i, int i2) {
        String line;
        int i3;
        int offset;
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i, i2);
            return;
        }
        TokenStream tokenStream = this.ts;
        if (tokenStream == null) {
            line = "";
            i3 = 1;
            offset = 1;
        } else {
            int lineno = tokenStream.getLineno();
            line = this.ts.getLine();
            offset = this.ts.getOffset();
            i3 = lineno;
        }
        this.errorReporter.error(strLookupMessage, this.sourceURI, i3, line, offset);
    }

    private void addStrictWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2, i3, str3, i4);
        }
    }

    private void addWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2, i3, str3, i4);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    private void addError(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.error(strLookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    String lookupMessage(String str) {
        return lookupMessage(str, null);
    }

    String lookupMessage(String str, String str2) {
        if (str2 == null) {
            return ScriptRuntime.getMessage0(str);
        }
        return ScriptRuntime.getMessage1(str, str2);
    }

    void reportError(String str) {
        reportError(str, null);
    }

    void reportError(String str, String str2) {
        TokenStream tokenStream = this.ts;
        if (tokenStream == null) {
            reportError(str, str2, 1, 1);
        } else {
            reportError(str, str2, tokenStream.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
        }
    }

    void reportError(String str, int i, int i2) {
        reportError(str, null, i, i2);
    }

    void reportError(String str, String str2, int i, int i2) {
        addError(str, str2, i, i2);
        if (!this.compilerEnv.recoverFromErrors()) {
            throw new ParserException();
        }
    }

    private int getNodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private void recordComment(int i, String str) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList();
        }
        Comment comment = new Comment(this.ts.tokenBeg, this.ts.getTokenLength(), this.ts.commentType, str);
        if (this.ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            this.currentJsDocComment = comment;
        }
        comment.setLineno(i);
        this.scannedComments.add(comment);
    }

    private Comment getAndResetJsDoc() {
        Comment comment = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return comment;
    }

    private int getNumberOfEols(String str) {
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) == '\n') {
                i++;
            }
        }
        return i;
    }

    private int peekToken() throws IOException {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int lineno = this.ts.getLineno();
        int token = this.ts.getToken();
        boolean z = false;
        while (true) {
            if (token != 1 && token != 162) {
                break;
            }
            if (token == 1) {
                lineno++;
                z = true;
            } else if (this.compilerEnv.isRecordingComments()) {
                String andResetCurrentComment = this.ts.getAndResetCurrentComment();
                recordComment(lineno, andResetCurrentComment);
                lineno += getNumberOfEols(andResetCurrentComment);
            }
            token = this.ts.getToken();
        }
        this.currentToken = token;
        this.currentFlaggedToken = token | (z ? 65536 : 0);
        return token;
    }

    private int peekFlaggedToken() throws IOException {
        peekToken();
        return this.currentFlaggedToken;
    }

    private void consumeToken() {
        this.currentFlaggedToken = 0;
    }

    private int nextToken() throws IOException {
        int iPeekToken = peekToken();
        consumeToken();
        return iPeekToken;
    }

    private int nextFlaggedToken() throws IOException {
        peekToken();
        int i = this.currentFlaggedToken;
        consumeToken();
        return i;
    }

    private boolean matchToken(int i) throws IOException {
        if (peekToken() != i) {
            return false;
        }
        consumeToken();
        return true;
    }

    private int peekTokenOrEOL() throws IOException {
        int iPeekToken = peekToken();
        if ((this.currentFlaggedToken & 65536) != 0) {
            return 1;
        }
        return iPeekToken;
    }

    private boolean mustMatchToken(int i, String str) throws IOException {
        return mustMatchToken(i, str, this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
    }

    private boolean mustMatchToken(int i, String str, int i2, int i3) throws IOException {
        if (matchToken(i)) {
            return true;
        }
        reportError(str, i2, i3);
        return false;
    }

    private void mustHaveXML() {
        if (this.compilerEnv.isXmlAvailable()) {
            return;
        }
        reportError("msg.XML.not.available");
    }

    public boolean eof() {
        return this.ts.eof();
    }

    boolean insideFunction() {
        return this.nestingOfFunction != 0;
    }

    void pushScope(Scope scope) {
        Scope parentScope = scope.getParentScope();
        if (parentScope != null) {
            if (parentScope != this.currentScope) {
                codeBug();
            }
        } else {
            this.currentScope.addChildScope(scope);
        }
        this.currentScope = scope;
    }

    void popScope() {
        this.currentScope = this.currentScope.getParentScope();
    }

    private void enterLoop(Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(loop);
        pushScope(loop);
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null) {
            labeledStatement.setStatement(loop);
            this.currentLabel.getFirstLabel().setLoop(loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }

    private void exitLoop() {
        Loop loopRemove = this.loopSet.remove(r0.size() - 1);
        this.loopAndSwitchSet.remove(r1.size() - 1);
        if (loopRemove.getParent() != null) {
            loopRemove.setRelative(loopRemove.getParent().getPosition());
        }
        popScope();
    }

    private void enterSwitch(SwitchStatement switchStatement) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(switchStatement);
    }

    private void exitSwitch() {
        this.loopAndSwitchSet.remove(r0.size() - 1);
    }

    public AstRoot parse(String str, String str2, int i) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        this.sourceURI = str2;
        if (this.compilerEnv.isIdeMode()) {
            this.sourceChars = str.toCharArray();
        }
        this.ts = new TokenStream(this, null, str, i);
        try {
            try {
                return parse();
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } finally {
            this.parseFinished = true;
        }
    }

    public AstRoot parse(Reader reader, String str, int i) throws IOException {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        if (this.compilerEnv.isIdeMode()) {
            return parse(readFully(reader), str, i);
        }
        try {
            this.sourceURI = str;
            this.ts = new TokenStream(this, reader, null, i);
            return parse();
        } finally {
            this.parseFinished = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.AstRoot parse() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.parse():org.mozilla.javascript.ast.AstRoot");
    }

    private AstNode parseFunctionBody(int i, FunctionNode functionNode) throws IOException {
        boolean z;
        AstNode astNodeFunction;
        if (matchToken(86)) {
            z = false;
        } else if (this.compilerEnv.getLanguageVersion() >= 180 || i == 4) {
            z = true;
        } else {
            reportError("msg.no.brace.body");
            z = false;
        }
        boolean z2 = i == 4;
        this.nestingOfFunction++;
        int i2 = this.ts.tokenBeg;
        Block block = new Block(i2);
        boolean z3 = this.inUseStrictDirective;
        block.setLineno(this.ts.lineno);
        try {
            if (z) {
                AstNode astNodeAssignExpr = assignExpr();
                ReturnStatement returnStatement = new ReturnStatement(astNodeAssignExpr.getPosition(), astNodeAssignExpr.getLength(), astNodeAssignExpr);
                returnStatement.putProp(25, Boolean.TRUE);
                block.putProp(25, Boolean.TRUE);
                if (z2) {
                    returnStatement.putProp(27, Boolean.TRUE);
                }
                block.addStatement(returnStatement);
            } else {
                boolean z4 = true;
                while (true) {
                    int iPeekToken = peekToken();
                    if (iPeekToken == -1 || iPeekToken == 0 || iPeekToken == 87) {
                        break;
                    }
                    if (iPeekToken == 110) {
                        consumeToken();
                        astNodeFunction = function(1);
                    } else {
                        astNodeFunction = statement();
                        if (z4) {
                            String directive = getDirective(astNodeFunction);
                            if (directive == null) {
                                z4 = false;
                            } else if (directive.equals("use strict")) {
                                this.inUseStrictDirective = true;
                                functionNode.setInStrictMode(true);
                                if (!z3) {
                                    setRequiresActivation();
                                }
                            }
                        }
                    }
                    block.addStatement(astNodeFunction);
                }
            }
        } catch (ParserException unused) {
        } catch (Throwable th) {
            this.nestingOfFunction--;
            this.inUseStrictDirective = z3;
            throw th;
        }
        this.nestingOfFunction--;
        this.inUseStrictDirective = z3;
        int i3 = this.ts.tokenEnd;
        getAndResetJsDoc();
        if (!z && mustMatchToken(87, "msg.no.brace.after.body")) {
            i3 = this.ts.tokenEnd;
        }
        block.setLength(i3 - i2);
        return block;
    }

    private String getDirective(AstNode astNode) {
        if (!(astNode instanceof ExpressionStatement)) {
            return null;
        }
        AstNode expression = ((ExpressionStatement) astNode).getExpression();
        if (expression instanceof StringLiteral) {
            return ((StringLiteral) expression).getValue();
        }
        return null;
    }

    private void parseFunctionParams(FunctionNode functionNode) throws IOException {
        if (matchToken(89)) {
            functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
            return;
        }
        HashSet hashSet = new HashSet();
        HashMap map = null;
        do {
            int iPeekToken = peekToken();
            if (iPeekToken == 84 || iPeekToken == 86) {
                AstNode astNodeDestructuringPrimaryExpr = destructuringPrimaryExpr();
                markDestructuring(astNodeDestructuringPrimaryExpr);
                functionNode.addParam(astNodeDestructuringPrimaryExpr);
                if (map == null) {
                    map = new HashMap();
                }
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                map.put(nextTempName, astNodeDestructuringPrimaryExpr);
            } else if (mustMatchToken(39, "msg.no.parm")) {
                AstNode astNodeCreateNameNode = createNameNode();
                Comment andResetJsDoc = getAndResetJsDoc();
                if (andResetJsDoc != null) {
                    astNodeCreateNameNode.setJsDocNode(andResetJsDoc);
                }
                functionNode.addParam(astNodeCreateNameNode);
                String string = this.ts.getString();
                defineSymbol(88, string);
                if (this.inUseStrictDirective) {
                    if ("eval".equals(string) || "arguments".equals(string)) {
                        reportError("msg.bad.id.strict", string);
                    }
                    if (hashSet.contains(string)) {
                        addError("msg.dup.param.strict", string);
                    }
                    hashSet.add(string);
                }
            } else {
                functionNode.addParam(makeErrorNode());
            }
        } while (matchToken(90));
        if (map != null) {
            Node node = new Node(90);
            for (Map.Entry entry : map.entrySet()) {
                node.addChildToBack(createDestructuringAssignment(123, (Node) entry.getValue(), createName((String) entry.getKey())));
            }
            functionNode.putProp(23, node);
        }
        if (mustMatchToken(89, "msg.no.paren.after.parms")) {
            functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
        }
    }

    private FunctionNode function(int i) throws IOException {
        Name nameCreateNameNode;
        int i2 = this.ts.lineno;
        int i3 = this.ts.tokenBeg;
        AstNode astNodeMemberExprTail = null;
        if (matchToken(39)) {
            nameCreateNameNode = createNameNode(true, 39);
            if (this.inUseStrictDirective) {
                String identifier = nameCreateNameNode.getIdentifier();
                if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                    reportError("msg.bad.id.strict", identifier);
                }
            }
            if (!matchToken(88)) {
                if (this.compilerEnv.isAllowMemberExprAsFunctionName()) {
                    astNodeMemberExprTail = memberExprTail(false, nameCreateNameNode);
                    nameCreateNameNode = null;
                }
                mustMatchToken(88, "msg.no.paren.parms");
            }
        } else if (matchToken(88)) {
            nameCreateNameNode = null;
        } else {
            AstNode astNodeMemberExpr = this.compilerEnv.isAllowMemberExprAsFunctionName() ? memberExpr(false) : null;
            mustMatchToken(88, "msg.no.paren.parms");
            astNodeMemberExprTail = astNodeMemberExpr;
            nameCreateNameNode = null;
        }
        int i4 = this.currentToken == 88 ? this.ts.tokenBeg : -1;
        if ((astNodeMemberExprTail != null ? 2 : i) != 2 && nameCreateNameNode != null && nameCreateNameNode.length() > 0) {
            defineSymbol(110, nameCreateNameNode.getIdentifier());
        }
        FunctionNode functionNode = new FunctionNode(i3, nameCreateNameNode);
        functionNode.setFunctionType(i);
        if (i4 != -1) {
            functionNode.setLp(i4 - i3);
        }
        functionNode.setJsDocNode(getAndResetJsDoc());
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            parseFunctionParams(functionNode);
            functionNode.setBody(parseFunctionBody(i, functionNode));
            functionNode.setEncodedSourceBounds(i3, this.ts.tokenEnd);
            functionNode.setLength(this.ts.tokenEnd - i3);
            if (this.compilerEnv.isStrictMode() && !functionNode.getBody().hasConsistentReturnUsage()) {
                addStrictWarning((nameCreateNameNode == null || nameCreateNameNode.length() <= 0) ? "msg.anon.no.return.value" : "msg.no.return.value", nameCreateNameNode == null ? "" : nameCreateNameNode.getIdentifier());
            }
            if (astNodeMemberExprTail != null) {
                Kit.codeBug();
                functionNode.setMemberExprNode(astNodeMemberExprTail);
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i2);
            functionNode.setEndLineno(this.ts.lineno);
            if (this.compilerEnv.isIdeMode()) {
                functionNode.setParentScope(this.currentScope);
            }
            return functionNode;
        } finally {
            perFunctionVariables.restore();
        }
    }

    private AstNode arrowFunction(AstNode astNode) throws IOException {
        int i = this.ts.lineno;
        int position = astNode != null ? astNode.getPosition() : -1;
        FunctionNode functionNode = new FunctionNode(position);
        functionNode.setFunctionType(4);
        functionNode.setJsDocNode(getAndResetJsDoc());
        Map<String, Node> map = new HashMap<>();
        Set<String> hashSet = new HashSet<>();
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            if (astNode instanceof ParenthesizedExpression) {
                functionNode.setParens(0, astNode.getLength());
                AstNode expression = ((ParenthesizedExpression) astNode).getExpression();
                if (!(expression instanceof EmptyExpression)) {
                    arrowFunctionParams(functionNode, expression, map, hashSet);
                }
            } else {
                arrowFunctionParams(functionNode, astNode, map, hashSet);
            }
            if (!map.isEmpty()) {
                Node node = new Node(90);
                for (Map.Entry<String, Node> entry : map.entrySet()) {
                    node.addChildToBack(createDestructuringAssignment(123, entry.getValue(), createName(entry.getKey())));
                }
                functionNode.putProp(23, node);
            }
            functionNode.setBody(parseFunctionBody(4, functionNode));
            functionNode.setEncodedSourceBounds(position, this.ts.tokenEnd);
            functionNode.setLength(this.ts.tokenEnd - position);
            perFunctionVariables.restore();
            if (functionNode.isGenerator()) {
                reportError("msg.arrowfunction.generator");
                return makeErrorNode();
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i);
            functionNode.setEndLineno(this.ts.lineno);
            return functionNode;
        } catch (Throwable th) {
            perFunctionVariables.restore();
            throw th;
        }
    }

    private void arrowFunctionParams(FunctionNode functionNode, AstNode astNode, Map<String, Node> map, Set<String> set) {
        if ((astNode instanceof ArrayLiteral) || (astNode instanceof ObjectLiteral)) {
            markDestructuring(astNode);
            functionNode.addParam(astNode);
            String nextTempName = this.currentScriptOrFn.getNextTempName();
            defineSymbol(88, nextTempName, false);
            map.put(nextTempName, astNode);
            return;
        }
        if ((astNode instanceof InfixExpression) && astNode.getType() == 90) {
            InfixExpression infixExpression = (InfixExpression) astNode;
            arrowFunctionParams(functionNode, infixExpression.getLeft(), map, set);
            arrowFunctionParams(functionNode, infixExpression.getRight(), map, set);
            return;
        }
        if (astNode instanceof Name) {
            functionNode.addParam(astNode);
            String identifier = ((Name) astNode).getIdentifier();
            defineSymbol(88, identifier);
            if (this.inUseStrictDirective) {
                if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (set.contains(identifier)) {
                    addError("msg.dup.param.strict", identifier);
                }
                set.add(identifier);
                return;
            }
            return;
        }
        reportError("msg.no.parm", astNode.getPosition(), astNode.getLength());
        functionNode.addParam(makeErrorNode());
    }

    private AstNode statements(AstNode astNode) throws IOException {
        if (this.currentToken != 86 && !this.compilerEnv.isIdeMode()) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        if (astNode == null) {
            astNode = new Block(i);
        }
        astNode.setLineno(this.ts.lineno);
        while (true) {
            int iPeekToken = peekToken();
            if (iPeekToken <= 0 || iPeekToken == 87) {
                break;
            }
            astNode.addChild(statement());
        }
        astNode.setLength(this.ts.tokenBeg - i);
        return astNode;
    }

    private AstNode statements() throws IOException {
        return statements(null);
    }

    private static class ConditionData {
        AstNode condition;
        int lp;
        int rp;

        private ConditionData() {
            this.lp = -1;
            this.rp = -1;
        }
    }

    private ConditionData condition() throws IOException {
        ConditionData conditionData = new ConditionData();
        if (mustMatchToken(88, "msg.no.paren.cond")) {
            conditionData.lp = this.ts.tokenBeg;
        }
        conditionData.condition = expr();
        if (mustMatchToken(89, "msg.no.paren.after.cond")) {
            conditionData.rp = this.ts.tokenBeg;
        }
        if (conditionData.condition instanceof Assignment) {
            addStrictWarning("msg.equal.as.assign", "", conditionData.condition.getPosition(), conditionData.condition.getLength());
        }
        return conditionData;
    }

    private AstNode statement() throws IOException {
        int iPeekTokenOrEOL;
        int i = this.ts.tokenBeg;
        try {
            AstNode astNodeStatementHelper = statementHelper();
            if (astNodeStatementHelper != null) {
                if (this.compilerEnv.isStrictMode() && !astNodeStatementHelper.hasSideEffects()) {
                    int position = astNodeStatementHelper.getPosition();
                    int iMax = Math.max(position, lineBeginningFor(position));
                    addStrictWarning(astNodeStatementHelper instanceof EmptyStatement ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", iMax, nodeEnd(astNodeStatementHelper) - iMax);
                }
                return astNodeStatementHelper;
            }
        } catch (ParserException unused) {
        }
        do {
            iPeekTokenOrEOL = peekTokenOrEOL();
            consumeToken();
            if (iPeekTokenOrEOL == -1 || iPeekTokenOrEOL == 0 || iPeekTokenOrEOL == 1) {
                break;
            }
        } while (iPeekTokenOrEOL != 83);
        return new EmptyStatement(i, this.ts.tokenBeg - i);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.AstNode statementHelper() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.statementHelper():org.mozilla.javascript.ast.AstNode");
    }

    private void autoInsertSemicolon(AstNode astNode) throws IOException {
        int iPeekFlaggedToken = peekFlaggedToken();
        int position = astNode.getPosition();
        int i = 65535 & iPeekFlaggedToken;
        if (i != -1 && i != 0) {
            if (i == 83) {
                consumeToken();
                astNode.setLength(this.ts.tokenEnd - position);
                return;
            } else if (i != 87) {
                if ((iPeekFlaggedToken & 65536) == 0) {
                    reportError("msg.no.semi.stmt");
                    return;
                } else {
                    warnMissingSemi(position, nodeEnd(astNode));
                    return;
                }
            }
        }
        warnMissingSemi(position, nodeEnd(astNode));
    }

    private IfStatement ifStatement() throws IOException {
        int i;
        AstNode astNodeStatement;
        if (this.currentToken != 113) {
            codeBug();
        }
        consumeToken();
        int i2 = this.ts.tokenBeg;
        int i3 = this.ts.lineno;
        ConditionData conditionDataCondition = condition();
        AstNode astNodeStatement2 = statement();
        if (matchToken(114)) {
            i = this.ts.tokenBeg - i2;
            astNodeStatement = statement();
        } else {
            i = -1;
            astNodeStatement = null;
        }
        IfStatement ifStatement = new IfStatement(i2, getNodeEnd(astNodeStatement != null ? astNodeStatement : astNodeStatement2) - i2);
        ifStatement.setCondition(conditionDataCondition.condition);
        ifStatement.setParens(conditionDataCondition.lp - i2, conditionDataCondition.rp - i2);
        ifStatement.setThenPart(astNodeStatement2);
        ifStatement.setElsePart(astNodeStatement);
        ifStatement.setElsePosition(i);
        ifStatement.setLineno(i3);
        return ifStatement;
    }

    private SwitchStatement switchStatement() throws IOException {
        AstNode astNodeExpr;
        if (this.currentToken != 115) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        SwitchStatement switchStatement = new SwitchStatement(i);
        if (mustMatchToken(88, "msg.no.paren.switch")) {
            switchStatement.setLp(this.ts.tokenBeg - i);
        }
        switchStatement.setLineno(this.ts.lineno);
        switchStatement.setExpression(expr());
        enterSwitch(switchStatement);
        try {
            if (mustMatchToken(89, "msg.no.paren.after.switch")) {
                switchStatement.setRp(this.ts.tokenBeg - i);
            }
            mustMatchToken(86, "msg.no.brace.switch");
            boolean z = false;
            while (true) {
                int iNextToken = nextToken();
                int i2 = this.ts.tokenBeg;
                int i3 = this.ts.lineno;
                if (iNextToken == 87) {
                    switchStatement.setLength(this.ts.tokenEnd - i);
                    break;
                }
                if (iNextToken == 116) {
                    astNodeExpr = expr();
                    mustMatchToken(104, "msg.no.colon.case");
                } else if (iNextToken == 117) {
                    if (z) {
                        reportError("msg.double.switch.default");
                    }
                    mustMatchToken(104, "msg.no.colon.case");
                    z = true;
                    astNodeExpr = null;
                } else {
                    reportError("msg.bad.switch");
                    break;
                }
                SwitchCase switchCase = new SwitchCase(i2);
                switchCase.setExpression(astNodeExpr);
                switchCase.setLength(this.ts.tokenEnd - i);
                switchCase.setLineno(i3);
                while (true) {
                    int iPeekToken = peekToken();
                    if (iPeekToken == 87 || iPeekToken == 116 || iPeekToken == 117 || iPeekToken == 0) {
                        break;
                    }
                    switchCase.addStatement(statement());
                }
                switchStatement.addCase(switchCase);
            }
            return switchStatement;
        } finally {
            exitSwitch();
        }
    }

    private WhileLoop whileLoop() throws IOException {
        if (this.currentToken != 118) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        WhileLoop whileLoop = new WhileLoop(i);
        whileLoop.setLineno(this.ts.lineno);
        enterLoop(whileLoop);
        try {
            ConditionData conditionDataCondition = condition();
            whileLoop.setCondition(conditionDataCondition.condition);
            whileLoop.setParens(conditionDataCondition.lp - i, conditionDataCondition.rp - i);
            AstNode astNodeStatement = statement();
            whileLoop.setLength(getNodeEnd(astNodeStatement) - i);
            whileLoop.setBody(astNodeStatement);
            return whileLoop;
        } finally {
            exitLoop();
        }
    }

    private DoLoop doLoop() throws IOException {
        if (this.currentToken != 119) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        DoLoop doLoop = new DoLoop(i);
        doLoop.setLineno(this.ts.lineno);
        enterLoop(doLoop);
        try {
            AstNode astNodeStatement = statement();
            mustMatchToken(118, "msg.no.while.do");
            doLoop.setWhilePosition(this.ts.tokenBeg - i);
            ConditionData conditionDataCondition = condition();
            doLoop.setCondition(conditionDataCondition.condition);
            doLoop.setParens(conditionDataCondition.lp - i, conditionDataCondition.rp - i);
            int nodeEnd = getNodeEnd(astNodeStatement);
            doLoop.setBody(astNodeStatement);
            exitLoop();
            if (matchToken(83)) {
                nodeEnd = this.ts.tokenEnd;
            }
            doLoop.setLength(nodeEnd - i);
            return doLoop;
        } catch (Throwable th) {
            exitLoop();
            throw th;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Loop forLoop() throws IOException {
        boolean z;
        int i;
        AstNode astNodeExpr;
        AstNode astNodeExpr2;
        boolean z2;
        AstNode astNode;
        AstNode astNodeExpr3;
        int i2;
        Loop loop;
        if (this.currentToken != 120) {
            codeBug();
        }
        consumeToken();
        int i3 = this.ts.tokenBeg;
        int i4 = this.ts.lineno;
        Scope scope = new Scope();
        pushScope(scope);
        try {
            boolean z3 = false;
            if (!matchToken(39)) {
                z = false;
                i = -1;
            } else if ("each".equals(this.ts.getString())) {
                i = this.ts.tokenBeg - i3;
                z = true;
            } else {
                reportError("msg.no.paren.for");
                z = false;
                i = -1;
            }
            int i5 = mustMatchToken(88, "msg.no.paren.for") ? this.ts.tokenBeg - i3 : -1;
            AstNode astNodeForLoopInit = forLoopInit(peekToken());
            if (matchToken(52)) {
                i2 = this.ts.tokenBeg - i3;
                astNode = null;
                astNodeExpr3 = expr();
                z2 = false;
                z3 = true;
            } else if (this.compilerEnv.getLanguageVersion() >= 200 && matchToken(39) && "of".equals(this.ts.getString())) {
                i2 = this.ts.tokenBeg - i3;
                astNode = null;
                astNodeExpr3 = expr();
                z2 = true;
            } else {
                mustMatchToken(83, "msg.no.semi.for");
                if (peekToken() == 83) {
                    astNodeExpr = new EmptyExpression(this.ts.tokenBeg, 1);
                    astNodeExpr.setLineno(this.ts.lineno);
                } else {
                    astNodeExpr = expr();
                }
                mustMatchToken(83, "msg.no.semi.for.cond");
                int i6 = this.ts.tokenEnd;
                if (peekToken() == 89) {
                    astNodeExpr2 = new EmptyExpression(i6, 1);
                    astNodeExpr2.setLineno(this.ts.lineno);
                } else {
                    astNodeExpr2 = expr();
                }
                z2 = false;
                astNode = astNodeExpr2;
                astNodeExpr3 = astNodeExpr;
                i2 = -1;
            }
            int i7 = mustMatchToken(89, "msg.no.paren.for.ctrl") ? this.ts.tokenBeg - i3 : -1;
            if (z3 || z2) {
                ForInLoop forInLoop = new ForInLoop(i3);
                if ((astNodeForLoopInit instanceof VariableDeclaration) && ((VariableDeclaration) astNodeForLoopInit).getVariables().size() > 1) {
                    reportError("msg.mult.index");
                }
                if (z2 && z) {
                    reportError("msg.invalid.for.each");
                }
                forInLoop.setIterator(astNodeForLoopInit);
                forInLoop.setIteratedObject(astNodeExpr3);
                forInLoop.setInPosition(i2);
                forInLoop.setIsForEach(z);
                forInLoop.setEachPosition(i);
                forInLoop.setIsForOf(z2);
                loop = forInLoop;
            } else {
                ForLoop forLoop = new ForLoop(i3);
                forLoop.setInitializer(astNodeForLoopInit);
                forLoop.setCondition(astNodeExpr3);
                forLoop.setIncrement(astNode);
                loop = forLoop;
            }
            this.currentScope.replaceWith(loop);
            popScope();
            enterLoop(loop);
            try {
                AstNode astNodeStatement = statement();
                loop.setLength(getNodeEnd(astNodeStatement) - i3);
                loop.setBody(astNodeStatement);
                loop.setParens(i5, i7);
                loop.setLineno(i4);
                return loop;
            } finally {
                exitLoop();
            }
        } finally {
            if (this.currentScope == scope) {
                popScope();
            }
        }
    }

    private AstNode forLoopInit(int i) throws IOException {
        AstNode astNodeVariables;
        try {
            this.inForInit = true;
            if (i == 83) {
                astNodeVariables = new EmptyExpression(this.ts.tokenBeg, 1);
                astNodeVariables.setLineno(this.ts.lineno);
            } else if (i == 123 || i == 154) {
                consumeToken();
                astNodeVariables = variables(i, this.ts.tokenBeg, false);
            } else {
                astNodeVariables = expr();
                markDestructuring(astNodeVariables);
            }
            return astNodeVariables;
        } finally {
            this.inForInit = false;
        }
    }

    private TryStatement tryStatement() throws IOException {
        int i;
        ArrayList arrayList;
        int i2;
        AstNode astNode;
        int i3;
        AstNode astNodeExpr;
        if (this.currentToken != 82) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        int i4 = this.ts.tokenBeg;
        int i5 = this.ts.lineno;
        int i6 = 86;
        if (peekToken() != 86) {
            reportError("msg.no.brace.try");
        }
        AstNode astNodeStatement = statement();
        int nodeEnd = getNodeEnd(astNodeStatement);
        int iPeekToken = peekToken();
        if (iPeekToken == 125) {
            boolean z = false;
            arrayList = null;
            for (int i7 = 125; matchToken(i7); i7 = 125) {
                int i8 = this.ts.lineno;
                if (z) {
                    reportError("msg.catch.unreachable");
                }
                int i9 = this.ts.tokenBeg;
                int i10 = mustMatchToken(88, "msg.no.paren.catch") ? this.ts.tokenBeg : -1;
                mustMatchToken(39, "msg.bad.catchcond");
                Name nameCreateNameNode = createNameNode();
                Comment andResetJsDoc2 = getAndResetJsDoc();
                if (andResetJsDoc2 != null) {
                    nameCreateNameNode.setJsDocNode(andResetJsDoc2);
                }
                String identifier = nameCreateNameNode.getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (matchToken(113)) {
                    i3 = this.ts.tokenBeg;
                    astNodeExpr = expr();
                } else {
                    z = true;
                    i3 = -1;
                    astNodeExpr = null;
                }
                int i11 = mustMatchToken(89, "msg.bad.catchcond") ? this.ts.tokenBeg : -1;
                mustMatchToken(i6, "msg.no.brace.catchblock");
                Block block = (Block) statements();
                int nodeEnd2 = getNodeEnd(block);
                CatchClause catchClause = new CatchClause(i9);
                catchClause.setVarName(nameCreateNameNode);
                catchClause.setCatchCondition(astNodeExpr);
                catchClause.setBody(block);
                if (i3 != -1) {
                    catchClause.setIfPosition(i3 - i9);
                }
                catchClause.setParens(i10, i11);
                catchClause.setLineno(i8);
                nodeEnd = mustMatchToken(87, "msg.no.brace.after.body") ? this.ts.tokenEnd : nodeEnd2;
                catchClause.setLength(nodeEnd - i9);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(catchClause);
                i6 = 86;
            }
            i = 126;
        } else {
            i = 126;
            if (iPeekToken != 126) {
                mustMatchToken(126, "msg.try.no.catchfinally");
            }
            arrayList = null;
        }
        if (matchToken(i)) {
            int i12 = this.ts.tokenBeg;
            AstNode astNodeStatement2 = statement();
            nodeEnd = getNodeEnd(astNodeStatement2);
            astNode = astNodeStatement2;
            i2 = i12;
        } else {
            i2 = -1;
            astNode = null;
        }
        TryStatement tryStatement = new TryStatement(i4, nodeEnd - i4);
        tryStatement.setTryBlock(astNodeStatement);
        tryStatement.setCatchClauses(arrayList);
        tryStatement.setFinallyBlock(astNode);
        if (i2 != -1) {
            tryStatement.setFinallyPosition(i2 - i4);
        }
        tryStatement.setLineno(i5);
        if (andResetJsDoc != null) {
            tryStatement.setJsDocNode(andResetJsDoc);
        }
        return tryStatement;
    }

    private ThrowStatement throwStatement() throws IOException {
        if (this.currentToken != 50) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        int i2 = this.ts.lineno;
        if (peekTokenOrEOL() == 1) {
            reportError("msg.bad.throw.eol");
        }
        AstNode astNodeExpr = expr();
        ThrowStatement throwStatement = new ThrowStatement(i, getNodeEnd(astNodeExpr), astNodeExpr);
        throwStatement.setLineno(i2);
        return throwStatement;
    }

    private LabeledStatement matchJumpLabelName() throws IOException {
        if (peekTokenOrEOL() == 39) {
            consumeToken();
            Map<String, LabeledStatement> map = this.labelSet;
            labeledStatement = map != null ? map.get(this.ts.getString()) : null;
            if (labeledStatement == null) {
                reportError("msg.undef.label");
            }
        }
        return labeledStatement;
    }

    private BreakStatement breakStatement() throws IOException {
        int nodeEnd;
        Name nameCreateNameNode;
        if (this.currentToken != 121) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.lineno;
        int i2 = this.ts.tokenBeg;
        int i3 = this.ts.tokenEnd;
        if (peekTokenOrEOL() == 39) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i3;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        Jump firstLabel = labeledStatementMatchJumpLabelName != null ? labeledStatementMatchJumpLabelName.getFirstLabel() : null;
        if (firstLabel == null && nameCreateNameNode == null) {
            List<Jump> list = this.loopAndSwitchSet;
            if (list != null && list.size() != 0) {
                firstLabel = this.loopAndSwitchSet.get(r4.size() - 1);
            } else if (nameCreateNameNode == null) {
                reportError("msg.bad.break", i2, nodeEnd - i2);
            }
        }
        BreakStatement breakStatement = new BreakStatement(i2, nodeEnd - i2);
        breakStatement.setBreakLabel(nameCreateNameNode);
        if (firstLabel != null) {
            breakStatement.setBreakTarget(firstLabel);
        }
        breakStatement.setLineno(i);
        return breakStatement;
    }

    private ContinueStatement continueStatement() throws IOException {
        int nodeEnd;
        Name nameCreateNameNode;
        if (this.currentToken != 122) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.lineno;
        int i2 = this.ts.tokenBeg;
        int i3 = this.ts.tokenEnd;
        Loop loop = null;
        if (peekTokenOrEOL() == 39) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i3;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        if (labeledStatementMatchJumpLabelName == null && nameCreateNameNode == null) {
            List<Loop> list = this.loopSet;
            if (list == null || list.size() == 0) {
                reportError("msg.continue.outside");
            } else {
                loop = this.loopSet.get(r4.size() - 1);
            }
        } else {
            if (labeledStatementMatchJumpLabelName == null || !(labeledStatementMatchJumpLabelName.getStatement() instanceof Loop)) {
                reportError("msg.continue.nonloop", i2, nodeEnd - i2);
            }
            if (labeledStatementMatchJumpLabelName != null) {
                loop = (Loop) labeledStatementMatchJumpLabelName.getStatement();
            }
        }
        ContinueStatement continueStatement = new ContinueStatement(i2, nodeEnd - i2);
        if (loop != null) {
            continueStatement.setTarget(loop);
        }
        continueStatement.setLabel(nameCreateNameNode);
        continueStatement.setLineno(i);
        return continueStatement;
    }

    private WithStatement withStatement() throws IOException {
        if (this.currentToken != 124) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        int i = this.ts.lineno;
        int i2 = this.ts.tokenBeg;
        int i3 = mustMatchToken(88, "msg.no.paren.with") ? this.ts.tokenBeg : -1;
        AstNode astNodeExpr = expr();
        int i4 = mustMatchToken(89, "msg.no.paren.after.with") ? this.ts.tokenBeg : -1;
        AstNode astNodeStatement = statement();
        WithStatement withStatement = new WithStatement(i2, getNodeEnd(astNodeStatement) - i2);
        withStatement.setJsDocNode(andResetJsDoc);
        withStatement.setExpression(astNodeExpr);
        withStatement.setStatement(astNodeStatement);
        withStatement.setParens(i3, i4);
        withStatement.setLineno(i);
        return withStatement;
    }

    private AstNode letStatement() throws IOException {
        AstNode astNodeVariables;
        if (this.currentToken != 154) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.lineno;
        int i2 = this.ts.tokenBeg;
        if (peekToken() == 88) {
            astNodeVariables = let(true, i2);
        } else {
            astNodeVariables = variables(154, i2, true);
        }
        astNodeVariables.setLineno(i);
        return astNodeVariables;
    }

    private AstNode returnOrYield(int i, boolean z) throws IOException {
        int nodeEnd;
        AstNode astNodeExpr;
        AstNode yield;
        if (!insideFunction()) {
            reportError(i == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        consumeToken();
        int i2 = this.ts.lineno;
        int i3 = this.ts.tokenBeg;
        int i4 = this.ts.tokenEnd;
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL == -1 || iPeekTokenOrEOL == 0 || iPeekTokenOrEOL == 1 || iPeekTokenOrEOL == 73 || iPeekTokenOrEOL == 83 || iPeekTokenOrEOL == 85 || iPeekTokenOrEOL == 87 || iPeekTokenOrEOL == 89) {
            nodeEnd = i4;
            astNodeExpr = null;
        } else {
            astNodeExpr = expr();
            nodeEnd = getNodeEnd(astNodeExpr);
        }
        int i5 = this.endFlags;
        if (i == 4) {
            this.endFlags = i5 | (astNodeExpr == null ? 2 : 4);
            int i6 = nodeEnd - i3;
            yield = new ReturnStatement(i3, i6, astNodeExpr);
            if (nowAllSet(i5, this.endFlags, 6)) {
                addStrictWarning("msg.return.inconsistent", "", i3, i6);
            }
        } else {
            if (!insideFunction()) {
                reportError("msg.bad.yield");
            }
            this.endFlags |= 8;
            yield = new Yield(i3, nodeEnd - i3, astNodeExpr);
            setRequiresActivation();
            setIsGenerator();
            if (!z) {
                yield = new ExpressionStatement(yield);
            }
        }
        if (insideFunction() && nowAllSet(i5, this.endFlags, 12)) {
            Name functionName = ((FunctionNode) this.currentScriptOrFn).getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                addError("msg.anon.generator.returns", "");
            } else {
                addError("msg.generator.returns", functionName.getIdentifier());
            }
        }
        yield.setLineno(i2);
        return yield;
    }

    private AstNode block() throws IOException {
        if (this.currentToken != 86) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        Scope scope = new Scope(i);
        scope.setLineno(this.ts.lineno);
        pushScope(scope);
        try {
            statements(scope);
            mustMatchToken(87, "msg.no.brace.block");
            scope.setLength(this.ts.tokenEnd - i);
            return scope;
        } finally {
            popScope();
        }
    }

    private AstNode defaultXmlNamespace() throws IOException {
        if (this.currentToken != 117) {
            codeBug();
        }
        consumeToken();
        mustHaveXML();
        setRequiresActivation();
        int i = this.ts.lineno;
        int i2 = this.ts.tokenBeg;
        if (!matchToken(39) || !AbstractHttpOverXmpp.Xml.ELEMENT.equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(39) || !"namespace".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(91)) {
            reportError("msg.bad.namespace");
        }
        AstNode astNodeExpr = expr();
        UnaryExpression unaryExpression = new UnaryExpression(i2, getNodeEnd(astNodeExpr) - i2);
        unaryExpression.setOperator(75);
        unaryExpression.setOperand(astNodeExpr);
        unaryExpression.setLineno(i);
        return new ExpressionStatement((AstNode) unaryExpression, true);
    }

    private void recordLabel(Label label, LabeledStatement labeledStatement) throws IOException {
        if (peekToken() != 104) {
            codeBug();
        }
        consumeToken();
        String name = label.getName();
        Map<String, LabeledStatement> map = this.labelSet;
        if (map == null) {
            this.labelSet = new HashMap();
        } else {
            LabeledStatement labeledStatement2 = map.get(name);
            if (labeledStatement2 != null) {
                if (this.compilerEnv.isIdeMode()) {
                    Label labelByName = labeledStatement2.getLabelByName(name);
                    reportError("msg.dup.label", labelByName.getAbsolutePosition(), labelByName.getLength());
                }
                reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        labeledStatement.addLabel(label);
        this.labelSet.put(name, labeledStatement);
    }

    private AstNode nameOrLabel() throws IOException {
        AstNode astNodeStatementHelper;
        int nodeEnd;
        if (this.currentToken != 39) {
            throw codeBug();
        }
        int i = this.ts.tokenBeg;
        this.currentFlaggedToken |= 131072;
        AstNode astNodeExpr = expr();
        if (astNodeExpr.getType() != 131) {
            ExpressionStatement expressionStatement = new ExpressionStatement(astNodeExpr, !insideFunction());
            expressionStatement.lineno = astNodeExpr.lineno;
            return expressionStatement;
        }
        LabeledStatement labeledStatement = new LabeledStatement(i);
        recordLabel((Label) astNodeExpr, labeledStatement);
        labeledStatement.setLineno(this.ts.lineno);
        while (true) {
            if (peekToken() != 39) {
                astNodeStatementHelper = null;
                break;
            }
            this.currentFlaggedToken |= 131072;
            AstNode astNodeExpr2 = expr();
            if (astNodeExpr2.getType() != 131) {
                astNodeStatementHelper = new ExpressionStatement(astNodeExpr2, !insideFunction());
                autoInsertSemicolon(astNodeStatementHelper);
                break;
            }
            recordLabel((Label) astNodeExpr2, labeledStatement);
        }
        try {
            this.currentLabel = labeledStatement;
            if (astNodeStatementHelper == null) {
                astNodeStatementHelper = statementHelper();
            }
            if (astNodeStatementHelper.getParent() == null) {
                nodeEnd = getNodeEnd(astNodeStatementHelper) - i;
            } else {
                nodeEnd = getNodeEnd(astNodeStatementHelper);
            }
            labeledStatement.setLength(nodeEnd);
            labeledStatement.setStatement(astNodeStatementHelper);
            return labeledStatement;
        } finally {
            this.currentLabel = null;
            Iterator<Label> it = labeledStatement.getLabels().iterator();
            while (it.hasNext()) {
                this.labelSet.remove(it.next().getName());
            }
        }
    }

    private VariableDeclaration variables(int i, int i2, boolean z) throws IOException {
        AstNode astNodeDestructuringPrimaryExpr;
        int nodeEnd;
        Name name;
        VariableDeclaration variableDeclaration = new VariableDeclaration(i2);
        variableDeclaration.setType(i);
        variableDeclaration.setLineno(this.ts.lineno);
        Comment andResetJsDoc = getAndResetJsDoc();
        if (andResetJsDoc != null) {
            variableDeclaration.setJsDocNode(andResetJsDoc);
        }
        do {
            int iPeekToken = peekToken();
            int i3 = this.ts.tokenBeg;
            int i4 = this.ts.tokenEnd;
            AstNode astNodeAssignExpr = null;
            if (iPeekToken == 84 || iPeekToken == 86) {
                astNodeDestructuringPrimaryExpr = destructuringPrimaryExpr();
                int nodeEnd2 = getNodeEnd(astNodeDestructuringPrimaryExpr);
                if (!(astNodeDestructuringPrimaryExpr instanceof DestructuringForm)) {
                    reportError("msg.bad.assign.left", i3, nodeEnd2 - i3);
                }
                markDestructuring(astNodeDestructuringPrimaryExpr);
                nodeEnd = nodeEnd2;
                name = null;
            } else {
                mustMatchToken(39, "msg.bad.var");
                Name nameCreateNameNode = createNameNode();
                nameCreateNameNode.setLineno(this.ts.getLineno());
                if (this.inUseStrictDirective) {
                    String string = this.ts.getString();
                    if ("eval".equals(string) || "arguments".equals(this.ts.getString())) {
                        reportError("msg.bad.id.strict", string);
                    }
                }
                defineSymbol(i, this.ts.getString(), this.inForInit);
                nodeEnd = i4;
                name = nameCreateNameNode;
                astNodeDestructuringPrimaryExpr = null;
            }
            int i5 = this.ts.lineno;
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (matchToken(91)) {
                astNodeAssignExpr = assignExpr();
                nodeEnd = getNodeEnd(astNodeAssignExpr);
            }
            VariableInitializer variableInitializer = new VariableInitializer(i3, nodeEnd - i3);
            if (astNodeDestructuringPrimaryExpr != null) {
                if (astNodeAssignExpr == null && !this.inForInit) {
                    reportError("msg.destruct.assign.no.init");
                }
                variableInitializer.setTarget(astNodeDestructuringPrimaryExpr);
            } else {
                variableInitializer.setTarget(name);
            }
            variableInitializer.setInitializer(astNodeAssignExpr);
            variableInitializer.setType(i);
            variableInitializer.setJsDocNode(andResetJsDoc2);
            variableInitializer.setLineno(i5);
            variableDeclaration.addVariable(variableInitializer);
        } while (matchToken(90));
        variableDeclaration.setLength(nodeEnd - i2);
        variableDeclaration.setIsStatement(z);
        return variableDeclaration;
    }

    private AstNode let(boolean z, int i) throws IOException {
        LetNode letNode = new LetNode(i);
        letNode.setLineno(this.ts.lineno);
        if (mustMatchToken(88, "msg.no.paren.after.let")) {
            letNode.setLp(this.ts.tokenBeg - i);
        }
        pushScope(letNode);
        try {
            letNode.setVariables(variables(154, this.ts.tokenBeg, z));
            if (mustMatchToken(89, "msg.no.paren.let")) {
                letNode.setRp(this.ts.tokenBeg - i);
            }
            if (z && peekToken() == 86) {
                consumeToken();
                int i2 = this.ts.tokenBeg;
                AstNode astNodeStatements = statements();
                mustMatchToken(87, "msg.no.curly.let");
                astNodeStatements.setLength(this.ts.tokenEnd - i2);
                letNode.setLength(this.ts.tokenEnd - i);
                letNode.setBody(astNodeStatements);
                letNode.setType(154);
            } else {
                AstNode astNodeExpr = expr();
                letNode.setLength(getNodeEnd(astNodeExpr) - i);
                letNode.setBody(astNodeExpr);
                if (z) {
                    ExpressionStatement expressionStatement = new ExpressionStatement(letNode, !insideFunction());
                    expressionStatement.setLineno(letNode.getLineno());
                    return expressionStatement;
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    void defineSymbol(int i, String str) {
        defineSymbol(i, str, false);
    }

    void defineSymbol(int i, String str, boolean z) {
        if (str == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            } else {
                codeBug();
            }
        }
        Scope definingScope = this.currentScope.getDefiningScope(str);
        org.mozilla.javascript.ast.Symbol symbol = definingScope != null ? definingScope.getSymbol(str) : null;
        int declType = symbol != null ? symbol.getDeclType() : -1;
        String str2 = "msg.var.redecl";
        if (symbol != null && (declType == 155 || i == 155 || (definingScope == this.currentScope && declType == 154))) {
            if (declType == 155) {
                str2 = "msg.const.redecl";
            } else if (declType == 154) {
                str2 = "msg.let.redecl";
            } else if (declType != 123) {
                str2 = declType == 110 ? "msg.fn.redecl" : "msg.parm.redecl";
            }
            addError(str2, str);
            return;
        }
        if (i == 88) {
            if (symbol != null) {
                addWarning("msg.dup.parms", str);
            }
            this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
            return;
        }
        if (i != 110 && i != 123) {
            if (i == 154) {
                if (!z && (this.currentScope.getType() == 113 || (this.currentScope instanceof Loop))) {
                    addError("msg.let.decl.not.in.block");
                    return;
                } else {
                    this.currentScope.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
                    return;
                }
            }
            if (i != 155) {
                throw codeBug();
            }
        }
        if (symbol == null) {
            this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
        } else if (declType == 123) {
            addStrictWarning("msg.var.redecl", str);
        } else if (declType == 88) {
            addStrictWarning("msg.var.hides.arg", str);
        }
    }

    private AstNode expr() throws IOException {
        AstNode astNodeAssignExpr = assignExpr();
        int position = astNodeAssignExpr.getPosition();
        while (matchToken(90)) {
            int i = this.ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !astNodeAssignExpr.hasSideEffects()) {
                addStrictWarning("msg.no.side.effects", "", position, nodeEnd(astNodeAssignExpr) - position);
            }
            if (peekToken() == 73) {
                reportError("msg.yield.parenthesized");
            }
            astNodeAssignExpr = new InfixExpression(90, astNodeAssignExpr, assignExpr(), i);
        }
        return astNodeAssignExpr;
    }

    private AstNode assignExpr() throws IOException {
        int iPeekToken = peekToken();
        boolean z = true;
        if (iPeekToken == 73) {
            return returnOrYield(iPeekToken, true);
        }
        AstNode astNodeCondExpr = condExpr();
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL == 1) {
            iPeekTokenOrEOL = peekToken();
        } else {
            z = false;
        }
        if (91 > iPeekTokenOrEOL || iPeekTokenOrEOL > 102) {
            if (iPeekTokenOrEOL == 83) {
                if (this.currentJsDocComment == null) {
                    return astNodeCondExpr;
                }
                astNodeCondExpr.setJsDocNode(getAndResetJsDoc());
                return astNodeCondExpr;
            }
            if (z || iPeekTokenOrEOL != 165) {
                return astNodeCondExpr;
            }
            consumeToken();
            return arrowFunction(astNodeCondExpr);
        }
        if (this.inDestructuringAssignment) {
            reportError("msg.destruct.default.vals");
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        markDestructuring(astNodeCondExpr);
        Assignment assignment = new Assignment(iPeekTokenOrEOL, astNodeCondExpr, assignExpr(), this.ts.tokenBeg);
        if (andResetJsDoc != null) {
            assignment.setJsDocNode(andResetJsDoc);
        }
        return assignment;
    }

    private AstNode condExpr() throws IOException {
        AstNode astNodeOrExpr = orExpr();
        if (!matchToken(103)) {
            return astNodeOrExpr;
        }
        int i = this.ts.lineno;
        int i2 = this.ts.tokenBeg;
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            AstNode astNodeAssignExpr = assignExpr();
            this.inForInit = z;
            int i3 = mustMatchToken(104, "msg.no.colon.cond") ? this.ts.tokenBeg : -1;
            AstNode astNodeAssignExpr2 = assignExpr();
            int position = astNodeOrExpr.getPosition();
            ConditionalExpression conditionalExpression = new ConditionalExpression(position, getNodeEnd(astNodeAssignExpr2) - position);
            conditionalExpression.setLineno(i);
            conditionalExpression.setTestExpression(astNodeOrExpr);
            conditionalExpression.setTrueExpression(astNodeAssignExpr);
            conditionalExpression.setFalseExpression(astNodeAssignExpr2);
            conditionalExpression.setQuestionMarkPosition(i2 - position);
            conditionalExpression.setColonPosition(i3 - position);
            return conditionalExpression;
        } catch (Throwable th) {
            this.inForInit = z;
            throw th;
        }
    }

    private AstNode orExpr() throws IOException {
        AstNode astNodeAndExpr = andExpr();
        if (!matchToken(105)) {
            return astNodeAndExpr;
        }
        return new InfixExpression(105, astNodeAndExpr, orExpr(), this.ts.tokenBeg);
    }

    private AstNode andExpr() throws IOException {
        AstNode astNodeBitOrExpr = bitOrExpr();
        if (!matchToken(106)) {
            return astNodeBitOrExpr;
        }
        return new InfixExpression(106, astNodeBitOrExpr, andExpr(), this.ts.tokenBeg);
    }

    private AstNode bitOrExpr() throws IOException {
        AstNode astNodeBitXorExpr = bitXorExpr();
        while (matchToken(9)) {
            astNodeBitXorExpr = new InfixExpression(9, astNodeBitXorExpr, bitXorExpr(), this.ts.tokenBeg);
        }
        return astNodeBitXorExpr;
    }

    private AstNode bitXorExpr() throws IOException {
        AstNode astNodeBitAndExpr = bitAndExpr();
        while (matchToken(10)) {
            astNodeBitAndExpr = new InfixExpression(10, astNodeBitAndExpr, bitAndExpr(), this.ts.tokenBeg);
        }
        return astNodeBitAndExpr;
    }

    private AstNode bitAndExpr() throws IOException {
        AstNode astNodeEqExpr = eqExpr();
        while (matchToken(11)) {
            astNodeEqExpr = new InfixExpression(11, astNodeEqExpr, eqExpr(), this.ts.tokenBeg);
        }
        return astNodeEqExpr;
    }

    private AstNode eqExpr() throws IOException {
        AstNode astNodeRelExpr = relExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 12 && iPeekToken != 13 && iPeekToken != 46 && iPeekToken != 47) {
                return astNodeRelExpr;
            }
            consumeToken();
            if (this.compilerEnv.getLanguageVersion() == 120) {
                if (iPeekToken == 12) {
                    iPeekToken = 46;
                } else if (iPeekToken == 13) {
                    iPeekToken = 47;
                }
            }
            astNodeRelExpr = new InfixExpression(iPeekToken, astNodeRelExpr, relExpr(), i);
        }
    }

    private AstNode relExpr() throws IOException {
        AstNode astNodeShiftExpr = shiftExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken == 52) {
                if (!this.inForInit) {
                    consumeToken();
                    astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i);
                }
            } else {
                if (iPeekToken != 53) {
                    switch (iPeekToken) {
                    }
                } else {
                    continue;
                }
                consumeToken();
                astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i);
            }
        }
        return astNodeShiftExpr;
    }

    private AstNode shiftExpr() throws IOException {
        AstNode astNodeAddExpr = addExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 18:
                case 19:
                case 20:
                    consumeToken();
                    astNodeAddExpr = new InfixExpression(iPeekToken, astNodeAddExpr, addExpr(), i);
                    break;
                default:
                    return astNodeAddExpr;
            }
        }
    }

    private AstNode addExpr() throws IOException {
        AstNode astNodeMulExpr = mulExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 21 && iPeekToken != 22) {
                return astNodeMulExpr;
            }
            consumeToken();
            astNodeMulExpr = new InfixExpression(iPeekToken, astNodeMulExpr, mulExpr(), i);
        }
    }

    private AstNode mulExpr() throws IOException {
        AstNode astNodeUnaryExpr = unaryExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 23:
                case 24:
                case 25:
                    consumeToken();
                    astNodeUnaryExpr = new InfixExpression(iPeekToken, astNodeUnaryExpr, unaryExpr(), i);
                    break;
                default:
                    return astNodeUnaryExpr;
            }
        }
    }

    private AstNode unaryExpr() throws IOException {
        int iPeekToken = peekToken();
        int i = this.ts.lineno;
        if (iPeekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (iPeekToken != 14) {
            if (iPeekToken != 127) {
                if (iPeekToken == 21) {
                    consumeToken();
                    UnaryExpression unaryExpression = new UnaryExpression(28, this.ts.tokenBeg, unaryExpr());
                    unaryExpression.setLineno(i);
                    return unaryExpression;
                }
                if (iPeekToken == 22) {
                    consumeToken();
                    UnaryExpression unaryExpression2 = new UnaryExpression(29, this.ts.tokenBeg, unaryExpr());
                    unaryExpression2.setLineno(i);
                    return unaryExpression2;
                }
                if (iPeekToken != 26 && iPeekToken != 27) {
                    if (iPeekToken == 31) {
                        consumeToken();
                        UnaryExpression unaryExpression3 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
                        unaryExpression3.setLineno(i);
                        return unaryExpression3;
                    }
                    if (iPeekToken != 32) {
                        if (iPeekToken == 107 || iPeekToken == 108) {
                            consumeToken();
                            UnaryExpression unaryExpression4 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, memberExpr(true));
                            unaryExpression4.setLineno(i);
                            checkBadIncDec(unaryExpression4);
                            return unaryExpression4;
                        }
                    }
                }
            }
            consumeToken();
            UnaryExpression unaryExpression5 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
            unaryExpression5.setLineno(i);
            return unaryExpression5;
        }
        if (this.compilerEnv.isXmlAvailable()) {
            consumeToken();
            return memberExprTail(true, xmlInitializer());
        }
        AstNode astNodeMemberExpr = memberExpr(true);
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL != 107 && iPeekTokenOrEOL != 108) {
            return astNodeMemberExpr;
        }
        consumeToken();
        UnaryExpression unaryExpression6 = new UnaryExpression(iPeekTokenOrEOL, this.ts.tokenBeg, astNodeMemberExpr, true);
        unaryExpression6.setLineno(i);
        checkBadIncDec(unaryExpression6);
        return unaryExpression6;
    }

    private AstNode xmlInitializer() throws IOException {
        if (this.currentToken != 14) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        int firstXMLToken = this.ts.getFirstXMLToken();
        if (firstXMLToken != 146 && firstXMLToken != 149) {
            reportError("msg.syntax");
            return makeErrorNode();
        }
        XmlLiteral xmlLiteral = new XmlLiteral(i);
        xmlLiteral.setLineno(this.ts.lineno);
        while (firstXMLToken == 146) {
            xmlLiteral.addFragment(new XmlString(this.ts.tokenBeg, this.ts.getString()));
            mustMatchToken(86, "msg.syntax");
            int i2 = this.ts.tokenBeg;
            AstNode emptyExpression = peekToken() == 87 ? new EmptyExpression(i2, this.ts.tokenEnd - i2) : expr();
            mustMatchToken(87, "msg.syntax");
            XmlExpression xmlExpression = new XmlExpression(i2, emptyExpression);
            xmlExpression.setIsXmlAttribute(this.ts.isXMLAttribute());
            xmlExpression.setLength(this.ts.tokenEnd - i2);
            xmlLiteral.addFragment(xmlExpression);
            firstXMLToken = this.ts.getNextXMLToken();
        }
        if (firstXMLToken == 149) {
            xmlLiteral.addFragment(new XmlString(this.ts.tokenBeg, this.ts.getString()));
            return xmlLiteral;
        }
        reportError("msg.syntax");
        return makeErrorNode();
    }

    private List<AstNode> argumentList() throws IOException {
        if (matchToken(89)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.inForInit;
        this.inForInit = false;
        do {
            try {
                if (peekToken() == 73) {
                    reportError("msg.yield.parenthesized");
                }
                AstNode astNodeAssignExpr = assignExpr();
                if (peekToken() == 120) {
                    try {
                        arrayList.add(generatorExpression(astNodeAssignExpr, 0, true));
                    } catch (IOException unused) {
                    }
                } else {
                    arrayList.add(astNodeAssignExpr);
                }
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        } while (matchToken(90));
        this.inForInit = z;
        mustMatchToken(89, "msg.no.paren.arg");
        return arrayList;
    }

    private AstNode memberExpr(boolean z) throws IOException {
        AstNode astNodePrimaryExpr;
        int iPeekToken = peekToken();
        int i = this.ts.lineno;
        if (iPeekToken != 30) {
            astNodePrimaryExpr = primaryExpr();
        } else {
            consumeToken();
            int i2 = this.ts.tokenBeg;
            NewExpression newExpression = new NewExpression(i2);
            AstNode astNodeMemberExpr = memberExpr(false);
            int nodeEnd = getNodeEnd(astNodeMemberExpr);
            newExpression.setTarget(astNodeMemberExpr);
            if (matchToken(88)) {
                int i3 = this.ts.tokenBeg;
                List<AstNode> listArgumentList = argumentList();
                if (listArgumentList != null && listArgumentList.size() > 65536) {
                    reportError("msg.too.many.constructor.args");
                }
                int i4 = this.ts.tokenBeg;
                int i5 = this.ts.tokenEnd;
                if (listArgumentList != null) {
                    newExpression.setArguments(listArgumentList);
                }
                newExpression.setParens(i3 - i2, i4 - i2);
                nodeEnd = i5;
            }
            if (matchToken(86)) {
                ObjectLiteral objectLiteral = objectLiteral();
                nodeEnd = getNodeEnd(objectLiteral);
                newExpression.setInitializer(objectLiteral);
            }
            newExpression.setLength(nodeEnd - i2);
            astNodePrimaryExpr = newExpression;
        }
        astNodePrimaryExpr.setLineno(i);
        return memberExprTail(z, astNodePrimaryExpr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [org.mozilla.javascript.ast.AstNode] */
    /* JADX WARN: Type inference failed for: r10v1, types: [org.mozilla.javascript.ast.AstNode] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [org.mozilla.javascript.ast.AstNode] */
    /* JADX WARN: Type inference failed for: r2v11, types: [org.mozilla.javascript.ast.FunctionCall] */
    /* JADX WARN: Type inference failed for: r6v2, types: [org.mozilla.javascript.ast.ElementGet] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [org.mozilla.javascript.ast.XmlDotQuery] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.mozilla.javascript.Parser] */
    private AstNode memberExprTail(boolean z, AstNode astNode) throws IOException {
        ?? r6;
        if (astNode == 0) {
            codeBug();
        }
        int position = astNode.getPosition();
        while (true) {
            int iPeekToken = peekToken();
            int i = -1;
            if (iPeekToken == 84) {
                consumeToken();
                int i2 = this.ts.tokenBeg;
                int i3 = this.ts.lineno;
                AstNode astNodeExpr = expr();
                int nodeEnd = getNodeEnd(astNodeExpr);
                if (mustMatchToken(85, "msg.no.bracket.index")) {
                    i = this.ts.tokenBeg;
                    nodeEnd = this.ts.tokenEnd;
                }
                ?? elementGet = new ElementGet(position, nodeEnd - position);
                elementGet.setTarget(astNode);
                elementGet.setElement(astNodeExpr);
                elementGet.setParens(i2, i);
                elementGet.setLineno(i3);
                r6 = elementGet;
            } else if (iPeekToken != 88) {
                if (iPeekToken == 109 || iPeekToken == 144) {
                    int i4 = this.ts.lineno;
                    astNode = propertyAccess(iPeekToken, astNode);
                    astNode.setLineno(i4);
                } else {
                    if (iPeekToken != 147) {
                        break;
                    }
                    consumeToken();
                    int i5 = this.ts.tokenBeg;
                    int i6 = this.ts.lineno;
                    mustHaveXML();
                    setRequiresActivation();
                    AstNode astNodeExpr2 = expr();
                    int nodeEnd2 = getNodeEnd(astNodeExpr2);
                    if (mustMatchToken(89, "msg.no.paren")) {
                        i = this.ts.tokenBeg;
                        nodeEnd2 = this.ts.tokenEnd;
                    }
                    ?? xmlDotQuery = new XmlDotQuery(position, nodeEnd2 - position);
                    xmlDotQuery.setLeft(astNode);
                    xmlDotQuery.setRight(astNodeExpr2);
                    xmlDotQuery.setOperatorPosition(i5);
                    xmlDotQuery.setRp(i - position);
                    xmlDotQuery.setLineno(i6);
                    r6 = xmlDotQuery;
                }
            } else {
                if (!z) {
                    break;
                }
                int i7 = this.ts.lineno;
                consumeToken();
                checkCallRequiresActivation(astNode);
                ?? functionCall = new FunctionCall(position);
                functionCall.setTarget(astNode);
                functionCall.setLineno(i7);
                functionCall.setLp(this.ts.tokenBeg - position);
                List<AstNode> listArgumentList = argumentList();
                if (listArgumentList != null && listArgumentList.size() > 65536) {
                    reportError("msg.too.many.function.args");
                }
                functionCall.setArguments(listArgumentList);
                functionCall.setRp(this.ts.tokenBeg - position);
                functionCall.setLength(this.ts.tokenEnd - position);
                astNode = functionCall;
            }
            astNode = r6;
        }
        return astNode;
    }

    private AstNode propertyAccess(int i, AstNode astNode) throws IOException {
        int i2;
        AstNode astNodePropertyName;
        String strKeywordToName;
        if (astNode == null) {
            codeBug();
        }
        int i3 = this.ts.lineno;
        int i4 = this.ts.tokenBeg;
        consumeToken();
        if (i == 144) {
            mustHaveXML();
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!this.compilerEnv.isXmlAvailable()) {
            if (nextToken() != 39 && (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective))) {
                reportError("msg.no.name.after.dot");
            }
            PropertyGet propertyGet = new PropertyGet(astNode, createNameNode(true, 33), i4);
            propertyGet.setLineno(i3);
            return propertyGet;
        }
        int iNextToken = nextToken();
        if (iNextToken == 23) {
            saveNameTokenData(this.ts.tokenBeg, "*", this.ts.lineno);
            astNodePropertyName = propertyName(-1, "*", i2);
        } else if (iNextToken == 39) {
            astNodePropertyName = propertyName(-1, this.ts.getString(), i2);
        } else if (iNextToken == 50) {
            saveNameTokenData(this.ts.tokenBeg, "throw", this.ts.lineno);
            astNodePropertyName = propertyName(-1, "throw", i2);
        } else if (iNextToken == 128) {
            String string = this.ts.getString();
            saveNameTokenData(this.ts.tokenBeg, string, this.ts.lineno);
            astNodePropertyName = propertyName(-1, string, i2);
        } else if (iNextToken == 148) {
            astNodePropertyName = attributeAccess();
        } else if (this.compilerEnv.isReservedKeywordAsIdentifier() && (strKeywordToName = Token.keywordToName(iNextToken)) != null) {
            saveNameTokenData(this.ts.tokenBeg, strKeywordToName, this.ts.lineno);
            astNodePropertyName = propertyName(-1, strKeywordToName, i2);
        } else {
            reportError("msg.no.name.after.dot");
            return makeErrorNode();
        }
        boolean z = astNodePropertyName instanceof XmlRef;
        InfixExpression xmlMemberGet = z ? new XmlMemberGet() : new PropertyGet();
        if (z && i == 109) {
            xmlMemberGet.setType(109);
        }
        int position = astNode.getPosition();
        xmlMemberGet.setPosition(position);
        xmlMemberGet.setLength(getNodeEnd(astNodePropertyName) - position);
        xmlMemberGet.setOperatorPosition(i4 - position);
        xmlMemberGet.setLineno(astNode.getLineno());
        xmlMemberGet.setLeft(astNode);
        xmlMemberGet.setRight(astNodePropertyName);
        return xmlMemberGet;
    }

    private AstNode attributeAccess() throws IOException {
        int iNextToken = nextToken();
        int i = this.ts.tokenBeg;
        if (iNextToken == 23) {
            saveNameTokenData(this.ts.tokenBeg, "*", this.ts.lineno);
            return propertyName(i, "*", 0);
        }
        if (iNextToken == 39) {
            return propertyName(i, this.ts.getString(), 0);
        }
        if (iNextToken == 84) {
            return xmlElemRef(i, null, -1);
        }
        reportError("msg.no.name.after.xmlAttr");
        return makeErrorNode();
    }

    private AstNode propertyName(int i, String str, int i2) throws IOException {
        Name nameCreateNameNode;
        int i3;
        int i4 = i != -1 ? i : this.ts.tokenBeg;
        int i5 = this.ts.lineno;
        Name nameCreateNameNode2 = createNameNode(true, this.currentToken);
        if (matchToken(145)) {
            i3 = this.ts.tokenBeg;
            int iNextToken = nextToken();
            if (iNextToken == 23) {
                saveNameTokenData(this.ts.tokenBeg, "*", this.ts.lineno);
                nameCreateNameNode = createNameNode(false, -1);
            } else {
                if (iNextToken != 39) {
                    if (iNextToken == 84) {
                        return xmlElemRef(i, nameCreateNameNode2, i3);
                    }
                    reportError("msg.no.name.after.coloncolon");
                    return makeErrorNode();
                }
                nameCreateNameNode = createNameNode();
            }
        } else {
            nameCreateNameNode = nameCreateNameNode2;
            nameCreateNameNode2 = null;
            i3 = -1;
        }
        if (nameCreateNameNode2 == null && i2 == 0 && i == -1) {
            return nameCreateNameNode;
        }
        XmlPropRef xmlPropRef = new XmlPropRef(i4, getNodeEnd(nameCreateNameNode) - i4);
        xmlPropRef.setAtPos(i);
        xmlPropRef.setNamespace(nameCreateNameNode2);
        xmlPropRef.setColonPos(i3);
        xmlPropRef.setPropName(nameCreateNameNode);
        xmlPropRef.setLineno(i5);
        return xmlPropRef;
    }

    private XmlElemRef xmlElemRef(int i, Name name, int i2) throws IOException {
        int i3 = this.ts.tokenBeg;
        int i4 = -1;
        int i5 = i != -1 ? i : i3;
        AstNode astNodeExpr = expr();
        int nodeEnd = getNodeEnd(astNodeExpr);
        if (mustMatchToken(85, "msg.no.bracket.index")) {
            i4 = this.ts.tokenBeg;
            nodeEnd = this.ts.tokenEnd;
        }
        XmlElemRef xmlElemRef = new XmlElemRef(i5, nodeEnd - i5);
        xmlElemRef.setNamespace(name);
        xmlElemRef.setColonPos(i2);
        xmlElemRef.setAtPos(i);
        xmlElemRef.setExpression(astNodeExpr);
        xmlElemRef.setBrackets(i3, i4);
        return xmlElemRef;
    }

    private AstNode destructuringPrimaryExpr() throws ParserException, IOException {
        try {
            this.inDestructuringAssignment = true;
            return primaryExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private AstNode primaryExpr() throws IOException {
        int iPeekFlaggedToken = peekFlaggedToken();
        int i = 65535 & iPeekFlaggedToken;
        if (i == -1) {
            consumeToken();
        } else {
            if (i != 0) {
                if (i != 24) {
                    if (i == 84) {
                        consumeToken();
                        return arrayLiteral();
                    }
                    if (i == 86) {
                        consumeToken();
                        return objectLiteral();
                    }
                    if (i == 88) {
                        consumeToken();
                        return parenExpr();
                    }
                    if (i != 101) {
                        if (i == 110) {
                            consumeToken();
                            return function(2);
                        }
                        if (i == 128) {
                            consumeToken();
                            reportError("msg.reserved.id", this.ts.getString());
                        } else {
                            if (i == 148) {
                                consumeToken();
                                mustHaveXML();
                                return attributeAccess();
                            }
                            if (i == 154) {
                                consumeToken();
                                return let(false, this.ts.tokenBeg);
                            }
                            switch (i) {
                                case 39:
                                    consumeToken();
                                    return name(iPeekFlaggedToken, i);
                                case 40:
                                    consumeToken();
                                    String string = this.ts.getString();
                                    if (this.inUseStrictDirective && this.ts.isNumberOldOctal()) {
                                        reportError("msg.no.old.octal.strict");
                                    }
                                    if (this.ts.isNumberBinary()) {
                                        string = "0b" + string;
                                    }
                                    if (this.ts.isNumberOldOctal()) {
                                        string = "0" + string;
                                    }
                                    if (this.ts.isNumberOctal()) {
                                        string = "0o" + string;
                                    }
                                    if (this.ts.isNumberHex()) {
                                        string = "0x" + string;
                                    }
                                    return new NumberLiteral(this.ts.tokenBeg, string, this.ts.getNumber());
                                case 41:
                                    consumeToken();
                                    return createStringLiteral();
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    consumeToken();
                                    int i2 = this.ts.tokenBeg;
                                    return new KeywordLiteral(i2, this.ts.tokenEnd - i2, i);
                                default:
                                    consumeToken();
                                    reportError("msg.syntax");
                                    break;
                            }
                        }
                    }
                }
                consumeToken();
                this.ts.readRegExp(i);
                int i3 = this.ts.tokenBeg;
                RegExpLiteral regExpLiteral = new RegExpLiteral(i3, this.ts.tokenEnd - i3);
                regExpLiteral.setValue(this.ts.getString());
                regExpLiteral.setFlags(this.ts.readAndClearRegExpFlags());
                return regExpLiteral;
            }
            consumeToken();
            reportError("msg.unexpected.eof");
        }
        consumeToken();
        return makeErrorNode();
    }

    private AstNode parenExpr() throws IOException {
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            Comment andResetJsDoc = getAndResetJsDoc();
            int i = this.ts.lineno;
            int i2 = this.ts.tokenBeg;
            AstNode emptyExpression = peekToken() == 89 ? new EmptyExpression(i2) : expr();
            if (peekToken() == 120) {
                return generatorExpression(emptyExpression, i2);
            }
            ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression(emptyExpression);
            if (andResetJsDoc == null) {
                andResetJsDoc = getAndResetJsDoc();
            }
            if (andResetJsDoc != null) {
                parenthesizedExpression.setJsDocNode(andResetJsDoc);
            }
            mustMatchToken(89, "msg.no.paren");
            if (emptyExpression.getType() == 129 && peekToken() != 165) {
                reportError("msg.syntax");
                return makeErrorNode();
            }
            parenthesizedExpression.setLength(this.ts.tokenEnd - parenthesizedExpression.getPosition());
            parenthesizedExpression.setLineno(i);
            return parenthesizedExpression;
        } finally {
            this.inForInit = z;
        }
    }

    private AstNode name(int i, int i2) throws IOException {
        String string = this.ts.getString();
        int i3 = this.ts.tokenBeg;
        int i4 = this.ts.lineno;
        if ((i & 131072) != 0 && peekToken() == 104) {
            Label label = new Label(i3, this.ts.tokenEnd - i3);
            label.setName(string);
            label.setLineno(this.ts.lineno);
            return label;
        }
        saveNameTokenData(i3, string, i4);
        if (this.compilerEnv.isXmlAvailable()) {
            return propertyName(-1, string, 0);
        }
        return createNameNode(true, 39);
    }

    private AstNode arrayLiteral() throws IOException {
        if (this.currentToken != 84) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        int i2 = this.ts.tokenEnd;
        ArrayList arrayList = new ArrayList();
        ArrayLiteral arrayLiteral = new ArrayLiteral(i);
        int i3 = 0;
        int i4 = -1;
        loop0: while (true) {
            int i5 = 1;
            while (true) {
                int iPeekToken = peekToken();
                if (iPeekToken == 90) {
                    consumeToken();
                    i4 = this.ts.tokenEnd;
                    if (i5 == 0) {
                        break;
                    }
                    arrayList.add(new EmptyExpression(this.ts.tokenBeg, 1));
                    i3++;
                } else if (iPeekToken == 85) {
                    consumeToken();
                    i2 = this.ts.tokenEnd;
                    arrayLiteral.setDestructuringLength(arrayList.size() + i5);
                    arrayLiteral.setSkipCount(i3);
                    if (i4 != -1) {
                        warnTrailingComma(i, arrayList, i4);
                    }
                } else {
                    if (iPeekToken == 120 && i5 == 0 && arrayList.size() == 1) {
                        return arrayComprehension((AstNode) arrayList.get(0), i);
                    }
                    if (iPeekToken == 0) {
                        reportError("msg.no.bracket.arg");
                        break loop0;
                    }
                    if (i5 == 0) {
                        reportError("msg.no.bracket.arg");
                    }
                    arrayList.add(assignExpr());
                    i5 = 0;
                    i4 = -1;
                }
            }
        }
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayLiteral.addElement((AstNode) it.next());
        }
        arrayLiteral.setLength(i2 - i);
        return arrayLiteral;
    }

    private AstNode arrayComprehension(AstNode astNode, int i) throws IOException {
        int i2;
        ConditionData conditionDataCondition;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(arrayComprehensionLoop());
        }
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionDataCondition = condition();
        } else {
            i2 = -1;
            conditionDataCondition = null;
        }
        mustMatchToken(85, "msg.no.bracket.arg");
        ArrayComprehension arrayComprehension = new ArrayComprehension(i, this.ts.tokenEnd - i);
        arrayComprehension.setResult(astNode);
        arrayComprehension.setLoops(arrayList);
        if (conditionDataCondition != null) {
            arrayComprehension.setIfPosition(i2);
            arrayComprehension.setFilter(conditionDataCondition.condition);
            arrayComprehension.setFilterLp(conditionDataCondition.lp - i);
            arrayComprehension.setFilterRp(conditionDataCondition.rp - i);
        }
        return arrayComprehension;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:6:0x0019, B:9:0x0022, B:11:0x0030, B:14:0x003a, B:16:0x0042, B:18:0x0049, B:24:0x0057, B:27:0x006d, B:29:0x0074, B:30:0x007f, B:41:0x00ad, B:43:0x00b4, B:45:0x00c2, B:47:0x00c9, B:51:0x00e1, B:35:0x008b, B:36:0x0091, B:39:0x00a1, B:40:0x00a6, B:25:0x005e, B:26:0x0066, B:12:0x0036), top: B:57:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.ArrayComprehensionLoop arrayComprehensionLoop() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.arrayComprehensionLoop():org.mozilla.javascript.ast.ArrayComprehensionLoop");
    }

    private AstNode generatorExpression(AstNode astNode, int i) throws IOException {
        return generatorExpression(astNode, i, false);
    }

    private AstNode generatorExpression(AstNode astNode, int i, boolean z) throws IOException {
        int i2;
        ConditionData conditionDataCondition;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(generatorExpressionLoop());
        }
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionDataCondition = condition();
        } else {
            i2 = -1;
            conditionDataCondition = null;
        }
        if (!z) {
            mustMatchToken(89, "msg.no.paren.let");
        }
        GeneratorExpression generatorExpression = new GeneratorExpression(i, this.ts.tokenEnd - i);
        generatorExpression.setResult(astNode);
        generatorExpression.setLoops(arrayList);
        if (conditionDataCondition != null) {
            generatorExpression.setIfPosition(i2);
            generatorExpression.setFilter(conditionDataCondition.condition);
            generatorExpression.setFilterLp(conditionDataCondition.lp - i);
            generatorExpression.setFilterRp(conditionDataCondition.rp - i);
        }
        return generatorExpression;
    }

    private GeneratorExpressionLoop generatorExpressionLoop() throws IOException {
        AstNode astNodeCreateNameNode;
        if (nextToken() != 120) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        GeneratorExpressionLoop generatorExpressionLoop = new GeneratorExpressionLoop(i);
        pushScope(generatorExpressionLoop);
        try {
            int i2 = mustMatchToken(88, "msg.no.paren.for") ? this.ts.tokenBeg - i : -1;
            int iPeekToken = peekToken();
            if (iPeekToken == 39) {
                consumeToken();
                astNodeCreateNameNode = createNameNode();
            } else if (iPeekToken == 84 || iPeekToken == 86) {
                astNodeCreateNameNode = destructuringPrimaryExpr();
                markDestructuring(astNodeCreateNameNode);
            } else {
                reportError("msg.bad.var");
                astNodeCreateNameNode = null;
            }
            if (astNodeCreateNameNode.getType() == 39) {
                defineSymbol(154, this.ts.getString(), true);
            }
            int i3 = mustMatchToken(52, "msg.in.after.for.name") ? this.ts.tokenBeg - i : -1;
            AstNode astNodeExpr = expr();
            int i4 = mustMatchToken(89, "msg.no.paren.for.ctrl") ? this.ts.tokenBeg - i : -1;
            generatorExpressionLoop.setLength(this.ts.tokenEnd - i);
            generatorExpressionLoop.setIterator(astNodeCreateNameNode);
            generatorExpressionLoop.setIteratedObject(astNodeExpr);
            generatorExpressionLoop.setInPosition(i3);
            generatorExpressionLoop.setParens(i2, i4);
            return generatorExpressionLoop;
        } finally {
            popScope();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010c A[LOOP:0: B:7:0x0026->B:72:0x010c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0113 A[EDGE_INSN: B:79:0x0113->B:73:0x0113 BREAK  A[LOOP:0: B:7:0x0026->B:72:0x010c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.ObjectLiteral objectLiteral() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.objectLiteral():org.mozilla.javascript.ast.ObjectLiteral");
    }

    private AstNode objliteralProperty() throws IOException {
        switch (peekToken()) {
            case 39:
                return createNameNode();
            case 40:
                return new NumberLiteral(this.ts.tokenBeg, this.ts.getString(), this.ts.getNumber());
            case 41:
                return createStringLiteral();
            default:
                if (this.compilerEnv.isReservedKeywordAsIdentifier() && TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                    return createNameNode();
                }
                return null;
        }
    }

    private ObjectProperty plainProperty(AstNode astNode, int i) throws IOException {
        int iPeekToken = peekToken();
        if ((iPeekToken == 90 || iPeekToken == 87) && i == 39 && this.compilerEnv.getLanguageVersion() >= 180) {
            if (!this.inDestructuringAssignment) {
                reportError("msg.bad.object.init");
            }
            Name name = new Name(astNode.getPosition(), astNode.getString());
            ObjectProperty objectProperty = new ObjectProperty();
            objectProperty.putProp(26, Boolean.TRUE);
            objectProperty.setLeftAndRight(astNode, name);
            return objectProperty;
        }
        mustMatchToken(104, "msg.no.colon.prop");
        ObjectProperty objectProperty2 = new ObjectProperty();
        objectProperty2.setOperatorPosition(this.ts.tokenBeg);
        objectProperty2.setLeftAndRight(astNode, assignExpr());
        return objectProperty2;
    }

    private ObjectProperty methodDefinition(int i, AstNode astNode, int i2) throws IOException {
        FunctionNode functionNodeFunction = function(2);
        Name functionName = functionNodeFunction.getFunctionName();
        if (functionName != null && functionName.length() != 0) {
            reportError("msg.bad.prop");
        }
        ObjectProperty objectProperty = new ObjectProperty(i);
        if (i2 == 2) {
            objectProperty.setIsGetterMethod();
            functionNodeFunction.setFunctionIsGetterMethod();
        } else if (i2 == 4) {
            objectProperty.setIsSetterMethod();
            functionNodeFunction.setFunctionIsSetterMethod();
        } else if (i2 == 8) {
            objectProperty.setIsNormalMethod();
            functionNodeFunction.setFunctionIsNormalMethod();
        }
        int nodeEnd = getNodeEnd(functionNodeFunction);
        objectProperty.setLeft(astNode);
        objectProperty.setRight(functionNodeFunction);
        objectProperty.setLength(nodeEnd - i);
        return objectProperty;
    }

    private Name createNameNode() {
        return createNameNode(false, 39);
    }

    private Name createNameNode(boolean z, int i) {
        int i2 = this.ts.tokenBeg;
        String string = this.ts.getString();
        int i3 = this.ts.lineno;
        String str = "";
        if (!"".equals(this.prevNameTokenString)) {
            i2 = this.prevNameTokenStart;
            string = this.prevNameTokenString;
            i3 = this.prevNameTokenLineno;
            this.prevNameTokenStart = 0;
            this.prevNameTokenString = "";
            this.prevNameTokenLineno = 0;
        }
        if (string != null) {
            str = string;
        } else if (!this.compilerEnv.isIdeMode()) {
            codeBug();
            str = string;
        }
        Name name = new Name(i2, str);
        name.setLineno(i3);
        if (z) {
            checkActivationName(str, i);
        }
        return name;
    }

    private StringLiteral createStringLiteral() {
        int i = this.ts.tokenBeg;
        StringLiteral stringLiteral = new StringLiteral(i, this.ts.tokenEnd - i);
        stringLiteral.setLineno(this.ts.lineno);
        stringLiteral.setValue(this.ts.getString());
        stringLiteral.setQuoteCharacter(this.ts.getQuoteChar());
        return stringLiteral;
    }

    protected void checkActivationName(String str, int i) {
        if (insideFunction()) {
            if ((!"arguments".equals(str) || ((FunctionNode) this.currentScriptOrFn).getFunctionType() == 4) && ((this.compilerEnv.getActivationNames() == null || !this.compilerEnv.getActivationNames().contains(str)) && !(Range.ATTR_LENGTH.equals(str) && i == 33 && this.compilerEnv.getLanguageVersion() == 120))) {
                return;
            }
            setRequiresActivation();
        }
    }

    protected void setRequiresActivation() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setRequiresActivation();
        }
    }

    private void checkCallRequiresActivation(AstNode astNode) {
        if ((astNode.getType() == 39 && "eval".equals(((Name) astNode).getIdentifier())) || (astNode.getType() == 33 && "eval".equals(((PropertyGet) astNode).getProperty().getIdentifier()))) {
            setRequiresActivation();
        }
    }

    protected void setIsGenerator() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setIsGenerator();
        }
    }

    private void checkBadIncDec(UnaryExpression unaryExpression) {
        int type = removeParens(unaryExpression.getOperand()).getType();
        if (type == 39 || type == 33 || type == 36 || type == 68 || type == 38) {
            return;
        }
        reportError(unaryExpression.getType() == 107 ? "msg.bad.incr" : "msg.bad.decr");
    }

    private ErrorNode makeErrorNode() {
        ErrorNode errorNode = new ErrorNode(this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
        errorNode.setLineno(this.ts.lineno);
        return errorNode;
    }

    private int nodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private void saveNameTokenData(int i, String str, int i2) {
        this.prevNameTokenStart = i;
        this.prevNameTokenString = str;
        this.prevNameTokenLineno = i2;
    }

    private int lineBeginningFor(int i) {
        char[] cArr = this.sourceChars;
        if (cArr == null) {
            return -1;
        }
        if (i <= 0) {
            return 0;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return 0;
            }
            if (ScriptRuntime.isJSLineTerminator(cArr[i2])) {
                return i;
            }
            i = i2;
        }
    }

    private void warnMissingSemi(int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            int[] iArr = new int[2];
            String line = this.ts.getLine(i2, iArr);
            if (this.compilerEnv.isIdeMode()) {
                i = Math.max(i, i2 - iArr[1]);
            }
            int i3 = i;
            if (line != null) {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3, iArr[0], line, iArr[1]);
            } else {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3);
            }
        }
    }

    private void warnTrailingComma(int i, List<?> list, int i2) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!list.isEmpty()) {
                i = ((AstNode) list.get(0)).getPosition();
            }
            int iMax = Math.max(i, lineBeginningFor(i2));
            addWarning("msg.extra.trailing.comma", iMax, i2 - iMax);
        }
    }

    private String readFully(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder(1024);
            while (true) {
                int i = bufferedReader.read(cArr, 0, 1024);
                if (i != -1) {
                    sb.append(cArr, 0, i);
                } else {
                    return sb.toString();
                }
            }
        } finally {
            bufferedReader.close();
        }
    }

    protected class PerFunctionVariables {
        private Scope savedCurrentScope;
        private ScriptNode savedCurrentScriptOrFn;
        private int savedEndFlags;
        private boolean savedInForInit;
        private Map<String, LabeledStatement> savedLabelSet;
        private List<Jump> savedLoopAndSwitchSet;
        private List<Loop> savedLoopSet;

        PerFunctionVariables(FunctionNode functionNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = functionNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = functionNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }

        void restore() {
            Parser.this.currentScriptOrFn = this.savedCurrentScriptOrFn;
            Parser.this.currentScope = this.savedCurrentScope;
            Parser.this.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }

    Node createDestructuringAssignment(int i, Node node, Node node2) {
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        Node nodeDestructuringAssignmentHelper = destructuringAssignmentHelper(i, node, node2, nextTempName);
        nodeDestructuringAssignmentHelper.getLastChild().addChildToBack(createName(nextTempName));
        return nodeDestructuringAssignmentHelper;
    }

    Node destructuringAssignmentHelper(int i, Node node, Node node2, String str) {
        Scope scopeCreateScopeNode = createScopeNode(159, node.getLineno());
        scopeCreateScopeNode.addChildToFront(new Node(154, createName(39, str, node2)));
        try {
            pushScope(scopeCreateScopeNode);
            boolean zDestructuringArray = true;
            defineSymbol(154, str, true);
            popScope();
            Node node3 = new Node(90);
            scopeCreateScopeNode.addChildToBack(node3);
            List<String> arrayList = new ArrayList<>();
            int type = node.getType();
            if (type == 33 || type == 36) {
                if (i == 123 || i == 154 || i == 155) {
                    reportError("msg.bad.assign.left");
                }
                node3.addChildToBack(simpleAssignment(node, createName(str)));
            } else if (type == 66) {
                zDestructuringArray = destructuringArray((ArrayLiteral) node, i, str, node3, arrayList);
            } else if (type == 67) {
                zDestructuringArray = destructuringObject((ObjectLiteral) node, i, str, node3, arrayList);
            } else {
                reportError("msg.bad.assign.left");
            }
            if (zDestructuringArray) {
                node3.addChildToBack(createNumber(0.0d));
            }
            scopeCreateScopeNode.putProp(22, arrayList);
            return scopeCreateScopeNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    boolean destructuringArray(ArrayLiteral arrayLiteral, int i, String str, Node node, List<String> list) {
        int i2 = i == 155 ? 156 : 8;
        int i3 = 0;
        boolean z = true;
        for (AstNode astNode : arrayLiteral.getElements()) {
            if (astNode.getType() == 129) {
                i3++;
            } else {
                Node node2 = new Node(36, createName(str), createNumber(i3));
                if (astNode.getType() == 39) {
                    String string = astNode.getString();
                    node.addChildToBack(new Node(i2, createName(49, string, null), node2));
                    if (i != -1) {
                        defineSymbol(i, string, true);
                        list.add(string);
                    }
                } else {
                    node.addChildToBack(destructuringAssignmentHelper(i, astNode, node2, this.currentScriptOrFn.getNextTempName()));
                }
                i3++;
                z = false;
            }
        }
        return z;
    }

    boolean destructuringObject(ObjectLiteral objectLiteral, int i, String str, Node node, List<String> list) {
        Node node2;
        int i2 = i == 155 ? 156 : 8;
        boolean z = true;
        for (ObjectProperty objectProperty : objectLiteral.getElements()) {
            TokenStream tokenStream = this.ts;
            int i3 = tokenStream != null ? tokenStream.lineno : 0;
            AstNode left = objectProperty.getLeft();
            if (left instanceof Name) {
                node2 = new Node(33, createName(str), Node.newString(((Name) left).getIdentifier()));
            } else if (left instanceof StringLiteral) {
                node2 = new Node(33, createName(str), Node.newString(((StringLiteral) left).getValue()));
            } else if (left instanceof NumberLiteral) {
                node2 = new Node(36, createName(str), createNumber((int) ((NumberLiteral) left).getNumber()));
            } else {
                throw codeBug();
            }
            node2.setLineno(i3);
            AstNode right = objectProperty.getRight();
            if (right.getType() == 39) {
                String identifier = ((Name) right).getIdentifier();
                node.addChildToBack(new Node(i2, createName(49, identifier, null), node2));
                if (i != -1) {
                    defineSymbol(i, identifier, true);
                    list.add(identifier);
                }
            } else {
                node.addChildToBack(destructuringAssignmentHelper(i, right, node2, this.currentScriptOrFn.getNextTempName()));
            }
            z = false;
        }
        return z;
    }

    protected Node createName(String str) {
        checkActivationName(str, 39);
        return Node.newString(39, str);
    }

    protected Node createName(int i, String str, Node node) {
        Node nodeCreateName = createName(str);
        nodeCreateName.setType(i);
        if (node != null) {
            nodeCreateName.addChildToBack(node);
        }
        return nodeCreateName;
    }

    protected Node createNumber(double d2) {
        return Node.newNumber(d2);
    }

    protected Scope createScopeNode(int i, int i2) {
        Scope scope = new Scope();
        scope.setType(i);
        scope.setLineno(i2);
        return scope;
    }

    protected Node simpleAssignment(Node node, Node node2) {
        Node firstChild;
        Node lastChild;
        int i;
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type != 39) {
                if (type == 68) {
                    Node firstChild2 = node.getFirstChild();
                    checkMutableReference(firstChild2);
                    return new Node(69, firstChild2, node2);
                }
                throw codeBug();
            }
            String identifier = ((Name) node).getIdentifier();
            if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                reportError("msg.bad.id.strict", identifier);
            }
            node.setType(49);
            return new Node(8, node, node2);
        }
        if (node instanceof PropertyGet) {
            PropertyGet propertyGet = (PropertyGet) node;
            firstChild = propertyGet.getTarget();
            lastChild = propertyGet.getProperty();
        } else if (node instanceof ElementGet) {
            ElementGet elementGet = (ElementGet) node;
            firstChild = elementGet.getTarget();
            lastChild = elementGet.getElement();
        } else {
            firstChild = node.getFirstChild();
            lastChild = node.getLastChild();
        }
        if (type == 33) {
            lastChild.setType(41);
            i = 35;
        } else {
            i = 37;
        }
        return new Node(i, firstChild, lastChild, node2);
    }

    protected void checkMutableReference(Node node) {
        if ((node.getIntProp(16, 0) & 4) != 0) {
            reportError("msg.bad.assign.left");
        }
    }

    protected AstNode removeParens(AstNode astNode) {
        while (astNode instanceof ParenthesizedExpression) {
            astNode = ((ParenthesizedExpression) astNode).getExpression();
        }
        return astNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void markDestructuring(AstNode astNode) {
        if (astNode instanceof DestructuringForm) {
            ((DestructuringForm) astNode).setIsDestructuring(true);
        } else if (astNode instanceof ParenthesizedExpression) {
            markDestructuring(((ParenthesizedExpression) astNode).getExpression());
        }
    }

    private RuntimeException codeBug() throws RuntimeException {
        throw Kit.codeBug("ts.cursor=" + this.ts.cursor + ", ts.tokenBeg=" + this.ts.tokenBeg + ", currentToken=" + this.currentToken);
    }

    public void setDefaultUseStrictDirective(boolean z) {
        this.defaultUseStrictDirective = z;
    }

    public boolean inUseStrictDirective() {
        return this.inUseStrictDirective;
    }
}
