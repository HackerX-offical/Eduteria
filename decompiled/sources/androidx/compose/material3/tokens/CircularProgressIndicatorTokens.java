package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: CircularProgressIndicatorTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/tokens/CircularProgressIndicatorTokens;", "", "<init>", "()V", "ActiveThickness", "Landroidx/compose/ui/unit/Dp;", "getActiveThickness-D9Ej5fM", "()F", "F", "ActiveWaveAmplitude", "getActiveWaveAmplitude-D9Ej5fM", "ActiveWaveWavelength", "getActiveWaveWavelength-D9Ej5fM", "Size", "getSize-D9Ej5fM", "TrackActiveSpace", "getTrackActiveSpace-D9Ej5fM", "TrackThickness", "getTrackThickness-D9Ej5fM", "WaveSize", "getWaveSize-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CircularProgressIndicatorTokens {
    public static final int $stable = 0;
    private static final float ActiveThickness;
    private static final float TrackActiveSpace;
    private static final float TrackThickness;
    public static final CircularProgressIndicatorTokens INSTANCE = new CircularProgressIndicatorTokens();
    private static final float ActiveWaveAmplitude = Dp.m8830constructorimpl((float) 1.6d);
    private static final float ActiveWaveWavelength = Dp.m8830constructorimpl((float) 15.0d);
    private static final float Size = Dp.m8830constructorimpl((float) 40.0d);
    private static final float WaveSize = Dp.m8830constructorimpl((float) 48.0d);

    private CircularProgressIndicatorTokens() {
    }

    /* JADX INFO: renamed from: getActiveThickness-D9Ej5fM, reason: not valid java name */
    public final float m4266getActiveThicknessD9Ej5fM() {
        return ActiveThickness;
    }

    /* JADX INFO: renamed from: getActiveWaveAmplitude-D9Ej5fM, reason: not valid java name */
    public final float m4267getActiveWaveAmplitudeD9Ej5fM() {
        return ActiveWaveAmplitude;
    }

    /* JADX INFO: renamed from: getActiveWaveWavelength-D9Ej5fM, reason: not valid java name */
    public final float m4268getActiveWaveWavelengthD9Ej5fM() {
        return ActiveWaveWavelength;
    }

    /* JADX INFO: renamed from: getSize-D9Ej5fM, reason: not valid java name */
    public final float m4269getSizeD9Ej5fM() {
        return Size;
    }

    /* JADX INFO: renamed from: getTrackActiveSpace-D9Ej5fM, reason: not valid java name */
    public final float m4270getTrackActiveSpaceD9Ej5fM() {
        return TrackActiveSpace;
    }

    /* JADX INFO: renamed from: getTrackThickness-D9Ej5fM, reason: not valid java name */
    public final float m4271getTrackThicknessD9Ej5fM() {
        return TrackThickness;
    }

    /* JADX INFO: renamed from: getWaveSize-D9Ej5fM, reason: not valid java name */
    public final float m4272getWaveSizeD9Ej5fM() {
        return WaveSize;
    }

    static {
        float f2 = (float) 4.0d;
        ActiveThickness = Dp.m8830constructorimpl(f2);
        TrackActiveSpace = Dp.m8830constructorimpl(f2);
        TrackThickness = Dp.m8830constructorimpl(f2);
    }
}
