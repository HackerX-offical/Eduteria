package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Shader extends GeneratedMessageLite<MutationPayload$Shader, a> implements MessageLiteOrBuilder {
    public static final int CENTER_FIELD_NUMBER = 18;
    public static final int COLORS_FIELD_NUMBER = 15;
    private static final MutationPayload$Shader DEFAULT_INSTANCE;
    public static final int END_ANGLE_FIELD_NUMBER = 21;
    public static final int END_FIELD_NUMBER = 12;
    public static final int GRAD_FLAGS_FIELD_NUMBER = 14;
    public static final int IMAGE_INDEX_FIELD_NUMBER = 7;
    public static final int LOCAL_MATRIX_FIELD_NUMBER = 17;
    public static final int MASKED_COLOR_FIELD_NUMBER = 10;
    public static final int MASKED_HEIGHT_FIELD_NUMBER = 9;
    public static final int MASKED_WIDTH_FIELD_NUMBER = 8;
    public static final int MATRIX_FIELD_NUMBER = 4;
    private static volatile Parser<MutationPayload$Shader> PARSER = null;
    public static final int POS_FIELD_NUMBER = 16;
    public static final int RADIUS_FIELD_NUMBER = 19;
    public static final int RAW_FIELD_NUMBER = 5;
    public static final int SAMPLING_FIELD_NUMBER = 6;
    public static final int SHADER_FIELD_NUMBER = 22;
    public static final int START_ANGLE_FIELD_NUMBER = 20;
    public static final int START_FIELD_NUMBER = 11;
    public static final int TILE_MODE_FIELD_NUMBER = 13;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int T_X_FIELD_NUMBER = 2;
    public static final int T_Y_FIELD_NUMBER = 3;
    private int bitField0_;
    private MutationPayload$Point center_;
    private float endAngle_;
    private MutationPayload$Point end_;
    private double gradFlags_;
    private int imageIndex_;
    private MutationPayload$Color4f maskedColor_;
    private int maskedHeight_;
    private int maskedWidth_;
    private float radius_;
    private boolean raw_;
    private MutationPayload$Sampling sampling_;
    private MutationPayload$Shader shader_;
    private float startAngle_;
    private MutationPayload$Point start_;
    private double tX_;
    private double tY_;
    private double tileMode_;
    private int matrixMemoizedSerializedSize = -1;
    private int posMemoizedSerializedSize = -1;
    private int localMatrixMemoizedSerializedSize = -1;
    private String type_ = "";
    private Internal.FloatList matrix_ = GeneratedMessageLite.emptyFloatList();
    private Internal.ProtobufList<MutationPayload$Color4f> colors_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.FloatList pos_ = GeneratedMessageLite.emptyFloatList();
    private Internal.FloatList localMatrix_ = GeneratedMessageLite.emptyFloatList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Shader, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$Shader.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setGradFlags(d2);
            return this;
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setEndAngle(f2);
            return this;
        }

        public final a a(MutationPayload$Point mutationPayload$Point) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setCenter(mutationPayload$Point);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setType(str);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).addAllColors(list);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setRaw(z);
            return this;
        }

        public final void a(int i) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setImageIndex(i);
        }

        public final void a(MutationPayload$Color4f mutationPayload$Color4f) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setMaskedColor(mutationPayload$Color4f);
        }

        public final void a(MutationPayload$Sampling mutationPayload$Sampling) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setSampling(mutationPayload$Sampling);
        }

        public final void a(MutationPayload$Shader mutationPayload$Shader) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setShader(mutationPayload$Shader);
        }

        public final a b(double d2) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setTX(d2);
            return this;
        }

        public final a b(float f2) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setRadius(f2);
            return this;
        }

        public final a b(MutationPayload$Point mutationPayload$Point) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setEnd(mutationPayload$Point);
            return this;
        }

        public final void b(int i) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setMaskedHeight(i);
        }

        public final void b(List list) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).addAllLocalMatrix(list);
        }

        public final a c(double d2) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setTY(d2);
            return this;
        }

        public final a c(float f2) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setStartAngle(f2);
            return this;
        }

        public final a c(MutationPayload$Point mutationPayload$Point) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setStart(mutationPayload$Point);
            return this;
        }

        public final a c(List list) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).addAllMatrix(list);
            return this;
        }

        public final void c(int i) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setMaskedWidth(i);
        }

        public final a d(double d2) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).setTileMode(d2);
            return this;
        }

        public final void d(List list) {
            copyOnWrite();
            ((MutationPayload$Shader) this.instance).addAllPos(list);
        }
    }

    static {
        MutationPayload$Shader mutationPayload$Shader = new MutationPayload$Shader();
        DEFAULT_INSTANCE = mutationPayload$Shader;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Shader.class, mutationPayload$Shader);
    }

    private MutationPayload$Shader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllColors(Iterable<? extends MutationPayload$Color4f> iterable) {
        ensureColorsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.colors_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLocalMatrix(Iterable<? extends Float> iterable) {
        ensureLocalMatrixIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.localMatrix_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMatrix(Iterable<? extends Float> iterable) {
        ensureMatrixIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.matrix_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPos(Iterable<? extends Float> iterable) {
        ensurePosIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pos_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addColors(int i, MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        ensureColorsIsMutable();
        this.colors_.add(i, mutationPayload$Color4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addColors(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        ensureColorsIsMutable();
        this.colors_.add(mutationPayload$Color4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocalMatrix(float f2) {
        ensureLocalMatrixIsMutable();
        this.localMatrix_.addFloat(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMatrix(float f2) {
        ensureMatrixIsMutable();
        this.matrix_.addFloat(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPos(float f2) {
        ensurePosIsMutable();
        this.pos_.addFloat(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCenter() {
        this.center_ = null;
        this.bitField0_ &= -8193;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearColors() {
        this.colors_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnd() {
        this.end_ = null;
        this.bitField0_ &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndAngle() {
        this.bitField0_ &= -65537;
        this.endAngle_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGradFlags() {
        this.bitField0_ &= -4097;
        this.gradFlags_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageIndex() {
        this.bitField0_ &= -33;
        this.imageIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocalMatrix() {
        this.localMatrix_ = GeneratedMessageLite.emptyFloatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaskedColor() {
        this.maskedColor_ = null;
        this.bitField0_ &= -257;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaskedHeight() {
        this.bitField0_ &= -129;
        this.maskedHeight_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaskedWidth() {
        this.bitField0_ &= -65;
        this.maskedWidth_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMatrix() {
        this.matrix_ = GeneratedMessageLite.emptyFloatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPos() {
        this.pos_ = GeneratedMessageLite.emptyFloatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadius() {
        this.bitField0_ &= -16385;
        this.radius_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRaw() {
        this.bitField0_ &= -9;
        this.raw_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSampling() {
        this.sampling_ = null;
        this.bitField0_ &= -17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearShader() {
        this.shader_ = null;
        this.bitField0_ &= -131073;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStart() {
        this.start_ = null;
        this.bitField0_ &= -513;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartAngle() {
        this.bitField0_ &= -32769;
        this.startAngle_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTX() {
        this.bitField0_ &= -3;
        this.tX_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTY() {
        this.bitField0_ &= -5;
        this.tY_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTileMode() {
        this.bitField0_ &= -2049;
        this.tileMode_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    private void ensureColorsIsMutable() {
        Internal.ProtobufList<MutationPayload$Color4f> protobufList = this.colors_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.colors_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureLocalMatrixIsMutable() {
        Internal.FloatList floatList = this.localMatrix_;
        if (floatList.isModifiable()) {
            return;
        }
        this.localMatrix_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    private void ensureMatrixIsMutable() {
        Internal.FloatList floatList = this.matrix_;
        if (floatList.isModifiable()) {
            return;
        }
        this.matrix_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    private void ensurePosIsMutable() {
        Internal.FloatList floatList = this.pos_;
        if (floatList.isModifiable()) {
            return;
        }
        this.pos_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    public static MutationPayload$Shader getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCenter(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        MutationPayload$Point mutationPayload$Point2 = this.center_;
        if (mutationPayload$Point2 != null && mutationPayload$Point2 != MutationPayload$Point.getDefaultInstance()) {
            mutationPayload$Point = MutationPayload$Point.newBuilder(this.center_).mergeFrom(mutationPayload$Point).buildPartial();
        }
        this.center_ = mutationPayload$Point;
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEnd(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        MutationPayload$Point mutationPayload$Point2 = this.end_;
        if (mutationPayload$Point2 != null && mutationPayload$Point2 != MutationPayload$Point.getDefaultInstance()) {
            mutationPayload$Point = MutationPayload$Point.newBuilder(this.end_).mergeFrom(mutationPayload$Point).buildPartial();
        }
        this.end_ = mutationPayload$Point;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMaskedColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        MutationPayload$Color4f mutationPayload$Color4f2 = this.maskedColor_;
        if (mutationPayload$Color4f2 != null && mutationPayload$Color4f2 != MutationPayload$Color4f.getDefaultInstance()) {
            mutationPayload$Color4f = MutationPayload$Color4f.newBuilder(this.maskedColor_).mergeFrom(mutationPayload$Color4f).buildPartial();
        }
        this.maskedColor_ = mutationPayload$Color4f;
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSampling(MutationPayload$Sampling mutationPayload$Sampling) {
        mutationPayload$Sampling.getClass();
        MutationPayload$Sampling mutationPayload$Sampling2 = this.sampling_;
        if (mutationPayload$Sampling2 != null && mutationPayload$Sampling2 != MutationPayload$Sampling.getDefaultInstance()) {
            mutationPayload$Sampling = MutationPayload$Sampling.newBuilder(this.sampling_).mergeFrom(mutationPayload$Sampling).buildPartial();
        }
        this.sampling_ = mutationPayload$Sampling;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeShader(MutationPayload$Shader mutationPayload$Shader) {
        mutationPayload$Shader.getClass();
        MutationPayload$Shader mutationPayload$Shader2 = this.shader_;
        if (mutationPayload$Shader2 != null && mutationPayload$Shader2 != getDefaultInstance()) {
            mutationPayload$Shader = newBuilder(this.shader_).mergeFrom(mutationPayload$Shader).buildPartial();
        }
        this.shader_ = mutationPayload$Shader;
        this.bitField0_ |= 131072;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStart(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        MutationPayload$Point mutationPayload$Point2 = this.start_;
        if (mutationPayload$Point2 != null && mutationPayload$Point2 != MutationPayload$Point.getDefaultInstance()) {
            mutationPayload$Point = MutationPayload$Point.newBuilder(this.start_).mergeFrom(mutationPayload$Point).buildPartial();
        }
        this.start_ = mutationPayload$Point;
        this.bitField0_ |= 512;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Shader mutationPayload$Shader) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Shader);
    }

    public static MutationPayload$Shader parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Shader parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(ByteString byteString) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Shader parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Shader parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(InputStream inputStream) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Shader parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Shader parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(byte[] bArr) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Shader parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Shader> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeColors(int i) {
        ensureColorsIsMutable();
        this.colors_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCenter(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        this.center_ = mutationPayload$Point;
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColors(int i, MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        ensureColorsIsMutable();
        this.colors_.set(i, mutationPayload$Color4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnd(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        this.end_ = mutationPayload$Point;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndAngle(float f2) {
        this.bitField0_ |= 65536;
        this.endAngle_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGradFlags(double d2) {
        this.bitField0_ |= 4096;
        this.gradFlags_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageIndex(int i) {
        this.bitField0_ |= 32;
        this.imageIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalMatrix(int i, float f2) {
        ensureLocalMatrixIsMutable();
        this.localMatrix_.setFloat(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        this.maskedColor_ = mutationPayload$Color4f;
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedHeight(int i) {
        this.bitField0_ |= 128;
        this.maskedHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedWidth(int i) {
        this.bitField0_ |= 64;
        this.maskedWidth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMatrix(int i, float f2) {
        ensureMatrixIsMutable();
        this.matrix_.setFloat(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPos(int i, float f2) {
        ensurePosIsMutable();
        this.pos_.setFloat(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadius(float f2) {
        this.bitField0_ |= 16384;
        this.radius_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRaw(boolean z) {
        this.bitField0_ |= 8;
        this.raw_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSampling(MutationPayload$Sampling mutationPayload$Sampling) {
        mutationPayload$Sampling.getClass();
        this.sampling_ = mutationPayload$Sampling;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShader(MutationPayload$Shader mutationPayload$Shader) {
        mutationPayload$Shader.getClass();
        this.shader_ = mutationPayload$Shader;
        this.bitField0_ |= 131072;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStart(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        this.start_ = mutationPayload$Point;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartAngle(float f2) {
        this.bitField0_ |= 32768;
        this.startAngle_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTX(double d2) {
        this.bitField0_ |= 2;
        this.tX_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTY(double d2) {
        this.bitField0_ |= 4;
        this.tY_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTileMode(double d2) {
        this.bitField0_ |= 2048;
        this.tileMode_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Shader();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0004\u0000\u0001ለ\u0000\u0002က\u0001\u0003က\u0002\u0004$\u0005ဇ\u0003\u0006ဉ\u0004\u0007င\u0005\bင\u0006\tင\u0007\nဉ\b\u000bဉ\t\fဉ\n\rက\u000b\u000eက\f\u000f\u001b\u0010$\u0011$\u0012ဉ\r\u0013ခ\u000e\u0014ခ\u000f\u0015ခ\u0010\u0016ဉ\u0011", new Object[]{"bitField0_", "type_", "tX_", "tY_", "matrix_", "raw_", "sampling_", "imageIndex_", "maskedWidth_", "maskedHeight_", "maskedColor_", "start_", "end_", "tileMode_", "gradFlags_", "colors_", MutationPayload$Color4f.class, "pos_", "localMatrix_", "center_", "radius_", "startAngle_", "endAngle_", "shader_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Shader> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Shader.class) {
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

    public MutationPayload$Point getCenter() {
        MutationPayload$Point mutationPayload$Point = this.center_;
        return mutationPayload$Point == null ? MutationPayload$Point.getDefaultInstance() : mutationPayload$Point;
    }

    public MutationPayload$Color4f getColors(int i) {
        return this.colors_.get(i);
    }

    public int getColorsCount() {
        return this.colors_.size();
    }

    public List<MutationPayload$Color4f> getColorsList() {
        return this.colors_;
    }

    public b getColorsOrBuilder(int i) {
        return this.colors_.get(i);
    }

    public List<? extends b> getColorsOrBuilderList() {
        return this.colors_;
    }

    public MutationPayload$Point getEnd() {
        MutationPayload$Point mutationPayload$Point = this.end_;
        return mutationPayload$Point == null ? MutationPayload$Point.getDefaultInstance() : mutationPayload$Point;
    }

    public float getEndAngle() {
        return this.endAngle_;
    }

    public double getGradFlags() {
        return this.gradFlags_;
    }

    public int getImageIndex() {
        return this.imageIndex_;
    }

    public float getLocalMatrix(int i) {
        return this.localMatrix_.getFloat(i);
    }

    public int getLocalMatrixCount() {
        return this.localMatrix_.size();
    }

    public List<Float> getLocalMatrixList() {
        return this.localMatrix_;
    }

    public MutationPayload$Color4f getMaskedColor() {
        MutationPayload$Color4f mutationPayload$Color4f = this.maskedColor_;
        return mutationPayload$Color4f == null ? MutationPayload$Color4f.getDefaultInstance() : mutationPayload$Color4f;
    }

    public int getMaskedHeight() {
        return this.maskedHeight_;
    }

    public int getMaskedWidth() {
        return this.maskedWidth_;
    }

    public float getMatrix(int i) {
        return this.matrix_.getFloat(i);
    }

    public int getMatrixCount() {
        return this.matrix_.size();
    }

    public List<Float> getMatrixList() {
        return this.matrix_;
    }

    public float getPos(int i) {
        return this.pos_.getFloat(i);
    }

    public int getPosCount() {
        return this.pos_.size();
    }

    public List<Float> getPosList() {
        return this.pos_;
    }

    public float getRadius() {
        return this.radius_;
    }

    public boolean getRaw() {
        return this.raw_;
    }

    public MutationPayload$Sampling getSampling() {
        MutationPayload$Sampling mutationPayload$Sampling = this.sampling_;
        return mutationPayload$Sampling == null ? MutationPayload$Sampling.getDefaultInstance() : mutationPayload$Sampling;
    }

    public MutationPayload$Shader getShader() {
        MutationPayload$Shader mutationPayload$Shader = this.shader_;
        return mutationPayload$Shader == null ? getDefaultInstance() : mutationPayload$Shader;
    }

    public MutationPayload$Point getStart() {
        MutationPayload$Point mutationPayload$Point = this.start_;
        return mutationPayload$Point == null ? MutationPayload$Point.getDefaultInstance() : mutationPayload$Point;
    }

    public float getStartAngle() {
        return this.startAngle_;
    }

    public double getTX() {
        return this.tX_;
    }

    public double getTY() {
        return this.tY_;
    }

    public double getTileMode() {
        return this.tileMode_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasCenter() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasEnd() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasEndAngle() {
        return (this.bitField0_ & 65536) != 0;
    }

    public boolean hasGradFlags() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasImageIndex() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasMaskedColor() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasMaskedHeight() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasMaskedWidth() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasRadius() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasRaw() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSampling() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasShader() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasStart() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasStartAngle() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasTX() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTY() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTileMode() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }
}
