package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.g;
import com.microsoft.clarity.j.p;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Typeface extends GeneratedMessageLite<MutationPayload$Typeface, a> implements p {
    public static final int COLLECTION_INDEX_FIELD_NUMBER = 5;
    public static final int COORDINATES_FIELD_NUMBER = 6;
    public static final int DATA_HASH_FIELD_NUMBER = 7;
    private static final MutationPayload$Typeface DEFAULT_INSTANCE;
    public static final int FAMILY_NAME_FIELD_NUMBER = 1;
    public static final int FULL_NAME_FIELD_NUMBER = 2;
    public static final int ITALIC_VALUE_FIELD_NUMBER = 11;
    public static final int PALLETE_INDEX_FIELD_NUMBER = 12;
    private static volatile Parser<MutationPayload$Typeface> PARSER = null;
    public static final int POSTSCRIPT_NAME_FIELD_NUMBER = 3;
    public static final int SLANT_VALUE_FIELD_NUMBER = 10;
    public static final int STYLE_FIELD_NUMBER = 4;
    public static final int WEIGHT_VALUE_FIELD_NUMBER = 8;
    public static final int WIDTH_VALUE_FIELD_NUMBER = 9;
    private int bitField0_;
    private double collectionIndex_;
    private float italicValue_;
    private double palleteIndex_;
    private float slantValue_;
    private MutationPayload$FontStyle style_;
    private float weightValue_;
    private float widthValue_;
    private String familyName_ = "";
    private String fullName_ = "";
    private String postscriptName_ = "";
    private Internal.ProtobufList<MutationPayload$FontCoordinate> coordinates_ = GeneratedMessageLite.emptyProtobufList();
    private String dataHash_ = "";

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Typeface, a> implements p {
        public a() {
            super(MutationPayload$Typeface.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(MutationPayload$FontStyle mutationPayload$FontStyle) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setStyle(mutationPayload$FontStyle);
            return this;
        }

        public final void a(double d2) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setCollectionIndex(d2);
        }

        public final void a(float f2) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setItalicValue(f2);
        }

        public final void a(String str) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setDataHash(str);
        }

        public final void a(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).addAllCoordinates(arrayList);
        }

        public final a b(String str) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setFamilyName(str);
            return this;
        }

        public final void b(double d2) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setPalleteIndex(d2);
        }

        public final void b(float f2) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setSlantValue(f2);
        }

        public final void c(float f2) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setWeightValue(f2);
        }

        public final void c(String str) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setFullName(str);
        }

        public final void d(float f2) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setWidthValue(f2);
        }

        public final void d(String str) {
            copyOnWrite();
            ((MutationPayload$Typeface) this.instance).setPostscriptName(str);
        }
    }

    static {
        MutationPayload$Typeface mutationPayload$Typeface = new MutationPayload$Typeface();
        DEFAULT_INSTANCE = mutationPayload$Typeface;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Typeface.class, mutationPayload$Typeface);
    }

    private MutationPayload$Typeface() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCoordinates(Iterable<? extends MutationPayload$FontCoordinate> iterable) {
        ensureCoordinatesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.coordinates_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCoordinates(int i, MutationPayload$FontCoordinate mutationPayload$FontCoordinate) {
        mutationPayload$FontCoordinate.getClass();
        ensureCoordinatesIsMutable();
        this.coordinates_.add(i, mutationPayload$FontCoordinate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCoordinates(MutationPayload$FontCoordinate mutationPayload$FontCoordinate) {
        mutationPayload$FontCoordinate.getClass();
        ensureCoordinatesIsMutable();
        this.coordinates_.add(mutationPayload$FontCoordinate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCollectionIndex() {
        this.bitField0_ &= -17;
        this.collectionIndex_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCoordinates() {
        this.coordinates_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDataHash() {
        this.bitField0_ &= -33;
        this.dataHash_ = getDefaultInstance().getDataHash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFamilyName() {
        this.bitField0_ &= -2;
        this.familyName_ = getDefaultInstance().getFamilyName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFullName() {
        this.bitField0_ &= -3;
        this.fullName_ = getDefaultInstance().getFullName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItalicValue() {
        this.bitField0_ &= -513;
        this.italicValue_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPalleteIndex() {
        this.bitField0_ &= -1025;
        this.palleteIndex_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPostscriptName() {
        this.bitField0_ &= -5;
        this.postscriptName_ = getDefaultInstance().getPostscriptName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSlantValue() {
        this.bitField0_ &= -257;
        this.slantValue_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStyle() {
        this.style_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWeightValue() {
        this.bitField0_ &= -65;
        this.weightValue_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidthValue() {
        this.bitField0_ &= -129;
        this.widthValue_ = 0.0f;
    }

    private void ensureCoordinatesIsMutable() {
        Internal.ProtobufList<MutationPayload$FontCoordinate> protobufList = this.coordinates_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.coordinates_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Typeface getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStyle(MutationPayload$FontStyle mutationPayload$FontStyle) {
        mutationPayload$FontStyle.getClass();
        MutationPayload$FontStyle mutationPayload$FontStyle2 = this.style_;
        if (mutationPayload$FontStyle2 != null && mutationPayload$FontStyle2 != MutationPayload$FontStyle.getDefaultInstance()) {
            mutationPayload$FontStyle = MutationPayload$FontStyle.newBuilder(this.style_).mergeFrom(mutationPayload$FontStyle).buildPartial();
        }
        this.style_ = mutationPayload$FontStyle;
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Typeface mutationPayload$Typeface) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Typeface);
    }

    public static MutationPayload$Typeface parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Typeface parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Typeface parseFrom(ByteString byteString) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Typeface parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Typeface parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Typeface parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Typeface parseFrom(InputStream inputStream) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Typeface parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Typeface parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Typeface parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Typeface parseFrom(byte[] bArr) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Typeface parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Typeface) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Typeface> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCoordinates(int i) {
        ensureCoordinatesIsMutable();
        this.coordinates_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCollectionIndex(double d2) {
        this.bitField0_ |= 16;
        this.collectionIndex_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCoordinates(int i, MutationPayload$FontCoordinate mutationPayload$FontCoordinate) {
        mutationPayload$FontCoordinate.getClass();
        ensureCoordinatesIsMutable();
        this.coordinates_.set(i, mutationPayload$FontCoordinate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataHash(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.dataHash_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataHashBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.dataHash_ = byteString.toStringUtf8();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFamilyName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.familyName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFamilyNameBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.familyName_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullName(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.fullName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullNameBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.fullName_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItalicValue(float f2) {
        this.bitField0_ |= 512;
        this.italicValue_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPalleteIndex(double d2) {
        this.bitField0_ |= 1024;
        this.palleteIndex_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostscriptName(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.postscriptName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostscriptNameBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.postscriptName_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSlantValue(float f2) {
        this.bitField0_ |= 256;
        this.slantValue_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyle(MutationPayload$FontStyle mutationPayload$FontStyle) {
        mutationPayload$FontStyle.getClass();
        this.style_ = mutationPayload$FontStyle;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeightValue(float f2) {
        this.bitField0_ |= 64;
        this.weightValue_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidthValue(float f2) {
        this.bitField0_ |= 128;
        this.widthValue_ = f2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Typeface();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ဉ\u0003\u0005က\u0004\u0006\u001b\u0007ለ\u0005\bခ\u0006\tခ\u0007\nခ\b\u000bခ\t\fက\n", new Object[]{"bitField0_", "familyName_", "fullName_", "postscriptName_", "style_", "collectionIndex_", "coordinates_", MutationPayload$FontCoordinate.class, "dataHash_", "weightValue_", "widthValue_", "slantValue_", "italicValue_", "palleteIndex_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Typeface> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Typeface.class) {
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

    public double getCollectionIndex() {
        return this.collectionIndex_;
    }

    public MutationPayload$FontCoordinate getCoordinates(int i) {
        return this.coordinates_.get(i);
    }

    public int getCoordinatesCount() {
        return this.coordinates_.size();
    }

    public List<MutationPayload$FontCoordinate> getCoordinatesList() {
        return this.coordinates_;
    }

    public g getCoordinatesOrBuilder(int i) {
        return this.coordinates_.get(i);
    }

    public List<? extends g> getCoordinatesOrBuilderList() {
        return this.coordinates_;
    }

    public String getDataHash() {
        return this.dataHash_;
    }

    public ByteString getDataHashBytes() {
        return ByteString.copyFromUtf8(this.dataHash_);
    }

    public String getFamilyName() {
        return this.familyName_;
    }

    public ByteString getFamilyNameBytes() {
        return ByteString.copyFromUtf8(this.familyName_);
    }

    public String getFullName() {
        return this.fullName_;
    }

    public ByteString getFullNameBytes() {
        return ByteString.copyFromUtf8(this.fullName_);
    }

    public float getItalicValue() {
        return this.italicValue_;
    }

    public double getPalleteIndex() {
        return this.palleteIndex_;
    }

    public String getPostscriptName() {
        return this.postscriptName_;
    }

    public ByteString getPostscriptNameBytes() {
        return ByteString.copyFromUtf8(this.postscriptName_);
    }

    public float getSlantValue() {
        return this.slantValue_;
    }

    public MutationPayload$FontStyle getStyle() {
        MutationPayload$FontStyle mutationPayload$FontStyle = this.style_;
        return mutationPayload$FontStyle == null ? MutationPayload$FontStyle.getDefaultInstance() : mutationPayload$FontStyle;
    }

    public float getWeightValue() {
        return this.weightValue_;
    }

    public float getWidthValue() {
        return this.widthValue_;
    }

    public boolean hasCollectionIndex() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasDataHash() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasFamilyName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasFullName() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasItalicValue() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasPalleteIndex() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasPostscriptName() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSlantValue() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasStyle() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasWeightValue() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasWidthValue() {
        return (this.bitField0_ & 128) != 0;
    }
}
