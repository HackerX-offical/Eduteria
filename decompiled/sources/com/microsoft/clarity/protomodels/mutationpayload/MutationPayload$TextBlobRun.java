package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.f;
import com.microsoft.clarity.j.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$TextBlobRun extends GeneratedMessageLite<MutationPayload$TextBlobRun, a> implements o {
    public static final int CLUSTERS_FIELD_NUMBER = 8;
    private static final MutationPayload$TextBlobRun DEFAULT_INSTANCE;
    public static final int FONT_SCALE_X_FIELD_NUMBER = 3;
    public static final int FONT_SIZE_FIELD_NUMBER = 2;
    public static final int FONT_SKEW_X_FIELD_NUMBER = 4;
    public static final int GLYPHS_FIELD_NUMBER = 6;
    private static volatile Parser<MutationPayload$TextBlobRun> PARSER = null;
    public static final int POINT_FIELD_NUMBER = 1;
    public static final int POSITIONS_FIELD_NUMBER = 7;
    public static final int TEXT_FIELD_NUMBER = 9;
    public static final int TYPEFACE_INDEX_FIELD_NUMBER = 5;
    private int bitField0_;
    private float fontScaleX_;
    private float fontSize_;
    private float fontSkewX_;
    private MutationPayload$Point point_;
    private int typefaceIndex_;
    private int glyphsMemoizedSerializedSize = -1;
    private int clustersMemoizedSerializedSize = -1;
    private Internal.DoubleList glyphs_ = GeneratedMessageLite.emptyDoubleList();
    private Internal.ProtobufList<MutationPayload$FloatList> positions_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.DoubleList clusters_ = GeneratedMessageLite.emptyDoubleList();
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$TextBlobRun, a> implements o {
        public a() {
            super(MutationPayload$TextBlobRun.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(MutationPayload$Point mutationPayload$Point) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).setPoint(mutationPayload$Point);
            return this;
        }

        public final void a(float f2) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).setFontScaleX(f2);
        }

        public final void a(int i) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).setTypefaceIndex(i);
        }

        public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).addPositions(mutationPayload$FloatList);
        }

        public final void a(String str) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).setText(str);
        }

        public final void a(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).addAllClusters(arrayList);
        }

        public final a b(float f2) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).setFontSize(f2);
            return this;
        }

        public final void b(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).addAllGlyphs(arrayList);
        }

        public final void c(float f2) {
            copyOnWrite();
            ((MutationPayload$TextBlobRun) this.instance).setFontSkewX(f2);
        }
    }

    static {
        MutationPayload$TextBlobRun mutationPayload$TextBlobRun = new MutationPayload$TextBlobRun();
        DEFAULT_INSTANCE = mutationPayload$TextBlobRun;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$TextBlobRun.class, mutationPayload$TextBlobRun);
    }

    private MutationPayload$TextBlobRun() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllClusters(Iterable<? extends Double> iterable) {
        ensureClustersIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.clusters_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllGlyphs(Iterable<? extends Double> iterable) {
        ensureGlyphsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.glyphs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPositions(Iterable<? extends MutationPayload$FloatList> iterable) {
        ensurePositionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.positions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addClusters(double d2) {
        ensureClustersIsMutable();
        this.clusters_.addDouble(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGlyphs(double d2) {
        ensureGlyphsIsMutable();
        this.glyphs_.addDouble(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPositions(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensurePositionsIsMutable();
        this.positions_.add(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPositions(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensurePositionsIsMutable();
        this.positions_.add(mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClusters() {
        this.clusters_ = GeneratedMessageLite.emptyDoubleList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFontScaleX() {
        this.bitField0_ &= -5;
        this.fontScaleX_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFontSize() {
        this.bitField0_ &= -3;
        this.fontSize_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFontSkewX() {
        this.bitField0_ &= -9;
        this.fontSkewX_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGlyphs() {
        this.glyphs_ = GeneratedMessageLite.emptyDoubleList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPoint() {
        this.point_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPositions() {
        this.positions_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearText() {
        this.bitField0_ &= -33;
        this.text_ = getDefaultInstance().getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypefaceIndex() {
        this.bitField0_ &= -17;
        this.typefaceIndex_ = 0;
    }

    private void ensureClustersIsMutable() {
        Internal.DoubleList doubleList = this.clusters_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.clusters_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    private void ensureGlyphsIsMutable() {
        Internal.DoubleList doubleList = this.glyphs_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.glyphs_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    private void ensurePositionsIsMutable() {
        Internal.ProtobufList<MutationPayload$FloatList> protobufList = this.positions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.positions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$TextBlobRun getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePoint(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        MutationPayload$Point mutationPayload$Point2 = this.point_;
        if (mutationPayload$Point2 != null && mutationPayload$Point2 != MutationPayload$Point.getDefaultInstance()) {
            mutationPayload$Point = MutationPayload$Point.newBuilder(this.point_).mergeFrom(mutationPayload$Point).buildPartial();
        }
        this.point_ = mutationPayload$Point;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$TextBlobRun mutationPayload$TextBlobRun) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$TextBlobRun);
    }

    public static MutationPayload$TextBlobRun parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$TextBlobRun parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$TextBlobRun parseFrom(ByteString byteString) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$TextBlobRun parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$TextBlobRun parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$TextBlobRun parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$TextBlobRun parseFrom(InputStream inputStream) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$TextBlobRun parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$TextBlobRun parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$TextBlobRun parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$TextBlobRun parseFrom(byte[] bArr) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$TextBlobRun parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlobRun) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$TextBlobRun> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePositions(int i) {
        ensurePositionsIsMutable();
        this.positions_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClusters(int i, double d2) {
        ensureClustersIsMutable();
        this.clusters_.setDouble(i, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFontScaleX(float f2) {
        this.bitField0_ |= 4;
        this.fontScaleX_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFontSize(float f2) {
        this.bitField0_ |= 2;
        this.fontSize_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFontSkewX(float f2) {
        this.bitField0_ |= 8;
        this.fontSkewX_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGlyphs(int i, double d2) {
        ensureGlyphsIsMutable();
        this.glyphs_.setDouble(i, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPoint(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        this.point_ = mutationPayload$Point;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPositions(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensurePositionsIsMutable();
        this.positions_.set(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.text_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.text_ = byteString.toStringUtf8();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypefaceIndex(int i) {
        this.bitField0_ |= 16;
        this.typefaceIndex_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$TextBlobRun();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0003\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005င\u0004\u0006#\u0007\u001b\b#\tለ\u0005", new Object[]{"bitField0_", "point_", "fontSize_", "fontScaleX_", "fontSkewX_", "typefaceIndex_", "glyphs_", "positions_", MutationPayload$FloatList.class, "clusters_", "text_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$TextBlobRun> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$TextBlobRun.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public double getClusters(int i) {
        return this.clusters_.getDouble(i);
    }

    public int getClustersCount() {
        return this.clusters_.size();
    }

    public List<Double> getClustersList() {
        return this.clusters_;
    }

    public float getFontScaleX() {
        return this.fontScaleX_;
    }

    public float getFontSize() {
        return this.fontSize_;
    }

    public float getFontSkewX() {
        return this.fontSkewX_;
    }

    public double getGlyphs(int i) {
        return this.glyphs_.getDouble(i);
    }

    public int getGlyphsCount() {
        return this.glyphs_.size();
    }

    public List<Double> getGlyphsList() {
        return this.glyphs_;
    }

    public MutationPayload$Point getPoint() {
        MutationPayload$Point mutationPayload$Point = this.point_;
        return mutationPayload$Point == null ? MutationPayload$Point.getDefaultInstance() : mutationPayload$Point;
    }

    public MutationPayload$FloatList getPositions(int i) {
        return this.positions_.get(i);
    }

    public int getPositionsCount() {
        return this.positions_.size();
    }

    public List<MutationPayload$FloatList> getPositionsList() {
        return this.positions_;
    }

    public f getPositionsOrBuilder(int i) {
        return this.positions_.get(i);
    }

    public List<? extends f> getPositionsOrBuilderList() {
        return this.positions_;
    }

    public String getText() {
        return this.text_;
    }

    public ByteString getTextBytes() {
        return ByteString.copyFromUtf8(this.text_);
    }

    public int getTypefaceIndex() {
        return this.typefaceIndex_;
    }

    public boolean hasFontScaleX() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasFontSize() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFontSkewX() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPoint() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasText() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasTypefaceIndex() {
        return (this.bitField0_ & 16) != 0;
    }
}
