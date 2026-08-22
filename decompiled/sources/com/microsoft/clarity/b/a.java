package com.microsoft.clarity.b;

import android.app.Application;
import android.content.Context;
import com.appnew.android.Utils.Const;
import com.facebook.internal.AnalyticsEvents;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.c.f;
import com.microsoft.clarity.e.d;
import com.microsoft.clarity.e.e;
import com.microsoft.clarity.f.k;
import com.microsoft.clarity.f.m;
import com.microsoft.clarity.f.q;
import com.microsoft.clarity.g.g;
import com.microsoft.clarity.g.l;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.i.s;
import com.microsoft.clarity.k.b;
import com.microsoft.clarity.l.c;
import com.microsoft.clarity.models.DynamicConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.microsoft.clarity.l.a f691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.microsoft.clarity.k.a f693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static HashMap<Integer, b> f694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static d f695g;

    static {
        new C0184a();
        f694f = new HashMap<>();
    }

    /* JADX INFO: renamed from: com.microsoft.clarity.b.a$a, reason: collision with other inner class name */
    public static final class C0184a {
        public static e a(Context context, String projectId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(projectId, "projectId");
            if (a.f690b == null) {
                a.f690b = new e(context, projectId);
            }
            e eVar = a.f690b;
            Intrinsics.checkNotNull(eVar);
            return eVar;
        }

        public static k a(Context context, ClarityConfig config, DynamicConfig dynamicConfig) throws f {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
            Application application = (Application) context;
            a.f690b = a(context, config.getProjectId());
            s sVar = new s();
            g gVarA = a(application);
            e eVar = a.f690b;
            Intrinsics.checkNotNull(eVar);
            com.microsoft.clarity.g.b bVar = new com.microsoft.clarity.g.b(context, config, dynamicConfig, gVarA, eVar);
            l lVar = new l(gVarA);
            com.microsoft.clarity.g.a aVar = new com.microsoft.clarity.g.a(gVarA);
            o oVar = config.getEnableWebViewCapture() ? new o(context, gVarA, config, dynamicConfig) : null;
            b bVarA = a(application, 1);
            e eVar2 = a.f690b;
            Intrinsics.checkNotNull(eVar2);
            Boolean ENABLE_LIVE_MODE = com.microsoft.clarity.a.a.f676a;
            Intrinsics.checkNotNullExpressionValue(ENABLE_LIVE_MODE, "ENABLE_LIVE_MODE");
            m oVar2 = ENABLE_LIVE_MODE.booleanValue() ? new com.microsoft.clarity.f.o(application, config, new com.microsoft.clarity.l.f(), eVar2) : new q(application, config, dynamicConfig, bVarA, c(application), eVar2);
            e eVar3 = a.f690b;
            Intrinsics.checkNotNull(eVar3);
            com.microsoft.clarity.f.e eVar4 = new com.microsoft.clarity.f.e(application, config, dynamicConfig, sVar, gVarA, bVar, lVar, aVar, oVar, eVar3);
            e eVar5 = a.f690b;
            Intrinsics.checkNotNull(eVar5);
            return new k(context, eVar4, oVar2, eVar5, gVarA);
        }

        public static g a(Application app) {
            Intrinsics.checkNotNullParameter(app, "app");
            if (a.f689a == null) {
                a.f689a = new com.microsoft.clarity.g.k(app);
            }
            g gVar = a.f689a;
            Intrinsics.checkNotNull(gVar);
            return gVar;
        }

        public static com.microsoft.clarity.k.a b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (a.f693e == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter("metadata", "directory");
                a.f693e = new com.microsoft.clarity.k.c(new com.microsoft.clarity.m.a(context, "metadata"));
            }
            com.microsoft.clarity.k.a aVar = a.f693e;
            Intrinsics.checkNotNull(aVar);
            return aVar;
        }

        public static d c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (a.f695g == null) {
                a.f695g = new d(context);
            }
            d dVar = a.f695g;
            Intrinsics.checkNotNull(dVar);
            return dVar;
        }

        public static com.microsoft.clarity.m.a d(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter("faulty_pictures", "directory");
            return new com.microsoft.clarity.m.a(context, "faulty_pictures");
        }

        public static com.microsoft.clarity.m.a e(Context context) {
            g gVar = a.f689a;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter("", "directory");
            return new com.microsoft.clarity.m.a(context, "");
        }

        public static c f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (a.f692d == null) {
                a.f692d = new com.microsoft.clarity.l.g(context);
            }
            c cVar = a.f692d;
            Intrinsics.checkNotNull(cVar);
            return cVar;
        }

        public static com.microsoft.clarity.l.a a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (a.f691c == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter("faulty_collect_requests", "directory");
                a.f691c = new com.microsoft.clarity.l.d(context, new com.microsoft.clarity.m.a(context, "faulty_collect_requests"), f(context));
            }
            com.microsoft.clarity.l.a aVar = a.f691c;
            Intrinsics.checkNotNull(aVar);
            return aVar;
        }

        public static b a(Context context, int i) throws f {
            Intrinsics.checkNotNullParameter(context, "context");
            if (!a.f694f.containsKey(Integer.valueOf(i))) {
                Integer numValueOf = Integer.valueOf(i);
                HashMap map = a.f694f;
                if (i == 1) {
                    com.microsoft.clarity.k.a aVarB = b(context);
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter("frames", "directory");
                    com.microsoft.clarity.m.a aVar = new com.microsoft.clarity.m.a(context, "frames");
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter("events", "directory");
                    com.microsoft.clarity.m.a aVar2 = new com.microsoft.clarity.m.a(context, "events");
                    String directory = com.microsoft.clarity.n.f.a("assets", Const.IMAGES);
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(directory, "directory");
                    com.microsoft.clarity.m.a aVar3 = new com.microsoft.clarity.m.a(context, directory);
                    String directory2 = com.microsoft.clarity.n.f.a("assets", "typefaces");
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(directory2, "directory");
                    com.microsoft.clarity.m.a aVar4 = new com.microsoft.clarity.m.a(context, directory2);
                    String directory3 = com.microsoft.clarity.n.f.a("assets", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB);
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(directory3, "directory");
                    map.put(numValueOf, new com.microsoft.clarity.k.e(aVarB, aVar, aVar2, aVar3, aVar4, new com.microsoft.clarity.m.a(context, directory3)));
                } else {
                    throw new f(i);
                }
            }
            Object obj = a.f694f.get(Integer.valueOf(i));
            Intrinsics.checkNotNull(obj);
            return (b) obj;
        }
    }
}
