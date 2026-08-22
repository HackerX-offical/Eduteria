package org.mozilla.javascript.xmlimpl;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mozilla.javascript.Undefined;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes10.dex */
class XmlNode implements Serializable {
    private static final boolean DOM_LEVEL_3 = true;
    private static final String USER_DATA_XMLNODE_KEY = "org.mozilla.javascript.xmlimpl.XmlNode";
    private static final String XML_NAMESPACES_NAMESPACE_URI = "http://www.w3.org/2000/xmlns/";
    private static final long serialVersionUID = 1;
    private Node dom;
    private UserDataHandler events = new XmlNodeUserDataHandler();
    private XML xml;

    private static XmlNode getUserData(Node node) {
        return (XmlNode) node.getUserData(USER_DATA_XMLNODE_KEY);
    }

    private static void setUserData(Node node, XmlNode xmlNode) {
        node.setUserData(USER_DATA_XMLNODE_KEY, xmlNode, xmlNode.events);
    }

    private static XmlNode createImpl(Node node) {
        if (node instanceof Document) {
            throw new IllegalArgumentException();
        }
        if (getUserData(node) == null) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.dom = node;
            setUserData(node, xmlNode);
            return xmlNode;
        }
        return getUserData(node);
    }

    static XmlNode newElementWithText(XmlProcessor xmlProcessor, XmlNode xmlNode, QName qName, String str) {
        Document documentNewDocument;
        Element elementCreateElementNS;
        if (xmlNode instanceof Document) {
            throw new IllegalArgumentException("Cannot use Document node as reference");
        }
        if (xmlNode != null) {
            documentNewDocument = xmlNode.dom.getOwnerDocument();
        } else {
            documentNewDocument = xmlProcessor.newDocument();
        }
        Node node = xmlNode != null ? xmlNode.dom : null;
        Namespace namespace = qName.getNamespace();
        if (namespace == null || namespace.getUri().length() == 0) {
            elementCreateElementNS = documentNewDocument.createElementNS(null, qName.getLocalName());
        } else {
            elementCreateElementNS = documentNewDocument.createElementNS(namespace.getUri(), qName.qualify(node));
        }
        if (str != null) {
            elementCreateElementNS.appendChild(documentNewDocument.createTextNode(str));
        }
        return createImpl(elementCreateElementNS);
    }

    static XmlNode createText(XmlProcessor xmlProcessor, String str) {
        return createImpl(xmlProcessor.newDocument().createTextNode(str));
    }

    static XmlNode createElementFromNode(Node node) {
        if (node instanceof Document) {
            node = ((Document) node).getDocumentElement();
        }
        return createImpl(node);
    }

    static XmlNode createElement(XmlProcessor xmlProcessor, String str, String str2) throws SAXException {
        return createImpl(xmlProcessor.toXml(str, str2));
    }

    static XmlNode createEmpty(XmlProcessor xmlProcessor) {
        return createText(xmlProcessor, "");
    }

    private static XmlNode copy(XmlNode xmlNode) {
        return createImpl(xmlNode.dom.cloneNode(true));
    }

    private XmlNode() {
    }

    String debug() {
        XmlProcessor xmlProcessor = new XmlProcessor();
        xmlProcessor.setIgnoreComments(false);
        xmlProcessor.setIgnoreProcessingInstructions(false);
        xmlProcessor.setIgnoreWhitespace(false);
        xmlProcessor.setPrettyPrinting(false);
        return xmlProcessor.ecmaToXmlString(this.dom);
    }

    public String toString() {
        return "XmlNode: type=" + ((int) this.dom.getNodeType()) + " dom=" + this.dom.toString();
    }

    XML getXml() {
        return this.xml;
    }

    void setXml(XML xml) {
        this.xml = xml;
    }

    int getChildCount() {
        return this.dom.getChildNodes().getLength();
    }

    XmlNode parent() {
        Node parentNode = this.dom.getParentNode();
        if ((parentNode instanceof Document) || parentNode == null) {
            return null;
        }
        return createImpl(parentNode);
    }

    int getChildIndex() {
        if (isAttributeType() || parent() == null) {
            return -1;
        }
        NodeList childNodes = this.dom.getParentNode().getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) == this.dom) {
                return i;
            }
        }
        throw new RuntimeException("Unreachable.");
    }

    void removeChild(int i) {
        Node node = this.dom;
        node.removeChild(node.getChildNodes().item(i));
    }

    String toXmlString(XmlProcessor xmlProcessor) {
        return xmlProcessor.ecmaToXmlString(this.dom);
    }

    String ecmaValue() {
        if (isTextType()) {
            return ((Text) this.dom).getData();
        }
        if (isAttributeType()) {
            return ((Attr) this.dom).getValue();
        }
        if (isProcessingInstructionType()) {
            return ((ProcessingInstruction) this.dom).getData();
        }
        if (isCommentType()) {
            return ((Comment) this.dom).getNodeValue();
        }
        if (isElementType()) {
            throw new RuntimeException("Unimplemented ecmaValue() for elements.");
        }
        throw new RuntimeException("Unimplemented for node " + this.dom);
    }

    void deleteMe() {
        Node node = this.dom;
        if (node instanceof Attr) {
            Attr attr = (Attr) node;
            attr.getOwnerElement().getAttributes().removeNamedItemNS(attr.getNamespaceURI(), attr.getLocalName());
        } else if (node.getParentNode() != null) {
            this.dom.getParentNode().removeChild(this.dom);
        }
    }

    void normalize() {
        this.dom.normalize();
    }

    void insertChildAt(int i, XmlNode xmlNode) {
        Node node = this.dom;
        Node nodeImportNode = node.getOwnerDocument().importNode(xmlNode.dom, true);
        if (node.getChildNodes().getLength() < i) {
            throw new IllegalArgumentException("index=" + i + " length=" + node.getChildNodes().getLength());
        }
        if (node.getChildNodes().getLength() == i) {
            node.appendChild(nodeImportNode);
        } else {
            node.insertBefore(nodeImportNode, node.getChildNodes().item(i));
        }
    }

    void insertChildrenAt(int i, XmlNode[] xmlNodeArr) {
        for (int i2 = 0; i2 < xmlNodeArr.length; i2++) {
            insertChildAt(i + i2, xmlNodeArr[i2]);
        }
    }

    XmlNode getChild(int i) {
        return createImpl(this.dom.getChildNodes().item(i));
    }

    boolean hasChildElement() {
        NodeList childNodes = this.dom.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == 1) {
                return true;
            }
        }
        return false;
    }

    boolean isSameNode(XmlNode xmlNode) {
        return this.dom == xmlNode.dom;
    }

    private String toUri(String str) {
        return str == null ? "" : str;
    }

    private void addNamespaces(Namespaces namespaces, Element element) {
        if (element == null) {
            throw new RuntimeException("element must not be null");
        }
        String uri = toUri(element.lookupNamespaceURI(null));
        if (!uri.equals(element.getParentNode() != null ? toUri(element.getParentNode().lookupNamespaceURI(null)) : "") || !(element.getParentNode() instanceof Element)) {
            namespaces.declare(Namespace.create("", uri));
        }
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            if (attr.getPrefix() != null && attr.getPrefix().equals("xmlns")) {
                namespaces.declare(Namespace.create(attr.getLocalName(), attr.getValue()));
            }
        }
    }

    private Namespaces getAllNamespaces() {
        Namespaces namespaces = new Namespaces();
        Node parentNode = this.dom;
        if (parentNode instanceof Attr) {
            parentNode = ((Attr) parentNode).getOwnerElement();
        }
        while (parentNode != null) {
            if (parentNode instanceof Element) {
                addNamespaces(namespaces, (Element) parentNode);
            }
            parentNode = parentNode.getParentNode();
        }
        namespaces.declare(Namespace.create("", ""));
        return namespaces;
    }

    Namespace[] getInScopeNamespaces() {
        return getAllNamespaces().getNamespaces();
    }

    Namespace[] getNamespaceDeclarations() {
        if (this.dom instanceof Element) {
            Namespaces namespaces = new Namespaces();
            addNamespaces(namespaces, (Element) this.dom);
            return namespaces.getNamespaces();
        }
        return new Namespace[0];
    }

    Namespace getNamespaceDeclaration(String str) {
        if (str.equals("") && (this.dom instanceof Attr)) {
            return Namespace.create("", "");
        }
        return getAllNamespaces().getNamespace(str);
    }

    Namespace getNamespaceDeclaration() {
        return this.dom.getPrefix() == null ? getNamespaceDeclaration("") : getNamespaceDeclaration(this.dom.getPrefix());
    }

    static class XmlNodeUserDataHandler implements UserDataHandler, Serializable {
        private static final long serialVersionUID = 4666895518900769588L;

        @Override // org.w3c.dom.UserDataHandler
        public void handle(short s, String str, Object obj, Node node, Node node2) {
        }

        XmlNodeUserDataHandler() {
        }
    }

    private static class Namespaces {
        private Map<String, String> map = new HashMap();
        private Map<String, String> uriToPrefix = new HashMap();

        Namespaces() {
        }

        void declare(Namespace namespace) {
            if (this.map.get(namespace.prefix) == null) {
                this.map.put(namespace.prefix, namespace.uri);
            }
            if (this.uriToPrefix.get(namespace.uri) == null) {
                this.uriToPrefix.put(namespace.uri, namespace.prefix);
            }
        }

        Namespace getNamespaceByUri(String str) {
            if (this.uriToPrefix.get(str) == null) {
                return null;
            }
            return Namespace.create(str, this.uriToPrefix.get(str));
        }

        Namespace getNamespace(String str) {
            if (this.map.get(str) == null) {
                return null;
            }
            return Namespace.create(str, this.map.get(str));
        }

        Namespace[] getNamespaces() {
            ArrayList arrayList = new ArrayList();
            for (String str : this.map.keySet()) {
                Namespace namespaceCreate = Namespace.create(str, this.map.get(str));
                if (!namespaceCreate.isEmpty()) {
                    arrayList.add(namespaceCreate);
                }
            }
            return (Namespace[]) arrayList.toArray(new Namespace[arrayList.size()]);
        }
    }

    final XmlNode copy() {
        return copy(this);
    }

    final boolean isParentType() {
        return isElementType();
    }

    final boolean isTextType() {
        return this.dom.getNodeType() == 3 || this.dom.getNodeType() == 4;
    }

    final boolean isAttributeType() {
        return this.dom.getNodeType() == 2;
    }

    final boolean isProcessingInstructionType() {
        return this.dom.getNodeType() == 7;
    }

    final boolean isCommentType() {
        return this.dom.getNodeType() == 8;
    }

    final boolean isElementType() {
        return this.dom.getNodeType() == 1;
    }

    final void renameNode(QName qName) {
        this.dom = this.dom.getOwnerDocument().renameNode(this.dom, qName.getNamespace().getUri(), qName.qualify(this.dom));
    }

    void invalidateNamespacePrefix() {
        Node node = this.dom;
        if (!(node instanceof Element)) {
            throw new IllegalStateException();
        }
        String prefix = node.getPrefix();
        renameNode(QName.create(this.dom.getNamespaceURI(), this.dom.getLocalName(), null));
        NamedNodeMap attributes = this.dom.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            if (attributes.item(i).getPrefix().equals(prefix)) {
                createImpl(attributes.item(i)).renameNode(QName.create(attributes.item(i).getNamespaceURI(), attributes.item(i).getLocalName(), null));
            }
        }
    }

    private void declareNamespace(Element element, String str, String str2) {
        if (str.length() > 0) {
            element.setAttributeNS(XML_NAMESPACES_NAMESPACE_URI, "xmlns:" + str, str2);
        } else {
            element.setAttribute("xmlns", str2);
        }
    }

    void declareNamespace(String str, String str2) {
        Node node = this.dom;
        if (!(node instanceof Element)) {
            throw new IllegalStateException();
        }
        if (node.lookupNamespaceURI(str2) == null || !this.dom.lookupNamespaceURI(str2).equals(str)) {
            declareNamespace((Element) this.dom, str, str2);
        }
    }

    private Namespace getDefaultNamespace() {
        return Namespace.create("", this.dom.lookupNamespaceURI(null) == null ? "" : this.dom.lookupNamespaceURI(null));
    }

    private String getExistingPrefixFor(Namespace namespace) {
        if (getDefaultNamespace().getUri().equals(namespace.getUri())) {
            return "";
        }
        return this.dom.lookupPrefix(namespace.getUri());
    }

    private Namespace getNodeNamespace() {
        String namespaceURI = this.dom.getNamespaceURI();
        String prefix = this.dom.getPrefix();
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (prefix == null) {
            prefix = "";
        }
        return Namespace.create(prefix, namespaceURI);
    }

    Namespace getNamespace() {
        return getNodeNamespace();
    }

    void removeNamespace(Namespace namespace) {
        if (namespace.is(getNodeNamespace())) {
            return;
        }
        NamedNodeMap attributes = this.dom.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            if (namespace.is(createImpl(attributes.item(i)).getNodeNamespace())) {
                return;
            }
        }
        String existingPrefixFor = getExistingPrefixFor(namespace);
        if (existingPrefixFor != null) {
            if (namespace.isUnspecifiedPrefix()) {
                declareNamespace(existingPrefixFor, getDefaultNamespace().getUri());
            } else if (existingPrefixFor.equals(namespace.getPrefix())) {
                declareNamespace(existingPrefixFor, getDefaultNamespace().getUri());
            }
        }
    }

    private void setProcessingInstructionName(String str) {
        ProcessingInstruction processingInstruction = (ProcessingInstruction) this.dom;
        processingInstruction.getParentNode().replaceChild(processingInstruction, processingInstruction.getOwnerDocument().createProcessingInstruction(str, processingInstruction.getData()));
    }

    final void setLocalName(String str) {
        Node node = this.dom;
        if (node instanceof ProcessingInstruction) {
            setProcessingInstructionName(str);
            return;
        }
        String prefix = node.getPrefix();
        if (prefix == null) {
            prefix = "";
        }
        Document ownerDocument = this.dom.getOwnerDocument();
        Node node2 = this.dom;
        this.dom = ownerDocument.renameNode(node2, node2.getNamespaceURI(), QName.qualify(prefix, str));
    }

    final QName getQname() {
        return QName.create(this.dom.getNamespaceURI() == null ? "" : this.dom.getNamespaceURI(), this.dom.getLocalName(), this.dom.getPrefix() != null ? this.dom.getPrefix() : "");
    }

    void addMatchingChildren(XMLList xMLList, Filter filter) {
        NodeList childNodes = this.dom.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            XmlNode xmlNodeCreateImpl = createImpl(nodeItem);
            if (filter.accept(nodeItem)) {
                xMLList.addToList(xmlNodeCreateImpl);
            }
        }
    }

    XmlNode[] getMatchingChildren(Filter filter) {
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = this.dom.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (filter.accept(nodeItem)) {
                arrayList.add(createImpl(nodeItem));
            }
        }
        return (XmlNode[]) arrayList.toArray(new XmlNode[arrayList.size()]);
    }

    XmlNode[] getAttributes() {
        NamedNodeMap attributes = this.dom.getAttributes();
        if (attributes == null) {
            throw new IllegalStateException("Must be element.");
        }
        XmlNode[] xmlNodeArr = new XmlNode[attributes.getLength()];
        for (int i = 0; i < attributes.getLength(); i++) {
            xmlNodeArr[i] = createImpl(attributes.item(i));
        }
        return xmlNodeArr;
    }

    String getAttributeValue() {
        return ((Attr) this.dom).getValue();
    }

    void setAttribute(QName qName, String str) {
        Node node = this.dom;
        if (!(node instanceof Element)) {
            throw new IllegalStateException("Can only set attribute on elements.");
        }
        qName.setAttribute((Element) node, str);
    }

    void replaceWith(XmlNode xmlNode) {
        Node nodeImportNode = xmlNode.dom;
        if (nodeImportNode.getOwnerDocument() != this.dom.getOwnerDocument()) {
            nodeImportNode = this.dom.getOwnerDocument().importNode(nodeImportNode, true);
        }
        this.dom.getParentNode().replaceChild(nodeImportNode, this.dom);
    }

    String ecmaToXMLString(XmlProcessor xmlProcessor) {
        if (isElementType()) {
            Element element = (Element) this.dom.cloneNode(true);
            Namespace[] inScopeNamespaces = getInScopeNamespaces();
            for (int i = 0; i < inScopeNamespaces.length; i++) {
                declareNamespace(element, inScopeNamespaces[i].getPrefix(), inScopeNamespaces[i].getUri());
            }
            return xmlProcessor.ecmaToXmlString(element);
        }
        return xmlProcessor.ecmaToXmlString(this.dom);
    }

    static class Namespace implements Serializable {
        static final Namespace GLOBAL = create("", "");
        private static final long serialVersionUID = 4073904386884677090L;
        private String prefix;
        private String uri;

        static Namespace create(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("Empty string represents default namespace prefix");
            }
            if (str2 == null) {
                throw new IllegalArgumentException("Namespace may not lack a URI");
            }
            Namespace namespace = new Namespace();
            namespace.prefix = str;
            namespace.uri = str2;
            return namespace;
        }

        static Namespace create(String str) {
            Namespace namespace = new Namespace();
            namespace.uri = str;
            if (str != null && str.length() != 0) {
                return namespace;
            }
            namespace.prefix = "";
            return namespace;
        }

        private Namespace() {
        }

        public String toString() {
            return this.prefix == null ? "XmlNode.Namespace [" + this.uri + Constants.AES_SUFFIX : "XmlNode.Namespace [" + this.prefix + "{" + this.uri + "}]";
        }

        boolean isUnspecifiedPrefix() {
            return this.prefix == null;
        }

        boolean is(Namespace namespace) {
            String str;
            String str2 = this.prefix;
            return str2 != null && (str = namespace.prefix) != null && str2.equals(str) && this.uri.equals(namespace.uri);
        }

        boolean isEmpty() {
            String str = this.prefix;
            return str != null && str.equals("") && this.uri.equals("");
        }

        boolean isDefault() {
            String str = this.prefix;
            return str != null && str.equals("");
        }

        boolean isGlobal() {
            String str = this.uri;
            return str != null && str.equals("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrefix(String str) {
            if (str == null) {
                throw new IllegalArgumentException();
            }
            this.prefix = str;
        }

        String getPrefix() {
            return this.prefix;
        }

        String getUri() {
            return this.uri;
        }
    }

    static class QName implements Serializable {
        private static final long serialVersionUID = -6587069811691451077L;
        private String localName;
        private Namespace namespace;

        static QName create(Namespace namespace, String str) {
            if (str != null && str.equals("*")) {
                throw new RuntimeException("* is not valid localName");
            }
            QName qName = new QName();
            qName.namespace = namespace;
            qName.localName = str;
            return qName;
        }

        @Deprecated
        static QName create(String str, String str2, String str3) {
            return create(Namespace.create(str3, str), str2);
        }

        static String qualify(String str, String str2) {
            if (str != null) {
                return str.length() > 0 ? str + ":" + str2 : str2;
            }
            throw new IllegalArgumentException("prefix must not be null");
        }

        private QName() {
        }

        public String toString() {
            return "XmlNode.QName [" + this.localName + Constants.SEPARATOR_COMMA + this.namespace + Constants.AES_SUFFIX;
        }

        private boolean equals(String str, String str2) {
            if (str == null && str2 == null) {
                return true;
            }
            if (str == null || str2 == null) {
                return false;
            }
            return str.equals(str2);
        }

        private boolean namespacesEqual(Namespace namespace, Namespace namespace2) {
            if (namespace == null && namespace2 == null) {
                return true;
            }
            if (namespace == null || namespace2 == null) {
                return false;
            }
            return equals(namespace.getUri(), namespace2.getUri());
        }

        final boolean equals(QName qName) {
            return namespacesEqual(this.namespace, qName.namespace) && equals(this.localName, qName.localName);
        }

        public boolean equals(Object obj) {
            if (obj instanceof QName) {
                return equals((QName) obj);
            }
            return false;
        }

        public int hashCode() {
            String str = this.localName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        void lookupPrefix(Node node) {
            if (node == null) {
                throw new IllegalArgumentException("node must not be null");
            }
            String strLookupPrefix = node.lookupPrefix(this.namespace.getUri());
            if (strLookupPrefix == null) {
                String strLookupNamespaceURI = node.lookupNamespaceURI(null);
                if (strLookupNamespaceURI == null) {
                    strLookupNamespaceURI = "";
                }
                if (this.namespace.getUri().equals(strLookupNamespaceURI)) {
                    strLookupPrefix = "";
                }
            }
            int i = 0;
            while (strLookupPrefix == null) {
                int i2 = i + 1;
                String str = "e4x_" + i;
                if (node.lookupNamespaceURI(str) == null) {
                    Node parentNode = node;
                    while (parentNode.getParentNode() != null && (parentNode.getParentNode() instanceof Element)) {
                        parentNode = parentNode.getParentNode();
                    }
                    ((Element) parentNode).setAttributeNS(XmlNode.XML_NAMESPACES_NAMESPACE_URI, "xmlns:" + str, this.namespace.getUri());
                    strLookupPrefix = str;
                }
                i = i2;
            }
            this.namespace.setPrefix(strLookupPrefix);
        }

        String qualify(Node node) {
            if (this.namespace.getPrefix() == null) {
                if (node != null) {
                    lookupPrefix(node);
                } else if (this.namespace.getUri().equals("")) {
                    this.namespace.setPrefix("");
                } else {
                    this.namespace.setPrefix("");
                }
            }
            return qualify(this.namespace.getPrefix(), this.localName);
        }

        void setAttribute(Element element, String str) {
            if (this.namespace.getPrefix() == null) {
                lookupPrefix(element);
            }
            element.setAttributeNS(this.namespace.getUri(), qualify(this.namespace.getPrefix(), this.localName), str);
        }

        Namespace getNamespace() {
            return this.namespace;
        }

        String getLocalName() {
            return this.localName;
        }
    }

    static class InternalList implements Serializable {
        private static final long serialVersionUID = -3633151157292048978L;
        private List<XmlNode> list = new ArrayList();

        InternalList() {
        }

        private void _add(XmlNode xmlNode) {
            this.list.add(xmlNode);
        }

        XmlNode item(int i) {
            return this.list.get(i);
        }

        void remove(int i) {
            this.list.remove(i);
        }

        void add(InternalList internalList) {
            for (int i = 0; i < internalList.length(); i++) {
                _add(internalList.item(i));
            }
        }

        void add(InternalList internalList, int i, int i2) {
            while (i < i2) {
                _add(internalList.item(i));
                i++;
            }
        }

        void add(XmlNode xmlNode) {
            _add(xmlNode);
        }

        void add(XML xml) {
            _add(xml.getAnnotation());
        }

        void addToList(Object obj) {
            if (obj instanceof Undefined) {
                return;
            }
            if (obj instanceof XMLList) {
                XMLList xMLList = (XMLList) obj;
                for (int i = 0; i < xMLList.length(); i++) {
                    _add(xMLList.item(i).getAnnotation());
                }
                return;
            }
            if (obj instanceof XML) {
                _add(((XML) obj).getAnnotation());
            } else if (obj instanceof XmlNode) {
                _add((XmlNode) obj);
            }
        }

        int length() {
            return this.list.size();
        }
    }

    static abstract class Filter {
        static final Filter COMMENT = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.1
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            boolean accept(Node node) {
                return node.getNodeType() == 8;
            }
        };
        static final Filter TEXT = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.2
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            boolean accept(Node node) {
                return node.getNodeType() == 3;
            }
        };
        static Filter ELEMENT = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.4
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            boolean accept(Node node) {
                return node.getNodeType() == 1;
            }
        };
        static Filter TRUE = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.5
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            boolean accept(Node node) {
                return true;
            }
        };

        abstract boolean accept(Node node);

        Filter() {
        }

        static Filter PROCESSING_INSTRUCTION(final XMLName xMLName) {
            return new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.3
                @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
                boolean accept(Node node) {
                    if (node.getNodeType() == 7) {
                        return xMLName.matchesLocalName(((ProcessingInstruction) node).getTarget());
                    }
                    return false;
                }
            };
        }
    }

    Node toDomNode() {
        return this.dom;
    }
}
