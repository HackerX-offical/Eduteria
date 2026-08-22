package org.jivesoftware.smackx.softwareinfo.form;

import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smackx.mediaelement.element.MediaElement;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public final class SoftwareInfoForm extends FilledForm {
    public static final String FORM_TYPE = "urn:xmpp:dataforms:softwareinfo";
    public static final String ICON = "icon";
    public static final String OS = "os";
    public static final String OS_VERSION = "os_version";
    public static final String SOFTWARE = "software";
    public static final String SOFTWARE_VERSION = "software_version";

    private SoftwareInfoForm(DataForm dataForm) {
        super(dataForm);
    }

    public String getOS() {
        return readFirstValue("os");
    }

    public String getOSVersion() {
        return readFirstValue("os_version");
    }

    public String getSoftwareName() {
        return readFirstValue(SOFTWARE);
    }

    public String getSoftwareVersion() {
        return readFirstValue(SOFTWARE_VERSION);
    }

    public MediaElement getIcon() {
        FormFieldChildElement formFieldChildElement;
        FormField field = getField("icon");
        if (field == null || (formFieldChildElement = field.getFormFieldChildElement(MediaElement.QNAME)) == null) {
            return null;
        }
        return (MediaElement) formFieldChildElement;
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14249x65acbabb(builder, (SoftwareInfoForm) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-softwareinfo-form-SoftwareInfoForm, reason: not valid java name */
    /* synthetic */ void m14249x65acbabb(EqualsUtil.Builder builder, SoftwareInfoForm softwareInfoForm) {
        builder.append(getDataForm().getType(), softwareInfoForm.getDataForm().getType()).append(getDataForm().getTitle(), softwareInfoForm.getDataForm().getTitle()).append(getDataForm().getReportedData(), softwareInfoForm.getDataForm().getReportedData()).append(getDataForm().getItems(), softwareInfoForm.getDataForm().getItems()).append(getDataForm().getFields(), softwareInfoForm.getDataForm().getFields()).append(getDataForm().getExtensionElements(), softwareInfoForm.getDataForm().getExtensionElements());
    }

    public int hashCode() {
        HashCode.Builder builder = HashCode.builder();
        builder.append(getDataForm().getFields());
        builder.append(getDataForm().getItems());
        builder.append(getDataForm().getExtensionElements());
        return builder.build();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {
        DataForm.Builder dataFormBuilder;

        private Builder() {
            this.dataFormBuilder = DataForm.builder(DataForm.Type.result);
            this.dataFormBuilder.addField(FormField.buildHiddenFormType(SoftwareInfoForm.FORM_TYPE));
        }

        public Builder setIcon(int i, int i2, List<MediaElement.Uri> list) {
            MediaElement.Builder builder = MediaElement.builder();
            Iterator<MediaElement.Uri> it = list.iterator();
            while (it.hasNext()) {
                builder.addUri(it.next());
            }
            return setIcon(builder.setHeightAndWidth(i, i2).build());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [org.jivesoftware.smackx.xdata.FormField] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public Builder setIcon(MediaElement mediaElement) {
            TextSingleFormField.Builder builder = FormField.builder("icon");
            builder.addFormFieldChildElement(mediaElement);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setOS(String str) {
            TextSingleFormField.Builder builder = FormField.builder("os");
            builder.setValue(str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setOSVersion(String str) {
            TextSingleFormField.Builder builder = FormField.builder("os_version");
            builder.setValue(str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setSoftware(String str) {
            TextSingleFormField.Builder builder = FormField.builder(SoftwareInfoForm.SOFTWARE);
            builder.setValue(str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setSoftwareVersion(String str) {
            TextSingleFormField.Builder builder = FormField.builder(SoftwareInfoForm.SOFTWARE_VERSION);
            builder.setValue(str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setDataForm(DataForm dataForm) {
            if (dataForm.getTitle() != null || !dataForm.getItems().isEmpty() || dataForm.getReportedData() != null || !dataForm.getInstructions().isEmpty()) {
                throw new IllegalArgumentException("Illegal Arguements for SoftwareInformation");
            }
            String formType = dataForm.getFormType();
            if (formType == null) {
                throw new IllegalArgumentException("FORM_TYPE Formfield missing");
            }
            if (!formType.equals(SoftwareInfoForm.FORM_TYPE)) {
                throw new IllegalArgumentException("Malformed FORM_TYPE Formfield encountered");
            }
            this.dataFormBuilder = dataForm.asBuilder();
            return this;
        }

        public SoftwareInfoForm build() {
            return new SoftwareInfoForm(this.dataFormBuilder.build());
        }
    }
}
