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
public final class MutationPayload$MaskFilter extends GeneratedMessageLite<MutationPayload$MaskFilter, a> implements MessageLiteOrBuilder {
    private static final MutationPayload$MaskFilter DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$MaskFilter> PARSER = null;
    public static final int RESPECT_C_T_M_FIELD_NUMBER = 4;
    public static final int SIGMA_FIELD_NUMBER = 2;
    public static final int STYLE_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean respectCTM_;
    private float sigma_;
    private int style_;
    private String type_ = "";

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$MaskFilter, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$MaskFilter.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$MaskFilter) this.instance).setSigma(f2);
            return this;
        }

        public final a a(int i) {
            copyOnWrite();
            ((MutationPayload$MaskFilter) this.instance).setStyle(i);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$MaskFilter) this.instance).setType(str);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$MaskFilter) this.instance).setRespectCTM(z);
            return this;
        }
    }

    static {
        MutationPayload$MaskFilter mutationPayload$MaskFilter = new MutationPayload$MaskFilter();
        DEFAULT_INSTANCE = mutationPayload$MaskFilter;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$MaskFilter.class, mutationPayload$MaskFilter);
    }

    private MutationPayload$MaskFilter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRespectCTM() {
        this.bitField0_ &= -9;
        this.respectCTM_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSigma() {
        this.bitField0_ &= -3;
        this.sigma_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStyle() {
        this.bitField0_ &= -5;
        this.style_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    public static MutationPayload$MaskFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$MaskFilter mutationPayload$MaskFilter) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$MaskFilter);
    }

    public static MutationPayload$MaskFilter parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$MaskFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(ByteString byteString) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$MaskFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$MaskFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(InputStream inputStream) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$MaskFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$MaskFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(byte[] bArr) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$MaskFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$MaskFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRespectCTM(boolean z) {
        this.bitField0_ |= 8;
        this.respectCTM_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSigma(float f2) {
        this.bitField0_ |= 2;
        this.sigma_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyle(int i) {
        this.bitField0_ |= 4;
        this.style_ = i;
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
                return new MutationPayload$MaskFilter();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ለ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဇ\u0003", new Object[]{"bitField0_", "type_", "sigma_", "style_", "respectCTM_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$MaskFilter> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$MaskFilter.class) {
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

    public boolean getRespectCTM() {
        return this.respectCTM_;
    }

    public float getSigma() {
        return this.sigma_;
    }

    public int getStyle() {
        return this.style_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasRespectCTM() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSigma() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStyle() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }
}
