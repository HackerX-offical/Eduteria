package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    String toString(String str) {
        String str2 = str + "<value>: " + this.value + "\n";
        if (this.children.isEmpty()) {
            return str2 + str + "<empty>";
        }
        for (Map.Entry<ChildKey, TreeNode<T>> entry : this.children.entrySet()) {
            str2 = str2 + str + entry.getKey() + ":\n" + entry.getValue().toString(str + "\t") + "\n";
        }
        return str2;
    }
}
