package org.jivesoftware.smackx.iot.discovery.element;

import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class IoTMine extends IQ {
    public static final String ELEMENT = "mine";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final List<Tag> metaTags;
    private final boolean publicThing;

    public IoTMine(Collection<Tag> collection, boolean z) {
        this((List<Tag>) new ArrayList(collection), z);
    }

    public IoTMine(List<Tag> list, boolean z) {
        super(ELEMENT, "urn:xmpp:iot:discovery");
        this.metaTags = list;
        this.publicThing = z;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue(HeaderConstants.PUBLIC, this.publicThing);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append(this.metaTags);
        return iQChildElementXmlStringBuilder;
    }
}
