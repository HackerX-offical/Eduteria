package org.jivesoftware.smackx.xdata;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.BooleanFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.JidMultiFormField;
import org.jivesoftware.smackx.xdata.JidSingleFormField;
import org.jivesoftware.smackx.xdata.ListMultiFormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.TextMultiFormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FormField implements FullyQualifiedElement {
    public static final String FORM_TYPE = "FORM_TYPE";
    public static final String NAMESPACE = "jabber:x:data";
    private final String description;
    protected transient List<FullyQualifiedElement> extraXmlChildElements;
    private final String fieldName;
    private final List<FormFieldChildElement> formFieldChildElements;
    private final MultiMap<QName, FormFieldChildElement> formFieldChildElementsMap;
    private final String label;
    private transient List<CharSequence> rawValueCharSequences;
    private final boolean required;
    private final Type type;
    public static final String ELEMENT = "field";
    public static final QName QNAME = new QName("jabber:x:data", ELEMENT);

    public abstract List<Value> getRawValues();

    /* JADX INFO: renamed from: org.jivesoftware.smackx.xdata.FormField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = iArr;
            try {
                iArr[Type.bool.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum Type {
        bool,
        fixed,
        hidden,
        jid_multi,
        jid_single,
        list_multi,
        list_single,
        text_multi,
        text_private,
        text_single;

        @Override // java.lang.Enum
        public String toString() {
            if (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[ordinal()] == 1) {
                return "boolean";
            }
            return name().replace('_', '-');
        }

        public static Type fromString(String str) {
            if (str == null) {
                return null;
            }
            str.hashCode();
            if (str.equals("boolean")) {
                return bool;
            }
            return valueOf(str.replace('-', '_'));
        }
    }

    private MultiMap<QName, FormFieldChildElement> createChildElementsMap() {
        MultiMap multiMap = new MultiMap(this.formFieldChildElements.size());
        for (FormFieldChildElement formFieldChildElement : this.formFieldChildElements) {
            multiMap.put(formFieldChildElement.getQName(), formFieldChildElement);
        }
        return multiMap.asUnmodifiableMultiMap();
    }

    protected FormField(Builder<?, ?> builder) {
        String str = ((Builder) builder).fieldName;
        this.fieldName = str;
        this.label = ((Builder) builder).label;
        Type type = ((Builder) builder).type;
        this.type = type;
        if (((Builder) builder).formFieldChildElements == null) {
            this.formFieldChildElements = Collections.emptyList();
        } else {
            this.formFieldChildElements = Collections.unmodifiableList(((Builder) builder).formFieldChildElements);
        }
        if (str == null && type != Type.fixed) {
            throw new IllegalArgumentException("The variable can only be null if the form is of type fixed");
        }
        ArrayList arrayList = new ArrayList(this.formFieldChildElements.size());
        String description = null;
        boolean z = false;
        for (FormFieldChildElement formFieldChildElement : this.formFieldChildElements) {
            if (formFieldChildElement instanceof Description) {
                description = ((Description) formFieldChildElement).getDescription();
            } else if (formFieldChildElement instanceof Required) {
                z = true;
            }
        }
        arrayList.trimToSize();
        this.description = description;
        this.required = z;
        this.formFieldChildElementsMap = createChildElementsMap();
    }

    public String getDescription() {
        return this.description;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isRequired() {
        return this.required;
    }

    public Type getType() {
        Type type = this.type;
        return type == null ? Type.text_single : type;
    }

    public List<? extends CharSequence> getValues() {
        return getRawValueCharSequences();
    }

    public final List<CharSequence> getRawValueCharSequences() {
        if (this.rawValueCharSequences == null) {
            List<Value> rawValues = getRawValues();
            this.rawValueCharSequences = new ArrayList(rawValues.size());
            Iterator<Value> it = rawValues.iterator();
            while (it.hasNext()) {
                this.rawValueCharSequences.add(it.next().value);
            }
        }
        return this.rawValueCharSequences;
    }

    public boolean hasValueSet() {
        return !getValues().isEmpty();
    }

    public List<String> getValuesAsString() {
        List<? extends CharSequence> values = getValues();
        ArrayList arrayList = new ArrayList(values.size());
        Iterator<? extends CharSequence> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return arrayList;
    }

    public String getFirstValue() {
        List<? extends CharSequence> values = getValues();
        if (values.isEmpty()) {
            return null;
        }
        return values.get(0).toString();
    }

    public Date getFirstValueAsDate() throws ParseException {
        String firstValue = getFirstValue();
        if (firstValue == null) {
            return null;
        }
        return XmppDateTime.parseXEP0082Date(firstValue);
    }

    @Deprecated
    public String getVariable() {
        return getFieldName();
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public FormFieldChildElement getFormFieldChildElement(QName qName) {
        return this.formFieldChildElementsMap.getFirst(qName);
    }

    public List<FormFieldChildElement> getFormFieldChildElements(QName qName) {
        return this.formFieldChildElementsMap.getAll(qName);
    }

    public List<FormFieldChildElement> getFormFieldChildElements() {
        return this.formFieldChildElements;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "jabber:x:data";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public QName getQName() {
        return QNAME;
    }

    protected void populateExtraXmlChildElements() {
        List<Value> rawValues = getRawValues();
        ArrayList arrayList = new ArrayList(rawValues.size());
        this.extraXmlChildElements = arrayList;
        arrayList.addAll(rawValues);
    }

    @Override // org.jivesoftware.smack.packet.Element
    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return toXML(xmlEnvironment, true);
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment, boolean z) {
        List<FullyQualifiedElement> list;
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.optAttribute("label", getLabel());
        xmlStringBuilder.optAttribute("var", getFieldName());
        if (z) {
            xmlStringBuilder.attribute("type", getType(), Type.text_single);
        }
        if (this.extraXmlChildElements == null) {
            populateExtraXmlChildElements();
        }
        if (this.formFieldChildElements.isEmpty() && ((list = this.extraXmlChildElements) == null || list.isEmpty())) {
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optAppend(this.extraXmlChildElements);
        xmlStringBuilder.append(this.formFieldChildElements);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof FormField) {
            return toXML().toString().equals(((FormField) obj).toXML().toString());
        }
        return false;
    }

    public int hashCode() {
        return toXML().toString().hashCode();
    }

    public static BooleanFormField.Builder booleanBuilder(String str) {
        return new BooleanFormField.Builder(str);
    }

    public static TextSingleFormField.Builder fixedBuilder() {
        return fixedBuilder(null);
    }

    public static TextSingleFormField.Builder fixedBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.fixed);
    }

    public static TextSingleFormField.Builder hiddenBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.hidden);
    }

    public static JidMultiFormField.Builder jidMultiBuilder(String str) {
        return new JidMultiFormField.Builder(str);
    }

    public static JidSingleFormField.Builder jidSingleBuilder(String str) {
        return new JidSingleFormField.Builder(str);
    }

    public static ListMultiFormField.Builder listMultiBuilder(String str) {
        return new ListMultiFormField.Builder(str);
    }

    public static ListSingleFormField.Builder listSingleBuilder(String str) {
        return new ListSingleFormField.Builder(str);
    }

    public static TextMultiFormField.Builder textMultiBuilder(String str) {
        return new TextMultiFormField.Builder(str);
    }

    public static TextSingleFormField.Builder textPrivateBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.text_private);
    }

    public static TextSingleFormField.Builder textSingleBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.text_single);
    }

    public static TextSingleFormField.Builder builder(String str) {
        return textSingleBuilder(str);
    }

    public static TextSingleFormField buildHiddenFormType(String str) {
        return hiddenBuilder(FORM_TYPE).setValue(str).build();
    }

    public <F extends FormField> F ifPossibleAs(Class<F> cls) {
        if (cls.isInstance(this)) {
            return cls.cast(this);
        }
        return null;
    }

    public <F extends FormField> F ifPossibleAsOrThrow(Class<F> cls) {
        F f2 = (F) ifPossibleAs(cls);
        if (f2 != null) {
            return f2;
        }
        throw new IllegalArgumentException();
    }

    public TextSingleFormField asHiddenFormTypeFieldIfPossible() {
        TextSingleFormField textSingleFormField = (TextSingleFormField) ifPossibleAs(TextSingleFormField.class);
        if (textSingleFormField != null && getType() == Type.hidden && getFieldName().equals(FORM_TYPE)) {
            return textSingleFormField;
        }
        return null;
    }

    public static abstract class Builder<F extends FormField, B extends Builder<?, ?>> {
        private boolean disallowFurtherFormFieldChildElements;
        private boolean disallowType;
        private final String fieldName;
        private List<FormFieldChildElement> formFieldChildElements;
        private String label;
        private final Type type;

        public abstract F build();

        public abstract B getThis();

        protected abstract void resetInternal();

        protected Builder(String str, Type type) {
            if (StringUtils.isNullOrEmpty(str) && type != Type.fixed) {
                throw new IllegalArgumentException("Fields of type " + type + " must have a field name set");
            }
            this.fieldName = str;
            this.type = type;
        }

        protected Builder(FormField formField) {
            this.fieldName = formField.fieldName;
            this.label = formField.label;
            this.type = formField.type;
            this.formFieldChildElements = CollectionUtil.newListWith(formField.formFieldChildElements);
        }

        public B setDescription(String str) {
            setOnlyElement(new Description(str));
            return (B) getThis();
        }

        public B setLabel(String str) {
            this.label = (String) Objects.requireNonNull(str, "label must not be null");
            return (B) getThis();
        }

        public B setRequired() {
            return (B) setRequired(true);
        }

        public B setRequired(boolean z) {
            if (z) {
                setOnlyElement(Required.INSTANCE);
            }
            return (B) getThis();
        }

        public B addFormFieldChildElements(Collection<? extends FormFieldChildElement> collection) {
            Iterator<? extends FormFieldChildElement> it = collection.iterator();
            while (it.hasNext()) {
                addFormFieldChildElement(it.next());
            }
            return (B) getThis();
        }

        public B addFormFieldChildElement(FormFieldChildElement formFieldChildElement) {
            if (this.disallowFurtherFormFieldChildElements) {
                throw new IllegalArgumentException();
            }
            if (formFieldChildElement.requiresNoTypeSet() && this.type != null) {
                throw new IllegalArgumentException("Elements of type " + formFieldChildElement.getClass() + " can only be added to form fields where no type is set");
            }
            ensureThatFormFieldChildElementsIsSet();
            if (!this.formFieldChildElements.isEmpty() && formFieldChildElement.isExclusiveElement()) {
                throw new IllegalArgumentException("Elements of type " + formFieldChildElement.getClass() + " must be the only child elements of a form field.");
            }
            this.disallowType = this.disallowType || formFieldChildElement.requiresNoTypeSet();
            this.disallowFurtherFormFieldChildElements = formFieldChildElement.isExclusiveElement();
            this.formFieldChildElements.add(formFieldChildElement);
            Iterator<FormFieldChildElement> it = this.formFieldChildElements.iterator();
            while (it.hasNext()) {
                try {
                    it.next().checkConsistency(this);
                } catch (IllegalArgumentException e2) {
                    this.formFieldChildElements.remove(formFieldChildElement);
                    throw e2;
                }
            }
            return (B) getThis();
        }

        public B reset() {
            resetInternal();
            List<FormFieldChildElement> list = this.formFieldChildElements;
            if (list == null) {
                return (B) getThis();
            }
            Iterator<FormFieldChildElement> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Value) {
                    it.remove();
                }
            }
            this.disallowFurtherFormFieldChildElements = false;
            this.disallowType = false;
            return (B) getThis();
        }

        public Type getType() {
            return this.type;
        }

        private void ensureThatFormFieldChildElementsIsSet() {
            if (this.formFieldChildElements == null) {
                this.formFieldChildElements = new ArrayList(4);
            }
        }

        private <E extends FormFieldChildElement> void setOnlyElement(E e2) {
            Class<?> cls = e2.getClass();
            ensureThatFormFieldChildElementsIsSet();
            for (int i = 0; i < this.formFieldChildElements.size(); i++) {
                if (this.formFieldChildElements.get(i).getClass().equals(cls)) {
                    this.formFieldChildElements.set(i, e2);
                    return;
                }
            }
            addFormFieldChildElement(e2);
        }
    }

    private static abstract class StandardFormFieldChildElement implements FormFieldChildElement {
        private StandardFormFieldChildElement() {
        }

        /* synthetic */ StandardFormFieldChildElement(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static final class Option implements FullyQualifiedElement {
        public static final String ELEMENT = "option";
        public static final QName QNAME = new QName("jabber:x:data", "option");
        private final HashCode.Cache hashCodeCache;
        private final String label;
        private final Value value;

        public Option(String str) {
            this((String) null, str);
        }

        public Option(String str, String str2) {
            this.hashCodeCache = new HashCode.Cache();
            this.label = str;
            this.value = new Value(str2);
        }

        public Option(String str, Value value) {
            this.hashCodeCache = new HashCode.Cache();
            this.label = str;
            this.value = value;
        }

        public String getLabel() {
            return this.label;
        }

        public Value getValue() {
            return this.value;
        }

        public String getValueString() {
            return this.value.value.toString();
        }

        public String toString() {
            return getLabel();
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "option";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:x:data";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public QName getQName() {
            return QNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optAttribute("label", getLabel());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.element("value", getValueString());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.xdata.FormField$Option$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
                public final void compare(EqualsUtil.Builder builder, Object obj2) {
                    this.f$0.m14254lambda$equals$0$orgjivesoftwaresmackxxdataFormField$Option(builder, (FormField.Option) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-xdata-FormField$Option, reason: not valid java name */
        /* synthetic */ void m14254lambda$equals$0$orgjivesoftwaresmackxxdataFormField$Option(EqualsUtil.Builder builder, Option option) {
            builder.append(this.value, option.value).append(this.label, option.label);
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new HashCode.Calculator() { // from class: org.jivesoftware.smackx.xdata.FormField$Option$$ExternalSyntheticLambda1
                @Override // org.jivesoftware.smack.util.HashCode.Calculator
                public final void calculateHash(HashCode.Builder builder) {
                    this.f$0.m14255lambda$hashCode$1$orgjivesoftwaresmackxxdataFormField$Option(builder);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$hashCode$1$org-jivesoftware-smackx-xdata-FormField$Option, reason: not valid java name */
        /* synthetic */ void m14255lambda$hashCode$1$orgjivesoftwaresmackxxdataFormField$Option(HashCode.Builder builder) {
            builder.append(this.value).append(this.label);
        }
    }

    public static class Description extends StandardFormFieldChildElement {
        public static final String ELEMENT = "desc";
        public static final QName QNAME = new QName("jabber:x:data", "desc");
        private final String description;

        public Description(String str) {
            super(null);
            this.description = str;
        }

        public String getDescription() {
            return this.description;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "desc";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:x:data";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public QName getQName() {
            return QNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.description);
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }

    public static final class Required extends StandardFormFieldChildElement {
        public static final Required INSTANCE = new Required();
        public static final String ELEMENT = "required";
        public static final QName QNAME = new QName("jabber:x:data", ELEMENT);

        @Override // org.jivesoftware.smackx.xdata.FormFieldChildElement
        public boolean mustBeOnlyOfHisKind() {
            return true;
        }

        private Required() {
            super(null);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:x:data";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public QName getQName() {
            return QNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<required/>";
        }
    }

    public static class Value implements FullyQualifiedElement {
        public static final String ELEMENT = "value";
        public static final QName QNAME = new QName("jabber:x:data", "value");
        private final CharSequence value;

        public Value(CharSequence charSequence) {
            this.value = charSequence;
        }

        public CharSequence getValue() {
            return this.value;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "value";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:x:data";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public QName getQName() {
            return QNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.value);
            return xmlStringBuilder.closeElement(this);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.xdata.FormField$Value$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
                public final void compare(EqualsUtil.Builder builder, Object obj2) {
                    this.f$0.m14256lambda$equals$0$orgjivesoftwaresmackxxdataFormField$Value(builder, (FormField.Value) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-xdata-FormField$Value, reason: not valid java name */
        /* synthetic */ void m14256lambda$equals$0$orgjivesoftwaresmackxxdataFormField$Value(EqualsUtil.Builder builder, Value value) {
            builder.append(this.value, value.value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }
    }
}
