package com.anychart.math.adl;

import com.anychart.JsObject;
import com.anychart.math.CycledQueue;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Context extends JsObject {
    public Context(CycledQueue cycledQueue, Number number, CycledQueue cycledQueue2, CycledQueue cycledQueue3, Number number2, Number number3, CycledQueue cycledQueue4) {
        this.js.append(String.format(Locale.US, "{closeQueue:%s, dispose: %s, highQueue: %s, lowQueue: %s, period: %s, prevResult: %s, volumeQueue: %s, } ", cycledQueue != null ? cycledQueue.getJsBase() : null, number, cycledQueue2 != null ? cycledQueue2.getJsBase() : null, cycledQueue3 != null ? cycledQueue3.getJsBase() : null, number2, number3, cycledQueue4 != null ? cycledQueue4.getJsBase() : null));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
