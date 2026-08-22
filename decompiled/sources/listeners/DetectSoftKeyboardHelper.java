package listeners;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: loaded from: classes10.dex */
public class DetectSoftKeyboardHelper extends LinearLayout {
    private Listener listener;

    public interface Listener {
        void onSoftKeyboardShown(boolean z);
    }

    public DetectSoftKeyboardHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
        Rect rect = new Rect();
        appCompatActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = (appCompatActivity.getWindowManager().getDefaultDisplay().getHeight() - rect.top) - size;
        Listener listener = this.listener;
        if (listener != null) {
            listener.onSoftKeyboardShown(height > 300);
        }
        super.onMeasure(i, i2);
    }
}
