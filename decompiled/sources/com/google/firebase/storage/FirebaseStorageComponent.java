package com.google.firebase.storage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
class FirebaseStorageComponent {
    private final FirebaseApp app;
    private final Provider<InternalAuthProvider> authProvider;
    private final Map<String, FirebaseStorage> instances = new HashMap();

    FirebaseStorageComponent(FirebaseApp firebaseApp, Provider<InternalAuthProvider> provider) {
        this.app = firebaseApp;
        this.authProvider = provider;
    }

    synchronized FirebaseStorage get(String str) {
        FirebaseStorage firebaseStorage;
        firebaseStorage = this.instances.get(str);
        if (firebaseStorage == null) {
            firebaseStorage = new FirebaseStorage(str, this.app, this.authProvider);
            this.instances.put(str, firebaseStorage);
        }
        return firebaseStorage;
    }

    synchronized void clearInstancesForTesting() {
        this.instances.clear();
    }
}
