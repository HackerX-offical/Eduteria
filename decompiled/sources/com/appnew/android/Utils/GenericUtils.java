package com.appnew.android.Utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.amazonaws.services.s3.internal.Constants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class GenericUtils {
    public static float[] getScreenDimension(Activity activity, boolean dpOrPx) {
        float f2;
        float f3;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        float f4 = activity.getResources().getDisplayMetrics().density;
        if (dpOrPx) {
            f3 = displayMetrics.heightPixels;
            f2 = displayMetrics.widthPixels;
        } else {
            f2 = displayMetrics.widthPixels / f4;
            f3 = displayMetrics.heightPixels / f4;
        }
        return new float[]{f3, f2};
    }

    public static String getParsableString(String s) {
        return isEmpty(s) ? "0" : s;
    }

    public static boolean isJsonEmpty(JSONObject jsonObject) {
        return jsonObject == null || jsonObject.toString().equals("{}");
    }

    public static JSONArray getJsonArray(JSONObject jsonResponse) {
        JSONArray jSONArrayOptJSONArray = jsonResponse.optJSONArray("data");
        return jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray : new JSONArray();
    }

    public static JSONObject getJsonObject(JSONObject jsonResponse) {
        JSONObject jSONObjectOptJSONObject = jsonResponse.optJSONObject("data");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject : new JSONObject();
    }

    public static boolean isListEmpty(List toCheck) {
        return toCheck == null || toCheck.isEmpty() || (toCheck.size() == 1 && toCheck.get(0) == null);
    }

    public static boolean isEmpty(EditText editText) {
        return (editText == null || editText.getText() == null || !isEmpty(editText.getText().toString().trim())) ? false : true;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty() || s.equalsIgnoreCase(Constants.NULL_VERSION_ID);
    }

    public static String getValueAt(String[] arr, int pos) {
        return (arr == null || arr.length <= pos) ? "" : arr[pos];
    }

    public static String getFormattedDate(String[] fullDate, String[] amPM) {
        return getValueAt(fullDate, 0) + ", " + getValueAt(fullDate, 1) + " " + getValueAt(fullDate, 2) + ", " + getValueAt(fullDate, 5) + " at " + getValueAt(amPM, 1) + " " + getValueAt(amPM, 2);
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, 0).show();
    }

    public static void setFullScreen(Activity activity, View playerView, boolean setFullScren) {
        if (setFullScren) {
            hideSystemBar(activity);
            playerView.getLayoutParams().height = (int) getScreenDimension(activity, true)[0];
        } else {
            showSystemBar(activity);
            playerView.getLayoutParams().height = (int) (((double) getScreenDimension(activity, true)[1]) * 0.5625d);
        }
    }

    private static void hideSystemBar(Activity activity) {
        try {
            if (activity.getWindow() != null) {
                activity.getWindow().getDecorView().setSystemUiVisibility(6);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void showSystemBar(Activity activity) {
        try {
            if (activity.getWindow() != null) {
                activity.getWindow().getDecorView().setSystemUiVisibility(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
