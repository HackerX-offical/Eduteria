package listeners;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes10.dex */
public class KeyBoardListener {
    public void hideKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        } catch (Error | Exception unused) {
        }
    }
}
