package helper;

import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes9.dex */
public class ToStringConverterFactory extends Converter.Factory {
    private static final MediaType MEDIA_TYPE = MediaType.parse(HTTP.PLAIN_TEXT_TYPE);

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (String.class.equals(type)) {
            return new Converter<ResponseBody, String>() { // from class: helper.ToStringConverterFactory.1
                @Override // retrofit2.Converter
                public String convert(ResponseBody responseBody) throws IOException {
                    return responseBody.string();
                }
            };
        }
        return null;
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (String.class.equals(type)) {
            return new Converter<String, RequestBody>() { // from class: helper.ToStringConverterFactory.2
                @Override // retrofit2.Converter
                public RequestBody convert(String str) throws IOException {
                    return RequestBody.create(ToStringConverterFactory.MEDIA_TYPE, str);
                }
            };
        }
        return null;
    }
}
