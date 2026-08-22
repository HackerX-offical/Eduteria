package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes8.dex */
public class SchemeTonalSpot extends DynamicScheme {
    public SchemeTonalSpot(Hct hct, boolean z, double d2) {
        super(hct, Variant.TONAL_SPOT, z, d2, TonalPalette.fromHueAndChroma(hct.getHue(), 40.0d), TonalPalette.fromHueAndChroma(hct.getHue(), 16.0d), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(hct.getHue() + 60.0d), 24.0d), TonalPalette.fromHueAndChroma(hct.getHue(), 6.0d), TonalPalette.fromHueAndChroma(hct.getHue(), 8.0d));
    }
}
