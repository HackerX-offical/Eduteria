package d;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.MediaDrmCallback;
import androidx.media3.exoplayer.drm.MediaDrmCallbackException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.exception.PallyConLicenseServerException;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.model.PallyConCallback;
import com.pallycon.widevine.model.PallyConDrmConfigration;
import com.pallycon.widevine.model.PallyConLicenseResponse;
import com.pallycon.widevine.model.PallyConResponse;
import h.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements MediaDrmCallback {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f1147h = new a(null);
    public static final int i = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OkHttpDataSource.Factory f1149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentData f1150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super PallyConLicenseServerException, Unit> f1153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super PallyConException, Unit> f1154g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(HttpDataSource.InvalidResponseCodeException exception, int i) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            int i2 = exception.responseCode;
            if ((i2 == 307 || i2 == 308) && i < 5) {
                Map<String, List<String>> headerFields = exception.headerFields;
                Intrinsics.checkNotNullExpressionValue(headerFields, "headerFields");
                List<String> list = headerFields.get("Location");
                if (list != null && !list.isEmpty()) {
                    return list.get(0);
                }
            }
            return null;
        }

        public a() {
        }
    }

    public c(Context context, OkHttpDataSource.Factory factory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f1148a = context;
        this.f1149b = factory;
        this.f1151d = "";
        this.f1152e = "";
    }

    public final void a(ContentData contentData, String deviceInfo) {
        String token;
        String licenseCipherPath;
        Function1<? super PallyConException, Unit> function1;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.f1150c = contentData;
        PallyConDrmConfigration drmConfig = contentData.getDrmConfig();
        if (drmConfig == null || (token = drmConfig.getCustomData()) == null) {
            PallyConDrmConfigration drmConfig2 = contentData.getDrmConfig();
            token = drmConfig2 != null ? drmConfig2.getToken() : null;
            if (token == null) {
                token = "";
            }
        }
        this.f1151d = token;
        this.f1152e = deviceInfo;
        PallyConDrmConfigration drmConfig3 = contentData.getDrmConfig();
        if (drmConfig3 == null || (licenseCipherPath = drmConfig3.getLicenseCipherPath()) == null || e.f1332f.a().a(this.f1148a, licenseCipherPath) || (function1 = this.f1154g) == null) {
            return;
        }
        function1.invoke(new PallyConException.PallyConLicenseCipherException(null, "failed createLicenseCipher. LicenseCipher requires an implementation to use it."));
    }

    public final void b(Function1<? super PallyConException, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f1154g = callback;
    }

    public final boolean c(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "\"license\"", false, 2, (Object) null);
    }

    @Override // androidx.media3.exoplayer.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest request) {
        PallyConDrmConfigration drmConfig;
        PallyConDrmConfigration drmConfig2;
        String cookie;
        PallyConDrmConfigration drmConfig3;
        Map<String, String> httpHeaders;
        PallyConDrmConfigration drmConfig4;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(request, "request");
        ContentData contentData = this.f1150c;
        if (contentData == null) {
            if (((contentData == null || (drmConfig4 = contentData.getDrmConfig()) == null) ? null : drmConfig4.getDrmLicenseUrl()) == null) {
                Function1<? super PallyConException, Unit> function1 = this.f1154g;
                if (function1 != null) {
                    function1.invoke(new PallyConException.ContentDataException(null, "check a contentData. ex. drmConfig"));
                }
                return new byte[0];
            }
        }
        Map<String, String> map = new HashMap<>();
        if (Intrinsics.areEqual(C.PLAYREADY_UUID, uuid)) {
            map.put("Content-Type", "text/xml");
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        } else if (Intrinsics.areEqual(C.CLEARKEY_UUID, uuid)) {
            map.put("Content-Type", "application/json");
        } else {
            map.put("Content-Type", "application/octet-stream");
        }
        map.put(h.a.f1320e, this.f1151d);
        map.put(h.a.f1321f, this.f1152e);
        ContentData contentData2 = this.f1150c;
        if (contentData2 != null && (drmConfig3 = contentData2.getDrmConfig()) != null && (httpHeaders = drmConfig3.getHttpHeaders()) != null) {
            for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String key = entry.getKey();
                    Intrinsics.checkNotNull(key);
                    String value = entry.getValue();
                    Intrinsics.checkNotNull(value);
                    map.put(key, value);
                }
            }
        }
        ContentData contentData3 = this.f1150c;
        if (contentData3 != null && (drmConfig2 = contentData3.getDrmConfig()) != null && (cookie = drmConfig2.getCookie()) != null) {
            map.put("Cookie", cookie);
        }
        byte[] data = request.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        ContentData contentData4 = this.f1150c;
        if (contentData4 != null && (drmConfig = contentData4.getDrmConfig()) != null && drmConfig.getLicenseCipherPath() != null) {
            e eVarA = e.f1332f.a();
            if (eVarA.c() != null) {
                byte[] bArr = new byte[request.getData().length];
                byte[] data2 = request.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
                if (eVarA.a(data2, bArr)) {
                    data = bArr;
                } else {
                    Function1<? super PallyConException, Unit> function12 = this.f1154g;
                    if (function12 != null) {
                        function12.invoke(new PallyConException.PallyConLicenseCipherException(null, "failed encrypt for response"));
                    }
                }
            } else {
                Function1<? super PallyConException, Unit> function13 = this.f1154g;
                if (function13 != null) {
                    function13.invoke(new PallyConException.PallyConLicenseCipherException(null, "failed createLicenseCipher"));
                }
            }
        }
        ContentData contentData5 = this.f1150c;
        Intrinsics.checkNotNull(contentData5);
        return a(a(contentData5, data, map));
    }

    @Override // androidx.media3.exoplayer.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest request) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(request, "request");
        return a(this.f1149b, request.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(request.getData()), null, MapsKt.emptyMap());
    }

    public final PallyConResponse b(byte[] bArr) {
        try {
            String str = new String(bArr, Charsets.UTF_8);
            Gson gson = new Gson();
            if (b(str)) {
                Object objFromJson = gson.fromJson(str, (Class<Object>) b.class);
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                return new PallyConResponse.Error((b) objFromJson);
            }
            if (!c(str)) {
                return new PallyConResponse.RawData(bArr);
            }
            Object objFromJson2 = gson.fromJson(str, (Class<Object>) PallyConLicenseResponse.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson2, "fromJson(...)");
            return new PallyConResponse.License((PallyConLicenseResponse) objFromJson2);
        } catch (JsonSyntaxException unused) {
            return new PallyConResponse.RawData(bArr);
        }
    }

    public final void a(Function1<? super PallyConLicenseServerException, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f1153f = callback;
    }

    public final byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public final boolean b(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "\"errorCode\"", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "\"message\"", false, 2, (Object) null);
    }

    public final byte[] a(byte[] bArr) {
        PallyConResponse pallyConResponseB = b(bArr);
        if (pallyConResponseB instanceof PallyConResponse.Error) {
            return a(((PallyConResponse.Error) pallyConResponseB).getError());
        }
        if (pallyConResponseB instanceof PallyConResponse.License) {
            return a(((PallyConResponse.License) pallyConResponseB).getLicense().getLicense());
        }
        if (pallyConResponseB instanceof PallyConResponse.RawData) {
            return ((PallyConResponse.RawData) pallyConResponseB).getData();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final byte[] a(b bVar) {
        String strD = bVar.d();
        if (strD == null) {
            strD = "body is null";
        }
        Integer numE = bVar.e();
        int iIntValue = numE != null ? numE.intValue() : 0;
        String strF = bVar.f();
        if (strF == null) {
            strF = "message is null";
        }
        PallyConLicenseServerException pallyConLicenseServerException = new PallyConLicenseServerException(strD, iIntValue, strF);
        Function1<? super PallyConLicenseServerException, Unit> function1 = this.f1153f;
        if (function1 != null) {
            function1.invoke(pallyConLicenseServerException);
            throw pallyConLicenseServerException;
        }
        throw pallyConLicenseServerException;
    }

    public final byte[] a(ContentData contentData, byte[] bArr, Map<String, String> map) {
        byte[] bArrExecuteKeyRequest;
        PallyConCallback pallyConCallbackD = e.f1332f.a().d();
        if (pallyConCallbackD != null && (bArrExecuteKeyRequest = pallyConCallbackD.executeKeyRequest(contentData, bArr, map)) != null) {
            return bArrExecuteKeyRequest;
        }
        PallyConDrmConfigration drmConfig = contentData.getDrmConfig();
        String drmLicenseUrl = drmConfig != null ? drmConfig.getDrmLicenseUrl() : null;
        if (drmLicenseUrl != null && drmLicenseUrl.length() != 0) {
            return a(this.f1149b, drmLicenseUrl, bArr, map);
        }
        return new byte[0];
    }

    public final byte[] a(DataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        StatsDataSource statsDataSource = new StatsDataSource(factory.createDataSource());
        DataSpec dataSpecBuild = new DataSpec.Builder().setUri(str).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build();
        Intrinsics.checkNotNullExpressionValue(dataSpecBuild, "build(...)");
        int i2 = 0;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecBuild);
                try {
                    return ByteStreamsKt.readBytes(dataSourceInputStream);
                } catch (HttpDataSource.InvalidResponseCodeException e2) {
                    try {
                        String strA = f1147h.a(e2, i2);
                        if (strA != null) {
                            i2++;
                            dataSpecBuild.buildUpon().setUri(strA).build();
                            Util.closeQuietly(dataSourceInputStream);
                        } else {
                            throw e2;
                        }
                    } finally {
                        Util.closeQuietly(dataSourceInputStream);
                    }
                }
            } catch (Exception e3) {
                throw new MediaDrmCallbackException(dataSpecBuild, (Uri) Assertions.checkNotNull(statsDataSource.getLastOpenedUri()), statsDataSource.getResponseHeaders(), statsDataSource.getBytesRead(), e3);
            }
        }
    }
}
