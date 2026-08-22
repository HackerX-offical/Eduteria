package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.Form;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class SubscribeForm extends Form implements SubscribeFormReader {
    public SubscribeForm(DataForm dataForm) {
        super(dataForm);
        ensureFormType(dataForm, SubscribeFormReader.FORM_TYPE);
    }

    @Override // org.jivesoftware.smackx.xdata.form.Form
    public FillableSubscribeForm getFillableForm() {
        return new FillableSubscribeForm(getDataForm());
    }
}
