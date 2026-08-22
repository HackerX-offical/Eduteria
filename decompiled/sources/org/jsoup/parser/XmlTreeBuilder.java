package org.jsoup.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Token;

/* JADX INFO: loaded from: classes10.dex */
public class XmlTreeBuilder extends TreeBuilder {
    private static final int maxQueueDepth = 256;

    @Override // org.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    @Override // org.jsoup.parser.TreeBuilder
    ParseSettings defaultSettings() {
        return ParseSettings.preserveCase;
    }

    @Override // org.jsoup.parser.TreeBuilder
    @ParametersAreNonnullByDefault
    protected void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.stack.add(this.doc);
        this.doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml).escapeMode(Entities.EscapeMode.xhtml).prettyPrint(false);
    }

    Document parse(Reader reader, String str) {
        return parse(reader, str, new Parser(this));
    }

    Document parse(String str, String str2) {
        return parse(new StringReader(str), str2, new Parser(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jsoup.parser.TreeBuilder
    public XmlTreeBuilder newInstance() {
        return new XmlTreeBuilder();
    }

    /* JADX INFO: renamed from: org.jsoup.parser.XmlTreeBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Comment.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // org.jsoup.parser.TreeBuilder
    protected boolean process(Token token) {
        switch (AnonymousClass1.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
            case 1:
                insert(token.asStartTag());
                break;
            case 2:
                popStackToClose(token.asEndTag());
                break;
            case 3:
                insert(token.asComment());
                break;
            case 4:
                insert(token.asCharacter());
                break;
            case 5:
                insert(token.asDoctype());
                break;
            case 6:
                break;
            default:
                Validate.fail("Unexpected token type: " + token.type);
                break;
        }
        return true;
    }

    protected void insertNode(Node node) {
        currentElement().appendChild(node);
        onNodeInserted(node, null);
    }

    protected void insertNode(Node node, Token token) {
        currentElement().appendChild(node);
        onNodeInserted(node, token);
    }

    Element insert(Token.StartTag startTag) {
        Tag tagTagFor = tagFor(startTag.name(), this.settings);
        if (startTag.hasAttributes()) {
            startTag.attributes.deduplicate(this.settings);
        }
        Element element = new Element(tagTagFor, null, this.settings.normalizeAttributes(startTag.attributes));
        insertNode(element, startTag);
        if (startTag.isSelfClosing()) {
            if (!tagTagFor.isKnownTag()) {
                tagTagFor.setSelfClosing();
            }
            return element;
        }
        this.stack.add(element);
        return element;
    }

    void insert(Token.Comment comment) {
        XmlDeclaration xmlDeclarationAsXmlDeclaration;
        Comment comment2 = new Comment(comment.getData());
        if (comment.bogus && comment2.isXmlDeclaration() && (xmlDeclarationAsXmlDeclaration = comment2.asXmlDeclaration()) != null) {
            comment2 = xmlDeclarationAsXmlDeclaration;
        }
        insertNode(comment2, comment);
    }

    void insert(Token.Character character) {
        String data = character.getData();
        insertNode(character.isCData() ? new CDataNode(data) : new TextNode(data), character);
    }

    void insert(Token.Doctype doctype) {
        DocumentType documentType = new DocumentType(this.settings.normalizeTag(doctype.getName()), doctype.getPublicIdentifier(), doctype.getSystemIdentifier());
        documentType.setPubSysKey(doctype.getPubSysKey());
        insertNode(documentType, doctype);
    }

    protected void popStackToClose(Token.EndTag endTag) {
        Element element;
        String strNormalizeTag = this.settings.normalizeTag(endTag.tagName);
        int size = this.stack.size();
        int i = size + (-1) >= 256 ? size - 257 : 0;
        int size2 = this.stack.size() - 1;
        while (true) {
            if (size2 < i) {
                element = null;
                break;
            }
            element = this.stack.get(size2);
            if (element.nodeName().equals(strNormalizeTag)) {
                break;
            } else {
                size2--;
            }
        }
        if (element == null) {
            return;
        }
        for (int size3 = this.stack.size() - 1; size3 >= 0; size3--) {
            Element element2 = this.stack.get(size3);
            this.stack.remove(size3);
            if (element2 == element) {
                onNodeClosed(element2, endTag);
                return;
            }
        }
    }

    List<Node> parseFragment(String str, String str2, Parser parser) {
        initialiseParse(new StringReader(str), str2, parser);
        runParser();
        return this.doc.childNodes();
    }

    @Override // org.jsoup.parser.TreeBuilder
    List<Node> parseFragment(String str, Element element, String str2, Parser parser) {
        return parseFragment(str, str2, parser);
    }
}
