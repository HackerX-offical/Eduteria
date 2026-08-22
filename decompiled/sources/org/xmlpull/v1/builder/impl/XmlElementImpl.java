package org.xmlpull.v1.builder.impl;

import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.builder.Iterable;
import org.xmlpull.v1.builder.XmlAttribute;
import org.xmlpull.v1.builder.XmlBuilderException;
import org.xmlpull.v1.builder.XmlCharacters;
import org.xmlpull.v1.builder.XmlContained;
import org.xmlpull.v1.builder.XmlContainer;
import org.xmlpull.v1.builder.XmlDocument;
import org.xmlpull.v1.builder.XmlElement;
import org.xmlpull.v1.builder.XmlNamespace;

/* JADX INFO: loaded from: classes9.dex */
public class XmlElementImpl implements XmlElement {
    private List attrs;
    private List children;
    private String name;
    private XmlNamespace namespace;
    private List nsList;
    private XmlContainer parent;
    private static final Iterator EMPTY_ITERATOR = new EmptyIterator();
    private static final Iterable EMPTY_ITERABLE = new Iterable() { // from class: org.xmlpull.v1.builder.impl.XmlElementImpl.3
        @Override // org.xmlpull.v1.builder.Iterable
        public Iterator iterator() {
            return XmlElementImpl.EMPTY_ITERATOR;
        }
    };

    @Override // org.xmlpull.v1.builder.XmlElement
    public Object clone() throws CloneNotSupportedException {
        XmlElementImpl xmlElementImpl = (XmlElementImpl) super.clone();
        xmlElementImpl.parent = null;
        xmlElementImpl.attrs = cloneList(xmlElementImpl, this.attrs);
        xmlElementImpl.nsList = cloneList(xmlElementImpl, this.nsList);
        List listCloneList = cloneList(xmlElementImpl, this.children);
        xmlElementImpl.children = listCloneList;
        if (listCloneList != null) {
            for (int i = 0; i < xmlElementImpl.children.size(); i++) {
                Object obj = xmlElementImpl.children.get(i);
                if (obj instanceof XmlContained) {
                    XmlContained xmlContained = (XmlContained) obj;
                    if (xmlContained.getParent() == this) {
                        xmlContained.setParent(null);
                        xmlContained.setParent(xmlElementImpl);
                    }
                }
            }
        }
        return xmlElementImpl;
    }

    private List cloneList(XmlElementImpl xmlElementImpl, List list) throws CloneNotSupportedException {
        XmlElementImpl xmlElementImpl2;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (i < list.size()) {
            Object objInvoke = list.get(i);
            if ((objInvoke instanceof XmlNamespace) || (objInvoke instanceof String)) {
                xmlElementImpl2 = xmlElementImpl;
            } else if (objInvoke instanceof XmlElement) {
                objInvoke = ((XmlElement) objInvoke).clone();
                xmlElementImpl2 = xmlElementImpl;
            } else if (objInvoke instanceof XmlAttribute) {
                XmlAttribute xmlAttribute = (XmlAttribute) objInvoke;
                xmlElementImpl2 = xmlElementImpl;
                objInvoke = new XmlAttributeImpl(xmlElementImpl2, xmlAttribute.getType(), xmlAttribute.getNamespace(), xmlAttribute.getName(), xmlAttribute.getValue(), xmlAttribute.isSpecified());
            } else {
                xmlElementImpl2 = xmlElementImpl;
                if (objInvoke instanceof Cloneable) {
                    try {
                        objInvoke = objInvoke.getClass().getMethod("clone", null).invoke(objInvoke, null);
                    } catch (Exception e2) {
                        throw new CloneNotSupportedException(new StringBuffer("failed to call clone() on  ").append(objInvoke).append(e2).toString());
                    }
                } else {
                    throw new CloneNotSupportedException();
                }
            }
            arrayList.add(objInvoke);
            i++;
            xmlElementImpl = xmlElementImpl2;
        }
        return arrayList;
    }

    XmlElementImpl(String str) {
        this.name = str;
    }

    XmlElementImpl(XmlNamespace xmlNamespace, String str) {
        this.namespace = xmlNamespace;
        this.name = str;
    }

