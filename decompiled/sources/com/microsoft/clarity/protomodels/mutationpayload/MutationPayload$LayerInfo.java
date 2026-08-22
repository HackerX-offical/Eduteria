package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$LayerInfo extends GeneratedMessageLite<MutationPayload$LayerInfo, a> implements MessageLiteOrBuilder {
    public static final int COLOR_MODE_FIELD_NUMBER = 2;
    private static final MutationPayload$LayerInfo DEFAULT_INSTANCE;
    public static final int OFFSET_FIELD_NUMBER = 3;
    public static final int PAINT_BITS_FIELD_NUMBER = 1;
    private static volatile Parser<MutationPayload$LayerInfo> PARSER = null;
    public static final int POST_TRANSLATE_FIELD_NUMBER = 4;
    private int bitField0_;
    private int colorMode_;
    private int offsetMemoizedSerializedSize = -1;
    private Internal.FloatList offset_ = GeneratedMessageLite.emptyFloatList();
    private int paintBits_;
    private boolean postTranslate_;

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$LayerInfo, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$LayerInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(int i) {
            copyOnWrite();
            ((MutationPayload$LayerInfo) this.instance).setColorMode(i);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$LayerInfo) this.instance).addAllOffset(list);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$LayerInfo) this.instance).setPostTranslate(z);
            return this;
        }

        public final a b(int i) {
            copyOnWrite();
            ((MutationPayload$LayerInfo) this.instance).setPaintBits(i);
            return this;
        }
    }

    static {
        MutationPayload$LayerInfo mutationPayload$LayerInfo = new MutationPayload$LayerInfo();
        DEFAULT_INSTANCE = mutationPayload$LayerInfo;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$LayerInfo.class, mutationPayload$LayerInfo);
    }

    private MutationPayload$LayerInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOffset(Iterable<? extends Float> iterable) {
        ensureOffsetIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.offset_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOffset(float f2) {
        ensureOffsetIsMutable();
        this.offset_.addFloat(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearColorMode() {
        this.bitField0_ &= -3;
        this.colorMode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOffset() {
        this.offset_ = GeneratedMessageLite.emptyFloatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPaintBits() {
        this.bitField0_ &= -2;
        this.paintBits_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPostTranslate() {
        this.bitField0_ &= -5;
        this.postTranslate_ = false;
    }

    private void ensureOffsetIsMutable() {
        Internal.FloatList floatList = this.offset_;
        if (floatList.isModifiable()) {
            return;
        }
        this.offset_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    public static MutationPayload$LayerInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$LayerInfo mutationPayload$LayerInfo) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$LayerInfo);
    }

    public static MutationPayload$LayerInfo parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$LayerInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$LayerInfo parseFrom(ByteString byteString) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$LayerInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$LayerInfo parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$LayerInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$LayerInfo parseFrom(InputStream inputStream) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$LayerInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$LayerInfo parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$LayerInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$LayerInfo parseFrom(byte[] bArr) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$LayerInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$LayerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$LayerInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorMode(int i) {
        this.bitField0_ |= 2;
        this.colorMode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffset(int i, float f2) {
        ensureOffsetIsMutable();
        this.offset_.setFloat(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaintBits(int i) {
        this.bitField0_ |= 1;
        this.paintBits_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostTranslate(boolean z) {
        this.bitField0_ |= 4;
        this.postTranslate_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$LayerInfo();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003$\u0004ဇ\u0002", new Object[]{"bitField0_", "paintBits_", "colorMode_", "offset_", "postTranslate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$LayerInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$LayerInfo.class) {
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

    public int getColorMode() {
        return this.colorMode_;
    }

    public float getOffset(int i) {
        return this.offset_.getFloat(i);
    }

    public int getOffsetCount() {
        return this.offset_.size();
    }

    public List<Float> getOffsetList() {
        return this.offset_;
    }

    public int getPaintBits() {
        return this.paintBits_;
    }

    public boolean getPostTranslate() {
        return this.postTranslate_;
    }

    public boolean hasColorMode() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPaintBits() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPostTranslate() {
        return (this.bitField0_ & 4) != 0;
    }
}
