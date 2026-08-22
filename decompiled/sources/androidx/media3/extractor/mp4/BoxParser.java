package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.DolbyVisionConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class BoxParser {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "BoxParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static int parseFullBoxFlags(int i) {
        return i & 16777215;
    }

    public static int parseFullBoxVersion(int i) {
        return (i >> 24) & 255;
    }

    public static List<TrackSampleTable> parseTraks(Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerBox.containerChildren.size(); i++) {
            Mp4Box.ContainerBox containerBox2 = containerBox.containerChildren.get(i);
            if (containerBox2.type == 1953653099 && (trackApply = function.apply(parseTrak(containerBox2, (Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(trackApply, (Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox2.getContainerBoxOfType(1835297121))).getContainerBoxOfType(1835626086))).getContainerBoxOfType(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Mp4Box.LeafBox leafBox) {
        ParsableByteArray parsableByteArray = leafBox.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            int i2 = parsableByteArray.readInt();
            if (i2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(parseUdtaMeta(parsableByteArray, position + i));
            } else if (i2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(SmtaAtomUtil.parseSmta(parsableByteArray, position + i));
            } else if (i2 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(parseXyz(parsableByteArray));
            }
            parsableByteArray.setPosition(position + i);
        }
        return metadata;
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long unsignedInt;
        long unsignedInt2;
        parsableByteArray.setPosition(8);
        if (parseFullBoxVersion(parsableByteArray.readInt()) == 0) {
            unsignedInt = parsableByteArray.readUnsignedInt();
            unsignedInt2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedInt = parsableByteArray.readLong();
            unsignedInt2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(unsignedInt, unsignedInt2, parsableByteArray.readUnsignedInt());
    }

    public static Metadata parseMdtaFromMeta(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(1751411826);
        Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(1801812339);
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(1768715124);
        if (leafBoxOfType == null || leafBoxOfType2 == null || leafBoxOfType3 == null || parseHdlr(leafBoxOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafBoxOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 >= 0 && i5 < i) {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            } else {
                Log.w(TAG, "Skipped metadata with unknown key index: " + i5);
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void maybeSkipRemainingMetaBoxHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    public static Track parseTrak(Mp4Box.ContainerBox containerBox, Mp4Box.LeafBox leafBox, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Mp4Box.ContainerBox containerBoxOfType;
        Pair<long[], long[]> edts;
        Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox.getContainerBoxOfType(1835297121));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox2.getLeafBoxOfType(1751411826))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1953196132))).data);
        long j2 = j == -9223372036854775807L ? tkhd.duration : j;
        long j3 = parseMvhd(leafBox.data).timescale;
        long jScaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, j3) : -9223372036854775807L;
        Mp4Box.ContainerBox containerBox3 = (Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox2.getContainerBoxOfType(1835626086))).getContainerBoxOfType(1937007212));
        MdhdData mdhd = parseMdhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox2.getLeafBoxOfType(1835296868))).data);
        Mp4Box.LeafBox leafBoxOfType = containerBox3.getLeafBoxOfType(1937011556);
        if (leafBoxOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData stsd = parseStsd(leafBoxOfType.data, tkhd.id, tkhd.rotationDegrees, mdhd.language, drmInitData, z2);
        if (z || (containerBoxOfType = containerBox.getContainerBoxOfType(1701082227)) == null || (edts = parseEdts(containerBoxOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.id, trackTypeForHdlr, mdhd.timescale, j3, jScaleLargeTimestamp, mdhd.mediaDurationUs, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.extractor.mp4.TrackSampleTable parseStbl(androidx.media3.extractor.mp4.Track r34, androidx.media3.container.Mp4Box.ContainerBox r35, androidx.media3.extractor.GaplessInfoHolder r36) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instruction units count: 1352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.BoxParser.parseStbl(androidx.media3.extractor.mp4.Track, androidx.media3.container.Mp4Box$ContainerBox, androidx.media3.extractor.GaplessInfoHolder):androidx.media3.extractor.mp4.TrackSampleTable");
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaBoxHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short s = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String string = parsableByteArray.readString(s);
        int iMax = Math.max(string.lastIndexOf(43), string.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(string.substring(0, iMax)), Float.parseFloat(string.substring(iMax, string.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullBoxVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i4 < i2) {
                if (parsableByteArray.getData()[position + i4] != -1) {
                    long unsignedInt = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (unsignedInt != 0) {
                        j = unsignedInt;
                    }
                } else {
                    i4++;
                }
            } else {
                parsableByteArray.skipBytes(i2);
                break;
            }
        }
        parsableByteArray.skipBytes(16);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = 270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = 180;
        }
        return new TkhdData(i, j, i3);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static MdhdData parseMdhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        int position = parsableByteArray.getPosition();
        int i = fullBoxVersion == 0 ? 4 : 8;
        int i2 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i2 < i) {
                if (parsableByteArray.getData()[position + i2] != -1) {
                    long unsignedInt2 = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (unsignedInt2 != 0) {
                        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(unsignedInt2, 1000000L, unsignedInt);
                        unsignedInt = unsignedInt;
                        j = jScaleLargeTimestamp;
                    }
                } else {
                    i2++;
                }
            } else {
                parsableByteArray.skipBytes(i);
                break;
            }
        }
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return new MdhdData(unsignedInt, j, "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int i3 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i3);
        int i4 = 0;
        while (i4 < i3) {
            int position = parsableByteArray.getPosition();
            int i5 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i5 > 0, "childAtomSize must be positive");
            int i6 = parsableByteArray.readInt();
            if (i6 == 1635148593 || i6 == 1635148595 || i6 == 1701733238 || i6 == 1831958048 || i6 == 1836070006 || i6 == 1752589105 || i6 == 1751479857 || i6 == 1932670515 || i6 == 1211250227 || i6 == 1748121139 || i6 == 1987063864 || i6 == 1987063865 || i6 == 1635135537 || i6 == 1685479798 || i6 == 1685479729 || i6 == 1685481573 || i6 == 1685481521) {
                StsdData stsdData2 = stsdData;
                int i7 = i4;
                parseVideoSampleEntry(parsableByteArray, i6, position, i5, i, i2, drmInitData, stsdData2, i7);
                stsdData = stsdData2;
                i4 = i7;
            } else if (i6 == 1836069985 || i6 == 1701733217 || i6 == 1633889587 || i6 == 1700998451 || i6 == 1633889588 || i6 == 1835823201 || i6 == 1685353315 || i6 == 1685353317 || i6 == 1685353320 || i6 == 1685353324 || i6 == 1685353336 || i6 == 1935764850 || i6 == 1935767394 || i6 == 1819304813 || i6 == 1936684916 || i6 == 1953984371 || i6 == 778924082 || i6 == 778924083 || i6 == 1835557169 || i6 == 1835560241 || i6 == 1634492771 || i6 == 1634492791 || i6 == 1970037111 || i6 == 1332770163 || i6 == 1716281667 || i6 == 1767992678) {
                StsdData stsdData3 = stsdData;
                parseAudioSampleEntry(parsableByteArray, i6, position, i5, i, str, z, drmInitData, stsdData3, i4);
                stsdData = stsdData3;
            } else if (i6 == 1414810956 || i6 == 1954034535 || i6 == 2004251764 || i6 == 1937010800 || i6 == 1664495672) {
                parseTextSampleEntry(parsableByteArray, i6, position, i5, i, str, stsdData);
            } else if (i6 == 1835365492) {
                parseMetaDataSampleEntry(parsableByteArray, i6, position, i, stsdData);
            } else if (i6 == 1667329389) {
                stsdData.format = new Format.Builder().setId(i).setSampleMimeType("application/x-camera-motion").build();
            }
            parsableByteArray.setPosition(position + i5);
            i4++;
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListOf = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableListOf = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableListOf).build();
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str;
        int i7;
        String str2;
        int i8;
        int iIsoTransferCharacteristicsToColorTransfer;
        DrmInitData drmInitData2;
        List<byte[]> list;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        NalUnitUtil.H265VpsData h265VpsData;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20 = i2;
        int i21 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i20 + 16);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i20, i21);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str3 = "video/3gpp";
        if (iIntValue != 1831958048) {
            str = iIntValue == 1211250227 ? "video/3gpp" : null;
        } else {
            str = "video/mpeg";
        }
        float paspFromParent = 1.0f;
        int i22 = 8;
        int i23 = 8;
        List<byte[]> listOf = null;
        String str4 = null;
        byte[] projFromParent = null;
        int i24 = -1;
        int i25 = -1;
        int iIsoColorPrimariesToColorSpace = -1;
        int i26 = -1;
        int i27 = -1;
        ByteBuffer byteBufferAllocateHdrStaticInfo = null;
        EsdsData esdsFromParent = null;
        NalUnitUtil.H265VpsData h265VpsData2 = null;
        boolean z = false;
        while (position - i20 < i21) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i28 = parsableByteArray.readInt();
            if (i28 == 0 && parsableByteArray.getPosition() - i2 == i21) {
                break;
            }
            ExtractorUtil.checkContainerInput(i28 > 0, "childAtomSize must be positive");
            int i29 = parsableByteArray.readInt();
            if (i29 == 1635148611) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                List<byte[]> list2 = avcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                String str5 = avcConfig.codecs;
                int i30 = avcConfig.maxNumReorderFrames;
                int i31 = avcConfig.colorSpace;
                int i32 = avcConfig.colorRange;
                listOf = list2;
                int i33 = avcConfig.colorTransfer;
                i12 = avcConfig.bitdepthLuma;
                i7 = position;
                i9 = iIntValue;
                str2 = str3;
                iIsoColorPrimariesToColorSpace = i31;
                i8 = i32;
                iIsoTransferCharacteristicsToColorTransfer = i33;
                i23 = avcConfig.bitdepthChroma;
                str4 = str5;
                str = "video/avc";
                h265VpsData = h265VpsData2;
                drmInitData2 = drmInitDataCopyWithSchemeType;
                i25 = i30;
            } else {
                i7 = position;
                if (i29 == 1752589123) {
                    ExtractorUtil.checkContainerInput(str == null, null);
                    parsableByteArray.setPosition(position2 + 8);
                    HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                    List<byte[]> list3 = hevcConfig.initializationData;
                    stsdData2.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                    if (!z) {
                        paspFromParent = hevcConfig.pixelWidthHeightRatio;
                    }
                    int i34 = hevcConfig.maxNumReorderPics;
                    String str6 = hevcConfig.codecs;
                    if (hevcConfig.stereoMode != -1) {
                        i24 = hevcConfig.stereoMode;
                    }
                    int i35 = hevcConfig.colorSpace;
                    int i36 = hevcConfig.colorRange;
                    listOf = list3;
                    int i37 = hevcConfig.colorTransfer;
                    int i38 = hevcConfig.bitdepthLuma;
                    int i39 = hevcConfig.bitdepthChroma;
                    h265VpsData = hevcConfig.vpsData;
                    drmInitData2 = drmInitDataCopyWithSchemeType;
                    i9 = iIntValue;
                    str2 = str3;
                    iIsoColorPrimariesToColorSpace = i35;
                    i8 = i36;
                    iIsoTransferCharacteristicsToColorTransfer = i37;
                    i12 = i38;
                    i23 = i39;
                    i25 = i34;
                    str4 = str6;
                    str = "video/hevc";
                } else {
                    str2 = str3;
                    if (i29 == 1818785347) {
                        ExtractorUtil.checkContainerInput("video/hevc".equals(str), "lhvC must follow hvcC atom");
                        NalUnitUtil.H265VpsData h265VpsData3 = h265VpsData2;
                        ExtractorUtil.checkContainerInput(h265VpsData3 != null && h265VpsData3.layerInfos.size() >= 2, "must have at least two layers");
                        parsableByteArray.setPosition(position2 + 8);
                        HevcConfig layered = HevcConfig.parseLayered(parsableByteArray, (NalUnitUtil.H265VpsData) Assertions.checkNotNull(h265VpsData3));
                        ExtractorUtil.checkContainerInput(stsdData2.nalUnitLengthFieldLength == layered.nalUnitLengthFieldLength, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                        if (layered.colorSpace != -1) {
                            i16 = iIsoColorPrimariesToColorSpace;
                            ExtractorUtil.checkContainerInput(i16 == layered.colorSpace, "colorSpace must be the same for both views");
                        } else {
                            i16 = iIsoColorPrimariesToColorSpace;
                        }
                        if (layered.colorRange != -1) {
                            i17 = i26;
                            ExtractorUtil.checkContainerInput(i17 == layered.colorRange, "colorRange must be the same for both views");
                        } else {
                            i17 = i26;
                        }
                        if (layered.colorTransfer != -1) {
                            int i40 = i27;
                            i18 = i40;
                            ExtractorUtil.checkContainerInput(i40 == layered.colorTransfer, "colorTransfer must be the same for both views");
                        } else {
                            i18 = i27;
                        }
                        ExtractorUtil.checkContainerInput(i22 == layered.bitdepthLuma, "bitdepthLuma must be the same for both views");
                        ExtractorUtil.checkContainerInput(i23 == layered.bitdepthChroma, "bitdepthChroma must be the same for both views");
                        List<byte[]> listBuild = listOf;
                        if (listBuild != null) {
                            listBuild = ImmutableList.builder().addAll((Iterable) listBuild).addAll((Iterable) layered.initializationData).build();
                            i19 = i16;
                        } else {
                            i19 = i16;
                            ExtractorUtil.checkContainerInput(false, "initializationData must be already set from hvcC atom");
                        }
                        String str7 = layered.codecs;
                        str = MimeTypes.VIDEO_MV_HEVC;
                        drmInitData2 = drmInitDataCopyWithSchemeType;
                        i9 = iIntValue;
                        i8 = i17;
                        i12 = i22;
                        iIsoColorPrimariesToColorSpace = i19;
                        iIsoTransferCharacteristicsToColorTransfer = i18;
                        str4 = str7;
                        h265VpsData = h265VpsData3;
                        listOf = listBuild;
                    } else {
                        List<byte[]> listBuildVp9CodecPrivateInitializationData = listOf;
                        int i41 = iIsoColorPrimariesToColorSpace;
                        i8 = i26;
                        iIsoTransferCharacteristicsToColorTransfer = i27;
                        NalUnitUtil.H265VpsData h265VpsData4 = h265VpsData2;
                        if (i29 == 1986361461) {
                            VexuData videoExtendedUsageBox = parseVideoExtendedUsageBox(parsableByteArray, position2, i28);
                            if (videoExtendedUsageBox == null || videoExtendedUsageBox.eyesData == null) {
                                i15 = i24;
                                i24 = i15;
                                h265VpsData = h265VpsData4;
                                drmInitData2 = drmInitDataCopyWithSchemeType;
                                listOf = listBuildVp9CodecPrivateInitializationData;
                                i9 = iIntValue;
                                i12 = i22;
                                iIsoColorPrimariesToColorSpace = i41;
                            } else if (h265VpsData4 == null || h265VpsData4.layerInfos.size() < 2) {
                                i15 = i24;
                                if (i15 == -1) {
                                    i24 = videoExtendedUsageBox.eyesData.striData.eyeViewsReversed ? 5 : 4;
                                } else {
                                    i24 = i15;
                                }
                                h265VpsData = h265VpsData4;
                                drmInitData2 = drmInitDataCopyWithSchemeType;
                                listOf = listBuildVp9CodecPrivateInitializationData;
                                i9 = iIntValue;
                                i12 = i22;
                                iIsoColorPrimariesToColorSpace = i41;
                            } else {
                                ExtractorUtil.checkContainerInput(videoExtendedUsageBox.hasBothEyeViews(), "both eye views must be marked as available");
                                ExtractorUtil.checkContainerInput(!videoExtendedUsageBox.eyesData.striData.eyeViewsReversed, "for MV-HEVC, eye_views_reversed must be set to false");
                                i15 = i24;
                                i24 = i15;
                                h265VpsData = h265VpsData4;
                                drmInitData2 = drmInitDataCopyWithSchemeType;
                                listOf = listBuildVp9CodecPrivateInitializationData;
                                i9 = iIntValue;
                                i12 = i22;
                                iIsoColorPrimariesToColorSpace = i41;
                            }
                        } else {
                            int i42 = i24;
                            if (i29 == 1685480259 || i29 == 1685485123) {
                                drmInitData2 = drmInitDataCopyWithSchemeType;
                                list = listBuildVp9CodecPrivateInitializationData;
                                i9 = iIntValue;
                                i10 = i42;
                                i11 = i23;
                                i12 = i22;
                                i13 = i41;
                                i14 = iIsoTransferCharacteristicsToColorTransfer;
                                DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(parsableByteArray);
                                if (dolbyVisionConfig != null) {
                                    str = "video/dolby-vision";
                                    str4 = dolbyVisionConfig.codecs;
                                }
                            } else if (i29 == 1987076931) {
                                ExtractorUtil.checkContainerInput(str == null, null);
                                String str8 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                parsableByteArray.setPosition(position2 + 12);
                                byte unsignedByte = (byte) parsableByteArray.readUnsignedByte();
                                byte unsignedByte2 = (byte) parsableByteArray.readUnsignedByte();
                                int unsignedByte3 = parsableByteArray.readUnsignedByte();
                                int i43 = unsignedByte3 >> 4;
                                i9 = iIntValue;
                                byte b2 = (byte) ((unsignedByte3 >> 1) & 7);
                                if (str8.equals("video/x-vnd.on2.vp9")) {
                                    listBuildVp9CodecPrivateInitializationData = CodecSpecificDataUtil.buildVp9CodecPrivateInitializationData(unsignedByte, unsignedByte2, (byte) i43, b2);
                                }
                                boolean z2 = (unsignedByte3 & 1) != 0;
                                int unsignedByte4 = parsableByteArray.readUnsignedByte();
                                int unsignedByte5 = parsableByteArray.readUnsignedByte();
                                iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte4);
                                str = str8;
                                drmInitData2 = drmInitDataCopyWithSchemeType;
                                i23 = i43;
                                i8 = z2 ? 1 : 2;
                                h265VpsData = h265VpsData4;
                                iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte5);
                                listOf = listBuildVp9CodecPrivateInitializationData;
                                i24 = i42;
                                i12 = i23;
                            } else {
                                i9 = iIntValue;
                                if (i29 == 1635135811) {
                                    int i44 = i28 - 8;
                                    byte[] bArr = new byte[i44];
                                    parsableByteArray.readBytes(bArr, 0, i44);
                                    listOf = ImmutableList.of(bArr);
                                    parsableByteArray.setPosition(position2 + 8);
                                    ColorInfo av1c = parseAv1c(parsableByteArray);
                                    int i45 = av1c.lumaBitdepth;
                                    int i46 = av1c.chromaBitdepth;
                                    int i47 = av1c.colorSpace;
                                    int i48 = av1c.colorRange;
                                    iIsoTransferCharacteristicsToColorTransfer = av1c.colorTransfer;
                                    i12 = i45;
                                    drmInitData2 = drmInitDataCopyWithSchemeType;
                                    iIsoColorPrimariesToColorSpace = i47;
                                    i8 = i48;
                                    str = "video/av01";
                                    h265VpsData = h265VpsData4;
                                    i23 = i46;
                                } else if (i29 == 1668050025) {
                                    if (byteBufferAllocateHdrStaticInfo == null) {
                                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                                    }
                                    ByteBuffer byteBuffer = byteBufferAllocateHdrStaticInfo;
                                    byteBuffer.position(21);
                                    byteBuffer.putShort(parsableByteArray.readShort());
                                    byteBuffer.putShort(parsableByteArray.readShort());
                                    byteBufferAllocateHdrStaticInfo = byteBuffer;
                                    drmInitData2 = drmInitDataCopyWithSchemeType;
                                    listOf = listBuildVp9CodecPrivateInitializationData;
                                    i12 = i22;
                                    h265VpsData = h265VpsData4;
                                    iIsoColorPrimariesToColorSpace = i41;
                                } else if (i29 == 1835295606) {
                                    if (byteBufferAllocateHdrStaticInfo == null) {
                                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                                    }
                                    ByteBuffer byteBuffer2 = byteBufferAllocateHdrStaticInfo;
                                    short s = parsableByteArray.readShort();
                                    short s2 = parsableByteArray.readShort();
                                    short s3 = parsableByteArray.readShort();
                                    short s4 = parsableByteArray.readShort();
                                    int i49 = i23;
                                    short s5 = parsableByteArray.readShort();
                                    i12 = i22;
                                    short s6 = parsableByteArray.readShort();
                                    drmInitData2 = drmInitDataCopyWithSchemeType;
                                    short s7 = parsableByteArray.readShort();
                                    short s8 = parsableByteArray.readShort();
                                    long unsignedInt = parsableByteArray.readUnsignedInt();
                                    long unsignedInt2 = parsableByteArray.readUnsignedInt();
                                    byteBuffer2.position(1);
                                    byteBuffer2.putShort(s5);
                                    byteBuffer2.putShort(s6);
                                    byteBuffer2.putShort(s);
                                    byteBuffer2.putShort(s2);
                                    byteBuffer2.putShort(s3);
                                    byteBuffer2.putShort(s4);
                                    byteBuffer2.putShort(s7);
                                    byteBuffer2.putShort(s8);
                                    byteBuffer2.putShort((short) (unsignedInt / 10000));
                                    byteBuffer2.putShort((short) (unsignedInt2 / 10000));
                                    byteBufferAllocateHdrStaticInfo = byteBuffer2;
                                    h265VpsData = h265VpsData4;
                                    i23 = i49;
                                    iIsoColorPrimariesToColorSpace = i41;
                                    listOf = listBuildVp9CodecPrivateInitializationData;
                                    i24 = i42;
                                } else {
                                    drmInitData2 = drmInitDataCopyWithSchemeType;
                                    list = listBuildVp9CodecPrivateInitializationData;
                                    i10 = i42;
                                    i11 = i23;
                                    i12 = i22;
                                    if (i29 == 1681012275) {
                                        ExtractorUtil.checkContainerInput(str == null, null);
                                        h265VpsData = h265VpsData4;
                                        i23 = i11;
                                        str = str2;
                                    } else if (i29 == 1702061171) {
                                        ExtractorUtil.checkContainerInput(str == null, null);
                                        esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                                        String str9 = esdsFromParent.mimeType;
                                        byte[] bArr2 = esdsFromParent.initializationData;
                                        listOf = bArr2 != null ? ImmutableList.of(bArr2) : list;
                                        str = str9;
                                        h265VpsData = h265VpsData4;
                                        i23 = i11;
                                        iIsoColorPrimariesToColorSpace = i41;
                                        i24 = i10;
                                    } else if (i29 == 1885434736) {
                                        paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                                        h265VpsData = h265VpsData4;
                                        i23 = i11;
                                        iIsoColorPrimariesToColorSpace = i41;
                                        listOf = list;
                                        i24 = i10;
                                        z = true;
                                    } else {
                                        if (i29 == 1937126244) {
                                            projFromParent = parseProjFromParent(parsableByteArray, position2, i28);
                                        } else if (i29 == 1936995172) {
                                            int unsignedByte6 = parsableByteArray.readUnsignedByte();
                                            parsableByteArray.skipBytes(3);
                                            if (unsignedByte6 == 0) {
                                                int unsignedByte7 = parsableByteArray.readUnsignedByte();
                                                if (unsignedByte7 == 0) {
                                                    i10 = 0;
                                                } else if (unsignedByte7 == 1) {
                                                    i10 = 1;
                                                } else if (unsignedByte7 == 2) {
                                                    i10 = 2;
                                                } else if (unsignedByte7 == 3) {
                                                    i10 = 3;
                                                }
                                            }
                                        } else {
                                            i13 = i41;
                                            if (i29 == 1668246642) {
                                                i14 = iIsoTransferCharacteristicsToColorTransfer;
                                                if (i13 == -1 && i14 == -1) {
                                                    int i50 = parsableByteArray.readInt();
                                                    if (i50 == TYPE_nclx || i50 == TYPE_nclc) {
                                                        int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                                        int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                                        parsableByteArray.skipBytes(2);
                                                        boolean z3 = i28 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                                        int iIsoColorPrimariesToColorSpace2 = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                                        int i51 = z3 ? 1 : 2;
                                                        iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                                                        i8 = i51;
                                                        i23 = i11;
                                                        listOf = list;
                                                        iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace2;
                                                        h265VpsData = h265VpsData4;
                                                        i24 = i10;
                                                    } else {
                                                        Log.w(TAG, "Unsupported color type: " + Mp4Box.getBoxTypeString(i50));
                                                    }
                                                }
                                            } else {
                                                i14 = iIsoTransferCharacteristicsToColorTransfer;
                                            }
                                        }
                                        h265VpsData = h265VpsData4;
                                        i23 = i11;
                                    }
                                    iIsoColorPrimariesToColorSpace = i41;
                                    listOf = list;
                                    i24 = i10;
                                }
                                i24 = i42;
                            }
                            iIsoTransferCharacteristicsToColorTransfer = i14;
                            h265VpsData = h265VpsData4;
                            i23 = i11;
                            listOf = list;
                            i24 = i10;
                            iIsoColorPrimariesToColorSpace = i13;
                        }
                    }
                }
            }
            position = i7 + i28;
            i21 = i3;
            stsdData2 = stsdData;
            iIntValue = i9;
            i22 = i12;
            drmInitDataCopyWithSchemeType = drmInitData2;
            str3 = str2;
            i26 = i8;
            i27 = iIsoTransferCharacteristicsToColorTransfer;
            h265VpsData2 = h265VpsData;
            i20 = i2;
        }
        DrmInitData drmInitData3 = drmInitDataCopyWithSchemeType;
        List<byte[]> list4 = listOf;
        int i52 = i24;
        int i53 = iIsoColorPrimariesToColorSpace;
        int i54 = i26;
        int i55 = i27;
        int i56 = i23;
        int i57 = i22;
        if (str == null) {
            return;
        }
        Format.Builder colorInfo = new Format.Builder().setId(i4).setSampleMimeType(str).setCodecs(str4).setWidth(unsignedShort).setHeight(unsignedShort2).setPixelWidthHeightRatio(paspFromParent).setRotationDegrees(i5).setProjectionData(projFromParent).setStereoMode(i52).setInitializationData(list4).setMaxNumReorderSamples(i25).setDrmInitData(drmInitData3).setColorInfo(new ColorInfo.Builder().setColorSpace(i53).setColorRange(i54).setColorTransfer(i55).setHdrStaticInfo(byteBufferAllocateHdrStaticInfo != null ? byteBufferAllocateHdrStaticInfo.array() : null).setLumaBitdepth(i57).setChromaBitdepth(i56).build());
        if (esdsFromParent != null) {
            colorInfo.setAverageBitrate(Ints.saturatedCast(esdsFromParent.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsFromParent.peakBitrate));
        }
        stsdData.format = colorInfo.build();
    }

    private static ColorInfo parseAv1c(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(6);
        boolean bit = parsableBitArray.readBit();
        boolean bit2 = parsableBitArray.readBit();
        if (bits == 2 && bit) {
            builder.setLumaBitdepth(bit2 ? 12 : 10);
            builder.setChromaBitdepth(bit2 ? 12 : 10);
        } else if (bits <= 2) {
            builder.setLumaBitdepth(bit ? 10 : 8);
            builder.setChromaBitdepth(bit ? 10 : 8);
        }
        parsableBitArray.skipBits(13);
        parsableBitArray.skipBit();
        int bits2 = parsableBitArray.readBits(4);
        if (bits2 != 1) {
            Log.i(TAG, "Unsupported obu_type: " + bits2);
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported obu_extension_flag");
            return builder.build();
        }
        boolean bit3 = parsableBitArray.readBit();
        parsableBitArray.skipBit();
        if (bit3 && parsableBitArray.readBits(8) > 127) {
            Log.i(TAG, "Excessive obu_size");
            return builder.build();
        }
        int bits3 = parsableBitArray.readBits(3);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported reduced_still_picture_header");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported timing_info_present_flag");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported initial_display_delay_present_flag");
            return builder.build();
        }
        int bits4 = parsableBitArray.readBits(5);
        boolean z = false;
        for (int i = 0; i <= bits4; i++) {
            parsableBitArray.skipBits(12);
            if (parsableBitArray.readBits(5) > 7) {
                parsableBitArray.skipBit();
            }
        }
        int bits5 = parsableBitArray.readBits(4);
        int bits6 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(bits5 + 1);
        parsableBitArray.skipBits(bits6 + 1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(7);
        }
        parsableBitArray.skipBits(7);
        boolean bit4 = parsableBitArray.readBit();
        if (bit4) {
            parsableBitArray.skipBits(2);
        }
        if ((parsableBitArray.readBit() ? 2 : parsableBitArray.readBits(1)) > 0 && !parsableBitArray.readBit()) {
            parsableBitArray.skipBits(1);
        }
        if (bit4) {
            parsableBitArray.skipBits(3);
        }
        parsableBitArray.skipBits(3);
        boolean bit5 = parsableBitArray.readBit();
        if (bits3 == 2 && bit5) {
            parsableBitArray.skipBit();
        }
        if (bits3 != 1 && parsableBitArray.readBit()) {
            z = true;
        }
        if (parsableBitArray.readBit()) {
            int bits7 = parsableBitArray.readBits(8);
            int bits8 = parsableBitArray.readBits(8);
            builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits7)).setColorRange(((z || bits7 != 1 || bits8 != 13 || parsableBitArray.readBits(8) != 0) ? parsableBitArray.readBits(1) : 1) != 1 ? 2 : 1).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8));
        }
        return builder.build();
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String nullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (nullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(nullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(1701606260);
        if (leafBoxOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType.data;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullBoxVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullBoxVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseAudioSampleEntry(androidx.media3.common.util.ParsableByteArray r24, int r25, int r26, int r27, int r28, java.lang.String r29, boolean r30, androidx.media3.common.DrmInitData r31, androidx.media3.extractor.mp4.BoxParser.StsdData r32, int r33) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instruction units count: 1145
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.BoxParser.parseAudioSampleEntry(androidx.media3.common.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, androidx.media3.common.DrmInitData, androidx.media3.extractor.mp4.BoxParser$StsdData, int):void");
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int i4 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i4 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += i4;
        }
        return -1;
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        long j = unsignedInt2;
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        if (j <= 0) {
            j = -1;
        }
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, j, unsignedInt > 0 ? unsignedInt : -1L);
    }

    static VexuData parseVideoExtendedUsageBox(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int position = parsableByteArray.getPosition();
        EyesData stereoViewBox = null;
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1702454643) {
                stereoViewBox = parseStereoViewBox(parsableByteArray, position, i3);
            }
            position += i3;
        }
        if (stereoViewBox == null) {
            return null;
        }
        return new VexuData(stereoViewBox);
    }

    private static EyesData parseStereoViewBox(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1937011305) {
                parsableByteArray.skipBytes(4);
                int unsignedByte = parsableByteArray.readUnsignedByte();
                return new EyesData(new StriData((unsignedByte & 1) == 1, (unsignedByte & 2) == 2, (unsignedByte & 8) == 8, (unsignedByte & 4) == 4));
            }
            position += i3;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String string = null;
        Integer numValueOf = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == 1935894637) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == 1935894633) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!"cenc".equals(string) && !"cbc1".equals(string) && !"cens".equals(string) && !"cbcs".equals(string)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        ExtractorUtil.checkContainerInput(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.castNonNull(schiFromParent));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullBoxVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private BoxParser() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long unsignedInt;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                unsignedInt = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                unsignedInt = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = unsignedInt;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    private static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    private static final class StriData {
        private final boolean eyeViewsReversed;
        private final boolean hasAdditionalViews;
        private final boolean hasLeftEyeView;
        private final boolean hasRightEyeView;

        public StriData(boolean z, boolean z2, boolean z3, boolean z4) {
            this.hasLeftEyeView = z;
            this.hasRightEyeView = z2;
            this.eyeViewsReversed = z3;
            this.hasAdditionalViews = z4;
        }
    }

    private static final class EyesData {
        private final StriData striData;

        public EyesData(StriData striData) {
            this.striData = striData;
        }
    }

    private static final class MdhdData {
        private final String language;
        private final long mediaDurationUs;
        private final long timescale;

        public MdhdData(long j, long j2, String str) {
            this.timescale = j;
            this.mediaDurationUs = j2;
            this.language = str;
        }
    }

    static final class VexuData {
        private final EyesData eyesData;

        public VexuData(EyesData eyesData) {
            this.eyesData = eyesData;
        }

        public boolean hasBothEyeViews() {
            EyesData eyesData = this.eyesData;
            return eyesData != null && eyesData.striData.hasLeftEyeView && this.eyesData.striData.hasRightEyeView;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Mp4Box.LeafBox leafBox, Format format) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if ("audio/raw".equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt == 0 || unsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(BoxParser.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Mp4Box.LeafBox leafBox) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int unsignedByte = this.data.readUnsignedByte();
                this.currentByte = unsignedByte;
                return (unsignedByte & 240) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}
