package androidx.compose.animation;

import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001%J\u0017\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦\u0004JL\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0014\u0010\u0015JL\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u0017*\u00020\u001c8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0082\u0001\u0001&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006'À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/Transition$Segment;", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition$Companion;", "getKeepUntilTransitionsFinished$annotations", "(Landroidx/compose/animation/ExitTransition$Companion;)V", "getKeepUntilTransitionsFinished", "(Landroidx/compose/animation/ExitTransition$Companion;)Landroidx/compose/animation/ExitTransition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "SlideDirection", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AnimatedContentTransitionScope<S> extends Transition.Segment<S> {
    static /* synthetic */ void getKeepUntilTransitionsFinished$annotations(ExitTransition.Companion companion) {
    }

    Alignment getContentAlignment();

    /* JADX INFO: renamed from: slideIntoContainer-mOhB8PU, reason: not valid java name */
    EnterTransition mo47slideIntoContainermOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> initialOffset);

    /* JADX INFO: renamed from: slideOutOfContainer-mOhB8PU, reason: not valid java name */
    ExitTransition mo48slideOutOfContainermOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> targetOffset);

    ContentTransform using(ContentTransform contentTransform, SizeTransform sizeTransform);

    /* JADX INFO: compiled from: AnimatedContent.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class SlideDirection {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Left = m50constructorimpl(0);
        private static final int Right = m50constructorimpl(1);
        private static final int Up = m50constructorimpl(2);
        private static final int Down = m50constructorimpl(3);
        private static final int Start = m50constructorimpl(4);
        private static final int End = m50constructorimpl(5);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ SlideDirection m49boximpl(int i) {
            return new SlideDirection(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m50constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m51equalsimpl(int i, Object obj) {
            return (obj instanceof SlideDirection) && i == ((SlideDirection) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m52equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m53hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object other) {
            return m51equalsimpl(this.value, other);
        }

        public int hashCode() {
            return m53hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: AnimatedContent.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection$Companion;", "", "<init>", "()V", "Left", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "getLeft-DKzdypw", "()I", "I", "Right", "getRight-DKzdypw", "Up", "getUp-DKzdypw", "Down", "getDown-DKzdypw", "Start", "getStart-DKzdypw", "End", "getEnd-DKzdypw", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getLeft-DKzdypw, reason: not valid java name */
            public final int m58getLeftDKzdypw() {
                return SlideDirection.Left;
            }

            /* JADX INFO: renamed from: getRight-DKzdypw, reason: not valid java name */
            public final int m59getRightDKzdypw() {
                return SlideDirection.Right;
            }

            /* JADX INFO: renamed from: getUp-DKzdypw, reason: not valid java name */
            public final int m61getUpDKzdypw() {
                return SlideDirection.Up;
            }

            /* JADX INFO: renamed from: getDown-DKzdypw, reason: not valid java name */
            public final int m56getDownDKzdypw() {
                return SlideDirection.Down;
            }

            /* JADX INFO: renamed from: getStart-DKzdypw, reason: not valid java name */
            public final int m60getStartDKzdypw() {
                return SlideDirection.Start;
            }

            /* JADX INFO: renamed from: getEnd-DKzdypw, reason: not valid java name */
            public final int m57getEndDKzdypw() {
                return SlideDirection.End;
            }
        }

        private /* synthetic */ SlideDirection(int i) {
            this.value = i;
        }

        public String toString() {
            return m54toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m54toStringimpl(int i) {
            return m52equalsimpl0(i, Left) ? "Left" : m52equalsimpl0(i, Right) ? "Right" : m52equalsimpl0(i, Up) ? "Up" : m52equalsimpl0(i, Down) ? "Down" : m52equalsimpl0(i, Start) ? "Start" : m52equalsimpl0(i, End) ? "End" : "Invalid";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: slideIntoContainer-mOhB8PU$default, reason: not valid java name */
    static /* synthetic */ EnterTransition m45slideIntoContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideIntoContainer-mOhB8PU");
        }
        if ((i2 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m8949boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScope$slideIntoContainer$1
                public final Integer invoke(int i3) {
                    return Integer.valueOf(i3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return animatedContentTransitionScope.mo47slideIntoContainermOhB8PU(i, finiteAnimationSpec, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: slideOutOfContainer-mOhB8PU$default, reason: not valid java name */
    static /* synthetic */ ExitTransition m46slideOutOfContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideOutOfContainer-mOhB8PU");
        }
        if ((i2 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m8949boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScope$slideOutOfContainer$1
                public final Integer invoke(int i3) {
                    return Integer.valueOf(i3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return animatedContentTransitionScope.mo48slideOutOfContainermOhB8PU(i, finiteAnimationSpec, function1);
    }

    default ExitTransition getKeepUntilTransitionsFinished(ExitTransition.Companion companion) {
        return companion.getKeepUntilTransitionsFinished$animation();
    }
}
