package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$FloatList extends GeneratedMessageLite<MutationPayload$FloatList, a> implements f {
    private static final MutationPayload$FloatList DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$FloatList> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int valueMemoizedSerializedSize = -1;
    private Internal.FloatList value_ = GeneratedMessageLite.emptyFloatList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$FloatList, a> implements f {
        public a() {
            super(MutationPayload$FloatList.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$FloatList) this.instance).addAllValue(list);
            return this;
        }
    }

    static {
        MutationPayload$FloatList mutationPayload$FloatList = new MutationPayload$FloatList();
        DEFAULT_INSTANCE = mutationPayload$FloatList;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$FloatList.class, mutationPayload$FloatList);
    }

    private MutationPayload$FloatList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValue(Iterable<? extends Float> iterable) {
        ensureValueIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.value_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValue(float f2) {
        ensureValueIsMutable();
        this.value_.addFloat(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = GeneratedMessageLite.emptyFloatList();
    }

    private void ensureValueIsMutable() {
        Internal.FloatList floatList = this.value_;
        if (floatList.isModifiable()) {
            return;
        }
        this.value_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    public static MutationPayload$FloatList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$FloatList mutationPayload$FloatList) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$FloatList);
    }

    public static MutationPayload$FloatList parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FloatList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(ByteString byteString) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$FloatList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$FloatList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(InputStream inputStream) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FloatList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$FloatList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(byte[] bArr) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$FloatList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$FloatList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, float f2) {
        ensureValueIsMutable();
        this.value_.setFloat(i, f2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$FloatList();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001$", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$FloatList> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$FloatList.class) {
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

    public float getValue(int i) {
        return this.value_.getFloat(i);
    }

    public int getValueCount() {
        return this.value_.size();
    }

    public List<Float> getValueList() {
        return this.value_;
    }
}
