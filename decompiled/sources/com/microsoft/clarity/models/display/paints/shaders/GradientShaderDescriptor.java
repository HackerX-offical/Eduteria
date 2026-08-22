package com.microsoft.clarity.models.display.paints.shaders;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.display.paints.Color4f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006 "}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/GradientShaderDescriptor;", "", "tileMode", "", "gradFlags", "colors", "", "Lcom/microsoft/clarity/models/display/paints/Color4f;", Constants.INAPP_POSITION, "", "localMatrix", "(JJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getColors", "()Ljava/util/List;", "getGradFlags", "()J", "getLocalMatrix", "getPos", "getTileMode", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class GradientShaderDescriptor {
    private final List<Color4f> colors;
    private final long gradFlags;
    private final List<Float> localMatrix;
    private final List<Float> pos;
    private final long tileMode;

    public GradientShaderDescriptor(long j, long j2, List<Color4f> colors, List<Float> list, List<Float> list2) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.tileMode = j;
        this.gradFlags = j2;
        this.colors = colors;
        this.pos = list;
        this.localMatrix = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GradientShaderDescriptor copy$default(GradientShaderDescriptor gradientShaderDescriptor, long j, long j2, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = gradientShaderDescriptor.tileMode;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = gradientShaderDescriptor.gradFlags;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            list = gradientShaderDescriptor.colors;
        }
        List list4 = list;
        if ((i & 8) != 0) {
            list2 = gradientShaderDescriptor.pos;
        }
        List list5 = list2;
        if ((i & 16) != 0) {
            list3 = gradientShaderDescriptor.localMatrix;
        }
        return gradientShaderDescriptor.copy(j3, j4, list4, list5, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTileMode() {
        return this.tileMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGradFlags() {
        return this.gradFlags;
    }

    public final List<Color4f> component3() {
        return this.colors;
    }

    public final List<Float> component4() {
        return this.pos;
    }

    public final List<Float> component5() {
        return this.localMatrix;
    }

    public final GradientShaderDescriptor copy(long tileMode, long gradFlags, List<Color4f> colors, List<Float> pos, List<Float> localMatrix) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new GradientShaderDescriptor(tileMode, gradFlags, colors, pos, localMatrix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GradientShaderDescriptor)) {
            return false;
        }
        GradientShaderDescriptor gradientShaderDescriptor = (GradientShaderDescriptor) other;
        return this.tileMode == gradientShaderDescriptor.tileMode && this.gradFlags == gradientShaderDescriptor.gradFlags && Intrinsics.areEqual(this.colors, gradientShaderDescriptor.colors) && Intrinsics.areEqual(this.pos, gradientShaderDescriptor.pos) && Intrinsics.areEqual(this.localMatrix, gradientShaderDescriptor.localMatrix);
    }

    public final List<Color4f> getColors() {
        return this.colors;
    }

    public final long getGradFlags() {
        return this.gradFlags;
    }

    public final List<Float> getLocalMatrix() {
        return this.localMatrix;
    }

    public final List<Float> getPos() {
        return this.pos;
    }

    public final long getTileMode() {
        return this.tileMode;
    }

    public int hashCode() {
        int iHashCode = (this.colors.hashCode() + ((Long.hashCode(this.gradFlags) + (Long.hashCode(this.tileMode) * 31)) * 31)) * 31;
        List<Float> list = this.pos;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Float> list2 = this.localMatrix;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return b.a("GradientShaderDescriptor(tileMode=").append(this.tileMode).append(", gradFlags=").append(this.gradFlags).append(", colors=").append(this.colors).append(", pos=").append(this.pos).append(", localMatrix=").append(this.localMatrix).append(')').toString();
    }
}
