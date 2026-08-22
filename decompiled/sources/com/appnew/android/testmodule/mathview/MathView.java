package com.appnew.android.testmodule.mathview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.R;
import com.x5.template.Chunk;
import com.x5.template.Theme;
import com.x5.template.providers.AndroidTemplates;

/* JADX INFO: loaded from: classes6.dex */
public class MathView extends WebView {
    private String mConfig;
    private int mEngine;
    private String mText;

    public static class Engine {
        public static final int KATEX = 0;
        public static final int MATHJAX = 1;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public MathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        setBackgroundColor(0);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MathView, 0, 0);
        try {
            setEngine(typedArrayObtainStyledAttributes.getInteger(0, 0));
            setText(typedArrayObtainStyledAttributes.getString(1));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private Chunk getChunk() {
        String str;
        AndroidTemplates androidTemplates = new AndroidTemplates(getContext());
        if (this.mEngine == 1) {
            str = "mathjax";
        } else {
            str = "katex";
        }
        return new Theme(androidTemplates).makeChunk(str);
    }

    public void setText(String text) {
        this.mText = text;
        Chunk chunk = getChunk();
        chunk.set("formula", this.mText);
        chunk.set("config", this.mConfig);
        loadDataWithBaseURL(null, chunk.toString(), Mimetypes.MIMETYPE_HTML, "utf-8", "about:blank");
    }

    public String getText() {
        return this.mText;
    }

    public void config(String config) {
        if (this.mEngine == 1) {
            this.mConfig = config;
        }
    }

    public void setEngine(int engine) {
        if (engine == 0) {
            this.mEngine = 0;
        } else if (engine == 1) {
            this.mEngine = 1;
        } else {
            this.mEngine = 0;
        }
    }
}
