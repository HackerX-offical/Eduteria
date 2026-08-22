package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class FilledSubscribeForm extends FilledForm implements SubscribeFormReader {
    public FilledSubscribeForm(DataForm dataForm) {
        super(dataForm);
        ensureFormType(dataForm, SubscribeFormReader.FORM_TYPE);
    }
}
