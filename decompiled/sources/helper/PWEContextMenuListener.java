package helper;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: loaded from: classes9.dex */
public class PWEContextMenuListener implements View.OnTouchListener {
    private static final int TIME_INTERVAL_BETWEEN_DOUBLE_TAP = 30;
    public EditText editText;
    private InputMethodManager inputMethodManager;
    private long lastTapTime = 0;

    public PWEContextMenuListener(InputMethodManager inputMethodManager, EditText editText) {
        this.inputMethodManager = inputMethodManager;
        this.editText = editText;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.lastTapTime;
            if (j != 0 && jCurrentTimeMillis - j < 30) {
                this.editText.setSelected(false);
                performHandlerAction(this.inputMethodManager);
                return true;
            }
            if (j == 0) {
                this.lastTapTime = jCurrentTimeMillis;
            } else {
                this.lastTapTime = 0L;
            }
            performHandlerAction(this.inputMethodManager);
            return true;
        }
        if (motionEvent.getAction() == 2) {
            this.editText.setSelected(false);
            performHandlerAction(this.inputMethodManager);
        }
        return false;
    }

    private void performHandlerAction(final InputMethodManager inputMethodManager) {
        try {
            new Handler().postDelayed(new Runnable() { // from class: helper.PWEContextMenuListener.1
                @Override // java.lang.Runnable
                public void run() {
                    PWEContextMenuListener.this.editText.setSelected(true);
                    PWEContextMenuListener.this.editText.requestFocusFromTouch();
                    inputMethodManager.showSoftInput(PWEContextMenuListener.this.editText, 2);
                }
            }, 25);
        } catch (Exception unused) {
        }
    }
}
