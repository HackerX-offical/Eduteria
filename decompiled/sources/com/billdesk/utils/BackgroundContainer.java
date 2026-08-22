package com.billdesk.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes6.dex */
public class BackgroundContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f475e;

    public BackgroundContainer(Context context) {
        super(context);
        this.f471a = false;
        this.f475e = false;
        b();
    }

    public final void a() {
        setWillNotDraw(true);
        this.f471a = false;
    }

    public final void b() {
        byte[] bArrDecode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAAAQSURBVHjaYli1alUDQIABAAZ/An/ldNSWAAAAAElFTkSuQmCC", 0);
        this.f472b = new BitmapDrawable(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f471a) {
            if (this.f475e) {
                this.f472b.setBounds(0, 0, getWidth(), this.f474d);
            }
            canvas.save();
            canvas.translate(0.0f, this.f473c);
            this.f472b.draw(canvas);
            canvas.restore();
        }
    }
}
