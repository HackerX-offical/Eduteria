package org.xmlpull.v1.builder;

/* JADX INFO: loaded from: classes9.dex */
public interface XmlDocument extends XmlContainer, Cloneable {
    void addChild(Object obj);

    XmlComment addComment(String str);

    XmlDoctype addDoctype(String str, String str2);

    XmlElement addDocumentElement(String str);

    XmlElement addDocumentElement(XmlNamespace xmlNamespace, String str);

    XmlNotation addNotation(String str, String str2, String str3, String str4);

    XmlProcessingInstruction addProcessingInstruction(String str, String str2);

    Iterable children();

    Object clone() throws CloneNotSupportedException;

    XmlElement element(XmlNamespace xmlNamespace, String str);

    XmlElement element(XmlNamespace xmlNamespace, String str, boolean z);

    String getBaseUri();

    String getCharacterEncodingScheme();

    XmlElement getDocumentElement();

    String getVersion();

    void insertChild(int i, Object obj);

    boolean isAllDeclarationsProcessed();

    Boolean isStandalone();

    XmlComment newComment(String str);

    XmlDoctype newDoctype(String str, String str2);

    XmlProcessingInstruction newProcessingInstruction(String str, String str2);

    Iterable notations();

    void removeAllChildren();

    void removeAllNotations();

    void removeAllUnparsedEntities();

    XmlElement requiredElement(XmlNamespace xmlNamespace, String str);

    void setCharacterEncodingScheme(String str);

    void setDocumentElement(XmlElement xmlElement);

    Iterable unparsedEntities();
}
