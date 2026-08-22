package org.jsoup.nodes;

import com.appnew.android.Utils.Const;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.Consumer;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.QueryParser;
import org.jsoup.select.Selector;

/* JADX INFO: loaded from: classes10.dex */
public class Element extends Node {

    @Nullable
    Attributes attributes;
    List<Node> childNodes;

    @Nullable
    private WeakReference<List<Element>> shadowChildrenRef;
    private Tag tag;
    private static final List<Element> EmptyChildren = Collections.emptyList();
    private static final Pattern ClassSplit = Pattern.compile("\\s+");
    private static final String BaseUriKey = Attributes.internalKey("baseUri");

    @Override // org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node forEachNode(Consumer consumer) {
        return forEachNode((Consumer<? super Node>) consumer);
    }

    public Element(String str) {
        this(Tag.valueOf(str), "", null);
    }

    public Element(Tag tag, @Nullable String str, @Nullable Attributes attributes) {
        Validate.notNull(tag);
        this.childNodes = EmptyNodes;
        this.attributes = attributes;
        this.tag = tag;
        if (str != null) {
            setBaseUri(str);
        }
    }

    public Element(Tag tag, @Nullable String str) {
        this(tag, str, null);
    }

    protected boolean hasChildNodes() {
        return this.childNodes != EmptyNodes;
    }

    @Override // org.jsoup.nodes.Node
    protected List<Node> ensureChildNodes() {
        if (this.childNodes == EmptyNodes) {
            this.childNodes = new NodeList(this, 4);
        }
        return this.childNodes;
    }

    @Override // org.jsoup.nodes.Node
    protected boolean hasAttributes() {
        return this.attributes != null;
    }

    @Override // org.jsoup.nodes.Node
    public Attributes attributes() {
        if (this.attributes == null) {
            this.attributes = new Attributes();
        }
        return this.attributes;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return searchUpForAttribute(this, BaseUriKey);
    }

    private static String searchUpForAttribute(Element element, String str) {
        while (element != null) {
            Attributes attributes = element.attributes;
            if (attributes != null && attributes.hasKey(str)) {
                return element.attributes.get(str);
            }
            element = element.parent();
        }
        return "";
    }

    @Override // org.jsoup.nodes.Node
    protected void doSetBaseUri(String str) {
        attributes().put(BaseUriKey, str);
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return this.childNodes.size();
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return this.tag.getName();
    }

    public String tagName() {
        return this.tag.getName();
    }

    public String normalName() {
        return this.tag.normalName();
    }

    public Element tagName(String str) {
        Validate.notEmptyParam(str, "tagName");
        this.tag = Tag.valueOf(str, NodeUtils.parser(this).settings());
        return this;
    }

    public Tag tag() {
        return this.tag;
    }

    public boolean isBlock() {
        return this.tag.isBlock();
    }

    public String id() {
        Attributes attributes = this.attributes;
        return attributes != null ? attributes.getIgnoreCase("id") : "";
    }

    public Element id(String str) {
        Validate.notNull(str);
        attr("id", str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element attr(String str, String str2) {
        super.attr(str, str2);
        return this;
    }

    public Element attr(String str, boolean z) {
        attributes().put(str, z);
        return this;
    }

    public Map<String, String> dataset() {
        return attributes().dataset();
    }

    @Override // org.jsoup.nodes.Node
    @Nullable
    public final Element parent() {
        return (Element) this.parentNode;
    }

    public Elements parents() {
        Elements elements = new Elements();
        accumulateParents(this, elements);
        return elements;
    }

    private static void accumulateParents(Element element, Elements elements) {
        Element elementParent = element.parent();
        if (elementParent == null || elementParent.tagName().equals("#root")) {
            return;
        }
        elements.add(elementParent);
        accumulateParents(elementParent, elements);
    }

    public Element child(int i) {
        return childElementsList().get(i);
    }

    public int childrenSize() {
        return childElementsList().size();
    }

    public Elements children() {
        return new Elements(childElementsList());
    }

    List<Element> childElementsList() {
        List<Element> list;
        if (childNodeSize() == 0) {
            return EmptyChildren;
        }
        WeakReference<List<Element>> weakReference = this.shadowChildrenRef;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.childNodes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Node node = this.childNodes.get(i);
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        this.shadowChildrenRef = new WeakReference<>(arrayList);
        return arrayList;
    }

    @Override // org.jsoup.nodes.Node
    void nodelistChanged() {
        super.nodelistChanged();
        this.shadowChildrenRef = null;
    }

    public List<TextNode> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<DataNode> dataNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                arrayList.add((DataNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Elements select(Evaluator evaluator) {
        return Selector.select(evaluator, this);
    }

    @Nullable
    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    @Nullable
    public Element selectFirst(Evaluator evaluator) {
        return Collector.findFirst(evaluator, this);
    }

    public Element expectFirst(String str) {
        String str2;
        Element elementSelectFirst = Selector.selectFirst(str, this);
        if (parent() != null) {
            str2 = "No elements matched the query '%s' on element '%s'.";
        } else {
            str2 = "No elements matched the query '%s' in the document.";
        }
        return (Element) Validate.ensureNotNull(elementSelectFirst, str2, str, tagName());
    }

    public boolean is(String str) {
        return is(QueryParser.parse(str));
    }

    public boolean is(Evaluator evaluator) {
        return evaluator.matches(root(), this);
    }

    @Nullable
    public Element closest(String str) {
        return closest(QueryParser.parse(str));
    }

    @Nullable
    public Element closest(Evaluator evaluator) {
        Validate.notNull(evaluator);
        Element elementRoot = root();
        Element elementParent = this;
        while (!evaluator.matches(elementRoot, elementParent)) {
            elementParent = elementParent.parent();
            if (elementParent == null) {
                return null;
            }
        }
        return elementParent;
    }

    public Elements selectXpath(String str) {
        return new Elements((List<Element>) NodeUtils.selectXpath(str, this, Element.class));
    }

    public <T extends Node> List<T> selectXpath(String str, Class<T> cls) {
        return NodeUtils.selectXpath(str, this, cls);
    }

    public Element appendChild(Node node) {
        Validate.notNull(node);
        reparentChild(node);
        ensureChildNodes();
        this.childNodes.add(node);
        node.setSiblingIndex(this.childNodes.size() - 1);
        return this;
    }

    public Element appendChildren(Collection<? extends Node> collection) {
        insertChildren(-1, collection);
        return this;
    }

    public Element appendTo(Element element) {
        Validate.notNull(element);
        element.appendChild(this);
        return this;
    }

    public Element prependChild(Node node) {
        Validate.notNull(node);
        addChildren(0, node);
        return this;
    }

    public Element prependChildren(Collection<? extends Node> collection) {
        insertChildren(0, collection);
        return this;
    }

    public Element insertChildren(int i, Collection<? extends Node> collection) {
        Validate.notNull(collection, "Children collection to be inserted must not be null.");
        int iChildNodeSize = childNodeSize();
        if (i < 0) {
            i += iChildNodeSize + 1;
        }
        Validate.isTrue(i >= 0 && i <= iChildNodeSize, "Insert position out of bounds.");
        addChildren(i, (Node[]) new ArrayList(collection).toArray(new Node[0]));
        return this;
    }

    public Element insertChildren(int i, Node... nodeArr) {
        Validate.notNull(nodeArr, "Children collection to be inserted must not be null.");
        int iChildNodeSize = childNodeSize();
        if (i < 0) {
            i += iChildNodeSize + 1;
        }
        Validate.isTrue(i >= 0 && i <= iChildNodeSize, "Insert position out of bounds.");
        addChildren(i, nodeArr);
        return this;
    }

    public Element appendElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        appendChild(element);
        return element;
    }

    public Element prependElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        prependChild(element);
        return element;
    }

    public Element appendText(String str) {
        Validate.notNull(str);
        appendChild(new TextNode(str));
        return this;
    }

    public Element prependText(String str) {
        Validate.notNull(str);
        prependChild(new TextNode(str));
        return this;
    }

    public Element append(String str) {
        Validate.notNull(str);
        addChildren((Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element prepend(String str) {
        Validate.notNull(str);
        addChildren(0, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element before(String str) {
        return (Element) super.before(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element before(Node node) {
        return (Element) super.before(node);
    }

    @Override // org.jsoup.nodes.Node
    public Element after(String str) {
        return (Element) super.after(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element after(Node node) {
        return (Element) super.after(node);
    }

    @Override // org.jsoup.nodes.Node
    public Element empty() {
        this.childNodes.clear();
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element wrap(String str) {
        return (Element) super.wrap(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (r3.get(0) == r5) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String cssSelector() {
        /*
            r5 = this;
            java.lang.String r0 = r5.id()
            int r0 = r0.length()
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "#"
            r0.<init>(r3)
            java.lang.String r3 = r5.id()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            org.jsoup.nodes.Document r3 = r5.ownerDocument()
            if (r3 == 0) goto L35
            org.jsoup.select.Elements r3 = r3.select(r0)
            int r4 = r3.size()
            if (r4 != r2) goto L36
            java.lang.Object r3 = r3.get(r1)
            if (r3 != r5) goto L36
        L35:
            return r0
        L36:
            java.lang.String r0 = r5.tagName()
            r3 = 58
            r4 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = r0.replace(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.util.Set r0 = r5.classNames()
            java.lang.String r4 = "."
            java.lang.String r0 = org.jsoup.internal.StringUtil.join(r0, r4)
            int r4 = r0.length()
            if (r4 <= 0) goto L60
            r4 = 46
            java.lang.StringBuilder r4 = r3.append(r4)
            r4.append(r0)
        L60:
            org.jsoup.nodes.Element r0 = r5.parent()
            if (r0 == 0) goto Lba
            org.jsoup.nodes.Element r0 = r5.parent()
            boolean r0 = r0 instanceof org.jsoup.nodes.Document
            if (r0 == 0) goto L6f
            goto Lba
        L6f:
            java.lang.String r0 = " > "
            r3.insert(r1, r0)
            org.jsoup.nodes.Element r0 = r5.parent()
            java.lang.String r1 = r3.toString()
            org.jsoup.select.Elements r0 = r0.select(r1)
            int r0 = r0.size()
            if (r0 <= r2) goto L9c
            int r0 = r5.elementSiblingIndex()
            int r0 = r0 + r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = ":nth-child(%d)"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r3.append(r0)
        L9c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            org.jsoup.nodes.Element r1 = r5.parent()
            java.lang.String r1 = r1.cssSelector()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        Lba:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Element.cssSelector():java.lang.String");
    }

    public Elements siblingElements() {
        if (this.parentNode == null) {
            return new Elements(0);
        }
        List<Element> listChildElementsList = parent().childElementsList();
        Elements elements = new Elements(listChildElementsList.size() - 1);
        for (Element element : listChildElementsList) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    @Nullable
    public Element nextElementSibling() {
        if (this.parentNode == null) {
            return null;
        }
        List<Element> listChildElementsList = parent().childElementsList();
        int iIndexInList = indexInList(this, listChildElementsList) + 1;
        if (listChildElementsList.size() > iIndexInList) {
            return listChildElementsList.get(iIndexInList);
        }
        return null;
    }

    public Elements nextElementSiblings() {
        return nextElementSiblings(true);
    }

    @Nullable
    public Element previousElementSibling() {
        List<Element> listChildElementsList;
        int iIndexInList;
        if (this.parentNode != null && (iIndexInList = indexInList(this, (listChildElementsList = parent().childElementsList()))) > 0) {
            return listChildElementsList.get(iIndexInList - 1);
        }
        return null;
    }

    public Elements previousElementSiblings() {
        return nextElementSiblings(false);
    }

    private Elements nextElementSiblings(boolean z) {
        Elements elements = new Elements();
        if (this.parentNode == null) {
            return elements;
        }
        elements.add(this);
        return z ? elements.nextAll() : elements.prevAll();
    }

    public Element firstElementSibling() {
        if (parent() != null) {
            List<Element> listChildElementsList = parent().childElementsList();
            if (listChildElementsList.size() > 1) {
                return listChildElementsList.get(0);
            }
        }
        return this;
    }

    public int elementSiblingIndex() {
        if (parent() == null) {
            return 0;
        }
        return indexInList(this, parent().childElementsList());
    }

    public Element lastElementSibling() {
        if (parent() != null) {
            List<Element> listChildElementsList = parent().childElementsList();
            if (listChildElementsList.size() > 1) {
                return listChildElementsList.get(listChildElementsList.size() - 1);
            }
        }
        return this;
    }

    private static <E extends Element> int indexInList(Element element, List<E> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == element) {
                return i;
            }
        }
        return 0;
    }

    @Nullable
    public Element firstElementChild() {
        int iChildNodeSize = childNodeSize();
        if (iChildNodeSize == 0) {
            return null;
        }
        List<Node> listEnsureChildNodes = ensureChildNodes();
        for (int i = 0; i < iChildNodeSize; i++) {
            Node node = listEnsureChildNodes.get(i);
            if (node instanceof Element) {
                return (Element) node;
            }
        }
        return null;
    }

    @Nullable
    public Element lastElementChild() {
        int iChildNodeSize = childNodeSize();
        if (iChildNodeSize == 0) {
            return null;
        }
        List<Node> listEnsureChildNodes = ensureChildNodes();
        for (int i = iChildNodeSize - 1; i >= 0; i--) {
            Node node = listEnsureChildNodes.get(i);
            if (node instanceof Element) {
                return (Element) node;
            }
        }
        return null;
    }

    public Elements getElementsByTag(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Tag(Normalizer.normalize(str)), this);
    }

    @Nullable
    public Element getElementById(String str) {
        Validate.notEmpty(str);
        Elements elementsCollect = Collector.collect(new Evaluator.Id(str), this);
        if (elementsCollect.size() > 0) {
            return elementsCollect.get(0);
        }
        return null;
    }

    public Elements getElementsByClass(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Class(str), this);
    }

    public Elements getElementsByAttribute(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Attribute(str.trim()), this);
    }

    public Elements getElementsByAttributeStarting(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.AttributeStarting(str.trim()), this);
    }

    public Elements getElementsByAttributeValue(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValue(str, str2), this);
    }

    public Elements getElementsByAttributeValueNot(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueNot(str, str2), this);
    }

    public Elements getElementsByAttributeValueStarting(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueStarting(str, str2), this);
    }

    public Elements getElementsByAttributeValueEnding(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueEnding(str, str2), this);
    }

    public Elements getElementsByAttributeValueContaining(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueContaining(str, str2), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, Pattern pattern) {
        return Collector.collect(new Evaluator.AttributeWithValueMatching(str, pattern), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, String str2) {
        try {
            return getElementsByAttributeValueMatching(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str2, e2);
        }
    }

    public Elements getElementsByIndexLessThan(int i) {
        return Collector.collect(new Evaluator.IndexLessThan(i), this);
    }

    public Elements getElementsByIndexGreaterThan(int i) {
        return Collector.collect(new Evaluator.IndexGreaterThan(i), this);
    }

    public Elements getElementsByIndexEquals(int i) {
        return Collector.collect(new Evaluator.IndexEquals(i), this);
    }

    public Elements getElementsContainingText(String str) {
        return Collector.collect(new Evaluator.ContainsText(str), this);
    }

    public Elements getElementsContainingOwnText(String str) {
        return Collector.collect(new Evaluator.ContainsOwnText(str), this);
    }

    public Elements getElementsMatchingText(Pattern pattern) {
        return Collector.collect(new Evaluator.Matches(pattern), this);
    }

    public Elements getElementsMatchingText(String str) {
        try {
            return getElementsMatchingText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e2);
        }
    }

    public Elements getElementsMatchingOwnText(Pattern pattern) {
        return Collector.collect(new Evaluator.MatchesOwn(pattern), this);
    }

    public Elements getElementsMatchingOwnText(String str) {
        try {
            return getElementsMatchingOwnText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e2);
        }
    }

    public Elements getAllElements() {
        return Collector.collect(new Evaluator.AllElements(), this);
    }

    public String text() {
        final StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.1
            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i) {
                if (node instanceof TextNode) {
                    Element.appendNormalisedText(sbBorrowBuilder, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (sbBorrowBuilder.length() > 0) {
                        if ((element.isBlock() || element.tag.normalName().equals("br")) && !TextNode.lastCharIsWhitespace(sbBorrowBuilder)) {
                            sbBorrowBuilder.append(' ');
                        }
                    }
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i) {
                if ((node instanceof Element) && ((Element) node).isBlock() && (node.nextSibling() instanceof TextNode) && !TextNode.lastCharIsWhitespace(sbBorrowBuilder)) {
                    sbBorrowBuilder.append(' ');
                }
            }
        }, this);
        return StringUtil.releaseBuilder(sbBorrowBuilder).trim();
    }

    public String wholeText() {
        final StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element$$ExternalSyntheticLambda0
            @Override // org.jsoup.select.NodeVisitor
            public final void head(Node node, int i) {
                Element.appendWholeText(node, sbBorrowBuilder);
            }
        }, this);
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendWholeText(Node node, StringBuilder sb) {
        if (node instanceof TextNode) {
            sb.append(((TextNode) node).getWholeText());
        } else if (node instanceof Element) {
            appendNewlineIfBr((Element) node, sb);
        }
    }

    public String wholeOwnText() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        int iChildNodeSize = childNodeSize();
        for (int i = 0; i < iChildNodeSize; i++) {
            appendWholeText(this.childNodes.get(i), sbBorrowBuilder);
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    public String ownText() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        ownText(sbBorrowBuilder);
        return StringUtil.releaseBuilder(sbBorrowBuilder).trim();
    }

    private void ownText(StringBuilder sb) {
        for (int i = 0; i < childNodeSize(); i++) {
            Node node = this.childNodes.get(i);
            if (node instanceof TextNode) {
                appendNormalisedText(sb, (TextNode) node);
            } else if (node instanceof Element) {
                appendWhitespaceIfBr((Element) node, sb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendNormalisedText(StringBuilder sb, TextNode textNode) {
        String wholeText = textNode.getWholeText();
        if (preserveWhitespace(textNode.parentNode) || (textNode instanceof CDataNode)) {
            sb.append(wholeText);
        } else {
            StringUtil.appendNormalisedWhitespace(sb, wholeText, TextNode.lastCharIsWhitespace(sb));
        }
    }

    private static void appendWhitespaceIfBr(Element element, StringBuilder sb) {
        if (!element.tag.normalName().equals("br") || TextNode.lastCharIsWhitespace(sb)) {
            return;
        }
        sb.append(" ");
    }

    private static void appendNewlineIfBr(Element element, StringBuilder sb) {
        if (element.tag.normalName().equals("br")) {
            sb.append("\n");
        }
    }

    static boolean preserveWhitespace(@Nullable Node node) {
        if (node instanceof Element) {
            Element elementParent = (Element) node;
            int i = 0;
            while (!elementParent.tag.preserveWhitespace()) {
                elementParent = elementParent.parent();
                i++;
                if (i >= 6 || elementParent == null) {
                }
            }
            return true;
        }
        return false;
    }

    public Element text(String str) {
        Validate.notNull(str);
        empty();
        Document documentOwnerDocument = ownerDocument();
        if (documentOwnerDocument != null && documentOwnerDocument.parser().isContentForTagData(normalName())) {
            appendChild(new DataNode(str));
            return this;
        }
        appendChild(new TextNode(str));
        return this;
    }

    public boolean hasText() {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                if (!((TextNode) node).isBlank()) {
                    return true;
                }
            } else if ((node instanceof Element) && ((Element) node).hasText()) {
                return true;
            }
        }
        return false;
    }

    public String data() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                sbBorrowBuilder.append(((DataNode) node).getWholeData());
            } else if (node instanceof Comment) {
                sbBorrowBuilder.append(((Comment) node).getData());
            } else if (node instanceof Element) {
                sbBorrowBuilder.append(((Element) node).data());
            } else if (node instanceof CDataNode) {
                sbBorrowBuilder.append(((CDataNode) node).getWholeText());
            }
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    public String className() {
        return attr(Const.CLASS).trim();
    }

    public Set<String> classNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(ClassSplit.split(className())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Element classNames(Set<String> set) {
        Validate.notNull(set);
        if (set.isEmpty()) {
            attributes().remove(Const.CLASS);
            return this;
        }
        attributes().put(Const.CLASS, StringUtil.join(set, " "));
        return this;
    }

    public boolean hasClass(String str) {
        String str2;
        Attributes attributes = this.attributes;
        if (attributes == null) {
            return false;
        }
        String ignoreCase = attributes.getIgnoreCase(Const.CLASS);
        int length = ignoreCase.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(ignoreCase);
            }
            int i = 0;
            boolean z = false;
            int i2 = 0;
            while (i < length) {
                if (!Character.isWhitespace(ignoreCase.charAt(i))) {
                    str2 = str;
                    if (!z) {
                        i2 = i;
                        z = true;
                    }
                } else if (z) {
                    if (i - i2 == length2) {
                        str2 = str;
                        if (ignoreCase.regionMatches(true, i2, str2, 0, length2)) {
                            return true;
                        }
                    } else {
                        str2 = str;
                    }
                    z = false;
                } else {
                    str2 = str;
                }
                i++;
                str = str2;
            }
            String str3 = str;
            if (z && length - i2 == length2) {
                return ignoreCase.regionMatches(true, i2, str3, 0, length2);
            }
        }
        return false;
    }

    public Element addClass(String str) {
        Validate.notNull(str);
        Set<String> setClassNames = classNames();
        setClassNames.add(str);
        classNames(setClassNames);
        return this;
    }

    public Element removeClass(String str) {
        Validate.notNull(str);
        Set<String> setClassNames = classNames();
        setClassNames.remove(str);
        classNames(setClassNames);
        return this;
    }

    public Element toggleClass(String str) {
        Validate.notNull(str);
        Set<String> setClassNames = classNames();
        if (setClassNames.contains(str)) {
            setClassNames.remove(str);
        } else {
            setClassNames.add(str);
        }
        classNames(setClassNames);
        return this;
    }

    public String val() {
        if (normalName().equals("textarea")) {
            return text();
        }
        return attr("value");
    }

    public Element val(String str) {
        if (normalName().equals("textarea")) {
            text(str);
            return this;
        }
        attr("value", str);
        return this;
    }

    public Range endSourceRange() {
        return Range.of(this, false);
    }

    boolean shouldIndent(Document.OutputSettings outputSettings) {
        return outputSettings.prettyPrint() && isFormatAsBlock(outputSettings) && !isInlineable(outputSettings);
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (shouldIndent(outputSettings) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0)) {
            indent(appendable, i, outputSettings);
        }
        appendable.append(Typography.less).append(tagName());
        Attributes attributes = this.attributes;
        if (attributes != null) {
            attributes.html(appendable, outputSettings);
        }
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty()) {
                appendable.append(Typography.greater);
                return;
            } else {
                appendable.append(" />");
                return;
            }
        }
        appendable.append(Typography.greater);
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            return;
        }
        if (outputSettings.prettyPrint() && !this.childNodes.isEmpty() && (this.tag.formatAsBlock() || (outputSettings.outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && (this.childNodes.get(0) instanceof Element)))))) {
            indent(appendable, i, outputSettings);
        }
        appendable.append("</").append(tagName()).append(Typography.greater);
    }

    public String html() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        html(sbBorrowBuilder);
        String strReleaseBuilder = StringUtil.releaseBuilder(sbBorrowBuilder);
        return NodeUtils.outputSettings(this).prettyPrint() ? strReleaseBuilder.trim() : strReleaseBuilder;
    }

    @Override // org.jsoup.nodes.Node
    public <T extends Appendable> T html(T t) {
        int size = this.childNodes.size();
        for (int i = 0; i < size; i++) {
            this.childNodes.get(i).outerHtml(t);
        }
        return t;
    }

    public Element html(String str) {
        empty();
        append(str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    /* JADX INFO: renamed from: clone */
    public Element mo14259clone() {
        return (Element) super.mo14259clone();
    }

    @Override // org.jsoup.nodes.Node
    public Element shallowClone() {
        Tag tag = this.tag;
        String strBaseUri = baseUri();
        Attributes attributes = this.attributes;
        return new Element(tag, strBaseUri, attributes == null ? null : attributes.clone());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public Element doClone(@Nullable Node node) {
        Element element = (Element) super.doClone(node);
        Attributes attributes = this.attributes;
        element.attributes = attributes != null ? attributes.clone() : null;
        NodeList nodeList = new NodeList(element, this.childNodes.size());
        element.childNodes = nodeList;
        nodeList.addAll(this.childNodes);
        return element;
    }

    @Override // org.jsoup.nodes.Node
    public Element clearAttributes() {
        if (this.attributes != null) {
            super.clearAttributes();
            this.attributes = null;
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element removeAttr(String str) {
        return (Element) super.removeAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element root() {
        return (Element) super.root();
    }

    @Override // org.jsoup.nodes.Node
    public Element traverse(NodeVisitor nodeVisitor) {
        return (Element) super.traverse(nodeVisitor);
    }

    @Override // org.jsoup.nodes.Node
    public Element forEachNode(Consumer<? super Node> consumer) {
        return (Element) super.forEachNode(consumer);
    }

    public Element forEach(final Consumer<? super Element> consumer) {
        Validate.notNull(consumer);
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element$$ExternalSyntheticLambda1
            @Override // org.jsoup.select.NodeVisitor
            public final void head(Node node, int i) {
                Element.lambda$forEach$1(consumer, node, i);
            }
        }, this);
        return this;
    }

    static /* synthetic */ void lambda$forEach$1(Consumer consumer, Node node, int i) {
        if (node instanceof Element) {
            consumer.accept((Element) node);
        }
    }

    @Override // org.jsoup.nodes.Node
    public Element filter(NodeFilter nodeFilter) {
        return (Element) super.filter(nodeFilter);
    }

    private static final class NodeList extends ChangeNotifyingArrayList<Node> {
        private final Element owner;

        NodeList(Element element, int i) {
            super(i);
            this.owner = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.nodelistChanged();
        }
    }

    private boolean isFormatAsBlock(Document.OutputSettings outputSettings) {
        if (this.tag.formatAsBlock()) {
            return true;
        }
        return (parent() != null && parent().tag().formatAsBlock()) || outputSettings.outline();
    }

    private boolean isInlineable(Document.OutputSettings outputSettings) {
        if (tag().isInline()) {
            return ((parent() != null && !parent().isBlock()) || previousSibling() == null || outputSettings.outline()) ? false : true;
        }
        return false;
    }
}
