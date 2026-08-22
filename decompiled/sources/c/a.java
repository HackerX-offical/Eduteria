package c;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadCursor;
import androidx.media3.exoplayer.offline.DownloadHelper;
import androidx.media3.exoplayer.offline.DownloadIndex;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.offline.WritableDownloadIndex;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.model.DownloadState;
import com.pallycon.widevine.model.PallyConFileInformation;
import com.pallycon.widevine.track.AudioTrackInfo;
import com.pallycon.widevine.track.PallyConDownloaderTracks;
import com.pallycon.widevine.track.TextTrackInfo;
import com.pallycon.widevine.track.VideoTrackInfo;
import h.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentData f257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpDataSource.Factory f258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadHelper f259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DownloadHelper f260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaItem f261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DownloadIndex f262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f263h;
    public Class<? extends DownloadService> i;

    public static final class b extends Lambda implements Function1<File, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f268a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(File it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it.isFile());
        }
    }

    public static final class c extends Lambda implements Function1<File, Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f269a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke(File it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Long.valueOf(it.length());
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.downloader.PallyConDownloadManager$getFirstFormatWithDrmInitData$1", f = "PallyConDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Uri f272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f274e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function1<Format, Unit> f275f;

        /* JADX INFO: renamed from: c.a$d$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pallycon.widevine.downloader.PallyConDownloadManager$getFirstFormatWithDrmInitData$1$1", f = "PallyConDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0095a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f276a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Pair<Format, UUID> f277b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1<PallyConException, Unit> f278c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function1<Format, Unit> f279d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ a f280e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0095a(Pair<Format, UUID> pair, Function1<? super PallyConException, Unit> function1, Function1<? super Format, Unit> function12, a aVar, Continuation<? super C0095a> continuation) {
                super(2, continuation);
                this.f277b = pair;
                this.f278c = function1;
                this.f279d = function12;
                this.f280e = aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0095a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0095a(this.f277b, this.f278c, this.f279d, this.f280e, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r0 = r6.f276a
                    if (r0 != 0) goto L4d
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlin.Pair<androidx.media3.common.Format, java.util.UUID> r7 = r6.f277b
                    r0 = 0
                    if (r7 == 0) goto L3a
                    kotlin.jvm.functions.Function1<androidx.media3.common.Format, kotlin.Unit> r1 = r6.f279d
                    c.a r2 = r6.f280e
                    kotlin.jvm.functions.Function1<com.pallycon.widevine.exception.PallyConException, kotlin.Unit> r3 = r6.f278c
                    java.lang.Object r4 = r7.component1()
                    androidx.media3.common.Format r4 = (androidx.media3.common.Format) r4
                    java.lang.Object r7 = r7.component2()
                    java.util.UUID r7 = (java.util.UUID) r7
                    java.util.UUID r5 = androidx.media3.common.C.WIDEVINE_UUID
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r5)
                    if (r5 == 0) goto L33
                    if (r1 == 0) goto L31
                    r1.invoke(r4)
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    goto L38
                L31:
                    r7 = r0
                    goto L38
                L33:
                    c.a.a(r2, r7, r3)
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                L38:
                    if (r7 != 0) goto L4a
                L3a:
                    kotlin.jvm.functions.Function1<com.pallycon.widevine.exception.PallyConException, kotlin.Unit> r7 = r6.f278c
                    if (r7 == 0) goto L4a
                    com.pallycon.widevine.exception.PallyConException$DownloadException r1 = new com.pallycon.widevine.exception.PallyConException$DownloadException
                    java.lang.String r2 = "not supported type or failed to get DrmInitData"
                    r1.<init>(r0, r2)
                    r7.invoke(r1)
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                L4a:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                L4d:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: c.a.d.C0095a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Uri uri, a aVar, Function1<? super PallyConException, Unit> function1, Function1<? super Format, Unit> function12, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f272c = uri;
            this.f273d = aVar;
            this.f274e = function1;
            this.f275f = function12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.f272c, this.f273d, this.f274e, this.f275f, continuation);
            dVar.f271b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Pair pairH;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f270a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f271b;
            int iInferContentType = Util.inferContentType(this.f272c);
            if (iInferContentType == 0) {
                pairH = this.f273d.h();
            } else if (iInferContentType != 2) {
                pairH = null;
            } else {
                a aVar = this.f273d;
                Uri uri = this.f272c;
                Intrinsics.checkNotNullExpressionValue(uri, "$uri");
                pairH = aVar.b(uri);
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new C0095a(pairH, this.f274e, this.f275f, this.f273d, null), 2, null);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.downloader.PallyConDownloadManager$pauseAllDownload$1", f = "PallyConDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f281a;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new e(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f281a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            h.e.f1332f.a().b(a.this.f257b);
            return Unit.INSTANCE;
        }
    }

    public static final class f implements DownloadHelper.Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<DownloadHelper, Unit> f284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<PallyConException, Unit> f285c;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Function1<? super DownloadHelper, Unit> function1, Function1<? super PallyConException, Unit> function12) {
            this.f284b = function1;
            this.f285c = function12;
        }

        @Override // androidx.media3.exoplayer.offline.DownloadHelper.Callback
        public void onPrepareError(DownloadHelper helper2, IOException e2) {
            Intrinsics.checkNotNullParameter(helper2, "helper");
            Intrinsics.checkNotNullParameter(e2, "e");
            a.this.f260e = null;
            Throwable cause = e2;
            while (true) {
                if ((cause != null ? cause.getCause() : null) == null) {
                    Function1<PallyConException, Unit> function1 = this.f285c;
                    if (function1 != null) {
                        function1.invoke(new PallyConException.DownloadException(null, "download init error : " + e2.getMessage()));
                        return;
                    }
                    return;
                }
                if (cause instanceof UnknownHostException) {
                    Function1<PallyConException, Unit> function12 = this.f285c;
                    if (function12 != null) {
                        function12.invoke(new PallyConException.NetworkConnectedException(null, "network not connected : " + e2.getMessage()));
                        return;
                    }
                    return;
                }
                cause = cause.getCause();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadHelper.Callback
        public void onPrepared(DownloadHelper helper2) {
            Intrinsics.checkNotNullParameter(helper2, "helper");
            a.this.f260e = null;
            a.this.f259d = helper2;
            Function1<DownloadHelper, Unit> function1 = this.f284b;
            if (function1 != null) {
                function1.invoke(helper2);
            }
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.downloader.PallyConDownloadManager$processListener$1", f = "PallyConDownloadManager.kt", i = {1}, l = {681, 692}, m = "invokeSuspend", n = {"preBytesDownloaded"}, s = {"J$0"})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Download f288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f289d;

        /* JADX INFO: renamed from: c.a$g$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pallycon.widevine.downloader.PallyConDownloadManager$processListener$1$1", f = "PallyConDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0096a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f290a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Download f291b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f292c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0096a(Download download, a aVar, Continuation<? super C0096a> continuation) {
                super(2, continuation);
                this.f291b = download;
                this.f292c = aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0096a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0096a(this.f291b, this.f292c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f290a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.f291b.state == 2) {
                    h.e.f1332f.a().a(this.f292c.f257b, this.f291b.getPercentDownloaded(), this.f291b.getBytesDownloaded());
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Download download, a aVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.f288c = download;
            this.f289d = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.f288c, this.f289d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8) == r0) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005e -> B:11:0x0029). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.f287b
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L20
                if (r1 == r2) goto L1c
                if (r1 != r3) goto L14
                long r4 = r8.f286a
                kotlin.ResultKt.throwOnFailure(r9)
                goto L29
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L4e
            L20:
                kotlin.ResultKt.throwOnFailure(r9)
                androidx.media3.exoplayer.offline.Download r9 = r8.f288c
                long r4 = r9.getBytesDownloaded()
            L29:
                androidx.media3.exoplayer.offline.Download r9 = r8.f288c
                int r1 = r9.state
                if (r1 != r3) goto L61
                long r6 = r9.getBytesDownloaded()
                int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r9 >= 0) goto L54
                kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()
                c.a$g$a r1 = new c.a$g$a
                androidx.media3.exoplayer.offline.Download r4 = r8.f288c
                c.a r5 = r8.f289d
                r6 = 0
                r1.<init>(r4, r5, r6)
                r8.f287b = r2
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8)
                if (r9 != r0) goto L4e
                goto L60
            L4e:
                androidx.media3.exoplayer.offline.Download r9 = r8.f288c
                long r4 = r9.getBytesDownloaded()
            L54:
                r8.f286a = r4
                r8.f287b = r3
                r6 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r8)
                if (r9 != r0) goto L29
            L60:
                return r0
            L61:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: c.a.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.downloader.PallyConDownloadManager$processListener$2", f = "PallyConDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f293a;

        public h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new h(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f293a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Download downloadA = h.d.m.a().a(a.this.f257b);
            if (downloadA != null) {
                a aVar = a.this;
                int i = downloadA.state;
                if (i == 1) {
                    h.e.f1332f.a().e(aVar.f257b);
                } else if (i == 7) {
                    h.e.f1332f.a().d(aVar.f257b);
                } else if (i == 3) {
                    h.e.f1332f.a().a(aVar.f257b);
                } else if (i == 4) {
                    h.e.f1332f.a().a(aVar.f257b, new PallyConException.DownloadException(null, "Download failed"));
                } else if (i == 5) {
                    h.e.f1332f.a().c(aVar.f257b);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public a(Context context, ContentData contentData, HttpDataSource.Factory factory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f256a = context;
        this.f257b = contentData;
        this.f258c = factory;
        d.a aVar = h.d.m;
        this.i = aVar.a().b();
        String url = contentData.getUrl();
        if (url != null) {
            this.f261f = MediaItem.fromUri(url);
            h.d dVarA = aVar.a();
            String contentId = contentData.getContentId();
            String url2 = contentData.getUrl();
            Intrinsics.checkNotNull(url2);
            dVarA.a(contentId, url2, new C0093a());
        }
        this.f262g = aVar.a().f(context).getDownloadIndex();
        f();
    }

    public final DownloadRequest c() {
        d.a aVar = h.d.m;
        if (aVar.a().a(this.f257b) == null) {
            return null;
        }
        Download downloadA = aVar.a().a(this.f257b);
        Intrinsics.checkNotNull(downloadA);
        return downloadA.request;
    }

    public final DownloadState d() {
        d.a aVar = h.d.m;
        if (aVar.a().a(this.f257b) == null) {
            return DownloadState.NOT;
        }
        Download downloadA = aVar.a().a(this.f257b);
        Intrinsics.checkNotNull(downloadA);
        int i = downloadA.state;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 7 ? DownloadState.NOT : DownloadState.RESTARTING : DownloadState.REMOVING : DownloadState.FAILED : DownloadState.COMPLETED : DownloadState.DOWNLOADING : DownloadState.STOPPED : DownloadState.QUEUED;
    }

    public final PallyConDownloaderTracks e() {
        if (this.f259d == null) {
            return null;
        }
        PallyConDownloaderTracks pallyConDownloaderTracks = new PallyConDownloaderTracks();
        DownloadHelper downloadHelper = this.f259d;
        Intrinsics.checkNotNull(downloadHelper);
        int periodCount = downloadHelper.getPeriodCount();
        for (int i = 0; i < periodCount; i++) {
            DownloadHelper downloadHelper2 = this.f259d;
            Intrinsics.checkNotNull(downloadHelper2);
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = downloadHelper2.getMappedTrackInfo(i);
            Intrinsics.checkNotNullExpressionValue(mappedTrackInfo, "getMappedTrackInfo(...)");
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i2);
                Intrinsics.checkNotNullExpressionValue(trackGroups, "getTrackGroups(...)");
                int i3 = trackGroups.length;
                for (int i4 = 0; i4 < i3; i4++) {
                    TrackGroup trackGroup = trackGroups.get(i4);
                    Intrinsics.checkNotNullExpressionValue(trackGroup, "get(...)");
                    int i5 = trackGroup.length;
                    for (int i6 = 0; i6 < i5; i6++) {
                        Format format = trackGroup.getFormat(i6);
                        Intrinsics.checkNotNullExpressionValue(format, "getFormat(...)");
                        int rendererType = mappedTrackInfo.getRendererType(i2);
                        if (rendererType == 1) {
                            AudioTrackInfo audioTrackInfo = new AudioTrackInfo(format);
                            if (pallyConDownloaderTracks.getAudio().size() == 0) {
                                audioTrackInfo.setDownload(true);
                            }
                            pallyConDownloaderTracks.getAudio().add(audioTrackInfo);
                        } else if (rendererType == 2) {
                            VideoTrackInfo videoTrackInfo = new VideoTrackInfo(format);
                            if (pallyConDownloaderTracks.getVideo().size() == 0) {
                                videoTrackInfo.setDownload(true);
                            }
                            pallyConDownloaderTracks.getVideo().add(videoTrackInfo);
                        } else if (rendererType == 3) {
                            TextTrackInfo textTrackInfo = new TextTrackInfo(format);
                            if (pallyConDownloaderTracks.getText().size() == 0) {
                                textTrackInfo.setDownload(true);
                            }
                            pallyConDownloaderTracks.getText().add(textTrackInfo);
                        }
                    }
                }
            }
        }
        return pallyConDownloaderTracks;
    }

    public final void f() {
        try {
            DownloadIndex downloadIndex = this.f262g;
            DownloadCursor downloads = downloadIndex != null ? downloadIndex.getDownloads(new int[0]) : null;
            if (downloads != null) {
                while (downloads.moveToNext()) {
                    try {
                        Download download = downloads.getDownload();
                        Intrinsics.checkNotNullExpressionValue(download, "getDownload(...)");
                        if (Intrinsics.areEqual(download.request.id, this.f257b.getContentId())) {
                            h.d.m.a().a(this.f257b, download);
                        } else if (this.f257b.getContentId() == null) {
                            String string = download.request.uri.toString();
                            String url = this.f257b.getUrl();
                            Intrinsics.checkNotNull(url);
                            if (Intrinsics.areEqual(string, url)) {
                                h.d.m.a().a(this.f257b, download);
                            }
                        }
                    } finally {
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(downloads, null);
        } catch (IOException e2) {
            e2.printStackTrace();
            System.out.print((Object) e2.getMessage());
        }
    }

    public final void g() {
        h.d.m.a().f(this.f256a).pauseDownloads();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new e(null), 3, null);
    }

    public final Pair<Format, UUID> h() {
        DownloadHelper downloadHelper = this.f259d;
        Intrinsics.checkNotNull(downloadHelper);
        int periodCount = downloadHelper.getPeriodCount();
        for (int i = 0; i < periodCount; i++) {
            DownloadHelper downloadHelper2 = this.f259d;
            Intrinsics.checkNotNull(downloadHelper2);
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = downloadHelper2.getMappedTrackInfo(i);
            Intrinsics.checkNotNullExpressionValue(mappedTrackInfo, "getMappedTrackInfo(...)");
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i2);
                Intrinsics.checkNotNullExpressionValue(trackGroups, "getTrackGroups(...)");
                int i3 = trackGroups.length;
                for (int i4 = 0; i4 < i3; i4++) {
                    TrackGroup trackGroup = trackGroups.get(i4);
                    Intrinsics.checkNotNullExpressionValue(trackGroup, "get(...)");
                    int i5 = trackGroup.length;
                    for (int i6 = 0; i6 < i5; i6++) {
                        Format format = trackGroup.getFormat(i6);
                        Intrinsics.checkNotNullExpressionValue(format, "getFormat(...)");
                        UUID uuidA = a(format);
                        if (format.cryptoType == 0 && uuidA == null) {
                            return TuplesKt.to(format, null);
                        }
                        if (Intrinsics.areEqual(uuidA, C.CLEARKEY_UUID)) {
                            return TuplesKt.to(format, uuidA);
                        }
                        if (Intrinsics.areEqual(uuidA, C.WIDEVINE_UUID)) {
                            return TuplesKt.to(format, uuidA);
                        }
                    }
                }
            }
        }
        return null;
    }

    public final void i() {
        d.a aVar = h.d.m;
        aVar.a().f(this.f256a).release();
        DownloadHelper downloadHelper = this.f259d;
        if (downloadHelper != null) {
            downloadHelper.release();
        }
        h.d dVarA = aVar.a();
        dVarA.f();
        String contentId = this.f257b.getContentId();
        String url = this.f257b.getUrl();
        if (url == null) {
            url = "";
        }
        dVarA.a(contentId, url);
    }

    public final void j() {
        h.d.m.a().f(this.f256a).removeAllDownloads();
    }

    public final void k() {
        d.a aVar = h.d.m;
        if (aVar.a().a(this.f257b) == null) {
            throw new PallyConException.DownloadException(null, "downloader object is null");
        }
        String url = this.f257b.getUrl();
        if (url == null) {
            throw new PallyConException.ContentDataException(null, "content url is null");
        }
        String contentId = this.f257b.getContentId();
        if (contentId != null) {
            url = contentId;
        }
        aVar.a().f(this.f256a).removeDownload(url);
    }

    public final void l() {
        h.d.m.a().f(this.f256a).resumeDownloads();
    }

    public final void m() {
        d.a aVar = h.d.m;
        if (aVar.a().a(this.f257b) == null) {
            throw new PallyConException.DownloadException(null, "downloader object is null");
        }
        String url = this.f257b.getUrl();
        if (url == null) {
            throw new PallyConException.ContentDataException(null, "content url is null");
        }
        String contentId = this.f257b.getContentId();
        if (contentId != null) {
            url = contentId;
        }
        aVar.a().f(this.f256a).setStopReason(url, 0);
    }

    public final void n() {
        if (this.f259d == null) {
            throw new PallyConException.ContentDataException(null, "downloader object is null");
        }
        String url = this.f257b.getUrl();
        if (url == null) {
            throw new PallyConException.ContentDataException(null, "content url is null");
        }
        String contentId = this.f257b.getContentId();
        if (contentId != null) {
            url = contentId;
        }
        h.d.m.a().f(this.f256a).setStopReason(url, 1);
    }

    public final Pair<Format, UUID> b(Uri uri) throws IOException {
        Format formatA = a((Format) null, uri);
        if (formatA == null) {
            return null;
        }
        UUID uuidA = a(formatA);
        if (formatA.cryptoType == 0 && uuidA == null) {
            return TuplesKt.to(formatA, null);
        }
        if (Intrinsics.areEqual(uuidA, C.CLEARKEY_UUID)) {
            return TuplesKt.to(formatA, uuidA);
        }
        if (Intrinsics.areEqual(uuidA, C.WIDEVINE_UUID)) {
            return TuplesKt.to(formatA, uuidA);
        }
        return null;
    }

    public final void a(DrmSessionManager drmSessionManager, Function1<? super DownloadHelper, Unit> function1, Function1<? super PallyConException, Unit> function12) {
        Intrinsics.checkNotNullParameter(drmSessionManager, "drmSessionManager");
        if (this.f260e != null) {
            return;
        }
        DownloadHelper downloadHelper = this.f259d;
        if (downloadHelper != null) {
            if (function1 != null) {
                Intrinsics.checkNotNull(downloadHelper);
                function1.invoke(downloadHelper);
                return;
            }
            return;
        }
        MediaItem mediaItem = this.f261f;
        if (mediaItem == null) {
            if (function12 != null) {
                function12.invoke(new PallyConException.ContentDataException(null, "content url is null"));
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(mediaItem);
        this.f260e = DownloadHelper.forMediaItem(mediaItem, DefaultTrackSelector.Parameters.getDefaults(this.f256a), new DefaultRenderersFactory(this.f256a), this.f258c, drmSessionManager);
        f fVar = new f(function1, function12);
        DownloadHelper downloadHelper2 = this.f260e;
        if (downloadHelper2 != null) {
            downloadHelper2.prepare(fVar);
        }
    }

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static final class C0093a implements d.b {

        /* JADX INFO: renamed from: c.a$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pallycon.widevine.downloader.PallyConDownloadManager$1$1$onDownloadsChanged$1", f = "PallyConDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0094a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f265a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f266b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f267c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0094a(a aVar, Exception exc, Continuation<? super C0094a> continuation) {
                super(2, continuation);
                this.f266b = aVar;
                this.f267c = exc;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0094a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0094a(this.f266b, this.f267c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f265a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                h.e.f1332f.a().a(this.f266b.f257b, new PallyConException.DownloadException(null, "finalException " + this.f267c.getMessage()));
                return Unit.INSTANCE;
            }
        }

        public C0093a() {
        }

        @Override // h.d.b
        public void a(Download download, Exception exc) {
            Intrinsics.checkNotNullParameter(download, "download");
            h.d.m.a().a(a.this.f257b, download);
            if (exc != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0094a(a.this, exc, null), 3, null);
            } else {
                a.this.a(download);
            }
        }

        @Override // h.d.b
        public void a(Download download) {
            Intrinsics.checkNotNullParameter(download, "download");
            h.d.m.a().a(a.this.f257b, download);
        }
    }

    public final PallyConFileInformation b() {
        String strA;
        if (this.f257b.getUrl() != null) {
            d.a aVar = h.d.m;
            if (aVar.a().a(this.f257b) != null) {
                h.d dVarA = aVar.a();
                if (this.f257b.getContentId() != null) {
                    b.a aVarA = b.a.f244c.a(this.f256a);
                    String contentId = this.f257b.getContentId();
                    Intrinsics.checkNotNull(contentId);
                    strA = aVarA.a(contentId);
                } else {
                    strA = "";
                }
                String str = strA;
                if (str.length() > 0) {
                    String strSubstring = str.substring(0, StringsKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null));
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    File file = new File(strSubstring);
                    return new PallyConFileInformation(SequencesKt.sumOfLong(SequencesKt.map(SequencesKt.filter(FilesKt.walkTopDown(file), b.f268a), c.f269a)), null, file);
                }
                Download downloadA = aVar.a().a(this.f257b);
                Intrinsics.checkNotNull(downloadA);
                return new PallyConFileInformation(downloadA.getBytesDownloaded(), dVarA.c(this.f256a), dVarA.e(this.f256a));
            }
        }
        return new PallyConFileInformation(0L, null, null);
    }

    public final void a(PallyConDownloaderTracks downloaderTracks, byte[] bArr) {
        DownloadRequest downloadRequest;
        DownloadRequest downloadRequestCopyWithKeySetId;
        Intrinsics.checkNotNullParameter(downloaderTracks, "downloaderTracks");
        if (this.f259d != null) {
            String url = this.f257b.getUrl();
            if (url != null) {
                a(downloaderTracks);
                String contentId = this.f257b.getContentId();
                if (contentId != null) {
                    url = contentId;
                }
                DownloadHelper downloadHelper = this.f259d;
                if (downloadHelper != null && (downloadRequest = downloadHelper.getDownloadRequest(url, Util.getUtf8Bytes(url))) != null && (downloadRequestCopyWithKeySetId = downloadRequest.copyWithKeySetId(bArr)) != null) {
                    h.d.m.a().f(this.f256a).addDownload(downloadRequestCopyWithKeySetId);
                    return;
                }
                throw new PallyConException.DownloadException(null, "failed create downloadRequest");
            }
            throw new PallyConException.ContentDataException(null, "content url is null");
        }
        throw new PallyConException.ContentDataException(null, "downloader object is null");
    }

    public final void a(byte[] keySetId) throws IOException {
        Download download;
        Intrinsics.checkNotNullParameter(keySetId, "keySetId");
        d.a aVar = h.d.m;
        DownloadIndex downloadIndex = aVar.a().f(this.f256a).getDownloadIndex();
        Intrinsics.checkNotNull(downloadIndex, "null cannot be cast to non-null type androidx.media3.exoplayer.offline.WritableDownloadIndex");
        WritableDownloadIndex writableDownloadIndex = (WritableDownloadIndex) downloadIndex;
        Download downloadA = aVar.a().a(this.f257b);
        if (downloadA != null) {
            DownloadRequest downloadRequestCopyWithKeySetId = downloadA.request.copyWithKeySetId(keySetId);
            Intrinsics.checkNotNullExpressionValue(downloadRequestCopyWithKeySetId, "copyWithKeySetId(...)");
            download = new Download(downloadRequestCopyWithKeySetId, downloadA.state, downloadA.startTimeMs, downloadA.updateTimeMs, downloadA.contentLength, downloadA.stopReason, downloadA.failureReason);
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis() - ((long) DateTimeConstants.MILLIS_PER_DAY);
            String contentId = this.f257b.getContentId();
            if (contentId == null) {
                contentId = this.f257b.getUrl();
                Intrinsics.checkNotNull(contentId);
            }
            DownloadRequest downloadRequestCopyWithKeySetId2 = new DownloadRequest.Builder(contentId, Uri.parse(this.f257b.getUrl())).setData(Util.getUtf8Bytes(contentId)).build().copyWithKeySetId(keySetId);
            Intrinsics.checkNotNullExpressionValue(downloadRequestCopyWithKeySetId2, "copyWithKeySetId(...)");
            download = new Download(downloadRequestCopyWithKeySetId2, 0, jCurrentTimeMillis, jCurrentTimeMillis + ((long) 3000), -1L, 0, 0);
        }
        writableDownloadIndex.putDownload(download);
    }

    public final void a(String url, String cid, byte[] keySetId, long j) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(keySetId, "keySetId");
        DownloadRequest downloadRequestCopyWithKeySetId = new DownloadRequest.Builder(cid, Uri.parse(url)).setData(Util.getUtf8Bytes(cid)).build().copyWithKeySetId(keySetId);
        Intrinsics.checkNotNullExpressionValue(downloadRequestCopyWithKeySetId, "copyWithKeySetId(...)");
        Download download = new Download(downloadRequestCopyWithKeySetId, 3, j, j + ((long) 3000), -1L, 0, 0);
        d.a aVar = h.d.m;
        DownloadIndex downloadIndex = aVar.a().f(this.f256a).getDownloadIndex();
        Intrinsics.checkNotNull(downloadIndex, "null cannot be cast to non-null type androidx.media3.exoplayer.offline.WritableDownloadIndex");
        ((WritableDownloadIndex) downloadIndex).putDownload(download);
        aVar.a().a(this.f257b, download);
    }

    public final List<byte[]> a() {
        ArrayList arrayList = new ArrayList();
        try {
            try {
                DownloadIndex downloadIndex = this.f262g;
                DownloadCursor downloads = downloadIndex != null ? downloadIndex.getDownloads(new int[0]) : null;
                if (downloads != null) {
                    while (downloads.moveToNext()) {
                        try {
                            Download download = downloads.getDownload();
                            Intrinsics.checkNotNullExpressionValue(download, "getDownload(...)");
                            byte[] bArr = download.request.keySetId;
                            if (bArr != null) {
                                Intrinsics.checkNotNull(bArr);
                                arrayList.add(bArr);
                            }
                        } finally {
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(downloads, null);
                return arrayList;
            } catch (IOException e2) {
                e2.printStackTrace();
                System.out.print((Object) e2.getMessage());
                return arrayList;
            }
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public final void a(Function1<? super Format, Unit> function1, Function1<? super PallyConException, Unit> function12) {
        if (this.f259d == null || this.f257b.getUrl() == null) {
            if (function12 != null) {
                function12.invoke(new PallyConException.ContentDataException(null, "downloadHelper or contentData is null"));
            }
        } else {
            String url = this.f257b.getUrl();
            Intrinsics.checkNotNull(url);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new d(Uri.parse(url), this, function12, function1, null), 3, null);
        }
    }

    public final UUID a(Format format) {
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData == null) {
            return null;
        }
        int i = drmInitData.schemeDataCount;
        for (int i2 = 0; i2 < i; i2++) {
            UUID uuid = drmInitData.get(i2).uuid;
            Intrinsics.checkNotNullExpressionValue(uuid, "uuid");
            if (Intrinsics.areEqual(uuid, C.WIDEVINE_UUID) || Intrinsics.areEqual(uuid, C.CLEARKEY_UUID)) {
                return uuid;
            }
        }
        return null;
    }

    public final void a(UUID uuid, Function1<? super PallyConException, Unit> function1) {
        if (uuid == null) {
            if (function1 != null) {
                function1.invoke(new PallyConException.ClearKeyLicenseException(null, "Non DRM"));
            }
        } else if (Intrinsics.areEqual(uuid, C.CLEARKEY_UUID)) {
            if (function1 != null) {
                function1.invoke(new PallyConException.ClearKeyLicenseException(null, "Clear Key Content"));
            }
        } else if (function1 != null) {
            function1.invoke(new PallyConException.DownloadException(null, "failed get DrmInitData"));
        }
    }

    public final Format a(Format format, Uri uri) throws IOException {
        HlsPlaylist hlsPlaylist = new HlsPlaylistParser().parse(uri, a(uri));
        Intrinsics.checkNotNullExpressionValue(hlsPlaylist, "parse(...)");
        if (hlsPlaylist instanceof HlsMultivariantPlaylist) {
            Iterator<HlsMultivariantPlaylist.Variant> it = ((HlsMultivariantPlaylist) hlsPlaylist).variants.iterator();
            if (!it.hasNext()) {
                return format;
            }
            HlsMultivariantPlaylist.Variant next = it.next();
            Format format2 = next.format;
            if (format2.drmInitData != null) {
                return format2;
            }
            Uri url = next.url;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            return a(format2, url);
        }
        if (!(hlsPlaylist instanceof HlsMediaPlaylist) || format == null) {
            return null;
        }
        for (HlsMediaPlaylist.Segment segment : ((HlsMediaPlaylist) hlsPlaylist).segments) {
            if (segment.drmInitData != null) {
                return new Format.Builder().setId(format.id).setLabel(format.label).setContainerMimeType(format.containerMimeType).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).setLanguage(format.language).setDrmInitData(segment.drmInitData).build();
            }
        }
        return format;
    }

    public final InputStream a(Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("GET");
        if (httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            return inputStream;
        }
        throw new PallyConException.NetworkConnectedException(null, "code : " + httpURLConnection.getResponseCode() + ", message : " + httpURLConnection.getResponseMessage());
    }

    public final void a(PallyConDownloaderTracks pallyConDownloaderTracks) {
        DownloadHelper downloadHelper = this.f259d;
        if (downloadHelper != null) {
            Intrinsics.checkNotNull(downloadHelper);
            int periodCount = downloadHelper.getPeriodCount();
            for (int i = 0; i < periodCount; i++) {
                DownloadHelper downloadHelper2 = this.f259d;
                Intrinsics.checkNotNull(downloadHelper2);
                downloadHelper2.clearTrackSelections(i);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList<VideoTrackInfo> video = pallyConDownloaderTracks.getVideo();
            if (!(video instanceof Collection) || !video.isEmpty()) {
                Iterator<T> it = video.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((VideoTrackInfo) it.next()).getIsDownload()) {
                        Iterable iterableWithIndex = CollectionsKt.withIndex(pallyConDownloaderTracks.getVideo());
                        ArrayList arrayList4 = new ArrayList();
                        for (Object obj : iterableWithIndex) {
                            if (((VideoTrackInfo) ((IndexedValue) obj).getValue()).getIsDownload()) {
                                arrayList4.add(obj);
                            }
                        }
                        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                        Iterator it2 = arrayList4.iterator();
                        while (it2.hasNext()) {
                            arrayList5.add(Integer.valueOf(((IndexedValue) it2.next()).getIndex()));
                        }
                        int[] intArray = CollectionsKt.toIntArray(arrayList5);
                        if (!(intArray.length == 0)) {
                            arrayList.add(new DefaultTrackSelector.SelectionOverride(0, Arrays.copyOf(intArray, intArray.length)));
                        }
                    }
                }
            }
            int size = pallyConDownloaderTracks.getAudio().size();
            for (int i2 = 0; i2 < size; i2++) {
                if (pallyConDownloaderTracks.getAudio().get(i2).getIsDownload()) {
                    arrayList2.add(new DefaultTrackSelector.SelectionOverride(i2, 0));
                }
            }
            int size2 = pallyConDownloaderTracks.getText().size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (pallyConDownloaderTracks.getText().get(i3).getIsDownload()) {
                    arrayList3.add(new DefaultTrackSelector.SelectionOverride(i3, 0));
                }
            }
            if (arrayList.size() > 0) {
                DownloadHelper downloadHelper3 = this.f259d;
                Intrinsics.checkNotNull(downloadHelper3);
                downloadHelper3.addTrackSelectionForSingleRenderer(0, 0, DownloadHelper.getDefaultTrackSelectorParameters(this.f256a), arrayList);
            }
            if (arrayList2.size() > 0) {
                DownloadHelper downloadHelper4 = this.f259d;
                Intrinsics.checkNotNull(downloadHelper4);
                downloadHelper4.addTrackSelectionForSingleRenderer(0, 1, DownloadHelper.getDefaultTrackSelectorParameters(this.f256a), arrayList2);
            }
            if (arrayList3.size() > 0) {
                DownloadHelper downloadHelper5 = this.f259d;
                Intrinsics.checkNotNull(downloadHelper5);
                downloadHelper5.addTrackSelectionForSingleRenderer(0, 2, DownloadHelper.getDefaultTrackSelectorParameters(this.f256a), arrayList3);
                return;
            }
            return;
        }
        throw new PallyConException.DownloadException(null, "downloader object is null");
    }

    public final void a(Download download) {
        if (h.d.m.a().a(this.f257b) != null) {
            if (download.state == 2) {
                if (this.f263h == null) {
                    this.f263h = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new g(download, this, null), 3, null);
                    return;
                }
                return;
            } else {
                Job job = this.f263h;
                if (job != null) {
                    Intrinsics.checkNotNull(job);
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    this.f263h = null;
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new h(null), 3, null);
                return;
            }
        }
        throw new PallyConException.DownloadException(null, "failed processListener about download object is null");
    }
}
