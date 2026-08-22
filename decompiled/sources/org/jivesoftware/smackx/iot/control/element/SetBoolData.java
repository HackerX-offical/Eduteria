package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.iot.control.element.SetData;

/* JADX INFO: loaded from: classes10.dex */
public class SetBoolData extends SetData {
    private Boolean booleanCache;

    public SetBoolData(String str, boolean z) {
        this(str, Boolean.toString(z));
        this.booleanCache = Boolean.valueOf(z);
    }

    protected SetBoolData(String str, String str2) {
        super(str, SetData.Type.BOOL, str2);
    }

    public Boolean getBooleanValue() {
        if (this.booleanCache != null) {
            this.booleanCache = Boolean.valueOf(ParserUtils.parseXmlBoolean(getValue()));
        }
        return this.booleanCache;
    }
}
