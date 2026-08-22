package org.jivesoftware.smackx.iqversion.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class Version extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:version";
    private final String name;
    private String os;
    private final String version;

    public Version() {
        super("query", NAMESPACE);
        this.name = null;
        this.version = null;
        setType(IQ.Type.get);
    }

    public Version(Jid jid) {
        this();
        setTo(jid);
    }

    public Version(String str, String str2) {
        this(str, str2, null);
    }

    public Version(String str, String str2, String str3) {
        super("query", NAMESPACE);
        setType(IQ.Type.result);
        this.name = (String) StringUtils.requireNotNullNorEmpty(str, "name must not be null");
        this.version = (String) StringUtils.requireNotNullNorEmpty(str2, "version must not be null");
        this.os = str3;
    }

    public Version(Version version) {
        this(version.name, version.version, version.os);
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String str) {
        this.os = str;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("name", this.name);
        iQChildElementXmlStringBuilder.optElement("version", this.version);
        iQChildElementXmlStringBuilder.optElement("os", this.os);
        return iQChildElementXmlStringBuilder;
    }

    public static Version createResultFor(Stanza stanza, Version version) {
        Version version2 = new Version(version);
        version2.setStanzaId(stanza.getStanzaId());
        version2.setTo(stanza.getFrom());
        return version2;
    }
}
