package org.xmlpull.v1.builder.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.builder.Iterable;
import org.xmlpull.v1.builder.XmlBuilderException;
import org.xmlpull.v1.builder.XmlComment;
import org.xmlpull.v1.builder.XmlDoctype;
import org.xmlpull.v1.builder.XmlDocument;
import org.xmlpull.v1.builder.XmlElement;
import org.xmlpull.v1.builder.XmlNamespace;
import org.xmlpull.v1.builder.XmlNotation;
import org.xmlpull.v1.builder.XmlProcessingInstruction;

/* JADX INFO: loaded from: classes9.dex */
public class XmlDocumentImpl implements XmlDocument {
    private String characterEncoding;
    private List children = new ArrayList();
    private XmlElement root;
    private Boolean standalone;
    private String version;

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Object clone() throws CloneNotSupportedException {
        XmlDocumentImpl xmlDocumentImpl = (XmlDocumentImpl) super.clone();
        xmlDocumentImpl.root = null;
        xmlDocumentImpl.children = cloneList(xmlDocumentImpl, this.children);
        int iFindDocumentElement = xmlDocumentImpl.findDocumentElement();
        if (iFindDocumentElement >= 0) {
            XmlElement xmlElement = (XmlElement) xmlDocumentImpl.children.get(iFindDocumentElement);
            xmlDocumentImpl.root = xmlElement;
            xmlElement.setParent(xmlDocumentImpl);
        }
        return xmlDocumentImpl;
    }

    private List cloneList(XmlDocumentImpl xmlDocumentImpl, List list) throws CloneNotSupportedException {
        Object objInvoke;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof XmlElement) {
                objInvoke = ((XmlElement) obj).clone();
            } else if (obj instanceof Cloneable) {
                try {
                    objInvoke = obj.getClass().getMethod("clone", null).invoke(obj, null);
                } catch (Exception e2) {
                    throw new CloneNotSupportedException(new StringBuffer("failed to call clone() on  ").append(obj).append(e2).toString());
                }
            } else {
                throw new CloneNotSupportedException(new StringBuffer("could not clone ").append(obj).append(" of ").append(obj != null ? obj.getClass().toString() : "").toString());
            }
            arrayList.add(objInvoke);
        }
        return arrayList;
    }

    public XmlDocumentImpl(String str, Boolean bool, String str2) {
        this.version = str;
        this.standalone = bool;
        this.characterEncoding = str2;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getVersion() {
        return this.version;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Boolean isStandalone() {
        return this.standalone;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getCharacterEncodingScheme() {
        return this.characterEncoding;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void setCharacterEncodingScheme(String str) {
        this.characterEncoding = str;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlProcessingInstruction newProcessingInstruction(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlProcessingInstruction addProcessingInstruction(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterable children() {
        return new Iterable() { // from class: org.xmlpull.v1.builder.impl.XmlDocumentImpl.1
            @Override // org.xmlpull.v1.builder.Iterable
            public Iterator iterator() {
                return XmlDocumentImpl.this.children.iterator();
            }
        };
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllUnparsedEntities() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void setDocumentElement(XmlElement xmlElement) {
        int iFindDocumentElement = findDocumentElement();
        if (iFindDocumentElement >= 0) {
            this.children.set(iFindDocumentElement, xmlElement);
        } else {
            this.children.add(xmlElement);
        }
        this.root = xmlElement;
        xmlElement.setParent(this);
    }

    private int findDocumentElement() {
        for (int i = 0; i < this.children.size(); i++) {
            if (this.children.get(i) instanceof XmlElement) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement requiredElement(XmlNamespace xmlNamespace, String str) {
        XmlElement xmlElementElement = element(xmlNamespace, str);
        if (xmlElementElement != null) {
            return xmlElementElement;
        }
        throw new XmlBuilderException(new StringBuffer("document does not contain element with name ").append(str).append(" in namespace ").append(xmlNamespace.getNamespaceName()).toString());
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement element(XmlNamespace xmlNamespace, String str) {
        return element(xmlNamespace, str, false);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement element(XmlNamespace xmlNamespace, String str, boolean z) {
        XmlElement documentElement = getDocumentElement();
        if (documentElement == null) {
            return null;
        }
        String namespaceName = documentElement.getNamespace() != null ? documentElement.getNamespace().getNamespaceName() : null;
        if (xmlNamespace == null ? str.equals(documentElement.getName()) && namespaceName == null : str.equals(documentElement.getName()) && namespaceName != null && namespaceName.equals(xmlNamespace.getNamespaceName())) {
            return documentElement;
        }
        if (z) {
            return addDocumentElement(xmlNamespace, str);
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void insertChild(int i, Object obj) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlComment addComment(String str) {
        XmlCommentImpl xmlCommentImpl = new XmlCommentImpl(this, str);
        this.children.add(xmlCommentImpl);
        return xmlCommentImpl;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlDoctype newDoctype(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterable unparsedEntities() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllChildren() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlComment newComment(String str) {
        return new XmlCommentImpl(null, str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllNotations() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlDoctype addDoctype(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void addChild(Object obj) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlNotation addNotation(String str, String str2, String str3, String str4) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getBaseUri() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterable notations() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement addDocumentElement(String str) {
        return addDocumentElement(null, str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement addDocumentElement(XmlNamespace xmlNamespace, String str) {
        XmlElementImpl xmlElementImpl = new XmlElementImpl(xmlNamespace, str);
        if (getDocumentElement() != null) {
            throw new XmlBuilderException("document already has root element");
        }
        setDocumentElement(xmlElementImpl);
        return xmlElementImpl;
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public boolean isAllDeclarationsProcessed() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement getDocumentElement() {
        return this.root;
    }
}
