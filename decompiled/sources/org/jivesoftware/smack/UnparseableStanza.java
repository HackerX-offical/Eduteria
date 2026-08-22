package org.jivesoftware.smack;

/* JADX INFO: loaded from: classes10.dex */
public class UnparseableStanza {
    private final CharSequence content;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Exception f1489e;

    UnparseableStanza(CharSequence charSequence, Exception exc) {
        this.content = charSequence;
        this.f1489e = exc;
    }

    public Exception getParsingException() {
        return this.f1489e;
    }

    public CharSequence getContent() {
        return this.content;
    }
}
