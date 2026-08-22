package org.jivesoftware.smackx.ox.listener;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.pgpainless.decryption_verification.OpenPgpMetadata;

/* JADX INFO: loaded from: classes10.dex */
public interface CryptElementReceivedListener {
    void cryptElementReceived(OpenPgpContact openPgpContact, Message message, CryptElement cryptElement, OpenPgpMetadata openPgpMetadata);
}
