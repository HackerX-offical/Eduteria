package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.c;
import com.microsoft.clarity.j.d;
import com.microsoft.clarity.j.h;
import com.microsoft.clarity.j.j;
import com.microsoft.clarity.j.k;
import com.microsoft.clarity.j.n;
import com.microsoft.clarity.j.p;
import com.microsoft.clarity.j.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$DisplayFrame extends GeneratedMessageLite<MutationPayload$DisplayFrame, a> implements d {
    public static final int ACTIVITY_ID_FIELD_NUMBER = 12;
    public static final int ACTIVITY_NAME_FIELD_NUMBER = 11;
    public static final int COMMANDS_FIELD_NUMBER = 1;
    private static final MutationPayload$DisplayFrame DEFAULT_INSTANCE;
    public static final int DENSITY_FIELD_NUMBER = 15;
    public static final int IMAGES_FIELD_NUMBER = 3;
    public static final int PAINTS_FIELD_NUMBER = 6;
    private static volatile Parser<MutationPayload$DisplayFrame> PARSER = null;
    public static final int PATHS_FIELD_NUMBER = 7;
    public static final int SCREEN_HEIGHT_FIELD_NUMBER = 14;
    public static final int SCREEN_WIDTH_FIELD_NUMBER = 13;
    public static final int SUB_PICTURES_FIELD_NUMBER = 8;
    public static final int TEXT_BLOBS_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_FIELD_NUMBER = 10;
    public static final int TYPEFACES_FIELD_NUMBER = 2;
    public static final int VERTICES_FIELD_NUMBER = 5;
    public static final int VIEW_HIERARCHY_FIELD_NUMBER = 9;
    private int activityId_;
    private int bitField0_;
    private float density_;
    private int screenHeight_;
    private int screenWidth_;
    private double timestamp_;
    private MutationPayload$ViewHierarchy viewHierarchy_;
    private Internal.ProtobufList<MutationPayload$DisplayCommand> commands_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Typeface> typefaces_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Image> images_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$TextBlob> textBlobs_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Vertices> vertices_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Paint> paints_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Path> paths_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$DisplayFrame> subPictures_ = GeneratedMessageLite.emptyProtobufList();
    private String activityName_ = "";

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$DisplayFrame, a> implements d {
        public a() {
            super(MutationPayload$DisplayFrame.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).setTimestamp(d2);
            return this;
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).setDensity(f2);
            return this;
        }

        public final a a(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).setActivityId(i);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).setActivityName(str);
            return this;
        }

        public final a a(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllCommands(arrayList);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllImages(list);
            return this;
        }

        public final void a(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).setViewHierarchy(mutationPayload$ViewHierarchy);
        }

        public final a b(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).setScreenHeight(i);
            return this;
        }

        public final a b(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllTypefaces(arrayList);
            return this;
        }

        public final a b(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllPaints(list);
            return this;
        }

        public final a c(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).setScreenWidth(i);
            return this;
        }

        public final a c(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllPaths(list);
            return this;
        }

        public final a d(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllSubPictures(list);
            return this;
        }

        public final a e(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllTextBlobs(list);
            return this;
        }

        public final a f(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayFrame) this.instance).addAllVertices(list);
            return this;
        }
    }

    static {
        MutationPayload$DisplayFrame mutationPayload$DisplayFrame = new MutationPayload$DisplayFrame();
        DEFAULT_INSTANCE = mutationPayload$DisplayFrame;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$DisplayFrame.class, mutationPayload$DisplayFrame);
    }

    private MutationPayload$DisplayFrame() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCommands(Iterable<? extends MutationPayload$DisplayCommand> iterable) {
        ensureCommandsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.commands_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllImages(Iterable<? extends MutationPayload$Image> iterable) {
        ensureImagesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.images_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPaints(Iterable<? extends MutationPayload$Paint> iterable) {
        ensurePaintsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.paints_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPaths(Iterable<? extends MutationPayload$Path> iterable) {
        ensurePathsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.paths_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubPictures(Iterable<? extends MutationPayload$DisplayFrame> iterable) {
        ensureSubPicturesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.subPictures_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTextBlobs(Iterable<? extends MutationPayload$TextBlob> iterable) {
        ensureTextBlobsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.textBlobs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTypefaces(Iterable<? extends MutationPayload$Typeface> iterable) {
        ensureTypefacesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.typefaces_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVertices(Iterable<? extends MutationPayload$Vertices> iterable) {
        ensureVerticesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.vertices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCommands(int i, MutationPayload$DisplayCommand mutationPayload$DisplayCommand) {
        mutationPayload$DisplayCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.add(i, mutationPayload$DisplayCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCommands(MutationPayload$DisplayCommand mutationPayload$DisplayCommand) {
        mutationPayload$DisplayCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.add(mutationPayload$DisplayCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImages(int i, MutationPayload$Image mutationPayload$Image) {
        mutationPayload$Image.getClass();
        ensureImagesIsMutable();
        this.images_.add(i, mutationPayload$Image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImages(MutationPayload$Image mutationPayload$Image) {
        mutationPayload$Image.getClass();
        ensureImagesIsMutable();
        this.images_.add(mutationPayload$Image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaints(int i, MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        ensurePaintsIsMutable();
        this.paints_.add(i, mutationPayload$Paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaints(MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        ensurePaintsIsMutable();
        this.paints_.add(mutationPayload$Paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaths(int i, MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        ensurePathsIsMutable();
        this.paths_.add(i, mutationPayload$Path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaths(MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        ensurePathsIsMutable();
        this.paths_.add(mutationPayload$Path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubPictures(int i, MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        mutationPayload$DisplayFrame.getClass();
        ensureSubPicturesIsMutable();
        this.subPictures_.add(i, mutationPayload$DisplayFrame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubPictures(MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        mutationPayload$DisplayFrame.getClass();
        ensureSubPicturesIsMutable();
        this.subPictures_.add(mutationPayload$DisplayFrame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTextBlobs(int i, MutationPayload$TextBlob mutationPayload$TextBlob) {
        mutationPayload$TextBlob.getClass();
        ensureTextBlobsIsMutable();
        this.textBlobs_.add(i, mutationPayload$TextBlob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTextBlobs(MutationPayload$TextBlob mutationPayload$TextBlob) {
        mutationPayload$TextBlob.getClass();
        ensureTextBlobsIsMutable();
        this.textBlobs_.add(mutationPayload$TextBlob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypefaces(int i, MutationPayload$Typeface mutationPayload$Typeface) {
        mutationPayload$Typeface.getClass();
        ensureTypefacesIsMutable();
        this.typefaces_.add(i, mutationPayload$Typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypefaces(MutationPayload$Typeface mutationPayload$Typeface) {
        mutationPayload$Typeface.getClass();
        ensureTypefacesIsMutable();
        this.typefaces_.add(mutationPayload$Typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVertices(int i, MutationPayload$Vertices mutationPayload$Vertices) {
        mutationPayload$Vertices.getClass();
        ensureVerticesIsMutable();
        this.vertices_.add(i, mutationPayload$Vertices);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVertices(MutationPayload$Vertices mutationPayload$Vertices) {
        mutationPayload$Vertices.getClass();
        ensureVerticesIsMutable();
        this.vertices_.add(mutationPayload$Vertices);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActivityId() {
        this.bitField0_ &= -9;
        this.activityId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActivityName() {
        this.bitField0_ &= -5;
        this.activityName_ = getDefaultInstance().getActivityName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCommands() {
        this.commands_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDensity() {
        this.bitField0_ &= -65;
        this.density_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImages() {
        this.images_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPaints() {
        this.paints_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPaths() {
        this.paths_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScreenHeight() {
        this.bitField0_ &= -33;
        this.screenHeight_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScreenWidth() {
        this.bitField0_ &= -17;
        this.screenWidth_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubPictures() {
        this.subPictures_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTextBlobs() {
        this.textBlobs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.bitField0_ &= -3;
        this.timestamp_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypefaces() {
        this.typefaces_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVertices() {
        this.vertices_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearViewHierarchy() {
        this.viewHierarchy_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCommandsIsMutable() {
        Internal.ProtobufList<MutationPayload$DisplayCommand> protobufList = this.commands_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.commands_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureImagesIsMutable() {
        Internal.ProtobufList<MutationPayload$Image> protobufList = this.images_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.images_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensurePaintsIsMutable() {
        Internal.ProtobufList<MutationPayload$Paint> protobufList = this.paints_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.paints_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensurePathsIsMutable() {
        Internal.ProtobufList<MutationPayload$Path> protobufList = this.paths_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.paths_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSubPicturesIsMutable() {
        Internal.ProtobufList<MutationPayload$DisplayFrame> protobufList = this.subPictures_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.subPictures_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureTextBlobsIsMutable() {
        Internal.ProtobufList<MutationPayload$TextBlob> protobufList = this.textBlobs_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.textBlobs_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureTypefacesIsMutable() {
        Internal.ProtobufList<MutationPayload$Typeface> protobufList = this.typefaces_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.typefaces_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureVerticesIsMutable() {
        Internal.ProtobufList<MutationPayload$Vertices> protobufList = this.vertices_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.vertices_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$DisplayFrame getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeViewHierarchy(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
        mutationPayload$ViewHierarchy.getClass();
        MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy2 = this.viewHierarchy_;
        if (mutationPayload$ViewHierarchy2 != null && mutationPayload$ViewHierarchy2 != MutationPayload$ViewHierarchy.getDefaultInstance()) {
            mutationPayload$ViewHierarchy = MutationPayload$ViewHierarchy.newBuilder(this.viewHierarchy_).mergeFrom(mutationPayload$ViewHierarchy).buildPartial();
        }
        this.viewHierarchy_ = mutationPayload$ViewHierarchy;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$DisplayFrame);
    }

    public static MutationPayload$DisplayFrame parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DisplayFrame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteString byteString) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$DisplayFrame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(InputStream inputStream) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DisplayFrame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(byte[] bArr) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$DisplayFrame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$DisplayFrame> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCommands(int i) {
        ensureCommandsIsMutable();
        this.commands_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImages(int i) {
        ensureImagesIsMutable();
        this.images_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePaints(int i) {
        ensurePaintsIsMutable();
        this.paints_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePaths(int i) {
        ensurePathsIsMutable();
        this.paths_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSubPictures(int i) {
        ensureSubPicturesIsMutable();
        this.subPictures_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTextBlobs(int i) {
        ensureTextBlobsIsMutable();
        this.textBlobs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTypefaces(int i) {
        ensureTypefacesIsMutable();
        this.typefaces_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeVertices(int i) {
        ensureVerticesIsMutable();
        this.vertices_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActivityId(int i) {
        this.bitField0_ |= 8;
        this.activityId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActivityName(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.activityName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActivityNameBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.activityName_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommands(int i, MutationPayload$DisplayCommand mutationPayload$DisplayCommand) {
        mutationPayload$DisplayCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.set(i, mutationPayload$DisplayCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDensity(float f2) {
        this.bitField0_ |= 64;
        this.density_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImages(int i, MutationPayload$Image mutationPayload$Image) {
        mutationPayload$Image.getClass();
        ensureImagesIsMutable();
        this.images_.set(i, mutationPayload$Image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaints(int i, MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        ensurePaintsIsMutable();
        this.paints_.set(i, mutationPayload$Paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaths(int i, MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        ensurePathsIsMutable();
        this.paths_.set(i, mutationPayload$Path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenHeight(int i) {
        this.bitField0_ |= 32;
        this.screenHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenWidth(int i) {
        this.bitField0_ |= 16;
        this.screenWidth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubPictures(int i, MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        mutationPayload$DisplayFrame.getClass();
        ensureSubPicturesIsMutable();
        this.subPictures_.set(i, mutationPayload$DisplayFrame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextBlobs(int i, MutationPayload$TextBlob mutationPayload$TextBlob) {
        mutationPayload$TextBlob.getClass();
        ensureTextBlobsIsMutable();
        this.textBlobs_.set(i, mutationPayload$TextBlob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(double d2) {
        this.bitField0_ |= 2;
        this.timestamp_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypefaces(int i, MutationPayload$Typeface mutationPayload$Typeface) {
        mutationPayload$Typeface.getClass();
        ensureTypefacesIsMutable();
        this.typefaces_.set(i, mutationPayload$Typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVertices(int i, MutationPayload$Vertices mutationPayload$Vertices) {
        mutationPayload$Vertices.getClass();
        ensureVerticesIsMutable();
        this.vertices_.set(i, mutationPayload$Vertices);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewHierarchy(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
        mutationPayload$ViewHierarchy.getClass();
        this.viewHierarchy_ = mutationPayload$ViewHierarchy;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$DisplayFrame();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0001\u0001\u000f\u000f\u0000\b\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u001b\b\u001b\tဉ\u0000\nက\u0001\u000bለ\u0002\fင\u0003\rင\u0004\u000eင\u0005\u000fခ\u0006", new Object[]{"bitField0_", "commands_", MutationPayload$DisplayCommand.class, "typefaces_", MutationPayload$Typeface.class, "images_", MutationPayload$Image.class, "textBlobs_", MutationPayload$TextBlob.class, "vertices_", MutationPayload$Vertices.class, "paints_", MutationPayload$Paint.class, "paths_", MutationPayload$Path.class, "subPictures_", MutationPayload$DisplayFrame.class, "viewHierarchy_", "timestamp_", "activityName_", "activityId_", "screenWidth_", "screenHeight_", "density_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$DisplayFrame> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$DisplayFrame.class) {
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

    public int getActivityId() {
        return this.activityId_;
    }

    public String getActivityName() {
        return this.activityName_;
    }

    public ByteString getActivityNameBytes() {
        return ByteString.copyFromUtf8(this.activityName_);
    }

    public MutationPayload$DisplayCommand getCommands(int i) {
        return this.commands_.get(i);
    }

    public int getCommandsCount() {
        return this.commands_.size();
    }

    public List<MutationPayload$DisplayCommand> getCommandsList() {
        return this.commands_;
    }

    public c getCommandsOrBuilder(int i) {
        return this.commands_.get(i);
    }

    public List<? extends c> getCommandsOrBuilderList() {
        return this.commands_;
    }

    public float getDensity() {
        return this.density_;
    }

    public MutationPayload$Image getImages(int i) {
        return this.images_.get(i);
    }

    public int getImagesCount() {
        return this.images_.size();
    }

    public List<MutationPayload$Image> getImagesList() {
        return this.images_;
    }

    public h getImagesOrBuilder(int i) {
        return this.images_.get(i);
    }

    public List<? extends h> getImagesOrBuilderList() {
        return this.images_;
    }

    public MutationPayload$Paint getPaints(int i) {
        return this.paints_.get(i);
    }

    public int getPaintsCount() {
        return this.paints_.size();
    }

    public List<MutationPayload$Paint> getPaintsList() {
        return this.paints_;
    }

    public j getPaintsOrBuilder(int i) {
        return this.paints_.get(i);
    }

    public List<? extends j> getPaintsOrBuilderList() {
        return this.paints_;
    }

    public MutationPayload$Path getPaths(int i) {
        return this.paths_.get(i);
    }

    public int getPathsCount() {
        return this.paths_.size();
    }

    public List<MutationPayload$Path> getPathsList() {
        return this.paths_;
    }

    public k getPathsOrBuilder(int i) {
        return this.paths_.get(i);
    }

    public List<? extends k> getPathsOrBuilderList() {
        return this.paths_;
    }

    public int getScreenHeight() {
        return this.screenHeight_;
    }

    public int getScreenWidth() {
        return this.screenWidth_;
    }

    public MutationPayload$DisplayFrame getSubPictures(int i) {
        return this.subPictures_.get(i);
    }

    public int getSubPicturesCount() {
        return this.subPictures_.size();
    }

    public List<MutationPayload$DisplayFrame> getSubPicturesList() {
        return this.subPictures_;
    }

    public d getSubPicturesOrBuilder(int i) {
        return this.subPictures_.get(i);
    }

    public List<? extends d> getSubPicturesOrBuilderList() {
        return this.subPictures_;
    }

    public MutationPayload$TextBlob getTextBlobs(int i) {
        return this.textBlobs_.get(i);
    }

    public int getTextBlobsCount() {
        return this.textBlobs_.size();
    }

    public List<MutationPayload$TextBlob> getTextBlobsList() {
        return this.textBlobs_;
    }

    public n getTextBlobsOrBuilder(int i) {
        return this.textBlobs_.get(i);
    }

    public List<? extends n> getTextBlobsOrBuilderList() {
        return this.textBlobs_;
    }

    public double getTimestamp() {
        return this.timestamp_;
    }

    public MutationPayload$Typeface getTypefaces(int i) {
        return this.typefaces_.get(i);
    }

    public int getTypefacesCount() {
        return this.typefaces_.size();
    }

    public List<MutationPayload$Typeface> getTypefacesList() {
        return this.typefaces_;
    }

    public p getTypefacesOrBuilder(int i) {
        return this.typefaces_.get(i);
    }

    public List<? extends p> getTypefacesOrBuilderList() {
        return this.typefaces_;
    }

    public MutationPayload$Vertices getVertices(int i) {
        return this.vertices_.get(i);
    }

    public int getVerticesCount() {
        return this.vertices_.size();
    }

    public List<MutationPayload$Vertices> getVerticesList() {
        return this.vertices_;
    }

    public q getVerticesOrBuilder(int i) {
        return this.vertices_.get(i);
    }

    public List<? extends q> getVerticesOrBuilderList() {
        return this.vertices_;
    }

    public MutationPayload$ViewHierarchy getViewHierarchy() {
        MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy = this.viewHierarchy_;
        return mutationPayload$ViewHierarchy == null ? MutationPayload$ViewHierarchy.getDefaultInstance() : mutationPayload$ViewHierarchy;
    }

    public boolean hasActivityId() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasActivityName() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasDensity() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasScreenHeight() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasScreenWidth() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasViewHierarchy() {
        return (this.bitField0_ & 1) != 0;
    }
}
