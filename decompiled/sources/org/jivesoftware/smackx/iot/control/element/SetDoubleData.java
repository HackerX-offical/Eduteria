package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smackx.iot.control.element.SetData;

/* JADX INFO: loaded from: classes10.dex */
public class SetDoubleData extends SetData {
    private Double doubleCache;

    public SetDoubleData(String str, double d2) {
        this(str, Double.toString(d2));
        this.doubleCache = Double.valueOf(d2);
    }

    protected SetDoubleData(String str, String str2) {
        super(str, SetData.Type.DOUBLE, str2);
    }

    public Double getDoubleValue() {
        if (this.doubleCache != null) {
            this.doubleCache = Double.valueOf(getValue());
        }
        return this.doubleCache;
    }
}
