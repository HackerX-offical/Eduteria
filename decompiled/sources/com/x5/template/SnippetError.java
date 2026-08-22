package com.x5.template;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes9.dex */
public class SnippetError extends SnippetPart {
    public SnippetError(String str) {
        super(str);
        super.setLiteral(true);
    }

    @Override // com.x5.template.SnippetPart
    public void render(Writer writer, Chunk chunk, String str, int i) throws IOException {
        if (chunk == null || chunk.renderErrorsToOutput()) {
            writer.append((CharSequence) this.snippetText);
        }
    }
}
