package com.billdesk.utils;

import a.a.b.c;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes6.dex */
public class XMLParser extends DefaultHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f555b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<c> f554a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f556c = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        this.f555b.append(new String(cArr, i, i2));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("cardlist")) {
            String str4 = "cardsList[" + this.f555b.toString() + Constants.AES_SUFFIX;
            c cVar = this.f556c;
            this.f555b.toString();
            cVar.getClass();
            return;
        }
        if (str2.equalsIgnoreCase("banklist")) {
            String str5 = "Amit banklist[" + this.f555b.toString() + Constants.AES_SUFFIX;
            c cVar2 = this.f556c;
            this.f555b.toString();
            cVar2.getClass();
            return;
        }
        if (str2.equalsIgnoreCase("msg")) {
            String str6 = "msg[" + this.f555b.toString() + Constants.AES_SUFFIX;
            c cVar3 = this.f556c;
            this.f555b.toString();
            cVar3.getClass();
            this.f554a.add(this.f556c);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        this.f554a = new ArrayList();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f555b = new StringBuilder();
        if (str2.equals("cardlist")) {
            this.f556c = new c();
        }
    }
}
