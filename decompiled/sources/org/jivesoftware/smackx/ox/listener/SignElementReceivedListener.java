package org.jivesoftware.smackx.ox.listener;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.pgpainless.decryption_verification.OpenPgpMetadata;

/* JADX INFO: loaded from: classes10.dex */
public interface SignElementReceivedListener {
    void signElementReceived(OpenPgpContact openPgpContact, Message message, SignElement signElement, OpenPgpMetadata openPgpMetadata);
}
