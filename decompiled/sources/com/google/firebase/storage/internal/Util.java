package com.google.firebase.storage.internal;

import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import cz.msebera.android.httpclient.HttpHost;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class Util {
    public static final String ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final int MAXIMUM_TOKEN_WAIT_TIME_MS = 30000;
    public static final int NETWORK_UNAVAILABLE = -2;
    private static final String TAG = "StorageUtil";

    public static long parseDateTime(String str) {
        if (str == null) {
            return 0L;
        }
        String strReplaceAll = str.replaceAll("Z$", "-0000");
        try {
            return new SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault()).parse(strReplaceAll).getTime();
        } catch (ParseException e2) {
            Log.w(TAG, "unable to parse datetime:" + strReplaceAll, e2);
            return 0L;
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        return Objects.equal(obj, obj2);
    }

    private static String getAuthority() throws RemoteException {
        return NetworkRequest.getAuthority();
    }

    public static Uri normalize(FirebaseApp firebaseApp, String str) throws UnsupportedEncodingException {
        String strSubstring;
        String strSubstring2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().startsWith("gs://")) {
            return Uri.parse("gs://" + Slashes.preserveSlashEncode(Slashes.normalizeSlashes(str.substring(5))));
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme == null || (!equals(scheme.toLowerCase(), HttpHost.DEFAULT_SCHEME_NAME) && !equals(scheme.toLowerCase(), TournamentShareDialogURIBuilder.scheme))) {
            Log.w(TAG, "FirebaseStorage is unable to support the scheme:" + scheme);
            throw new IllegalArgumentException("Uri scheme");
        }
        try {
            int iIndexOf = uri.getAuthority().toLowerCase().indexOf(getAuthority());
            String strSlashize = Slashes.slashize(uri.getEncodedPath());
            if (iIndexOf == 0 && strSlashize.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                int iIndexOf2 = strSlashize.indexOf("/b/", 0);
                int i = iIndexOf2 + 3;
                int iIndexOf3 = strSlashize.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR, i);
                int iIndexOf4 = strSlashize.indexOf("/o/", 0);
                if (iIndexOf2 != -1 && iIndexOf3 != -1) {
                    strSubstring = strSlashize.substring(i, iIndexOf3);
                    if (iIndexOf4 != -1) {
                        strSubstring2 = strSlashize.substring(iIndexOf4 + 3);
                    } else {
                        strSubstring2 = "";
                    }
                    strSlashize = strSubstring2;
                } else {
                    Log.w(TAG, "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                    throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                }
            } else if (iIndexOf > 1) {
                strSubstring = uri.getAuthority().substring(0, iIndexOf - 1);
            } else {
                Log.w(TAG, "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
            }
            Preconditions.checkNotEmpty(strSubstring, "No bucket specified");
            return new Uri.Builder().scheme("gs").authority(strSubstring).encodedPath(strSlashize).build();
        } catch (RemoteException unused) {
            throw new UnsupportedEncodingException("Could not parse Url because the Storage network layer did not load");
        }
    }

    public static String getCurrentAuthToken(InternalAuthProvider internalAuthProvider) {
        String token;
        if (internalAuthProvider != null) {
            try {
                token = ((GetTokenResult) Tasks.await(internalAuthProvider.getAccessToken(false), 30000L, TimeUnit.MILLISECONDS)).getToken();
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                Log.e(TAG, "error getting token " + e2);
            }
        } else {
            token = null;
        }
        if (!TextUtils.isEmpty(token)) {
            return token;
        }
        Log.w(TAG, "no auth token for request");
        return null;
    }
}
