package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.h;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Image extends GeneratedMessageLite<MutationPayload$Image, a> implements h {
    public static final int DATA_HASH_FIELD_NUMBER = 2;
    private static final MutationPayload$Image DEFAULT_INSTANCE;
    public static final int MIPMAP_FIELD_NUMBER = 3;
    private static volatile Parser<MutationPayload$Image> PARSER = null;
    public static final int SUBSET_FIELD_NUMBER = 1;
    private int bitField0_;
    private String dataHash_ = "";
    private ByteString mipmap_ = ByteString.EMPTY;
    private MutationPayload$Rect subset_;

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Image, a> implements h {
        public a() {
            super(MutationPayload$Image.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final void a(ByteString byteString) {
            copyOnWrite();
            ((MutationPayload$Image) this.instance).setMipmap(byteString);
        }

        public final void a(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$Image) this.instance).setSubset(mutationPayload$Rect);
        }

        public final void a(String str) {
            copyOnWrite();
            ((MutationPayload$Image) this.instance).setDataHash(str);
        }
    }

    static {
        MutationPayload$Image mutationPayload$Image = new MutationPayload$Image();
        DEFAULT_INSTANCE = mutationPayload$Image;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Image.class, mutationPayload$Image);
    }

    private MutationPayload$Image() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDataHash() {
        this.bitField0_ &= -3;
        this.dataHash_ = getDefaultInstance().getDataHash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMipmap() {
        this.mipmap_ = getDefaultInstance().getMipmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubset() {
        this.subset_ = null;
        this.bitField0_ &= -2;
    }

    public static MutationPayload$Image getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubset(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.subset_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.subset_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.subset_ = mutationPayload$Rect;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Image mutationPayload$Image) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Image);
    }

    public static MutationPayload$Image parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Image) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Image parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Image) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Image parseFrom(ByteString byteString) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Image parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Image parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Image parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Image parseFrom(InputStream inputStream) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Image parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Image parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Image parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Image parseFrom(byte[] bArr) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Image parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Image> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataHash(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.dataHash_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataHashBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.dataHash_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMipmap(ByteString byteString) {
        byteString.getClass();
        this.mipmap_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubset(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.subset_ = mutationPayload$Rect;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Image();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ለ\u0001\u0003\n", new Object[]{"bitField0_", "subset_", "dataHash_", "mipmap_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Image> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Image.class) {
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

    public String getDataHash() {
        return this.dataHash_;
    }

    public ByteString getDataHashBytes() {
        return ByteString.copyFromUtf8(this.dataHash_);
    }

    public ByteString getMipmap() {
        return this.mipmap_;
    }

    public MutationPayload$Rect getSubset() {
        MutationPayload$Rect mutationPayload$Rect = this.subset_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public boolean hasDataHash() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSubset() {
        return (this.bitField0_ & 1) != 0;
    }
}
