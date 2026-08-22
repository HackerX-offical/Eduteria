package org.jivesoftware.smackx.xdata.provider;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.provider.Provider;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FormFieldChildElementProvider<F extends FormFieldChildElement> extends Provider<F> {
    public abstract QName getQName();
}
