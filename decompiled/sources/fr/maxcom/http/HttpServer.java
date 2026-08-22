package fr.maxcom.http;

import android.webkit.JavascriptInterface;
import androidx.documentfile.provider.DocumentFile;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes9.dex */
public interface HttpServer {

    public interface JsInterface {
        @JavascriptInterface
        String getURL(int i, int i2, String str);

        @JavascriptInterface
        String getURL(String str);

        @JavascriptInterface
        String getURL(String str, String str2);
    }

    JsInterface getJsInterfaceObject();

    String getURL(int i, int i2, String str);

    String getURL(DocumentFile documentFile);

    String getURL(String str);

    String getURL(String str, String str2);

    HttpServer setCipher(Cipher cipher);

    HttpServer setCipherFactory(CipherFactory cipherFactory);

    HttpServer setDataSource(DataSource dataSource);

    void start();

    void stop();
}
