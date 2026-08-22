package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class ImageFill extends JsObject implements Fill {
    public ImageFill(ImageFillMode imageFillMode, Number number, String str) {
        this.js.append(String.format(Locale.US, "{mode:%s, opacity: %s, src: %s, } ", imageFillMode != null ? imageFillMode.getJsBase() : null, number, wrapQuotes(str)));
    }

    public ImageFill(String str, Number number, String str2) {
        this.js.append(String.format(Locale.US, "{mode:%s, opacity: %s, src: %s, } ", wrapQuotes(str), number, wrapQuotes(str2)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
