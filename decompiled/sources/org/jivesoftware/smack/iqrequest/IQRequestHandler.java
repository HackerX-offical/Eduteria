package org.jivesoftware.smack.iqrequest;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public interface IQRequestHandler {

    public enum Mode {
        sync,
        async
    }

    String getElement();

    Mode getMode();

    String getNamespace();

    IQ.Type getType();

    IQ handleIQRequest(IQ iq);

    default QName getQName() {
        return new QName(getNamespace(), getElement());
    }
}
