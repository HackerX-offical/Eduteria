package e;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.offline.DownloadHelper;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import b.a;
import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.model.DownloadState;
import com.pallycon.widevine.model.PallyConCallback;
import com.pallycon.widevine.model.PallyConDrmConfigration;
import com.pallycon.widevine.model.PallyConDrmInformation;
import com.pallycon.widevine.model.PallyConEventListener;
import com.pallycon.widevine.model.PallyConFileInformation;
import com.pallycon.widevine.sdk.PallyConWvSDK;
import com.pallycon.widevine.track.PallyConDownloaderTracks;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements PallyConWvSDK {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f1157g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentData f1159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.a f1160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.a f1161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f1162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HttpDataSource.Factory f1163f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(PallyConEventListener pallyConEventListener) {
            Intrinsics.checkNotNullParameter(pallyConEventListener, "pallyConEventListener");
            h.e.f1332f.a().b(pallyConEventListener);
        }

        public a() {
        }

        public final PallyConWvSDK a(Context context, ContentData contentData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            return new b(context, contentData);
        }

        public final void a(Context context, String directoryName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(directoryName, "directoryName");
            h.d.m.a().a(context, directoryName);
        }

        public final void a(PallyConCallback pallyConCallback) {
            h.e.f1332f.a().a(pallyConCallback);
        }

        public final void a(Class<? extends DownloadService> cls) {
            h.d.m.a().b(cls);
        }

        public final void a(PallyConEventListener pallyConEventListener) {
            Intrinsics.checkNotNullParameter(pallyConEventListener, "pallyConEventListener");
            h.e.f1332f.a().a(pallyConEventListener);
        }

        public final DownloadManager a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return h.d.m.a().f(context);
        }

        public final void a(CmcdConfiguration.Factory factory) {
            h.e.f1332f.a().a(factory);
        }

        public final String a(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i) {
            int i2 = invalidResponseCodeException.responseCode;
            if ((i2 == 307 || i2 == 308) && i < 5) {
                Map<String, List<String>> headerFields = invalidResponseCodeException.headerFields;
                Intrinsics.checkNotNullExpressionValue(headerFields, "headerFields");
                List<String> list = headerFields.get("Location");
                if (list != null && !list.isEmpty()) {
                    return list.get(0);
                }
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: e.b$b, reason: collision with other inner class name */
    public static final class C0196b extends Lambda implements Function1<byte[], Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PallyConDownloaderTracks f1165b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0196b(PallyConDownloaderTracks pallyConDownloaderTracks) {
            super(1);
            this.f1165b = pallyConDownloaderTracks;
        }

        public final void a(byte[] id) {
            Intrinsics.checkNotNullParameter(id, "id");
            b.this.f1160c.a(this.f1165b, id);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
            a(bArr);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<PallyConException, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PallyConDownloaderTracks f1167b;

        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$download$2$1", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1168a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f1169b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PallyConDownloaderTracks f1170c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, PallyConDownloaderTracks pallyConDownloaderTracks, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f1169b = bVar;
                this.f1170c = pallyConDownloaderTracks;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f1169b, this.f1170c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1168a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.f1169b.f1160c.a(this.f1170c, (byte[]) null);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: e.b$c$b, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$download$2$2", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0197b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f1172b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PallyConException f1173c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0197b(b bVar, PallyConException pallyConException, Continuation<? super C0197b> continuation) {
                super(2, continuation);
                this.f1172b = bVar;
                this.f1173c = pallyConException;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0197b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0197b(this.f1172b, this.f1173c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1171a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                h.e.f1332f.a().a(this.f1172b.f1159b, this.f1173c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PallyConDownloaderTracks pallyConDownloaderTracks) {
            super(1);
            this.f1167b = pallyConDownloaderTracks;
        }

        public final void a(PallyConException e2) {
            Intrinsics.checkNotNullParameter(e2, "e");
            if (e2 instanceof PallyConException.ClearKeyLicenseException) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new a(b.this, this.f1167b, null), 3, null);
            } else {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0197b(b.this, e2, null), 3, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConException pallyConException) {
            a(pallyConException);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$download$3", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1174a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PallyConDownloaderTracks f1176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ byte[] f1177d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PallyConDownloaderTracks pallyConDownloaderTracks, byte[] bArr, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f1176c = pallyConDownloaderTracks;
            this.f1177d = bArr;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new d(this.f1176c, this.f1177d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f1174a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b.this.f1160c.a(this.f1176c, this.f1177d);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$download$4", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1178a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PallyConDownloaderTracks f1180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ byte[] f1181d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PallyConDownloaderTracks pallyConDownloaderTracks, byte[] bArr, Continuation<? super e> continuation) {
            super(2, continuation);
            this.f1180c = pallyConDownloaderTracks;
            this.f1181d = bArr;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new e(this.f1180c, this.f1181d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f1178a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b.this.f1160c.a(this.f1180c, this.f1181d);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<PallyConException, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f1182a;

        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$downloadLicense$failed$1$1", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1183a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<PallyConException, Unit> f1184b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PallyConException f1185c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super PallyConException, Unit> function1, PallyConException pallyConException, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f1184b = function1;
                this.f1185c = pallyConException;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f1184b, this.f1185c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1183a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.f1184b.invoke(this.f1185c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Function1<? super PallyConException, Unit> function1) {
            super(1);
            this.f1182a = function1;
        }

        public final void a(PallyConException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new a(this.f1182a, exception, null), 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConException pallyConException) {
            a(pallyConException);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<byte[], Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f1187b;

        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$downloadLicense$success$1$1", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1188a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f1189b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ byte[] f1190c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f1191d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, byte[] bArr, Function0<Unit> function0, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f1189b = bVar;
                this.f1190c = bArr;
                this.f1191d = function0;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f1189b, this.f1190c, this.f1191d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1188a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.f1189b.f1162e = this.f1190c;
                this.f1189b.f1160c.a(this.f1190c);
                this.f1191d.invoke();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Function0<Unit> function0) {
            super(1);
            this.f1187b = function0;
        }

        public final void a(byte[] id) {
            Intrinsics.checkNotNullParameter(id, "id");
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new a(b.this, id, this.f1187b, null), 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
            a(bArr);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<byte[], Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<byte[], Unit> f1192a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public h(Function1<? super byte[], Unit> function1) {
            super(1);
            this.f1192a = function1;
        }

        public final void a(byte[] keySetId) {
            Intrinsics.checkNotNullParameter(keySetId, "keySetId");
            Function1<byte[], Unit> function1 = this.f1192a;
            if (function1 != null) {
                function1.invoke(keySetId);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
            a(bArr);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<PallyConException.DrmException, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f1193a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public i(Function1<? super PallyConException, Unit> function1) {
            super(1);
            this.f1193a = function1;
        }

        public final void a(PallyConException.DrmException downloadLicenseException) {
            Intrinsics.checkNotNullParameter(downloadLicenseException, "downloadLicenseException");
            Function1<PallyConException, Unit> function1 = this.f1193a;
            if (function1 != null) {
                function1.invoke(downloadLicenseException);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConException.DrmException drmException) {
            a(drmException);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<DownloadHelper, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<byte[], Unit> f1195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f1196c;

        public static final class a extends Lambda implements Function1<Format, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f1197a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<byte[], Unit> f1198b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1<PallyConException, Unit> f1199c;

            /* JADX INFO: renamed from: e.b$j$a$a, reason: collision with other inner class name */
            public static final class C0198a extends Lambda implements Function1<byte[], Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function1<byte[], Unit> f1200a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0198a(Function1<? super byte[], Unit> function1) {
                    super(1);
                    this.f1200a = function1;
                }

                public final void a(byte[] keySetId) {
                    Intrinsics.checkNotNullParameter(keySetId, "keySetId");
                    Function1<byte[], Unit> function1 = this.f1200a;
                    if (function1 != null) {
                        function1.invoke(keySetId);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                    a(bArr);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: e.b$j$a$b, reason: collision with other inner class name */
            public static final class C0199b extends Lambda implements Function1<PallyConException.DrmException, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function1<PallyConException, Unit> f1201a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0199b(Function1<? super PallyConException, Unit> function1) {
                    super(1);
                    this.f1201a = function1;
                }

                public final void a(PallyConException.DrmException downloadLicenseException) {
                    Intrinsics.checkNotNullParameter(downloadLicenseException, "downloadLicenseException");
                    Function1<PallyConException, Unit> function1 = this.f1201a;
                    if (function1 != null) {
                        function1.invoke(downloadLicenseException);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PallyConException.DrmException drmException) {
                    a(drmException);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(b bVar, Function1<? super byte[], Unit> function1, Function1<? super PallyConException, Unit> function12) {
                super(1);
                this.f1197a = bVar;
                this.f1198b = function1;
                this.f1199c = function12;
            }

            public final void a(Format it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.f1197a.f1161d.a(it, new C0198a(this.f1198b), new C0199b(this.f1199c));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Format format) {
                a(format);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: e.b$j$b, reason: collision with other inner class name */
        public static final class C0200b extends Lambda implements Function1<PallyConException, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<PallyConException, Unit> f1202a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0200b(Function1<? super PallyConException, Unit> function1) {
                super(1);
                this.f1202a = function1;
            }

            public final void a(PallyConException getDrmInitDataException) {
                Intrinsics.checkNotNullParameter(getDrmInitDataException, "getDrmInitDataException");
                Function1<PallyConException, Unit> function1 = this.f1202a;
                if (function1 != null) {
                    function1.invoke(getDrmInitDataException);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PallyConException pallyConException) {
                a(pallyConException);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(Function1<? super byte[], Unit> function1, Function1<? super PallyConException, Unit> function12) {
            super(1);
            this.f1195b = function1;
            this.f1196c = function12;
        }

        public final void a(DownloadHelper downloadHelper) {
            Intrinsics.checkNotNullParameter(downloadHelper, "<anonymous parameter 0>");
            b.this.f1160c.a(new a(b.this, this.f1195b, this.f1196c), new C0200b(this.f1196c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadHelper downloadHelper) {
            a(downloadHelper);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<PallyConException, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f1203a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public k(Function1<? super PallyConException, Unit> function1) {
            super(1);
            this.f1203a = function1;
        }

        public final void a(PallyConException downloadException) {
            Intrinsics.checkNotNullParameter(downloadException, "downloadException");
            Function1<PallyConException, Unit> function1 = this.f1203a;
            if (function1 != null) {
                function1.invoke(downloadException);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConException pallyConException) {
            a(pallyConException);
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<DownloadHelper, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConDownloaderTracks, Unit> f1205b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public l(Function1<? super PallyConDownloaderTracks, Unit> function1) {
            super(1);
            this.f1205b = function1;
        }

        public final void a(DownloadHelper downloadHelper) {
            Intrinsics.checkNotNullParameter(downloadHelper, "<anonymous parameter 0>");
            PallyConDownloaderTracks pallyConDownloaderTracksE = b.this.f1160c.e();
            if (pallyConDownloaderTracksE != null) {
                this.f1205b.invoke(pallyConDownloaderTracksE);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadHelper downloadHelper) {
            a(downloadHelper);
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<PallyConException, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f1207b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public m(Function1<? super PallyConException, Unit> function1) {
            super(1);
            this.f1207b = function1;
        }

        public final void a(PallyConException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            b.this.f1161d.c();
            this.f1207b.invoke(exception);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConException pallyConException) {
            a(pallyConException);
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function1<PallyConException, Unit> {

        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$getMediaSource$1$1", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1209a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f1210b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PallyConException f1211c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, PallyConException pallyConException, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f1210b = bVar;
                this.f1211c = pallyConException;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f1210b, this.f1211c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1209a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                h.e.f1332f.a().a(this.f1210b.f1159b, this.f1211c);
                return Unit.INSTANCE;
            }
        }

        public n() {
            super(1);
        }

        public final void a(PallyConException e2) {
            Intrinsics.checkNotNullParameter(e2, "e");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new a(b.this, e2, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PallyConException pallyConException) {
            a(pallyConException);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$reProvisionRequest$1", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class o extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1212a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f1214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f1215d;

        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$reProvisionRequest$1$1", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1216a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f1217b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Function0<Unit> function0, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f1217b = function0;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f1217b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1216a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.f1217b.invoke();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: e.b$o$b, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$reProvisionRequest$1$2", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0201b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1218a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<PallyConException, Unit> f1219b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PallyConException f1220c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0201b(Function1<? super PallyConException, Unit> function1, PallyConException pallyConException, Continuation<? super C0201b> continuation) {
                super(2, continuation);
                this.f1219b = function1;
                this.f1220c = pallyConException;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0201b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0201b(this.f1219b, this.f1220c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1218a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.f1219b.invoke(this.f1220c);
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pallycon.widevine.implement.PallyConWvSDKImpl$reProvisionRequest$1$3", f = "PallyConWvSDKImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1221a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<PallyConException, Unit> f1222b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f1223c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(Function1<? super PallyConException, Unit> function1, Exception exc, Continuation<? super c> continuation) {
                super(2, continuation);
                this.f1222b = function1;
                this.f1223c = exc;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new c(this.f1222b, this.f1223c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f1221a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<PallyConException, Unit> function1 = this.f1222b;
                Exception exc = this.f1223c;
                String message = exc.getMessage();
                if (message == null) {
                    message = "failed reProvisionRequest";
                }
                function1.invoke(new PallyConException.DrmException(exc, message));
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public o(Function0<Unit> function0, Function1<? super PallyConException, Unit> function1, Continuation<? super o> continuation) {
            super(2, continuation);
            this.f1214c = function0;
            this.f1215d = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new o(this.f1214c, this.f1215d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f1212a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                UUID uuid = C.WIDEVINE_UUID;
                FrameworkMediaDrm frameworkMediaDrmNewInstance = FrameworkMediaDrm.newInstance(uuid);
                Intrinsics.checkNotNullExpressionValue(frameworkMediaDrmNewInstance, "newInstance(...)");
                ExoMediaDrm exoMediaDrmAcquireExoMediaDrm = new ExoMediaDrm.AppManagedProvider(frameworkMediaDrmNewInstance).acquireExoMediaDrm(uuid);
                Intrinsics.checkNotNullExpressionValue(exoMediaDrmAcquireExoMediaDrm, "acquireExoMediaDrm(...)");
                ExoMediaDrm.ProvisionRequest provisionRequest = exoMediaDrmAcquireExoMediaDrm.getProvisionRequest();
                Intrinsics.checkNotNullExpressionValue(provisionRequest, "getProvisionRequest(...)");
                String str = provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData());
                DefaultHttpDataSource.Factory userAgent = new DefaultHttpDataSource.Factory().setUserAgent(Util.getUserAgent(b.this.f1158a, "PallyConWVSDK"));
                Intrinsics.checkNotNullExpressionValue(userAgent, "setUserAgent(...)");
                StatsDataSource statsDataSource = new StatsDataSource(userAgent.createDataSource());
                DataSpec dataSpecBuild = new DataSpec.Builder().setUri(str).setHttpMethod(2).setFlags(1).build();
                Intrinsics.checkNotNullExpressionValue(dataSpecBuild, "build(...)");
                int i = 0;
                while (true) {
                    DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecBuild);
                    try {
                        exoMediaDrmAcquireExoMediaDrm.provideProvisionResponse(ByteStreamsKt.readBytes(dataSourceInputStream));
                        b.this.a();
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new a(this.f1214c, null), 3, null);
                        return Unit.INSTANCE;
                    } catch (HttpDataSource.InvalidResponseCodeException e2) {
                        String strA = b.f1157g.a(e2, i);
                        if (strA == null) {
                            throw e2;
                        }
                        i++;
                        dataSpecBuild.buildUpon().setUri(strA).build();
                    } finally {
                        Util.closeQuietly(dataSourceInputStream);
                    }
                }
            } catch (PallyConException e3) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0201b(this.f1215d, e3, null), 3, null);
                return Unit.INSTANCE;
            } catch (Exception e4) {
                e4.printStackTrace();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new c(this.f1215d, e4, null), 3, null);
                return Unit.INSTANCE;
            }
        }
    }

    public static final class p extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f1224a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public p(Function1<? super PallyConException, Unit> function1) {
            super(0);
            this.f1224a = function1;
        }

        public final void a() {
            Function1<PallyConException, Unit> function1 = this.f1224a;
            if (function1 != null) {
                function1.invoke(new PallyConException.DetectedDeviceTimeModifiedException(null, "Modified device time. A network connection is required."));
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public b(Context context, ContentData contentData) {
        Map<String, String> httpHeaders;
        String cookie;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        h.f.f1339a.a(context);
        this.f1158a = context;
        this.f1159b = contentData;
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().build();
        this.f1163f = new OkHttpDataSource.Factory(okHttpClientBuild);
        OkHttpDataSource.Factory factory = new OkHttpDataSource.Factory(okHttpClientBuild);
        HashMap map = new HashMap();
        String cookie2 = contentData.getCookie();
        if (cookie2 != null) {
            map.put("Cookie", cookie2);
        }
        Map<String, String> httpHeaders2 = contentData.getHttpHeaders();
        if (httpHeaders2 != null) {
            for (Map.Entry<String, String> entry : httpHeaders2.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String key = entry.getKey();
                    Intrinsics.checkNotNull(key);
                    String value = entry.getValue();
                    Intrinsics.checkNotNull(value);
                    map.put(key, value);
                }
            }
        }
        this.f1163f.setDefaultRequestProperties(map);
        HashMap map2 = new HashMap();
        PallyConDrmConfigration drmConfig = contentData.getDrmConfig();
        if (drmConfig != null && (cookie = drmConfig.getCookie()) != null) {
            map2.put("Cookie", cookie);
        }
        PallyConDrmConfigration drmConfig2 = contentData.getDrmConfig();
        if (drmConfig2 != null && (httpHeaders = drmConfig2.getHttpHeaders()) != null) {
            for (Map.Entry<String, String> entry2 : httpHeaders.entrySet()) {
                if (entry2.getKey() != null && entry2.getValue() != null) {
                    String key2 = entry2.getKey();
                    Intrinsics.checkNotNull(key2);
                    String value2 = entry2.getValue();
                    Intrinsics.checkNotNull(value2);
                    map2.put(key2, value2);
                }
            }
        }
        factory.setDefaultRequestProperties((Map<String, String>) map2);
        this.f1161d = new d.a(context, contentData, factory);
        this.f1160c = new c.a(context, contentData, this.f1163f);
        a(this, null, null, 3, null);
    }

    public static final DrmSessionManager a(DrmSessionManager drm, MediaItem mediaItem) {
        Intrinsics.checkNotNullParameter(drm, "$drm");
        Intrinsics.checkNotNullParameter(mediaItem, "<anonymous parameter 0>");
        return drm;
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void download(PallyConDownloaderTracks downloaderTracks) {
        Intrinsics.checkNotNullParameter(downloaderTracks, "downloaderTracks");
        h.d.m.a().h(this.f1158a);
        if (downloaderTracks.getVideo().isEmpty() && downloaderTracks.getAudio().isEmpty()) {
            throw new PallyConException.DownloadException(null, "downloaderTracks is empty");
        }
        byte[] bArr = this.f1162e;
        if (bArr == null) {
            DownloadRequest downloadRequestC = this.f1160c.c();
            bArr = downloadRequestC != null ? downloadRequestC.keySetId : null;
        }
        if (bArr == null) {
            a(new C0196b(downloaderTracks), new c(downloaderTracks));
            return;
        }
        DownloadState downloadState = getDownloadState();
        if (downloadState == DownloadState.REMOVING) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new d(downloaderTracks, bArr, null), 3, null);
        } else if (downloadState != DownloadState.COMPLETED) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new e(downloaderTracks, bArr, null), 3, null);
        }
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void downloadLicense(Format format, Function0<Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        g gVar = new g(onSuccess);
        f fVar = new f(onFailed);
        if (format != null) {
            a(format, gVar, fVar);
        } else {
            a(gVar, fVar);
        }
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void getContentTrackInfo(Function1<? super PallyConDownloaderTracks, Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        this.f1160c.a(this.f1161d.b(), new l(onSuccess), new m(onFailed));
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public DataSource.Factory getDataSourceFactory() {
        if (this.f1159b.getUrl() == null) {
            throw new PallyConException.ContentDataException(null, "content url is nothing");
        }
        if (this.f1159b.getDrmConfig() == null) {
            throw new PallyConException.ContentDataException(null, "don't set drmConfig");
        }
        OkHttpDataSource.Factory factory = new OkHttpDataSource.Factory(new OkHttpClient.Builder().build());
        if (this.f1160c.c() == null) {
            return new DefaultDataSource.Factory(this.f1158a, factory);
        }
        h.d dVarA = h.d.m.a();
        CacheDataSource.Factory cacheWriteDataSinkFactory = new CacheDataSource.Factory().setCache(dVarA.c(this.f1158a)).setUpstreamDataSourceFactory(dVarA.d()).setCacheWriteDataSinkFactory(null);
        Intrinsics.checkNotNullExpressionValue(cacheWriteDataSinkFactory, "setCacheWriteDataSinkFactory(...)");
        return cacheWriteDataSinkFactory;
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public PallyConFileInformation getDownloadFileInformation() {
        return this.f1160c.b();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public DownloadManager getDownloadManager(Context context, Unit unit) {
        Intrinsics.checkNotNullParameter(context, "context");
        return h.d.m.a().f(context);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public DownloadState getDownloadState() {
        return this.f1160c.d();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public PallyConDrmInformation getDrmInformation() {
        byte[] bArr = this.f1162e;
        if (bArr == null) {
            DownloadRequest downloadRequestC = this.f1160c.c();
            bArr = downloadRequestC != null ? downloadRequestC.keySetId : null;
            if (bArr == null) {
                return new PallyConDrmInformation(0L, 0L);
            }
        }
        return this.f1161d.a(bArr);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public DrmSessionManager getDrmSessionManager() {
        return this.f1161d.b();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public byte[] getKeySetId() {
        DownloadRequest downloadRequestC = this.f1160c.c();
        byte[] bArr = this.f1162e;
        if (bArr != null) {
            return bArr;
        }
        if (downloadRequestC != null) {
            return downloadRequestC.keySetId;
        }
        return null;
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public MediaItem getMediaItem() {
        MediaItem mediaItem = getMediaSource().getMediaItem();
        Intrinsics.checkNotNullExpressionValue(mediaItem, "getMediaItem(...)");
        return mediaItem;
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public MediaSource getMediaSource() {
        return getMediaSource(this.f1161d.b());
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public boolean migrateDownloadedContent(String contentName, String str) {
        Intrinsics.checkNotNullParameter(contentName, "contentName");
        if (this.f1159b.getUrl() == null) {
            throw new PallyConException.ContentDataException(null, "content url is null");
        }
        if (this.f1159b.getContentId() == null) {
            throw new PallyConException.ContentDataException(null, "contentId is null");
        }
        if (this.f1159b.getDrmConfig() == null) {
            throw new PallyConException.ContentDataException(null, "drmConfig is null");
        }
        a.C0092a c0092a = b.a.f244c;
        b.a aVarA = c0092a.a(this.f1158a);
        String url = this.f1159b.getUrl();
        Intrinsics.checkNotNull(url);
        if (aVarA.a(url).length() <= 0) {
            return false;
        }
        b.a aVarA2 = c0092a.a(this.f1158a);
        String url2 = this.f1159b.getUrl();
        Intrinsics.checkNotNull(url2);
        String contentId = this.f1159b.getContentId();
        Intrinsics.checkNotNull(contentId);
        aVarA2.a(url2, contentId);
        return true;
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public boolean needsMigrateDownloadedContent() {
        if (this.f1159b.getUrl() == null) {
            throw new PallyConException.ContentDataException(null, "content url is null");
        }
        if (this.f1159b.getContentId() == null) {
            throw new PallyConException.ContentDataException(null, "contentId is null");
        }
        if (this.f1159b.getDrmConfig() == null) {
            throw new PallyConException.ContentDataException(null, "drmConfig is null");
        }
        b.a aVarA = b.a.f244c.a(this.f1158a);
        String url = this.f1159b.getUrl();
        Intrinsics.checkNotNull(url);
        return aVarA.a(url).length() > 0;
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void pauseAll() {
        this.f1160c.g();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void reProvisionRequest(Function0<Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new o(onSuccess, onFailed, null), 3, null);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void release() {
        a(this, null, null, 3, null);
        this.f1160c.i();
        h.d.m.b();
        h.e.f1332f.b();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void remove() {
        Unit unit = null;
        if (this.f1159b.getUrl() == null) {
            throw new PallyConException.ContentDataException(null, "content url is nothing");
        }
        String contentId = this.f1159b.getContentId();
        String strA = "";
        if (contentId != null) {
            String strA2 = b.a.f244c.a(this.f1158a).a(contentId);
            if (strA2.length() <= 0) {
                contentId = "";
            }
            strA = strA2;
            unit = Unit.INSTANCE;
        } else {
            contentId = "";
        }
        if (unit == null) {
            contentId = this.f1159b.getUrl();
            if (contentId == null) {
                throw new IllegalArgumentException("Content URL must not be null");
            }
            strA = b.a.f244c.a(this.f1158a).a(contentId);
        }
        try {
            if (strA.length() > 0) {
                a(strA);
                b.a.f244c.a(this.f1158a).b(contentId);
            }
            this.f1160c.k();
        } catch (IOException e2) {
            throw new PallyConException.DownloadException(e2, "download contents is nothing");
        } catch (Exception e3) {
            throw new PallyConException.DownloadException(e3, "download contents is nothing");
        }
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void removeAll() {
        for (String str : b.a.f244c.a(this.f1158a).c()) {
            Intrinsics.checkNotNull(str);
            a(str);
        }
        b.a.f244c.a(this.f1158a).f();
        this.f1160c.j();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void removeLicense() {
        byte[] bArr = this.f1162e;
        if (bArr == null) {
            DownloadRequest downloadRequestC = this.f1160c.c();
            bArr = downloadRequestC != null ? downloadRequestC.keySetId : null;
            if (bArr == null) {
                throw new PallyConException.DrmException(null, "not downloaded license");
            }
        }
        this.f1161d.b(bArr);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void renewLicense() {
        byte[] bArr = this.f1162e;
        if (bArr == null) {
            DownloadRequest downloadRequestC = this.f1160c.c();
            bArr = downloadRequestC != null ? downloadRequestC.keySetId : null;
            if (bArr == null) {
                throw new PallyConException.DrmException(null, "not downloaded license");
            }
        }
        this.f1162e = this.f1161d.c(bArr);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void resumeAll() {
        this.f1160c.l();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void setDownloadService(Class<? extends DownloadService> cls, Unit unit) {
        h.d.m.a().b(cls);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void setPallyConCallback(PallyConCallback pallyConCallback, Unit unit) {
        h.e.f1332f.a().a(pallyConCallback);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void setPallyConEventListener(PallyConEventListener pallyConEventListener) {
        h.e.f1332f.a().c(pallyConEventListener);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void stop() {
        this.f1160c.n();
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public void updateSecure(Function0<Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        a(onSuccess, onFailed);
    }

    @Override // com.pallycon.widevine.sdk.PallyConWvSDK
    public MediaSource getMediaSource(DrmSessionManager drmSessionManager) {
        String strA;
        Intrinsics.checkNotNullParameter(drmSessionManager, "drmSessionManager");
        if (this.f1159b.getUrl() == null) {
            new PallyConException.ContentDataException(null, "content url is nothing");
        }
        DownloadRequest downloadRequestC = this.f1160c.c();
        byte[] bArr = this.f1162e;
        if (bArr == null) {
            bArr = downloadRequestC != null ? downloadRequestC.keySetId : null;
        }
        String contentId = this.f1159b.getContentId();
        if (contentId == null || (strA = b.a.f244c.a(this.f1158a).a(contentId)) == null) {
            String url = this.f1159b.getUrl();
            strA = url != null ? b.a.f244c.a(this.f1158a).a(url) : "";
        }
        a((Function0<Unit>) null, new n());
        if (b.a.f244c.a()) {
            throw new PallyConException.DetectedDeviceTimeModifiedException(null, "Modified device time. A network connection is required.");
        }
        DownloadState downloadState = getDownloadState();
        if (strA.length() > 0) {
            MediaItem mediaItemFromUri = MediaItem.fromUri(strA);
            Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
            return a(mediaItemFromUri, bArr, new DefaultDataSource.Factory(this.f1158a));
        }
        DownloadState downloadState2 = DownloadState.COMPLETED;
        if ((downloadState == downloadState2 || downloadState == DownloadState.DOWNLOADING) && downloadRequestC != null) {
            String contentId2 = this.f1159b.getContentId();
            Intrinsics.checkNotNull(contentId2);
            if (Intrinsics.areEqual(contentId2, downloadRequestC.id)) {
                MediaItem mediaItem = downloadRequestC.toMediaItem();
                Intrinsics.checkNotNullExpressionValue(mediaItem, "toMediaItem(...)");
                return a(mediaItem, bArr, getDataSourceFactory());
            }
        }
        if (downloadState != downloadState2 || bArr == null) {
            String url2 = this.f1159b.getUrl();
            Intrinsics.checkNotNull(url2);
            return a(url2, drmSessionManager);
        }
        String url3 = this.f1159b.getUrl();
        Intrinsics.checkNotNull(url3);
        MediaItem mediaItemFromUri2 = MediaItem.fromUri(url3);
        Intrinsics.checkNotNullExpressionValue(mediaItemFromUri2, "fromUri(...)");
        return a(mediaItemFromUri2, bArr, new DefaultDataSource.Factory(this.f1158a));
    }

    public final void a() {
        Iterator<byte[]> it = this.f1160c.a().iterator();
        while (it.hasNext()) {
            try {
                this.f1161d.b(it.next());
            } catch (PallyConException unused) {
            }
        }
    }

    public final MediaSource a(MediaItem mediaItem, byte[] bArr, DataSource.Factory factory) {
        if (mediaItem.localConfiguration != null) {
            MediaItem.Builder builderBuildUpon = mediaItem.buildUpon();
            Intrinsics.checkNotNullExpressionValue(builderBuildUpon, "buildUpon(...)");
            if (bArr != null) {
                PallyConDrmConfigration drmConfig = this.f1159b.getDrmConfig();
                Intrinsics.checkNotNull(drmConfig);
                builderBuildUpon.setDrmConfiguration(new MediaItem.DrmConfiguration.Builder(drmConfig.getUuid()).setKeySetId(bArr).build());
            }
            MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
            Intrinsics.checkNotNull(localConfiguration);
            Uri uri = localConfiguration.uri;
            Intrinsics.checkNotNullExpressionValue(uri, "uri");
            return a(this, uri, factory, builderBuildUpon, null, 8, null);
        }
        throw new PallyConException.ContentDataException(null, "mediaItem is wrong. localConfiguration is null");
    }

    public final MediaSource a(String str, DrmSessionManager drmSessionManager) {
        String customData;
        String token;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String cookie = this.f1159b.getCookie();
        if (cookie != null) {
        }
        Map<String, String> httpHeaders = this.f1159b.getHttpHeaders();
        if (httpHeaders != null) {
            for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String key = entry.getKey();
                    Intrinsics.checkNotNull(key);
                    String value = entry.getValue();
                    Intrinsics.checkNotNull(value);
                    linkedHashMap.put(key, value);
                }
            }
        }
        PallyConDrmConfigration drmConfig = this.f1159b.getDrmConfig();
        if (drmConfig != null && (token = drmConfig.getToken()) != null) {
        }
        PallyConDrmConfigration drmConfig2 = this.f1159b.getDrmConfig();
        if (drmConfig2 != null && (customData = drmConfig2.getCustomData()) != null) {
        }
        MediaItem.Builder uri = new MediaItem.Builder().setUri(str);
        PallyConDrmConfigration drmConfig3 = this.f1159b.getDrmConfig();
        Intrinsics.checkNotNull(drmConfig3);
        MediaItem.DrmConfiguration.Builder builder = new MediaItem.DrmConfiguration.Builder(drmConfig3.getUuid());
        PallyConDrmConfigration drmConfig4 = this.f1159b.getDrmConfig();
        Intrinsics.checkNotNull(drmConfig4);
        MediaItem.Builder drmConfiguration = uri.setDrmConfiguration(builder.setLicenseUri(drmConfig4.getDrmLicenseUrl()).setMultiSession(true).setLicenseRequestHeaders(linkedHashMap).build());
        Intrinsics.checkNotNullExpressionValue(drmConfiguration, "setDrmConfiguration(...)");
        Uri uri2 = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(uri2, "parse(...)");
        return a(uri2, this.f1163f, drmConfiguration, drmSessionManager);
    }

    public final void a(Function1<? super byte[], Unit> function1, Function1<? super PallyConException, Unit> function12) {
        this.f1160c.a(this.f1161d.b(), new j(function1, function12), new k(function12));
    }

    public final void a(Format format, Function1<? super byte[], Unit> function1, Function1<? super PallyConException, Unit> function12) {
        this.f1161d.a(format, new h(function1), new i(function12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(b bVar, Function0 function0, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function0 = null;
        }
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        bVar.a((Function0<Unit>) function0, (Function1<? super PallyConException, Unit>) function1);
    }

    public final void a(Function0<Unit> function0, Function1<? super PallyConException, Unit> function1) {
        b.a.f244c.a(this.f1158a).a(function0, new p(function1));
    }

    public final void a(String str) {
        String strSubstring = str.substring(0, StringsKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        FilesKt.deleteRecursively(new File(strSubstring));
    }

    public static /* synthetic */ MediaSource a(b bVar, Uri uri, DataSource.Factory factory, MediaItem.Builder builder, DrmSessionManager drmSessionManager, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            drmSessionManager = null;
        }
        return bVar.a(uri, factory, builder, drmSessionManager);
    }

    public final MediaSource a(Uri uri, DataSource.Factory factory, MediaItem.Builder builder, final DrmSessionManager drmSessionManager) {
        e.a aVar;
        int iInferContentType = Util.inferContentType(uri);
        if (iInferContentType == 0) {
            aVar = new e.a(new DashMediaSource.Factory(factory), "application/dash+xml");
        } else if (iInferContentType == 1) {
            aVar = new e.a(new SsMediaSource.Factory(factory), "application/vnd.ms-sstr+xml");
        } else if (iInferContentType == 2) {
            aVar = new e.a(new HlsMediaSource.Factory(factory), "application/x-mpegURL");
        } else if (iInferContentType == 4) {
            aVar = new e.a(new ProgressiveMediaSource.Factory(factory), "application/mp4");
        } else {
            throw new PallyConException.ContentDataException(null, "Type is not supported");
        }
        MediaSource.Factory factoryA = aVar.a();
        String strB = aVar.b();
        if (drmSessionManager != null) {
            factoryA.setDrmSessionManagerProvider(new DrmSessionManagerProvider() { // from class: e.b$$ExternalSyntheticLambda0
                @Override // androidx.media3.exoplayer.drm.DrmSessionManagerProvider
                public final DrmSessionManager get(MediaItem mediaItem) {
                    return b.a(drmSessionManager, mediaItem);
                }
            });
        }
        CmcdConfiguration.Factory factoryB = h.e.f1332f.a().b();
        if (factoryB != null) {
            factoryA.setCmcdConfigurationFactory(factoryB);
        }
        Pair pair = TuplesKt.to(factoryA, builder.setMimeType(strB).build());
        MediaSource mediaSourceCreateMediaSource = ((MediaSource.Factory) pair.component1()).createMediaSource((MediaItem) pair.component2());
        Intrinsics.checkNotNullExpressionValue(mediaSourceCreateMediaSource, "createMediaSource(...)");
        return mediaSourceCreateMediaSource;
    }
}
