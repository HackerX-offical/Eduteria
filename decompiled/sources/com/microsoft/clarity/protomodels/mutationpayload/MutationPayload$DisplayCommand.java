package com.microsoft.clarity.protomodels.mutationpayload;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.c;
import com.microsoft.clarity.j.f;
import com.microsoft.clarity.j.m;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$DisplayCommand extends GeneratedMessageLite<MutationPayload$DisplayCommand, a> implements c {
    public static final int ANTI_ALIAS_FIELD_NUMBER = 3;
    public static final int BLOB_INDEX_FIELD_NUMBER = 29;
    public static final int BONES_FIELD_NUMBER = 32;
    public static final int BOUNDS_FIELD_NUMBER = 37;
    public static final int CENTER_FIELD_NUMBER = 24;
    public static final int CONSTRAINT_FIELD_NUMBER = 26;
    private static final MutationPayload$DisplayCommand DEFAULT_INSTANCE;
    public static final int DST_FIELD_NUMBER = 22;
    public static final int FILTER_MODE_FIELD_NUMBER = 23;
    public static final int FLAGS_FIELD_NUMBER = 35;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int IMAGE_FILTER_PAINT_FIELD_NUMBER = 38;
    public static final int IMAGE_INDEX_FIELD_NUMBER = 16;
    public static final int INNER_FIELD_NUMBER = 13;
    public static final int LATTICE_FIELD_NUMBER = 21;
    public static final int LEFT_FIELD_NUMBER = 41;
    public static final int MASKED_COLOR_FIELD_NUMBER = 20;
    public static final int MASKED_HEIGHT_FIELD_NUMBER = 19;
    public static final int MASKED_WIDTH_FIELD_NUMBER = 18;
    public static final int MATRIX_FIELD_NUMBER = 7;
    public static final int MODE_FIELD_NUMBER = 31;
    public static final int NAME_FIELD_NUMBER = 34;
    public static final int OP_FIELD_NUMBER = 2;
    public static final int OUTER_FIELD_NUMBER = 12;
    public static final int PAINT_INDEX_FIELD_NUMBER = 11;
    private static volatile Parser<MutationPayload$DisplayCommand> PARSER = null;
    public static final int PATH_INDEX_FIELD_NUMBER = 4;
    public static final int POINTS_FIELD_NUMBER = 28;
    public static final int POINT_MODE_FIELD_NUMBER = 27;
    public static final int RECT_FIELD_NUMBER = 5;
    public static final int RRECT_FIELD_NUMBER = 6;
    public static final int SAMPLING_FIELD_NUMBER = 17;
    public static final int SRC_FIELD_NUMBER = 25;
    public static final int START_ANGLE_FIELD_NUMBER = 8;
    public static final int SUBSET_FIELD_NUMBER = 36;
    public static final int SWEEP_ANGLE_FIELD_NUMBER = 9;
    public static final int SX_FIELD_NUMBER = 39;
    public static final int SY_FIELD_NUMBER = 40;
    public static final int TOP_FIELD_NUMBER = 42;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int USE_CENTER_FIELD_NUMBER = 10;
    public static final int VERTICES_INDEX_FIELD_NUMBER = 30;
    public static final int X_FIELD_NUMBER = 14;
    public static final int Y_FIELD_NUMBER = 15;
    private boolean antiAlias_;
    private int bitField0_;
    private int bitField1_;
    private int blobIndex_;
    private MutationPayload$Rect bounds_;
    private MutationPayload$Rect center_;
    private int constraint_;
    private MutationPayload$Rect dst_;
    private double filterMode_;
    private int flags_;
    private int id_;
    private int imageFilterPaint_;
    private int imageIndex_;
    private MutationPayload$Rect inner_;
    private MutationPayload$Lattice lattice_;
    private float left_;
    private MutationPayload$Color4f maskedColor_;
    private int maskedHeight_;
    private int maskedWidth_;
    private double mode_;
    private int op_;
    private MutationPayload$Rect outer_;
    private int paintIndex_;
    private int pathIndex_;
    private int pointMode_;
    private MutationPayload$Rect rect_;
    private MutationPayload$Rect rrect_;
    private MutationPayload$Sampling sampling_;
    private MutationPayload$Rect src_;
    private float startAngle_;
    private MutationPayload$Rect subset_;
    private float sweepAngle_;
    private float sx_;
    private float sy_;
    private float top_;
    private boolean useCenter_;
    private int verticesIndex_;
    private float x_;
    private float y_;
    private int matrixMemoizedSerializedSize = -1;
    private String type_ = "";
    private Internal.FloatList matrix_ = GeneratedMessageLite.emptyFloatList();
    private Internal.ProtobufList<MutationPayload$Point> points_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$FloatList> bones_ = GeneratedMessageLite.emptyProtobufList();
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$DisplayCommand, a> implements c {
        public a() {
            super(MutationPayload$DisplayCommand.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setLeft(f2);
            return this;
        }

        public final a a(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setBlobIndex(i);
            return this;
        }

        public final a a(MutationPayload$Lattice mutationPayload$Lattice) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setLattice(mutationPayload$Lattice);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setName(str);
            return this;
        }

        public final a a(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).addAllMatrix(list);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setAntiAlias(z);
            return this;
        }

        public final void a(double d2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setFilterMode(d2);
        }

        public final void a(MutationPayload$Color4f mutationPayload$Color4f) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setMaskedColor(mutationPayload$Color4f);
        }

        public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).addBones(mutationPayload$FloatList);
        }

        public final void a(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setBounds(mutationPayload$Rect);
        }

        public final void a(MutationPayload$Sampling mutationPayload$Sampling) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setSampling(mutationPayload$Sampling);
        }

        public final a b(double d2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setMode(d2);
            return this;
        }

        public final a b(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setStartAngle(f2);
            return this;
        }

        public final a b(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setConstraint(i);
            return this;
        }

        public final a b(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setCenter(mutationPayload$Rect);
            return this;
        }

        public final a b(String str) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setType(str);
            return this;
        }

        public final a b(List list) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).addAllPoints(list);
            return this;
        }

        public final a b(boolean z) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setUseCenter(z);
            return this;
        }

        public final a c(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setSweepAngle(f2);
            return this;
        }

        public final a c(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setFlags(i);
            return this;
        }

        public final a c(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setDst(mutationPayload$Rect);
            return this;
        }

        public final a d(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setSx(f2);
            return this;
        }

        public final a d(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setId(i);
            return this;
        }

        public final a d(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setInner(mutationPayload$Rect);
            return this;
        }

        public final a e(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setSy(f2);
            return this;
        }

        public final a e(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setOuter(mutationPayload$Rect);
            return this;
        }

        public final void e(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setImageFilterPaint(i);
        }

        public final a f(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setTop(f2);
            return this;
        }

        public final a f(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setRect(mutationPayload$Rect);
            return this;
        }

        public final void f(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setImageIndex(i);
        }

        public final a g(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setX(f2);
            return this;
        }

        public final a g(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setRrect(mutationPayload$Rect);
            return this;
        }

        public final void g(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setMaskedHeight(i);
        }

        public final a h(float f2) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setY(f2);
            return this;
        }

        public final void h(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setMaskedWidth(i);
        }

        public final void h(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setSrc(mutationPayload$Rect);
        }

        public final a i(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setOp(i);
            return this;
        }

        public final void i(MutationPayload$Rect mutationPayload$Rect) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setSubset(mutationPayload$Rect);
        }

        public final a j(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setPaintIndex(i);
            return this;
        }

        public final a k(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setPathIndex(i);
            return this;
        }

        public final a l(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setPointMode(i);
            return this;
        }

        public final a m(int i) {
            copyOnWrite();
            ((MutationPayload$DisplayCommand) this.instance).setVerticesIndex(i);
            return this;
        }
    }

    static {
        MutationPayload$DisplayCommand mutationPayload$DisplayCommand = new MutationPayload$DisplayCommand();
        DEFAULT_INSTANCE = mutationPayload$DisplayCommand;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$DisplayCommand.class, mutationPayload$DisplayCommand);
    }

    private MutationPayload$DisplayCommand() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBones(Iterable<? extends MutationPayload$FloatList> iterable) {
        ensureBonesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.bones_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMatrix(Iterable<? extends Float> iterable) {
        ensureMatrixIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.matrix_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPoints(Iterable<? extends MutationPayload$Point> iterable) {
        ensurePointsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.points_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBones(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBonesIsMutable();
        this.bones_.add(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBones(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBonesIsMutable();
        this.bones_.add(mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMatrix(float f2) {
        ensureMatrixIsMutable();
        this.matrix_.addFloat(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPoints(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePointsIsMutable();
        this.points_.add(i, mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPoints(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePointsIsMutable();
        this.points_.add(mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAntiAlias() {
        this.bitField0_ &= -5;
        this.antiAlias_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBlobIndex() {
        this.bitField0_ &= -67108865;
        this.blobIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBones() {
        this.bones_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBounds() {
        this.bounds_ = null;
        this.bitField1_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCenter() {
        this.center_ = null;
        this.bitField0_ &= -4194305;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConstraint() {
        this.bitField0_ &= -16777217;
        this.constraint_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDst() {
        this.dst_ = null;
        this.bitField0_ &= -1048577;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilterMode() {
        this.bitField0_ &= -2097153;
        this.filterMode_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFlags() {
        this.bitField0_ &= Integer.MAX_VALUE;
        this.flags_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.bitField0_ &= -536870913;
        this.id_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageFilterPaint() {
        this.bitField1_ &= -5;
        this.imageFilterPaint_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageIndex() {
        this.bitField0_ &= -16385;
        this.imageIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInner() {
        this.inner_ = null;
        this.bitField0_ &= -2049;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLattice() {
        this.lattice_ = null;
        this.bitField0_ &= -524289;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLeft() {
        this.bitField1_ &= -33;
        this.left_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaskedColor() {
        this.maskedColor_ = null;
        this.bitField0_ &= -262145;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaskedHeight() {
        this.bitField0_ &= -131073;
        this.maskedHeight_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaskedWidth() {
        this.bitField0_ &= -65537;
        this.maskedWidth_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMatrix() {
        this.matrix_ = GeneratedMessageLite.emptyFloatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMode() {
        this.bitField0_ &= -268435457;
        this.mode_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -1073741825;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOp() {
        this.bitField0_ &= -3;
        this.op_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOuter() {
        this.outer_ = null;
        this.bitField0_ &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPaintIndex() {
        this.bitField0_ &= -513;
        this.paintIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPathIndex() {
        this.bitField0_ &= -9;
        this.pathIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPointMode() {
        this.bitField0_ &= -33554433;
        this.pointMode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPoints() {
        this.points_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRect() {
        this.rect_ = null;
        this.bitField0_ &= -17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRrect() {
        this.rrect_ = null;
        this.bitField0_ &= -33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSampling() {
        this.sampling_ = null;
        this.bitField0_ &= -32769;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSrc() {
        this.src_ = null;
        this.bitField0_ &= -8388609;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartAngle() {
        this.bitField0_ &= -65;
        this.startAngle_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubset() {
        this.subset_ = null;
        this.bitField1_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSweepAngle() {
        this.bitField0_ &= -129;
        this.sweepAngle_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSx() {
        this.bitField1_ &= -9;
        this.sx_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSy() {
        this.bitField1_ &= -17;
        this.sy_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTop() {
        this.bitField1_ &= -65;
        this.top_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUseCenter() {
        this.bitField0_ &= -257;
        this.useCenter_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVerticesIndex() {
        this.bitField0_ &= -134217729;
        this.verticesIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearX() {
        this.bitField0_ &= -4097;
        this.x_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearY() {
        this.bitField0_ &= -8193;
        this.y_ = 0.0f;
    }

    private void ensureBonesIsMutable() {
        Internal.ProtobufList<MutationPayload$FloatList> protobufList = this.bones_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.bones_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureMatrixIsMutable() {
        Internal.FloatList floatList = this.matrix_;
        if (floatList.isModifiable()) {
            return;
        }
        this.matrix_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    private void ensurePointsIsMutable() {
        Internal.ProtobufList<MutationPayload$Point> protobufList = this.points_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.points_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$DisplayCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBounds(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.bounds_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.bounds_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.bounds_ = mutationPayload$Rect;
        this.bitField1_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCenter(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.center_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.center_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.center_ = mutationPayload$Rect;
        this.bitField0_ |= 4194304;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDst(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.dst_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.dst_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.dst_ = mutationPayload$Rect;
        this.bitField0_ |= 1048576;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInner(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.inner_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.inner_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.inner_ = mutationPayload$Rect;
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLattice(MutationPayload$Lattice mutationPayload$Lattice) {
        mutationPayload$Lattice.getClass();
        MutationPayload$Lattice mutationPayload$Lattice2 = this.lattice_;
        if (mutationPayload$Lattice2 != null && mutationPayload$Lattice2 != MutationPayload$Lattice.getDefaultInstance()) {
            mutationPayload$Lattice = MutationPayload$Lattice.newBuilder(this.lattice_).mergeFrom(mutationPayload$Lattice).buildPartial();
        }
        this.lattice_ = mutationPayload$Lattice;
        this.bitField0_ |= 524288;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMaskedColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        MutationPayload$Color4f mutationPayload$Color4f2 = this.maskedColor_;
        if (mutationPayload$Color4f2 != null && mutationPayload$Color4f2 != MutationPayload$Color4f.getDefaultInstance()) {
            mutationPayload$Color4f = MutationPayload$Color4f.newBuilder(this.maskedColor_).mergeFrom(mutationPayload$Color4f).buildPartial();
        }
        this.maskedColor_ = mutationPayload$Color4f;
        this.bitField0_ |= 262144;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOuter(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.outer_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.outer_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.outer_ = mutationPayload$Rect;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.rect_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.rect_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.rect_ = mutationPayload$Rect;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRrect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.rrect_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.rrect_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.rrect_ = mutationPayload$Rect;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSampling(MutationPayload$Sampling mutationPayload$Sampling) {
        mutationPayload$Sampling.getClass();
        MutationPayload$Sampling mutationPayload$Sampling2 = this.sampling_;
        if (mutationPayload$Sampling2 != null && mutationPayload$Sampling2 != MutationPayload$Sampling.getDefaultInstance()) {
            mutationPayload$Sampling = MutationPayload$Sampling.newBuilder(this.sampling_).mergeFrom(mutationPayload$Sampling).buildPartial();
        }
        this.sampling_ = mutationPayload$Sampling;
        this.bitField0_ |= 32768;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSrc(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.src_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.src_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.src_ = mutationPayload$Rect;
        this.bitField0_ |= 8388608;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubset(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.subset_;
        if (mutationPayload$Rect2 != null && mutationPayload$Rect2 != MutationPayload$Rect.getDefaultInstance()) {
            mutationPayload$Rect = MutationPayload$Rect.newBuilder(this.subset_).mergeFrom(mutationPayload$Rect).buildPartial();
        }
        this.subset_ = mutationPayload$Rect;
        this.bitField1_ |= 1;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$DisplayCommand mutationPayload$DisplayCommand) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$DisplayCommand);
    }

    public static MutationPayload$DisplayCommand parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DisplayCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayCommand parseFrom(ByteString byteString) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$DisplayCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$DisplayCommand parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$DisplayCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayCommand parseFrom(InputStream inputStream) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DisplayCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayCommand parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$DisplayCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$DisplayCommand parseFrom(byte[] bArr) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$DisplayCommand parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$DisplayCommand> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeBones(int i) {
        ensureBonesIsMutable();
        this.bones_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePoints(int i) {
        ensurePointsIsMutable();
        this.points_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAntiAlias(boolean z) {
        this.bitField0_ |= 4;
        this.antiAlias_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBlobIndex(int i) {
        this.bitField0_ |= 67108864;
        this.blobIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBones(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBonesIsMutable();
        this.bones_.set(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBounds(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.bounds_ = mutationPayload$Rect;
        this.bitField1_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCenter(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.center_ = mutationPayload$Rect;
        this.bitField0_ |= 4194304;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConstraint(int i) {
        this.bitField0_ |= 16777216;
        this.constraint_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDst(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.dst_ = mutationPayload$Rect;
        this.bitField0_ |= 1048576;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilterMode(double d2) {
        this.bitField0_ |= 2097152;
        this.filterMode_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFlags(int i) {
        this.bitField0_ |= Integer.MIN_VALUE;
        this.flags_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.bitField0_ |= 536870912;
        this.id_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageFilterPaint(int i) {
        this.bitField1_ |= 4;
        this.imageFilterPaint_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageIndex(int i) {
        this.bitField0_ |= 16384;
        this.imageIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInner(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.inner_ = mutationPayload$Rect;
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLattice(MutationPayload$Lattice mutationPayload$Lattice) {
        mutationPayload$Lattice.getClass();
        this.lattice_ = mutationPayload$Lattice;
        this.bitField0_ |= 524288;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeft(float f2) {
        this.bitField1_ |= 32;
        this.left_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        this.maskedColor_ = mutationPayload$Color4f;
        this.bitField0_ |= 262144;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedHeight(int i) {
        this.bitField0_ |= 131072;
        this.maskedHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedWidth(int i) {
        this.bitField0_ |= 65536;
        this.maskedWidth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMatrix(int i, float f2) {
        ensureMatrixIsMutable();
        this.matrix_.setFloat(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(double d2) {
        this.bitField0_ |= 268435456;
        this.mode_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1073741824;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
        this.bitField0_ |= 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOp(int i) {
        this.bitField0_ |= 2;
        this.op_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOuter(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.outer_ = mutationPayload$Rect;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaintIndex(int i) {
        this.bitField0_ |= 512;
        this.paintIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathIndex(int i) {
        this.bitField0_ |= 8;
        this.pathIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPointMode(int i) {
        this.bitField0_ |= GroupFlagsKt.HasAuxSlotFlag;
        this.pointMode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPoints(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePointsIsMutable();
        this.points_.set(i, mutationPayload$Point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.rect_ = mutationPayload$Rect;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRrect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.rrect_ = mutationPayload$Rect;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSampling(MutationPayload$Sampling mutationPayload$Sampling) {
        mutationPayload$Sampling.getClass();
        this.sampling_ = mutationPayload$Sampling;
        this.bitField0_ |= 32768;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSrc(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.src_ = mutationPayload$Rect;
        this.bitField0_ |= 8388608;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartAngle(float f2) {
        this.bitField0_ |= 64;
        this.startAngle_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubset(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.subset_ = mutationPayload$Rect;
        this.bitField1_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSweepAngle(float f2) {
        this.bitField0_ |= 128;
        this.sweepAngle_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSx(float f2) {
        this.bitField1_ |= 8;
        this.sx_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSy(float f2) {
        this.bitField1_ |= 16;
        this.sy_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTop(float f2) {
        this.bitField1_ |= 64;
        this.top_ = f2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setUseCenter(boolean z) {
        this.bitField0_ |= 256;
        this.useCenter_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVerticesIndex(int i) {
        this.bitField0_ |= 134217728;
        this.verticesIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(float f2) {
        this.bitField0_ |= 4096;
        this.x_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(float f2) {
        this.bitField0_ |= 8192;
        this.y_ = f2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$DisplayCommand();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000*\u0000\u0002\u0001**\u0000\u0003\u0000\u0001ለ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004င\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007$\bခ\u0006\tခ\u0007\nဇ\b\u000bင\t\fဉ\n\rဉ\u000b\u000eခ\f\u000fခ\r\u0010င\u000e\u0011ဉ\u000f\u0012င\u0010\u0013င\u0011\u0014ဉ\u0012\u0015ဉ\u0013\u0016ဉ\u0014\u0017က\u0015\u0018ဉ\u0016\u0019ဉ\u0017\u001aင\u0018\u001bင\u0019\u001c\u001b\u001dင\u001a\u001eင\u001b\u001fက\u001c \u001b!င\u001d\"ለ\u001e#င\u001f$ဉ %ဉ!&င\"'ခ#(ခ$)ခ%*ခ&", new Object[]{"bitField0_", "bitField1_", "type_", "op_", "antiAlias_", "pathIndex_", "rect_", "rrect_", "matrix_", "startAngle_", "sweepAngle_", "useCenter_", "paintIndex_", "outer_", "inner_", "x_", "y_", "imageIndex_", "sampling_", "maskedWidth_", "maskedHeight_", "maskedColor_", "lattice_", "dst_", "filterMode_", "center_", "src_", "constraint_", "pointMode_", "points_", MutationPayload$Point.class, "blobIndex_", "verticesIndex_", "mode_", "bones_", MutationPayload$FloatList.class, "id_", "name_", "flags_", "subset_", "bounds_", "imageFilterPaint_", "sx_", "sy_", "left_", "top_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$DisplayCommand> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$DisplayCommand.class) {
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

    public boolean getAntiAlias() {
        return this.antiAlias_;
    }

    public int getBlobIndex() {
        return this.blobIndex_;
    }

    public MutationPayload$FloatList getBones(int i) {
        return this.bones_.get(i);
    }

    public int getBonesCount() {
        return this.bones_.size();
    }

    public List<MutationPayload$FloatList> getBonesList() {
        return this.bones_;
    }

    public f getBonesOrBuilder(int i) {
        return this.bones_.get(i);
    }

    public List<? extends f> getBonesOrBuilderList() {
        return this.bones_;
    }

    public MutationPayload$Rect getBounds() {
        MutationPayload$Rect mutationPayload$Rect = this.bounds_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public MutationPayload$Rect getCenter() {
        MutationPayload$Rect mutationPayload$Rect = this.center_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public int getConstraint() {
        return this.constraint_;
    }

    public MutationPayload$Rect getDst() {
        MutationPayload$Rect mutationPayload$Rect = this.dst_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public double getFilterMode() {
        return this.filterMode_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getId() {
        return this.id_;
    }

    public int getImageFilterPaint() {
        return this.imageFilterPaint_;
    }

    public int getImageIndex() {
        return this.imageIndex_;
    }

    public MutationPayload$Rect getInner() {
        MutationPayload$Rect mutationPayload$Rect = this.inner_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public MutationPayload$Lattice getLattice() {
        MutationPayload$Lattice mutationPayload$Lattice = this.lattice_;
        return mutationPayload$Lattice == null ? MutationPayload$Lattice.getDefaultInstance() : mutationPayload$Lattice;
    }

    public float getLeft() {
        return this.left_;
    }

    public MutationPayload$Color4f getMaskedColor() {
        MutationPayload$Color4f mutationPayload$Color4f = this.maskedColor_;
        return mutationPayload$Color4f == null ? MutationPayload$Color4f.getDefaultInstance() : mutationPayload$Color4f;
    }

    public int getMaskedHeight() {
        return this.maskedHeight_;
    }

    public int getMaskedWidth() {
        return this.maskedWidth_;
    }

    public float getMatrix(int i) {
        return this.matrix_.getFloat(i);
    }

    public int getMatrixCount() {
        return this.matrix_.size();
    }

    public List<Float> getMatrixList() {
        return this.matrix_;
    }

    public double getMode() {
        return this.mode_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public int getOp() {
        return this.op_;
    }

    public MutationPayload$Rect getOuter() {
        MutationPayload$Rect mutationPayload$Rect = this.outer_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public int getPaintIndex() {
        return this.paintIndex_;
    }

    public int getPathIndex() {
        return this.pathIndex_;
    }

    public int getPointMode() {
        return this.pointMode_;
    }

    public MutationPayload$Point getPoints(int i) {
        return this.points_.get(i);
    }

    public int getPointsCount() {
        return this.points_.size();
    }

    public List<MutationPayload$Point> getPointsList() {
        return this.points_;
    }

    public m getPointsOrBuilder(int i) {
        return this.points_.get(i);
    }

    public List<? extends m> getPointsOrBuilderList() {
        return this.points_;
    }

    public MutationPayload$Rect getRect() {
        MutationPayload$Rect mutationPayload$Rect = this.rect_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public MutationPayload$Rect getRrect() {
        MutationPayload$Rect mutationPayload$Rect = this.rrect_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public MutationPayload$Sampling getSampling() {
        MutationPayload$Sampling mutationPayload$Sampling = this.sampling_;
        return mutationPayload$Sampling == null ? MutationPayload$Sampling.getDefaultInstance() : mutationPayload$Sampling;
    }

    public MutationPayload$Rect getSrc() {
        MutationPayload$Rect mutationPayload$Rect = this.src_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public float getStartAngle() {
        return this.startAngle_;
    }

    public MutationPayload$Rect getSubset() {
        MutationPayload$Rect mutationPayload$Rect = this.subset_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public float getSweepAngle() {
        return this.sweepAngle_;
    }

    public float getSx() {
        return this.sx_;
    }

    public float getSy() {
        return this.sy_;
    }

    public float getTop() {
        return this.top_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean getUseCenter() {
        return this.useCenter_;
    }

    public int getVerticesIndex() {
        return this.verticesIndex_;
    }

    public float getX() {
        return this.x_;
    }

    public float getY() {
        return this.y_;
    }

    public boolean hasAntiAlias() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasBlobIndex() {
        return (this.bitField0_ & 67108864) != 0;
    }

    public boolean hasBounds() {
        return (this.bitField1_ & 2) != 0;
    }

    public boolean hasCenter() {
        return (this.bitField0_ & 4194304) != 0;
    }

    public boolean hasConstraint() {
        return (this.bitField0_ & 16777216) != 0;
    }

    public boolean hasDst() {
        return (this.bitField0_ & 1048576) != 0;
    }

    public boolean hasFilterMode() {
        return (this.bitField0_ & 2097152) != 0;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & Integer.MIN_VALUE) != 0;
    }

    public boolean hasId() {
        return (this.bitField0_ & 536870912) != 0;
    }

    public boolean hasImageFilterPaint() {
        return (this.bitField1_ & 4) != 0;
    }

    public boolean hasImageIndex() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasInner() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasLattice() {
        return (this.bitField0_ & 524288) != 0;
    }

    public boolean hasLeft() {
        return (this.bitField1_ & 32) != 0;
    }

    public boolean hasMaskedColor() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasMaskedHeight() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasMaskedWidth() {
        return (this.bitField0_ & 65536) != 0;
    }

    public boolean hasMode() {
        return (this.bitField0_ & 268435456) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1073741824) != 0;
    }

    public boolean hasOp() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOuter() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasPaintIndex() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasPathIndex() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPointMode() {
        return (this.bitField0_ & GroupFlagsKt.HasAuxSlotFlag) != 0;
    }

    public boolean hasRect() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasRrect() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasSampling() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasSrc() {
        return (this.bitField0_ & 8388608) != 0;
    }

    public boolean hasStartAngle() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasSubset() {
        return (this.bitField1_ & 1) != 0;
    }

    public boolean hasSweepAngle() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasSx() {
        return (this.bitField1_ & 8) != 0;
    }

    public boolean hasSy() {
        return (this.bitField1_ & 16) != 0;
    }

    public boolean hasTop() {
        return (this.bitField1_ & 64) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUseCenter() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasVerticesIndex() {
        return (this.bitField0_ & 134217728) != 0;
    }

    public boolean hasX() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasY() {
        return (this.bitField0_ & 8192) != 0;
    }
}
