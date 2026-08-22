package com.facebook.appevents.suggestedevents;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SuggestedEventViewHierarchy.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0007R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventViewHierarchy;", "", "()V", "blacklistedViews", "", "Ljava/lang/Class;", "Landroid/view/View;", "getAllClickableViews", ViewHierarchyConstants.VIEW_KEY, "getDictionaryOfView", "Lorg/json/JSONObject;", "clickedView", "getTextOfChildren", "", "getTextOfViewRecursively", "hostView", "updateBasicInfo", "", "json", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SuggestedEventViewHierarchy {
    public static final SuggestedEventViewHierarchy INSTANCE = new SuggestedEventViewHierarchy();
    private static final List<Class<? extends View>> blacklistedViews = CollectionsKt.listOf((Object[]) new Class[]{Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class});

    private SuggestedEventViewHierarchy() {
    }

    @JvmStatic
    public static final JSONObject getDictionaryOfView(View view, View clickedView) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(clickedView, "clickedView");
            JSONObject jSONObject = new JSONObject();
            if (view == clickedView) {
                try {
                    jSONObject.put(ViewHierarchyConstants.IS_INTERACTED_KEY, true);
                } catch (JSONException unused) {
                }
            }
            updateBasicInfo(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<View> it = ViewHierarchy.getChildrenOfView(view).iterator();
            while (it.hasNext()) {
                jSONArray.put(getDictionaryOfView(it.next(), clickedView));
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventViewHierarchy.class);
            return null;
        }
    }

    @JvmStatic
    public static final void updateBasicInfo(View view, JSONObject json) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                String textOfView = ViewHierarchy.getTextOfView(view);
                String hintOfView = ViewHierarchy.getHintOfView(view);
                json.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getSimpleName());
                json.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, ViewHierarchy.getClassTypeBitmask(view));
                if (textOfView.length() > 0) {
                    json.put("text", textOfView);
                }
                if (hintOfView.length() > 0) {
                    json.put(ViewHierarchyConstants.HINT_KEY, hintOfView);
                }
                if (view instanceof EditText) {
                    json.put(ViewHierarchyConstants.INPUT_TYPE_KEY, ((EditText) view).getInputType());
                }
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventViewHierarchy.class);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r5.isClickable() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        r1.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r5 = com.facebook.appevents.codeless.internal.ViewHierarchy.getChildrenOfView(r5).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r5.hasNext() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        r1.addAll(getAllClickableViews(r5.next()));
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<android.view.View> getAllClickableViews(android.view.View r5) {
        /*
            java.lang.Class<com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy> r0 = com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch: java.lang.Throwable -> L58
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L58
            r1.<init>()     // Catch: java.lang.Throwable -> L58
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L58
            java.util.List<java.lang.Class<? extends android.view.View>> r3 = com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy.blacklistedViews     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
        L1d:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L30
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            java.lang.Class r4 = (java.lang.Class) r4     // Catch: java.lang.Throwable -> L58
            boolean r4 = r4.isInstance(r5)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L1d
            goto L57
        L30:
            boolean r3 = r5.isClickable()     // Catch: java.lang.Throwable -> L58
            if (r3 == 0) goto L39
            r1.add(r5)     // Catch: java.lang.Throwable -> L58
        L39:
            java.util.List r5 = com.facebook.appevents.codeless.internal.ViewHierarchy.getChildrenOfView(r5)     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L58
        L41:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r3 == 0) goto L57
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L58
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Throwable -> L58
            java.util.List r3 = getAllClickableViews(r3)     // Catch: java.lang.Throwable -> L58
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L58
            r1.addAll(r3)     // Catch: java.lang.Throwable -> L58
            goto L41
        L57:
            return r1
        L58:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy.getAllClickableViews(android.view.View):java.util.List");
    }

    @JvmStatic
    public static final String getTextOfViewRecursively(View hostView) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            String textOfView = ViewHierarchy.getTextOfView(hostView);
            if (textOfView.length() > 0) {
                return textOfView;
            }
            String strJoin = TextUtils.join(" ", INSTANCE.getTextOfChildren(hostView));
            Intrinsics.checkNotNullExpressionValue(strJoin, "join(\" \", childrenText)");
            return strJoin;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventViewHierarchy.class);
            return null;
        }
    }

    private final List<String> getTextOfChildren(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (View view2 : ViewHierarchy.getChildrenOfView(view)) {
                String textOfView = ViewHierarchy.getTextOfView(view2);
                if (textOfView.length() > 0) {
                    arrayList.add(textOfView);
                }
                arrayList.addAll(getTextOfChildren(view2));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
