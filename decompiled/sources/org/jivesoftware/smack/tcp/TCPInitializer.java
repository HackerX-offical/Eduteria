package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.initializer.UrlInitializer;
import org.jivesoftware.smack.sm.StreamManagementModuleDescriptor;

/* JADX INFO: loaded from: classes10.dex */
public class TCPInitializer extends UrlInitializer {
    static {
        SmackConfiguration.addModule(StreamManagementModuleDescriptor.class);
        SmackConfiguration.addModule(XmppTcpTransportModuleDescriptor.class);
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getProvidersUri() {
        return "classpath:org.jivesoftware.smack.tcp/smacktcp.providers";
    }
}
