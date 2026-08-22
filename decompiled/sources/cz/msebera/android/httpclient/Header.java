package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes9.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
