package fr.maxcom.http;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class Diagnostic {
    public final Code code;
    public final String extra;

    public enum Code {
        PROXY
    }

    private Diagnostic(Code code, String str) {
        this.code = code;
        this.extra = str;
    }

    public static List<Diagnostic> diagnose() {
        Proxy proxy;
        ArrayList arrayList = new ArrayList();
        ProxySelector proxySelector = ProxySelector.getDefault();
        if (proxySelector != null) {
            try {
                List<Proxy> listSelect = proxySelector.select(new URI("http://127.0.0.1/"));
                if (!listSelect.isEmpty() && (proxy = listSelect.get(0)) != Proxy.NO_PROXY) {
                    arrayList.add(new Diagnostic(Code.PROXY, proxy.toString()));
                }
            } catch (URISyntaxException unused) {
            }
        }
        return arrayList;
    }
}
