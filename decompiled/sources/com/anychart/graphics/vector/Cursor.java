package com.anychart.graphics.vector;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum Cursor {
    CROSSHAIR("crosshair"),
    DEFAULT(CookieSpecs.DEFAULT),
    EW_RESIZE("ew-resize"),
    E_RESIZE("e-resize"),
    HELP("help"),
    MOVE("move"),
    NESW_RESIZE("nesw-resize"),
    NE_RESIZE("ne-resize"),
    NS_RESIZE("ns-resize"),
    NWSE_RESIZE("nwse-resize"),
    NW_RESIZE("nw-resize"),
    N_RESIZE("n-resize"),
    POINTER("pointer"),
    SE_RESIZE("se-resize"),
    SW_RESIZE("sw-resize"),
    S_RESIZE("s-resize"),
    TEXT("text"),
    WAIT("wait"),
    W_RESIZE("w-resize");

    private final String value;

    Cursor(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
