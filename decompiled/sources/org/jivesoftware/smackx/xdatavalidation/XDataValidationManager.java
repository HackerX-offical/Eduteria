package org.jivesoftware.smackx.xdatavalidation;

import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProviderManager;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;
import org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider;

/* JADX INFO: loaded from: classes10.dex */
public class XDataValidationManager {
    static {
        FormFieldChildElementProviderManager.addFormFieldChildElementProvider(new DataValidationProvider());
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.xdatavalidation.XDataValidationManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(ValidateElement.NAMESPACE);
            }
        });
    }
}
