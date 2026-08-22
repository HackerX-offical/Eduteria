package org.jivesoftware.smack.packet;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class StreamError extends AbstractError implements Nonza {
    public static final String ELEMENT = "stream:error";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-streams";
    private final Condition condition;
    private final String conditionText;

    public StreamError(Condition condition, String str, Map<String, String> map, List<ExtensionElement> list) {
        super(map, list);
        str = StringUtils.isNullOrEmpty(str) ? null : str;
        if (str != null && AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition[condition.ordinal()] != 1) {
            throw new IllegalArgumentException("The given condition '" + condition + "' can not contain a conditionText");
        }
        this.condition = condition;
        this.conditionText = str;
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.packet.StreamError$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition;

        static {
            int[] iArr = new int[Condition.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition = iArr;
            try {
                iArr[Condition.see_other_host.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public String toString() {
        return toXML().toString();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement(ELEMENT);
        xmlStringBuilder.halfOpenElement(this.condition.toString()).xmlnsAttribute(NAMESPACE).closeEmptyElement();
        addDescriptiveTextsAndExtensions(xmlStringBuilder);
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }

    public enum Condition {
        bad_format,
        bad_namespace_prefix,
        conflict,
        connection_timeout,
        host_gone,
        host_unknown,
        improper_addressing,
        internal_server_error,
        invalid_from,
        invalid_namespace,
        invalid_xml,
        not_authorized,
        not_well_formed,
        policy_violation,
        remote_connection_failed,
        reset,
        resource_constraint,
        restricted_xml,
        see_other_host,
        system_shutdown,
        undefined_condition,
        unsupported_encoding,
        unsupported_feature,
        unsupported_stanza_type,
        unsupported_version;

        @Override // java.lang.Enum
        public String toString() {
            return name().replace('_', '-');
        }

        public static Condition fromString(String str) {
            if ("xml-not-well-formed".equals(str)) {
                str = "not-well-formed";
            }
            String strReplace = str.replace('-', '_');
            try {
                return valueOf(strReplace);
            } catch (Exception e2) {
                throw new IllegalStateException("Could not transform string '" + strReplace + "' to XMPPErrorCondition", e2);
            }
        }
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }
}
