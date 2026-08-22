package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Sampling extends GeneratedMessageLite<MutationPayload$Sampling, a> implements MessageLiteOrBuilder {
    private static final MutationPayload$Sampling DEFAULT_INSTANCE;
    public static final int FILTER_FIELD_NUMBER = 4;
    public static final int MIPMAP_FIELD_NUMBER = 5;
    private static volatile Parser<MutationPayload$Sampling> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int _B_FIELD_NUMBER = 2;
    public static final int _C_FIELD_NUMBER = 3;
    private float B_;
    private float C_;
    private int bitField0_;
    private int filter_;
    private int mipmap_;
    private String type_ = "";

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Sampling, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$Sampling.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$Sampling) this.instance).setB(f2);
            return this;
        }

        public final a a(int i) {
            copyOnWrite();
            ((MutationPayload$Sampling) this.instance).setFilter(i);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$Sampling) this.instance).setType(str);
            return this;
        }

        public final a b(float f2) {
            copyOnWrite();
            ((MutationPayload$Sampling) this.instance).setC(f2);
            return this;
        }

        public final a b(int i) {
            copyOnWrite();
            ((MutationPayload$Sampling) this.instance).setMipmap(i);
            return this;
        }
    }

    static {
        MutationPayload$Sampling mutationPayload$Sampling = new MutationPayload$Sampling();
        DEFAULT_INSTANCE = mutationPayload$Sampling;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Sampling.class, mutationPayload$Sampling);
    }

    private MutationPayload$Sampling() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearB() {
        this.bitField0_ &= -3;
        this.B_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearC() {
        this.bitField0_ &= -5;
        this.C_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilter() {
        this.bitField0_ &= -9;
        this.filter_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMipmap() {
        this.bitField0_ &= -17;
        this.mipmap_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    public static MutationPayload$Sampling getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Sampling mutationPayload$Sampling) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Sampling);
    }

    public static MutationPayload$Sampling parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Sampling parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(ByteString byteString) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Sampling parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Sampling parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(InputStream inputStream) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Sampling parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Sampling parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(byte[] bArr) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Sampling parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Sampling> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setB(float f2) {
        this.bitField0_ |= 2;
        this.B_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setC(float f2) {
        this.bitField0_ |= 4;
        this.C_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilter(int i) {
        this.bitField0_ |= 8;
        this.filter_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMipmap(int i) {
        this.bitField0_ |= 16;
        this.mipmap_ = i;
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
                return new MutationPayload$Sampling();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ለ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"bitField0_", "type_", "B_", "C_", "filter_", "mipmap_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Sampling> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Sampling.class) {
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

    public float getB() {
        return this.B_;
    }

    public float getC() {
        return this.C_;
    }

    public int getFilter() {
        return this.filter_;
    }

    public int getMipmap() {
        return this.mipmap_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasB() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasC() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasFilter() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMipmap() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }
}
