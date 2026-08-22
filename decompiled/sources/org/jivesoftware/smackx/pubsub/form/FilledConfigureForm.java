package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class FilledConfigureForm extends FilledForm implements ConfigureFormReader {
    public FilledConfigureForm(DataForm dataForm) {
        super(dataForm);
        ensureFormType(dataForm, ConfigureFormReader.FORM_TYPE);
    }
}
