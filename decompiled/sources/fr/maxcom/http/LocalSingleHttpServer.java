package fr.maxcom.http;

import androidx.documentfile.provider.DocumentFile;
import fr.maxcom.http.HttpServer;
import fr.maxcom.http.a;
import java.io.IOException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes9.dex */
public class LocalSingleHttpServer extends a {
    public LocalSingleHttpServer() throws IOException {
        super(a.e.LOCAL);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ HttpServer.JsInterface getJsInterfaceObject() {
        return super.getJsInterfaceObject();
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ String getURL(int i, int i2, String str) {
        return super.getURL(i, i2, str);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ HttpServer setCipher(Cipher cipher) {
        return super.setCipher(cipher);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ HttpServer setCipherFactory(CipherFactory cipherFactory) {
        return super.setCipherFactory(cipherFactory);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ HttpServer setDataSource(DataSource dataSource) {
        return super.setDataSource(dataSource);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ String getURL(DocumentFile documentFile) {
        return super.getURL(documentFile);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ String getURL(String str) {
        return super.getURL(str);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ String getURL(String str, String str2) {
        return super.getURL(str, str2);
    }
}
