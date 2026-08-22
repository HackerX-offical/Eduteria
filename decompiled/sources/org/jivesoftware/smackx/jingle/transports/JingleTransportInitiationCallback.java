package org.jivesoftware.smackx.jingle.transports;

import org.jivesoftware.smackx.bytestreams.BytestreamSession;

/* JADX INFO: loaded from: classes10.dex */
public interface JingleTransportInitiationCallback {
    void onException(Exception exc);

    void onSessionInitiated(BytestreamSession bytestreamSession);
}
