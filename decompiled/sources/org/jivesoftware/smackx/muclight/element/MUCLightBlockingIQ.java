package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightBlockingIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#blocking";
    private final HashMap<Jid, Boolean> rooms;
    private final HashMap<Jid, Boolean> users;

    public MUCLightBlockingIQ(HashMap<Jid, Boolean> map, HashMap<Jid, Boolean> map2) {
        super("query", NAMESPACE);
        this.rooms = map;
        this.users = map2;
    }

    public HashMap<Jid, Boolean> getRooms() {
        return this.rooms;
    }

    public HashMap<Jid, Boolean> getUsers() {
        return this.users;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        HashMap<Jid, Boolean> map = this.rooms;
        if (map != null) {
            parseBlocking(iQChildElementXmlStringBuilder, map, true);
        }
        HashMap<Jid, Boolean> map2 = this.users;
        if (map2 != null) {
            parseBlocking(iQChildElementXmlStringBuilder, map2, false);
        }
        return iQChildElementXmlStringBuilder;
    }

    private static void parseBlocking(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder, HashMap<Jid, Boolean> map, boolean z) {
        for (Map.Entry<Jid, Boolean> entry : map.entrySet()) {
            iQChildElementXmlStringBuilder.append(new MUCLightElements.BlockingElement(entry.getKey(), entry.getValue(), Boolean.valueOf(z)));
        }
    }
}
