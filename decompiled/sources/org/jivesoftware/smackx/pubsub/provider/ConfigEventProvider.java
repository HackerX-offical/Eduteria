package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.ConfigurationEvent;
import org.jivesoftware.smackx.pubsub.form.FilledConfigureForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class ConfigEventProvider extends EmbeddedExtensionProvider<ConfigurationEvent> {
    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    protected /* bridge */ /* synthetic */ ExtensionElement createReturnExtension(String str, String str2, Map map, List list) {
        return createReturnExtension(str, str2, (Map<String, String>) map, (List<? extends ExtensionElement>) list);
    }

    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    protected ConfigurationEvent createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        if (list.size() == 0) {
            return new ConfigurationEvent(map.get(NodeElement.ELEMENT));
        }
        return new ConfigurationEvent(map.get(NodeElement.ELEMENT), new FilledConfigureForm((DataForm) list.iterator().next()));
    }
}
