package org.jivesoftware.smackx.jingle.element;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleContentTransport implements ExtensionElement {
    public static final String ELEMENT = "transport";
    protected final List<JingleContentTransportCandidate> candidates;

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    protected final JingleContentTransportInfo f1499info;

    protected void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
    }

    protected JingleContentTransport(List<JingleContentTransportCandidate> list) {
        this(list, null);
    }

    protected JingleContentTransport(List<JingleContentTransportCandidate> list, JingleContentTransportInfo jingleContentTransportInfo) {
        if (list != null) {
            this.candidates = Collections.unmodifiableList(list);
        } else {
            this.candidates = Collections.emptyList();
        }
        this.f1499info = jingleContentTransportInfo;
    }

    public List<JingleContentTransportCandidate> getCandidates() {
        return this.candidates;
    }

    public JingleContentTransportInfo getInfo() {
        return this.f1499info;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "transport";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addExtraAttributes(xmlStringBuilder);
        if (this.candidates.isEmpty() && this.f1499info == null) {
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.candidates);
        xmlStringBuilder.optElement(this.f1499info);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
