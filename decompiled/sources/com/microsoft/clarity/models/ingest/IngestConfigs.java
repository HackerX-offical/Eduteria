package com.microsoft.clarity.models.ingest;

import com.microsoft.clarity.models.BackEndMaskingMode;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.MaskingModeAdapter;
import com.microsoft.clarity.n.k;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class IngestConfigs {
    private final boolean activate;
    private final String ingestUrl;
    private boolean lean;
    private MaskingMode maskingMode;
    private Set<String> nativeMask;
    private Set<String> nativeUnmask;
    private final String reportUrl;
    private Set<String> webMask;
    private Set<String> webUnmask;

    public IngestConfigs(String str, String str2, boolean z, boolean z2, MaskingMode maskingMode, Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4) {
        this.lean = false;
        MaskingMode maskingMode2 = MaskingMode.Strict;
        this.ingestUrl = str;
        this.reportUrl = str2;
        this.activate = z;
        this.lean = z2;
        this.maskingMode = maskingMode;
        this.webMask = set;
        this.webUnmask = set2;
        this.nativeMask = set3;
        this.nativeUnmask = set4;
    }

    public static IngestConfigs fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new IngestConfigs(jSONObject.getString("ingestUrl"), jSONObject.getString("reportUrl"), jSONObject.getBoolean("activate"), jSONObject.getBoolean("lean"), MaskingModeAdapter.INSTANCE.fromJson(jSONObject.optInt("maskingMode", BackEndMaskingMode.Strict.ordinal())), k.a(jSONObject.optJSONArray("webMask")), k.a(jSONObject.optJSONArray("webUnmask")), k.a(jSONObject.optJSONArray("nativeMask")), k.a(jSONObject.optJSONArray("nativeUnmask")));
    }

    public boolean getActivate() {
        return this.activate;
    }

    public String getIngestUrl() {
        return this.ingestUrl;
    }

    public boolean getLean() {
        return this.lean;
    }

    public MaskingMode getMaskingMode() {
        return this.maskingMode;
    }

    public Set<String> getNativeMaskSelectors() {
        return this.nativeMask;
    }

    public Set<String> getNativeUnmaskSelectors() {
        return this.nativeUnmask;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public Set<String> getWebMaskSelectors() {
        return this.webMask;
    }

    public Set<String> getWebUnmaskSelectors() {
        return this.webUnmask;
    }
}
