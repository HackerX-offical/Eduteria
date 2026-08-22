package clientRequestsApi;

import helper.ToStringConverterFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes4.dex */
public class ApiClient {
    private static Retrofit retrofit;

    public static Retrofit getClient(String str) {
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(str).addConverterFactory(new ToStringConverterFactory()).client(getHttpClient()).build();
        retrofit = retrofitBuild;
        return retrofitBuild;
    }

    private static OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS).build();
    }
}
