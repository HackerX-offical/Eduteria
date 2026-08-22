package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractTextElement implements ExtensionElement {
    public static final String ELEMENT = "text";
    private final String lang;
    private final String text;

    protected AbstractTextElement(String str, String str2) {
        this.text = (String) StringUtils.requireNotNullNorEmpty(str, "Text must not be null nor empty");
        this.lang = str2;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "text";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.escape(this.text);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public final String getText() {
        return this.text;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement, org.jivesoftware.smack.packet.XmlLangElement
    public final String getLanguage() {
        return this.lang;
    }

    @Deprecated
    public final String getLang() {
        return this.lang;
    }
}
