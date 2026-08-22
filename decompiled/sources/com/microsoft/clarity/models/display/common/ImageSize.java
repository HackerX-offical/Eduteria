package com.microsoft.clarity.models.display.common;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Lcom/microsoft/clarity/models/display/common/ImageSize;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "Lkotlin/UInt;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-pVg5ArA", "()I", "I", "getWidth-pVg5ArA", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageSize {
    private final int height;
    private final int width;

    private ImageSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public /* synthetic */ ImageSize(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name and from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name and from getter */
    public final int getWidth() {
        return this.width;
    }
}
