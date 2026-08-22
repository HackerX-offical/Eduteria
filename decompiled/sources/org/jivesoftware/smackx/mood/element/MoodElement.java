package org.jivesoftware.smackx.mood.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.mood.Mood;

/* JADX INFO: loaded from: classes10.dex */
public class MoodElement implements ExtensionElement {
    public static final String ELEM_TEXT = "text";
    public static final String NAMESPACE = "http://jabber.org/protocol/mood";
    private final MoodSubjectElement mood;
    private final String text;
    public static final String ELEMENT = "mood";
    public static final QName QNAME = new QName("http://jabber.org/protocol/mood", ELEMENT);

    public MoodElement(MoodSubjectElement moodSubjectElement, String str) {
        if (moodSubjectElement == null && str != null) {
            throw new IllegalArgumentException("If <mood/> is null, text MUST be null too.");
        }
        this.mood = moodSubjectElement;
        this.text = str;
    }

    public Mood getMood() {
        MoodSubjectElement moodSubjectElement = this.mood;
        if (moodSubjectElement != null) {
            return moodSubjectElement.getMood();
        }
        return null;
    }

    public String getText() {
        return this.text;
    }

    public boolean hasText() {
        return getText() != null;
    }

    public MoodConcretisation getMoodConcretisation() {
        MoodSubjectElement moodSubjectElement = this.mood;
        if (moodSubjectElement != null) {
            return moodSubjectElement.getConcretisation();
        }
        return null;
    }

    public boolean hasConcretisation() {
        return getMoodConcretisation() != null;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/mood";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        if (this.mood == null && this.text == null) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optAppend(this.mood);
        if (this.text != null) {
            xmlStringBuilder.openElement("text").append((CharSequence) this.text).closeElement("text");
        }
        return xmlStringBuilder.closeElement(getElementName());
    }

    public static MoodElement fromMessage(Message message) {
        return (MoodElement) message.getExtension(MoodElement.class);
    }

    public static boolean hasMoodElement(Message message) {
        return message.hasExtension(ELEMENT, "http://jabber.org/protocol/mood");
    }

    public static class MoodSubjectElement implements FullyQualifiedElement {
        private final MoodConcretisation concretisation;
        private final Mood mood;

        public MoodSubjectElement(Mood mood, MoodConcretisation moodConcretisation) {
            this.mood = (Mood) Objects.requireNonNull(mood);
            this.concretisation = moodConcretisation;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return this.mood.toString();
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            if (this.concretisation == null) {
                return xmlStringBuilder.closeEmptyElement();
            }
            xmlStringBuilder.rightAngleBracket().append(this.concretisation).closeElement(this);
            return xmlStringBuilder;
        }

        public Mood getMood() {
            return this.mood;
        }

        public MoodConcretisation getConcretisation() {
            return this.concretisation;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "http://jabber.org/protocol/mood";
        }
    }
}
