package com.appnew.android.Utils.StickyView.provider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.appnew.android.Utils.StickyView.provider.interfaces.IResourceProvider;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes6.dex */
@ParametersAreNonnullByDefault
public class ResourceProvider implements IResourceProvider {
    private final TypedArray mTypeArray;

    public ResourceProvider(Context context, AttributeSet attrs, int[] styleRes) {
        this.mTypeArray = context.obtainStyledAttributes(attrs, styleRes);
    }

    @Override // com.appnew.android.Utils.StickyView.provider.interfaces.IResourceProvider
    public int getResourceId(int styleResId) {
        try {
            return this.mTypeArray.getResourceId(styleResId, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return styleResId;
        }
    }

    @Override // com.appnew.android.Utils.StickyView.provider.interfaces.IResourceProvider
    public void recycle() {
        try {
            this.mTypeArray.recycle();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
