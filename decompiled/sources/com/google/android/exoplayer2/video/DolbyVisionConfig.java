package com.google.android.exoplayer2.video;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* JADX INFO: loaded from: classes7.dex */
public final class DolbyVisionConfig {
    public final String codecs;
    public final int level;
    public final int profile;

    public static DolbyVisionConfig parse(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte >> 1;
        int unsignedByte2 = ((parsableByteArray.readUnsignedByte() >> 3) & 31) | ((unsignedByte & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        String str2 = unsignedByte2 < 10 ? ".0" : InstructionFileId.DOT;
        return new DolbyVisionConfig(i, unsignedByte2, new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(str2).length()).append(str).append(".0").append(i).append(str2).append(unsignedByte2).toString());
    }

    private DolbyVisionConfig(int i, int i2, String str) {
        this.profile = i;
        this.level = i2;
        this.codecs = str;
    }
}
