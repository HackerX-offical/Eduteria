package com.google.firebase.storage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class StorageRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseStorageComponent.class).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.optionalProvider((Class<?>) InternalAuthProvider.class)).factory(StorageRegistrar$$Lambda$1.instance).build(), LibraryVersionComponent.create("fire-gcs", "19.1.0"));
    }

    static /* synthetic */ FirebaseStorageComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseStorageComponent((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(InternalAuthProvider.class));
    }
}
