package org.jsoup.safety;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* JADX INFO: loaded from: classes10.dex */
public class Cleaner {
    private final Safelist safelist;

    public Cleaner(Safelist safelist) {
        Validate.notNull(safelist);
        this.safelist = safelist;
    }

    public Document clean(Document document) {
        Validate.notNull(document);
        Document documentCreateShell = Document.createShell(document.baseUri());
        copySafeNodes(document.body(), documentCreateShell.body());
        documentCreateShell.outputSettings(document.outputSettings().clone());
        return documentCreateShell;
    }

    public boolean isValid(Document document) {
        Validate.notNull(document);
        return copySafeNodes(document.body(), Document.createShell(document.baseUri()).body()) == 0 && document.head().childNodes().isEmpty();
    }

    public boolean isValidBodyHtml(String str) {
        Document documentCreateShell = Document.createShell("");
        Document documentCreateShell2 = Document.createShell("");
        ParseErrorList parseErrorListTracking = ParseErrorList.tracking(1);
        documentCreateShell2.body().insertChildren(0, Parser.parseFragment(str, documentCreateShell2.body(), "", parseErrorListTracking));
        return copySafeNodes(documentCreateShell2.body(), documentCreateShell.body()) == 0 && parseErrorListTracking.isEmpty();
    }

    private final class CleaningVisitor implements NodeVisitor {
        private Element destination;
        private int numDiscarded;
        private final Element root;

        private CleaningVisitor(Element element, Element element2) {
            this.numDiscarded = 0;
            this.root = element;
            this.destination = element2;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (Cleaner.this.safelist.isSafeTag(element.normalName())) {
                    ElementMeta elementMetaCreateSafeElement = Cleaner.this.createSafeElement(element);
                    Element element2 = elementMetaCreateSafeElement.el;
                    this.destination.appendChild(element2);
                    this.numDiscarded += elementMetaCreateSafeElement.numAttribsDiscarded;
                    this.destination = element2;
                    return;
                }
                if (node != this.root) {
                    this.numDiscarded++;
                    return;
                }
                return;
            }
            if (node instanceof TextNode) {
                this.destination.appendChild(new TextNode(((TextNode) node).getWholeText()));
            } else if ((node instanceof DataNode) && Cleaner.this.safelist.isSafeTag(node.parent().nodeName())) {
                this.destination.appendChild(new DataNode(((DataNode) node).getWholeData()));
            } else {
                this.numDiscarded++;
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof Element) && Cleaner.this.safelist.isSafeTag(node.nodeName())) {
                this.destination = this.destination.parent();
            }
        }
    }

    private int copySafeNodes(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(element, element2);
        NodeTraversor.traverse(cleaningVisitor, element);
        return cleaningVisitor.numDiscarded;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ElementMeta createSafeElement(Element element) {
        String strTagName = element.tagName();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.valueOf(strTagName), element.baseUri(), attributes);
        int i = 0;
        for (Attribute attribute : element.attributes()) {
            if (this.safelist.isSafeAttribute(strTagName, element, attribute)) {
                attributes.put(attribute);
            } else {
                i++;
            }
        }
        attributes.addAll(this.safelist.getEnforcedAttributes(strTagName));
        if (element.sourceRange().isTracked()) {
            element.sourceRange().track(element2, true);
        }
        if (element.endSourceRange().isTracked()) {
            element.endSourceRange().track(element2, false);
        }
        return new ElementMeta(element2, i);
    }

    private static class ElementMeta {
        Element el;
        int numAttribsDiscarded;

        ElementMeta(Element element, int i) {
            this.el = element;
            this.numAttribsDiscarded = i;
        }
    }
}
