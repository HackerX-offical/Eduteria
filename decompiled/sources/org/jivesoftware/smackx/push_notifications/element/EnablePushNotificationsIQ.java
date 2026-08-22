package org.jivesoftware.smackx.push_notifications.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class EnablePushNotificationsIQ extends IQ {
    public static final String ELEMENT = "enable";
    public static final String NAMESPACE = "urn:xmpp:push:0";
    private final Jid jid;
    private final String node;
    private final HashMap<String, String> publishOptions;

    public EnablePushNotificationsIQ(Jid jid, String str, HashMap<String, String> map) {
        super("enable", "urn:xmpp:push:0");
        this.jid = jid;
        this.node = str;
        this.publishOptions = map;
        setType(IQ.Type.set);
    }

    public EnablePushNotificationsIQ(Jid jid, String str) {
        this(jid, str, null);
    }

    public Jid getJid() {
        return this.jid;
    }

    public String getNode() {
        return this.node;
    }

    public HashMap<String, String> getPublishOptions() {
        return this.publishOptions;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", this.jid);
        iQChildElementXmlStringBuilder.attribute(NodeElement.ELEMENT, this.node);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (this.publishOptions != null) {
            DataForm.Builder builder = DataForm.builder();
            builder.addField(FormField.buildHiddenFormType("http://jabber.org/protocol/pubsub#publish-options"));
            for (Map.Entry<String, String> entry : this.publishOptions.entrySet()) {
                TextSingleFormField.Builder builder2 = FormField.builder(entry.getKey());
                builder2.setValue(entry.getValue());
                builder.addField(builder2.build());
            }
            iQChildElementXmlStringBuilder.append(builder.build());
        }
        return iQChildElementXmlStringBuilder;
    }
}
