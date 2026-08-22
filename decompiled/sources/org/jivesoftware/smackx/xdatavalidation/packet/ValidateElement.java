package org.jivesoftware.smackx.xdatavalidation.packet;

import com.clevertap.android.sdk.Constants;
import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdatavalidation.ValidationConsistencyException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ValidateElement implements FormFieldChildElement {
    public static final String DATATYPE_XS_STRING = "xs:string";
    private final String datatype;
    private ListRange listRange;
    public static final String NAMESPACE = "http://jabber.org/protocol/xdata-validate";
    public static final String ELEMENT = "validate";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);

    protected abstract void appendXML(XmlStringBuilder xmlStringBuilder);

    @Override // org.jivesoftware.smackx.xdata.FormFieldChildElement
    public abstract void checkConsistency(FormField.Builder<?, ?> builder);

    @Override // org.jivesoftware.smackx.xdata.FormFieldChildElement
    public final boolean mustBeOnlyOfHisKind() {
        return true;
    }

    /* synthetic */ ValidateElement(String str, AnonymousClass1 anonymousClass1) {
        this(str);
    }

    private ValidateElement(String str) {
        this.datatype = StringUtils.isNotEmpty(str) ? str : null;
    }

    public String getDatatype() {
        String str = this.datatype;
        return str != null ? str : DATATYPE_XS_STRING;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public QName getQName() {
        return QNAME;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.optAttribute("datatype", this.datatype);
        xmlStringBuilder.rightAngleBracket();
        appendXML(xmlStringBuilder);
        xmlStringBuilder.optAppend(getListRange());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public void setListRange(ListRange listRange) {
        this.listRange = listRange;
    }

    public ListRange getListRange() {
        return this.listRange;
    }

    public static ValidateElement from(FormField formField) {
        return (ValidateElement) formField.getFormFieldChildElement(QNAME);
    }

    public static class BasicValidateElement extends ValidateElement {
        public static final String METHOD = "basic";

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return super.toXML(xmlEnvironment);
        }

        public BasicValidateElement(String str) {
            super(str, null);
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        protected void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.emptyElement(METHOD);
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smackx.xdata.FormFieldChildElement
        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkListRangeConsistency(builder);
            if (builder.getType() != null) {
                int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[builder.getType().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", builder.getType(), METHOD));
                }
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            int[] iArr = new int[FormField.Type.values().length];
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = iArr;
            try {
                iArr[FormField.Type.hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_multi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_single.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.list_multi.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_multi.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class OpenValidateElement extends ValidateElement {
        public static final String METHOD = "open";

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return super.toXML(xmlEnvironment);
        }

        public OpenValidateElement(String str) {
            super(str, null);
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        protected void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.emptyElement("open");
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smackx.xdata.FormFieldChildElement
        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkListRangeConsistency(builder);
            if (builder.getType() != null && AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[builder.getType().ordinal()] == 1) {
                throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", builder.getType(), "open"));
            }
        }
    }

    public static class RangeValidateElement extends ValidateElement {
        public static final String METHOD = "range";
        private final String max;
        private final String min;

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return super.toXML(xmlEnvironment);
        }

        public RangeValidateElement(String str, String str2, String str3) {
            super(str, null);
            this.min = str2;
            this.max = str3;
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        protected void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.halfOpenElement("range");
            xmlStringBuilder.optAttribute("min", getMin());
            xmlStringBuilder.optAttribute(Constants.PRIORITY_MAX, getMax());
            xmlStringBuilder.closeEmptyElement();
        }

        public String getMin() {
            return this.min;
        }

        public String getMax() {
            return this.max;
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smackx.xdata.FormFieldChildElement
        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkNonMultiConsistency(builder, "range");
            if (getDatatype().equals(ValidateElement.DATATYPE_XS_STRING)) {
                throw new ValidationConsistencyException(String.format("Field data type '%1$s' is not consistent with validation method '%2$s'.", getDatatype(), "range"));
            }
        }

        @Override // org.jivesoftware.smackx.xdata.FormFieldChildElement
        public void validate(FormField formField) {
            AbstractSingleStringValueFormField abstractSingleStringValueFormField = (AbstractSingleStringValueFormField) formField.ifPossibleAs(AbstractSingleStringValueFormField.class);
            if (abstractSingleStringValueFormField == null) {
                return;
            }
            String value = abstractSingleStringValueFormField.getValue();
            String datatype = getDatatype();
            datatype.hashCode();
            if (datatype.equals("xs:int") || datatype.equals("xs:integer")) {
                BigInteger bigInteger = new BigInteger(value);
                String min = getMin();
                if (min != null && bigInteger.compareTo(new BigInteger(min)) < 0) {
                    throw new IllegalArgumentException("The provided value " + value + " is lower than the allowed minimum of " + min);
                }
                String max = getMax();
                if (max != null && bigInteger.compareTo(new BigInteger(max)) > 0) {
                    throw new IllegalArgumentException("The provided value " + value + " is higher than the allowed maximum of " + max);
                }
            }
        }
    }

    public static class RegexValidateElement extends ValidateElement {
        public static final String METHOD = "regex";
        private final String regex;

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return super.toXML(xmlEnvironment);
        }

        public RegexValidateElement(String str, String str2) {
            super(str, null);
            this.regex = str2;
        }

        public String getRegex() {
            return this.regex;
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        protected void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.element(METHOD, getRegex());
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smackx.xdata.FormFieldChildElement
        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkNonMultiConsistency(builder, METHOD);
        }
    }

    public static class ListRange implements FullyQualifiedElement {
        public static final String ELEMENT = "list-range";
        private final UInt32 max;
        private final UInt32 min;

        public ListRange(Long l, Long l2) {
            this(l != null ? UInt32.from(l.longValue()) : null, l2 != null ? UInt32.from(l2.longValue()) : null);
        }

        public ListRange(UInt32 uInt32, UInt32 uInt322) {
            if (uInt322 == null && uInt32 == null) {
                throw new IllegalArgumentException("Either min or max must be given");
            }
            this.min = uInt32;
            this.max = uInt322;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttributeCs("min", getMin());
            xmlStringBuilder.optAttributeCs(Constants.PRIORITY_MAX, getMax());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public UInt32 getMin() {
            return this.min;
        }

        public UInt32 getMax() {
            return this.max;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ValidateElement.NAMESPACE;
        }
    }

    protected void checkListRangeConsistency(FormField.Builder<?, ?> builder) {
        ListRange listRange = getListRange();
        if (listRange == null) {
            return;
        }
        UInt32 max = listRange.getMax();
        UInt32 min = listRange.getMin();
        if ((max != null || min != null) && builder.getType() != FormField.Type.list_multi) {
            throw new ValidationConsistencyException("Field type is not of type 'list-multi' while a 'list-range' is defined.");
        }
    }

    protected void checkNonMultiConsistency(FormField.Builder<?, ?> builder, String str) {
        checkListRangeConsistency(builder);
        if (builder.getType() != null) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[builder.getType().ordinal()];
            if (i == 1 || i == 2 || i == 4 || i == 5) {
                throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", builder.getType(), str));
            }
        }
    }
}
