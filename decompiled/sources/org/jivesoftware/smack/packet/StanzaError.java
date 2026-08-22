package org.jivesoftware.smack.packet;

import com.appnew.android.Utils.Const;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.AbstractError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;

/* JADX INFO: loaded from: classes10.dex */
public class StanzaError extends AbstractError implements ExtensionElement {
    static final Map<Condition, Type> CONDITION_TO_TYPE;
    public static final String ERROR = "error";
    public static final String ERROR_CONDITION_AND_TEXT_NAMESPACE = "urn:ietf:params:xml:ns:xmpp-stanzas";

    @Deprecated
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-stanzas";
    private final Condition condition;
    private final String conditionText;
    private final String errorGenerator;
    private final Type type;
    public static final QName QNAME = new QName("jabber:client", "error");
    private static final Logger LOGGER = Logger.getLogger(StanzaError.class.getName());

    static {
        HashMap map = new HashMap();
        CONDITION_TO_TYPE = map;
        map.put(Condition.bad_request, Type.MODIFY);
        map.put(Condition.conflict, Type.CANCEL);
        map.put(Condition.feature_not_implemented, Type.CANCEL);
        map.put(Condition.forbidden, Type.AUTH);
        map.put(Condition.gone, Type.CANCEL);
        map.put(Condition.internal_server_error, Type.CANCEL);
        map.put(Condition.item_not_found, Type.CANCEL);
        map.put(Condition.jid_malformed, Type.MODIFY);
        map.put(Condition.not_acceptable, Type.MODIFY);
        map.put(Condition.not_allowed, Type.CANCEL);
        map.put(Condition.not_authorized, Type.AUTH);
        map.put(Condition.policy_violation, Type.MODIFY);
        map.put(Condition.recipient_unavailable, Type.WAIT);
        map.put(Condition.redirect, Type.MODIFY);
        map.put(Condition.registration_required, Type.AUTH);
        map.put(Condition.remote_server_not_found, Type.CANCEL);
        map.put(Condition.remote_server_timeout, Type.WAIT);
        map.put(Condition.resource_constraint, Type.WAIT);
        map.put(Condition.service_unavailable, Type.CANCEL);
        map.put(Condition.subscription_required, Type.AUTH);
        map.put(Condition.undefined_condition, Type.MODIFY);
        map.put(Condition.unexpected_request, Type.WAIT);
    }

    public StanzaError(Condition condition, String str, String str2, Type type, Map<String, String> map, List<ExtensionElement> list) {
        int i;
        super(map, "urn:ietf:params:xml:ns:xmpp-stanzas", list);
        this.condition = (Condition) Objects.requireNonNull(condition, "condition must not be null");
        str = StringUtils.isNullOrEmpty(str) ? null : str;
        if (str != null && (i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition[condition.ordinal()]) != 1 && i != 2) {
            throw new IllegalArgumentException("Condition text can only be set with condtion types 'gone' and 'redirect', not " + condition);
        }
        this.conditionText = str;
        this.errorGenerator = str2;
        if (type == null) {
            Type type2 = CONDITION_TO_TYPE.get(condition);
            if (type2 == null) {
                LOGGER.warning("Could not determine type for condition: " + condition);
                type2 = Type.CANCEL;
            }
            this.type = type2;
            return;
        }
        this.type = type;
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.packet.StanzaError$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition;

        static {
            int[] iArr = new int[Condition.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition = iArr;
            try {
                iArr[Condition.gone.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition[Condition.redirect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Condition getCondition() {
        return this.condition;
    }

    public Type getType() {
        return this.type;
    }

    public String getErrorGenerator() {
        return this.errorGenerator;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XMPPError: ");
        sb.append(this.condition.toString()).append(" - ").append(this.type.toString());
        String descriptiveText = getDescriptiveText();
        if (descriptiveText != null) {
            sb.append(" [").append(descriptiveText).append(']');
        }
        if (this.errorGenerator != null) {
            sb.append(". Generated by ").append(this.errorGenerator);
        }
        return sb.toString();
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return QNAME.getLocalPart();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("type", this.type.toString());
        xmlStringBuilder.optAttribute(StanzaIdElement.ATTR_BY, this.errorGenerator);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.halfOpenElement(this.condition.toString());
        xmlStringBuilder.xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-stanzas");
        if (this.conditionText != null) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.conditionText);
            xmlStringBuilder.closeElement(this.condition.toString());
        } else {
            xmlStringBuilder.closeEmptyElement();
        }
        addDescriptiveTextsAndExtensions(xmlStringBuilder);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static Builder from(Condition condition, String str) {
        Builder condition2 = getBuilder().setCondition(condition);
        if (str != null) {
            HashMap map = new HashMap();
            map.put(Const.ENGLISH, str);
            condition2.setDescriptiveTexts(map);
        }
        return condition2;
    }

    public static Builder getBuilder() {
        return new Builder(null);
    }

    public static Builder getBuilder(Condition condition) {
        return getBuilder().setCondition(condition);
    }

    public static Builder getBuilder(StanzaError stanzaError) {
        return getBuilder().copyFrom(stanzaError);
    }

    public static final class Builder extends AbstractError.Builder<Builder> {
        private Condition condition;
        private String conditionText;
        private String errorGenerator;
        private Type type;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.packet.AbstractError.Builder
        public Builder getThis() {
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        public Builder setCondition(Condition condition) {
            this.condition = condition;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setConditionText(String str) {
            this.conditionText = str;
            return this;
        }

        public Builder setErrorGenerator(String str) {
            this.errorGenerator = str;
            return this;
        }

        public Builder copyFrom(StanzaError stanzaError) {
            setCondition(stanzaError.getCondition());
            setType(stanzaError.getType());
            setConditionText(stanzaError.getConditionText());
            setErrorGenerator(stanzaError.getErrorGenerator());
            setDescriptiveTexts(stanzaError.descriptiveTexts);
            setTextNamespace(stanzaError.textNamespace);
            setExtensions(stanzaError.extensions);
            return this;
        }

        public StanzaError build() {
            return new StanzaError(this.condition, this.conditionText, this.errorGenerator, this.type, this.descriptiveTexts, this.extensions);
        }
    }

    public enum Type {
        WAIT,
        CANCEL,
        MODIFY,
        AUTH,
        CONTINUE;

        @Override // java.lang.Enum
        public String toString() {
            return name().toLowerCase(Locale.US);
        }

        public static Type fromString(String str) {
            return valueOf(str.toUpperCase(Locale.US));
        }
    }

    public enum Condition {
        bad_request,
        conflict,
        feature_not_implemented,
        forbidden,
        gone,
        internal_server_error,
        item_not_found,
        jid_malformed,
        not_acceptable,
        not_allowed,
        not_authorized,
        policy_violation,
        recipient_unavailable,
        redirect,
        registration_required,
        remote_server_not_found,
        remote_server_timeout,
        resource_constraint,
        service_unavailable,
        subscription_required,
        undefined_condition,
        unexpected_request;

        @Override // java.lang.Enum
        public String toString() {
            return name().replace('_', '-');
        }

        public static Condition fromString(String str) {
            String strReplace = str.replace('-', '_');
            try {
                return valueOf(strReplace);
            } catch (Exception e2) {
                throw new IllegalStateException("Could not transform string '" + strReplace + "' to XMPPErrorCondition", e2);
            }
        }
    }
}
