package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.Form;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class ConfigureForm extends Form implements ConfigureFormReader {
    public ConfigureForm(DataForm dataForm) {
        super(dataForm);
        ensureFormType(dataForm, ConfigureFormReader.FORM_TYPE);
    }

    @Override // org.jivesoftware.smackx.xdata.form.Form
    public FillableConfigureForm getFillableForm() {
        return new FillableConfigureForm(getDataForm());
    }
}
