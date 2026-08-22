package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SimpleIQ extends IQ {
    protected SimpleIQ(String str, String str2) {
        super(str, str2);
    }

    protected SimpleIQ(IqData iqData, String str, String str2) {
        super(iqData, str, str2);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
