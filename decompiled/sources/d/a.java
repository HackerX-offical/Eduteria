package d;

import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DummyExoMediaDrm;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.exoplayer.drm.OfflineLicenseHelper;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.source.MediaSource;
import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.exception.PallyConLicenseServerException;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.model.PallyConDrmConfigration;
import com.pallycon.widevine.model.PallyConDrmInformation;
import h.e;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentData f1124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OfflineLicenseHelper f1125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DrmSessionManager f1126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.c f1127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DrmSessionEventListener.EventDispatcher f1128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f1129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1130h;

    /* JADX INFO: renamed from: d.a$a, reason: collision with other inner class name */
    public static final class C0193a extends Lambda implements Function1<PallyConLicenseServerException, Unit> {

        /* JADX INFO: renamed from: d.a$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pallycon.widevine.drm.PallyConLicenseManager$2$1", f = "PallyConLicenseManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0194a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1132a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f1133b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PallyConLicenseServerException f1134c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0194a(a aVar, PallyConLicenseServerException pallyConLicenseServerException, Continuation<? super C0194a> continuation) {
                super(2, continuation);
                this.f1133b = aVar;
                this.f1134c = pallyConLicenseServerException;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0194a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0194a(this.f1133b, this.f1134c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1132a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                e.f1332f.a().a(this.f1133b.f1124b, this.f1134c);
                return Unit.INSTANCE;
            }
        }

        public C0193a() {
            super(1);
        }

        public final void a(PallyConLicenseServerException it) {
            Intrinsics.checkNotNullParameter(it, "it");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0194a(a.this, it, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConLicenseServerException pallyConLicenseServerException) {
            a(pallyConLicenseServerException);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<PallyConException, Unit> {

        /* JADX INFO: renamed from: d.a$b$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pallycon.widevine.drm.PallyConLicenseManager$3$1", f = "PallyConLicenseManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0195a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f1137b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PallyConException f1138c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0195a(a aVar, PallyConException pallyConException, Continuation<? super C0195a> continuation) {
                super(2, continuation);
                this.f1137b = aVar;
                this.f1138c = pallyConException;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0195a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0195a(this.f1137b, this.f1138c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1136a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                e.f1332f.a().a(this.f1137b.f1124b, this.f1138c);
                return Unit.INSTANCE;
            }
        }

        public b() {
            super(1);
        }

        public final void a(PallyConException it) {
            Intrinsics.checkNotNullParameter(it, "it");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0195a(a.this, it, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConException pallyConException) {
            a(pallyConException);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements DrmSessionEventListener {
        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            super.onDrmKeysLoaded(i, mediaPeriodId);
            System.out.print((Object) "onDrmKeysLoaded");
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            super.onDrmKeysRemoved(i, mediaPeriodId);
            System.out.print((Object) "onDrmKeysRemoved");
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            super.onDrmKeysRestored(i, mediaPeriodId);
            System.out.print((Object) "onDrmKeysRestored");
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
            super.onDrmSessionAcquired(i, mediaPeriodId, i2);
            System.out.print((Object) "onDrmSessionAcquired");
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            super.onDrmSessionManagerError(i, mediaPeriodId, error);
            System.out.print((Object) "onDrmSessionManagerError");
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            super.onDrmSessionReleased(i, mediaPeriodId);
            System.out.print((Object) "onDrmSessionReleased");
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.drm.PallyConLicenseManager$downloadLicense$1", f = "PallyConLicenseManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1139a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Format f1141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<byte[], Unit> f1142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException.DrmException, Unit> f1143e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Format format, Function1<? super byte[], Unit> function1, Function1<? super PallyConException.DrmException, Unit> function12, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f1141c = format;
            this.f1142d = function1;
            this.f1143e = function12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new d(this.f1141c, this.f1142d, this.f1143e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f1139a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                byte[] bArrDownloadLicense = a.this.f1125c.downloadLicense(this.f1141c);
                Intrinsics.checkNotNullExpressionValue(bArrDownloadLicense, "downloadLicense(...)");
                Function1<byte[], Unit> function1 = this.f1142d;
                if (function1 != null) {
                    function1.invoke(bArrDownloadLicense);
                }
            } catch (DrmSession.DrmSessionException e2) {
                Function1<PallyConException.DrmException, Unit> function12 = this.f1143e;
                if (function12 != null) {
                    function12.invoke(new PallyConException.DrmException(e2, "DrmSession Exception : " + e2.getMessage()));
                }
            } catch (NullPointerException e3) {
                Function1<PallyConException.DrmException, Unit> function13 = this.f1143e;
                if (function13 != null) {
                    function13.invoke(new PallyConException.DrmException(e3, "Download License Exception"));
                }
            } catch (Exception e4) {
                Function1<PallyConException.DrmException, Unit> function14 = this.f1143e;
                if (function14 != null) {
                    function14.invoke(new PallyConException.DrmException(e4, "Download License Exception"));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public a(Context context, ContentData contentData, OkHttpDataSource.Factory factory) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f1123a = context;
        this.f1124b = contentData;
        this.f1127e = new d.c(context, factory);
        this.f1128f = new DrmSessionEventListener.EventDispatcher();
        String strA = h.c.f1322a.a();
        if (contentData.getDrmConfig() != null) {
            this.f1127e.a(contentData, strA);
        }
        this.f1127e.a(new C0193a());
        this.f1127e.b(new b());
        this.f1126d = a();
        this.f1125c = new OfflineLicenseHelper(a(), this.f1128f);
        try {
            this.f1129g = Util.createHandlerForCurrentLooper();
        } catch (IllegalStateException e2) {
            System.out.print((Object) e2.getMessage());
        }
        if (this.f1129g == null) {
            this.f1129g = Util.createHandlerForCurrentOrMainLooper();
        }
        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f1128f;
        Handler handler = this.f1129g;
        Intrinsics.checkNotNull(handler);
        eventDispatcher.addEventListener(handler, new c());
    }

    public final void c() {
        this.f1126d = a();
    }

    public final DefaultDrmSessionManager a() {
        DefaultDrmSessionManager.Builder builder = new DefaultDrmSessionManager.Builder();
        PallyConDrmConfigration drmConfig = this.f1124b.getDrmConfig();
        Intrinsics.checkNotNull(drmConfig);
        DefaultDrmSessionManager defaultDrmSessionManagerBuild = builder.setUuidAndExoMediaDrmProvider(drmConfig.getUuid(), new ExoMediaDrm.Provider() { // from class: d.a$$ExternalSyntheticLambda0
            @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.Provider
            public final ExoMediaDrm acquireExoMediaDrm(UUID uuid) {
                return a.a(uuid);
            }
        }).setMultiSession(true).build(this.f1127e);
        Intrinsics.checkNotNullExpressionValue(defaultDrmSessionManagerBuild, "build(...)");
        return defaultDrmSessionManagerBuild;
    }

    public final DrmSessionManager b() {
        if (this.f1130h) {
            c();
        }
        this.f1130h = true;
        return this.f1126d;
    }

    public final byte[] c(byte[] keySetId) {
        Intrinsics.checkNotNullParameter(keySetId, "keySetId");
        try {
            byte[] bArrRenewLicense = this.f1125c.renewLicense(keySetId);
            Intrinsics.checkNotNullExpressionValue(bArrRenewLicense, "renewLicense(...)");
            return bArrRenewLicense;
        } catch (DrmSession.DrmSessionException e2) {
            throw new PallyConException.DrmException(e2, "failed renew drm license : " + e2.getMessage());
        } catch (Exception e3) {
            throw new PallyConException.DrmException(e3, "failed renew drm license : " + e3.getMessage());
        }
    }

    public final void b(byte[] keySetId) {
        Intrinsics.checkNotNullParameter(keySetId, "keySetId");
        try {
            this.f1125c.releaseLicense(keySetId);
        } catch (DrmSession.DrmSessionException e2) {
            if (e2.errorCode != 6004) {
                throw new PallyConException.DrmException(e2, "failed renew drm license : " + e2.getMessage());
            }
        } catch (Exception e3) {
            throw new PallyConException.DrmException(e3, "failed renew drm license : " + e3.getMessage());
        }
    }

    public static final ExoMediaDrm a(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        try {
            return FrameworkMediaDrm.newInstance(uuid);
        } catch (UnsupportedDrmException unused) {
            return new DummyExoMediaDrm();
        }
    }

    public final void a(Format format, Function1<? super byte[], Unit> function1, Function1<? super PallyConException.DrmException, Unit> function12) {
        Intrinsics.checkNotNullParameter(format, "format");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new d(format, function1, function12, null), 3, null);
    }

    public final PallyConDrmInformation a(byte[] keySetId) {
        Intrinsics.checkNotNullParameter(keySetId, "keySetId");
        try {
            Pair<Long, Long> licenseDurationRemainingSec = this.f1125c.getLicenseDurationRemainingSec(keySetId);
            Intrinsics.checkNotNullExpressionValue(licenseDurationRemainingSec, "getLicenseDurationRemainingSec(...)");
            Object first = licenseDurationRemainingSec.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            long jLongValue = ((Number) first).longValue();
            Object second = licenseDurationRemainingSec.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            return new PallyConDrmInformation(jLongValue, ((Number) second).longValue());
        } catch (DrmSession.DrmSessionException e2) {
            throw new PallyConException.DrmException(e2, "Problem with DRM : " + e2.getMessage());
        } catch (Exception e3) {
            throw new PallyConException.DrmException(e3, "Problem with DRM : " + e3.getMessage());
        }
    }
}
