package org.jivesoftware.smackx.carbons;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;

/* JADX INFO: loaded from: classes10.dex */
public interface CarbonCopyReceivedListener {
    void onCarbonCopyReceived(CarbonExtension.Direction direction, Message message, Message message2);
}
