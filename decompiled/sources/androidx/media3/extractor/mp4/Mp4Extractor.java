package androidx.media3.extractor.mp4;

import androidx.collection.SieveCacheKt;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class Mp4Extractor implements Extractor, SeekMap {

    @Deprecated
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: androidx.media3.extractor.mp4.Mp4Extractor$$ExternalSyntheticLambda2
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return Mp4Extractor.lambda$static$1();
        }
    };
    private static final int FILE_TYPE_HEIC = 2;
    private static final int FILE_TYPE_MP4 = 0;
    private static final int FILE_TYPE_QUICKTIME = 1;
    public static final int FLAG_EMIT_RAW_SUBTITLE_DATA = 16;
    public static final int FLAG_MARK_FIRST_VIDEO_TRACK_WITH_MAIN_ROLE = 8;
    public static final int FLAG_READ_EDITABLE_VIDEO_TRACKS = 64;
    public static final int FLAG_READ_MOTION_PHOTO_METADATA = 2;
    public static final int FLAG_READ_SEF_DATA = 4;
    public static final int FLAG_READ_WITHIN_GOP_SAMPLE_DEPENDENCIES = 32;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private static final int STATE_READING_SEF = 3;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque<Mp4Box.ContainerBox> containerAtoms;
    private long durationUs;
    private long edvdAtomOffset;
    private ExtractorOutput extractorOutput;
    private int fileType;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isSampleDependedOn;
    private ImmutableList<SniffFailure> lastSniffFailures;
    private MotionPhotoMetadata motionPhotoMetadata;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private boolean readingEditableVideoTracks;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private long sampleOffsetForEditableVideoTracks;
    private int sampleTrackIndex;
    private final ParsableByteArray scratch;
    private boolean seekToEdvdAtom;
    private boolean seenFtypAtom;
    private final SefReader sefReader;
    private final List<Metadata.Entry> slowMotionMetadataEntries;
    private final SubtitleParser.Factory subtitleParserFactory;
    private Mp4Track[] tracks;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static int brandToFileType(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    static /* synthetic */ Track lambda$processMoovAtom$2(Track track) {
        return track;
    }

    private static boolean shouldParseContainerAtom(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473 || i == 1701082724;
    }

    private static boolean shouldParseLeafAtom(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$newFactory$0(SubtitleParser.Factory factory) {
        return new Extractor[]{new Mp4Extractor(factory)};
    }

    public static ExtractorsFactory newFactory(final SubtitleParser.Factory factory) {
        return new ExtractorsFactory() { // from class: androidx.media3.extractor.mp4.Mp4Extractor$$ExternalSyntheticLambda0
            @Override // androidx.media3.extractor.ExtractorsFactory
            public final Extractor[] createExtractors() {
                return Mp4Extractor.lambda$newFactory$0(factory);
            }
        };
    }

    static /* synthetic */ Extractor[] lambda$static$1() {
        return new Extractor[]{new Mp4Extractor(SubtitleParser.Factory.UNSUPPORTED, 16)};
    }

    @Deprecated
    public Mp4Extractor() {
        this(SubtitleParser.Factory.UNSUPPORTED, 16);
    }

    public Mp4Extractor(SubtitleParser.Factory factory) {
        this(factory, 0);
    }

    @Deprecated
    public Mp4Extractor(int i) {
        this(SubtitleParser.Factory.UNSUPPORTED, i);
    }

    public Mp4Extractor(SubtitleParser.Factory factory, int i) {
        this.subtitleParserFactory = factory;
        this.flags = i;
        this.lastSniffFailures = ImmutableList.of();
        this.parserState = (i & 4) != 0 ? 3 : 0;
        this.sefReader = new SefReader();
        this.slowMotionMetadataEntries = new ArrayList();
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.scratch = new ParsableByteArray();
        this.sampleTrackIndex = -1;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.tracks = new Mp4Track[0];
        this.isSampleDependedOn = (i & 32) == 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        SniffFailure sniffFailureSniffUnfragmented = Sniffer.sniffUnfragmented(extractorInput, (this.flags & 2) != 0);
        this.lastSniffFailures = sniffFailureSniffUnfragmented != null ? ImmutableList.of(sniffFailureSniffUnfragmented) : ImmutableList.of();
        return sniffFailureSniffUnfragmented == null;
    }

    @Override // androidx.media3.extractor.Extractor
    public ImmutableList<SniffFailure> getSniffFailureDetails() {
        return this.lastSniffFailures;
    }

    @Override // androidx.media3.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        if ((this.flags & 16) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public void seek(long j, long j2) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.isSampleDependedOn = (this.flags & 32) == 0;
        if (j == 0) {
            if (this.parserState != 3) {
                enterReadingAtomHeaderState();
                return;
            } else {
                this.sefReader.reset();
                this.slowMotionMetadataEntries.clear();
                return;
            }
        }
        for (Mp4Track mp4Track : this.tracks) {
            updateSampleIndex(mp4Track, j2);
            if (mp4Track.trueHdSampleRechunker != null) {
                mp4Track.trueHdSampleRechunker.reset();
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    if (i == 3) {
                        return readSefData(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                }
                if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // androidx.media3.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        return getSeekPoints(j, -1);
    }

    public SeekMap.SeekPoints getSeekPoints(long j, int i) {
        long jMaybeAdjustSeekOffset;
        long jMaybeAdjustSeekOffset2;
        long j2;
        long j3;
        int indexOfLaterOrEqualSynchronizationSample;
        long j4 = j;
        Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int i2 = i != -1 ? i : this.firstVideoTrackIndex;
        if (i2 != -1) {
            TrackSampleTable trackSampleTable = mp4TrackArr[i2].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j4);
            if (synchronizationSampleIndex == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j5 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            jMaybeAdjustSeekOffset = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j5 >= j4 || synchronizationSampleIndex >= trackSampleTable.sampleCount - 1 || (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j4)) == -1 || indexOfLaterOrEqualSynchronizationSample == synchronizationSampleIndex) {
                j3 = -1;
                j2 = -9223372036854775807L;
            } else {
                j2 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                j3 = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            }
            jMaybeAdjustSeekOffset2 = j3;
            j4 = j5;
        } else {
            jMaybeAdjustSeekOffset = Long.MAX_VALUE;
            jMaybeAdjustSeekOffset2 = -1;
            j2 = -9223372036854775807L;
        }
        if (i == -1) {
            int i3 = 0;
            while (true) {
                Mp4Track[] mp4TrackArr2 = this.tracks;
                if (i3 >= mp4TrackArr2.length) {
                    break;
                }
                if (i3 != this.firstVideoTrackIndex) {
                    TrackSampleTable trackSampleTable2 = mp4TrackArr2[i3].sampleTable;
                    jMaybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j4, jMaybeAdjustSeekOffset);
                    if (j2 != -9223372036854775807L) {
                        jMaybeAdjustSeekOffset2 = maybeAdjustSeekOffset(trackSampleTable2, j2, jMaybeAdjustSeekOffset2);
                    }
                }
                i3++;
            }
        }
        SeekPoint seekPoint = new SeekPoint(j4, jMaybeAdjustSeekOffset);
        if (j2 == -9223372036854775807L) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j2, jMaybeAdjustSeekOffset2));
    }

    public long[] getSampleTimestampsUs(int i) {
        Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length <= i) {
            return new long[0];
        }
        return mp4TrackArr[i].sampleTable.timestampsUs;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException {
        Mp4Box.ContainerBox containerBoxPeek;
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.getData(), 0, 8, true)) {
                processEndOfStreamReadingAtomHeader();
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j = this.atomSize;
        if (j == 1) {
            extractorInput.readFully(this.atomHeader.getData(), 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (containerBoxPeek = this.containerAtoms.peek()) != null) {
                length = containerBoxPeek.endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize < this.atomHeaderBytesRead) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (shouldParseContainerAtom(this.atomType)) {
            long position = extractorInput.getPosition();
            long j2 = this.atomSize;
            int i = this.atomHeaderBytesRead;
            long j3 = (position + j2) - ((long) i);
            if (j2 != i && this.atomType == 1835365473) {
                maybeSkipRemainingMetaAtomHeaderBytes(extractorInput);
            }
            this.containerAtoms.push(new Mp4Box.ContainerBox(this.atomType, j3));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(j3);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            Assertions.checkState(this.atomHeaderBytesRead == 8);
            Assertions.checkState(this.atomSize <= SieveCacheKt.NodeLinkMask);
            ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
            System.arraycopy(this.atomHeader.getData(), 0, parsableByteArray.getData(), 0, 8);
            this.atomData = parsableByteArray;
            this.parserState = 1;
        } else {
            processUnparsedAtom(extractorInput.getPosition() - ((long) this.atomHeaderBytesRead));
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean readAtomPayload(androidx.media3.extractor.ExtractorInput r10, androidx.media3.extractor.PositionHolder r11) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.atomSize
            int r2 = r9.atomHeaderBytesRead
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            androidx.media3.common.util.ParsableByteArray r4 = r9.atomData
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L46
            byte[] r7 = r4.getData()
            int r8 = r9.atomHeaderBytesRead
            int r0 = (int) r0
            r10.readFully(r7, r8, r0)
            int r10 = r9.atomType
            r0 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r0) goto L2b
            r9.seenFtypAtom = r5
            int r10 = processFtypAtom(r4)
            r9.fileType = r10
            goto L5e
        L2b:
            java.util.ArrayDeque<androidx.media3.container.Mp4Box$ContainerBox> r10 = r9.containerAtoms
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L5e
            java.util.ArrayDeque<androidx.media3.container.Mp4Box$ContainerBox> r10 = r9.containerAtoms
            java.lang.Object r10 = r10.peek()
            androidx.media3.container.Mp4Box$ContainerBox r10 = (androidx.media3.container.Mp4Box.ContainerBox) r10
            androidx.media3.container.Mp4Box$LeafBox r0 = new androidx.media3.container.Mp4Box$LeafBox
            int r1 = r9.atomType
            r0.<init>(r1, r4)
            r10.add(r0)
            goto L5e
        L46:
            boolean r4 = r9.seenFtypAtom
            if (r4 != 0) goto L53
            int r4 = r9.atomType
            r7 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r4 != r7) goto L53
            r9.fileType = r5
        L53:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L60
            int r0 = (int) r0
            r10.skipFully(r0)
        L5e:
            r10 = r6
            goto L68
        L60:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.position = r7
            r10 = r5
        L68:
            r9.processAtomEnded(r2)
            boolean r0 = r9.seekToEdvdAtom
            if (r0 == 0) goto L78
            r9.readingEditableVideoTracks = r5
            long r0 = r9.edvdAtomOffset
            r11.position = r0
            r9.seekToEdvdAtom = r6
            r10 = r5
        L78:
            if (r10 == 0) goto L80
            int r10 = r9.parserState
            r11 = 2
            if (r10 == r11) goto L80
            return r5
        L80:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.readAtomPayload(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):boolean");
    }

    private int readSefData(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = this.sefReader.read(extractorInput, positionHolder, this.slowMotionMetadataEntries);
        if (i == 1 && positionHolder.position == 0) {
            enterReadingAtomHeaderState();
        }
        return i;
    }

    private void processAtomEnded(long j) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
            Mp4Box.ContainerBox containerBoxPop = this.containerAtoms.pop();
            if (containerBoxPop.type == 1836019574) {
                processMoovAtom(containerBoxPop);
                this.containerAtoms.clear();
                if (!this.seekToEdvdAtom) {
                    this.parserState = 2;
                }
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(containerBoxPop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private void processMoovAtom(Mp4Box.ContainerBox containerBox) throws ParserException {
        List<Integer> list;
        Metadata metadata;
        Metadata metadata2;
        int i;
        Metadata metadata3;
        List<TrackSampleTable> list2;
        int i2;
        int i3;
        Mp4Box.ContainerBox containerBoxOfType = containerBox.getContainerBoxOfType(1835365473);
        List<Integer> arrayList = new ArrayList<>();
        if (containerBoxOfType != null) {
            Metadata mdtaFromMeta = BoxParser.parseMdtaFromMeta(containerBoxOfType);
            if (this.readingEditableVideoTracks) {
                Assertions.checkStateNotNull(mdtaFromMeta);
                maybeSetDefaultSampleOffsetForEditableVideoTracks(mdtaFromMeta);
                arrayList = getAuxiliaryTrackTypesForEditableVideoTracks(mdtaFromMeta);
            } else if (shouldSeekToEdvdAtom(mdtaFromMeta)) {
                this.seekToEdvdAtom = true;
                return;
            }
            metadata = mdtaFromMeta;
            list = arrayList;
        } else {
            list = arrayList;
            metadata = null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        boolean z = this.fileType == 1;
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(1969517665);
        if (leafBoxOfType != null) {
            Metadata udta = BoxParser.parseUdta(leafBoxOfType);
            gaplessInfoHolder.setFromMetadata(udta);
            metadata2 = udta;
        } else {
            metadata2 = null;
        }
        Metadata metadata4 = new Metadata(BoxParser.parseMvhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1836476516))).data));
        List<TrackSampleTable> traks = BoxParser.parseTraks(containerBox, gaplessInfoHolder, -9223372036854775807L, null, (this.flags & 1) != 0, z, new Function() { // from class: androidx.media3.extractor.mp4.Mp4Extractor$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Mp4Extractor.lambda$processMoovAtom$2((Track) obj);
            }
        });
        if (this.readingEditableVideoTracks) {
            Assertions.checkState(list.size() == traks.size(), String.format(Locale.US, "The number of auxiliary track types from metadata (%d) is not same as the number of editable video tracks (%d)", Integer.valueOf(list.size()), Integer.valueOf(traks.size())));
        }
        int i5 = 0;
        int i6 = 0;
        long j = -9223372036854775807L;
        int size = -1;
        while (i5 < traks.size()) {
            TrackSampleTable trackSampleTable = traks.get(i5);
            if (trackSampleTable.sampleCount == 0) {
                list2 = traks;
                i2 = i6;
                i = i4;
                metadata3 = metadata2;
            } else {
                Track track = trackSampleTable.track;
                i = i4;
                metadata3 = metadata2;
                long j2 = track.durationUs != -9223372036854775807L ? track.durationUs : trackSampleTable.durationUs;
                long jMax = Math.max(j, j2);
                list2 = traks;
                i2 = i6 + 1;
                Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.extractorOutput.track(i6, track.type));
                if ("audio/true-hd".equals(track.format.sampleMimeType)) {
                    i3 = trackSampleTable.maximumSize * 16;
                } else {
                    i3 = trackSampleTable.maximumSize + 30;
                }
                Format.Builder builderBuildUpon = track.format.buildUpon();
                builderBuildUpon.setMaxInputSize(i3);
                if (track.type == 2) {
                    int i7 = track.format.roleFlags;
                    if ((this.flags & 8) != 0) {
                        i7 |= size == -1 ? 1 : 2;
                    }
                    if (track.format.frameRate == -1.0f && j2 > 0 && trackSampleTable.sampleCount > 0) {
                        builderBuildUpon.setFrameRate(trackSampleTable.sampleCount / (j2 / 1000000.0f));
                    }
                    if (this.readingEditableVideoTracks) {
                        i7 |= 32768;
                        builderBuildUpon.setAuxiliaryTrackType(list.get(i5).intValue());
                    }
                    builderBuildUpon.setRoleFlags(i7);
                }
                MetadataUtil.setFormatGaplessInfo(track.type, gaplessInfoHolder, builderBuildUpon);
                int i8 = track.type;
                Metadata[] metadataArr = new Metadata[3];
                metadataArr[i] = this.slowMotionMetadataEntries.isEmpty() ? null : new Metadata(this.slowMotionMetadataEntries);
                metadataArr[1] = metadata3;
                metadataArr[2] = metadata4;
                MetadataUtil.setFormatMetadata(i8, metadata, builderBuildUpon, metadataArr);
                mp4Track.trackOutput.format(builderBuildUpon.build());
                if (track.type == 2 && size == -1) {
                    size = arrayList2.size();
                }
                arrayList2.add(mp4Track);
                j = jMax;
            }
            i5++;
            i4 = i;
            metadata2 = metadata3;
            traks = list2;
            i6 = i2;
        }
        this.firstVideoTrackIndex = size;
        this.durationUs = j;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList2.toArray(new Mp4Track[i4]);
        this.tracks = mp4TrackArr;
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(mp4TrackArr);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private boolean shouldSeekToEdvdAtom(Metadata metadata) {
        MdtaMetadataEntry mdtaMetadataEntryFindMdtaMetadataEntryWithKey;
        if (metadata != null && (this.flags & 64) != 0 && (mdtaMetadataEntryFindMdtaMetadataEntryWithKey = MetadataUtil.findMdtaMetadataEntryWithKey(metadata, MdtaMetadataEntry.KEY_EDITABLE_TRACKS_OFFSET)) != null) {
            long unsignedLongToLong = new ParsableByteArray(mdtaMetadataEntryFindMdtaMetadataEntryWithKey.value).readUnsignedLongToLong();
            if (unsignedLongToLong > 0) {
                this.edvdAtomOffset = unsignedLongToLong;
                return true;
            }
        }
        return false;
    }

    private void maybeSetDefaultSampleOffsetForEditableVideoTracks(Metadata metadata) {
        MdtaMetadataEntry mdtaMetadataEntryFindMdtaMetadataEntryWithKey = MetadataUtil.findMdtaMetadataEntryWithKey(metadata, MdtaMetadataEntry.KEY_EDITABLE_TRACKS_SAMPLES_LOCATION);
        if (mdtaMetadataEntryFindMdtaMetadataEntryWithKey == null || mdtaMetadataEntryFindMdtaMetadataEntryWithKey.value[0] != 0) {
            return;
        }
        this.sampleOffsetForEditableVideoTracks = this.edvdAtomOffset + 16;
    }

    private List<Integer> getAuxiliaryTrackTypesForEditableVideoTracks(Metadata metadata) {
        List<Integer> editableTrackTypesFromMap = ((MdtaMetadataEntry) Assertions.checkStateNotNull(MetadataUtil.findMdtaMetadataEntryWithKey(metadata, MdtaMetadataEntry.KEY_EDITABLE_TRACKS_MAP))).getEditableTrackTypesFromMap();
        ArrayList arrayList = new ArrayList(editableTrackTypesFromMap.size());
        for (int i = 0; i < editableTrackTypesFromMap.size(); i++) {
            int iIntValue = editableTrackTypesFromMap.get(i).intValue();
            int i2 = 1;
            if (iIntValue != 0) {
                if (iIntValue != 1) {
                    i2 = 3;
                    if (iIntValue != 2) {
                        i2 = iIntValue != 3 ? 0 : 4;
                    }
                } else {
                    i2 = 2;
                }
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        long position = extractorInput.getPosition();
        if (this.sampleTrackIndex == -1) {
            int trackIndexOfNextReadSample = getTrackIndexOfNextReadSample(position);
            this.sampleTrackIndex = trackIndexOfNextReadSample;
            if (trackIndexOfNextReadSample == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i2 = mp4Track.sampleIndex;
        long j = mp4Track.sampleTable.offsets[i2] + this.sampleOffsetForEditableVideoTracks;
        int i3 = mp4Track.sampleTable.sizes[i2];
        TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.trueHdSampleRechunker;
        long j2 = (j - position) + ((long) this.sampleBytesRead);
        if (j2 < 0 || j2 >= 262144) {
            positionHolder.position = j;
            return 1;
        }
        if (mp4Track.track.sampleTransformation == 1) {
            j2 += 8;
            i3 -= 8;
        }
        extractorInput.skipFully((int) j2);
        if (!Objects.equals(mp4Track.track.format.sampleMimeType, "video/avc")) {
            this.isSampleDependedOn = true;
        }
        if (mp4Track.track.nalUnitLengthFieldLength != 0) {
            byte[] data = this.nalPrefix.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i4 = mp4Track.track.nalUnitLengthFieldLength + 1;
            int i5 = 4;
            int i6 = 4 - mp4Track.track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < i3) {
                int i7 = this.sampleCurrentNalBytesRemaining;
                if (i7 == 0) {
                    extractorInput.readFully(data, i6, i4);
                    this.sampleBytesRead += i4;
                    this.nalPrefix.setPosition(0);
                    int i8 = this.nalPrefix.readInt();
                    if (i8 < 1) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                    }
                    this.sampleCurrentNalBytesRemaining = i8 - 1;
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, i5);
                    trackOutput.sampleData(this.nalPrefix, 1);
                    this.sampleBytesWritten += 5;
                    i3 += i6;
                    if (!this.isSampleDependedOn && NalUnitUtil.isH264NalUnitDependedOn(data[i5])) {
                        this.isSampleDependedOn = true;
                    }
                } else {
                    int iSampleData = trackOutput.sampleData((DataReader) extractorInput, i7, false);
                    this.sampleBytesRead += iSampleData;
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                    i5 = 4;
                }
            }
        } else {
            if ("audio/ac4".equals(mp4Track.track.format.sampleMimeType)) {
                if (this.sampleBytesWritten == 0) {
                    Ac4Util.getAc4SampleHeader(i3, this.scratch);
                    trackOutput.sampleData(this.scratch, 7);
                    this.sampleBytesWritten += 7;
                }
                i3 += 7;
            } else if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.startSample(extractorInput);
            }
            while (true) {
                int i9 = this.sampleBytesWritten;
                if (i9 >= i3) {
                    break;
                }
                int iSampleData2 = trackOutput.sampleData((DataReader) extractorInput, i3 - i9, false);
                this.sampleBytesRead += iSampleData2;
                this.sampleBytesWritten += iSampleData2;
                this.sampleCurrentNalBytesRemaining -= iSampleData2;
            }
        }
        int i10 = i3;
        long j3 = mp4Track.sampleTable.timestampsUs[i2];
        int i11 = mp4Track.sampleTable.flags[i2];
        if (!this.isSampleDependedOn) {
            i11 |= 67108864;
        }
        if (trueHdSampleRechunker != null) {
            int i12 = i11;
            i = 0;
            trueHdSampleRechunker.sampleMetadata(trackOutput, j3, i12, i10, 0, null);
            if (i2 + 1 == mp4Track.sampleTable.sampleCount) {
                trueHdSampleRechunker.outputPendingSampleMetadata(trackOutput, null);
            }
        } else {
            int i13 = i11;
            i = 0;
            trackOutput.sampleMetadata(j3, i13, i10, 0, null);
        }
        mp4Track.sampleIndex++;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = i;
        this.sampleBytesWritten = i;
        this.sampleCurrentNalBytesRemaining = i;
        this.isSampleDependedOn = (this.flags & 32) != 0 ? i : 1;
        return i;
    }

    private int getTrackIndexOfNextReadSample(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i3 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i3];
            int i4 = mp4Track.sampleIndex;
            if (i4 != mp4Track.sampleTable.sampleCount) {
                long j5 = mp4Track.sampleTable.offsets[i4];
                long j6 = ((long[][]) Util.castNonNull(this.accumulatedSampleSizes))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    j3 = j6;
                    z2 = z3;
                    i2 = i3;
                    j4 = j7;
                }
                if (j6 < j2) {
                    j2 = j6;
                    z = z3;
                    i = i3;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    private void updateSampleIndex(Mp4Track mp4Track, long j) {
        TrackSampleTable trackSampleTable = mp4Track.sampleTable;
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j);
        if (indexOfEarlierOrEqualSynchronizationSample == -1) {
            indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j);
        }
        mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
    }

    private void processEndOfStreamReadingAtomHeader() {
        if (this.fileType != 2 || (this.flags & 2) == 0) {
            return;
        }
        this.extractorOutput.track(0, 4).format(new Format.Builder().setMetadata(this.motionPhotoMetadata == null ? null : new Metadata(this.motionPhotoMetadata)).build());
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
    }

    private void maybeSkipRemainingMetaAtomHeaderBytes(ExtractorInput extractorInput) throws IOException {
        this.scratch.reset(8);
        extractorInput.peekFully(this.scratch.getData(), 0, 8);
        BoxParser.maybeSkipRemainingMetaBoxHeaderBytes(this.scratch);
        extractorInput.skipFully(this.scratch.getPosition());
        extractorInput.resetPeekPosition();
    }

    private void processUnparsedAtom(long j) {
        if (this.atomType == 1836086884) {
            int i = this.atomHeaderBytesRead;
            this.motionPhotoMetadata = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + ((long) i), this.atomSize - ((long) i));
        }
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i = 0; i < mp4TrackArr.length; i++) {
            jArr[i] = new long[mp4TrackArr[i].sampleTable.sampleCount];
            jArr2[i] = mp4TrackArr[i].sampleTable.timestampsUs[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < mp4TrackArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < mp4TrackArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = j;
            j += (long) mp4TrackArr[i3].sampleTable.sizes[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = mp4TrackArr[i3].sampleTable.timestampsUs[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long j, long j2) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j);
        return synchronizationSampleIndex == -1 ? j2 : Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j2);
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long j) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j);
        return indexOfEarlierOrEqualSynchronizationSample == -1 ? trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j) : indexOfEarlierOrEqualSynchronizationSample;
    }

    private static int processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int iBrandToFileType = brandToFileType(parsableByteArray.readInt());
        if (iBrandToFileType != 0) {
            return iBrandToFileType;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            int iBrandToFileType2 = brandToFileType(parsableByteArray.readInt());
            if (iBrandToFileType2 != 0) {
                return iBrandToFileType2;
            }
        }
        return 0;
    }

    private static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;
        public final TrueHdSampleRechunker trueHdSampleRechunker;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.track = track;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput;
            this.trueHdSampleRechunker = "audio/true-hd".equals(track.format.sampleMimeType) ? new TrueHdSampleRechunker() : null;
        }
    }
}
