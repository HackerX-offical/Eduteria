package org.jivesoftware.smackx.pubsub;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.pubsub.form.FilledConfigureForm;

/* JADX INFO: loaded from: classes10.dex */
public class ConfigurationEvent extends NodeExtension implements EmbeddedPacketExtension {
    private final FilledConfigureForm form;

    public ConfigurationEvent(String str) {
        this(str, null);
    }

    public ConfigurationEvent(String str, FilledConfigureForm filledConfigureForm) {
        super(PubSubElementType.CONFIGURATION, str);
        this.form = filledConfigureForm;
    }

    public FilledConfigureForm getConfiguration() {
        return this.form;
    }

    @Override // org.jivesoftware.smackx.pubsub.EmbeddedPacketExtension
    public List<ExtensionElement> getExtensions() {
        return getConfiguration() == null ? Collections.emptyList() : Arrays.asList(getConfiguration().getDataForm());
    }
}
