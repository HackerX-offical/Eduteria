package org.jivesoftware.smackx.xdata.form;

import java.util.Iterator;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FilledForm implements FormReader {
    private final DataForm dataForm;
    protected final TextSingleFormField formTypeFormField;

    public FilledForm(DataForm dataForm) {
        this.dataForm = (DataForm) Objects.requireNonNull(dataForm);
        if (dataForm.getType() == DataForm.Type.cancel) {
            throw new IllegalArgumentException("Forms of type 'cancel' are not filled nor fillable");
        }
        this.formTypeFormField = dataForm.getHiddenFormTypeField();
    }

    @Override // org.jivesoftware.smackx.xdata.form.FormReader
    public FormField getField(String str) {
        return this.dataForm.getField(str);
    }

    public String getTitle() {
        return this.dataForm.getTitle();
    }

    public StringBuilder getInstructions() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.dataForm.getInstructions().iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append('\n');
        }
        return sb;
    }

    public DataForm getDataForm() {
        return this.dataForm;
    }

    public String getFormType() {
        TextSingleFormField textSingleFormField = this.formTypeFormField;
        if (textSingleFormField == null) {
            return null;
        }
        return textSingleFormField.getValue();
    }

    public boolean hasField(String str) {
        return this.dataForm.hasField(str);
    }

    protected FormField getFieldOrThrow(String str) {
        FormField field = getField(str);
        if (field != null) {
            return field;
        }
        throw new IllegalArgumentException("No field named " + str);
    }

    protected static void ensureFormType(DataForm dataForm, String str) {
        String formType = dataForm.getFormType();
        if (!str.equals(formType)) {
            throw new IllegalArgumentException("The provided data form must be of type '" + str + "', this one was of type '" + formType + '\'');
        }
    }
}
