package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightAffiliationsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#affiliations";
    private HashMap<Jid, MUCLightAffiliation> affiliations;
    private final String version;

    public MUCLightAffiliationsIQ(String str, HashMap<Jid, MUCLightAffiliation> map) {
        super("query", "urn:xmpp:muclight:0#affiliations");
        this.version = str;
        this.affiliations = map;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("version", this.version);
        for (Map.Entry<Jid, MUCLightAffiliation> entry : this.affiliations.entrySet()) {
            iQChildElementXmlStringBuilder.append(new MUCLightElements.UserWithAffiliationElement(entry.getKey(), entry.getValue()));
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getVersion() {
        return this.version;
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations() {
        return this.affiliations;
    }
}
