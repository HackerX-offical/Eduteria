package org.xmlpull.v1.dom2_builder;

import java.io.IOException;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes9.dex */
public class DOM2XmlPullBuilder {
    public static void main(String[] strArr) throws Exception {
    }

    protected Document newDoc() throws XmlPullParserException {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            documentBuilderNewDocumentBuilder.getDOMImplementation();
            return documentBuilderNewDocumentBuilder.newDocument();
        } catch (FactoryConfigurationError e2) {
            throw new XmlPullParserException(new StringBuffer("could not configure factory JAXP DocumentBuilderFactory: ").append(e2).toString(), null, e2);
        } catch (ParserConfigurationException e3) {
            throw new XmlPullParserException(new StringBuffer("could not configure parser JAXP DocumentBuilderFactory: ").append(e3).toString(), null, e3);
        }
    }

    protected XmlPullParser newParser() throws XmlPullParserException {
        return XmlPullParserFactory.newInstance().newPullParser();
    }

    public Element parse(Reader reader) throws XmlPullParserException, IOException {
        return parse(reader, newDoc());
    }

    public Element parse(Reader reader, Document document) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewParser = newParser();
        xmlPullParserNewParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
        xmlPullParserNewParser.setInput(reader);
        xmlPullParserNewParser.next();
        return parse(xmlPullParserNewParser, document);
    }

    public Element parse(XmlPullParser xmlPullParser, Document document) throws XmlPullParserException, IOException {
        return parseSubTree(xmlPullParser, document);
    }

    public Element parseSubTree(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseSubTree(xmlPullParser, newDoc());
    }

    public Element parseSubTree(XmlPullParser xmlPullParser, Document document) throws XmlPullParserException, IOException {
        return new BuildProcess().parseSubTree(xmlPullParser, document);
    }

    static class BuildProcess {
        private Document docFactory;
        private XmlPullParser pp;
        private boolean scanNamespaces;

        private BuildProcess() {
            this.scanNamespaces = true;
        }

        public Element parseSubTree(XmlPullParser xmlPullParser, Document document) throws XmlPullParserException, IOException {
            this.pp = xmlPullParser;
            this.docFactory = document;
            return parseSubTree();
        }

        private Element parseSubTree() throws XmlPullParserException, IOException {
            this.pp.require(2, null, null);
            String name = this.pp.getName();
            String namespace = this.pp.getNamespace();
            String prefix = this.pp.getPrefix();
            Element elementCreateElementNS = this.docFactory.createElementNS(namespace, prefix != null ? new StringBuffer().append(prefix).append(":").append(name).toString() : name);
            declareNamespaces(this.pp, elementCreateElementNS);
            for (int i = 0; i < this.pp.getAttributeCount(); i++) {
                String attributeNamespace = this.pp.getAttributeNamespace(i);
                String attributeName = this.pp.getAttributeName(i);
                String attributeValue = this.pp.getAttributeValue(i);
                if (attributeNamespace == null || attributeNamespace.length() == 0) {
                    elementCreateElementNS.setAttribute(attributeName, attributeValue);
                } else {
                    String attributePrefix = this.pp.getAttributePrefix(i);
                    if (attributePrefix != null) {
                        attributeName = new StringBuffer().append(attributePrefix).append(":").append(attributeName).toString();
                    }
                    elementCreateElementNS.setAttributeNS(attributeNamespace, attributeName, attributeValue);
                }
            }
            while (this.pp.next() != 3) {
                if (this.pp.getEventType() == 2) {
                    elementCreateElementNS.appendChild(parseSubTree(this.pp, this.docFactory));
                } else if (this.pp.getEventType() == 4) {
                    elementCreateElementNS.appendChild(this.docFactory.createTextNode(this.pp.getText()));
                } else {
                    throw new XmlPullParserException(new StringBuffer("unexpected event ").append(XmlPullParser.TYPES[this.pp.getEventType()]).toString(), this.pp, null);
                }
            }
            this.pp.require(3, namespace, name);
            return elementCreateElementNS;
        }

        private void declareNamespaces(XmlPullParser xmlPullParser, Element element) throws XmlPullParserException, DOMException {
            if (this.scanNamespaces) {
                this.scanNamespaces = false;
                int namespaceCount = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth()) - 1;
                for (int i = namespaceCount; i >= xmlPullParser.getNamespaceCount(0); i--) {
                    String namespacePrefix = xmlPullParser.getNamespacePrefix(i);
                    int i2 = namespaceCount;
                    while (true) {
                        if (i2 > i) {
                            String namespacePrefix2 = xmlPullParser.getNamespacePrefix(i2);
                            if ((namespacePrefix == null || !namespacePrefix.equals(namespacePrefix2)) && (namespacePrefix == null || namespacePrefix != namespacePrefix2)) {
                                i2--;
                            }
                        } else {
                            declareOneNamespace(xmlPullParser, i, element);
                            break;
                        }
                    }
                }
                return;
            }
            for (int namespaceCount2 = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth() - 1); namespaceCount2 < xmlPullParser.getNamespaceCount(xmlPullParser.getDepth()); namespaceCount2++) {
                declareOneNamespace(xmlPullParser, namespaceCount2, element);
            }
        }

        private void declareOneNamespace(XmlPullParser xmlPullParser, int i, Element element) throws XmlPullParserException, DOMException {
            String namespacePrefix = xmlPullParser.getNamespacePrefix(i);
            element.setAttributeNS("http://www.w3.org/2000/xmlns/", namespacePrefix != null ? new StringBuffer("xmlns:").append(namespacePrefix).toString() : "xmlns", xmlPullParser.getNamespaceUri(i));
        }
    }

    private static void assertEquals(String str, String str2) {
        if ((str != null && !str.equals(str2)) || (str == null && str2 == null)) {
            throw new RuntimeException(new StringBuffer("expected '").append(str).append("' but got '").append(str2).append("'").toString());
        }
    }

    private static void assertNotNull(Object obj) {
        if (obj == null) {
            throw new RuntimeException("expected no null value");
        }
    }
}
