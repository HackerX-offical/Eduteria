package com.appnew.android.Microsoft;

import android.content.Context;
import com.microsoft.clarity.Clarity;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.models.ApplicationFramework;
import com.microsoft.clarity.models.LogLevel;
import java.util.Collections;

/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftClarity {
    public void Clarity(Context context) {
        Clarity.initialize(context, new ClarityConfig("jm4cwp8vvz", null, LogLevel.None, false, true, Collections.singletonList("*"), ApplicationFramework.Native));
    }
}
