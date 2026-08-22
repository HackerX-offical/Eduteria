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
public final class MutationPayload$ColorFilter extends GeneratedMessageLite<MutationPayload$ColorFilter, a> implements MessageLiteOrBuilder {
    public static final int COLOR_FIELD_NUMBER = 2;
    private static final MutationPayload$ColorFilter DEFAULT_INSTANCE;
    public static final int MODE_FIELD_NUMBER = 3;
    private static volatile Parser<MutationPayload$ColorFilter> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private double color_;
    private double mode_;
    private String type_ = "";

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$ColorFilter, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$ColorFilter.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$ColorFilter) this.instance).setColor(d2);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$ColorFilter) this.instance).setType(str);
            return this;
        }

        public final a b(double d2) {
            copyOnWrite();
            ((MutationPayload$ColorFilter) this.instance).setMode(d2);
            return this;
        }
    }

    static {
        MutationPayload$ColorFilter mutationPayload$ColorFilter = new MutationPayload$ColorFilter();
        DEFAULT_INSTANCE = mutationPayload$ColorFilter;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$ColorFilter.class, mutationPayload$ColorFilter);
    }

    private MutationPayload$ColorFilter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearColor() {
        this.bitField0_ &= -3;
        this.color_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMode() {
        this.bitField0_ &= -5;
        this.mode_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    public static MutationPayload$ColorFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$ColorFilter mutationPayload$ColorFilter) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$ColorFilter);
    }

    public static MutationPayload$ColorFilter parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ColorFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(ByteString byteString) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$ColorFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$ColorFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(InputStream inputStream) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ColorFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$ColorFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(byte[] bArr) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$ColorFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$ColorFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor(double d2) {
        this.bitField0_ |= 2;
        this.color_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(double d2) {
        this.bitField0_ |= 4;
        this.mode_ = d2;
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
                return new MutationPayload$ColorFilter();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ለ\u0000\u0002က\u0001\u0003က\u0002", new Object[]{"bitField0_", "type_", "color_", "mode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$ColorFilter> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$ColorFilter.class) {
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

    public double getColor() {
        return this.color_;
    }

    public double getMode() {
        return this.mode_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasColor() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMode() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }
}
