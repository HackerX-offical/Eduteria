package org.jivesoftware.smackx.muclight.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightConfigurationIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#configuration";
    private final MUCLightRoomConfiguration configuration;
    private final String version;

    public MUCLightConfigurationIQ(String str, MUCLightRoomConfiguration mUCLightRoomConfiguration) {
        super("query", "urn:xmpp:muclight:0#configuration");
        this.version = str;
        this.configuration = mUCLightRoomConfiguration;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("version", this.version);
        iQChildElementXmlStringBuilder.append(new MUCLightElements.ConfigurationElement(this.configuration));
        return iQChildElementXmlStringBuilder;
    }

    public String getVersion() {
        return this.version;
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }
}
