package com.microsoft.clarity.e;

import android.content.Context;
import android.net.Uri;
import com.appnew.android.Utils.StoreProvider;
import com.microsoft.clarity.ClarityConfig;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClarityConfig f794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, byte[], Unit> f795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Regex f796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Regex f797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Regex f798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Regex f799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Regex f800h;
    public final LinkedHashMap i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f804d;

        public a(String assetPath, int i, String absoluteUrl, int i2) {
            Intrinsics.checkNotNullParameter(assetPath, "assetPath");
            Intrinsics.checkNotNullParameter(absoluteUrl, "absoluteUrl");
            this.f801a = i;
            this.f802b = i2;
            this.f803c = assetPath;
            this.f804d = absoluteUrl;
        }

        public final String a() {
            return this.f804d;
        }

        public final String b() {
            return this.f803c;
        }

        public final int c() {
            return this.f801a;
        }

        public final int d() {
            return this.f802b;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f806b;

        public b(c metadata, byte[] content) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            Intrinsics.checkNotNullParameter(content, "content");
            this.f805a = metadata;
            this.f806b = content;
        }

        public final byte[] a() {
            return this.f806b;
        }

        public final c b() {
            return this.f805a;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f812f;

        public c(String path, boolean z, String hash, String pathWithHash, String absolutePathWithHash, Long l, List<String> dependencies) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(pathWithHash, "pathWithHash");
            Intrinsics.checkNotNullParameter(absolutePathWithHash, "absolutePathWithHash");
            Intrinsics.checkNotNullParameter(dependencies, "dependencies");
            this.f807a = path;
            this.f808b = z;
            this.f809c = pathWithHash;
            this.f810d = absolutePathWithHash;
            this.f811e = l;
            this.f812f = dependencies;
        }

        public final String a() {
            return this.f810d;
        }

        public final List<String> b() {
            return this.f812f;
        }

        public final Long c() {
            return this.f811e;
        }

        public final String d() {
            return this.f807a;
        }

        public final String e() {
            return this.f809c;
        }

        public final boolean f() {
            return this.f808b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Context context, ClarityConfig config, Function2<? super String, ? super byte[], Unit> webAssetCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(webAssetCallback, "webAssetCallback");
        this.f793a = context;
        this.f794b = config;
        this.f795c = webAssetCallback;
        this.f796d = new Regex("\\[ClarityStyleContent]|\\[/ClarityStyleContent]|\\[ClarityLocalURL]|\\[/ClarityLocalURL]");
        this.f797e = new Regex("\\[ClarityLocalURL](.*?)\\[/ClarityLocalURL]");
        this.f798f = new Regex("\\[ClarityStyleContent](.*?)\\[/ClarityStyleContent]");
        this.f799g = new Regex("url\\((?:'|\\\\\"|\")?(.*?)(?:'|\\\\\"|\")?\\)");
        this.f800h = new Regex("@import\\s(?:'|\\\\\"|\")(.*?)(?:'|\\\\\"|\");");
        this.i = new LinkedHashMap();
    }

    public final a a(String str, String str2, boolean z, int i, int i2, int i3) {
        File file;
        InputStream fileInputStream;
        if (i3 > 6) {
            return null;
        }
        try {
            boolean zD = d(str);
            boolean zA = zD ? a(new URL(str)) : z;
            String strA = a(str2, str, zD);
            if (this.i.containsKey(strA) && !b(strA) && !a(strA)) {
                Object obj = this.i.get(strA);
                Intrinsics.checkNotNull(obj);
                return new a(strA, i, ((c) obj).a(), i2);
            }
            if (zA) {
                fileInputStream = this.f793a.getAssets().open(strA);
                file = null;
            } else {
                file = new File(strA);
                fileInputStream = new FileInputStream(file);
            }
            Intrinsics.checkNotNullExpressionValue(fileInputStream, "if (isContextAsset) {\n  …e.inputStream()\n        }");
            Long lValueOf = file != null ? Long.valueOf(file.lastModified()) : null;
            List listEmptyList = CollectionsKt.emptyList();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(StringUtils.MD5);
                byte[] bytes = ByteStreamsKt.readBytes(new DigestInputStream(fileInputStream, messageDigest));
                String contentHash = Base64.getUrlEncoder().encodeToString(messageDigest.digest());
                Intrinsics.checkNotNullExpressionValue(contentHash, "contentHash");
                String string = StringsKt.replaceRange((CharSequence) strA, com.microsoft.clarity.n.f.a(strA), (CharSequence) contentHash).toString();
                b bVar = new b(new c(strA, zA, contentHash, string, c(string), lValueOf, listEmptyList), bytes);
                CloseableKt.closeFinally(fileInputStream, null);
                if (StringsKt.endsWith$default(bVar.b().d(), ".css", false, 2, (Object) null)) {
                    bVar = a(bVar, zA, i3 + 1);
                }
                this.i.put(bVar.b().d(), bVar.b());
                this.f795c.invoke(bVar.b().e(), bVar.a());
                return new a(strA, i, bVar.b().a(), i2);
            } finally {
            }
        } catch (Exception e2) {
            com.microsoft.clarity.n.i.c("Failed to process local URL " + str + ", " + e2.getMessage() + '!');
            return null;
        }
    }

    public final String a(URL url, boolean z) {
        String str;
        String path = url.getPath();
        if (Intrinsics.areEqual(url.getProtocol(), "file")) {
            Intrinsics.checkNotNullExpressionValue(path, "path");
            str = "/android_asset";
        } else {
            if (!Intrinsics.areEqual(url.getHost(), "appassets.androidplatform.net")) {
                if (this.f794b.isIonic$sdk_prodRelease() && Intrinsics.areEqual(url.getHost(), "localhost") && z) {
                    path = MqttTopic.TOPIC_LEVEL_SEPARATOR;
                }
                Intrinsics.checkNotNullExpressionValue(path, "path");
                return path;
            }
            Intrinsics.checkNotNullExpressionValue(path, "path");
            str = "assets";
        }
        path = StringsKt.removePrefix(path, (CharSequence) str);
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return path;
    }

    public final void a() {
        this.i.clear();
    }

    public final boolean a(String str) {
        List<String> listEmptyList;
        c cVar = (c) this.i.get(str);
        if (cVar == null || (listEmptyList = cVar.b()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (String str2 : listEmptyList) {
            if (b(str2) || a(str2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(URL url) {
        if (Intrinsics.areEqual(url.getProtocol(), "file")) {
            String path = url.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "url.path");
            if (StringsKt.startsWith$default(path, "/android_asset", false, 2, (Object) null)) {
                return true;
            }
        }
        if (Intrinsics.areEqual(url.getHost(), "appassets.androidplatform.net")) {
            return true;
        }
        return (this.f794b.isIonic$sdk_prodRelease() || this.f794b.isCordova$sdk_prodRelease()) && Intrinsics.areEqual(url.getHost(), "localhost");
    }

    public final boolean b(String str) {
        Long lC;
        c cVar = (c) this.i.get(str);
        if (Intrinsics.areEqual(cVar != null ? Boolean.valueOf(cVar.f()) : null, Boolean.TRUE)) {
            return false;
        }
        c cVar2 = (c) this.i.get(str);
        return new File(str).lastModified() > ((cVar2 == null || (lC = cVar2.c()) == null) ? 0L : lC.longValue());
    }

    public final String c(String str) {
        String string = Uri.parse("https://clarity.microsoft.com/").buildUpon().appendPath(StoreProvider.StoreData.APP).appendPath("webasset").appendPath("v1").appendPath(this.f794b.getProjectId()).appendPath("*clarity-playback-token-placeholder*").appendPath("all").appendEncodedPath(str).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(BuildConfig.WEB_AS…)\n            .toString()");
        return string;
    }

    public final boolean d(String str) {
        try {
            URL url = new URL(str);
            if (Intrinsics.areEqual(url.getProtocol(), "file") || Intrinsics.areEqual(url.getHost(), "appassets.androidplatform.net")) {
                return true;
            }
            if (this.f794b.isIonic$sdk_prodRelease() || this.f794b.isCordova$sdk_prodRelease()) {
                return Intrinsics.areEqual(url.getHost(), "localhost");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final ArrayList a(String str, String str2, boolean z, int i, int i2) {
        h hVar = this;
        Sequence<MatchResult> sequencePlus = SequencesKt.plus(Regex.findAll$default(hVar.f799g, str, 0, 2, null), Regex.findAll$default(hVar.f800h, str, 0, 2, null));
        ArrayList arrayList = new ArrayList();
        for (MatchResult matchResult : sequencePlus) {
            String str3 = matchResult.getGroupValues().get(1);
            if ((StringsKt.indexOf$default((CharSequence) str3, "://", 0, false, 6, (Object) null) <= 0 && StringsKt.indexOf$default((CharSequence) str3, "//", 0, false, 6, (Object) null) != 0 && !StringsKt.startsWith$default(str3, "data:", false, 2, (Object) null)) || hVar.d(str3)) {
                String path = Uri.parse(str3).getPath();
                if (path != null) {
                    MatchGroup matchGroup = matchResult.getGroups().get(1);
                    Intrinsics.checkNotNull(matchGroup);
                    a aVarA = hVar.a(path, str2, z, matchGroup.getRange().getFirst() + i, (path.length() + r4) - 1, i2 + 1);
                    if (aVarA != null) {
                        arrayList.add(aVarA);
                    }
                    hVar = this;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.microsoft.clarity.models.ingest.WebViewMutationEvent r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.h.a(com.microsoft.clarity.models.ingest.WebViewMutationEvent):void");
    }

    public final String a(String str, String str2, boolean z) throws IOException {
        if (z) {
            return StringsKt.trimStart(a(new URL(str2), false), '/');
        }
        String canonicalPath = FilesKt.resolve(new File(str), StringsKt.trimStart(str2, '/')).getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath, "File(pageFolderPath)\n   …           .canonicalPath");
        String strTrimStart = StringsKt.trimStart(canonicalPath, '/');
        String str3 = this.f794b.isCordova$sdk_prodRelease() ? "www" : this.f794b.isIonic$sdk_prodRelease() ? HeaderConstants.PUBLIC : null;
        return (str3 == null || StringsKt.startsWith$default(strTrimStart, str3, false, 2, (Object) null)) ? strTrimStart : str3 + '/' + strTrimStart;
    }

    public final b a(b bVar, boolean z, int i) {
        String str = new String(bVar.a(), Charsets.UTF_8);
        ArrayList<a> arrayListA = a(str, StringsKt.substringBeforeLast(bVar.b().d(), '/', ""), z, 0, i);
        if (arrayListA.isEmpty()) {
            return bVar;
        }
        StringBuilder sb = new StringBuilder(str);
        if (arrayListA.size() > 1) {
            CollectionsKt.sortWith(arrayListA, new i());
        }
        for (a aVar : arrayListA) {
            sb.replace(aVar.c(), aVar.d() + 1, aVar.a());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "newDataBuilder.toString()");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        String strD = bVar.b().d();
        Long lC = bVar.b().c();
        boolean zF = bVar.b().f();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListA, 10));
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).b());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(StringUtils.MD5);
            byte[] bytes2 = ByteStreamsKt.readBytes(new DigestInputStream(byteArrayInputStream, messageDigest));
            String contentHash = Base64.getUrlEncoder().encodeToString(messageDigest.digest());
            Intrinsics.checkNotNullExpressionValue(contentHash, "contentHash");
            String string2 = StringsKt.replaceRange((CharSequence) strD, com.microsoft.clarity.n.f.a(strD), (CharSequence) contentHash).toString();
            b bVar2 = new b(new c(strD, zF, contentHash, string2, c(string2), lC, arrayList), bytes2);
            CloseableKt.closeFinally(byteArrayInputStream, null);
            return bVar2;
        } finally {
        }
    }
}
