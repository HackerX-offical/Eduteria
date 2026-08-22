package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class MediaCommonConfig implements Serializable {
    private DynamicReadaheadConfig dynamicReadaheadConfig;

    public DynamicReadaheadConfig getDynamicReadaheadConfig() {
        return this.dynamicReadaheadConfig;
    }

    public void setDynamicReadaheadConfig(DynamicReadaheadConfig dynamicReadaheadConfig) {
        this.dynamicReadaheadConfig = dynamicReadaheadConfig;
    }

    public String toString() {
        return "MediaCommonConfig{dynamicReadaheadConfig = '" + this.dynamicReadaheadConfig + "'}";
    }
}
