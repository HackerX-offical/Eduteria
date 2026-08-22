package org.jsoup.nodes;

import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.jsoup.parser.HtmlTreeBuilder;
import org.jsoup.parser.Parser;

/* JADX INFO: loaded from: classes10.dex */
final class NodeUtils {
    NodeUtils() {
    }

    static Document.OutputSettings outputSettings(Node node) {
        Document documentOwnerDocument = node.ownerDocument();
        return documentOwnerDocument != null ? documentOwnerDocument.outputSettings() : new Document("").outputSettings();
    }

    static Parser parser(Node node) {
        Document documentOwnerDocument = node.ownerDocument();
        return (documentOwnerDocument == null || documentOwnerDocument.parser() == null) ? new Parser(new HtmlTreeBuilder()) : documentOwnerDocument.parser();
    }

    static <T extends Node> List<T> selectXpath(String str, Element element, Class<T> cls) {
        Validate.notEmpty(str);
        Validate.notNull(element);
        Validate.notNull(cls);
        W3CDom w3CDomNamespaceAware = new W3CDom().namespaceAware(false);
        return w3CDomNamespaceAware.sourceNodes(w3CDomNamespaceAware.selectXpath(str, w3CDomNamespaceAware.contextNode(w3CDomNamespaceAware.fromJsoup(element))), cls);
    }
}
