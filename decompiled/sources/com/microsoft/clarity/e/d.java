package com.microsoft.clarity.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.display.common.ImageSize;
import com.microsoft.clarity.models.ingest.AssetCheck;
import com.microsoft.clarity.models.ingest.AssetMetadata;
import com.microsoft.clarity.models.repositories.RepositoryAsset;
import com.microsoft.clarity.n.l;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.microsoft.clarity.l.a f755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.microsoft.clarity.k.a f756c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f757a;

        static {
            int[] iArr = new int[AssetType.values().length];
            iArr[AssetType.Web.ordinal()] = 1;
            iArr[AssetType.Image.ordinal()] = 2;
            iArr[AssetType.Typeface.ordinal()] = 3;
            f757a = iArr;
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SessionMetadata f759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RepositoryAsset f760c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SessionMetadata sessionMetadata, RepositoryAsset repositoryAsset) {
            super(0);
            this.f759b = sessionMetadata;
            this.f760c = repositoryAsset;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(d.this.a(this.f759b, this.f760c));
        }
    }

    public d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f754a = context;
        com.microsoft.clarity.g.g gVar = com.microsoft.clarity.b.a.f689a;
        this.f755b = a.C0184a.a(context);
        this.f756c = a.C0184a.b(context);
    }

    public static final Boolean a(com.microsoft.clarity.k.b sessionRepository, SessionMetadata sessionMetadata, RepositoryAsset it, d this$0) {
        Intrinsics.checkNotNullParameter(sessionRepository, "$sessionRepository");
        Intrinsics.checkNotNullParameter(sessionMetadata, "$sessionMetadata");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean zBooleanValue = ((Boolean) l.a(this$0.new b(sessionMetadata, it))).booleanValue();
        if (zBooleanValue) {
            sessionRepository.a(sessionMetadata.getSessionId(), it.getType(), it.getId());
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public final boolean a(SessionMetadata sessionMetadata, RepositoryAsset repositoryAsset) {
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        Intrinsics.checkNotNullParameter(repositoryAsset, "repositoryAsset");
        int i = a.f757a[repositoryAsset.getType().ordinal()];
        if (i == 1) {
            return this.f755b.a(sessionMetadata.getIngestUrl(), sessionMetadata.getProjectId(), repositoryAsset.getId(), repositoryAsset.getData());
        }
        if (i != 2) {
            return i != 3 ? this.f755b.a(sessionMetadata, repositoryAsset.getId(), repositoryAsset.getData(), new AssetMetadata(repositoryAsset.getType(), null, null, 6, null)) : this.f755b.a(sessionMetadata, repositoryAsset.getId(), com.microsoft.clarity.n.b.a(repositoryAsset.getData()), new AssetMetadata(repositoryAsset.getType(), null, null, 6, null));
        }
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        Intrinsics.checkNotNullParameter(repositoryAsset, "repositoryAsset");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        ImageSize imageSizeA = com.microsoft.clarity.n.a.a(repositoryAsset.getData());
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(repositoryAsset.getData(), 0, repositoryAsset.getData().length, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapDecodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] compressedBytes = byteArrayOutputStream.toByteArray();
        bitmapDecodeByteArray.recycle();
        com.microsoft.clarity.l.a aVar = this.f755b;
        String id = repositoryAsset.getId();
        Intrinsics.checkNotNullExpressionValue(compressedBytes, "compressedBytes");
        return aVar.a(sessionMetadata, id, compressedBytes, new AssetMetadata(AssetType.Image, Integer.valueOf(imageSizeA.getWidth()), Integer.valueOf(imageSizeA.getHeight())));
    }

    public final boolean a(final com.microsoft.clarity.k.b sessionRepository, final SessionMetadata sessionMetadata) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        try {
            List<RepositoryAsset> listB = sessionRepository.b(sessionMetadata.getSessionId());
            HashSet hashSet = new HashSet();
            ArrayList<RepositoryAsset> arrayList = new ArrayList();
            for (Object obj : listB) {
                if (hashSet.add(((RepositoryAsset) obj).getId())) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (RepositoryAsset repositoryAsset : arrayList) {
                arrayList2.add(repositoryAsset.getType() == AssetType.Web ? new AssetCheck(null, repositoryAsset.getId(), "all", repositoryAsset.getType().ordinal()) : new AssetCheck(repositoryAsset.getId(), null, null, repositoryAsset.getType().ordinal()));
            }
            Map mapA = this.f755b.a(sessionMetadata.getIngestUrl(), sessionMetadata.getProjectId(), arrayList2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapA.entrySet()) {
                if (!((Boolean) entry.getValue()).booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList<RepositoryAsset> arrayList3 = new ArrayList();
            for (Object obj2 : listB) {
                if (!linkedHashMap.containsKey(((RepositoryAsset) obj2).getId())) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (RepositoryAsset repositoryAsset2 : arrayList3) {
                sessionRepository.a(sessionMetadata.getSessionId(), repositoryAsset2.getType(), repositoryAsset2.getId());
                arrayList4.add(Unit.INSTANCE);
            }
            ArrayList<RepositoryAsset> arrayList5 = new ArrayList();
            for (Object obj3 : listB) {
                if (linkedHashMap.containsKey(((RepositoryAsset) obj3).getId())) {
                    arrayList5.add(obj3);
                }
            }
            ArrayList<CompletableFuture> arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            for (final RepositoryAsset repositoryAsset3 : arrayList5) {
                arrayList6.add(CompletableFuture.supplyAsync(new Supplier() { // from class: com.microsoft.clarity.e.d$$ExternalSyntheticLambda0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return d.a(sessionRepository, sessionMetadata, repositoryAsset3, this);
                    }
                }));
            }
            while (true) {
                boolean z = true;
                for (CompletableFuture completableFuture : arrayList6) {
                    if (z) {
                        Object obj4 = completableFuture.get();
                        Intrinsics.checkNotNullExpressionValue(obj4, "success2.get()");
                        if (((Boolean) obj4).booleanValue()) {
                            break;
                        }
                    }
                    z = false;
                }
                return z;
            }
        } catch (Exception e2) {
            com.microsoft.clarity.n.i.c(com.microsoft.clarity.a.b.a("Assets upload failed for session ").append(sessionMetadata.getSessionId()).append(" with Error: ").append(e2).append('.').toString());
            return false;
        }
    }

    public final boolean a(PayloadMetadata payloadMetadata) throws com.microsoft.clarity.c.f {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        com.microsoft.clarity.n.i.b("Upload payload " + payloadMetadata + '.');
        String sessionId = payloadMetadata.getSessionId();
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionMetadata sessionMetadata = this.f756c.a(sessionId);
        if (sessionMetadata == null) {
            com.microsoft.clarity.n.i.e(com.microsoft.clarity.a.b.a("Session ").append(payloadMetadata.getSessionId()).append(" metadata was deleted before uploading").toString());
            return true;
        }
        com.microsoft.clarity.g.g gVar = com.microsoft.clarity.b.a.f689a;
        com.microsoft.clarity.k.b sessionRepository = a.C0184a.a(this.f754a, sessionMetadata.getLocalStorageVersion());
        if (!sessionMetadata.getLeanSession() && !a(sessionRepository, sessionMetadata)) {
            com.microsoft.clarity.n.i.c(com.microsoft.clarity.a.b.a("Upload session ").append(payloadMetadata.getSessionId()).append(" assets failed.").toString());
        }
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        if (!this.f755b.a(sessionRepository.a(sessionMetadata.getLeanSession(), payloadMetadata), sessionMetadata)) {
            com.microsoft.clarity.n.i.c("Upload payload " + payloadMetadata + '.');
            return false;
        }
        com.microsoft.clarity.n.i.b("Upload payload " + payloadMetadata + '.');
        sessionRepository.a(payloadMetadata);
        return true;
    }
}
