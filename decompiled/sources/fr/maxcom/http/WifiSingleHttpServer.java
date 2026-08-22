package fr.maxcom.http;

import androidx.documentfile.provider.DocumentFile;
import com.google.android.gms.cast.CastDevice;
import fr.maxcom.http.HttpServer;
import fr.maxcom.http.a;
import java.io.IOException;
import java.net.InetAddress;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes9.dex */
public class WifiSingleHttpServer extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InetAddress f1280a;

    public WifiSingleHttpServer() throws IOException {
        super(a.e.WIFI);
    }

    @Override // fr.maxcom.http.a
    boolean a(InetAddress inetAddress) {
        InetAddress inetAddress2 = this.f1280a;
        return inetAddress2 != null && inetAddress2.equals(inetAddress);
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ HttpServer.JsInterface getJsInterfaceObject() {
        return super.getJsInterfaceObject();
    }

    @Override // fr.maxcom.http.a, fr.maxcom.http.HttpServer
    public /* bridge */ /* synthetic */ String getURL(int i, int i2, String str) {
        return super.getURL(i, i2, str);
    }

    public WifiSingleHttpServer setAllowedClient(CastDevice castDevice) {
        this.f1280a = castDevice != null ? castDevice.getInetAddress() : null;
        return this;
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

    public WifiSingleHttpServer setAllowedClient(InetAddress inetAddress) {
        this.f1280a = inetAddress;
        return this;
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
