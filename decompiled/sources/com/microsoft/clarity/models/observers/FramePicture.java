package com.microsoft.clarity.models.observers;

import android.graphics.Picture;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/microsoft/clarity/models/observers/FramePicture;", "Lcom/microsoft/clarity/models/observers/ObservedEvent;", "picture", "Landroid/graphics/Picture;", "viewHierarchy", "Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "absoluteTimestamp", "", "activityName", "", "activityId", "", "maskRestrictively", "", "screenWidth", "screenHeight", "density", "", "(Landroid/graphics/Picture;Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;JLjava/lang/String;IZIIF)V", "getActivityId", "()I", "getActivityName", "()Ljava/lang/String;", "getDensity", "()F", "getMaskRestrictively", "()Z", "getPicture", "()Landroid/graphics/Picture;", "getScreenHeight", "setScreenHeight", "(I)V", "getScreenWidth", "setScreenWidth", "getViewHierarchy", "()Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FramePicture extends ObservedEvent {
    private final int activityId;
    private final String activityName;
    private final float density;
    private final boolean maskRestrictively;
    private final Picture picture;
    private int screenHeight;
    private int screenWidth;
    private final ViewHierarchy viewHierarchy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FramePicture(Picture picture, ViewHierarchy viewHierarchy, long j, String activityName, int i, boolean z, int i2, int i3, float f2) {
        super(j);
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(viewHierarchy, "viewHierarchy");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.picture = picture;
        this.viewHierarchy = viewHierarchy;
        this.activityName = activityName;
        this.activityId = i;
        this.maskRestrictively = z;
        this.screenWidth = i2;
        this.screenHeight = i3;
        this.density = f2;
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final float getDensity() {
        return this.density;
    }

    public final boolean getMaskRestrictively() {
        return this.maskRestrictively;
    }

    public final Picture getPicture() {
        return this.picture;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final ViewHierarchy getViewHierarchy() {
        return this.viewHierarchy;
    }

    public final void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public final void setScreenWidth(int i) {
        this.screenWidth = i;
    }
}
