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
public final class MutationPayload$PathEffect extends GeneratedMessageLite<MutationPayload$PathEffect, a> implements MessageLiteOrBuilder {
    private static final MutationPayload$PathEffect DEFAULT_INSTANCE;
    public static final int INTERVALS_FIELD_NUMBER = 3;
    private static volatile Parser<MutationPayload$PathEffect> PARSER = null;
    public static final int PHASE_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private float phase_;
    private int intervalsMemoizedSerializedSize = -1;
    private String type_ = "";
    private Internal.FloatList intervals_ = GeneratedMessageLite.emptyFloatList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$PathEffect, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$PathEffect.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$PathEffect) this.instance).setPhase(f2);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$PathEffect) this.instance).setType(str);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$PathEffect) this.instance).addAllIntervals(list);
            return this;
        }
    }

    static {
        MutationPayload$PathEffect mutationPayload$PathEffect = new MutationPayload$PathEffect();
        DEFAULT_INSTANCE = mutationPayload$PathEffect;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$PathEffect.class, mutationPayload$PathEffect);
    }

    private MutationPayload$PathEffect() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIntervals(Iterable<? extends Float> iterable) {
        ensureIntervalsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.intervals_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIntervals(float f2) {
        ensureIntervalsIsMutable();
        this.intervals_.addFloat(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIntervals() {
        this.intervals_ = GeneratedMessageLite.emptyFloatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhase() {
        this.bitField0_ &= -3;
        this.phase_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    private void ensureIntervalsIsMutable() {
        Internal.FloatList floatList = this.intervals_;
        if (floatList.isModifiable()) {
            return;
        }
        this.intervals_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    public static MutationPayload$PathEffect getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$PathEffect mutationPayload$PathEffect) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$PathEffect);
    }

    public static MutationPayload$PathEffect parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathEffect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(ByteString byteString) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$PathEffect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$PathEffect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(InputStream inputStream) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathEffect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$PathEffect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(byte[] bArr) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$PathEffect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$PathEffect> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIntervals(int i, float f2) {
        ensureIntervalsIsMutable();
        this.intervals_.setFloat(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhase(float f2) {
        this.bitField0_ |= 2;
        this.phase_ = f2;
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
                return new MutationPayload$PathEffect();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ለ\u0000\u0002ခ\u0001\u0003$", new Object[]{"bitField0_", "type_", "phase_", "intervals_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$PathEffect> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$PathEffect.class) {
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

    public float getIntervals(int i) {
        return this.intervals_.getFloat(i);
    }

    public int getIntervalsCount() {
        return this.intervals_.size();
    }

    public List<Float> getIntervalsList() {
        return this.intervals_;
    }

    public float getPhase() {
        return this.phase_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasPhase() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }
}
