package com.appnew.android.Utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class CustomContextWrapper {
    public static ContextWrapper wrap(Context context, String language) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(language);
        configuration.locale = locale;
        configuration.setLocale(locale);
        Locale.setDefault(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return new ContextWrapper(context.createConfigurationContext(configuration));
    }
}
