package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerConstants.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toFloat", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlayerConstantsKt {

    /* JADX INFO: compiled from: PlayerConstants.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlaybackRate.values().length];
            try {
                iArr[PlayerConstants.PlaybackRate.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_0_25.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_0_5.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_0_75.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_1.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_1_25.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_1_5.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_1_75.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PlayerConstants.PlaybackRate.RATE_2.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float toFloat(PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkNotNullParameter(playbackRate, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[playbackRate.ordinal()]) {
            case 1:
                return 1.0f;
            case 2:
                return 0.25f;
            case 3:
                return 0.5f;
            case 4:
                return 0.75f;
            case 5:
                return 1.0f;
            case 6:
                return 1.25f;
            case 7:
                return 1.5f;
            case 8:
                return 1.75f;
            case 9:
                return 2.0f;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
