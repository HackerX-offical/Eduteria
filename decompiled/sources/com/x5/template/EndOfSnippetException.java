package com.x5.template;

/* JADX INFO: loaded from: classes9.dex */
public class EndOfSnippetException extends Exception {
    private String line;

    public EndOfSnippetException(String str) {
        this.line = str;
    }

    public String getRestOfLine() {
        return this.line;
    }
}
