package org.jivesoftware.smack.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class ExtendedAppendable implements Appendable {
    private final Appendable appendable;

    public ExtendedAppendable(Appendable appendable) {
        this.appendable = appendable;
    }

    @Override // java.lang.Appendable
    public ExtendedAppendable append(CharSequence charSequence) throws IOException {
        this.appendable.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public ExtendedAppendable append(CharSequence charSequence, int i, int i2) throws IOException {
        this.appendable.append(charSequence, i, i2);
        return this;
    }

    @Override // java.lang.Appendable
    public ExtendedAppendable append(char c2) throws IOException {
        this.appendable.append(c2);
        return this;
    }

    public ExtendedAppendable append(boolean z) throws IOException {
        this.appendable.append(String.valueOf(z));
        return this;
    }

    public ExtendedAppendable append(int i) throws IOException {
        this.appendable.append(String.valueOf(i));
        return this;
    }
}
