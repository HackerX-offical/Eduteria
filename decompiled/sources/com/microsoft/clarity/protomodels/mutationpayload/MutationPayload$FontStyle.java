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
public final class MutationPayload$FontStyle extends GeneratedMessageLite<MutationPayload$FontStyle, a> implements MessageLiteOrBuilder {
    private static final MutationPayload$FontStyle DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$FontStyle> PARSER = null;
    public static final int SLANT_FIELD_NUMBER = 3;
    public static final int WEIGHT_FIELD_NUMBER = 2;
    public static final int WIDTH_FIELD_NUMBER = 1;
    private int bitField0_;
    private double slant_;
    private double weight_;
    private double width_;

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$FontStyle, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$FontStyle.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$FontStyle) this.instance).setSlant(d2);
            return this;
        }

        public final a b(double d2) {
            copyOnWrite();
            ((MutationPayload$FontStyle) this.instance).setWeight(d2);
            return this;
        }

        public final a c(double d2) {
            copyOnWrite();
            ((MutationPayload$FontStyle) this.instance).setWidth(d2);
            return this;
        }
    }

    static {
        MutationPayload$FontStyle mutationPayload$FontStyle = new MutationPayload$FontStyle();
        DEFAULT_INSTANCE = mutationPayload$FontStyle;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$FontStyle.class, mutationPayload$FontStyle);
    }

    private MutationPayload$FontStyle() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSlant() {
        this.bitField0_ &= -5;
        this.slant_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWeight() {
        this.bitField0_ &= -3;
        this.weight_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.bitField0_ &= -2;
        this.width_ = 0.0d;
    }

    public static MutationPayload$FontStyle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$FontStyle mutationPayload$FontStyle) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$FontStyle);
    }

    public static MutationPayload$FontStyle parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FontStyle parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(ByteString byteString) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$FontStyle parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$FontStyle parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(InputStream inputStream) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FontStyle parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$FontStyle parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(byte[] bArr) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$FontStyle parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$FontStyle> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSlant(double d2) {
        this.bitField0_ |= 4;
        this.slant_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeight(double d2) {
        this.bitField0_ |= 2;
        this.weight_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(double d2) {
        this.bitField0_ |= 1;
        this.width_ = d2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$FontStyle();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003က\u0002", new Object[]{"bitField0_", "width_", "weight_", "slant_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$FontStyle> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$FontStyle.class) {
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

    public double getSlant() {
        return this.slant_;
    }

    public double getWeight() {
        return this.weight_;
    }

    public double getWidth() {
        return this.width_;
    }

    public boolean hasSlant() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasWeight() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasWidth() {
        return (this.bitField0_ & 1) != 0;
    }
}
