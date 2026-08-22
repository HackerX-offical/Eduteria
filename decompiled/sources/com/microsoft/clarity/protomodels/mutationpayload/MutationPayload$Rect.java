package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Rect extends GeneratedMessageLite<MutationPayload$Rect, a> implements MessageLiteOrBuilder {
    public static final int BOTTOM_FIELD_NUMBER = 3;
    private static final MutationPayload$Rect DEFAULT_INSTANCE;
    public static final int LEFT_FIELD_NUMBER = 2;
    private static volatile Parser<MutationPayload$Rect> PARSER = null;
    public static final int RADII_FIELD_NUMBER = 5;
    public static final int RIGHT_FIELD_NUMBER = 4;
    public static final int TOP_FIELD_NUMBER = 1;
    private int bitField0_;
    private float bottom_;
    private float left_;
    private Internal.ProtobufList<MutationPayload$FloatList> radii_ = GeneratedMessageLite.emptyProtobufList();
    private float right_;
    private float top_;

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Rect, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$Rect.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$Rect) this.instance).setBottom(f2);
            return this;
        }

        public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
            copyOnWrite();
            ((MutationPayload$Rect) this.instance).addRadii(mutationPayload$FloatList);
        }

        public final a b(float f2) {
            copyOnWrite();
            ((MutationPayload$Rect) this.instance).setLeft(f2);
            return this;
        }

        public final a c(float f2) {
            copyOnWrite();
            ((MutationPayload$Rect) this.instance).setRight(f2);
            return this;
        }

        public final a d(float f2) {
            copyOnWrite();
            ((MutationPayload$Rect) this.instance).setTop(f2);
            return this;
        }
    }

    static {
        MutationPayload$Rect mutationPayload$Rect = new MutationPayload$Rect();
        DEFAULT_INSTANCE = mutationPayload$Rect;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Rect.class, mutationPayload$Rect);
    }

    private MutationPayload$Rect() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRadii(Iterable<? extends MutationPayload$FloatList> iterable) {
        ensureRadiiIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.radii_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRadii(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureRadiiIsMutable();
        this.radii_.add(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRadii(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureRadiiIsMutable();
        this.radii_.add(mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBottom() {
        this.bitField0_ &= -5;
        this.bottom_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLeft() {
        this.bitField0_ &= -3;
        this.left_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadii() {
        this.radii_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRight() {
        this.bitField0_ &= -9;
        this.right_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTop() {
        this.bitField0_ &= -2;
        this.top_ = 0.0f;
    }

    private void ensureRadiiIsMutable() {
        Internal.ProtobufList<MutationPayload$FloatList> protobufList = this.radii_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.radii_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Rect getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Rect mutationPayload$Rect) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Rect);
    }

    public static MutationPayload$Rect parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Rect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(ByteString byteString) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Rect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Rect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(InputStream inputStream) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Rect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Rect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(byte[] bArr) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Rect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Rect> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRadii(int i) {
        ensureRadiiIsMutable();
        this.radii_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottom(float f2) {
        this.bitField0_ |= 4;
        this.bottom_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeft(float f2) {
        this.bitField0_ |= 2;
        this.left_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadii(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureRadiiIsMutable();
        this.radii_.set(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRight(float f2) {
        this.bitField0_ |= 8;
        this.right_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTop(float f2) {
        this.bitField0_ |= 1;
        this.top_ = f2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Rect();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005\u001b", new Object[]{"bitField0_", "top_", "left_", "bottom_", "right_", "radii_", MutationPayload$FloatList.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Rect> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Rect.class) {
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

    public float getBottom() {
        return this.bottom_;
    }

    public float getLeft() {
        return this.left_;
    }

    public MutationPayload$FloatList getRadii(int i) {
        return this.radii_.get(i);
    }

    public int getRadiiCount() {
        return this.radii_.size();
    }

    public List<MutationPayload$FloatList> getRadiiList() {
        return this.radii_;
    }

    public f getRadiiOrBuilder(int i) {
        return this.radii_.get(i);
    }

    public List<? extends f> getRadiiOrBuilderList() {
        return this.radii_;
    }

    public float getRight() {
        return this.right_;
    }

    public float getTop() {
        return this.top_;
    }

    public boolean hasBottom() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLeft() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRight() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTop() {
        return (this.bitField0_ & 1) != 0;
    }
}
