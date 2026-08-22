package org.jivesoftware.smackx.commands;

/* JADX INFO: loaded from: classes10.dex */
public class AdHocCommandNote {
    private final Type type;
    private final String value;

    public enum Type {
        info,
        warn,
        error
    }

    public AdHocCommandNote(Type type, String str) {
        this.type = type;
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public Type getType() {
        return this.type;
    }
}
