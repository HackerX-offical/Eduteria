package org.jivesoftware.smack.fsm;

import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public class LoginContext {
    public final String password;
    public final Resourcepart resource;
    public final String username;

    public LoginContext(String str, String str2, Resourcepart resourcepart) {
        this.username = str;
        this.password = str2;
        this.resource = resourcepart;
    }
}
