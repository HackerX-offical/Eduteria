package org.jivesoftware.smackx.bytestreams.ibb;

import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;

/* JADX INFO: loaded from: classes10.dex */
public abstract class InBandBytestreamListener implements BytestreamListener {
    public abstract void incomingBytestreamRequest(InBandBytestreamRequest inBandBytestreamRequest);

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamListener
    public void incomingBytestreamRequest(BytestreamRequest bytestreamRequest) {
        incomingBytestreamRequest((InBandBytestreamRequest) bytestreamRequest);
    }
}
