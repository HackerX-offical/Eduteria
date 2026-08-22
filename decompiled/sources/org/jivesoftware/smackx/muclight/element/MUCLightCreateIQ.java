package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightCreateIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#create";
    private MUCLightRoomConfiguration configuration;
    private final HashMap<Jid, MUCLightAffiliation> occupants;

    public MUCLightCreateIQ(EntityJid entityJid, String str, String str2, HashMap<String, String> map, List<Jid> list) {
        super("query", NAMESPACE);
        this.configuration = new MUCLightRoomConfiguration(str, str2, map);
        this.occupants = new HashMap<>();
        Iterator<Jid> it = list.iterator();
        while (it.hasNext()) {
            this.occupants.put(it.next(), MUCLightAffiliation.member);
        }
        setType(IQ.Type.set);
        setTo(entityJid);
    }

    public MUCLightCreateIQ(EntityJid entityJid, String str, List<Jid> list) {
        this(entityJid, str, null, null, list);
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }

    public HashMap<Jid, MUCLightAffiliation> getOccupants() {
        return this.occupants;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append(new MUCLightElements.ConfigurationElement(this.configuration));
        if (!this.occupants.isEmpty()) {
            iQChildElementXmlStringBuilder.append(new MUCLightElements.OccupantsElement(this.occupants));
        }
        return iQChildElementXmlStringBuilder;
    }
}
