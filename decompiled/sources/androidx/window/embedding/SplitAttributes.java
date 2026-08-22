package androidx.window.embedding;

import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import androidx.window.embedding.EmbeddingAnimationParams;
import androidx.window.embedding.SplitAttributes;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplitAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB1\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/window/embedding/SplitAttributes;", "", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "layoutDirection", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "animationParams", "Landroidx/window/embedding/EmbeddingAnimationParams;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "<init>", "(Landroidx/window/embedding/SplitAttributes$SplitType;Landroidx/window/embedding/SplitAttributes$LayoutDirection;Landroidx/window/embedding/EmbeddingAnimationParams;Landroidx/window/embedding/DividerAttributes;)V", "getSplitType", "()Landroidx/window/embedding/SplitAttributes$SplitType;", "getLayoutDirection", "()Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "getAnimationParams", "()Landroidx/window/embedding/EmbeddingAnimationParams;", "getDividerAttributes", "()Landroidx/window/embedding/DividerAttributes;", "hashCode", "", "equals", "", "other", InAppPurchaseConstants.METHOD_TO_STRING, "", "SplitType", "LayoutDirection", "Companion", "Builder", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SplitAttributes {
    private static final String TAG = "SplitAttributes";
    private final EmbeddingAnimationParams animationParams;
    private final DividerAttributes dividerAttributes;
    private final LayoutDirection layoutDirection;
    private final SplitType splitType;

    public /* synthetic */ SplitAttributes(SplitType splitType, LayoutDirection layoutDirection, EmbeddingAnimationParams embeddingAnimationParams, DividerAttributes dividerAttributes, DefaultConstructorMarker defaultConstructorMarker) {
        this(splitType, layoutDirection, embeddingAnimationParams, dividerAttributes);
    }

    private SplitAttributes(SplitType splitType, LayoutDirection layoutDirection, EmbeddingAnimationParams embeddingAnimationParams, DividerAttributes dividerAttributes) {
        this.splitType = splitType;
        this.layoutDirection = layoutDirection;
        this.animationParams = embeddingAnimationParams;
        this.dividerAttributes = dividerAttributes;
    }

    /* synthetic */ SplitAttributes(SplitType splitType, LayoutDirection layoutDirection, EmbeddingAnimationParams embeddingAnimationParams, DividerAttributes dividerAttributes, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SplitType.SPLIT_TYPE_EQUAL : splitType, (i & 2) != 0 ? LayoutDirection.LOCALE : layoutDirection, (i & 4) != 0 ? new EmbeddingAnimationParams.Builder().build() : embeddingAnimationParams, (i & 8) != 0 ? DividerAttributes.NO_DIVIDER : dividerAttributes);
    }

    public final SplitType getSplitType() {
        return this.splitType;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final EmbeddingAnimationParams getAnimationParams() {
        return this.animationParams;
    }

    public final DividerAttributes getDividerAttributes() {
        return this.dividerAttributes;
    }

    /* JADX INFO: compiled from: SplitAttributes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/SplitAttributes$SplitType;", "", "description", "", "value", "", "<init>", "(Ljava/lang/String;F)V", "getDescription$window_release", "()Ljava/lang/String;", "getValue$window_release", "()F", InAppPurchaseConstants.METHOD_TO_STRING, "equals", "", "other", "hashCode", "", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SplitType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SplitType SPLIT_TYPE_EQUAL;
        public static final SplitType SPLIT_TYPE_EXPAND;
        public static final SplitType SPLIT_TYPE_HINGE;
        private final String description;
        private final float value;

        @JvmStatic
        public static final SplitType ratio(float f2) {
            return INSTANCE.ratio(f2);
        }

        public SplitType(String description, float f2) {
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
            this.value = f2;
        }

        /* JADX INFO: renamed from: getDescription$window_release, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: getValue$window_release, reason: from getter */
        public final float getValue() {
            return this.value;
        }

        public String toString() {
            return this.description;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof SplitType)) {
                return false;
            }
            SplitType splitType = (SplitType) other;
            return this.value == splitType.value && Intrinsics.areEqual(this.description, splitType.description);
        }

        public int hashCode() {
            return this.description.hashCode() + (Float.hashCode(this.value) * 31);
        }

        /* JADX INFO: compiled from: SplitAttributes.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0006H\u0007J\u0017\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\fR\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/window/embedding/SplitAttributes$SplitType$Companion;", "", "<init>", "()V", "ratio", "Landroidx/window/embedding/SplitAttributes$SplitType;", "", "SPLIT_TYPE_EXPAND", "SPLIT_TYPE_EQUAL", "SPLIT_TYPE_HINGE", "buildSplitTypeFromValue", "value", "buildSplitTypeFromValue$window_release", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SplitType ratio(final float ratio) {
                SpecificationComputer.Companion companion = SpecificationComputer.INSTANCE;
                Float fValueOf = Float.valueOf(ratio);
                String str = SplitAttributes.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Object objCompute = SpecificationComputer.Companion.startSpecification$default(companion, fValueOf, str, VerificationMode.STRICT, null, 4, null).require("Ratio must be in range (0.0, 1.0). Use SplitType.expandContainers() instead of 0 or 1.", new Function1() { // from class: androidx.window.embedding.SplitAttributes$SplitType$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SplitAttributes.SplitType.Companion.ratio$lambda$0(ratio, ((Float) obj).floatValue()));
                    }
                }).compute();
                Intrinsics.checkNotNull(objCompute);
                float fFloatValue = ((Number) objCompute).floatValue();
                return new SplitType("ratio:" + fFloatValue, fFloatValue);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean ratio$lambda$0(float f2, float f3) {
                double d2 = f2;
                return 0.0d <= d2 && d2 <= 1.0d && !ArraysKt.contains(new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)}, Float.valueOf(f2));
            }

            public final SplitType buildSplitTypeFromValue$window_release(float value) {
                if (value == SplitType.SPLIT_TYPE_EXPAND.getValue()) {
                    return SplitType.SPLIT_TYPE_EXPAND;
                }
                return ratio(value);
            }
        }

        static {
            Companion companion = new Companion(null);
            INSTANCE = companion;
            SPLIT_TYPE_EXPAND = new SplitType("expandContainers", 0.0f);
            SPLIT_TYPE_EQUAL = companion.ratio(0.5f);
            SPLIT_TYPE_HINGE = new SplitType("hinge", -1.0f);
        }
    }

    /* JADX INFO: compiled from: SplitAttributes.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "", "description", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getValue$window_release", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "equals", "", "other", "hashCode", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LayoutDirection {
        private final String description;
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final LayoutDirection LOCALE = new LayoutDirection("LOCALE", 0);
        public static final LayoutDirection LEFT_TO_RIGHT = new LayoutDirection("LEFT_TO_RIGHT", 1);
        public static final LayoutDirection RIGHT_TO_LEFT = new LayoutDirection("RIGHT_TO_LEFT", 2);
        public static final LayoutDirection TOP_TO_BOTTOM = new LayoutDirection("TOP_TO_BOTTOM", 3);
        public static final LayoutDirection BOTTOM_TO_TOP = new LayoutDirection("BOTTOM_TO_TOP", 4);

        private LayoutDirection(String str, int i) {
            this.description = str;
            this.value = i;
        }

        /* JADX INFO: renamed from: getValue$window_release, reason: from getter */
        public final int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: toString, reason: from getter */
        public String getDescription() {
            return this.description;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof LayoutDirection)) {
                return false;
            }
            LayoutDirection layoutDirection = (LayoutDirection) other;
            return Intrinsics.areEqual(this.description, layoutDirection.description) && this.value == layoutDirection.value;
        }

        public int hashCode() {
            return (this.description.hashCode() * 31) + this.value;
        }

        /* JADX INFO: compiled from: SplitAttributes.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/window/embedding/SplitAttributes$LayoutDirection$Companion;", "", "<init>", "()V", "LOCALE", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "TOP_TO_BOTTOM", "BOTTOM_TO_TOP", "getLayoutDirectionFromValue", "value", "", "getLayoutDirectionFromValue$window_release", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LayoutDirection getLayoutDirectionFromValue$window_release(int value) {
                if (value == LayoutDirection.LEFT_TO_RIGHT.getValue()) {
                    return LayoutDirection.LEFT_TO_RIGHT;
                }
                if (value == LayoutDirection.RIGHT_TO_LEFT.getValue()) {
                    return LayoutDirection.RIGHT_TO_LEFT;
                }
                if (value == LayoutDirection.LOCALE.getValue()) {
                    return LayoutDirection.LOCALE;
                }
                if (value == LayoutDirection.TOP_TO_BOTTOM.getValue()) {
                    return LayoutDirection.TOP_TO_BOTTOM;
                }
                if (value == LayoutDirection.BOTTOM_TO_TOP.getValue()) {
                    return LayoutDirection.BOTTOM_TO_TOP;
                }
                throw new IllegalArgumentException("Undefined value:" + value);
            }
        }
    }

    public int hashCode() {
        return (((((this.splitType.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.animationParams.hashCode()) * 31) + this.dividerAttributes.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SplitAttributes)) {
            return false;
        }
        SplitAttributes splitAttributes = (SplitAttributes) other;
        return Intrinsics.areEqual(this.splitType, splitAttributes.splitType) && Intrinsics.areEqual(this.layoutDirection, splitAttributes.layoutDirection) && Intrinsics.areEqual(this.animationParams, splitAttributes.animationParams) && Intrinsics.areEqual(this.dividerAttributes, splitAttributes.dividerAttributes);
    }

    public String toString() {
        return "SplitAttributes:{splitType=" + this.splitType + ", layoutDir=" + this.layoutDirection + ", animationParams=" + this.animationParams + ", dividerAttributes=" + this.dividerAttributes + " }";
    }

    /* JADX INFO: compiled from: SplitAttributes.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\fH\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/embedding/SplitAttributes$Builder;", "", "<init>", "()V", "original", "Landroidx/window/embedding/SplitAttributes;", "(Landroidx/window/embedding/SplitAttributes;)V", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "layoutDirection", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "animationParams", "Landroidx/window/embedding/EmbeddingAnimationParams;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "setSplitType", "type", "setLayoutDirection", "setAnimationParams", NativeProtocol.WEB_DIALOG_PARAMS, "setDividerAttributes", InAppPurchaseConstants.METHOD_BUILD, "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private EmbeddingAnimationParams animationParams;
        private DividerAttributes dividerAttributes;
        private LayoutDirection layoutDirection;
        private SplitType splitType;

        public Builder() {
            this.splitType = SplitType.SPLIT_TYPE_EQUAL;
            this.layoutDirection = LayoutDirection.LOCALE;
            this.animationParams = new EmbeddingAnimationParams.Builder().build();
            this.dividerAttributes = DividerAttributes.NO_DIVIDER;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(SplitAttributes original) {
            this();
            Intrinsics.checkNotNullParameter(original, "original");
            setSplitType(original.getSplitType()).setLayoutDirection(original.getLayoutDirection()).setAnimationParams(original.getAnimationParams()).setDividerAttributes(original.getDividerAttributes());
        }

        public final Builder setSplitType(SplitType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.splitType = type;
            return this;
        }

        public final Builder setLayoutDirection(LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            this.layoutDirection = layoutDirection;
            return this;
        }

        public final Builder setAnimationParams(EmbeddingAnimationParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.animationParams = params;
            return this;
        }

        public final Builder setDividerAttributes(DividerAttributes dividerAttributes) {
            Intrinsics.checkNotNullParameter(dividerAttributes, "dividerAttributes");
            this.dividerAttributes = dividerAttributes;
            return this;
        }

        public final SplitAttributes build() {
            return new SplitAttributes(this.splitType, this.layoutDirection, this.animationParams, this.dividerAttributes, null);
        }
    }
}
