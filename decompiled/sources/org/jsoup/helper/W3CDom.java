package org.jsoup.helper;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import javax.annotation.Nullable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFactoryConfigurationException;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.Selector;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes10.dex */
public class W3CDom {
    private static final String ContextNodeProperty = "jsoupContextNode";
    private static final String ContextProperty = "jsoupContextSource";
    public static final String SourceProperty = "jsoupSource";
    public static final String XPathFactoryProperty = "javax.xml.xpath.XPathFactory:jsoup";
    protected DocumentBuilderFactory factory;
    private boolean namespaceAware = true;

    public W3CDom() {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        this.factory = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
    }

    public boolean namespaceAware() {
        return this.namespaceAware;
    }

    public W3CDom namespaceAware(boolean z) {
        this.namespaceAware = z;
        this.factory.setNamespaceAware(z);
        return this;
    }

    public static Document convert(org.jsoup.nodes.Document document) {
        return new W3CDom().fromJsoup(document);
    }

    public static String asString(Document document, @Nullable Map<String, String> map) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            if (map != null) {
                transformerNewTransformer.setOutputProperties(propertiesFromMap(map));
            }
            if (document.getDoctype() != null) {
                DocumentType doctype = document.getDoctype();
                if (!StringUtil.isBlank(doctype.getPublicId())) {
                    transformerNewTransformer.setOutputProperty("doctype-public", doctype.getPublicId());
                }
                if (!StringUtil.isBlank(doctype.getSystemId())) {
                    transformerNewTransformer.setOutputProperty("doctype-system", doctype.getSystemId());
                } else if (doctype.getName().equalsIgnoreCase("html") && StringUtil.isBlank(doctype.getPublicId()) && StringUtil.isBlank(doctype.getSystemId())) {
                    transformerNewTransformer.setOutputProperty("doctype-system", "about:legacy-compat");
                }
            }
            transformerNewTransformer.transform(dOMSource, streamResult);
            return stringWriter.toString();
        } catch (TransformerException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static Properties propertiesFromMap(Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    public static HashMap<String, String> OutputHtml() {
        return methodMap("html");
    }

    public static HashMap<String, String> OutputXml() {
        return methodMap(AbstractHttpOverXmpp.Xml.ELEMENT);
    }

    private static HashMap<String, String> methodMap(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put(FirebaseAnalytics.Param.METHOD, str);
        return map;
    }

    public Document fromJsoup(org.jsoup.nodes.Document document) {
        return fromJsoup((Element) document);
    }

    public Document fromJsoup(Element element) {
        Validate.notNull(element);
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = this.factory.newDocumentBuilder();
            DOMImplementation dOMImplementation = documentBuilderNewDocumentBuilder.getDOMImplementation();
            Document documentNewDocument = documentBuilderNewDocumentBuilder.newDocument();
            org.jsoup.nodes.Document documentOwnerDocument = element.ownerDocument();
            org.jsoup.nodes.DocumentType documentType = documentOwnerDocument != null ? documentOwnerDocument.documentType() : null;
            if (documentType != null) {
                documentNewDocument.appendChild(dOMImplementation.createDocumentType(documentType.name(), documentType.publicId(), documentType.systemId()));
            }
            documentNewDocument.setXmlStandalone(true);
            documentNewDocument.setUserData(ContextProperty, element instanceof org.jsoup.nodes.Document ? element.child(0) : element, null);
            if (documentOwnerDocument != null) {
                element = documentOwnerDocument;
            }
            convert(element, documentNewDocument);
            return documentNewDocument;
        } catch (ParserConfigurationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void convert(org.jsoup.nodes.Document document, Document document2) {
        convert((Element) document, document2);
    }

    public void convert(Element element, Document document) {
        W3CBuilder w3CBuilder = new W3CBuilder(document);
        w3CBuilder.namespaceAware = this.namespaceAware;
        org.jsoup.nodes.Document documentOwnerDocument = element.ownerDocument();
        if (documentOwnerDocument != null) {
            if (!StringUtil.isBlank(documentOwnerDocument.location())) {
                document.setDocumentURI(documentOwnerDocument.location());
            }
            w3CBuilder.syntax = documentOwnerDocument.outputSettings().syntax();
        }
        if (element instanceof org.jsoup.nodes.Document) {
            element = element.child(0);
        }
        NodeTraversor.traverse(w3CBuilder, element);
    }

    public NodeList selectXpath(String str, Document document) {
        return selectXpath(str, (Node) document);
    }

    public NodeList selectXpath(String str, Node node) {
        XPathFactory xPathFactoryNewInstance;
        Validate.notEmptyParam(str, "xpath");
        Validate.notNullParam(node, "contextNode");
        try {
            if (System.getProperty(XPathFactoryProperty) != null) {
                xPathFactoryNewInstance = XPathFactory.newInstance("jsoup");
            } else {
                xPathFactoryNewInstance = XPathFactory.newInstance();
            }
            NodeList nodeList = (NodeList) xPathFactoryNewInstance.newXPath().compile(str).evaluate(node, XPathConstants.NODESET);
            Validate.notNull(nodeList);
            return nodeList;
        } catch (XPathExpressionException | XPathFactoryConfigurationException e2) {
            throw new Selector.SelectorParseException("Could not evaluate XPath query [%s]: %s", str, e2.getMessage());
        }
    }

    public <T extends org.jsoup.nodes.Node> List<T> sourceNodes(NodeList nodeList, Class<T> cls) {
        Validate.notNull(nodeList);
        Validate.notNull(cls);
        ArrayList arrayList = new ArrayList(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Object userData = nodeList.item(i).getUserData(SourceProperty);
            if (cls.isInstance(userData)) {
                arrayList.add(cls.cast(userData));
            }
        }
        return arrayList;
    }

    public Node contextNode(Document document) {
        return (Node) document.getUserData(ContextNodeProperty);
    }

    public String asString(Document document) {
        return asString(document, null);
    }

    protected static class W3CBuilder implements NodeVisitor {
        private static final String xmlnsKey = "xmlns";
        private static final String xmlnsPrefix = "xmlns:";

        @Nullable
        private final Element contextElement;
        private Node dest;
        private final Document doc;
        private boolean namespaceAware = true;
        private final Stack<HashMap<String, String>> namespacesStack;
        private Document.OutputSettings.Syntax syntax;

        public W3CBuilder(org.w3c.dom.Document document) {
            Stack<HashMap<String, String>> stack = new Stack<>();
            this.namespacesStack = stack;
            this.syntax = Document.OutputSettings.Syntax.xml;
            this.doc = document;
            stack.push(new HashMap<>());
            this.dest = document;
            this.contextElement = (Element) document.getUserData(W3CDom.ContextProperty);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0048 A[Catch: DOMException -> 0x0062, TryCatch #0 {DOMException -> 0x0062, blocks: (B:10:0x0037, B:12:0x003f, B:14:0x004e, B:16:0x0058, B:17:0x005f, B:13:0x0048), top: B:32:0x0037 }] */
        @Override // org.jsoup.select.NodeVisitor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void head(org.jsoup.nodes.Node r5, int r6) {
            /*
                r4 = this;
                java.util.Stack<java.util.HashMap<java.lang.String, java.lang.String>> r6 = r4.namespacesStack
                java.util.HashMap r0 = new java.util.HashMap
                java.util.Stack<java.util.HashMap<java.lang.String, java.lang.String>> r1 = r4.namespacesStack
                java.lang.Object r1 = r1.peek()
                java.util.Map r1 = (java.util.Map) r1
                r0.<init>(r1)
                r6.push(r0)
                boolean r6 = r5 instanceof org.jsoup.nodes.Element
                if (r6 == 0) goto L81
                org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
                java.lang.String r6 = r4.updateNamespaces(r5)
                boolean r0 = r4.namespaceAware
                r1 = 0
                if (r0 == 0) goto L30
                java.util.Stack<java.util.HashMap<java.lang.String, java.lang.String>> r0 = r4.namespacesStack
                java.lang.Object r0 = r0.peek()
                java.util.HashMap r0 = (java.util.HashMap) r0
                java.lang.Object r6 = r0.get(r6)
                java.lang.String r6 = (java.lang.String) r6
                goto L31
            L30:
                r6 = r1
            L31:
                java.lang.String r0 = r5.tagName()
                if (r6 != 0) goto L48
                java.lang.String r2 = ":"
                boolean r2 = r0.contains(r2)     // Catch: org.w3c.dom.DOMException -> L62
                if (r2 == 0) goto L48
                org.w3c.dom.Document r6 = r4.doc     // Catch: org.w3c.dom.DOMException -> L62
                java.lang.String r2 = ""
                org.w3c.dom.Element r6 = r6.createElementNS(r2, r0)     // Catch: org.w3c.dom.DOMException -> L62
                goto L4e
            L48:
                org.w3c.dom.Document r2 = r4.doc     // Catch: org.w3c.dom.DOMException -> L62
                org.w3c.dom.Element r6 = r2.createElementNS(r6, r0)     // Catch: org.w3c.dom.DOMException -> L62
            L4e:
                r4.copyAttributes(r5, r6)     // Catch: org.w3c.dom.DOMException -> L62
                r4.append(r6, r5)     // Catch: org.w3c.dom.DOMException -> L62
                org.jsoup.nodes.Element r2 = r4.contextElement     // Catch: org.w3c.dom.DOMException -> L62
                if (r5 != r2) goto L5f
                org.w3c.dom.Document r2 = r4.doc     // Catch: org.w3c.dom.DOMException -> L62
                java.lang.String r3 = "jsoupContextNode"
                r2.setUserData(r3, r6, r1)     // Catch: org.w3c.dom.DOMException -> L62
            L5f:
                r4.dest = r6     // Catch: org.w3c.dom.DOMException -> L62
                goto Lbc
            L62:
                org.w3c.dom.Document r6 = r4.doc
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "<"
                r1.<init>(r2)
                java.lang.StringBuilder r0 = r1.append(r0)
                java.lang.String r1 = ">"
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                org.w3c.dom.Text r6 = r6.createTextNode(r0)
                r4.append(r6, r5)
                goto Lbc
            L81:
                boolean r6 = r5 instanceof org.jsoup.nodes.TextNode
                if (r6 == 0) goto L95
                org.jsoup.nodes.TextNode r5 = (org.jsoup.nodes.TextNode) r5
                org.w3c.dom.Document r6 = r4.doc
                java.lang.String r0 = r5.getWholeText()
                org.w3c.dom.Text r6 = r6.createTextNode(r0)
                r4.append(r6, r5)
                return
            L95:
                boolean r6 = r5 instanceof org.jsoup.nodes.Comment
                if (r6 == 0) goto La9
                org.jsoup.nodes.Comment r5 = (org.jsoup.nodes.Comment) r5
                org.w3c.dom.Document r6 = r4.doc
                java.lang.String r0 = r5.getData()
                org.w3c.dom.Comment r6 = r6.createComment(r0)
                r4.append(r6, r5)
                return
            La9:
                boolean r6 = r5 instanceof org.jsoup.nodes.DataNode
                if (r6 == 0) goto Lbc
                org.jsoup.nodes.DataNode r5 = (org.jsoup.nodes.DataNode) r5
                org.w3c.dom.Document r6 = r4.doc
                java.lang.String r0 = r5.getWholeData()
                org.w3c.dom.Text r6 = r6.createTextNode(r0)
                r4.append(r6, r5)
            Lbc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.W3CDom.W3CBuilder.head(org.jsoup.nodes.Node, int):void");
        }

        private void append(Node node, org.jsoup.nodes.Node node2) {
            node.setUserData(W3CDom.SourceProperty, node2, null);
            this.dest.appendChild(node);
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(org.jsoup.nodes.Node node, int i) {
            if ((node instanceof Element) && (this.dest.getParentNode() instanceof org.w3c.dom.Element)) {
                this.dest = this.dest.getParentNode();
            }
            this.namespacesStack.pop();
        }

        private void copyAttributes(org.jsoup.nodes.Node node, org.w3c.dom.Element element) {
            for (Attribute attribute : node.attributes()) {
                String validKey = Attribute.getValidKey(attribute.getKey(), this.syntax);
                if (validKey != null) {
                    element.setAttribute(validKey, attribute.getValue());
                }
            }
        }

        private String updateNamespaces(Element element) {
            Iterator<Attribute> it = element.attributes().iterator();
            while (true) {
                String strSubstring = "";
                if (!it.hasNext()) {
                    break;
                }
                Attribute next = it.next();
                String key = next.getKey();
                if (!key.equals(xmlnsKey)) {
                    if (key.startsWith(xmlnsPrefix)) {
                        strSubstring = key.substring(xmlnsPrefix.length());
                    }
                }
                this.namespacesStack.peek().put(strSubstring, next.getValue());
            }
            int iIndexOf = element.tagName().indexOf(58);
            return iIndexOf > 0 ? element.tagName().substring(0, iIndexOf) : "";
        }
    }
}
