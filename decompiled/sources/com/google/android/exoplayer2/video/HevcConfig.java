package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;
    public final String codecs;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z;
        try {
            parsableByteArray.skipBytes(21);
            int unsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i = 0;
            int i2 = 0;
            while (true) {
                z = true;
                if (i >= unsignedByte2) {
                    break;
                }
                parsableByteArray.skipBytes(1);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                for (int i3 = 0; i3 < unsignedShort; i3++) {
                    int unsignedShort2 = parsableByteArray.readUnsignedShort();
                    i2 += unsignedShort2 + 4;
                    parsableByteArray.skipBytes(unsignedShort2);
                }
                i++;
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i2];
            int i4 = -1;
            int i5 = -1;
            float f2 = 1.0f;
            String strBuildHevcCodecString = null;
            int i6 = 0;
            for (int i7 = 0; i7 < unsignedByte2; i7++) {
                int unsignedByte3 = parsableByteArray.readUnsignedByte() & 127;
                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                int i8 = 0;
                while (i8 < unsignedShort3) {
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    boolean z2 = z;
                    int i9 = unsignedByte;
                    System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, i6, NalUnitUtil.NAL_START_CODE.length);
                    int length = i6 + NalUnitUtil.NAL_START_CODE.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, unsignedShort4);
                    if (unsignedByte3 == 33 && i8 == 0) {
                        NalUnitUtil.H265SpsData h265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + unsignedShort4);
                        i4 = h265SpsNalUnit.width;
                        i5 = h265SpsNalUnit.height;
                        f2 = h265SpsNalUnit.pixelWidthHeightRatio;
                        strBuildHevcCodecString = CodecSpecificDataUtil.buildHevcCodecString(h265SpsNalUnit.generalProfileSpace, h265SpsNalUnit.generalTierFlag, h265SpsNalUnit.generalProfileIdc, h265SpsNalUnit.generalProfileCompatibilityFlags, h265SpsNalUnit.constraintBytes, h265SpsNalUnit.generalLevelIdc);
                    }
                    i6 = length + unsignedShort4;
                    parsableByteArray.skipBytes(unsignedShort4);
                    i8++;
                    z = z2;
                    unsignedByte = i9;
                }
            }
            return new HevcConfig(i2 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), unsignedByte + 1, i4, i5, f2, strBuildHevcCodecString);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e2);
        }
    }

    private HevcConfig(List<byte[]> list, int i, int i2, int i3, float f2, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidthHeightRatio = f2;
        this.codecs = str;
    }
}
