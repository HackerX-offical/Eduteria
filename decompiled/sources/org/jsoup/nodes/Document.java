package org.jsoup.nodes;

import com.x5.template.ThemeConfig;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

/* JADX INFO: loaded from: classes10.dex */
public class Document extends Element {
    private static final Evaluator titleEval = new Evaluator.Tag("title");

    @Nullable
    private Connection connection;
    private final String location;
    private OutputSettings outputSettings;
    private Parser parser;
    private QuirksMode quirksMode;
    private boolean updateMetaCharset;

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), str);
        this.outputSettings = new OutputSettings();
        this.quirksMode = QuirksMode.noQuirks;
        this.updateMetaCharset = false;
        this.location = str;
        this.parser = Parser.htmlParser();
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        document.parser = document.parser();
        Element elementAppendElement = document.appendElement("html");
        elementAppendElement.appendElement("head");
        elementAppendElement.appendElement("body");
        return document;
    }

    public String location() {
        return this.location;
    }

    public Connection connection() {
        Connection connection = this.connection;
        return connection == null ? Jsoup.newSession() : connection;
    }

    @Nullable
    public DocumentType documentType() {
        for (Node node : this.childNodes) {
            if (node instanceof DocumentType) {
                return (DocumentType) node;
            }
            if (!(node instanceof LeafNode)) {
                return null;
            }
        }
        return null;
    }

    private Element htmlEl() {
        for (Element element : childElementsList()) {
            if (element.normalName().equals("html")) {
                return element;
            }
        }
        return appendElement("html");
    }

    public Element head() {
        Element elementHtmlEl = htmlEl();
        for (Element element : elementHtmlEl.childElementsList()) {
            if (element.normalName().equals("head")) {
                return element;
            }
        }
        return elementHtmlEl.prependElement("head");
    }

    public Element body() {
        Element elementHtmlEl = htmlEl();
        for (Element element : elementHtmlEl.childElementsList()) {
            if ("body".equals(element.normalName()) || "frameset".equals(element.normalName())) {
                return element;
            }
        }
        return elementHtmlEl.appendElement("body");
    }

    public String title() {
        Element elementSelectFirst = head().selectFirst(titleEval);
        return elementSelectFirst != null ? StringUtil.normaliseWhitespace(elementSelectFirst.text()).trim() : "";
    }

    public void title(String str) {
        Validate.notNull(str);
        Element elementSelectFirst = head().selectFirst(titleEval);
        if (elementSelectFirst == null) {
            elementSelectFirst = head().appendElement("title");
        }
        elementSelectFirst.text(str);
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str, ParseSettings.preserveCase), baseUri());
    }

    public Document normalise() {
        Element elementHtmlEl = htmlEl();
        Element elementHead = head();
        body();
        normaliseTextNodes(elementHead);
        normaliseTextNodes(elementHtmlEl);
        normaliseTextNodes(this);
        normaliseStructure("head", elementHtmlEl);
        normaliseStructure("body", elementHtmlEl);
        ensureMetaCharsetElement();
        return this;
    }

    private void normaliseTextNodes(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.childNodes) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(" "));
            body().prependChild(node2);
        }
    }

    private void normaliseStructure(String str, Element element) {
        Elements elementsByTag = getElementsByTag(str);
        Element elementFirst = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < elementsByTag.size(); i++) {
                Element element2 = elementsByTag.get(i);
                arrayList.addAll(element2.ensureChildNodes());
                element2.remove();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                elementFirst.appendChild((Node) it.next());
            }
        }
        if (elementFirst.parent() == null || elementFirst.parent().equals(element)) {
            return;
        }
        element.appendChild(elementFirst);
    }

    @Override // org.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    @Override // org.jsoup.nodes.Element
    public Element text(String str) {
        body().text(str);
        return this;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        this.outputSettings.charset(charset);
        ensureMetaCharsetElement();
    }

    public Charset charset() {
        return this.outputSettings.charset();
    }

    public void updateMetaCharsetElement(boolean z) {
        this.updateMetaCharset = z;
    }

    public boolean updateMetaCharsetElement() {
        return this.updateMetaCharset;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Document mo14259clone() {
        Document document = (Document) super.mo14259clone();
        document.outputSettings = this.outputSettings.clone();
        return document;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public Document shallowClone() {
        Document document = new Document(baseUri());
        if (this.attributes != null) {
            document.attributes = this.attributes.clone();
        }
        document.outputSettings = this.outputSettings.clone();
        return document;
    }

    private void ensureMetaCharsetElement() {
        if (this.updateMetaCharset) {
            OutputSettings.Syntax syntax = outputSettings().syntax();
            if (syntax == OutputSettings.Syntax.html) {
                Element elementSelectFirst = selectFirst("meta[charset]");
                if (elementSelectFirst != null) {
                    elementSelectFirst.attr("charset", charset().displayName());
                } else {
                    head().appendElement("meta").attr("charset", charset().displayName());
                }
                select("meta[name=charset]").remove();
                return;
            }
            if (syntax == OutputSettings.Syntax.xml) {
                Node node = ensureChildNodes().get(0);
                if (node instanceof XmlDeclaration) {
                    XmlDeclaration xmlDeclaration = (XmlDeclaration) node;
                    if (xmlDeclaration.name().equals(AbstractHttpOverXmpp.Xml.ELEMENT)) {
                        xmlDeclaration.attr(ThemeConfig.ENCODING, charset().displayName());
                        if (xmlDeclaration.hasAttr("version")) {
                            xmlDeclaration.attr("version", "1.0");
                            return;
                        }
                        return;
                    }
                    XmlDeclaration xmlDeclaration2 = new XmlDeclaration(AbstractHttpOverXmpp.Xml.ELEMENT, false);
                    xmlDeclaration2.attr("version", "1.0");
                    xmlDeclaration2.attr(ThemeConfig.ENCODING, charset().displayName());
                    prependChild(xmlDeclaration2);
                    return;
                }
                XmlDeclaration xmlDeclaration3 = new XmlDeclaration(AbstractHttpOverXmpp.Xml.ELEMENT, false);
                xmlDeclaration3.attr("version", "1.0");
                xmlDeclaration3.attr(ThemeConfig.ENCODING, charset().displayName());
                prependChild(xmlDeclaration3);
            }
        }
    }

    public static class OutputSettings implements Cloneable {

        @Nullable
        Entities.CoreCharset coreCharset;
        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private Charset charset = DataUtil.UTF_8;
        private final ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>();
        private boolean prettyPrint = true;
        private boolean outline = false;
        private int indentAmount = 1;
        private int maxPaddingWidth = 30;
        private Syntax syntax = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        public Charset charset() {
            return this.charset;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }

        CharsetEncoder prepareEncoder() {
            CharsetEncoder charsetEncoderNewEncoder = this.charset.newEncoder();
            this.encoderThreadLocal.set(charsetEncoderNewEncoder);
            this.coreCharset = Entities.CoreCharset.byName(charsetEncoderNewEncoder.charset().name());
            return charsetEncoderNewEncoder;
        }

        CharsetEncoder encoder() {
            CharsetEncoder charsetEncoder = this.encoderThreadLocal.get();
            return charsetEncoder != null ? charsetEncoder : prepareEncoder();
        }

        public Syntax syntax() {
            return this.syntax;
        }

        public OutputSettings syntax(Syntax syntax) {
            this.syntax = syntax;
            return this;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public boolean outline() {
            return this.outline;
        }

        public OutputSettings outline(boolean z) {
            this.outline = z;
            return this;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public OutputSettings indentAmount(int i) {
            Validate.isTrue(i >= 0);
            this.indentAmount = i;
            return this;
        }

        public int maxPaddingWidth() {
            return this.maxPaddingWidth;
        }

        public OutputSettings maxPaddingWidth(int i) {
            Validate.isTrue(i >= -1);
            this.maxPaddingWidth = i;
            return this;
        }

        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    public Parser parser() {
        return this.parser;
    }

    public Document parser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public Document connection(Connection connection) {
        Validate.notNull(connection);
        this.connection = connection;
        return this;
    }
}
