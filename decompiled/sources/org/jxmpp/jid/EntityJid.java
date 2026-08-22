package org.jxmpp.jid;

import org.jxmpp.jid.parts.Localpart;

/* JADX INFO: loaded from: classes10.dex */
public interface EntityJid extends Jid {
    EntityBareJid asEntityBareJid();

    String asEntityBareJidString();

    Localpart getLocalpart();
}