    XmlElementImpl(String str, String str2) {
        if (str != null) {
            this.namespace = new XmlNamespaceImpl(null, str);
        }
        this.name = str2;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlContainer getRoot() {
        XmlContainer parent = this;
        while (parent instanceof XmlElement) {
            XmlElement xmlElement = (XmlElement) parent;
            if (xmlElement.getParent() == null) {
                break;
            }
            parent = xmlElement.getParent();
        }
        return parent;
    }

    @Override // org.xmlpull.v1.builder.XmlElement, org.xmlpull.v1.builder.XmlContained
    public XmlContainer getParent() {
        return this.parent;
    }

    @Override // org.xmlpull.v1.builder.XmlElement, org.xmlpull.v1.builder.XmlContained
    public void setParent(XmlContainer xmlContainer) {
        if (xmlContainer != null && (xmlContainer instanceof XmlDocument) && ((XmlDocument) xmlContainer).getDocumentElement() != this) {
            throw new XmlBuilderException("this element must be root document element to have document set as parent but already different element is set as root document element");
        }
        this.parent = xmlContainer;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace getNamespace() {
        return this.namespace;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getNamespaceName() {
        XmlNamespace xmlNamespace = this.namespace;
        if (xmlNamespace != null) {
            return xmlNamespace.getNamespaceName();
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void setNamespace(XmlNamespace xmlNamespace) {
        this.namespace = xmlNamespace;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getName() {
        return this.name;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return new StringBuffer("name[").append(this.name).append(Constants.AES_SUFFIX).append(this.namespace != null ? new StringBuffer(" namespace[").append(this.namespace.getNamespaceName()).append(Constants.AES_SUFFIX).toString() : "").toString();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getBaseUri() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void setBaseUri(String str) {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator attributes() {
        List list = this.attrs;
        if (list == null) {
            return EMPTY_ITERATOR;
        }
        return list.iterator();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(XmlAttribute xmlAttribute) {
        if (this.attrs == null) {
            ensureAttributeCapacity(5);
        }
        this.attrs.add(xmlAttribute);
        return xmlAttribute;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(XmlNamespace xmlNamespace, String str, String str2) {
        return addAttribute("CDATA", xmlNamespace, str, str2, false);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, String str2) {
        return addAttribute("CDATA", null, str, str2, false);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, XmlNamespace xmlNamespace, String str2, String str3) {
        return addAttribute(str, xmlNamespace, str2, str3, false);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, XmlNamespace xmlNamespace, String str2, String str3, boolean z) {
        return addAttribute(new XmlAttributeImpl(this, str, xmlNamespace, str2, str3, z));
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, String str2, String str3, String str4, String str5, boolean z) {
        return addAttribute(str, newNamespace(str2, str3), str4, str5, z);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureAttributeCapacity(int i) {
        List list = this.attrs;
        if (list == null) {
            this.attrs = new ArrayList(i);
        } else {
            ((ArrayList) list).ensureCapacity(i);
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String getAttributeValue(String str, String str2) {
        XmlAttribute xmlAttributeFindAttribute = findAttribute(str, str2);
        if (xmlAttributeFindAttribute != null) {
            return xmlAttributeFindAttribute.getValue();
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasAttributes() {
        List list = this.attrs;
        return list != null && list.size() > 0;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute attribute(String str) {
        return attribute(null, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute attribute(XmlNamespace xmlNamespace, String str) {
        return findAttribute(xmlNamespace != null ? xmlNamespace.getNamespaceName() : null, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute findAttribute(String str, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("attribute name ca not ber null");
        }
        List list = this.attrs;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            XmlAttribute xmlAttribute = (XmlAttribute) this.attrs.get(i);
            String name = xmlAttribute.getName();
            if (name == str2 || str2.equals(name)) {
                if (str != null) {
                    String namespaceName = xmlAttribute.getNamespaceName();
                    if (str.equals(namespaceName) || (str == "" && namespaceName == null)) {
                        return xmlAttribute;
                    }
                } else if (xmlAttribute.getNamespace() == null || xmlAttribute.getNamespace().getNamespaceName() == "") {
                    return xmlAttribute;
                }
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllAttributes() {
        this.attrs = null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAttribute(XmlAttribute xmlAttribute) {
        if (this.attrs == null) {
            throw new XmlBuilderException("this element has no attributes to remove");
        }
        for (int i = 0; i < this.attrs.size(); i++) {
            if (this.attrs.get(i).equals(xmlAttribute)) {
                this.attrs.remove(i);
                return;
            }
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace declareNamespace(String str, String str2) {
        if (str == null) {
            throw new XmlBuilderException("namespace added to element must have not null prefix");
        }
        return declareNamespace(newNamespace(str, str2));
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace declareNamespace(XmlNamespace xmlNamespace) {
        if (xmlNamespace.getPrefix() == null) {
            throw new XmlBuilderException("namespace added to element must have not null prefix");
        }
        if (this.nsList == null) {
            ensureNamespaceDeclarationsCapacity(5);
        }
        this.nsList.add(xmlNamespace);
        return xmlNamespace;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasNamespaceDeclarations() {
        List list = this.nsList;
        return list != null && list.size() > 0;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace lookupNamespaceByPrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("namespace prefix can not be null");
        }
        if (hasNamespaceDeclarations()) {
            int size = this.nsList.size();
            for (int i = 0; i < size; i++) {
                XmlNamespace xmlNamespace = (XmlNamespace) this.nsList.get(i);
                if (str.equals(xmlNamespace.getPrefix())) {
                    return xmlNamespace;
                }
            }
        }
        XmlContainer xmlContainer = this.parent;
        if (xmlContainer == null || !(xmlContainer instanceof XmlElement)) {
            return null;
        }
        return ((XmlElement) xmlContainer).lookupNamespaceByPrefix(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace lookupNamespaceByName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("namespace name can not ber null");
        }
        if (hasNamespaceDeclarations()) {
            int size = this.nsList.size();
            for (int i = 0; i < size; i++) {
                XmlNamespace xmlNamespace = (XmlNamespace) this.nsList.get(i);
                if (str.equals(xmlNamespace.getNamespaceName())) {
                    return xmlNamespace;
                }
            }
        }
        XmlContainer xmlContainer = this.parent;
        if (xmlContainer == null || !(xmlContainer instanceof XmlElement)) {
            return null;
        }
        return ((XmlElement) xmlContainer).lookupNamespaceByName(str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator namespaces() {
        List list = this.nsList;
        if (list == null) {
            return EMPTY_ITERATOR;
        }
        return list.iterator();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace newNamespace(String str) {
        return newNamespace(null, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace newNamespace(String str, String str2) {
        return new XmlNamespaceImpl(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureNamespaceDeclarationsCapacity(int i) {
        List list = this.nsList;
        if (list == null) {
            this.nsList = new ArrayList(i);
        } else {
            ((ArrayList) list).ensureCapacity(i);
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllNamespaceDeclarations() {
        this.nsList = null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void addChild(Object obj) {
        obj.getClass();
        if (this.children == null) {
            ensureChildrenCapacity(1);
        }
        this.children.add(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void addChild(int i, Object obj) {
        if (this.children == null) {
            ensureChildrenCapacity(1);
        }
        this.children.add(i, obj);
    }

    private void checkChildParent(Object obj) {
        if (obj instanceof XmlContainer) {
            if (obj instanceof XmlElement) {
                XmlContainer parent = ((XmlElement) obj).getParent();
                if (parent != null && parent != this.parent) {
                    throw new XmlBuilderException("child must have no parent to be added to this node");
                }
                return;
            }
            if (obj instanceof XmlDocument) {
                throw new XmlBuilderException("docuemet can not be stored as element child");
            }
        }
    }

    private void setChildParent(Object obj) {
        if (obj instanceof XmlElement) {
            ((XmlElement) obj).setParent(this);
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(XmlElement xmlElement) {
        checkChildParent(xmlElement);
        addChild(xmlElement);
        setChildParent(xmlElement);
        return xmlElement;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(int i, XmlElement xmlElement) {
        checkChildParent(xmlElement);
        addChild(i, xmlElement);
        setChildParent(xmlElement);
        return xmlElement;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(XmlNamespace xmlNamespace, String str) {
        XmlElement xmlElementNewElement = newElement(xmlNamespace, str);
        addChild(xmlElementNewElement);
        setChildParent(xmlElementNewElement);
        return xmlElementNewElement;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(String str) {
        return addElement((XmlNamespace) null, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator children() {
        List list = this.children;
        if (list == null) {
            return EMPTY_ITERATOR;
        }
        return list.iterator();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterable requiredElementContent() {
        if (this.children == null) {
            return EMPTY_ITERABLE;
        }
        return new Iterable() { // from class: org.xmlpull.v1.builder.impl.XmlElementImpl.1
            @Override // org.xmlpull.v1.builder.Iterable
            public Iterator iterator() {
                return new RequiredElementContentIterator(XmlElementImpl.this.children.iterator());
            }
        };
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public String requiredTextContent() {
        List list = this.children;
        if (list == null || list.size() == 0) {
            return "";
        }
        if (this.children.size() == 1) {
            Object obj = this.children.get(0);
            if (obj instanceof String) {
                return obj.toString();
            }
            if (obj instanceof XmlCharacters) {
                return ((XmlCharacters) obj).getText();
            }
            throw new XmlBuilderException(new StringBuffer("expected text content and not ").append(obj != null ? obj.getClass() : null).append(" with '").append(obj).append("'").toString());
        }
        Iterator itChildren = children();
        StringBuffer stringBuffer = new StringBuffer();
        while (itChildren.hasNext()) {
            Object next = itChildren.next();
            if (next instanceof String) {
                stringBuffer.append(next.toString());
            } else if (next instanceof XmlCharacters) {
                stringBuffer.append(((XmlCharacters) next).getText());
            } else {
                throw new XmlBuilderException(new StringBuffer("expected text content and not ").append(next.getClass()).append(" with '").append(next).append("'").toString());
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureChildrenCapacity(int i) {
        List list = this.children;
        if (list == null) {
            this.children = new ArrayList(i);
        } else {
            ((ArrayList) list).ensureCapacity(i);
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement element(int i) {
        List list = this.children;
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (i < 0 || i >= size + 1) {
            throw new IndexOutOfBoundsException(new StringBuffer("position ").append(i).append(" bigger or equal to ").append(size).append(" children").toString());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = this.children.get(i3);
            if ((obj instanceof XmlElement) && (i2 = i2 + 1) == i) {
                return (XmlElement) obj;
            }
        }
        throw new IndexOutOfBoundsException(new StringBuffer("position ").append(i).append(" too big as only ").append(i2).append(" element(s) available").toString());
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement requiredElement(XmlNamespace xmlNamespace, String str) throws XmlBuilderException {
        XmlElement xmlElementElement = element(xmlNamespace, str);
        if (xmlElementElement == null) {
            throw new XmlBuilderException(new StringBuffer("could not find element with name ").append(str).append(" in namespace ").append(xmlNamespace != null ? xmlNamespace.getNamespaceName() : null).toString());
        }
        return xmlElementElement;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement element(XmlNamespace xmlNamespace, String str) {
        return element(xmlNamespace, str, false);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement element(XmlNamespace xmlNamespace, String str, boolean z) {
        XmlElement xmlElementFindElementByName = xmlNamespace != null ? findElementByName(xmlNamespace.getNamespaceName(), str) : findElementByName(str);
        if (xmlElementFindElementByName != null) {
            return xmlElementFindElementByName;
        }
        if (z) {
            return addElement(xmlNamespace, str);
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterable elements(final XmlNamespace xmlNamespace, final String str) {
        return new Iterable() { // from class: org.xmlpull.v1.builder.impl.XmlElementImpl.2
            @Override // org.xmlpull.v1.builder.Iterable
            public Iterator iterator() {
                XmlElementImpl xmlElementImpl = XmlElementImpl.this;
                return xmlElementImpl.new ElementsSimpleIterator(xmlNamespace, str, xmlElementImpl.children());
            }
        };
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str) {
        List list = this.children;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.children.get(i);
            if (obj instanceof XmlElement) {
                XmlElement xmlElement = (XmlElement) obj;
                if (str.equals(xmlElement.getName())) {
                    return xmlElement;
                }
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, String str2, XmlElement xmlElement) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, XmlElement xmlElement) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, String str2) {
        List list = this.children;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.children.get(i);
            if (obj instanceof XmlElement) {
                XmlElement xmlElement = (XmlElement) obj;
                XmlNamespace namespace = xmlElement.getNamespace();
                if (namespace != null) {
                    if (str2.equals(xmlElement.getName()) && str.equals(namespace.getNamespaceName())) {
                        return xmlElement;
                    }
                } else if (str2.equals(xmlElement.getName()) && str == null) {
                    return xmlElement;
                }
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasChild(Object obj) {
        if (this.children == null) {
            return false;
        }
        for (int i = 0; i < this.children.size(); i++) {
            if (this.children.get(i) == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasChildren() {
        List list = this.children;
        return list != null && list.size() > 0;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void insertChild(int i, Object obj) {
        if (this.children == null) {
            ensureChildrenCapacity(1);
        }
        this.children.add(i, obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(String str) {
        return newElement((XmlNamespace) null, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(String str, String str2) {
        return new XmlElementImpl(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(XmlNamespace xmlNamespace, String str) {
        return new XmlElementImpl(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void replaceChild(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException("new child to replace can not be null");
        }
        if (obj2 == null) {
            throw new IllegalArgumentException("old child to replace can not be null");
        }
        if (!hasChildren()) {
            throw new XmlBuilderException("no children available for replacement");
        }
        int iIndexOf = this.children.indexOf(obj2);
        if (iIndexOf == -1) {
            throw new XmlBuilderException("could not find child to replace");
        }
        this.children.set(iIndexOf, obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllChildren() {
        this.children = null;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeChild(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("child to remove can not be null");
        }
        if (!hasChildren()) {
            throw new XmlBuilderException("no children to remove");
        }
        int iIndexOf = this.children.indexOf(obj);
        if (iIndexOf != -1) {
            this.children.remove(iIndexOf);
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void replaceChildrenWithText(String str) {
        removeAllChildren();
        addChild(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isWhiteSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '\n' && str.charAt(i) != '\t' && str.charAt(i) != '\r') {
                return false;
            }
        }
        return true;
    }

    private class ElementsSimpleIterator implements Iterator {
        private Iterator children;
        private XmlElement currentEl;
        private XmlNamespace n;
        private String name;

        ElementsSimpleIterator(XmlNamespace xmlNamespace, String str, Iterator it) {
            this.children = it;
            this.n = xmlNamespace;
            this.name = str;
            findNextEl();
        }

        private void findNextEl() {
            this.currentEl = null;
            while (this.children.hasNext()) {
                Object next = this.children.next();
                if (next instanceof XmlElement) {
                    XmlElement xmlElement = (XmlElement) next;
                    if (this.name != null) {
                        String name = xmlElement.getName();
                        String str = this.name;
                        if (name == str || str.equals(xmlElement.getName())) {
                        }
                    }
                    if (this.n != null) {
                        XmlNamespace namespace = xmlElement.getNamespace();
                        XmlNamespace xmlNamespace = this.n;
                        if (namespace == xmlNamespace || xmlNamespace.equals(xmlElement.getNamespace())) {
                        }
                    }
                    this.currentEl = xmlElement;
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentEl != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            XmlElement xmlElement = this.currentEl;
            if (xmlElement == null) {
                throw new XmlBuilderException("this iterator has no content and next() is not allowed");
            }
            findNextEl();
            return xmlElement;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new XmlBuilderException("this element iterator does nto support remove()");
        }
    }

    private static class RequiredElementContentIterator implements Iterator {
        private Iterator children;
        private XmlElement currentEl;

        RequiredElementContentIterator(Iterator it) {
            this.children = it;
            findNextEl();
        }

        private void findNextEl() {
            this.currentEl = null;
            while (this.children.hasNext()) {
                Object next = this.children.next();
                if (next instanceof XmlElement) {
                    this.currentEl = (XmlElement) next;
                    return;
                }
                if (next instanceof String) {
                    if (!XmlElementImpl.isWhiteSpace(next.toString())) {
                        throw new XmlBuilderException("only whitespace string children allowed for non mixed element content");
                    }
                } else if (next instanceof XmlCharacters) {
                    XmlCharacters xmlCharacters = (XmlCharacters) next;
                    if (!Boolean.TRUE.equals(xmlCharacters.isWhitespaceContent()) || !XmlElementImpl.isWhiteSpace(xmlCharacters.getText())) {
                        throw new XmlBuilderException("only whitespace characters children allowed for non mixed element content");
                    }
                } else {
                    throw new XmlBuilderException(new StringBuffer("only whitespace characters and element children allowed for non mixed element content and not ").append(next.getClass()).toString());
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentEl != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            XmlElement xmlElement = this.currentEl;
            if (xmlElement == null) {
                throw new XmlBuilderException("this iterator has no content and next() is not allowed");
            }
            findNextEl();
            return xmlElement;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new XmlBuilderException("this iterator does nto support remove()");
        }
    }

    private static class EmptyIterator implements Iterator {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new XmlBuilderException("this iterator has no content and next() is not allowed");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new XmlBuilderException("this iterator has no content and remove() is not allowed");
        }
    }
}
