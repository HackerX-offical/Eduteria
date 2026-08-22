package a.a.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.LinearLayout;
import com.billdesk.sdk.PaymentWebView;

/* JADX INFO: loaded from: classes.dex */
public class k extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PaymentWebView f163c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PaymentWebView paymentWebView, Context context) {
        super(context);
        this.f163c = paymentWebView;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f161a.set(0.0f, 0.0f, getWidth(), getHeight());
        RectF rectF = this.f161a;
        float f2 = this.f163c.f422g / 2;
        canvas.drawRoundRect(rectF, f2, f2, this.f162b);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.f162b = paint;
        paint.setColor(i);
        super.setBackgroundColor(0);
    }

    @Override // android.widget.LinearLayout
    public void setGravity(int i) {
        this.f161a = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        super.setGravity(i);
    }
}
