package org.jivesoftware.smackx.httpfileupload.element;

import java.net.URL;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class Slot_V0_2 extends Slot {
    public static final String NAMESPACE = "urn:xmpp:http:upload";

    public Slot_V0_2(URL url, URL url2) {
        super(url, url2, null, "urn:xmpp:http:upload");
    }

    @Override // org.jivesoftware.smackx.httpfileupload.element.Slot, org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.element("put", this.putUrl.toString());
        iQChildElementXmlStringBuilder.element("get", this.getUrl.toString());
        return iQChildElementXmlStringBuilder;
    }
}
