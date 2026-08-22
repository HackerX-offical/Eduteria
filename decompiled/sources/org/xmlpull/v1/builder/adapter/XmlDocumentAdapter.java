package org.xmlpull.v1.builder.adapter;

import org.xmlpull.v1.builder.Iterable;
import org.xmlpull.v1.builder.XmlComment;
import org.xmlpull.v1.builder.XmlDoctype;
import org.xmlpull.v1.builder.XmlDocument;
import org.xmlpull.v1.builder.XmlElement;
import org.xmlpull.v1.builder.XmlNamespace;
import org.xmlpull.v1.builder.XmlNotation;
import org.xmlpull.v1.builder.XmlProcessingInstruction;

/* JADX INFO: loaded from: classes9.dex */
public class XmlDocumentAdapter implements XmlDocument {
    private XmlDocument target;

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Object clone() throws CloneNotSupportedException {
        XmlDocumentAdapter xmlDocumentAdapter = (XmlDocumentAdapter) super.clone();
        xmlDocumentAdapter.target = (XmlDocument) this.target.clone();
        return xmlDocumentAdapter;
    }

    public XmlDocumentAdapter(XmlDocument xmlDocument) {
        this.target = xmlDocument;
        fixImportedChildParent(xmlDocument.getDocumentElement());
    }

    private void fixImportedChildParent(Object obj) {
        if (obj instanceof XmlElement) {
            XmlElement xmlElement = (XmlElement) obj;
            if (xmlElement.getParent() == this.target) {
                xmlElement.setParent(this);
            }
        }
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterable children() {
        return this.target.children();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement getDocumentElement() {
        return this.target.getDocumentElement();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement requiredElement(XmlNamespace xmlNamespace, String str) {
        return this.target.requiredElement(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement element(XmlNamespace xmlNamespace, String str) {
        return this.target.element(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement element(XmlNamespace xmlNamespace, String str, boolean z) {
        return this.target.element(xmlNamespace, str, z);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterable notations() {
        return this.target.notations();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterable unparsedEntities() {
        return this.target.unparsedEntities();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getBaseUri() {
        return this.target.getBaseUri();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getCharacterEncodingScheme() {
        return this.target.getCharacterEncodingScheme();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void setCharacterEncodingScheme(String str) {
        this.target.setCharacterEncodingScheme(str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public Boolean isStandalone() {
        return this.target.isStandalone();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getVersion() {
        return this.target.getVersion();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public boolean isAllDeclarationsProcessed() {
        return this.target.isAllDeclarationsProcessed();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void setDocumentElement(XmlElement xmlElement) {
        this.target.setDocumentElement(xmlElement);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void addChild(Object obj) {
        this.target.addChild(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void insertChild(int i, Object obj) {
        this.target.insertChild(i, obj);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllChildren() {
        this.target.removeAllChildren();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlComment newComment(String str) {
        return this.target.newComment(str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlComment addComment(String str) {
        return this.target.addComment(str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlDoctype newDoctype(String str, String str2) {
        return this.target.newDoctype(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlDoctype addDoctype(String str, String str2) {
        return this.target.addDoctype(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement addDocumentElement(String str) {
        return this.target.addDocumentElement(str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement addDocumentElement(XmlNamespace xmlNamespace, String str) {
        return this.target.addDocumentElement(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlProcessingInstruction newProcessingInstruction(String str, String str2) {
        return this.target.newProcessingInstruction(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlProcessingInstruction addProcessingInstruction(String str, String str2) {
        return this.target.addProcessingInstruction(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllUnparsedEntities() {
        this.target.removeAllUnparsedEntities();
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlNotation addNotation(String str, String str2, String str3, String str4) {
        return this.target.addNotation(str, str2, str3, str4);
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllNotations() {
        this.target.removeAllNotations();
    }
}
