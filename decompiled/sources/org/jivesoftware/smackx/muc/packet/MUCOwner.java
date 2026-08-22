package org.jivesoftware.smackx.muc.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class MUCOwner extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/muc#owner";
    private Destroy destroy;
    private final List<MUCItem> items;

    public MUCOwner() {
        super("query", NAMESPACE);
        this.items = new ArrayList();
    }

    public List<MUCItem> getItems() {
        List<MUCItem> listUnmodifiableList;
        synchronized (this.items) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.items));
        }
        return listUnmodifiableList;
    }

    public Destroy getDestroy() {
        return this.destroy;
    }

    public void setDestroy(Destroy destroy) {
        this.destroy = destroy;
    }

    public void addItem(MUCItem mUCItem) {
        synchronized (this.items) {
            this.items.add(mUCItem);
        }
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.items) {
            Iterator<MUCItem> it = this.items.iterator();
            while (it.hasNext()) {
                iQChildElementXmlStringBuilder.append(it.next().toXML());
            }
        }
        iQChildElementXmlStringBuilder.optElement(getDestroy());
        return iQChildElementXmlStringBuilder;
    }
}
