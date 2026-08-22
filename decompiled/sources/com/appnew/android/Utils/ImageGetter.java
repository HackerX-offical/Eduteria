package com.appnew.android.Utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.Html;

/* JADX INFO: loaded from: classes6.dex */
public class ImageGetter implements Html.ImageGetter {
    Activity activity;

    public ImageGetter(Activity activity) {
        this.activity = activity;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String source) {
        int identifier = this.activity.getResources().getIdentifier(source, "drawable", this.activity.getPackageName());
        if (identifier == 0) {
            identifier = this.activity.getResources().getIdentifier(source, "drawable", "android");
        }
        if (identifier == 0) {
            return null;
        }
        Drawable drawable = this.activity.getResources().getDrawable(identifier);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }
}
