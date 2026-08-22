package org.jivesoftware.smackx.pubsub.form;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smackx.pubsub.PresenceState;
import org.jivesoftware.smackx.pubsub.SubscribeOptionFields;
import org.jivesoftware.smackx.xdata.form.FormReader;

/* JADX INFO: loaded from: classes10.dex */
public interface SubscribeFormReader extends FormReader {
    public static final String FORM_TYPE = "http://jabber.org/protocol/pubsub#subscribe_options";

    default boolean isDeliverOn() {
        return readBoolean(SubscribeOptionFields.deliver.getFieldName()).booleanValue();
    }

    default Boolean isDigestOn() {
        return readBoolean(SubscribeOptionFields.digest.getFieldName());
    }

    default Integer getDigestFrequency() {
        return readInteger(SubscribeOptionFields.digest_frequency.getFieldName());
    }

    default Date getExpiry() throws ParseException {
        return readDate(SubscribeOptionFields.expire.getFieldName());
    }

    default Boolean isIncludeBody() {
        return readBoolean(SubscribeOptionFields.include_body.getFieldName());
    }

    default List<PresenceState> getShowValues() {
        List<String> stringValues = readStringValues(SubscribeOptionFields.show_values.getFieldName());
        ArrayList arrayList = new ArrayList(stringValues.size());
        Iterator<String> it = stringValues.iterator();
        while (it.hasNext()) {
            arrayList.add(PresenceState.valueOf(it.next()));
        }
        return arrayList;
    }
}
