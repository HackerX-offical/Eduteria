package f;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import com.pallycon.widevine.exception.PallyConException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1247a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context, String cid, String siteId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cid, "cid");
            Intrinsics.checkNotNullParameter(siteId, "siteId");
            return new b(context).b(cid, siteId) != null && b.a.f244c.a(context).a(cid).length() == 0;
        }

        public final boolean b(Context context, String cid, String siteId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cid, "cid");
            Intrinsics.checkNotNullParameter(siteId, "siteId");
            try {
                return new b(context).a(cid, siteId);
            } catch (SQLiteException unused) {
                return false;
            }
        }

        public a() {
        }

        public static /* synthetic */ boolean a(a aVar, Context context, String str, String str2, String str3, String str4, String str5, c.a aVar2, int i, Object obj) {
            if ((i & 32) != 0) {
                str5 = null;
            }
            return aVar.a(context, str, str2, str3, str4, str5, aVar2);
        }

        public final boolean a(Context context, String url, String cid, String siteId, String contentName, String str, c.a downloadManager) throws IOException {
            String str2;
            String str3;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(cid, "cid");
            Intrinsics.checkNotNullParameter(siteId, "siteId");
            Intrinsics.checkNotNullParameter(contentName, "contentName");
            Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
            b bVar = new b(context);
            b.a aVarA = b.a.f244c.a(context);
            c cVarB = bVar.b(cid, siteId);
            if (cVarB != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() - ((long) DateTimeConstants.MILLIS_PER_DAY);
                Object obj = null;
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    Intrinsics.checkNotNull(externalFilesDir);
                    File fileE = h.d.m.a().e(context);
                    String absolutePath = externalFilesDir.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    String absolutePath2 = fileE.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                    if (!StringsKt.contains((CharSequence) absolutePath, (CharSequence) absolutePath2, true)) {
                        try {
                            String absolutePath3 = externalFilesDir.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
                            if (StringsKt.contains$default((CharSequence) url, (CharSequence) absolutePath3, false, 2, (Object) null) && contentName.length() == 0 && str == null) {
                                aVarA.b(cid, url);
                                str3 = url;
                            } else {
                                if (str == null) {
                                    str2 = externalFilesDir.getAbsolutePath() + '/' + contentName;
                                } else {
                                    str2 = externalFilesDir.getAbsolutePath() + '/' + str + '/' + contentName;
                                }
                                File file = new File(str2);
                                str3 = url;
                                String strSubstring = str3.substring(StringsKt.lastIndexOf$default((CharSequence) str3, MqttTopic.TOPIC_LEVEL_SEPARATOR, 0, false, 6, (Object) null) + 1);
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                aVarA.b(cid, file.getAbsolutePath() + '/' + strSubstring);
                            }
                            System.out.println((Object) "Directory moved successfully.");
                            downloadManager.a(str3, cid, cVarB.d(), jCurrentTimeMillis);
                            Iterator<T> it = downloadManager.a().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                byte[] bArr = (byte[]) next;
                                if (bArr.length == cVarB.d().length) {
                                    byte[] bArrD = cVarB.d();
                                    ArrayList arrayList = new ArrayList();
                                    for (byte b2 : bArrD) {
                                        if (!ArraysKt.contains(bArr, b2)) {
                                            arrayList.add(Byte.valueOf(b2));
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        obj = next;
                                        break;
                                    }
                                }
                            }
                            if (obj != null) {
                                return true;
                            }
                        } catch (Exception e2) {
                            throw new PallyConException.MigrationException(e2, "failed move the content");
                        }
                    } else {
                        throw new PallyConException.MigrationLocalPathException(null, "The download directory location must be different from the existing download location.");
                    }
                } else {
                    throw new PallyConException.MigrationException(null, "getExternalFilesDir exception");
                }
            }
            return false;
        }
    }
}
