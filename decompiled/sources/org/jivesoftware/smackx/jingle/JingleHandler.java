package org.jivesoftware.smackx.jingle;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.jingle.element.Jingle;

/* JADX INFO: loaded from: classes10.dex */
public interface JingleHandler {
    IQ handleJingleRequest(Jingle jingle);
}
