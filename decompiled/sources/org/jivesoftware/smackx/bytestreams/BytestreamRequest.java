package org.jivesoftware.smackx.bytestreams;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Exception;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface BytestreamRequest {
    BytestreamSession accept() throws SmackException.NotConnectedException, InterruptedException, Socks5Exception.NoSocks5StreamHostsProvided, Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host, XMPPException.XMPPErrorException;

    Jid getFrom();

    String getSessionID();

    void reject() throws SmackException.NotConnectedException, InterruptedException;
}
