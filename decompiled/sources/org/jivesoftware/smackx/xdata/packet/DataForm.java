package org.jivesoftware.smackx.xdata.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.formtypes.FormFieldRegistry;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;

/* JADX INFO: loaded from: classes10.dex */
public final class DataForm implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "jabber:x:data";
    public static final QName QNAME = new QName("jabber:x:data", "x");
    private final List<Element> extensionElements;
    private final List<FormField> fields;
    private final Map<String, FormField> fieldsMap;
    private final List<String> instructions;
    private final List<Item> items;
    private final ReportedData reportedData;
    private final String title;
    private final Type type;

    public enum Type {
        form,
        submit,
        cancel,
        result;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    private DataForm(Builder builder) {
        Type type = builder.type;
        this.type = type;
        this.title = builder.title;
        this.instructions = CollectionUtil.cloneAndSeal(builder.instructions);
        this.reportedData = builder.reportedData;
        this.items = CollectionUtil.cloneAndSeal(builder.items);
        builder.orderFields();
        this.fields = CollectionUtil.cloneAndSeal(builder.fields);
        this.fieldsMap = CollectionUtil.cloneAndSeal(builder.fieldsMap);
        this.extensionElements = CollectionUtil.cloneAndSeal(builder.extensionElements);
        if (type == Type.form) {
            FormFieldRegistry.register(this);
        }
    }

    public Type getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getInstructions() {
        return this.instructions;
    }

    public ReportedData getReportedData() {
        return this.reportedData;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public List<FormField> getFields() {
        return this.fields;
    }

    public FormField getField(String str) {
        return this.fieldsMap.get(str);
    }

    public boolean hasField(String str) {
        return this.fieldsMap.containsKey(str);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "jabber:x:data";
    }

    public List<Element> getExtensionElements() {
        return this.extensionElements;
    }

    public String getFormType() {
        TextSingleFormField hiddenFormTypeField = getHiddenFormTypeField();
        if (hiddenFormTypeField == null) {
            return null;
        }
        return hiddenFormTypeField.getFirstValue();
    }

    public TextSingleFormField getHiddenFormTypeField() {
        FormField field = getField(FormField.FORM_TYPE);
        if (field == null) {
            return null;
        }
        return field.asHiddenFormTypeFieldIfPossible();
    }

    public boolean hasHiddenFormTypeField() {
        return getHiddenFormTypeField() != null;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("type", getType());
        xmlStringBuilder.rightAngleBracket();
        XmlEnvironment xmlEnvironment2 = xmlStringBuilder.getXmlEnvironment();
        xmlStringBuilder.optElement("title", getTitle());
        Iterator<String> it = getInstructions().iterator();
        while (it.hasNext()) {
            xmlStringBuilder.element("instructions", it.next());
        }
        xmlStringBuilder.optElement(getReportedData());
        xmlStringBuilder.append(getItems());
        boolean z = getType() != Type.submit;
        Iterator<FormField> it2 = getFields().iterator();
        while (it2.hasNext()) {
            xmlStringBuilder.append(it2.next().toXML(xmlEnvironment2, z));
        }
        xmlStringBuilder.append(getExtensionElements());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public static DataForm from(StanzaView stanzaView) {
        return from(stanzaView, (String) null);
    }

    public static DataForm from(StanzaView stanzaView, String str) {
        if (str == null) {
            return (DataForm) stanzaView.getExtension(DataForm.class);
        }
        return from(stanzaView.getExtensions(DataForm.class), str);
    }

    public static DataForm from(Collection<DataForm> collection, String str) {
        for (DataForm dataForm : collection) {
            if (str.equals(dataForm.getFormType())) {
                return dataForm;
            }
        }
        return null;
    }

    public static DataForm remove(Collection<DataForm> collection, String str) {
        Iterator<DataForm> it = collection.iterator();
        while (it.hasNext()) {
            DataForm next = it.next();
            if (str.equals(next.getFormType())) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(Type type) {
        return new Builder(type);
    }

    public static final class Builder {
        private List<Element> extensionElements;
        private List<FormField> fields;
        private Map<String, FormField> fieldsMap;
        private List<String> instructions;
        private List<Item> items;
        private ReportedData reportedData;
        private String title;
        private Type type;

        private Builder() {
            this(Type.submit);
        }

        private Builder(Type type) {
            this.fields = new ArrayList();
            this.fieldsMap = new HashMap();
            this.type = type;
        }

        private Builder(DataForm dataForm) {
            this.fields = new ArrayList();
            this.fieldsMap = new HashMap();
            this.type = dataForm.getType();
            this.title = dataForm.getTitle();
            this.instructions = dataForm.getInstructions();
            this.reportedData = dataForm.getReportedData();
            this.items = CollectionUtil.newListWith(dataForm.getItems());
            this.fields = CollectionUtil.newListWith(dataForm.getFields());
            this.fieldsMap = new HashMap(dataForm.fieldsMap);
            this.extensionElements = CollectionUtil.newListWith(dataForm.getExtensionElements());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void orderFields() {
            Iterator<FormField> it = this.fields.iterator();
            if (it.hasNext() && it.next().asHiddenFormTypeFieldIfPossible() == null) {
                while (it.hasNext()) {
                    TextSingleFormField textSingleFormFieldAsHiddenFormTypeFieldIfPossible = it.next().asHiddenFormTypeFieldIfPossible();
                    if (textSingleFormFieldAsHiddenFormTypeFieldIfPossible != null) {
                        it.remove();
                        this.fields.add(0, textSingleFormFieldAsHiddenFormTypeFieldIfPossible);
                        return;
                    }
                }
            }
        }

        @Deprecated
        public Builder setType(Type type) {
            this.type = (Type) Objects.requireNonNull(type);
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder addField(FormField formField) {
            String fieldName = formField.getFieldName();
            if (fieldName != null) {
                if (this.fieldsMap.containsKey(fieldName)) {
                    throw new IllegalArgumentException("A field with the name " + fieldName + " already exists");
                }
                this.fieldsMap.put(fieldName, formField);
            }
            this.fields.add(formField);
            return this;
        }

        public Builder addFields(Collection<? extends FormField> collection) {
            Iterator<? extends FormField> it = collection.iterator();
            while (it.hasNext()) {
                String fieldName = it.next().getFieldName();
                if (this.fieldsMap.containsKey(fieldName)) {
                    throw new IllegalArgumentException("A field with the name " + fieldName + " already exists");
                }
            }
            for (FormField formField : collection) {
                String fieldName2 = formField.getFieldName();
                if (fieldName2 != null) {
                    this.fieldsMap.put(fieldName2, formField);
                }
                this.fields.add(formField);
            }
            return this;
        }

        public Builder removeField(String str) {
            FormField formFieldRemove = this.fieldsMap.remove(str);
            if (formFieldRemove != null) {
                this.fields.remove(formFieldRemove);
            }
            return this;
        }

        public Builder setFormType(String str) {
            return addField(FormField.buildHiddenFormType(str));
        }

        public Builder setInstructions(String str) {
            return setInstructions(StringUtils.splitLinesPortable(str));
        }

        public Builder setInstructions(List<String> list) {
            this.instructions = list;
            return this;
        }

        public Builder addInstruction(String str) {
            if (this.instructions == null) {
                this.instructions = new ArrayList();
            }
            this.instructions.add(str);
            return this;
        }

        public Builder addItem(Item item) {
            if (this.items == null) {
                this.items = new ArrayList();
            }
            this.items.add(item);
            return this;
        }

        public Builder setReportedData(ReportedData reportedData) {
            this.reportedData = reportedData;
            return this;
        }

        public Builder addExtensionElement(Element element) {
            if (this.extensionElements == null) {
                this.extensionElements = new ArrayList();
            }
            this.extensionElements.add(element);
            return this;
        }

        public DataForm build() {
            return new DataForm(this);
        }
    }

    public static class ReportedData implements ExtensionElement {
        public static final String ELEMENT = "reported";
        public static final QName QNAME = new QName("jabber:x:data", ELEMENT);
        private Map<String, FormField> fieldMap;
        private final List<? extends FormField> fields;

        public ReportedData(List<? extends FormField> list) {
            this.fields = Collections.unmodifiableList(list);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:x:data";
        }

        public List<? extends FormField> getFields() {
            return this.fields;
        }

        public FormField getField(String str) {
            if (this.fieldMap == null) {
                this.fieldMap = new HashMap(this.fields.size());
                for (FormField formField : this.fields) {
                    this.fieldMap.put(formField.getFieldName(), formField);
                }
            }
            return this.fieldMap.get(str);
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append(getFields());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }

    public static class Item implements ExtensionElement {
        public static final String ELEMENT = "item";
        public static final QName QNAME = new QName("jabber:x:data", "item");
        private final List<? extends FormField> fields;

        public Item(List<? extends FormField> list) {
            this.fields = Collections.unmodifiableList(list);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "item";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:x:data";
        }

        public List<? extends FormField> getFields() {
            return this.fields;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append(getFields());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }
}
