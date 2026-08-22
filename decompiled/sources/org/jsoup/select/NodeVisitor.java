package org.jsoup.select;

import org.jsoup.nodes.Node;

/* JADX INFO: loaded from: classes10.dex */
public interface NodeVisitor {
    void head(Node node, int i);

    default void tail(Node node, int i) {
    }
}
