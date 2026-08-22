package org.jivesoftware.smackx.muclight;

import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public enum MUCLightAffiliation {
    owner,
    member,
    none;

    public static MUCLightAffiliation fromString(String str) {
        if (str == null) {
            return null;
        }
        return valueOf(str.toLowerCase(Locale.US));
    }
}
