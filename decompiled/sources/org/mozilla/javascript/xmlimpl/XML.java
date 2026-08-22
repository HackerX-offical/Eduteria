package org.mozilla.javascript.xmlimpl;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes10.dex */
class XML extends XMLObjectImpl {
    static final long serialVersionUID = -630969919086449092L;
    private XmlNode node;

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    final XML getXML() {
        return this;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i == 0;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    int length() {
        return 1;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    Object valueOf() {
        return this;
    }

    XML(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject, XmlNode xmlNode) {
        super(xMLLibImpl, scriptable, xMLObject);
        initialize(xmlNode);
    }

    void initialize(XmlNode xmlNode) {
        this.node = xmlNode;
        xmlNode.setXml(this);
    }

    void replaceWith(XML xml) {
        if (this.node.parent() != null) {
            this.node.replaceWith(xml.node);
        } else {
            initialize(xml.node);
        }
    }

    XML makeXmlFromString(XMLName xMLName, String str) {
        try {
            return newTextElementXML(this.node, xMLName.toQname(), str);
        } catch (Exception e2) {
            throw ScriptRuntime.typeError(e2.getMessage());
        }
    }

    XmlNode getAnnotation() {
        return this.node;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return i == 0 ? this : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        throw ScriptRuntime.typeError("Assignment to indexed XML is not allowed");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        if (isPrototype()) {
            return new Object[0];
        }
        return new Object[]{0};
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i == 0) {
            remove();
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean hasXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName).length() > 0;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    Object getXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName);
    }

    XmlNode.QName getNodeQname() {
        return this.node.getQname();
    }

