package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightChangeAffiliationsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#affiliations";
    private HashMap<Jid, MUCLightAffiliation> affiliations;

    public MUCLightChangeAffiliationsIQ(Jid jid, HashMap<Jid, MUCLightAffiliation> map) {
        super("query", "urn:xmpp:muclight:0#affiliations");
        setType(IQ.Type.set);
        setTo(jid);
        this.affiliations = map;
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations() {
        return this.affiliations;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        HashMap<Jid, MUCLightAffiliation> map = this.affiliations;
        if (map != null) {
            for (Map.Entry<Jid, MUCLightAffiliation> entry : map.entrySet()) {
                iQChildElementXmlStringBuilder.append(new MUCLightElements.UserWithAffiliationElement(entry.getKey(), entry.getValue()));
            }
        }
        return iQChildElementXmlStringBuilder;
    }
}
