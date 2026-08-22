package org.jxmpp.stringprep;

/* JADX INFO: loaded from: classes10.dex */
public interface XmppStringprep {
    String domainprep(String str) throws XmppStringprepException;

    String localprep(String str) throws XmppStringprepException;

    String resourceprep(String str) throws XmppStringprepException;
}
