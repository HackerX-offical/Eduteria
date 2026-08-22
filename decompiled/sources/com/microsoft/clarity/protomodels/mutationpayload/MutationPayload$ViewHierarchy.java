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
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$ViewHierarchy extends GeneratedMessageLite<MutationPayload$ViewHierarchy, a> implements MessageLiteOrBuilder {
    private static final MutationPayload$ViewHierarchy DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$ViewHierarchy> PARSER = null;
    public static final int ROOT_FIELD_NUMBER = 2;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    public static final int VISIBLE_FRAGMENTS_FIELD_NUMBER = 3;
    private int bitField0_;
    private MutationPayload$ViewNode root_;
    private double timestamp_;
    private Internal.ProtobufList<String> visibleFragments_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$ViewHierarchy, a> implements MessageLiteOrBuilder {
        public a() {
            super(MutationPayload$ViewHierarchy.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$ViewHierarchy) this.instance).setTimestamp(d2);
            return this;
        }

        public final a a(MutationPayload$ViewNode mutationPayload$ViewNode) {
            copyOnWrite();
            ((MutationPayload$ViewHierarchy) this.instance).setRoot(mutationPayload$ViewNode);
            return this;
        }

        public final a a(Set set) {
            copyOnWrite();
            ((MutationPayload$ViewHierarchy) this.instance).addAllVisibleFragments(set);
            return this;
        }
    }

    static {
        MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy = new MutationPayload$ViewHierarchy();
        DEFAULT_INSTANCE = mutationPayload$ViewHierarchy;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$ViewHierarchy.class, mutationPayload$ViewHierarchy);
    }

    private MutationPayload$ViewHierarchy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVisibleFragments(Iterable<String> iterable) {
        ensureVisibleFragmentsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.visibleFragments_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVisibleFragments(String str) {
        str.getClass();
        ensureVisibleFragmentsIsMutable();
        this.visibleFragments_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVisibleFragmentsBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        ensureVisibleFragmentsIsMutable();
        this.visibleFragments_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoot() {
        this.root_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.bitField0_ &= -2;
        this.timestamp_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVisibleFragments() {
        this.visibleFragments_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureVisibleFragmentsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.visibleFragments_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.visibleFragments_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$ViewHierarchy getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoot(MutationPayload$ViewNode mutationPayload$ViewNode) {
        mutationPayload$ViewNode.getClass();
        MutationPayload$ViewNode mutationPayload$ViewNode2 = this.root_;
        if (mutationPayload$ViewNode2 != null && mutationPayload$ViewNode2 != MutationPayload$ViewNode.getDefaultInstance()) {
            mutationPayload$ViewNode = MutationPayload$ViewNode.newBuilder(this.root_).mergeFrom(mutationPayload$ViewNode).buildPartial();
        }
        this.root_ = mutationPayload$ViewNode;
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$ViewHierarchy);
    }

    public static MutationPayload$ViewHierarchy parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ViewHierarchy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteString byteString) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$ViewHierarchy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(InputStream inputStream) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ViewHierarchy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(byte[] bArr) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$ViewHierarchy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$ViewHierarchy> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoot(MutationPayload$ViewNode mutationPayload$ViewNode) {
        mutationPayload$ViewNode.getClass();
        this.root_ = mutationPayload$ViewNode;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(double d2) {
        this.bitField0_ |= 1;
        this.timestamp_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibleFragments(int i, String str) {
        str.getClass();
        ensureVisibleFragmentsIsMutable();
        this.visibleFragments_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$ViewHierarchy();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001က\u0000\u0002ဉ\u0001\u0003Ț", new Object[]{"bitField0_", "timestamp_", "root_", "visibleFragments_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$ViewHierarchy> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$ViewHierarchy.class) {
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

    public MutationPayload$ViewNode getRoot() {
        MutationPayload$ViewNode mutationPayload$ViewNode = this.root_;
        return mutationPayload$ViewNode == null ? MutationPayload$ViewNode.getDefaultInstance() : mutationPayload$ViewNode;
    }

    public double getTimestamp() {
        return this.timestamp_;
    }

    public String getVisibleFragments(int i) {
        return this.visibleFragments_.get(i);
    }

    public ByteString getVisibleFragmentsBytes(int i) {
        return ByteString.copyFromUtf8(this.visibleFragments_.get(i));
    }

    public int getVisibleFragmentsCount() {
        return this.visibleFragments_.size();
    }

    public List<String> getVisibleFragmentsList() {
        return this.visibleFragments_;
    }

    public boolean hasRoot() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }
}
