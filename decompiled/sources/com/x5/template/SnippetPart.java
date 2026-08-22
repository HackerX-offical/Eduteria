package com.x5.template;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes9.dex */
public class SnippetPart {
    private boolean isLiteral = false;
    protected String snippetText;

    public boolean isTag() {
        return false;
    }

    public SnippetPart(String str) {
        this.snippetText = str;
    }

    public String getText() {
        return this.snippetText;
    }

    public void setText(String str) {
        this.snippetText = str;
    }

    public void setLiteral(boolean z) {
        this.isLiteral = z;
    }

    public boolean isLiteral() {
        return this.isLiteral;
    }

    public boolean depthCheckFails(int i, Writer writer) throws IOException {
        if (i < 17) {
            return false;
        }
        writer.append("[**ERR** max template recursions: 17]");
        return true;
    }

    public void render(Writer writer, Chunk chunk, String str, int i) throws IOException {
        if (this.isLiteral) {
            writer.append((CharSequence) this.snippetText);
        }
    }

    public String toString() {
        return this.snippetText;
    }
}
