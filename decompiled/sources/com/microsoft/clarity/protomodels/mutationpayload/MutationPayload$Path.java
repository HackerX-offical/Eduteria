package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.k;
import com.microsoft.clarity.j.l;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Path extends GeneratedMessageLite<MutationPayload$Path, a> implements k {
    private static final MutationPayload$Path DEFAULT_INSTANCE;
    public static final int FILL_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<MutationPayload$Path> PARSER = null;
    public static final int VERBS_FIELD_NUMBER = 2;
    private int bitField0_;
    private int fillType_;
    private Internal.ProtobufList<MutationPayload$PathVerb> verbs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Path, a> implements k {
        public a() {
            super(MutationPayload$Path.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(int i) {
            copyOnWrite();
            ((MutationPayload$Path) this.instance).setFillType(i);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$Path) this.instance).addAllVerbs(list);
            return this;
        }
    }

    static {
        MutationPayload$Path mutationPayload$Path = new MutationPayload$Path();
        DEFAULT_INSTANCE = mutationPayload$Path;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Path.class, mutationPayload$Path);
    }

    private MutationPayload$Path() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVerbs(Iterable<? extends MutationPayload$PathVerb> iterable) {
        ensureVerbsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.verbs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVerbs(int i, MutationPayload$PathVerb mutationPayload$PathVerb) {
        mutationPayload$PathVerb.getClass();
        ensureVerbsIsMutable();
        this.verbs_.add(i, mutationPayload$PathVerb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVerbs(MutationPayload$PathVerb mutationPayload$PathVerb) {
        mutationPayload$PathVerb.getClass();
        ensureVerbsIsMutable();
        this.verbs_.add(mutationPayload$PathVerb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFillType() {
        this.bitField0_ &= -2;
        this.fillType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVerbs() {
        this.verbs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureVerbsIsMutable() {
        Internal.ProtobufList<MutationPayload$PathVerb> protobufList = this.verbs_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.verbs_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Path getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Path mutationPayload$Path) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Path);
    }

    public static MutationPayload$Path parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Path) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Path parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Path) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Path parseFrom(ByteString byteString) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Path parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Path parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Path parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Path parseFrom(InputStream inputStream) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Path parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Path parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Path parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Path parseFrom(byte[] bArr) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Path parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Path) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Path> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeVerbs(int i) {
        ensureVerbsIsMutable();
        this.verbs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFillType(int i) {
        this.bitField0_ |= 1;
        this.fillType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVerbs(int i, MutationPayload$PathVerb mutationPayload$PathVerb) {
        mutationPayload$PathVerb.getClass();
        ensureVerbsIsMutable();
        this.verbs_.set(i, mutationPayload$PathVerb);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Path();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u001b", new Object[]{"bitField0_", "fillType_", "verbs_", MutationPayload$PathVerb.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Path> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Path.class) {
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

    public int getFillType() {
        return this.fillType_;
    }

    public MutationPayload$PathVerb getVerbs(int i) {
        return this.verbs_.get(i);
    }

    public int getVerbsCount() {
        return this.verbs_.size();
    }

    public List<MutationPayload$PathVerb> getVerbsList() {
        return this.verbs_;
    }

    public l getVerbsOrBuilder(int i) {
        return this.verbs_.get(i);
    }

    public List<? extends l> getVerbsOrBuilderList() {
        return this.verbs_;
    }

    public boolean hasFillType() {
        return (this.bitField0_ & 1) != 0;
    }
}
