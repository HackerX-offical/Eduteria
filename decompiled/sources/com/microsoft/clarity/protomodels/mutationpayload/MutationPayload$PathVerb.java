package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.l;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$PathVerb extends GeneratedMessageLite<MutationPayload$PathVerb, a> implements l {
    public static final int CPX1_FIELD_NUMBER = 9;
    public static final int CPX2_FIELD_NUMBER = 11;
    public static final int CPY1_FIELD_NUMBER = 10;
    public static final int CPY2_FIELD_NUMBER = 12;
    private static final MutationPayload$PathVerb DEFAULT_INSTANCE;
    public static final int IS_C_C_W_FIELD_NUMBER = 3;
    private static volatile Parser<MutationPayload$PathVerb> PARSER = null;
    public static final int R_RECT_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int WEIGHT_FIELD_NUMBER = 8;
    public static final int X1_FIELD_NUMBER = 4;
    public static final int X2_FIELD_NUMBER = 6;
    public static final int X_FIELD_NUMBER = 13;
    public static final int Y1_FIELD_NUMBER = 5;
    public static final int Y2_FIELD_NUMBER = 7;
    public static final int Y_FIELD_NUMBER = 14;
    private int bitField0_;
    private float cpx1_;
    private float cpx2_;
    private float cpy1_;
    private float cpy2_;
    private boolean isCCW_;
    private MutationPayload$Rect rRect_;
    private String type_ = "";
    private float weight_;
    private float x1_;
    private float x2_;
    private float x_;
    private float y1_;
    private float y2_;
    private float y_;

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$PathVerb, a> implements l {
        public a() {
            super(MutationPayload$PathVerb.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setCpx1(f2);
            return this;
        }

        public final a a(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setRRect(mutationPayload$Rect);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setType(str);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setIsCCW(z);
            return this;
        }

        public final a b(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setCpx2(f2);
            return this;
        }

        public final a c(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setCpy1(f2);
            return this;
        }

        public final a d(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setCpy2(f2);
            return this;
        }

        public final a e(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setWeight(f2);
            return this;
        }

        public final a f(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setX(f2);
            return this;
        }

        public final a g(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setX1(f2);
            return this;
        }

        public final a h(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setX2(f2);
            return this;
        }

        public final a i(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setY(f2);
            return this;
        }

        public final a j(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setY1(f2);
            return this;
        }

        public final a k(float f2) {
            copyOnWrite();
            ((MutationPayload$PathVerb) this.instance).setY2(f2);
            return this;
        }
    }

    static {
        MutationPayload$PathVerb mutationPayload$PathVerb = new MutationPayload$PathVerb();
        DEFAULT_INSTANCE = mutationPayload$PathVerb;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$PathVerb.class, mutationPayload$PathVerb);
    }

    private MutationPayload$PathVerb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpx1() {
        this.bitField0_ &= -257;
        this.cpx1_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpx2() {
        this.bitField0_ &= -1025;
        this.cpx2_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpy1() {
        this.bitField0_ &= -513;
        this.cpy1_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpy2() {
        this.bitField0_ &= -2049;
        this.cpy2_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsCCW() {
        this.bitField0_ &= -5;
        this.isCCW_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRRect() {
        this.rRect_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWeight() {
        this.bitField0_ &= -129;
        this.weight_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearX() {
        this.bitField0_ &= -4097;
        this.x_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearX1() {
        this.bitField0_ &= -9;
        this.x1_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearX2() {
        this.bitField0_ &= -33;
        this.x2_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearY() {
        this.bitField0_ &= -8193;
        this.y_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearY1() {
        this.bitField0_ &= -17;
        this.y1_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearY2() {
        this.bitField0_ &= -65;
        this.y2_ = 0.0f;
    }

    public static MutationPayload$PathVerb getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRRect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.rRect_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.rRect_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.rRect_ = mutationPayload$Rect;
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$PathVerb mutationPayload$PathVerb) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$PathVerb);
    }

    public static MutationPayload$PathVerb parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathVerb parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(ByteString byteString) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$PathVerb parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$PathVerb parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(InputStream inputStream) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathVerb parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$PathVerb parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(byte[] bArr) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$PathVerb parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$PathVerb> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpx1(float f2) {
        this.bitField0_ |= 256;
        this.cpx1_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpx2(float f2) {
        this.bitField0_ |= 1024;
        this.cpx2_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpy1(float f2) {
        this.bitField0_ |= 512;
        this.cpy1_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpy2(float f2) {
        this.bitField0_ |= 2048;
        this.cpy2_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsCCW(boolean z) {
        this.bitField0_ |= 4;
        this.isCCW_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRRect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.rRect_ = mutationPayload$Rect;
        this.bitField0_ |= 2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeight(float f2) {
        this.bitField0_ |= 128;
        this.weight_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(float f2) {
        this.bitField0_ |= 4096;
        this.x_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX1(float f2) {
        this.bitField0_ |= 8;
        this.x1_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX2(float f2) {
        this.bitField0_ |= 32;
        this.x2_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(float f2) {
        this.bitField0_ |= 8192;
        this.y_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY1(float f2) {
        this.bitField0_ |= 16;
        this.y1_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY2(float f2) {
        this.bitField0_ |= 64;
        this.y2_ = f2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$PathVerb();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ለ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tခ\b\nခ\t\u000bခ\n\fခ\u000b\rခ\f\u000eခ\r", new Object[]{"bitField0_", "type_", "rRect_", "isCCW_", "x1_", "y1_", "x2_", "y2_", "weight_", "cpx1_", "cpy1_", "cpx2_", "cpy2_", "x_", "y_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$PathVerb> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$PathVerb.class) {
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

    public float getCpx1() {
        return this.cpx1_;
    }

    public float getCpx2() {
        return this.cpx2_;
    }

    public float getCpy1() {
        return this.cpy1_;
    }

    public float getCpy2() {
        return this.cpy2_;
    }

    public boolean getIsCCW() {
        return this.isCCW_;
    }

    public MutationPayload$Rect getRRect() {
        MutationPayload$Rect mutationPayload$Rect = this.rRect_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public float getWeight() {
        return this.weight_;
    }

    public float getX() {
        return this.x_;
    }

    public float getX1() {
        return this.x1_;
    }

    public float getX2() {
        return this.x2_;
    }

    public float getY() {
        return this.y_;
    }

    public float getY1() {
        return this.y1_;
    }

    public float getY2() {
        return this.y2_;
    }

    public boolean hasCpx1() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasCpx2() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasCpy1() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasCpy2() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasIsCCW() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasRRect() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasWeight() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasX() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasX1() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasX2() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasY() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasY1() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasY2() {
        return (this.bitField0_ & 64) != 0;
    }
}
