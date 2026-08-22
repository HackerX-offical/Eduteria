package a.a.a.b;

import android.content.Context;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static HttpURLConnection a(Context context, String str) {
        return str.startsWith(TournamentShareDialogURIBuilder.scheme) ? (HttpsURLConnection) new URL(str).openConnection() : (HttpURLConnection) new URL(str).openConnection();
    }
}
