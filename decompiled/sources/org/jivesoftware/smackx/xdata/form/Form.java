package org.jivesoftware.smackx.xdata.form;

import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class Form extends FilledForm {
    public Form(DataForm dataForm) {
        super(dataForm);
        if (dataForm.getType() != DataForm.Type.form) {
            throw new IllegalArgumentException();
        }
    }

    public FillableForm getFillableForm() {
        return new FillableForm(getDataForm());
    }

    public static Form from(StanzaView stanzaView) {
        DataForm dataFormFrom = DataForm.from(stanzaView);
        if (dataFormFrom == null || dataFormFrom.getType() != DataForm.Type.form) {
            return null;
        }
        return new Form(dataFormFrom);
    }
}
