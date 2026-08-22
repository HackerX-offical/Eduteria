package org.jivesoftware.smackx.message_markup.element;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;

/* JADX INFO: loaded from: classes10.dex */
public class ListElement extends MarkupElement.NonEmptyChildElement {
    public static final String ELEMENT = "list";
    public static final String ELEM_LI = "li";
    private final List<ListEntryElement> entries;

    public ListElement(int i, int i2, List<ListEntryElement> list) {
        super(i, i2);
        this.entries = Collections.unmodifiableList(list);
    }

    public List<ListEntryElement> getEntries() {
        return this.entries;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "list";
    }

    @Override // org.jivesoftware.smackx.message_markup.element.MarkupElement.NonEmptyChildElement
    public void appendInnerXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.append(getEntries());
    }

    public static class ListEntryElement implements ExtensionElement {
        private final int start;

        public ListEntryElement(int i) {
            this.start = i;
        }

        public int getStart() {
            return this.start;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "li";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return MarkupElement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("start", getStart());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }
}
