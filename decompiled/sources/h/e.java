package h;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.exception.PallyConLicenseServerException;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.model.PallyConCallback;
import com.pallycon.widevine.model.PallyConEventListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1332f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f1333g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PallyConEventListener f1334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PallyConCallback f1335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CmcdConfiguration.Factory f1336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<PallyConEventListener> f1337d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1338e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            e eVar;
            e eVar2 = e.f1333g;
            if (eVar2 != null) {
                return eVar2;
            }
            synchronized (this) {
                eVar = e.f1333g;
                if (eVar == null) {
                    eVar = new e();
                    a aVar = e.f1332f;
                    e.f1333g = eVar;
                }
            }
            return eVar;
        }

        public final void b() {
            e.f1333g = null;
        }

        public a() {
        }

        public final byte[] a(ContentData contentData) throws IOException {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            String url = contentData.getUrl();
            Intrinsics.checkNotNull(url);
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            try {
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    String cookie = contentData.getCookie();
                    if (cookie != null) {
                        httpURLConnection.setRequestProperty("Cookie", cookie);
                    }
                    Map<String, String> httpHeaders = contentData.getHttpHeaders();
                    if (httpHeaders != null) {
                        for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int i = inputStream.read(bArr, 0, 1024);
                        intRef.element = i;
                        if (i != -1) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                            return byteArray;
                        }
                    }
                } else {
                    throw new IOException("HTTP Error: " + httpURLConnection.getResponseCode());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        }
    }

    public final void b(PallyConCallback pallyConCallback) {
        this.f1335b = pallyConCallback;
    }

    public final Object c() {
        return this.f1338e;
    }

    public final void d(PallyConEventListener pallyConEventListener) {
        this.f1334a = pallyConEventListener;
    }

    public final PallyConEventListener e() {
        return this.f1334a;
    }

    public final CmcdConfiguration.Factory b() {
        return this.f1336c;
    }

    public final void c(PallyConEventListener pallyConEventListener) {
        this.f1334a = pallyConEventListener;
        if (pallyConEventListener == null || this.f1337d.contains(pallyConEventListener)) {
            return;
        }
        a(pallyConEventListener);
    }

    public final PallyConCallback d() {
        return this.f1335b;
    }

    public final void e(ContentData contentData) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onStopped(contentData);
        }
    }

    public final void a(CmcdConfiguration.Factory factory) {
        this.f1336c = factory;
    }

    public final void b(PallyConEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f1337d.remove(listener);
    }

    public final void d(ContentData contentData) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onRestarting(contentData);
        }
    }

    public final void a(Object obj) {
        this.f1338e = obj;
    }

    public final void b(ContentData contentData) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onPaused(contentData);
        }
    }

    public final void a(PallyConCallback pallyConCallback) {
        this.f1335b = pallyConCallback;
    }

    public final boolean a(Context context, String licenseCipherPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(licenseCipherPath, "licenseCipherPath");
        if (this.f1338e != null) {
            return true;
        }
        try {
            Object obj = Class.forName("com.pallycon.licensecipher.LicenseCipher").getField("Companion").get(null);
            Method method = obj.getClass().getMethod("createLicenseCipher", Context.class, String.class);
            method.setAccessible(true);
            this.f1338e = method.invoke(obj, context, licenseCipherPath);
            return true;
        } catch (ClassNotFoundException | Exception unused) {
            return false;
        }
    }

    public final void c(ContentData contentData) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onRemoved(contentData);
        }
    }

    public final boolean a(byte[] input, byte[] output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        try {
            Object obj = this.f1338e;
            if (obj == null) {
                return false;
            }
            Method declaredMethod = Class.forName("com.pallycon.licensecipher.LicenseCipher").getDeclaredMethod("doCipher", byte[].class, byte[].class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(obj, input, output);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (ClassNotFoundException | Exception unused) {
            return false;
        }
    }

    public final void a(PallyConEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f1337d.addIfAbsent(listener);
    }

    public final void a(ContentData contentData) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onCompleted(contentData);
        }
    }

    public final void a(ContentData contentData, float f2, long j) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onProgress(contentData, f2, j);
        }
    }

    public final void a(ContentData contentData, PallyConException pallyConException) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onFailed(contentData, pallyConException);
        }
    }

    public final void a(ContentData contentData, PallyConLicenseServerException pallyConLicenseServerException) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Iterator<T> it = this.f1337d.iterator();
        while (it.hasNext()) {
            ((PallyConEventListener) it.next()).onFailed(contentData, pallyConLicenseServerException);
        }
    }
}