    XML[] getChildren() {
        if (!isElement()) {
            return null;
        }
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.TRUE);
        int length = matchingChildren.length;
        XML[] xmlArr = new XML[length];
        for (int i = 0; i < length; i++) {
            xmlArr[i] = toXML(matchingChildren[i]);
        }
        return xmlArr;
    }

    XML[] getAttributes() {
        XmlNode[] attributes = this.node.getAttributes();
        int length = attributes.length;
        XML[] xmlArr = new XML[length];
        for (int i = 0; i < length; i++) {
            xmlArr[i] = toXML(attributes[i]);
        }
        return xmlArr;
    }

    XMLList getPropertyList(XMLName xMLName) {
        return xMLName.getMyValueOn(this);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    void deleteXMLProperty(XMLName xMLName) {
        XMLList propertyList = getPropertyList(xMLName);
        for (int i = 0; i < propertyList.length(); i++) {
            propertyList.item(i).node.deleteMe();
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    void putXMLProperty(XMLName xMLName, Object obj) {
        if (isPrototype()) {
            return;
        }
        xMLName.setMyValueOn(this, obj);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean hasOwnProperty(XMLName xMLName) {
        return isPrototype() ? findPrototypeId(xMLName.localName()) != 0 : getPropertyList(xMLName).length() > 0;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    protected Object jsConstructor(Context context, boolean z, Object[] objArr) {
        Object obj;
        if (objArr.length == 0 || (obj = objArr[0]) == null || obj == Undefined.instance) {
            objArr = new Object[]{""};
        }
        XML xmlEcmaToXml = ecmaToXml(objArr[0]);
        return z ? xmlEcmaToXml.copy() : xmlEcmaToXml;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Scriptable getExtraMethodSource(Context context) {
        if (hasSimpleContent()) {
            return ScriptRuntime.toObjectOrNull(context, toString());
        }
        return null;
    }

    void removeChild(int i) {
        this.node.removeChild(i);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    void normalize() {
        this.node.normalize();
    }

    private XML toXML(XmlNode xmlNode) {
        if (xmlNode.getXml() == null) {
            xmlNode.setXml(newXML(xmlNode));
        }
        return xmlNode.getXml();
    }

    void setAttribute(XMLName xMLName, Object obj) {
        if (!isElement()) {
            throw new IllegalStateException("Can only set attributes on elements.");
        }
        if (xMLName.uri() == null && xMLName.localName().equals("*")) {
            throw ScriptRuntime.typeError("@* assignment not supported.");
        }
        this.node.setAttribute(xMLName.toQname(), ScriptRuntime.toString(obj));
    }

    void remove() {
        this.node.deleteMe();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    void addMatches(XMLList xMLList, XMLName xMLName) {
        xMLName.addMatches(xMLList, this);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLList elements(XMLName xMLName) {
        XMLList xMLListNewXMLList = newXMLList();
        xMLListNewXMLList.setTargets(this, xMLName.toQname());
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i = 0; i < matchingChildren.length; i++) {
            if (xMLName.matches(toXML(matchingChildren[i]))) {
                xMLListNewXMLList.addToList(toXML(matchingChildren[i]));
            }
        }
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLList child(XMLName xMLName) {
        XMLList xMLListNewXMLList = newXMLList();
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i = 0; i < matchingChildren.length; i++) {
            if (xMLName.matchesElement(matchingChildren[i].getQname())) {
                xMLListNewXMLList.addToList(toXML(matchingChildren[i]));
            }
        }
        xMLListNewXMLList.setTargets(this, xMLName.toQname());
        return xMLListNewXMLList;
    }

    XML replace(XMLName xMLName, Object obj) {
        putXMLProperty(xMLName, obj);
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLList children() {
        XMLList xMLListNewXMLList = newXMLList();
        xMLListNewXMLList.setTargets(this, XMLName.formStar().toQname());
        for (XmlNode xmlNode : this.node.getMatchingChildren(XmlNode.Filter.TRUE)) {
            xMLListNewXMLList.addToList(toXML(xmlNode));
        }
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLList child(int i) {
        XMLList xMLListNewXMLList = newXMLList();
        xMLListNewXMLList.setTargets(this, null);
        if (i >= 0 && i < this.node.getChildCount()) {
            xMLListNewXMLList.addToList(getXmlChild(i));
        }
        return xMLListNewXMLList;
    }

    XML getXmlChild(int i) {
        XmlNode child = this.node.getChild(i);
        if (child.getXml() == null) {
            child.setXml(newXML(child));
        }
        return child.getXml();
    }

    XML getLastXmlChild() {
        int childCount = this.node.getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        return getXmlChild(childCount);
    }

    int childIndex() {
        return this.node.getChildIndex();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean contains(Object obj) {
        if (obj instanceof XML) {
            return equivalentXml(obj);
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean equivalentXml(Object obj) {
        if (obj instanceof XML) {
            return this.node.toXmlString(getProcessor()).equals(((XML) obj).node.toXmlString(getProcessor()));
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.length() == 1) {
                return equivalentXml(xMLList.getXML());
            }
            return false;
        }
        if (!hasSimpleContent()) {
            return false;
        }
        return toString().equals(ScriptRuntime.toString(obj));
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLObjectImpl copy() {
        return newXML(this.node.copy());
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean hasSimpleContent() {
        if (isComment() || isProcessingInstruction()) {
            return false;
        }
        if (isText() || this.node.isAttributeType()) {
            return true;
        }
        return !this.node.hasChildElement();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean hasComplexContent() {
        return !hasSimpleContent();
    }

    boolean is(XML xml) {
        return this.node.isSameNode(xml.node);
    }

    Object nodeKind() {
        return ecmaClass();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    Object parent() {
        if (this.node.parent() == null) {
            return null;
        }
        return newXML(this.node.parent());
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean propertyIsEnumerable(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            return dDoubleValue == 0.0d && 1.0d / dDoubleValue > 0.0d;
        }
        return ScriptRuntime.toString(obj).equals("0");
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLList comments() {
        XMLList xMLListNewXMLList = newXMLList();
        this.node.addMatchingChildren(xMLListNewXMLList, XmlNode.Filter.COMMENT);
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLList text() {
        XMLList xMLListNewXMLList = newXMLList();
        this.node.addMatchingChildren(xMLListNewXMLList, XmlNode.Filter.TEXT);
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    XMLList processingInstructions(XMLName xMLName) {
        XMLList xMLListNewXMLList = newXMLList();
        this.node.addMatchingChildren(xMLListNewXMLList, XmlNode.Filter.PROCESSING_INSTRUCTION(xMLName));
        return xMLListNewXMLList;
    }

    private XmlNode[] getNodesForInsert(Object obj) {
        if (obj instanceof XML) {
            return new XmlNode[]{((XML) obj).node};
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            XmlNode[] xmlNodeArr = new XmlNode[xMLList.length()];
            for (int i = 0; i < xMLList.length(); i++) {
                xmlNodeArr[i] = xMLList.item(i).node;
            }
            return xmlNodeArr;
        }
        return new XmlNode[]{XmlNode.createText(getProcessor(), ScriptRuntime.toString(obj))};
    }

    XML replace(int i, Object obj) {
        XMLList xMLListChild = child(i);
        if (xMLListChild.length() > 0) {
            insertChildAfter(xMLListChild.item(0), obj);
            removeChild(i);
        }
        return this;
    }

    XML prependChild(Object obj) {
        if (this.node.isParentType()) {
            this.node.insertChildrenAt(0, getNodesForInsert(obj));
        }
        return this;
    }

    XML appendChild(Object obj) {
        if (this.node.isParentType()) {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            XmlNode xmlNode = this.node;
            xmlNode.insertChildrenAt(xmlNode.getChildCount(), nodesForInsert);
        }
        return this;
    }

    private int getChildIndexOf(XML xml) {
        for (int i = 0; i < this.node.getChildCount(); i++) {
            if (this.node.getChild(i).isSameNode(xml.node)) {
                return i;
            }
        }
        return -1;
    }

    XML insertChildBefore(XML xml, Object obj) {
        if (xml == null) {
            appendChild(obj);
            return this;
        }
        XmlNode[] nodesForInsert = getNodesForInsert(obj);
        int childIndexOf = getChildIndexOf(xml);
        if (childIndexOf != -1) {
            this.node.insertChildrenAt(childIndexOf, nodesForInsert);
        }
        return this;
    }

    XML insertChildAfter(XML xml, Object obj) {
        if (xml == null) {
            prependChild(obj);
            return this;
        }
        XmlNode[] nodesForInsert = getNodesForInsert(obj);
        int childIndexOf = getChildIndexOf(xml);
        if (childIndexOf != -1) {
            this.node.insertChildrenAt(childIndexOf + 1, nodesForInsert);
        }
        return this;
    }

    XML setChildren(Object obj) {
        if (!isElement()) {
            return this;
        }
        while (this.node.getChildCount() > 0) {
            this.node.removeChild(0);
        }
        this.node.insertChildrenAt(0, getNodesForInsert(obj));
        return this;
    }

    private void addInScopeNamespace(Namespace namespace) {
        if (isElement() && namespace.prefix() != null) {
            if (namespace.prefix().length() == 0 && namespace.uri().length() == 0) {
                return;
            }
            if (this.node.getQname().getNamespace().getPrefix().equals(namespace.prefix())) {
                this.node.invalidateNamespacePrefix();
            }
            this.node.declareNamespace(namespace.prefix(), namespace.uri());
        }
    }

    Namespace[] inScopeNamespaces() {
        return createNamespaces(this.node.getInScopeNamespaces());
    }

    private XmlNode.Namespace adapt(Namespace namespace) {
        if (namespace.prefix() == null) {
            return XmlNode.Namespace.create(namespace.uri());
        }
        return XmlNode.Namespace.create(namespace.prefix(), namespace.uri());
    }

    XML removeNamespace(Namespace namespace) {
        if (!isElement()) {
            return this;
        }
        this.node.removeNamespace(adapt(namespace));
        return this;
    }

    XML addNamespace(Namespace namespace) {
        addInScopeNamespace(namespace);
        return this;
    }

    QName name() {
        if (isText() || isComment()) {
            return null;
        }
        return isProcessingInstruction() ? newQName("", this.node.getQname().getLocalName(), null) : newQName(this.node.getQname());
    }

    Namespace[] namespaceDeclarations() {
        return createNamespaces(this.node.getNamespaceDeclarations());
    }

    Namespace namespace(String str) {
        if (str == null) {
            return createNamespace(this.node.getNamespaceDeclaration());
        }
        return createNamespace(this.node.getNamespaceDeclaration(str));
    }

    String localName() {
        if (name() == null) {
            return null;
        }
        return name().localName();
    }

    void setLocalName(String str) {
        if (isText() || isComment()) {
            return;
        }
        this.node.setLocalName(str);
    }

    void setName(QName qName) {
        if (isText() || isComment()) {
            return;
        }
        if (isProcessingInstruction()) {
            this.node.setLocalName(qName.localName());
        } else {
            this.node.renameNode(qName.getDelegate());
        }
    }

    void setNamespace(Namespace namespace) {
        if (isText() || isComment() || isProcessingInstruction()) {
            return;
        }
        setName(newQName(namespace.uri(), localName(), namespace.prefix()));
    }

    final String ecmaClass() {
        if (this.node.isTextType()) {
            return "text";
        }
        if (this.node.isAttributeType()) {
            return "attribute";
        }
        if (this.node.isCommentType()) {
            return "comment";
        }
        if (this.node.isProcessingInstructionType()) {
            return "processing-instruction";
        }
        if (this.node.isElementType()) {
            return "element";
        }
        throw new RuntimeException("Unrecognized type: " + this.node);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "XML";
    }

    private String ecmaValue() {
        return this.node.ecmaValue();
    }

    private String ecmaToString() {
        if (isAttribute() || isText()) {
            return ecmaValue();
        }
        if (hasSimpleContent()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.node.getChildCount(); i++) {
                XmlNode child = this.node.getChild(i);
                if (!child.isProcessingInstructionType() && !child.isCommentType()) {
                    sb.append(new XML(getLib(), getParentScope(), (XMLObject) getPrototype(), child).toString());
                }
            }
            return sb.toString();
        }
        return toXMLString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toString() {
        return ecmaToString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    String toSource(int i) {
        return toXMLString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    String toXMLString() {
        return this.node.ecmaToXMLString(getProcessor());
    }

    final boolean isAttribute() {
        return this.node.isAttributeType();
    }

    final boolean isComment() {
        return this.node.isCommentType();
    }

    final boolean isText() {
        return this.node.isTextType();
    }

    final boolean isElement() {
        return this.node.isElementType();
    }

    final boolean isProcessingInstruction() {
        return this.node.isProcessingInstructionType();
    }

    Node toDomNode() {
        return this.node.toDomNode();
    }
}
