package com.hbb20;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes9.dex */
class CountryCodeDialog {
    static Context context;
    static Dialog dialog;
    private static final Field sCursorDrawableField;
    private static final Field sCursorDrawableResourceField;
    private static final Field sEditorField;

    CountryCodeDialog() {
    }

    static {
        Field declaredField;
        Field declaredField2;
        Field declaredField3;
        boolean z = true;
        try {
            declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
        } catch (Exception unused) {
            declaredField = null;
            declaredField2 = null;
        }
        try {
            declaredField.setAccessible(true);
            declaredField2 = TextView.class.getDeclaredField("mEditor");
            try {
                declaredField2.setAccessible(true);
                declaredField3 = declaredField2.getType().getDeclaredField("mCursorDrawable");
                try {
                    declaredField3.setAccessible(true);
                    z = false;
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                declaredField3 = null;
            }
        } catch (Exception unused4) {
            declaredField2 = null;
            declaredField3 = declaredField2;
        }
        if (z) {
            sEditorField = null;
            sCursorDrawableField = null;
            sCursorDrawableResourceField = null;
        } else {
            sEditorField = declaredField2;
            sCursorDrawableField = declaredField3;
            sCursorDrawableResourceField = declaredField;
        }
    }

    public static void openCountryCodeDialog(final CountryCodePicker codePicker) {
        openCountryCodeDialog(codePicker, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0271 A[EDGE_INSN: B:89:0x0271->B:77:0x0271 BREAK  A[LOOP:1: B:71:0x0255->B:76:0x026e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void openCountryCodeDialog(final com.hbb20.CountryCodePicker r14, final java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CountryCodeDialog.openCountryCodeDialog(com.hbb20.CountryCodePicker, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hideKeyboard(Context context2) {
        if (context2 instanceof Activity) {
            Activity activity = (Activity) context2;
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    static void setCursorColor(EditText editText, int color) {
        Field field = sCursorDrawableField;
        if (field == null) {
            return;
        }
        try {
            Drawable drawable = getDrawable(editText.getContext(), sCursorDrawableResourceField.getInt(editText));
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            field.set(sEditorField.get(editText), new Drawable[]{drawable, drawable});
        } catch (Exception unused) {
        }
    }

    static void clear() {
        Dialog dialog2 = dialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        dialog = null;
        context = null;
    }

    private static Drawable getDrawable(Context context2, int id) {
        return context2.getDrawable(id);
    }
}
