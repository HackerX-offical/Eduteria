package com.tuyenmonkey.mkloader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import com.tuyenmonkey.mkloader.callback.InvalidateListener;
import com.tuyenmonkey.mkloader.type.LoaderView;
import com.tuyenmonkey.mkloader.util.LoaderGenerator;

/* JADX INFO: loaded from: classes9.dex */
public class MKLoader extends View implements InvalidateListener {
    private LoaderView loaderView;

    public MKLoader(Context context) {
        super(context);
        initialize(context, null, 0);
    }

    public MKLoader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet, 0);
    }

    public MKLoader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet, i);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MKLoader);
        LoaderView loaderViewGenerateLoaderView = LoaderGenerator.generateLoaderView(typedArrayObtainStyledAttributes.getInt(R.styleable.MKLoader_mk_type, -1));
        this.loaderView = loaderViewGenerateLoaderView;
        loaderViewGenerateLoaderView.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.MKLoader_mk_color, Color.parseColor("#ffffff")));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(this.loaderView.getDesiredWidth(), i), resolveSize(this.loaderView.getDesiredHeight(), i2));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.loaderView.setSize(getWidth(), getHeight());
        this.loaderView.initializeObjects();
        this.loaderView.setUpAnimation();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.loaderView.draw(canvas);
    }

    @Override // com.tuyenmonkey.mkloader.callback.InvalidateListener
    public void reDraw() {
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LoaderView loaderView = this.loaderView;
        if (loaderView == null || !loaderView.isDetached()) {
            return;
        }
        this.loaderView.setInvalidateListener(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LoaderView loaderView = this.loaderView;
        if (loaderView != null) {
            loaderView.onDetach();
        }
    }
}
