package org.jivesoftware.smackx.xdata.provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes10.dex */
public class FormFieldChildElementProviderManager {
    private static final Map<QName, FormFieldChildElementProvider<?>> providers = new ConcurrentHashMap();

    public static void addFormFieldChildElementProvider(FormFieldChildElementProvider<?>... formFieldChildElementProviderArr) {
        for (FormFieldChildElementProvider<?> formFieldChildElementProvider : formFieldChildElementProviderArr) {
            providers.put(formFieldChildElementProvider.getQName(), formFieldChildElementProvider);
        }
    }

    public static FormFieldChildElementProvider<?> addFormFieldChildElementProvider(QName qName, FormFieldChildElementProvider<?> formFieldChildElementProvider) {
        return providers.put(qName, formFieldChildElementProvider);
    }

    public static FormFieldChildElementProvider<?> getFormFieldChildElementProvider(QName qName) {
        return providers.get(qName);
    }
}
