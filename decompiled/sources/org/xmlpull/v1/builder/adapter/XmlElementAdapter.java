package org.xmlpull.v1.builder.adapter;

import java.util.Iterator;
import org.xmlpull.v1.builder.Iterable;
import org.xmlpull.v1.builder.XmlAttribute;
import org.xmlpull.v1.builder.XmlBuilderException;
import org.xmlpull.v1.builder.XmlContainer;
import org.xmlpull.v1.builder.XmlDocument;
import org.xmlpull.v1.builder.XmlElement;
import org.xmlpull.v1.builder.XmlNamespace;

/* JADX INFO: loaded from: classes9.dex */
public class XmlElementAdapter implements XmlElement {
    static /* synthetic */ Class class$org$xmlpull$v1$builder$XmlElement;
    static /* synthetic */ Class class$org$xmlpull$v1$builder$adapter$XmlElementAdapter;
    private XmlContainer parent;
    private XmlElement target;
    private XmlElementAdapter topAdapter;

    public XmlElementAdapter(XmlElement xmlElement) {
        setTarget(xmlElement);
    }

    private void setTarget(XmlElement xmlElement) {
        this.target = xmlElement;
        if (xmlElement.getParent() != null) {
            XmlContainer parent = xmlElement.getParent();
            this.parent = parent;
            if (parent instanceof XmlDocument) {
                ((XmlDocument) parent).setDocumentElement(this);
            }
            XmlContainer xmlContainer = this.parent;
            if (xmlContainer instanceof XmlElement) {
                ((XmlElement) xmlContainer).replaceChild(this, xmlElement);
            }
        }
        Iterator itChildren = xmlElement.children();
        while (itChildren.hasNext()) {
            fixImportedChildParent(itChildren.next());
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Object clone() throws CloneNotSupportedException {
        XmlElementAdapter xmlElementAdapter = (XmlElementAdapter) super.clone();
        xmlElementAdapter.parent = null;
        xmlElementAdapter.target = (XmlElement) this.target.clone();
        return xmlElementAdapter;
    }

    public XmlElement getTarget() {
        return this.target;
    }

    public XmlElementAdapter getTopAdapter() {
        XmlElementAdapter xmlElementAdapter = this.topAdapter;
        return xmlElementAdapter != null ? xmlElementAdapter : this;
    }

    public void setTopAdapter(XmlElementAdapter xmlElementAdapter) {
        this.topAdapter = xmlElementAdapter;
        XmlElement xmlElement = this.target;
        if (xmlElement instanceof XmlElementAdapter) {
            ((XmlElementAdapter) xmlElement).setTopAdapter(xmlElementAdapter);
        }
    }

    public static XmlElementAdapter castOrWrap(XmlElement xmlElement, Class cls) {
        if (xmlElement == null) {
            throw new IllegalArgumentException("null element can not be wrapped");
        }
        Class clsClass$ = class$org$xmlpull$v1$builder$adapter$XmlElementAdapter;
        if (clsClass$ == null) {
            clsClass$ = class$("org.xmlpull.v1.builder.adapter.XmlElementAdapter");
            class$org$xmlpull$v1$builder$adapter$XmlElementAdapter = clsClass$;
        }
        if (!clsClass$.isAssignableFrom(cls)) {
            StringBuffer stringBuffer = new StringBuffer("class for cast/wrap must extend ");
            Class clsClass$2 = class$org$xmlpull$v1$builder$adapter$XmlElementAdapter;
            if (clsClass$2 == null) {
                clsClass$2 = class$("org.xmlpull.v1.builder.adapter.XmlElementAdapter");
                class$org$xmlpull$v1$builder$adapter$XmlElementAdapter = clsClass$2;
            }
            throw new IllegalArgumentException(stringBuffer.append(clsClass$2).toString());
        }
        if (xmlElement instanceof XmlElementAdapter) {
            XmlElementAdapter xmlElementAdapter = (XmlElementAdapter) xmlElement;
            if (cls.isAssignableFrom(xmlElementAdapter.getClass())) {
                return xmlElementAdapter;
            }
            XmlElementAdapter topAdapter = xmlElementAdapter.getTopAdapter();
            XmlElementAdapter xmlElementAdapter2 = topAdapter;
            while (xmlElementAdapter2.topAdapter != null) {
                if (xmlElementAdapter2.getClass().isAssignableFrom(cls)) {
                    return xmlElementAdapter2;
                }
                XmlElement xmlElement2 = xmlElementAdapter2.target;
                if (xmlElement2 instanceof XmlElementAdapter) {
                    xmlElementAdapter2 = (XmlElementAdapter) xmlElement2;
                }
            }
            try {
                Class<?>[] clsArr = new Class[1];
                Class<?> clsClass$3 = class$org$xmlpull$v1$builder$XmlElement;
                if (clsClass$3 == null) {
                    clsClass$3 = class$("org.xmlpull.v1.builder.XmlElement");
                    class$org$xmlpull$v1$builder$XmlElement = clsClass$3;
                }
                clsArr[0] = clsClass$3;
                XmlElementAdapter xmlElementAdapter3 = (XmlElementAdapter) cls.getConstructor(clsArr).newInstance(topAdapter);
                xmlElementAdapter2.topAdapter = xmlElementAdapter3;
                xmlElementAdapter3.setTopAdapter(xmlElementAdapter3);
                return xmlElementAdapter2.topAdapter;
            } catch (Exception e2) {
                throw new XmlBuilderException(new StringBuffer("could not create wrapper of ").append(cls).toString(), e2);
            }
        }
        try {
            Class<?>[] clsArr2 = new Class[1];
            Class<?> clsClass$4 = class$org$xmlpull$v1$builder$XmlElement;
            if (clsClass$4 == null) {
                clsClass$4 = class$("org.xmlpull.v1.builder.XmlElement");
                class$org$xmlpull$v1$builder$XmlElement = clsClass$4;
            }
            clsArr2[0] = clsClass$4;
            return (XmlElementAdapter) cls.getConstructor(clsArr2).newInstance(xmlElement);
        } catch (Exception e3) {
            throw new XmlBuilderException(new StringBuffer("could not wrap element ").append(xmlElement).toString(), e3);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private void fixImportedChildParent(Object obj) {
        if (obj instanceof XmlElement) {
            XmlElement xmlElement = (XmlElement) obj;
            if (xmlElement.getParent() == this.target) {
                xmlElement.setParent(this);
            }
        }
    }

    private XmlElement fixElementParent(XmlElement xmlElement) {
        xmlElement.setParent(this);
        return xmlElement;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlContainer getRoot() {
        XmlContainer root = this.target.getRoot();
        return root == this.target ? this : root;
    }

    @Override // org.xmlpull.v1.builder.XmlElement, org.xmlpull.v1.builder.XmlContained
    public XmlContainer getParent() {
        return this.parent;
    }

    @Override // org.xmlpull.v1.builder.XmlElement, org.xmlpull.v1.builder.XmlContained
    public void setParent(XmlContainer xmlContainer) {
        this.parent = xmlContainer;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace newNamespace(String str, String str2) {
        return this.target.newNamespace(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute attribute(String str) {
        return this.target.attribute(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute attribute(XmlNamespace xmlNamespace, String str) {
        return this.target.attribute(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute findAttribute(String str, String str2) {
        return this.target.findAttribute(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator attributes() {
        return this.target.attributes();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllChildren() {
        this.target.removeAllChildren();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, String str2, String str3, String str4, String str5, boolean z) {
        return this.target.addAttribute(str, str2, str3, str4, str5, z);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getAttributeValue(String str, String str2) {
        return this.target.getAttributeValue(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(XmlNamespace xmlNamespace, String str, String str2) {
        return this.target.addAttribute(xmlNamespace, str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getNamespaceName() {
        return this.target.getNamespaceName();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureChildrenCapacity(int i) {
        this.target.ensureChildrenCapacity(i);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator namespaces() {
        return this.target.namespaces();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllAttributes() {
        this.target.removeAllAttributes();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace getNamespace() {
        return this.target.getNamespace();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getBaseUri() {
        return this.target.getBaseUri();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAttribute(XmlAttribute xmlAttribute) {
        this.target.removeAttribute(xmlAttribute);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace declareNamespace(String str, String str2) {
        return this.target.declareNamespace(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllNamespaceDeclarations() {
        this.target.removeAllNamespaceDeclarations();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasAttributes() {
        return this.target.hasAttributes();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, XmlNamespace xmlNamespace, String str2, String str3, boolean z) {
        return this.target.addAttribute(str, xmlNamespace, str2, str3, z);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace declareNamespace(XmlNamespace xmlNamespace) {
        return this.target.declareNamespace(xmlNamespace);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, String str2) {
        return this.target.addAttribute(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasNamespaceDeclarations() {
        return this.target.hasNamespaceDeclarations();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace lookupNamespaceByName(String str) {
        XmlNamespace xmlNamespaceLookupNamespaceByName = this.target.lookupNamespaceByName(str);
        if (xmlNamespaceLookupNamespaceByName == null) {
            XmlContainer parent = getParent();
            if (parent instanceof XmlElement) {
                return ((XmlElement) parent).lookupNamespaceByName(str);
            }
        }
        return xmlNamespaceLookupNamespaceByName;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace lookupNamespaceByPrefix(String str) {
        XmlNamespace xmlNamespaceLookupNamespaceByPrefix = this.target.lookupNamespaceByPrefix(str);
        if (xmlNamespaceLookupNamespaceByPrefix == null) {
            XmlContainer parent = getParent();
            if (parent instanceof XmlElement) {
                return ((XmlElement) parent).lookupNamespaceByPrefix(str);
            }
        }
        return xmlNamespaceLookupNamespaceByPrefix;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace newNamespace(String str) {
        return this.target.newNamespace(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void setBaseUri(String str) {
        this.target.setBaseUri(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void setNamespace(XmlNamespace xmlNamespace) {
        this.target.setNamespace(xmlNamespace);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureNamespaceDeclarationsCapacity(int i) {
        this.target.ensureNamespaceDeclarationsCapacity(i);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getName() {
        return this.target.getName();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void setName(String str) {
        this.target.setName(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, XmlNamespace xmlNamespace, String str2, String str3) {
        return this.target.addAttribute(str, xmlNamespace, str2, str3);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureAttributeCapacity(int i) {
        this.target.ensureAttributeCapacity(i);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(XmlAttribute xmlAttribute) {
        return this.target.addAttribute(xmlAttribute);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement element(int i) {
        return this.target.element(i);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement requiredElement(XmlNamespace xmlNamespace, String str) {
        return this.target.requiredElement(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement element(XmlNamespace xmlNamespace, String str) {
        return this.target.element(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement element(XmlNamespace xmlNamespace, String str, boolean z) {
        return this.target.element(xmlNamespace, str, z);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterable elements(XmlNamespace xmlNamespace, String str) {
        return this.target.elements(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, XmlElement xmlElement) {
        return this.target.findElementByName(str, xmlElement);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(XmlNamespace xmlNamespace, String str) {
        return this.target.newElement(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(XmlElement xmlElement) {
        return fixElementParent(this.target.addElement(xmlElement));
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(int i, XmlElement xmlElement) {
        return fixElementParent(this.target.addElement(i, xmlElement));
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(String str) {
        return fixElementParent(this.target.addElement(str));
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, String str2) {
        return this.target.findElementByName(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void addChild(Object obj) {
        this.target.addChild(obj);
        fixImportedChildParent(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void insertChild(int i, Object obj) {
        this.target.insertChild(i, obj);
        fixImportedChildParent(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str) {
        return this.target.findElementByName(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, String str2, XmlElement xmlElement) {
        return this.target.findElementByName(str, str2, xmlElement);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeChild(Object obj) {
        this.target.removeChild(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator children() {
        return this.target.children();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterable requiredElementContent() {
        return this.target.requiredElementContent();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String requiredTextContent() {
        return this.target.requiredTextContent();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasChild(Object obj) {
        return this.target.hasChild(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(String str, String str2) {
        return this.target.newElement(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(XmlNamespace xmlNamespace, String str) {
        return fixElementParent(this.target.addElement(xmlNamespace, str));
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasChildren() {
        return this.target.hasChildren();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void addChild(int i, Object obj) {
        this.target.addChild(i, obj);
        fixImportedChildParent(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void replaceChild(Object obj, Object obj2) {
        this.target.replaceChild(obj, obj2);
        fixImportedChildParent(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(String str) {
        return this.target.newElement(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void replaceChildrenWithText(String str) {
        this.target.replaceChildrenWithText(str);
    }
}
