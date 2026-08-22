package com.microsoft.clarity.models.viewhierarchy;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ViewNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B»\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001dJ\u000e\u0010B\u001a\u00020C2\u0006\u0010\u0017\u001a\u00020\u0000J\b\u0010D\u001a\u00020\u0002H\u0016R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00000\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u001a\u0010\u001b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010(\"\u0004\b1\u00102R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010(R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010.R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.¨\u0006E"}, d2 = {"Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$ViewNode;", "id", "", "type", "", "renderNodeId", "", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "viewX", "viewY", "viewWidth", "viewHeight", "visible", "", "clickable", "ignoreClicks", "isWebView", "backgroundColor", ViewHierarchyConstants.VIEW_KEY, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "text", "isMasked", "fragmentName", "(ILjava/lang/String;JIIIIIIIIZZZZLjava/lang/Integer;Ljava/lang/ref/WeakReference;Ljava/lang/String;ZLjava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getClickable", "()Z", "getFragmentName", "()Ljava/lang/String;", "setFragmentName", "(Ljava/lang/String;)V", "getHeight", "()I", "getId", "getIgnoreClicks", "setMasked", "(Z)V", "getRenderNodeId", "()J", "getText", "setText", "getType", "getView", "()Ljava/lang/ref/WeakReference;", "getViewHeight", "getViewWidth", "getViewX", "getViewY", "getVisible", "getWidth", "getX", "getY", "addChildView", "", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewNode implements IProtoModel<MutationPayload$ViewNode> {
    private final Integer backgroundColor;
    private List<ViewNode> children;
    private final boolean clickable;
    private transient String fragmentName;
    private final int height;
    private final int id;
    private final boolean ignoreClicks;
    private boolean isMasked;
    private final boolean isWebView;
    private final long renderNodeId;
    private transient String text;
    private final String type;
    private final transient WeakReference<View> view;
    private final int viewHeight;
    private final int viewWidth;
    private final int viewX;
    private final int viewY;
    private final boolean visible;
    private final int width;
    private final int x;
    private final int y;

    public ViewNode(int i, String type, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, boolean z3, boolean z4, Integer num, WeakReference<View> weakReference, String text, boolean z5, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = i;
        this.type = type;
        this.renderNodeId = j;
        this.x = i2;
        this.y = i3;
        this.width = i4;
        this.height = i5;
        this.viewX = i6;
        this.viewY = i7;
        this.viewWidth = i8;
        this.viewHeight = i9;
        this.visible = z;
        this.clickable = z2;
        this.ignoreClicks = z3;
        this.isWebView = z4;
        this.backgroundColor = num;
        this.view = weakReference;
        this.text = text;
        this.isMasked = z5;
        this.fragmentName = str;
        this.children = new ArrayList();
    }

    public /* synthetic */ ViewNode(int i, String str, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, boolean z3, boolean z4, Integer num, WeakReference weakReference, String str2, boolean z5, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, j, i2, i3, i4, i5, i6, i7, i8, i9, z, z2, z3, z4, (i10 & 32768) != 0 ? null : num, (i10 & 65536) != 0 ? null : weakReference, (i10 & 131072) != 0 ? "" : str2, (i10 & 262144) != 0 ? false : z5, (i10 & 524288) != 0 ? null : str3);
    }

    public final void addChildView(ViewNode view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.children.add(view);
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<ViewNode> getChildren() {
        return this.children;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final String getFragmentName() {
        return this.fragmentName;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getIgnoreClicks() {
        return this.ignoreClicks;
    }

    public final long getRenderNodeId() {
        return this.renderNodeId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final WeakReference<View> getView() {
        return this.view;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final int getViewX() {
        return this.viewX;
    }

    public final int getViewY() {
        return this.viewY;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: isMasked, reason: from getter */
    public final boolean getIsMasked() {
        return this.isMasked;
    }

    /* JADX INFO: renamed from: isWebView, reason: from getter */
    public final boolean getIsWebView() {
        return this.isWebView;
    }

    public final void setChildren(List<ViewNode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.children = list;
    }

    public final void setFragmentName(String str) {
        this.fragmentName = str;
    }

    public final void setMasked(boolean z) {
        this.isMasked = z;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$ViewNode toProtobufInstance() {
        MutationPayload$ViewNode.a aVarD = MutationPayload$ViewNode.newBuilder().c(this.id).a(this.type).a(this.renderNodeId).i(this.x).j(this.y).h(this.width).b(this.height).f(this.viewX).g(this.viewY).e(this.viewWidth).d(this.viewHeight).e(this.visible).a(this.clickable).b(this.ignoreClicks).d(this.isWebView);
        List<ViewNode> list = this.children;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ViewNode) it.next()).toProtobufInstance());
        }
        MutationPayload$ViewNode.a aVarC = aVarD.a(arrayList).c(this.isMasked);
        Integer num = this.backgroundColor;
        if (num != null) {
            aVarC.a(num.intValue());
        }
        MutationPayload$ViewNode mutationPayload$ViewNodeBuild = aVarC.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$ViewNodeBuild, "builder.build()");
        return mutationPayload$ViewNodeBuild;
    }
}
