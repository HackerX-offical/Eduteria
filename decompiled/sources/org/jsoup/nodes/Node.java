package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import org.jsoup.SerializationException;
import org.jsoup.helper.Consumer;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Node implements Cloneable {
    static final List<Node> EmptyNodes = Collections.emptyList();
    static final String EmptyString = "";

    @Nullable
    Node parentNode;
    int siblingIndex;

    public abstract Attributes attributes();

    public abstract String baseUri();

    public abstract int childNodeSize();

    protected abstract void doSetBaseUri(String str);

    public abstract Node empty();

    protected abstract List<Node> ensureChildNodes();

    public boolean equals(@Nullable Object obj) {
        return this == obj;
    }

    protected abstract boolean hasAttributes();

    public abstract String nodeName();

    void nodelistChanged() {
    }

    abstract void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    abstract void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    protected Node() {
    }

    public boolean hasParent() {
        return this.parentNode != null;
    }

    public String attr(String str) {
        Validate.notNull(str);
        if (!hasAttributes()) {
            return "";
        }
        String ignoreCase = attributes().getIgnoreCase(str);
        return ignoreCase.length() > 0 ? ignoreCase : str.startsWith("abs:") ? absUrl(str.substring("abs:".length())) : "";
    }

    public int attributesSize() {
        if (hasAttributes()) {
            return attributes().size();
        }
        return 0;
    }

    public Node attr(String str, String str2) {
        attributes().putIgnoreCase(NodeUtils.parser(this).settings().normalizeAttribute(str), str2);
        return this;
    }

    public boolean hasAttr(String str) {
        Validate.notNull(str);
        if (!hasAttributes()) {
            return false;
        }
        if (str.startsWith("abs:")) {
            String strSubstring = str.substring("abs:".length());
            if (attributes().hasKeyIgnoreCase(strSubstring) && !absUrl(strSubstring).isEmpty()) {
                return true;
            }
        }
        return attributes().hasKeyIgnoreCase(str);
    }

    public Node removeAttr(String str) {
        Validate.notNull(str);
        if (hasAttributes()) {
            attributes().removeIgnoreCase(str);
        }
        return this;
    }

    public Node clearAttributes() {
        if (hasAttributes()) {
            Iterator<Attribute> it = attributes().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
        return this;
    }

    public void setBaseUri(String str) {
        Validate.notNull(str);
        doSetBaseUri(str);
    }

    public String absUrl(String str) {
        Validate.notEmpty(str);
        if (!hasAttributes() || !attributes().hasKeyIgnoreCase(str)) {
            return "";
        }
        return StringUtil.resolve(baseUri(), attributes().getIgnoreCase(str));
    }

    public Node childNode(int i) {
        return ensureChildNodes().get(i);
    }

    public List<Node> childNodes() {
        if (childNodeSize() == 0) {
            return EmptyNodes;
        }
        List<Node> listEnsureChildNodes = ensureChildNodes();
        ArrayList arrayList = new ArrayList(listEnsureChildNodes.size());
        arrayList.addAll(listEnsureChildNodes);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Node> childNodesCopy() {
        List<Node> listEnsureChildNodes = ensureChildNodes();
        ArrayList arrayList = new ArrayList(listEnsureChildNodes.size());
        Iterator<Node> it = listEnsureChildNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mo14259clone());
        }
        return arrayList;
    }

    protected Node[] childNodesAsArray() {
        return (Node[]) ensureChildNodes().toArray(new Node[0]);
    }

    @Nullable
    public Node parent() {
        return this.parentNode;
    }

    @Nullable
    public final Node parentNode() {
        return this.parentNode;
    }

    public Node root() {
        Node node = this;
        while (true) {
            Node node2 = node.parentNode;
            if (node2 == null) {
                return node;
            }
            node = node2;
        }
    }

    @Nullable
    public Document ownerDocument() {
        Node nodeRoot = root();
        if (nodeRoot instanceof Document) {
            return (Document) nodeRoot;
        }
        return null;
    }

    public void remove() {
        Validate.notNull(this.parentNode);
        this.parentNode.removeChild(this);
    }

    public Node before(String str) {
        addSiblingHtml(this.siblingIndex, str);
        return this;
    }

    public Node before(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex, node);
        return this;
    }

    public Node after(String str) {
        addSiblingHtml(this.siblingIndex + 1, str);
        return this;
    }

    public Node after(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex + 1, node);
        return this;
    }

    private void addSiblingHtml(int i, String str) {
        Validate.notNull(str);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(i, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, parent() instanceof Element ? (Element) parent() : null, baseUri()).toArray(new Node[0]));
    }

    public Node wrap(String str) {
        Element element;
        Validate.notEmpty(str);
        Node node = this.parentNode;
        if (node == null || !(node instanceof Element)) {
            element = this instanceof Element ? (Element) this : null;
        } else {
            element = (Element) node;
        }
        List<Node> fragmentInput = NodeUtils.parser(this).parseFragmentInput(str, element, baseUri());
        Node node2 = fragmentInput.get(0);
        if (node2 instanceof Element) {
            Element element2 = (Element) node2;
            Element deepChild = getDeepChild(element2);
            Node node3 = this.parentNode;
            if (node3 != null) {
                node3.replaceChild(this, element2);
            }
            deepChild.addChildren(this);
            if (fragmentInput.size() > 0) {
                for (int i = 0; i < fragmentInput.size(); i++) {
                    Node node4 = fragmentInput.get(i);
                    if (element2 != node4) {
                        Node node5 = node4.parentNode;
                        if (node5 != null) {
                            node5.removeChild(node4);
                        }
                        element2.after(node4);
                    }
                }
            }
        }
        return this;
    }

    @Nullable
    public Node unwrap() {
        Validate.notNull(this.parentNode);
        Node nodeFirstChild = firstChild();
        this.parentNode.addChildren(this.siblingIndex, childNodesAsArray());
        remove();
        return nodeFirstChild;
    }

    private Element getDeepChild(Element element) {
        Elements elementsChildren = element.children();
        return elementsChildren.size() > 0 ? getDeepChild(elementsChildren.get(0)) : element;
    }

    public void replaceWith(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.replaceChild(this, node);
    }

    protected void setParentNode(Node node) {
        Validate.notNull(node);
        Node node2 = this.parentNode;
        if (node2 != null) {
            node2.removeChild(this);
        }
        this.parentNode = node;
    }

    protected void replaceChild(Node node, Node node2) {
        Validate.isTrue(node.parentNode == this);
        Validate.notNull(node2);
        Node node3 = node2.parentNode;
        if (node3 != null) {
            node3.removeChild(node2);
        }
        int i = node.siblingIndex;
        ensureChildNodes().set(i, node2);
        node2.parentNode = this;
        node2.setSiblingIndex(i);
        node.parentNode = null;
    }

    protected void removeChild(Node node) {
        Validate.isTrue(node.parentNode == this);
        int i = node.siblingIndex;
        ensureChildNodes().remove(i);
        reindexChildren(i);
        node.parentNode = null;
    }

    protected void addChildren(Node... nodeArr) {
        List<Node> listEnsureChildNodes = ensureChildNodes();
        for (Node node : nodeArr) {
            reparentChild(node);
            listEnsureChildNodes.add(node);
            node.setSiblingIndex(listEnsureChildNodes.size() - 1);
        }
    }

    protected void addChildren(int i, Node... nodeArr) {
        Validate.notNull(nodeArr);
        if (nodeArr.length == 0) {
            return;
        }
        List<Node> listEnsureChildNodes = ensureChildNodes();
        Node nodeParent = nodeArr[0].parent();
        if (nodeParent != null && nodeParent.childNodeSize() == nodeArr.length) {
            List<Node> listEnsureChildNodes2 = nodeParent.ensureChildNodes();
            int length = nodeArr.length;
            while (true) {
                int i2 = length - 1;
                if (length > 0) {
                    if (nodeArr[i2] != listEnsureChildNodes2.get(i2)) {
                        break;
                    } else {
                        length = i2;
                    }
                } else {
                    boolean z = childNodeSize() == 0;
                    nodeParent.empty();
                    listEnsureChildNodes.addAll(i, Arrays.asList(nodeArr));
                    int length2 = nodeArr.length;
                    while (true) {
                        int i3 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        nodeArr[i3].parentNode = this;
                        length2 = i3;
                    }
                    if (z && nodeArr[0].siblingIndex == 0) {
                        return;
                    }
                    reindexChildren(i);
                    return;
                }
            }
        }
        Validate.noNullElements(nodeArr);
        for (Node node : nodeArr) {
            reparentChild(node);
        }
        listEnsureChildNodes.addAll(i, Arrays.asList(nodeArr));
        reindexChildren(i);
    }

    protected void reparentChild(Node node) {
        node.setParentNode(this);
    }

    private void reindexChildren(int i) {
        int iChildNodeSize = childNodeSize();
        if (iChildNodeSize == 0) {
            return;
        }
        List<Node> listEnsureChildNodes = ensureChildNodes();
        while (i < iChildNodeSize) {
            listEnsureChildNodes.get(i).setSiblingIndex(i);
            i++;
        }
    }

    public List<Node> siblingNodes() {
        Node node = this.parentNode;
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> listEnsureChildNodes = node.ensureChildNodes();
        ArrayList arrayList = new ArrayList(listEnsureChildNodes.size() - 1);
        for (Node node2 : listEnsureChildNodes) {
            if (node2 != this) {
                arrayList.add(node2);
            }
        }
        return arrayList;
    }

    @Nullable
    public Node nextSibling() {
        Node node = this.parentNode;
        if (node == null) {
            return null;
        }
        List<Node> listEnsureChildNodes = node.ensureChildNodes();
        int i = this.siblingIndex + 1;
        if (listEnsureChildNodes.size() > i) {
            return listEnsureChildNodes.get(i);
        }
        return null;
    }

    @Nullable
    public Node previousSibling() {
        Node node = this.parentNode;
        if (node != null && this.siblingIndex > 0) {
            return node.ensureChildNodes().get(this.siblingIndex - 1);
        }
        return null;
    }

    public int siblingIndex() {
        return this.siblingIndex;
    }

    protected void setSiblingIndex(int i) {
        this.siblingIndex = i;
    }

    @Nullable
    public Node firstChild() {
        if (childNodeSize() == 0) {
            return null;
        }
        return ensureChildNodes().get(0);
    }

    @Nullable
    public Node lastChild() {
        int iChildNodeSize = childNodeSize();
        if (iChildNodeSize == 0) {
            return null;
        }
        return ensureChildNodes().get(iChildNodeSize - 1);
    }

    public Node traverse(NodeVisitor nodeVisitor) {
        Validate.notNull(nodeVisitor);
        NodeTraversor.traverse(nodeVisitor, this);
        return this;
    }

    public Node forEachNode(final Consumer<? super Node> consumer) {
        Validate.notNull(consumer);
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Node$$ExternalSyntheticLambda0
            @Override // org.jsoup.select.NodeVisitor
            public final void head(Node node, int i) {
                consumer.accept(node);
            }
        }, this);
        return this;
    }

    public Node filter(NodeFilter nodeFilter) {
        Validate.notNull(nodeFilter);
        NodeTraversor.filter(nodeFilter, this);
        return this;
    }

    public String outerHtml() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        outerHtml(sbBorrowBuilder);
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    protected void outerHtml(Appendable appendable) {
        NodeTraversor.traverse(new OuterHtmlVisitor(appendable, NodeUtils.outputSettings(this)), this);
    }

    public <T extends Appendable> T html(T t) {
        outerHtml(t);
        return t;
    }

    public Range sourceRange() {
        return Range.of(this, true);
    }

    public String toString() {
        return outerHtml();
    }

    protected void indent(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append('\n').append(StringUtil.padding(i * outputSettings.indentAmount(), outputSettings.maxPaddingWidth()));
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean hasSameValue(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return outerHtml().equals(((Node) obj).outerHtml());
    }

    @Override // 
    /* JADX INFO: renamed from: clone */
    public Node mo14259clone() {
        Node nodeDoClone = doClone(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(nodeDoClone);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            int iChildNodeSize = node.childNodeSize();
            for (int i = 0; i < iChildNodeSize; i++) {
                List<Node> listEnsureChildNodes = node.ensureChildNodes();
                Node nodeDoClone2 = listEnsureChildNodes.get(i).doClone(node);
                listEnsureChildNodes.set(i, nodeDoClone2);
                linkedList.add(nodeDoClone2);
            }
        }
        return nodeDoClone;
    }

    public Node shallowClone() {
        return doClone(null);
    }

    protected Node doClone(@Nullable Node node) {
        Document documentOwnerDocument;
        try {
            Node node2 = (Node) super.clone();
            node2.parentNode = node;
            node2.siblingIndex = node == null ? 0 : this.siblingIndex;
            if (node == null && !(this instanceof Document) && (documentOwnerDocument = ownerDocument()) != null) {
                Document documentShallowClone = documentOwnerDocument.shallowClone();
                node2.parentNode = documentShallowClone;
                documentShallowClone.ensureChildNodes().add(node2);
            }
            return node2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static class OuterHtmlVisitor implements NodeVisitor {
        private final Appendable accum;
        private final Document.OutputSettings out;

        OuterHtmlVisitor(Appendable appendable, Document.OutputSettings outputSettings) {
            this.accum = appendable;
            this.out = outputSettings;
            outputSettings.prepareEncoder();
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            try {
                node.outerHtmlHead(this.accum, i, this.out);
            } catch (IOException e2) {
                throw new SerializationException(e2);
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if (node.nodeName().equals("#text")) {
                return;
            }
            try {
                node.outerHtmlTail(this.accum, i, this.out);
            } catch (IOException e2) {
                throw new SerializationException(e2);
            }
        }
    }
}
