package com.google.firebase.database;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class DatabaseRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseDatabaseComponent.class).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.optional(InternalAuthProvider.class)).factory(DatabaseRegistrar$$Lambda$1.instance).build(), LibraryVersionComponent.create("fire-rtdb", "19.1.0"));
    }

    static /* synthetic */ FirebaseDatabaseComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseDatabaseComponent((FirebaseApp) componentContainer.get(FirebaseApp.class), (InternalAuthProvider) componentContainer.get(InternalAuthProvider.class));
    }
}
