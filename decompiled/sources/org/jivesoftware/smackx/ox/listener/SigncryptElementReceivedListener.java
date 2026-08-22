package org.jivesoftware.smackx.ox.listener;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.pgpainless.decryption_verification.OpenPgpMetadata;

/* JADX INFO: loaded from: classes10.dex */
public interface SigncryptElementReceivedListener {
    void signcryptElementReceived(OpenPgpContact openPgpContact, Message message, SigncryptElement signcryptElement, OpenPgpMetadata openPgpMetadata);
}
