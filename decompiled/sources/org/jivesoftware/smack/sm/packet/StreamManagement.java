package org.jivesoftware.smack.sm.packet;

import com.clevertap.android.sdk.Constants;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StanzaErrorTextElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class StreamManagement {
    public static final String NAMESPACE = "urn:xmpp:sm:3";

    public static final class StreamManagementFeature implements ExtensionElement {
        public static final String ELEMENT = "sm";
        public static final StreamManagementFeature INSTANCE = new StreamManagementFeature();

        private StreamManagementFeature() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    private static abstract class AbstractEnable implements Nonza {
        protected int max;
        protected boolean resume;

        private AbstractEnable() {
            this.max = -1;
            this.resume = false;
        }

        protected void maybeAddResumeAttributeTo(XmlStringBuilder xmlStringBuilder) {
            if (this.resume) {
                xmlStringBuilder.attribute("resume", "true");
            }
        }

        protected void maybeAddMaxAttributeTo(XmlStringBuilder xmlStringBuilder) {
            int i = this.max;
            if (i > 0) {
                xmlStringBuilder.attribute(Constants.PRIORITY_MAX, Integer.toString(i));
            }
        }

        public boolean isResumeSet() {
            return this.resume;
        }

        public int getMaxResumptionTime() {
            return this.max;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public final String getNamespace() {
            return StreamManagement.NAMESPACE;
        }
    }

    public static class Enable extends AbstractEnable {
        public static final String ELEMENT = "enable";
        public static final Enable INSTANCE = new Enable();

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ int getMaxResumptionTime() {
            return super.getMaxResumptionTime();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ boolean isResumeSet() {
            return super.isResumeSet();
        }

        private Enable() {
            super();
        }

        public Enable(boolean z) {
            super();
            this.resume = z;
        }

        public Enable(boolean z, int i) {
            this(z);
            this.max = i;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            maybeAddResumeAttributeTo(xmlStringBuilder);
            maybeAddMaxAttributeTo(xmlStringBuilder);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "enable";
        }
    }

    public static class Enabled extends AbstractEnable {
        public static final String ELEMENT = "enabled";
        private final String id;
        private final String location;

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ int getMaxResumptionTime() {
            return super.getMaxResumptionTime();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ boolean isResumeSet() {
            return super.isResumeSet();
        }

        public Enabled(String str, boolean z) {
            this(str, z, null, -1);
        }

        public Enabled(String str, boolean z, String str2, int i) {
            super();
            this.id = str;
            this.resume = z;
            this.location = str2;
            this.max = i;
        }

        public String getId() {
            return this.id;
        }

        public String getLocation() {
            return this.location;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute("id", this.id);
            maybeAddResumeAttributeTo(xmlStringBuilder);
            xmlStringBuilder.optAttribute("location", this.location);
            maybeAddMaxAttributeTo(xmlStringBuilder);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Failed implements Nonza {
        public static final String ELEMENT = "failed";
        private final StanzaError.Condition condition;
        private final List<StanzaErrorTextElement> textElements;

        public Failed() {
            this(null, null);
        }

        public Failed(StanzaError.Condition condition, List<StanzaErrorTextElement> list) {
            this.condition = condition;
            if (list == null) {
                this.textElements = Collections.emptyList();
            } else {
                this.textElements = Collections.unmodifiableList(list);
            }
        }

        public StanzaError.Condition getStanzaErrorCondition() {
            return this.condition;
        }

        public List<StanzaErrorTextElement> getTextElements() {
            return this.textElements;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            if (this.condition == null && this.textElements.isEmpty()) {
                xmlStringBuilder.closeEmptyElement();
                return xmlStringBuilder;
            }
            if (this.condition != null) {
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.append((CharSequence) this.condition.toString());
                xmlStringBuilder.xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-stanzas");
                xmlStringBuilder.closeEmptyElement();
            }
            xmlStringBuilder.append(this.textElements);
            xmlStringBuilder.closeElement(ELEMENT);
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    private static abstract class AbstractResume implements Nonza {
        private final long handledCount;
        private final String previd;

        private AbstractResume(long j, String str) {
            this.handledCount = j;
            this.previd = str;
        }

        public long getHandledCount() {
            return this.handledCount;
        }

        public String getPrevId() {
            return this.previd;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public final String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("h", Long.toString(this.handledCount));
            xmlStringBuilder.attribute("previd", this.previd);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class Resume extends AbstractResume {
        public static final String ELEMENT = "resume";

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ long getHandledCount() {
            return super.getHandledCount();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ String getPrevId() {
            return super.getPrevId();
        }

        public Resume(long j, String str) {
            super(j, str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "resume";
        }
    }

    public static class Resumed extends AbstractResume {
        public static final String ELEMENT = "resumed";

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ long getHandledCount() {
            return super.getHandledCount();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ String getPrevId() {
            return super.getPrevId();
        }

        public Resumed(long j, String str) {
            super(j, str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class AckAnswer implements Nonza {
        public static final String ELEMENT = "a";
        private final long handledCount;

        public AckAnswer(long j) {
            this.handledCount = j;
        }

        public long getHandledCount() {
            return this.handledCount;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("h", Long.toString(this.handledCount));
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "a";
        }
    }

    public static final class AckRequest implements Nonza {
        public static final String ELEMENT = "r";
        public static final AckRequest INSTANCE = new AckRequest();

        private AckRequest() {
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return "<r xmlns='urn:xmpp:sm:3'/>";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }
}
