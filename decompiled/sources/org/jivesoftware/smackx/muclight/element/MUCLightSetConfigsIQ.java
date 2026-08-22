package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightSetConfigsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#configuration";
    private HashMap<String, String> customConfigs;
    private String roomName;
    private String subject;

    public MUCLightSetConfigsIQ(Jid jid, String str, String str2, HashMap<String, String> map) {
        super("query", "urn:xmpp:muclight:0#configuration");
        this.roomName = str;
        this.subject = str2;
        this.customConfigs = map;
        setType(IQ.Type.set);
        setTo(jid);
    }

    public MUCLightSetConfigsIQ(Jid jid, String str, HashMap<String, String> map) {
        this(jid, str, null, map);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("roomname", this.roomName);
        iQChildElementXmlStringBuilder.optElement("subject", this.subject);
        HashMap<String, String> map = this.customConfigs;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                iQChildElementXmlStringBuilder.element(entry.getKey(), entry.getValue());
            }
        }
        return iQChildElementXmlStringBuilder;
    }
}
