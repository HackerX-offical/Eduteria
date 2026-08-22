package org.pgpainless.algorithm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public enum KeyFlag {
    CERTIFY_OTHER(1),
    SIGN_DATA(2),
    ENCRYPT_COMMS(4),
    ENCRYPT_STORAGE(8),
    SPLIT(16),
    AUTHENTICATION(32),
    SHARED(128);

    private final int flag;

    KeyFlag(int i) {
        this.flag = i;
    }

    public int getFlag() {
        return this.flag;
    }

    public static List<KeyFlag> fromBitmask(int i) {
        ArrayList arrayList = new ArrayList();
        for (KeyFlag keyFlag : values()) {
            if ((keyFlag.flag & i) != 0) {
                arrayList.add(keyFlag);
            }
        }
        return arrayList;
    }

    public static int toBitmask(KeyFlag... keyFlagArr) {
        int flag = 0;
        for (KeyFlag keyFlag : keyFlagArr) {
            flag |= keyFlag.getFlag();
        }
        return flag;
    }

    public static boolean hasKeyFlag(int i, KeyFlag keyFlag) {
        return (i & keyFlag.getFlag()) == keyFlag.getFlag();
    }
}
