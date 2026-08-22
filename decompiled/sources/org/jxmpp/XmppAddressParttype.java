package org.jxmpp;

import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public enum XmppAddressParttype {
    localpart,
    domainpart,
    resourcepart;

    final String capitalizedName;

    XmppAddressParttype() {
        String strName = name();
        this.capitalizedName = strName.substring(0, 1).toUpperCase(Locale.US) + strName.substring(1);
    }

    public String getCapitalizedName() {
        return this.capitalizedName;
    }
}
