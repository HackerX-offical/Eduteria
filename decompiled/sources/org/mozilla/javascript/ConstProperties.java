package org.mozilla.javascript;

/* JADX INFO: loaded from: classes10.dex */
public interface ConstProperties {
    void defineConst(String str, Scriptable scriptable);

    boolean isConst(String str);

    void putConst(String str, Scriptable scriptable, Object obj);
}
