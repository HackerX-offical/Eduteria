package org.jivesoftware.smackx.iot.control.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class IoTSetRequest extends IQ {
    public static final String ELEMENT = "set";
    public static final String NAMESPACE = "urn:xmpp:iot:control";
    private final Collection<SetData> setData;

    public IoTSetRequest(Collection<? extends SetData> collection) {
        super("set", "urn:xmpp:iot:control");
        setType(IQ.Type.set);
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<? extends SetData> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.setData = Collections.unmodifiableCollection(arrayList);
    }

    public Collection<SetData> getSetData() {
        return this.setData;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append(this.setData);
        return iQChildElementXmlStringBuilder;
    }
}
