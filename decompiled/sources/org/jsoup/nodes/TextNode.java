package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* JADX INFO: loaded from: classes10.dex */
public class TextNode extends LeafNode {
    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node empty() {
        return super.empty();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public TextNode(String str) {
        this.value = str;
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#text";
    }

    public String text() {
        return StringUtil.normaliseWhitespace(getWholeText());
    }

    public TextNode text(String str) {
        coreValue(str);
        return this;
    }

    public String getWholeText() {
        return coreValue();
    }

    public boolean isBlank() {
        return StringUtil.isBlank(coreValue());
    }

    public TextNode splitText(int i) {
        String strCoreValue = coreValue();
        Validate.isTrue(i >= 0, "Split offset must be not be negative");
        Validate.isTrue(i < strCoreValue.length(), "Split offset must not be greater than current text length");
        String strSubstring = strCoreValue.substring(0, i);
        String strSubstring2 = strCoreValue.substring(i);
        text(strSubstring);
        TextNode textNode = new TextNode(strSubstring2);
        if (this.parentNode != null) {
            this.parentNode.addChildren(siblingIndex() + 1, textNode);
        }
        return textNode;
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        boolean z;
        boolean z2;
        boolean zPrettyPrint = outputSettings.prettyPrint();
        Element element = this.parentNode instanceof Element ? (Element) this.parentNode : null;
        boolean z3 = zPrettyPrint && !Element.preserveWhitespace(this.parentNode);
        if (z3) {
            boolean z4 = (this.siblingIndex == 0 && element != null && element.tag().isBlock()) || (this.parentNode instanceof Document);
            boolean z5 = nextSibling() == null && element != null && element.tag().isBlock();
            Node nodeNextSibling = nextSibling();
            if ((((nodeNextSibling instanceof Element) && ((Element) nodeNextSibling).shouldIndent(outputSettings)) || ((nodeNextSibling instanceof TextNode) && ((TextNode) nodeNextSibling).isBlank())) && isBlank()) {
                return;
            }
            if ((this.siblingIndex == 0 && element != null && element.tag().formatAsBlock() && !isBlank()) || (outputSettings.outline() && siblingNodes().size() > 0 && !isBlank())) {
                indent(appendable, i, outputSettings);
            }
            z = z4;
            z2 = z5;
        } else {
            z = false;
            z2 = false;
        }
        Entities.escape(appendable, coreValue(), outputSettings, false, z3, z, z2);
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node
    /* JADX INFO: renamed from: clone */
    public TextNode mo14259clone() {
        return (TextNode) super.mo14259clone();
    }

    public static TextNode createFromEncoded(String str) {
        return new TextNode(Entities.unescape(str));
    }

    static String normaliseWhitespace(String str) {
        return StringUtil.normaliseWhitespace(str);
    }

    static String stripLeadingWhitespace(String str) {
        return str.replaceFirst("^\\s+", "");
    }

    static boolean lastCharIsWhitespace(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }
}
