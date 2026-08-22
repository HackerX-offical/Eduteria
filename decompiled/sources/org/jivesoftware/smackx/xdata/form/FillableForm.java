package org.jivesoftware.smackx.xdata.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.util.JidUtil;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class FillableForm extends FilledForm {
    private final Map<String, FormField> filledFields;
    private final Set<String> filledRequiredFields;
    private final Set<String> missingRequiredFields;
    private final Set<String> requiredFields;

    public FillableForm(DataForm dataForm) {
        super(dataForm);
        this.filledRequiredFields = new HashSet();
        this.missingRequiredFields = new HashSet();
        this.filledFields = new HashMap();
        if (dataForm.getType() != DataForm.Type.form) {
            throw new IllegalArgumentException();
        }
        HashSet hashSet = new HashSet();
        for (FormField formField : dataForm.getFields()) {
            if (formField.isRequired()) {
                String fieldName = formField.getFieldName();
                hashSet.add(fieldName);
                if (formField.hasValueSet()) {
                    write(formField);
                } else {
                    this.missingRequiredFields.add(fieldName);
                }
            }
        }
        this.requiredFields = Collections.unmodifiableSet(hashSet);
    }

    protected void writeListMulti(String str, List<? extends CharSequence> list) {
        write(FormField.listMultiBuilder(str).addValues(list).build());
    }

    protected void writeTextSingle(String str, CharSequence charSequence) {
        write(FormField.textSingleBuilder(str).setValue(charSequence).build());
    }

    protected void writeBoolean(String str, boolean z) {
        write(FormField.booleanBuilder(str).setValue(z).build());
    }

    protected void write(String str, int i) {
        writeTextSingle(str, Integer.toString(i));
    }

    protected void write(String str, Date date) {
        writeTextSingle(str, XmppDateTime.formatXEP0082Date(date));
    }

    public void setAnswer(String str, Collection<? extends CharSequence> collection) {
        FormField formFieldBuild;
        FormField.Type type = getFieldOrThrow(str).getType();
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()];
        if (i == 1 || i == 2) {
            formFieldBuild = createMultiKindFieldbuilder(str, type).addValues(collection).build();
        } else if (i == 3) {
            ArrayList arrayList = new ArrayList(collection.size());
            ArrayList arrayList2 = new ArrayList();
            JidUtil.jidsFrom(collection, arrayList, arrayList2);
            if (!arrayList2.isEmpty()) {
                throw new IllegalArgumentException((Throwable) arrayList2.get(0));
            }
            formFieldBuild = FormField.jidMultiBuilder(str).addValues(arrayList).build();
        } else {
            throw new IllegalArgumentException("");
        }
        write(formFieldBuild);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.xdata.form.FillableForm$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            int[] iArr = new int[FormField.Type.values().length];
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = iArr;
            try {
                iArr[FormField.Type.list_multi.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_multi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_multi.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.fixed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.list_single.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_private.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_single.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.hidden.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.bool.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_single.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static AbstractMultiFormField.Builder<?, ?> createMultiKindFieldbuilder(String str, FormField.Type type) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()];
        if (i == 1) {
            return FormField.listMultiBuilder(str);
        }
        if (i == 2) {
            return FormField.textMultiBuilder(str);
        }
        throw new IllegalArgumentException();
    }

    public void setAnswer(String str, int i) {
        setAnswer(str, Integer.toString(i));
    }

    public void setAnswer(String str, CharSequence charSequence) {
        FormField formFieldBuild;
        FormField.Type type = getFieldOrThrow(str).getType();
        switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()]) {
            case 1:
            case 3:
                throw new IllegalArgumentException("Can not answer fields of type '" + type + "' with a CharSequence");
            case 2:
                formFieldBuild = createMultiKindFieldbuilder(str, type).addValue(charSequence).build();
                break;
            case 4:
                throw new IllegalArgumentException("Fields of type 'fixed' are not answerable");
            case 5:
            case 6:
            case 7:
            case 8:
                formFieldBuild = createSingleKindFieldBuilder(str, type).setValue(charSequence).build();
                break;
            case 9:
                formFieldBuild = FormField.booleanBuilder(str).setValue(charSequence).build();
                break;
            case 10:
                try {
                    formFieldBuild = FormField.jidSingleBuilder(str).setValue(JidCreate.from(charSequence)).build();
                } catch (XmppStringprepException e2) {
                    throw new IllegalArgumentException(e2);
                }
                break;
            default:
                throw new AssertionError();
        }
        write(formFieldBuild);
    }

    private static AbstractSingleStringValueFormField.Builder<?, ?> createSingleKindFieldBuilder(String str, FormField.Type type) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()];
        if (i == 5) {
            return FormField.listSingleBuilder(str);
        }
        if (i == 6) {
            return FormField.textPrivateBuilder(str);
        }
        if (i == 7) {
            return FormField.textSingleBuilder(str);
        }
        if (i == 8) {
            return FormField.hiddenBuilder(str);
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }

    public void setAnswer(String str, boolean z) {
        if (getFieldOrThrow(str).getType() != FormField.Type.bool) {
            throw new IllegalArgumentException();
        }
        write(FormField.booleanBuilder(str).setValue(z).build());
    }

    public final void write(FormField formField) {
        if (formField.getType() == FormField.Type.fixed) {
            throw new IllegalArgumentException();
        }
        if (!formField.hasValueSet()) {
            throw new IllegalArgumentException();
        }
        String fieldName = formField.getFieldName();
        if (!getDataForm().hasField(fieldName)) {
            throw new IllegalArgumentException();
        }
        Iterator<FormFieldChildElement> it = getDataForm().getField(fieldName).getFormFieldChildElements().iterator();
        while (it.hasNext()) {
            it.next().validate(formField);
        }
        this.filledFields.put(fieldName, formField);
        if (this.requiredFields.contains(fieldName)) {
            this.filledRequiredFields.add(fieldName);
            this.missingRequiredFields.remove(fieldName);
        }
    }

    @Override // org.jivesoftware.smackx.xdata.form.FilledForm, org.jivesoftware.smackx.xdata.form.FormReader
    public FormField getField(String str) {
        FormField formField = this.filledFields.get(str);
        return formField != null ? formField : super.getField(str);
    }

    public DataForm getDataFormToSubmit() {
        if (!this.missingRequiredFields.isEmpty()) {
            throw new IllegalStateException("Not all required fields filled. Missing: " + this.missingRequiredFields);
        }
        DataForm.Builder builder = DataForm.builder();
        if (this.formTypeFormField != null) {
            builder.addField(this.formTypeFormField);
        }
        builder.addFields(this.filledFields.values());
        return builder.build();
    }
}
