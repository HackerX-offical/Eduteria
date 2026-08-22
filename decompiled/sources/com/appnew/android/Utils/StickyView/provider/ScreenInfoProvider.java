package com.appnew.android.Utils.StickyView.provider;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.appnew.android.Utils.StickyView.provider.interfaces.IScreenInfoProvider;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes6.dex */
@ParametersAreNonnullByDefault
public class ScreenInfoProvider implements IScreenInfoProvider {
    private final Context mContext;

    public ScreenInfoProvider(Context context) {
        this.mContext = context;
    }

    @Override // com.appnew.android.Utils.StickyView.provider.interfaces.IScreenInfoProvider
    public int getScreenHeight() {
        return getDeviceDimension().y;
    }

    @Override // com.appnew.android.Utils.StickyView.provider.interfaces.IScreenInfoProvider
    public int getScreenWidth() {
        return getDeviceDimension().x;
    }

    Point getDeviceDimension() {
        Point point = new Point();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        return point;
    }
}
