package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.e;
import com.microsoft.clarity.j.f;
import com.microsoft.clarity.j.m;
import com.microsoft.clarity.j.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Vertices extends GeneratedMessageLite<MutationPayload$Vertices, a> implements q {
    public static final int BONE_INDICES_FIELD_NUMBER = 6;
    public static final int BONE_WEIGHTS_FIELD_NUMBER = 7;
    public static final int COLORS_FIELD_NUMBER = 5;
    private static final MutationPayload$Vertices DEFAULT_INSTANCE;
    public static final int INDICES_FIELD_NUMBER = 8;
    public static final int IS_VOLATILE_FIELD_NUMBER = 2;
    public static final int MODE_FIELD_NUMBER = 1;
    private static volatile Parser<MutationPayload$Vertices> PARSER = null;
    public static final int POSITIONS_FIELD_NUMBER = 3;
    public static final int TEX_COORDS_FIELD_NUMBER = 4;
    private int bitField0_;
    private boolean isVolatile_;
    private double mode_;
    private int colorsMemoizedSerializedSize = -1;
    private int indicesMemoizedSerializedSize = -1;
    private Internal.ProtobufList<MutationPayload$Point> positions_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Point> texCoords_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.DoubleList colors_ = GeneratedMessageLite.emptyDoubleList();
    private Internal.ProtobufList<MutationPayload$DoubleList> boneIndices_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$FloatList> boneWeights_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.DoubleList indices_ = GeneratedMessageLite.emptyDoubleList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Vertices, a> implements q {
        public a() {
            super(MutationPayload$Vertices.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).setMode(d2);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).addAllPositions(list);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).setIsVolatile(z);
            return this;
        }

        public final void a(MutationPayload$DoubleList mutationPayload$DoubleList) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).addBoneIndices(mutationPayload$DoubleList);
        }

        public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).addBoneWeights(mutationPayload$FloatList);
        }

        public final void a(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).addAllColors(arrayList);
        }

        public final a b(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).addAllIndices(arrayList);
            return this;
        }

        public final void b(List list) {
            copyOnWrite();
            ((MutationPayload$Vertices) this.instance).addAllTexCoords(list);
        }
    }

    static {
        MutationPayload$Vertices mutationPayload$Vertices = new MutationPayload$Vertices();
        DEFAULT_INSTANCE = mutationPayload$Vertices;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Vertices.class, mutationPayload$Vertices);
    }

    private MutationPayload$Vertices() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBoneIndices(Iterable<? extends MutationPayload$DoubleList> iterable) {
        ensureBoneIndicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.boneIndices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBoneWeights(Iterable<? extends MutationPayload$FloatList> iterable) {
        ensureBoneWeightsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.boneWeights_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllColors(Iterable<? extends Double> iterable) {
        ensureColorsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.colors_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIndices(Iterable<? extends Double> iterable) {
        ensureIndicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.indices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPositions(Iterable<? extends MutationPayload$Point> iterable) {
        ensurePositionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.positions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTexCoords(Iterable<? extends MutationPayload$Point> iterable) {
        ensureTexCoordsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.texCoords_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBoneIndices(int i, MutationPayload$DoubleList mutationPayload$DoubleList) {
        mutationPayload$DoubleList.getClass();
        ensureBoneIndicesIsMutable();
        this.boneIndices_.add(i, mutationPayload$DoubleList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBoneIndices(MutationPayload$DoubleList mutationPayload$DoubleList) {
        mutationPayload$DoubleList.getClass();
        ensureBoneIndicesIsMutable();
        this.boneIndices_.add(mutationPayload$DoubleList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBoneWeights(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBoneWeightsIsMutable();
        this.boneWeights_.add(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBoneWeights(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBoneWeightsIsMutable();
        this.boneWeights_.add(mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addColors(double d2) {
        ensureColorsIsMutable();
        this.colors_.addDouble(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIndices(double d2) {
        ensureIndicesIsMutable();
        this.indices_.addDouble(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPositions(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePositionsIsMutable();
        this.positions_.add(i, mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPositions(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePositionsIsMutable();
        this.positions_.add(mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTexCoords(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensureTexCoordsIsMutable();
        this.texCoords_.add(i, mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTexCoords(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensureTexCoordsIsMutable();
        this.texCoords_.add(mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBoneIndices() {
        this.boneIndices_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBoneWeights() {
        this.boneWeights_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearColors() {
        this.colors_ = GeneratedMessageLite.emptyDoubleList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIndices() {
        this.indices_ = GeneratedMessageLite.emptyDoubleList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsVolatile() {
        this.bitField0_ &= -3;
        this.isVolatile_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMode() {
        this.bitField0_ &= -2;
        this.mode_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPositions() {
        this.positions_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTexCoords() {
        this.texCoords_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBoneIndicesIsMutable() {
        Internal.ProtobufList<MutationPayload$DoubleList> protobufList = this.boneIndices_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.boneIndices_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureBoneWeightsIsMutable() {
        Internal.ProtobufList<MutationPayload$FloatList> protobufList = this.boneWeights_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.boneWeights_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureColorsIsMutable() {
        Internal.DoubleList doubleList = this.colors_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.colors_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    private void ensureIndicesIsMutable() {
        Internal.DoubleList doubleList = this.indices_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.indices_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    private void ensurePositionsIsMutable() {
        Internal.ProtobufList<MutationPayload$Point> protobufList = this.positions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.positions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureTexCoordsIsMutable() {
        Internal.ProtobufList<MutationPayload$Point> protobufList = this.texCoords_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.texCoords_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Vertices getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Vertices mutationPayload$Vertices) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Vertices);
    }

    public static MutationPayload$Vertices parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Vertices parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(ByteString byteString) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Vertices parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Vertices parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(InputStream inputStream) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Vertices parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Vertices parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(byte[] bArr) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Vertices parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Vertices> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeBoneIndices(int i) {
        ensureBoneIndicesIsMutable();
        this.boneIndices_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeBoneWeights(int i) {
        ensureBoneWeightsIsMutable();
        this.boneWeights_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePositions(int i) {
        ensurePositionsIsMutable();
        this.positions_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTexCoords(int i) {
        ensureTexCoordsIsMutable();
        this.texCoords_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBoneIndices(int i, MutationPayload$DoubleList mutationPayload$DoubleList) {
        mutationPayload$DoubleList.getClass();
        ensureBoneIndicesIsMutable();
        this.boneIndices_.set(i, mutationPayload$DoubleList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBoneWeights(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBoneWeightsIsMutable();
        this.boneWeights_.set(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColors(int i, double d2) {
        ensureColorsIsMutable();
        this.colors_.setDouble(i, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndices(int i, double d2) {
        ensureIndicesIsMutable();
        this.indices_.setDouble(i, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsVolatile(boolean z) {
        this.bitField0_ |= 2;
        this.isVolatile_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(double d2) {
        this.bitField0_ |= 1;
        this.mode_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPositions(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePositionsIsMutable();
        this.positions_.set(i, mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTexCoords(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensureTexCoordsIsMutable();
        this.texCoords_.set(i, mutationPayload$Point);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Vertices();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0006\u0000\u0001က\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005#\u0006\u001b\u0007\u001b\b#", new Object[]{"bitField0_", "mode_", "isVolatile_", "positions_", MutationPayload$Point.class, "texCoords_", MutationPayload$Point.class, "colors_", "boneIndices_", MutationPayload$DoubleList.class, "boneWeights_", MutationPayload$FloatList.class, "indices_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Vertices> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Vertices.class) {
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

    public MutationPayload$DoubleList getBoneIndices(int i) {
        return this.boneIndices_.get(i);
    }

    public int getBoneIndicesCount() {
        return this.boneIndices_.size();
    }

    public List<MutationPayload$DoubleList> getBoneIndicesList() {
        return this.boneIndices_;
    }

    public e getBoneIndicesOrBuilder(int i) {
        return this.boneIndices_.get(i);
    }

    public List<? extends e> getBoneIndicesOrBuilderList() {
        return this.boneIndices_;
    }

    public MutationPayload$FloatList getBoneWeights(int i) {
        return this.boneWeights_.get(i);
    }

    public int getBoneWeightsCount() {
        return this.boneWeights_.size();
    }

    public List<MutationPayload$FloatList> getBoneWeightsList() {
        return this.boneWeights_;
    }

    public f getBoneWeightsOrBuilder(int i) {
        return this.boneWeights_.get(i);
    }

    public List<? extends f> getBoneWeightsOrBuilderList() {
        return this.boneWeights_;
    }

    public double getColors(int i) {
        return this.colors_.getDouble(i);
    }

    public int getColorsCount() {
        return this.colors_.size();
    }

    public List<Double> getColorsList() {
        return this.colors_;
    }

    public double getIndices(int i) {
        return this.indices_.getDouble(i);
    }

    public int getIndicesCount() {
        return this.indices_.size();
    }

    public List<Double> getIndicesList() {
        return this.indices_;
    }

    public boolean getIsVolatile() {
        return this.isVolatile_;
    }

    public double getMode() {
        return this.mode_;
    }

    public MutationPayload$Point getPositions(int i) {
        return this.positions_.get(i);
    }

    public int getPositionsCount() {
        return this.positions_.size();
    }

    public List<MutationPayload$Point> getPositionsList() {
        return this.positions_;
    }

    public m getPositionsOrBuilder(int i) {
        return this.positions_.get(i);
    }

    public List<? extends m> getPositionsOrBuilderList() {
        return this.positions_;
    }

    public MutationPayload$Point getTexCoords(int i) {
        return this.texCoords_.get(i);
    }

    public int getTexCoordsCount() {
        return this.texCoords_.size();
    }

    public List<MutationPayload$Point> getTexCoordsList() {
        return this.texCoords_;
    }

    public m getTexCoordsOrBuilder(int i) {
        return this.texCoords_.get(i);
    }

    public List<? extends m> getTexCoordsOrBuilderList() {
        return this.texCoords_;
    }

    public boolean hasIsVolatile() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMode() {
        return (this.bitField0_ & 1) != 0;
    }
}
