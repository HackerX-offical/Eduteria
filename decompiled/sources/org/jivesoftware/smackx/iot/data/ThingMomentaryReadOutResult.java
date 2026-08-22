package org.jivesoftware.smackx.iot.data;

import java.util.List;
import org.jivesoftware.smackx.iot.data.element.IoTDataField;

/* JADX INFO: loaded from: classes10.dex */
public interface ThingMomentaryReadOutResult {
    void momentaryReadOut(List<? extends IoTDataField> list);
}
