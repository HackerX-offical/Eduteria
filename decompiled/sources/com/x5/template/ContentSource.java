package com.x5.template;

/* JADX INFO: loaded from: classes9.dex */
public interface ContentSource {
    String fetch(String str);

    String getProtocol();

    Snippet getSnippet(String str);

    boolean provides(String str);
}
