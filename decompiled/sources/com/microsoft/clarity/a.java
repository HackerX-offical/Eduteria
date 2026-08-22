package com.microsoft.clarity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.microsoft.clarity.a;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.f.k;
import com.microsoft.clarity.g.e;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.workers.UpdateClarityCachedConfigsWorker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static k f657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ClarityConfig f660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ArrayList f661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayList f662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f663h;
    public static final LinkedHashMap i;
    public static String j;
    public static final Object k;

    static {
        new C0182a();
        f656a = new Handler(Looper.getMainLooper());
        f661f = new ArrayList();
        f662g = new ArrayList();
        i = new LinkedHashMap();
        k = new Object();
    }

    /* JADX INFO: renamed from: com.microsoft.clarity.a$a, reason: collision with other inner class name */
    public static final class C0182a {

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$a, reason: collision with other inner class name */
        public static final class C0183a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ClarityConfig f664a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f665b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0183a(Context context, ClarityConfig clarityConfig) {
                super(0);
                this.f664a = clarityConfig;
                this.f665b = context;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                com.microsoft.clarity.n.i.b("Enqueuing the update Clarity configs worker.");
                String simpleName = Reflection.getOrCreateKotlinClass(UpdateClarityCachedConfigsWorker.class).getSimpleName();
                Intrinsics.checkNotNull(simpleName);
                Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) UpdateClarityCachedConfigsWorker.class);
                Pair[] pairArr = {TuplesKt.to("PROJECT_ID", this.f664a.getProjectId())};
                Data.Builder builder2 = new Data.Builder();
                Pair pair = pairArr[0];
                builder2.put((String) pair.getFirst(), pair.getSecond());
                Data dataBuild = builder2.build();
                Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
                WorkManager.getInstance(this.f665b).enqueueUniqueWork(simpleName, ExistingWorkPolicy.REPLACE, builder.setInputData(dataBuild).setConstraints(constraintsBuild).addTag(simpleName).addTag(com.microsoft.clarity.a.b.a("ENQUEUED_AT_").append(System.currentTimeMillis()).toString()).build());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$b */
        public static final class b extends Lambda implements Function1<Exception, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f666a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Exception exc) {
                Exception it = exc;
                Intrinsics.checkNotNullParameter(it, "it");
                Handler handler = a.f656a;
                C0182a.a(it, ErrorType.UpdateClarityCachedConfigsWorker);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$c */
        public static final class c extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f667a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(View view) {
                super(0);
                this.f667a = view;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Unit unit;
                Object obj = a.k;
                View view = this.f667a;
                synchronized (obj) {
                    if (a.f657b != null) {
                        k kVar = a.f657b;
                        if (kVar != null) {
                            kVar.a(view);
                        }
                    } else {
                        ArrayList arrayList = a.f661f;
                        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), view)) {
                                    break;
                                }
                            }
                        }
                        a.f661f.add(new WeakReference(view));
                    }
                    unit = Unit.INSTANCE;
                }
                return unit;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$d */
        public static final class d extends Lambda implements Function1<Exception, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f668a = new d();

            public d() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Exception exc) {
                Exception it = exc;
                Intrinsics.checkNotNullParameter(it, "it");
                Handler handler = a.f656a;
                C0182a.a(it, ErrorType.Masking);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$e */
        public static final class e extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f669a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f670b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(String str, String str2) {
                super(0);
                this.f669a = str;
                this.f670b = str2;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Unit unit;
                Object obj = a.k;
                String str = this.f669a;
                String str2 = this.f670b;
                synchronized (obj) {
                    if (a.f657b != null) {
                        k kVar = a.f657b;
                        if (kVar != null) {
                            kVar.a(str, str2);
                        }
                    } else {
                        a.i.put(str, str2);
                    }
                    unit = Unit.INSTANCE;
                }
                return unit;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$f */
        public static final class f extends Lambda implements Function1<Exception, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f671a = new f();

            public f() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Exception exc) {
                Exception it = exc;
                Intrinsics.checkNotNullParameter(it, "it");
                Handler handler = a.f656a;
                C0182a.a(it, ErrorType.SettingCustomUserId);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$g */
        public static final class g extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f672a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(String str) {
                super(0);
                this.f672a = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Unit unit;
                Object obj = a.k;
                String str = this.f672a;
                synchronized (obj) {
                    if (a.f657b != null) {
                        k kVar = a.f657b;
                        if (kVar != null) {
                            kVar.b(str);
                        }
                    } else {
                        a.f663h = str;
                    }
                    unit = Unit.INSTANCE;
                }
                return unit;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$h */
        public static final class h extends Lambda implements Function1<Exception, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final h f673a = new h();

            public h() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Exception exc) {
                Exception it = exc;
                Intrinsics.checkNotNullParameter(it, "it");
                Handler handler = a.f656a;
                C0182a.a(it, ErrorType.SettingCustomUserId);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$i */
        public static final class i extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f674a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public i(View view) {
                super(0);
                this.f674a = view;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Unit unit;
                Object obj = a.k;
                View view = this.f674a;
                synchronized (obj) {
                    if (a.f657b != null) {
                        k kVar = a.f657b;
                        if (kVar != null) {
                            kVar.b(view);
                        }
                    } else {
                        ArrayList arrayList = a.f662g;
                        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), view)) {
                                    break;
                                }
                            }
                        }
                        a.f662g.add(new WeakReference(view));
                    }
                    unit = Unit.INSTANCE;
                }
                return unit;
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.a$a$j */
        public static final class j extends Lambda implements Function1<Exception, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final j f675a = new j();

            public j() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Exception exc) {
                Exception it = exc;
                Intrinsics.checkNotNullParameter(it, "it");
                Handler handler = a.f656a;
                C0182a.a(it, ErrorType.Masking);
                return Unit.INSTANCE;
            }
        }

        public static final void a(Application application, ClarityConfig clarityConfig, Activity activity) {
            Handler handler = a.f656a;
            a.f660e = clarityConfig;
            com.microsoft.clarity.g.g gVar = com.microsoft.clarity.b.a.f689a;
            com.microsoft.clarity.g.g gVarA = a.C0184a.a(application);
            if (activity != null && (clarityConfig.isReactNative$sdk_prodRelease() || clarityConfig.isCordova$sdk_prodRelease() || clarityConfig.isIonic$sdk_prodRelease())) {
                gVarA.a(activity);
            }
            a.f656a.post(new com.microsoft.clarity.e(application, clarityConfig, gVarA));
        }

        public static final void a(ClarityConfig config, Context context) {
            Intrinsics.checkNotNullParameter(config, "$config");
            Intrinsics.checkNotNullParameter(context, "$context");
            com.microsoft.clarity.n.e.a(new C0183a(context, config), b.f666a, (o.c) null, 10);
        }

        public static boolean a(Activity activity, Context context, ClarityConfig config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            return com.microsoft.clarity.n.e.a(new com.microsoft.clarity.c(activity, context, config), com.microsoft.clarity.d.f704a, (e.c) null, 26);
        }

        public static boolean a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            com.microsoft.clarity.n.i.d("Mask view " + view + '.');
            return com.microsoft.clarity.n.e.a(new c(view), d.f668a, (e.c) null, 26);
        }

        public static boolean a(String customUserId) {
            String str;
            Intrinsics.checkNotNullParameter(customUserId, "customUserId");
            com.microsoft.clarity.n.i.d("Setting custom user id to " + customUserId + '.');
            if (StringsKt.isBlank(customUserId)) {
                str = "Custom user id cannot be blank.";
            } else {
                if (customUserId.length() <= 255) {
                    return com.microsoft.clarity.n.e.a(new g(customUserId), h.f673a, (e.c) null, 26);
                }
                str = "Custom user id length cannot exceed 255 characters.";
            }
            com.microsoft.clarity.n.i.c(str);
            return false;
        }

        public static boolean a(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            if (!StringsKt.isBlank(key) && !StringsKt.isBlank(value)) {
                return com.microsoft.clarity.n.e.a(new e(key, value), f.f671a, (e.c) null, 26);
            }
            com.microsoft.clarity.n.i.c("Custom tag key and value cannot be blank.");
            return false;
        }

        public static void b(final Context context, final ClarityConfig clarityConfig) {
            if (com.microsoft.clarity.a.a.f681f.booleanValue()) {
                new Thread(new Runnable() { // from class: com.microsoft.clarity.a$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0182a.a(clarityConfig, context);
                    }
                }).start();
            } else {
                c(context, clarityConfig);
            }
        }

        public static boolean b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            com.microsoft.clarity.n.i.d("Unmask view " + view + '.');
            return com.microsoft.clarity.n.e.a(new i(view), j.f675a, (e.c) null, 26);
        }

        public static void c(final Context context, final ClarityConfig clarityConfig) {
            new Thread(new Runnable() { // from class: com.microsoft.clarity.a$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    a.C0182a.d(context, clarityConfig);
                }
            }).start();
        }

        public static final void d(Context context, ClarityConfig config) throws InterruptedException {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(config, "$config");
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 25) {
                    return;
                }
                try {
                    com.microsoft.clarity.e.a.a(context, config.getProjectId());
                    return;
                } catch (Exception e2) {
                    com.microsoft.clarity.n.i.c(e2.getMessage());
                    Thread.sleep(1000L);
                    i2 = i3;
                }
            }
        }

        public static final boolean a() {
            Handler handler = a.f656a;
            IntRange intRange = new IntRange(29, 33);
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int i2 = Build.VERSION.SDK_INT;
            return first <= i2 && i2 <= last;
        }

        public static final void a(Exception exc, ErrorType errorType) {
            Handler handler = a.f656a;
            k kVar = a.f657b;
            if (kVar != null) {
                kVar.b(exc, errorType);
                return;
            }
            com.microsoft.clarity.e.e eVar = com.microsoft.clarity.b.a.f690b;
            if (eVar != null) {
                eVar.a(exc, errorType, (PageMetadata) null);
            }
            if (eVar == null) {
                com.microsoft.clarity.n.i.c(exc.toString());
            }
        }

        public static final void a(Application application, ClarityConfig clarityConfig, DynamicConfig dynamicConfig, com.microsoft.clarity.g.g gVar) {
            Unit unit;
            k kVar;
            k kVar2;
            Unit unit2;
            k kVar3;
            k kVar4;
            Handler handler = a.f656a;
            synchronized (a.k) {
                com.microsoft.clarity.g.g gVar2 = com.microsoft.clarity.b.a.f689a;
                a.f657b = a.C0184a.a(application, clarityConfig, dynamicConfig);
                if (clarityConfig.getUserId() != null && !clarityConfig.isValidUserId$sdk_prodRelease()) {
                    com.microsoft.clarity.n.i.c("Invalid user id. It cannot be a blank string and it must be a base36 string that is smaller than 1Z141Z4. Clarity will generate a random user id and the provided id will be stored as the custom user id, if you would like to override the custom user id, please use Clarity.setCustomUserId(...).");
                    a(clarityConfig.getUserId());
                }
                ArrayList arrayList = a.f661f;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (true) {
                    Unit unit3 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    View v = (View) ((WeakReference) it.next()).get();
                    if (v != null && (kVar4 = a.f657b) != null) {
                        Intrinsics.checkNotNullExpressionValue(v, "v");
                        kVar4.a(v);
                        unit3 = Unit.INSTANCE;
                    }
                    arrayList2.add(unit3);
                }
                ArrayList arrayList3 = a.f662g;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    View v2 = (View) ((WeakReference) it2.next()).get();
                    if (v2 == null || (kVar3 = a.f657b) == null) {
                        unit2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(v2, "v");
                        kVar3.b(v2);
                        unit2 = Unit.INSTANCE;
                    }
                    arrayList4.add(unit2);
                }
                String str = a.f663h;
                if (str != null && (kVar2 = a.f657b) != null) {
                    kVar2.b(str);
                }
                String str2 = a.j;
                if (str2 != null && (kVar = a.f657b) != null) {
                    kVar.a(str2);
                }
                LinkedHashMap linkedHashMap = a.i;
                ArrayList arrayList5 = new ArrayList(linkedHashMap.size());
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    k kVar5 = a.f657b;
                    if (kVar5 != null) {
                        kVar5.a((String) entry.getKey(), (String) entry.getValue());
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    arrayList5.add(unit);
                }
                a.f661f.clear();
                a.f662g.clear();
                a.f663h = null;
                a.j = null;
                a.i.clear();
                gVar.e();
                Unit unit4 = Unit.INSTANCE;
            }
        }
    }
}
