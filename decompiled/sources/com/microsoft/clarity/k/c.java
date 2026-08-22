package com.microsoft.clarity.k;

import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.n.i;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f1051a;

    public c(com.microsoft.clarity.m.a metadataStore) {
        Intrinsics.checkNotNullParameter(metadataStore, "metadataStore");
        this.f1051a = metadataStore;
    }

    @Override // com.microsoft.clarity.k.a
    public final SessionMetadata a(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (!this.f1051a.b(sessionId)) {
            return null;
        }
        return SessionMetadata.INSTANCE.fromJson(this.f1051a.d(sessionId));
    }

    @Override // com.microsoft.clarity.k.a
    public final void a(String sessionId, SessionMetadata metadata) throws JSONException {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        i.b("Setting session " + sessionId + " metadata.");
        this.f1051a.a(sessionId, metadata.toJson(), com.microsoft.clarity.m.c.OVERWRITE);
    }
}
