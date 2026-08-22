package h;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.clevertap.android.sdk.Constants;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (request.header(CmcdConfiguration.KEY_CMCD_SESSION) == null) {
            return chain.proceed(request);
        }
        HttpUrl.Builder builderNewBuilder = request.url().newBuilder();
        StringBuilder sb = new StringBuilder();
        Iterator<Pair<? extends String, ? extends String>> it = request.headers().iterator();
        while (it.hasNext()) {
            sb.append(StringsKt.removeSurrounding(StringsKt.trim((CharSequence) it.next().component2()).toString(), (CharSequence) "\"")).append(Constants.SEPARATOR_COMMA);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            builderNewBuilder.addQueryParameter(CmcdConfiguration.CMCD_QUERY_PARAMETER_KEY, sb.toString());
        }
        Request requestBuild = request.newBuilder().url(builderNewBuilder.build()).build();
        RequestBody requestBodyBody = requestBuild.body();
        if (requestBodyBody != null) {
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            System.out.println((Object) ("Request Body: " + buffer.readUtf8()));
        }
        return chain.proceed(requestBuild);
    }
}
