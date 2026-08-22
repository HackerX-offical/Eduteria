package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.i;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Looper extends GeneratedMessageLite<MutationPayload$Looper, a> implements MessageLiteOrBuilder {
    private static final MutationPayload$Looper DEFAULT_INSTANCE;
    public static final int LAYERS_FIELD_NUMBER = 2;
    private static volatile Parser<MutationPayload$Looper> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String type_ = "";
    private Internal.ProtobufList<MutationPayload$Layer> layers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Looper, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$Looper.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$Looper) this.instance).setType(str);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$Looper) this.instance).addAllLayers(list);
            return this;
        }
    }

    static {
        MutationPayload$Looper mutationPayload$Looper = new MutationPayload$Looper();
        DEFAULT_INSTANCE = mutationPayload$Looper;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Looper.class, mutationPayload$Looper);
    }

    private MutationPayload$Looper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLayers(Iterable<? extends MutationPayload$Layer> iterable) {
        ensureLayersIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.layers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(int i, MutationPayload$Layer mutationPayload$Layer) {
        mutationPayload$Layer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(i, mutationPayload$Layer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(MutationPayload$Layer mutationPayload$Layer) {
        mutationPayload$Layer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(mutationPayload$Layer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayers() {
        this.layers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    private void ensureLayersIsMutable() {
        Internal.ProtobufList<MutationPayload$Layer> protobufList = this.layers_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.layers_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Looper getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Looper mutationPayload$Looper) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Looper);
    }

    public static MutationPayload$Looper parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Looper parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(ByteString byteString) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Looper parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Looper parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(InputStream inputStream) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Looper parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Looper parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(byte[] bArr) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Looper parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Looper> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLayers(int i) {
        ensureLayersIsMutable();
        this.layers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayers(int i, MutationPayload$Layer mutationPayload$Layer) {
        mutationPayload$Layer.getClass();
        ensureLayersIsMutable();
        this.layers_.set(i, mutationPayload$Layer);
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
                return new MutationPayload$Looper();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ለ\u0000\u0002\u001b", new Object[]{"bitField0_", "type_", "layers_", MutationPayload$Layer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Looper> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Looper.class) {
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

    public MutationPayload$Layer getLayers(int i) {
        return this.layers_.get(i);
    }

    public int getLayersCount() {
        return this.layers_.size();
    }

    public List<MutationPayload$Layer> getLayersList() {
        return this.layers_;
    }

    public i getLayersOrBuilder(int i) {
        return this.layers_.get(i);
    }

    public List<? extends i> getLayersOrBuilderList() {
        return this.layers_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }
}
