package org.jivesoftware.smackx.xdatalayout.packet;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class DataLayout implements ExtensionElement {
    public static final String ELEMENT = "page";
    public static final String NAMESPACE = "http://jabber.org/protocol/xdata-layout";
    private final String label;
    private final List<DataFormLayoutElement> pageLayout = new ArrayList();

    public DataLayout(String str) {
        this.label = str;
    }

    public List<DataFormLayoutElement> getPageLayout() {
        return this.pageLayout;
    }

    public String getLabel() {
        return this.label;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "page";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute("label", getLabel());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(getPageLayout());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static class Fieldref extends DataFormLayoutElement {
        public static final String ELEMENT = "fieldref";
        private final String var;

        public Fieldref(String str) {
            this.var = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("var", getVar());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public String getVar() {
            return this.var;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Section extends DataFormLayoutElement {
        public static final String ELEMENT = "section";
        private final String label;
        private final List<DataFormLayoutElement> sectionLayout = new ArrayList();

        public Section(String str) {
            this.label = str;
        }

        public List<DataFormLayoutElement> getSectionLayout() {
            return this.sectionLayout;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute("label", getLabel());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append(getSectionLayout());
            xmlStringBuilder.closeElement(ELEMENT);
            return xmlStringBuilder;
        }

        public String getLabel() {
            return this.label;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Reportedref extends DataFormLayoutElement {
        public static final String ELEMENT = "reportedref";

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Text extends DataFormLayoutElement {
        public static final String ELEMENT = "text";
        private final String text;

        public Text(String str) {
            this.text = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(getText());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public String getText() {
            return this.text;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "text";
        }
    }

    public static abstract class DataFormLayoutElement implements ExtensionElement {
        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public final String getNamespace() {
            return DataLayout.NAMESPACE;
        }
    }
}
