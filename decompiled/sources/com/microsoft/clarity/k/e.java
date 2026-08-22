package com.microsoft.clarity.k;

import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.ingest.SerializedSessionPayload;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.mutation.BaseMutationEvent;
import com.microsoft.clarity.models.repositories.RepositoryAsset;
import com.microsoft.clarity.n.f;
import com.microsoft.clarity.n.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements b {
    public static final List<AssetType> i = CollectionsKt.listOf((Object[]) new AssetType[]{AssetType.Image, AssetType.Typeface, AssetType.Web});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.k.a f1053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f1054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f1055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f1056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f1057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f1058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1060h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1061a;

        static {
            int[] iArr = new int[AssetType.values().length];
            iArr[AssetType.Image.ordinal()] = 1;
            iArr[AssetType.Typeface.ordinal()] = 2;
            iArr[AssetType.Web.ordinal()] = 3;
            iArr[AssetType.Unsupported.ordinal()] = 4;
            f1061a = iArr;
        }
    }

    public e(com.microsoft.clarity.k.a metadataRepository, com.microsoft.clarity.m.a frameStore, com.microsoft.clarity.m.a analyticsStore, com.microsoft.clarity.m.a imageStore, com.microsoft.clarity.m.a typefaceStore, com.microsoft.clarity.m.a webStore) {
        Intrinsics.checkNotNullParameter(metadataRepository, "metadataRepository");
        Intrinsics.checkNotNullParameter(frameStore, "frameStore");
        Intrinsics.checkNotNullParameter(analyticsStore, "analyticsStore");
        Intrinsics.checkNotNullParameter(imageStore, "imageStore");
        Intrinsics.checkNotNullParameter(typefaceStore, "typefaceStore");
        Intrinsics.checkNotNullParameter(webStore, "webStore");
        this.f1053a = metadataRepository;
        this.f1054b = frameStore;
        this.f1055c = analyticsStore;
        this.f1056d = imageStore;
        this.f1057e = typefaceStore;
        this.f1058f = webStore;
        this.f1059g = "_";
        this.f1060h = 1;
    }

    @Override // com.microsoft.clarity.k.b
    public final int a() {
        return this.f1060h;
    }

    public final com.microsoft.clarity.m.a a(AssetType assetType) {
        int i2 = a.f1061a[assetType.ordinal()];
        if (i2 == 1) {
            return this.f1056d;
        }
        if (i2 == 2) {
            return this.f1057e;
        }
        if (i2 == 3) {
            return this.f1058f;
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("Unexpected asset type");
    }

    @Override // com.microsoft.clarity.k.b
    public final SessionMetadata a(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return this.f1053a.a(sessionId);
    }

    @Override // com.microsoft.clarity.k.b
    public final SerializedSessionPayload a(boolean z, PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        List<String> listA = a(this.f1054b, payloadMetadata);
        List<String> listA2 = a(this.f1055c, payloadMetadata);
        if (z) {
            listA = new ArrayList<>();
        }
        return new SerializedSessionPayload(listA, listA2, payloadMetadata.getPageNum(), payloadMetadata.getSequence(), payloadMetadata.getStart());
    }

    public final List<String> a(com.microsoft.clarity.m.a store, PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        List listSplit$default = StringsKt.split$default((CharSequence) store.d(b(payloadMetadata)), new String[]{"\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) obj).toString(), "")) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public final void a(com.microsoft.clarity.m.a eventStore, PayloadMetadata payloadMetadata, String serializedEvent) {
        Intrinsics.checkNotNullParameter(eventStore, "eventStore");
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        Intrinsics.checkNotNullParameter(serializedEvent, "serializedEvent");
        eventStore.a(b(payloadMetadata), serializedEvent + '\n', com.microsoft.clarity.m.c.APPEND);
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        i.b("Delete session payload " + payloadMetadata + '.');
        String strB = b(payloadMetadata);
        this.f1054b.a(strB);
        this.f1055c.a(strB);
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(PayloadMetadata payloadMetadata, WebViewAnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        Intrinsics.checkNotNullParameter(event, "event");
        a(this.f1055c, payloadMetadata, event.serialize());
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(PayloadMetadata payloadMetadata, WebViewMutationEvent event) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        Intrinsics.checkNotNullParameter(event, "event");
        a(this.f1054b, payloadMetadata, event.serialize());
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(PayloadMetadata payloadMetadata, AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        Intrinsics.checkNotNullParameter(event, "event");
        a(this.f1055c, payloadMetadata, event.serialize());
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(PayloadMetadata payloadMetadata, BaseMutationEvent event) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        Intrinsics.checkNotNullParameter(event, "event");
        a(this.f1054b, payloadMetadata, event.serialize());
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(SessionMetadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "sessionMetadata");
        i.b("Create session " + metadata.getSessionId() + '.');
        String sessionId = metadata.getSessionId();
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.f1053a.a(sessionId, metadata);
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(String sessionId, PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        i.b("Create session " + sessionId + ", page " + payloadMetadata.getPageNum() + ", sequence " + payloadMetadata.getSequence() + ", start " + payloadMetadata.getStart() + '.');
        String strB = b(payloadMetadata);
        com.microsoft.clarity.m.a aVar = this.f1054b;
        com.microsoft.clarity.m.c cVar = com.microsoft.clarity.m.c.OVERWRITE;
        aVar.a(strB, "", cVar);
        this.f1055c.a(strB, "", cVar);
    }

    public final String b(PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        return payloadMetadata.getSessionId() + '/' + payloadMetadata.getPageNum() + this.f1059g + payloadMetadata.getSequence();
    }

    @Override // com.microsoft.clarity.k.b
    public final List<RepositoryAsset> b(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        List<AssetType> list = i;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AssetType type : list) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(type, "type");
            com.microsoft.clarity.m.a aVarA = a(type);
            List listA = com.microsoft.clarity.m.a.a(aVarA, sessionId + '/', false, 2);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                String path = ((File) it.next()).getPath();
                Intrinsics.checkNotNullExpressionValue(path, "file.path");
                String filename = StringsKt.substringAfter$default(path, sessionId + '/', (String) null, 2, (Object) null);
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                Intrinsics.checkNotNullParameter(filename, "filename");
                arrayList2.add(new RepositoryAsset(type, aVarA.c(f.a(sessionId, filename)), filename));
            }
            arrayList.add(arrayList2);
        }
        return CollectionsKt.flatten(arrayList);
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(String sessionId, AssetType type, String filename) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(filename, "identifier");
        com.microsoft.clarity.m.a aVarA = a(type);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(filename, "filename");
        String strA = f.a(sessionId, filename);
        i.b("Deleting Asset " + strA + " from session " + sessionId + " repository");
        aVarA.a(strA);
    }

    @Override // com.microsoft.clarity.k.b
    public final void a(String sessionId, String filename, AssetType type, byte[] data) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(filename, "identifier");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        i.b("Save session " + sessionId + " asset " + filename);
        com.microsoft.clarity.m.a aVarA = a(type);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(filename, "filename");
        String strA = f.a(sessionId, filename);
        if (aVarA.b(strA)) {
            return;
        }
        aVarA.a(strA, data);
    }
}
