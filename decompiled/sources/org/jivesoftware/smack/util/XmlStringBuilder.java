package org.jivesoftware.smack.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class XmlStringBuilder implements Appendable, CharSequence, Element {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String RIGHT_ANGLE_BRACKET = Character.toString(Typography.greater);
    private final XmlEnvironment effectiveXmlEnvironment;
    private final LazyStringBuilder sb;

    public XmlStringBuilder() {
        this.sb = new LazyStringBuilder();
        this.effectiveXmlEnvironment = null;
    }

    public XmlStringBuilder(ExtensionElement extensionElement) {
        this(extensionElement, null);
    }

    public XmlStringBuilder(NamedElement namedElement) {
        this();
        halfOpenElement(namedElement.getElementName());
    }

    public XmlStringBuilder(FullyQualifiedElement fullyQualifiedElement, XmlEnvironment xmlEnvironment) {
        this(fullyQualifiedElement.getElementName(), fullyQualifiedElement.getNamespace(), fullyQualifiedElement.getLanguage(), xmlEnvironment);
    }

    public XmlStringBuilder(String str, String str2, String str3, XmlEnvironment xmlEnvironment) {
        this.sb = new LazyStringBuilder();
        halfOpenElement(str);
        if (xmlEnvironment == null) {
            xmlnsAttribute(str2);
            xmllangAttribute(str3);
        } else {
            if (!xmlEnvironment.effectiveNamespaceEquals(str2)) {
                xmlnsAttribute(str2);
            }
            if (!xmlEnvironment.effectiveLanguageEquals(str3)) {
                xmllangAttribute(str3);
            }
        }
        this.effectiveXmlEnvironment = XmlEnvironment.builder().withNamespace(str2).withLanguage(str3).withNext(xmlEnvironment).build();
    }

    public XmlEnvironment getXmlEnvironment() {
        return this.effectiveXmlEnvironment;
    }

    public XmlStringBuilder escapedElement(String str, String str2) {
        openElement(str);
        append((CharSequence) str2);
        closeElement(str);
        return this;
    }

    public XmlStringBuilder element(String str, String str2) {
        if (str2.isEmpty()) {
            return emptyElement(str);
        }
        openElement(str);
        escape(str2);
        closeElement(str);
        return this;
    }

    public XmlStringBuilder element(String str, Date date) {
        return element(str, XmppDateTime.formatXEP0082Date(date));
    }

    public XmlStringBuilder element(String str, CharSequence charSequence) {
        return element(str, charSequence.toString());
    }

    public XmlStringBuilder element(String str, Enum<?> r2) {
        element(str, r2.toString());
        return this;
    }

    @Deprecated
    public XmlStringBuilder element(Element element) {
        return append(element.toXML());
    }

    public XmlStringBuilder optElement(String str, String str2) {
        if (str2 != null) {
            element(str, str2);
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, Date date) {
        if (date != null) {
            element(str, date);
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, CharSequence charSequence) {
        if (charSequence != null) {
            element(str, charSequence.toString());
        }
        return this;
    }

    public XmlStringBuilder optElement(Element element) {
        if (element != null) {
            append(element);
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, Enum<?> r2) {
        if (r2 != null) {
            element(str, r2);
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, Object obj) {
        if (obj != null) {
            element(str, obj.toString());
        }
        return this;
    }

    public XmlStringBuilder optIntElement(String str, int i) {
        if (i >= 0) {
            element(str, String.valueOf(i));
        }
        return this;
    }

    public XmlStringBuilder halfOpenElement(String str) {
        this.sb.append(Typography.less).append((CharSequence) str);
        return this;
    }

    public XmlStringBuilder halfOpenElement(NamedElement namedElement) {
        return halfOpenElement(namedElement.getElementName());
    }

    public XmlStringBuilder openElement(String str) {
        halfOpenElement(str).rightAngleBracket();
        return this;
    }

    public XmlStringBuilder closeElement(String str) {
        this.sb.append((CharSequence) "</").append((CharSequence) str);
        rightAngleBracket();
        return this;
    }

    public XmlStringBuilder closeElement(NamedElement namedElement) {
        closeElement(namedElement.getElementName());
        return this;
    }

    public XmlStringBuilder closeEmptyElement() {
        this.sb.append((CharSequence) "/>");
        return this;
    }

    public XmlStringBuilder rightAngleBracket() {
        this.sb.append((CharSequence) RIGHT_ANGLE_BRACKET);
        return this;
    }

    public XmlStringBuilder attribute(String str, String str2) {
        this.sb.append(' ').append((CharSequence) str).append((CharSequence) "='");
        escapeAttributeValue(str2);
        this.sb.append('\'');
        return this;
    }

    public XmlStringBuilder attribute(String str, boolean z) {
        return attribute(str, Boolean.toString(z));
    }

    public XmlStringBuilder attribute(String str, Date date) {
        return attribute(str, XmppDateTime.formatXEP0082Date(date));
    }

    public XmlStringBuilder attribute(String str, CharSequence charSequence) {
        return attribute(str, charSequence.toString());
    }

    public XmlStringBuilder attribute(String str, Enum<?> r2) {
        attribute(str, r2.name());
        return this;
    }

    public <E extends Enum<?>> XmlStringBuilder attribute(String str, E e2, E e3) {
        if (e2 != null && e2 != e3) {
            attribute(str, e2.toString());
        }
        return this;
    }

    public XmlStringBuilder attribute(String str, int i) {
        return attribute(str, String.valueOf(i));
    }

    public XmlStringBuilder attribute(String str, long j) {
        return attribute(str, String.valueOf(j));
    }

    public XmlStringBuilder optAttribute(String str, String str2) {
        if (str2 != null) {
            attribute(str, str2);
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, Long l) {
        if (l != null) {
            attribute(str, l.longValue());
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, Date date) {
        if (date != null) {
            attribute(str, date);
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, CharSequence charSequence) {
        if (charSequence != null) {
            attribute(str, charSequence.toString());
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, Enum<?> r2) {
        if (r2 != null) {
            attribute(str, r2.toString());
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, Number number) {
        if (number != null) {
            attribute(str, number.toString());
        }
        return this;
    }

    public XmlStringBuilder optAttributeCs(String str, CharSequence charSequence) {
        return optAttribute(str, charSequence);
    }

    public XmlStringBuilder optIntAttribute(String str, int i) {
        if (i >= 0) {
            attribute(str, Integer.toString(i));
        }
        return this;
    }

    public XmlStringBuilder optIntAttribute(String str, Integer num) {
        if (num != null) {
            attribute(str, num.toString());
        }
        return this;
    }

    public XmlStringBuilder optLongAttribute(String str, Long l) {
        if (l != null && l.longValue() >= 0) {
            attribute(str, Long.toString(l.longValue()));
        }
        return this;
    }

    public XmlStringBuilder optBooleanAttribute(String str, boolean z) {
        if (z) {
            this.sb.append(' ').append((CharSequence) str).append((CharSequence) "='true'");
        }
        return this;
    }

    public XmlStringBuilder optBooleanAttributeDefaultTrue(String str, boolean z) {
        if (!z) {
            this.sb.append(' ').append((CharSequence) str).append((CharSequence) "='false'");
        }
        return this;
    }

    private static final class XmlNsAttribute implements CharSequence {
        private final String value;
        private final String xmlFragment;

        private XmlNsAttribute(String str) {
            this.value = (String) StringUtils.requireNotNullNorEmpty(str, "Value must not be null");
            this.xmlFragment = " xmlns='" + str + '\'';
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return this.xmlFragment;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.xmlFragment.length();
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.xmlFragment.charAt(i);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.xmlFragment.subSequence(i, i2);
        }
    }

    public XmlStringBuilder xmlnsAttribute(String str) {
        XmlEnvironment xmlEnvironment;
        if (str != null && ((xmlEnvironment = this.effectiveXmlEnvironment) == null || !xmlEnvironment.effectiveNamespaceEquals(str))) {
            append((CharSequence) new XmlNsAttribute(str));
        }
        return this;
    }

    public XmlStringBuilder xmllangAttribute(String str) {
        optAttribute("xml:lang", str);
        return this;
    }

    public XmlStringBuilder optXmlLangAttribute(String str) {
        if (!StringUtils.isNullOrEmpty(str)) {
            xmllangAttribute(str);
        }
        return this;
    }

    public XmlStringBuilder text(CharSequence charSequence) {
        this.sb.append(StringUtils.escapeForXmlText(charSequence));
        return this;
    }

    public XmlStringBuilder escape(String str) {
        this.sb.append(StringUtils.escapeForXml(str));
        return this;
    }

    public XmlStringBuilder escapeAttributeValue(String str) {
        this.sb.append(StringUtils.escapeForXmlAttributeApos(str));
        return this;
    }

    public XmlStringBuilder optEscape(CharSequence charSequence) {
        return charSequence == null ? this : escape(charSequence);
    }

    public XmlStringBuilder escape(CharSequence charSequence) {
        return escape(charSequence.toString());
    }

    protected XmlStringBuilder prelude(FullyQualifiedElement fullyQualifiedElement) {
        return prelude(fullyQualifiedElement.getElementName(), fullyQualifiedElement.getNamespace());
    }

    protected XmlStringBuilder prelude(String str, String str2) {
        halfOpenElement(str);
        xmlnsAttribute(str2);
        return this;
    }

    public XmlStringBuilder optAppend(Element element) {
        if (element != null) {
            append(element.toXML(this.effectiveXmlEnvironment));
        }
        return this;
    }

    public XmlStringBuilder optAppend(Collection<? extends Element> collection) {
        if (collection != null) {
            append(collection);
        }
        return this;
    }

    public XmlStringBuilder optTextChild(CharSequence charSequence, NamedElement namedElement) {
        if (charSequence == null) {
            return closeEmptyElement();
        }
        rightAngleBracket();
        escape(charSequence);
        closeElement(namedElement);
        return this;
    }

    public XmlStringBuilder append(XmlStringBuilder xmlStringBuilder) {
        this.sb.append(xmlStringBuilder.sb);
        return this;
    }

    public XmlStringBuilder append(Element element) {
        return append(element.toXML(this.effectiveXmlEnvironment));
    }

    public XmlStringBuilder append(Collection<? extends Element> collection) {
        Iterator<? extends Element> it = collection.iterator();
        while (it.hasNext()) {
            append(it.next());
        }
        return this;
    }

    public XmlStringBuilder emptyElement(Enum<?> r1) {
        return emptyElement(r1.toString());
    }

    public XmlStringBuilder emptyElement(String str) {
        halfOpenElement(str);
        return closeEmptyElement();
    }

    public XmlStringBuilder condEmptyElement(boolean z, String str) {
        if (z) {
            emptyElement(str);
        }
        return this;
    }

    public XmlStringBuilder condAttribute(boolean z, String str, String str2) {
        if (z) {
            attribute(str, str2);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public XmlStringBuilder append(CharSequence charSequence) {
        this.sb.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public XmlStringBuilder append(CharSequence charSequence, int i, int i2) {
        this.sb.append(charSequence, i, i2);
        return this;
    }

    @Override // java.lang.Appendable
    public XmlStringBuilder append(char c2) {
        this.sb.append(c2);
        return this;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.sb.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.sb.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.sb.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharSequence) {
            return toString().equals(((CharSequence) obj).toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class WrappedIoException extends RuntimeException {
        private static final long serialVersionUID = 1;
        private final IOException wrappedIoException;

        private WrappedIoException(IOException iOException) {
            this.wrappedIoException = iOException;
        }
    }

    public void write(final Writer writer, XmlEnvironment xmlEnvironment) throws IOException {
        try {
            appendXmlTo(new Consumer() { // from class: org.jivesoftware.smack.util.XmlStringBuilder$$ExternalSyntheticLambda1
                @Override // org.jivesoftware.smack.util.Consumer
                public final void accept(Object obj) {
                    XmlStringBuilder.lambda$write$0(writer, (CharSequence) obj);
                }
            }, xmlEnvironment);
        } catch (WrappedIoException e2) {
            throw e2.wrappedIoException;
        }
    }

    static /* synthetic */ void lambda$write$0(Writer writer, CharSequence charSequence) {
        try {
            writer.append(charSequence);
        } catch (IOException e2) {
            throw new WrappedIoException(e2);
        }
    }

    public List<CharSequence> toList(XmlEnvironment xmlEnvironment) {
        final ArrayList arrayList = new ArrayList(this.sb.getAsList().size());
        appendXmlTo(new Consumer() { // from class: org.jivesoftware.smack.util.XmlStringBuilder$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                arrayList.add((CharSequence) obj);
            }
        }, xmlEnvironment);
        return arrayList;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public StringBuilder toXML(XmlEnvironment xmlEnvironment) {
        final StringBuilder sb = new StringBuilder(length());
        appendXmlTo(new Consumer() { // from class: org.jivesoftware.smack.util.XmlStringBuilder$$ExternalSyntheticLambda2
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                sb.append((CharSequence) obj);
            }
        }, xmlEnvironment);
        return sb;
    }

    private void appendXmlTo(Consumer<CharSequence> consumer, XmlEnvironment xmlEnvironment) {
        for (CharSequence charSequence : this.sb.getAsList()) {
            if (charSequence instanceof XmlStringBuilder) {
                ((XmlStringBuilder) charSequence).appendXmlTo(consumer, xmlEnvironment);
            } else if (charSequence instanceof XmlNsAttribute) {
                XmlNsAttribute xmlNsAttribute = (XmlNsAttribute) charSequence;
                if (!xmlNsAttribute.value.equals(xmlEnvironment.getEffectiveNamespace())) {
                    consumer.accept(xmlNsAttribute);
                    xmlEnvironment = new XmlEnvironment(xmlNsAttribute.value);
                }
            } else {
                consumer.accept(charSequence);
            }
        }
    }
}
