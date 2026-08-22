package org.jivesoftware.smackx.iot.data.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.iot.data.element.IoTFieldsExtension;

/* JADX INFO: loaded from: classes10.dex */
public class IoTFieldsExtensionFilter extends FlexibleStanzaTypeFilter<Message> {
    private final boolean onlyDone;
    private final int seqNr;

    public IoTFieldsExtensionFilter(int i, boolean z) {
        this.seqNr = i;
        this.onlyDone = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        IoTFieldsExtension ioTFieldsExtensionFrom = IoTFieldsExtension.from(message);
        if (ioTFieldsExtensionFrom != null && ioTFieldsExtensionFrom.getSequenceNr() == this.seqNr) {
            return !this.onlyDone || ioTFieldsExtensionFrom.isDone();
        }
        return false;
    }
}
