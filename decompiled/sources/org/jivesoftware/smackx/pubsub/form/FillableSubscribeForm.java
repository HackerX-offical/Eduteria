package org.jivesoftware.smackx.pubsub.form;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import org.jivesoftware.smackx.pubsub.PresenceState;
import org.jivesoftware.smackx.pubsub.SubscribeOptionFields;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.ListMultiFormField;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class FillableSubscribeForm extends FillableForm implements SubscribeFormReader {
    FillableSubscribeForm(DataForm dataForm) {
        super(dataForm);
    }

    public void setDeliverOn(boolean z) {
        writeBoolean(SubscribeOptionFields.deliver.getFieldName(), z);
    }

    public void setDigestOn(boolean z) {
        writeBoolean(SubscribeOptionFields.digest.getFieldName(), z);
    }

    public void setDigestFrequency(int i) {
        write(SubscribeOptionFields.digest_frequency.getFieldName(), i);
    }

    public void setExpiry(Date date) {
        write(SubscribeOptionFields.expire.getFieldName(), date);
    }

    public void setIncludeBody(boolean z) {
        writeBoolean(SubscribeOptionFields.include_body.getFieldName(), z);
    }

    public void setShowValues(Collection<PresenceState> collection) {
        ListMultiFormField.Builder builderListMultiBuilder = FormField.listMultiBuilder(SubscribeOptionFields.show_values.getFieldName());
        Iterator<PresenceState> it = collection.iterator();
        while (it.hasNext()) {
            builderListMultiBuilder.addValue((CharSequence) it.next().toString());
        }
        write(builderListMultiBuilder.build());
    }
}
