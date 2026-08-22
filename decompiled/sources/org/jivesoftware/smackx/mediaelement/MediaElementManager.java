package org.jivesoftware.smackx.mediaelement;

import org.jivesoftware.smackx.mediaelement.provider.MediaElementProvider;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProviderManager;

/* JADX INFO: loaded from: classes10.dex */
public class MediaElementManager {
    static {
        FormFieldChildElementProviderManager.addFormFieldChildElementProvider(new MediaElementProvider());
    }
}
