package org.jsoup.parser;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.Range;
import org.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes10.dex */
public abstract class TreeBuilder {
    protected String baseUri;
    protected Token currentToken;
    protected Document doc;
    protected Parser parser;
    CharacterReader reader;
    protected Map<String, Tag> seenTags;
    protected ParseSettings settings;
    protected ArrayList<Element> stack;
    Tokeniser tokeniser;
    private boolean trackSourceRange;
    private Token.StartTag start = new Token.StartTag();
    private Token.EndTag end = new Token.EndTag();

    abstract ParseSettings defaultSettings();

    protected boolean isContentForTagData(String str) {
        return false;
    }

    abstract TreeBuilder newInstance();

    abstract List<Node> parseFragment(String str, Element element, String str2, Parser parser);

    protected abstract boolean process(Token token);

    TreeBuilder() {
    }

    @ParametersAreNonnullByDefault
    protected void initialiseParse(Reader reader, String str, Parser parser) {
        Validate.notNullParam(reader, "input");
        Validate.notNullParam(str, "baseUri");
        Validate.notNull(parser);
        Document document = new Document(str);
        this.doc = document;
        document.parser(parser);
        this.parser = parser;
        this.settings = parser.settings();
        this.reader = new CharacterReader(reader);
        this.trackSourceRange = parser.isTrackPosition();
        this.reader.trackNewlines(parser.isTrackErrors() || this.trackSourceRange);
        this.currentToken = null;
        this.tokeniser = new Tokeniser(this.reader, parser.getErrors());
        this.stack = new ArrayList<>(32);
        this.seenTags = new HashMap();
        this.baseUri = str;
    }

    @ParametersAreNonnullByDefault
    Document parse(Reader reader, String str, Parser parser) {
        initialiseParse(reader, str, parser);
        runParser();
        this.reader.close();
        this.reader = null;
        this.tokeniser = null;
        this.stack = null;
        this.seenTags = null;
        return this.doc;
    }

    protected void runParser() {
        Token token;
        Tokeniser tokeniser = this.tokeniser;
        Token.TokenType tokenType = Token.TokenType.EOF;
        do {
            token = tokeniser.read();
            process(token);
            token.reset();
        } while (token.type != tokenType);
    }

    protected boolean processStartTag(String str) {
        Token.StartTag startTag = this.start;
        if (this.currentToken == startTag) {
            return process(new Token.StartTag().name(str));
        }
        return process(startTag.reset().name(str));
    }

    public boolean processStartTag(String str, Attributes attributes) {
        Token.StartTag startTag = this.start;
        if (this.currentToken == startTag) {
            return process(new Token.StartTag().nameAttr(str, attributes));
        }
        startTag.reset();
        startTag.nameAttr(str, attributes);
        return process(startTag);
    }

    protected boolean processEndTag(String str) {
        Token token = this.currentToken;
        Token.EndTag endTag = this.end;
        if (token == endTag) {
            return process(new Token.EndTag().name(str));
        }
        return process(endTag.reset().name(str));
    }

    protected Element currentElement() {
        int size = this.stack.size();
        return size > 0 ? this.stack.get(size - 1) : this.doc;
    }

    protected boolean currentElementIs(String str) {
        Element elementCurrentElement;
        return (this.stack.size() == 0 || (elementCurrentElement = currentElement()) == null || !elementCurrentElement.normalName().equals(str)) ? false : true;
    }

    protected void error(String str) {
        error(str, null);
    }

    protected void error(String str, Object... objArr) {
        ParseErrorList errors = this.parser.getErrors();
        if (errors.canAddError()) {
            errors.add(new ParseError(this.reader, str, objArr));
        }
    }

    protected Tag tagFor(String str, ParseSettings parseSettings) {
        Tag tag = this.seenTags.get(str);
        if (tag != null) {
            return tag;
        }
        Tag tagValueOf = Tag.valueOf(str, parseSettings);
        this.seenTags.put(str, tagValueOf);
        return tagValueOf;
    }

    protected void onNodeInserted(Node node, @Nullable Token token) {
        trackNodePosition(node, token, true);
    }

    protected void onNodeClosed(Node node, Token token) {
        trackNodePosition(node, token, false);
    }

    private void trackNodePosition(Node node, @Nullable Token token, boolean z) {
        int iStartPos;
        if (!this.trackSourceRange || token == null || (iStartPos = token.startPos()) == -1) {
            return;
        }
        Range.Position position = new Range.Position(iStartPos, this.reader.lineNumber(iStartPos), this.reader.columnNumber(iStartPos));
        int iEndPos = token.endPos();
        new Range(position, new Range.Position(iEndPos, this.reader.lineNumber(iEndPos), this.reader.columnNumber(iEndPos))).track(node, z);
    }
}
