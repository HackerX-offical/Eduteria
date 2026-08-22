package com.google.firebase.database;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class DatabaseRegistrar$$Lambda$1 implements ComponentFactory {
    private static final DatabaseRegistrar$$Lambda$1 instance = new DatabaseRegistrar$$Lambda$1();

    private DatabaseRegistrar$$Lambda$1() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return DatabaseRegistrar.lambda$getComponents$0(componentContainer);
    }
}
