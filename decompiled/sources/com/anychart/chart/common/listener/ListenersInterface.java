package com.anychart.chart.common.listener;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.clevertap.android.sdk.Constants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class ListenersInterface {
    private static volatile ListenersInterface instance;
    private OnClickListener listener;

    private interface ClickListener {
        void onClick(Event event);
    }

    private ListenersInterface() {
    }

    public static ListenersInterface getInstance() {
        if (instance == null) {
            synchronized (ListenersInterface.class) {
                if (instance == null) {
                    instance = new ListenersInterface();
                }
            }
        }
        return instance;
    }

    public static abstract class OnClickListener implements ClickListener {
        private String[] fields;

        public OnClickListener() {
        }

        public OnClickListener(String[] strArr) {
            this.fields = strArr;
        }

        public String[] getFields() {
            return this.fields;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    @JavascriptInterface
    public void onClick(String str) {
        if (TextUtils.isEmpty(str)) {
            this.listener.onClick(new Event(null));
            return;
        }
        HashMap map = new HashMap();
        for (String str2 : str.split(Constants.SEPARATOR_COMMA)) {
            String[] strArrSplit = str2.split(":");
            map.put(strArrSplit[0], strArrSplit[1]);
        }
        this.listener.onClick(new Event(map));
    }
}
