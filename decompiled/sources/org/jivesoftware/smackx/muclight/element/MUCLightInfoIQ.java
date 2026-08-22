package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightInfoIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#info";
    private final MUCLightRoomConfiguration configuration;
    private final HashMap<Jid, MUCLightAffiliation> occupants;
    private final String version;

    public MUCLightInfoIQ(String str, MUCLightRoomConfiguration mUCLightRoomConfiguration, HashMap<Jid, MUCLightAffiliation> map) {
        super("query", "urn:xmpp:muclight:0#info");
        this.version = str;
        this.configuration = mUCLightRoomConfiguration;
        this.occupants = map;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("version", this.version);
        iQChildElementXmlStringBuilder.append(new MUCLightElements.ConfigurationElement(this.configuration));
        iQChildElementXmlStringBuilder.append(new MUCLightElements.OccupantsElement(this.occupants));
        return iQChildElementXmlStringBuilder;
    }

    public String getVersion() {
        return this.version;
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }

    public HashMap<Jid, MUCLightAffiliation> getOccupants() {
        return this.occupants;
    }
}
