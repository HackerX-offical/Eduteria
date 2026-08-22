package com.microsoft.clarity.models.display;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.commands.DisplayCommand;
import com.microsoft.clarity.models.display.common.Vertices;
import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paths.Path;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayFrame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b8\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B½\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0016HÆ\u0003J\t\u0010H\u001a\u00020\u0018HÆ\u0003J\t\u0010I\u001a\u00020\u001aHÆ\u0003J\t\u0010J\u001a\u00020\u001aHÆ\u0003J\t\u0010K\u001a\u00020\u001aHÆ\u0003J\t\u0010L\u001a\u00020\u001eHÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004HÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\r0\u0004HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004HÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004HÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0014HÆ\u0003JÑ\u0001\u0010U\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001eHÆ\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\u001aHÖ\u0001J\b\u0010[\u001a\u00020\u0002H\u0016J\t\u0010\\\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u001a\u0010\u001c\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001a\u0010\u001b\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u0010#R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006]"}, d2 = {"Lcom/microsoft/clarity/models/display/DisplayFrame;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayFrame;", "commands", "", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "typefaces", "Lcom/microsoft/clarity/models/display/typefaces/Typeface;", Const.IMAGES, "Lcom/microsoft/clarity/models/display/images/Image;", "textBlobs", "Lcom/microsoft/clarity/models/display/blobs/TextBlob;", "vertices", "Lcom/microsoft/clarity/models/display/common/Vertices;", "paints", "Lcom/microsoft/clarity/models/display/paints/Paint;", "paths", "Lcom/microsoft/clarity/models/display/paths/Path;", "subPictures", "viewHierarchy", "Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "timestamp", "", "activityName", "", "activityId", "", "screenWidth", "screenHeight", "density", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;JLjava/lang/String;IIIF)V", "getActivityId", "()I", "setActivityId", "(I)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getCommands", "()Ljava/util/List;", "setCommands", "(Ljava/util/List;)V", "getDensity", "()F", "setDensity", "(F)V", "getImages", "setImages", "getPaints", "getPaths", "getScreenHeight", "setScreenHeight", "getScreenWidth", "setScreenWidth", "getSubPictures", "getTextBlobs", "setTextBlobs", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTypefaces", "setTypefaces", "getVertices", "getViewHierarchy", "()Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "setViewHierarchy", "(Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class DisplayFrame implements IProtoModel<MutationPayload$DisplayFrame> {
    private int activityId;
    private String activityName;
    private List<? extends DisplayCommand> commands;
    private float density;
    private List<Image> images;
    private final List<Paint> paints;
    private final List<Path> paths;
    private int screenHeight;
    private int screenWidth;
    private final List<DisplayFrame> subPictures;
    private List<TextBlob> textBlobs;
    private long timestamp;
    private List<Typeface> typefaces;
    private final List<Vertices> vertices;
    private ViewHierarchy viewHierarchy;

    public DisplayFrame(List<? extends DisplayCommand> commands, List<Typeface> typefaces, List<Image> images, List<TextBlob> textBlobs, List<Vertices> vertices, List<Paint> paints, List<Path> paths, List<DisplayFrame> subPictures, ViewHierarchy viewHierarchy, long j, String activityName, int i, int i2, int i3, float f2) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(typefaces, "typefaces");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(textBlobs, "textBlobs");
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(subPictures, "subPictures");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.commands = commands;
        this.typefaces = typefaces;
        this.images = images;
        this.textBlobs = textBlobs;
        this.vertices = vertices;
        this.paints = paints;
        this.paths = paths;
        this.subPictures = subPictures;
        this.viewHierarchy = viewHierarchy;
        this.timestamp = j;
        this.activityName = activityName;
        this.activityId = i;
        this.screenWidth = i2;
        this.screenHeight = i3;
        this.density = f2;
    }

    public /* synthetic */ DisplayFrame(List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, ViewHierarchy viewHierarchy, long j, String str, int i, int i2, int i3, float f2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5, list6, list7, list8, (i4 & 256) != 0 ? null : viewHierarchy, (i4 & 512) != 0 ? 0L : j, (i4 & 1024) != 0 ? "" : str, (i4 & 2048) != 0 ? 0 : i, (i4 & 4096) != 0 ? 0 : i2, (i4 & 8192) != 0 ? 0 : i3, (i4 & 16384) != 0 ? 0.0f : f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DisplayFrame copy$default(DisplayFrame displayFrame, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, ViewHierarchy viewHierarchy, long j, String str, int i, int i2, int i3, float f2, int i4, Object obj) {
        List list9 = (i4 & 1) != 0 ? displayFrame.commands : list;
        return displayFrame.copy(list9, (i4 & 2) != 0 ? displayFrame.typefaces : list2, (i4 & 4) != 0 ? displayFrame.images : list3, (i4 & 8) != 0 ? displayFrame.textBlobs : list4, (i4 & 16) != 0 ? displayFrame.vertices : list5, (i4 & 32) != 0 ? displayFrame.paints : list6, (i4 & 64) != 0 ? displayFrame.paths : list7, (i4 & 128) != 0 ? displayFrame.subPictures : list8, (i4 & 256) != 0 ? displayFrame.viewHierarchy : viewHierarchy, (i4 & 512) != 0 ? displayFrame.timestamp : j, (i4 & 1024) != 0 ? displayFrame.activityName : str, (i4 & 2048) != 0 ? displayFrame.activityId : i, (i4 & 4096) != 0 ? displayFrame.screenWidth : i2, (i4 & 8192) != 0 ? displayFrame.screenHeight : i3, (i4 & 16384) != 0 ? displayFrame.density : f2);
    }

    public final List<DisplayCommand> component1() {
        return this.commands;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getScreenWidth() {
        return this.screenWidth;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getScreenHeight() {
        return this.screenHeight;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    public final List<Typeface> component2() {
        return this.typefaces;
    }

    public final List<Image> component3() {
        return this.images;
    }

    public final List<TextBlob> component4() {
        return this.textBlobs;
    }

    public final List<Vertices> component5() {
        return this.vertices;
    }

    public final List<Paint> component6() {
        return this.paints;
    }

    public final List<Path> component7() {
        return this.paths;
    }

    public final List<DisplayFrame> component8() {
        return this.subPictures;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ViewHierarchy getViewHierarchy() {
        return this.viewHierarchy;
    }

    public final DisplayFrame copy(List<? extends DisplayCommand> commands, List<Typeface> typefaces, List<Image> images, List<TextBlob> textBlobs, List<Vertices> vertices, List<Paint> paints, List<Path> paths, List<DisplayFrame> subPictures, ViewHierarchy viewHierarchy, long timestamp, String activityName, int activityId, int screenWidth, int screenHeight, float density) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(typefaces, "typefaces");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(textBlobs, "textBlobs");
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(subPictures, "subPictures");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        return new DisplayFrame(commands, typefaces, images, textBlobs, vertices, paints, paths, subPictures, viewHierarchy, timestamp, activityName, activityId, screenWidth, screenHeight, density);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayFrame)) {
            return false;
        }
        DisplayFrame displayFrame = (DisplayFrame) other;
        return Intrinsics.areEqual(this.commands, displayFrame.commands) && Intrinsics.areEqual(this.typefaces, displayFrame.typefaces) && Intrinsics.areEqual(this.images, displayFrame.images) && Intrinsics.areEqual(this.textBlobs, displayFrame.textBlobs) && Intrinsics.areEqual(this.vertices, displayFrame.vertices) && Intrinsics.areEqual(this.paints, displayFrame.paints) && Intrinsics.areEqual(this.paths, displayFrame.paths) && Intrinsics.areEqual(this.subPictures, displayFrame.subPictures) && Intrinsics.areEqual(this.viewHierarchy, displayFrame.viewHierarchy) && this.timestamp == displayFrame.timestamp && Intrinsics.areEqual(this.activityName, displayFrame.activityName) && this.activityId == displayFrame.activityId && this.screenWidth == displayFrame.screenWidth && this.screenHeight == displayFrame.screenHeight && Intrinsics.areEqual((Object) Float.valueOf(this.density), (Object) Float.valueOf(displayFrame.density));
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final List<DisplayCommand> getCommands() {
        return this.commands;
    }

    public final float getDensity() {
        return this.density;
    }

    public final List<Image> getImages() {
        return this.images;
    }

    public final List<Paint> getPaints() {
        return this.paints;
    }

    public final List<Path> getPaths() {
        return this.paths;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final List<DisplayFrame> getSubPictures() {
        return this.subPictures;
    }

    public final List<TextBlob> getTextBlobs() {
        return this.textBlobs;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final List<Typeface> getTypefaces() {
        return this.typefaces;
    }

    public final List<Vertices> getVertices() {
        return this.vertices;
    }

    public final ViewHierarchy getViewHierarchy() {
        return this.viewHierarchy;
    }

    public int hashCode() {
        int iHashCode = (this.subPictures.hashCode() + ((this.paths.hashCode() + ((this.paints.hashCode() + ((this.vertices.hashCode() + ((this.textBlobs.hashCode() + ((this.images.hashCode() + ((this.typefaces.hashCode() + (this.commands.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        ViewHierarchy viewHierarchy = this.viewHierarchy;
        return Float.hashCode(this.density) + ((Integer.hashCode(this.screenHeight) + ((Integer.hashCode(this.screenWidth) + ((Integer.hashCode(this.activityId) + ((this.activityName.hashCode() + ((Long.hashCode(this.timestamp) + ((iHashCode + (viewHierarchy == null ? 0 : viewHierarchy.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final void setActivityId(int i) {
        this.activityId = i;
    }

    public final void setActivityName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityName = str;
    }

    public final void setCommands(List<? extends DisplayCommand> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commands = list;
    }

    public final void setDensity(float f2) {
        this.density = f2;
    }

    public final void setImages(List<Image> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.images = list;
    }

    public final void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public final void setScreenWidth(int i) {
        this.screenWidth = i;
    }

    public final void setTextBlobs(List<TextBlob> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.textBlobs = list;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setTypefaces(List<Typeface> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.typefaces = list;
    }

    public final void setViewHierarchy(ViewHierarchy viewHierarchy) {
        this.viewHierarchy = viewHierarchy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayFrame toProtobufInstance() {
        MutationPayload$DisplayFrame.a aVarNewBuilder = MutationPayload$DisplayFrame.newBuilder();
        List<? extends DisplayCommand> list = this.commands;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((DisplayCommand) it.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarA = aVarNewBuilder.a(arrayList);
        List<Typeface> list2 = this.typefaces;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Typeface) it2.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarB = aVarA.b(arrayList2);
        List<Image> list3 = this.images;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Image) it3.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarA2 = aVarB.a(CollectionsKt.toList(arrayList3));
        List<TextBlob> list4 = this.textBlobs;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it4 = list4.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((TextBlob) it4.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarE = aVarA2.e(CollectionsKt.toList(arrayList4));
        List<Vertices> list5 = this.vertices;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        Iterator<T> it5 = list5.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((Vertices) it5.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarF = aVarE.f(CollectionsKt.toList(arrayList5));
        List<Paint> list6 = this.paints;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
        Iterator<T> it6 = list6.iterator();
        while (it6.hasNext()) {
            arrayList6.add(((Paint) it6.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarB2 = aVarF.b(CollectionsKt.toList(arrayList6));
        List<Path> list7 = this.paths;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
        Iterator<T> it7 = list7.iterator();
        while (it7.hasNext()) {
            arrayList7.add(((Path) it7.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarC = aVarB2.c(CollectionsKt.toList(arrayList7));
        List<DisplayFrame> list8 = this.subPictures;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
        Iterator<T> it8 = list8.iterator();
        while (it8.hasNext()) {
            arrayList8.add(((DisplayFrame) it8.next()).toProtobufInstance());
        }
        MutationPayload$DisplayFrame.a aVarA3 = aVarC.d(CollectionsKt.toList(arrayList8)).a(this.timestamp).a(this.activityName).a(this.activityId).b(this.screenHeight).c(this.screenWidth).a(this.density);
        ViewHierarchy viewHierarchy = this.viewHierarchy;
        if (viewHierarchy != null) {
            aVarA3.a(viewHierarchy.toProtobufInstance());
        }
        MutationPayload$DisplayFrame mutationPayload$DisplayFrameBuild = aVarA3.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayFrameBuild, "builder.build()");
        return mutationPayload$DisplayFrameBuild;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DisplayFrame(commands=");
        sb.append(this.commands).append(", typefaces=").append(this.typefaces).append(", images=").append(this.images).append(", textBlobs=").append(this.textBlobs).append(", vertices=").append(this.vertices).append(", paints=").append(this.paints).append(", paths=").append(this.paths).append(", subPictures=").append(this.subPictures).append(", viewHierarchy=").append(this.viewHierarchy).append(", timestamp=").append(this.timestamp).append(", activityName=").append(this.activityName).append(", activityId=");
        sb.append(this.activityId).append(", screenWidth=").append(this.screenWidth).append(", screenHeight=").append(this.screenHeight).append(", density=").append(this.density).append(')');
        return sb.toString();
    }
}
