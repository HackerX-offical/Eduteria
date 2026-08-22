package org.jivesoftware.smackx.pubsub.util;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.pubsub.FormNode;
import org.jivesoftware.smackx.pubsub.PubSubElementType;
import org.jivesoftware.smackx.pubsub.form.ConfigureForm;

/* JADX INFO: loaded from: classes10.dex */
public class NodeUtils {
    public static ConfigureForm getFormFromPacket(Stanza stanza, PubSubElementType pubSubElementType) {
        return new ConfigureForm(((FormNode) stanza.getExtensionElement(pubSubElementType.getElementName(), pubSubElementType.getNamespace().getXmlns())).getForm());
    }
}
