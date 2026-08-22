package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;

/* JADX INFO: loaded from: classes10.dex */
public class CDataNode extends TextNode {
    public CDataNode(String str) {
        super(str);
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    public String nodeName() {
        return "#cdata";
    }

    @Override // org.jsoup.nodes.TextNode
    public String text() {
        return getWholeText();
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("<![CDATA[").append(getWholeText());
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
        try {
            appendable.append("]]>");
        } catch (IOException e2) {
            throw new UncheckedIOException(e2);
        }
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    /* JADX INFO: renamed from: clone */
    public CDataNode mo14259clone() {
        return (CDataNode) super.mo14259clone();
    }
}
