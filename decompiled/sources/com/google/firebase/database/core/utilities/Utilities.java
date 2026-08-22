package com.google.firebase.database.core.utilities;

import android.net.Uri;
import android.util.Base64;
import androidx.collection.SieveCacheKt;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class Utilities {
    private static final char[] HEX_CHARACTERS = "0123456789abcdef".toCharArray();

    public static int compareInts(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compareLongs(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static ParsedUrl parseUrl(String str) throws DatabaseException {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (scheme == null) {
                throw new IllegalArgumentException("Database URL does not specify a URL scheme");
            }
            String host = uri.getHost();
            if (host == null) {
                throw new IllegalArgumentException("Database URL does not specify a valid host");
            }
            RepoInfo repoInfo = new RepoInfo();
            repoInfo.host = host.toLowerCase();
            int port = uri.getPort();
            boolean z = true;
            if (port != -1) {
                if (!scheme.equals(TournamentShareDialogURIBuilder.scheme) && !scheme.equals("wss")) {
                    z = false;
                }
                repoInfo.secure = z;
                repoInfo.host += ":" + port;
            } else {
                repoInfo.secure = true;
            }
            String queryParameter = uri.getQueryParameter("ns");
            if (queryParameter != null) {
                repoInfo.namespace = queryParameter;
            } else {
                repoInfo.namespace = host.split("\\.", -1)[0].toLowerCase();
            }
            repoInfo.internalHost = repoInfo.host;
            String strReplace = extractPathString(str).replace(MqttTopic.SINGLE_LEVEL_WILDCARD, " ");
            Validation.validateRootPathString(strReplace);
            ParsedUrl parsedUrl = new ParsedUrl();
            parsedUrl.path = new Path(strReplace);
            parsedUrl.repoInfo = repoInfo;
            return parsedUrl;
        } catch (Exception e2) {
            throw new DatabaseException("Invalid Firebase Database url specified: " + str, e2);
        }
    }

    private static String extractPathString(String str) {
        int iIndexOf = str.indexOf("//");
        if (iIndexOf == -1) {
            throw new DatabaseException("Firebase Database URL is missing URL scheme");
        }
        String strSubstring = str.substring(iIndexOf + 2);
        int iIndexOf2 = strSubstring.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (iIndexOf2 != -1) {
            int iIndexOf3 = strSubstring.indexOf("?");
            if (iIndexOf3 != -1) {
                return strSubstring.substring(iIndexOf2 + 1, iIndexOf3);
            }
            return strSubstring.substring(iIndexOf2 + 1);
        }
        return "";
    }

    public static String sha1HexDigest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e2);
        }
    }

    public static String stringHashV2Representation(String str) {
        String strReplace = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            strReplace = strReplace.replace("\"", "\\\"");
        }
        return "\"" + strReplace + '\"';
    }

    public static String doubleToHashString(double d2) {
        StringBuilder sb = new StringBuilder(16);
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        for (int i = 7; i >= 0; i--) {
            int i2 = (int) ((jDoubleToLongBits >>> (i * 8)) & 255);
            char[] cArr = HEX_CHARACTERS;
            sb.append(cArr[(i2 >> 4) & 15]);
            sb.append(cArr[i2 & 15]);
        }
        return sb.toString();
    }

    public static Integer tryParseInt(String str) {
        boolean z;
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            z = true;
            if (str.length() == 1) {
                return null;
            }
            i = 1;
        } else {
            z = false;
        }
        long j = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            j = (j * 10) + ((long) (cCharAt - '0'));
            i++;
        }
        if (!z) {
            if (j > SieveCacheKt.NodeLinkMask) {
                return null;
            }
            return Integer.valueOf((int) j);
        }
        long j2 = -j;
        if (j2 < SieveCacheKt.NodeMetaAndPreviousMask) {
            return null;
        }
        return Integer.valueOf((int) j2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <C> C castOrNull(Object obj, Class<C> cls) {
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        return null;
    }

    public static <C> C getOrNull(Object obj, String str, Class<C> cls) {
        Object obj2;
        if (obj == null || (obj2 = ((Map) castOrNull(obj, Map.class)).get(str)) == null) {
            return null;
        }
        return (C) castOrNull(obj2, cls);
    }

    public static void hardAssert(boolean z) {
        hardAssert(z, "");
    }

    public static void hardAssert(boolean z, String str) {
        if (!z) {
            throw new AssertionError("hardAssert failed: " + str);
        }
    }

    public static Pair<Task<Void>, DatabaseReference.CompletionListener> wrapOnComplete(DatabaseReference.CompletionListener completionListener) {
        if (completionListener == null) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            return new Pair<>(taskCompletionSource.getTask(), new DatabaseReference.CompletionListener() { // from class: com.google.firebase.database.core.utilities.Utilities.1
                @Override // com.google.firebase.database.DatabaseReference.CompletionListener
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        taskCompletionSource.setException(databaseError.toException());
                    } else {
                        taskCompletionSource.setResult(null);
                    }
                }
            });
        }
        return new Pair<>(null, completionListener);
    }
}
