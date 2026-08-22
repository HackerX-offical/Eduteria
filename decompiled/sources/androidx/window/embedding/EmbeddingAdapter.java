package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.Bounds;
import androidx.window.core.PredicateAdapter;
import androidx.window.embedding.DividerAttributes;
import androidx.window.embedding.EmbeddingAdapter;
import androidx.window.embedding.EmbeddingAnimationBackground;
import androidx.window.embedding.EmbeddingAnimationParams;
import androidx.window.embedding.EmbeddingConfiguration;
import androidx.window.embedding.SplitAttributes;
import androidx.window.embedding.SplitRule;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.AnimationParams;
import androidx.window.extensions.embedding.DividerAttributes;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPinRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.reflection.JFunction2;
import androidx.window.reflection.Predicate2;
import com.facebook.internal.NativeProtocol;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* JADX INFO: compiled from: EmbeddingAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 d2\u00020\u0001:\u0004abcdB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019J\u0010\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0015\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0019H\u0000¢\u0006\u0002\b!J\u0015\u0010\u0018\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b!J\u0015\u0010\u0018\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b!J&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020%0*2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#0-J\u0010\u0010\u0018\u001a\u00020.2\u0006\u0010/\u001a\u00020+H\u0007J$\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\n\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0002J\u0016\u00108\u001a\u0002092\u0006\u00102\u001a\u0002032\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020%2\u0006\u0010$\u001a\u00020#J\r\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J$\u0010D\u001a\u00020E2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020F2\n\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0002J\u000e\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IJ\u001c\u0010J\u001a\u00020K2\u0006\u00104\u001a\u00020L2\n\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0002J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020N0M2\u0006\u00102\u001a\u0002032\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0MJ\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0003J\u0010\u0010U\u001a\u00020T2\u0006\u0010S\u001a\u00020RH\u0003J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0003J\u0010\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020\u0007H\u0003J\u0012\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020^H\u0007J\u0012\u0010_\u001a\u00020^2\b\u0010`\u001a\u0004\u0018\u00010\\H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006e"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "predicateAdapter", "Landroidx/window/core/PredicateAdapter;", "<init>", "(Landroidx/window/core/PredicateAdapter;)V", "extensionVersion", "", "getExtensionVersion", "()I", "api1Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "api2Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "api3Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "embeddingConfiguration", "Landroidx/window/embedding/EmbeddingConfiguration;", "getEmbeddingConfiguration$annotations", "()V", "getEmbeddingConfiguration", "()Landroidx/window/embedding/EmbeddingConfiguration;", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "translate", "", "Landroidx/window/embedding/SplitInfo;", "splitInfoList", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfo", "Landroidx/window/embedding/ActivityStack;", "activityStack", "Landroidx/window/extensions/embedding/ActivityStack;", "translate$window_release", "activityStacks", "Landroidx/window/embedding/SplitAttributes;", "splitAttributes", "Landroidx/window/extensions/embedding/SplitAttributes;", "Landroidx/window/embedding/ParentContainerInfo;", "parentContainerInfo", "Landroidx/window/extensions/embedding/ParentContainerInfo;", "translateSplitAttributesCalculator", "Landroidx/window/reflection/JFunction2;", "Landroidx/window/extensions/embedding/SplitAttributesCalculatorParams;", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", NativeProtocol.WEB_DIALOG_PARAMS, "translateSplitPairRule", "Landroidx/window/extensions/embedding/SplitPairRule;", "context", "Landroid/content/Context;", AMPExtension.Rule.ELEMENT, "Landroidx/window/embedding/SplitPairRule;", "predicateClass", "Ljava/lang/Class;", "translateSplitPinRule", "Landroidx/window/extensions/embedding/SplitPinRule;", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "translateSplitAttributes", "translateWindowAttributes", "Landroidx/window/extensions/embedding/WindowAttributes;", "translateWindowAttributes$window_release", "translateSplitType", "Landroidx/window/extensions/embedding/SplitAttributes$SplitType;", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "translateSplitPlaceholderRule", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitPlaceholderRule;", "translateFinishBehavior", "behavior", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "translateActivityRule", "Landroidx/window/extensions/embedding/ActivityRule;", "Landroidx/window/embedding/ActivityRule;", "", "Landroidx/window/extensions/embedding/EmbeddingRule;", "rules", "Landroidx/window/embedding/EmbeddingRule;", "translateToOemAnimationBackground", "Landroidx/window/extensions/embedding/AnimationBackground;", "animationBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "translateToJetpackAnimationBackground", "translateToOemAnimationResId", "animationSpec", "Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "translateToJetpackAnimationSpec", "animationResId", "translateToOemDividerAttributes", "Landroidx/window/extensions/embedding/DividerAttributes;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "translateToJetpackDividerAttributes", "oemDividerAttributes", "VendorApiLevel3Impl", "VendorApiLevel2Impl", "VendorApiLevel1Impl", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EmbeddingAdapter {
    private final VendorApiLevel1Impl api1Impl;
    private final VendorApiLevel2Impl api2Impl;
    private final VendorApiLevel3Impl api3Impl;
    private EmbeddingConfiguration embeddingConfiguration;
    private final PredicateAdapter predicateAdapter;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(EmbeddingAdapter.class).getSimpleName();
    private static final String RULE_TAG_PREFIX = "ae-gen:";
    private static final Binder INVALID_SPLIT_INFO_TOKEN = new Binder();

    public static /* synthetic */ void getEmbeddingConfiguration$annotations() {
    }

    public EmbeddingAdapter(PredicateAdapter predicateAdapter) {
        Intrinsics.checkNotNullParameter(predicateAdapter, "predicateAdapter");
        this.predicateAdapter = predicateAdapter;
        this.api1Impl = new VendorApiLevel1Impl(this, predicateAdapter);
        this.api2Impl = new VendorApiLevel2Impl();
        this.api3Impl = new VendorApiLevel3Impl();
    }

    private final int getExtensionVersion() {
        return WindowSdkExtensions.INSTANCE.getInstance().getExtensionVersion();
    }

    public final EmbeddingConfiguration getEmbeddingConfiguration() {
        return this.embeddingConfiguration;
    }

    public final void setEmbeddingConfiguration(EmbeddingConfiguration embeddingConfiguration) {
        this.embeddingConfiguration = embeddingConfiguration;
    }

    public final List<SplitInfo> translate(List<? extends androidx.window.extensions.embedding.SplitInfo> splitInfoList) {
        Intrinsics.checkNotNullParameter(splitInfoList, "splitInfoList");
        List<? extends androidx.window.extensions.embedding.SplitInfo> list = splitInfoList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(translate((androidx.window.extensions.embedding.SplitInfo) it.next()));
        }
        return arrayList;
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        int extensionVersion = getExtensionVersion();
        if (extensionVersion == 1) {
            return this.api1Impl.translateCompat(splitInfo);
        }
        if (extensionVersion == 2) {
            return this.api2Impl.translateCompat(splitInfo);
        }
        if (3 <= extensionVersion && extensionVersion < 5) {
            return this.api3Impl.translateCompat(splitInfo);
        }
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
        ActivityStack activityStackTranslate$window_release = translate$window_release(primaryActivityStack);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
        ActivityStack activityStackTranslate$window_release2 = translate$window_release(secondaryActivityStack);
        androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
        Intrinsics.checkNotNullExpressionValue(splitAttributes, "getSplitAttributes(...)");
        SplitAttributes splitAttributesTranslate$window_release = translate$window_release(splitAttributes);
        SplitInfo.Token splitInfoToken = splitInfo.getSplitInfoToken();
        Intrinsics.checkNotNullExpressionValue(splitInfoToken, "getSplitInfoToken(...)");
        return new SplitInfo(activityStackTranslate$window_release, activityStackTranslate$window_release2, splitAttributesTranslate$window_release, splitInfoToken);
    }

    public final ActivityStack translate$window_release(androidx.window.extensions.embedding.ActivityStack activityStack) {
        Intrinsics.checkNotNullParameter(activityStack, "activityStack");
        int extensionVersion = getExtensionVersion();
        if (1 <= extensionVersion && extensionVersion < 5) {
            return this.api1Impl.translateCompat(activityStack);
        }
        List activities = activityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities, "getActivities(...)");
        return new ActivityStack(activities, activityStack.isEmpty(), activityStack.getActivityStackToken());
    }

    public final List<ActivityStack> translate$window_release(List<? extends androidx.window.extensions.embedding.ActivityStack> activityStacks) {
        Intrinsics.checkNotNullParameter(activityStacks, "activityStacks");
        List<? extends androidx.window.extensions.embedding.ActivityStack> list = activityStacks;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(translate$window_release((androidx.window.extensions.embedding.ActivityStack) it.next()));
        }
        return arrayList;
    }

    public final SplitAttributes translate$window_release(androidx.window.extensions.embedding.SplitAttributes splitAttributes) {
        SplitAttributes.SplitType splitTypeRatio;
        SplitAttributes.LayoutDirection layoutDirection;
        Intrinsics.checkNotNullParameter(splitAttributes, "splitAttributes");
        SplitAttributes.Builder builder = new SplitAttributes.Builder();
        SplitAttributes.SplitType.RatioSplitType splitType = splitAttributes.getSplitType();
        Intrinsics.checkNotNullExpressionValue(splitType, "getSplitType(...)");
        if (splitType instanceof SplitAttributes.SplitType.HingeSplitType) {
            splitTypeRatio = SplitAttributes.SplitType.SPLIT_TYPE_HINGE;
        } else if (splitType instanceof SplitAttributes.SplitType.ExpandContainersSplitType) {
            splitTypeRatio = SplitAttributes.SplitType.SPLIT_TYPE_EXPAND;
        } else {
            if (!(splitType instanceof SplitAttributes.SplitType.RatioSplitType)) {
                throw new IllegalArgumentException("Unknown split type: " + splitType);
            }
            splitTypeRatio = SplitAttributes.SplitType.INSTANCE.ratio(splitType.getRatio());
        }
        SplitAttributes.Builder splitType2 = builder.setSplitType(splitTypeRatio);
        int layoutDirection2 = splitAttributes.getLayoutDirection();
        if (layoutDirection2 == 0) {
            layoutDirection = SplitAttributes.LayoutDirection.LEFT_TO_RIGHT;
        } else if (layoutDirection2 == 1) {
            layoutDirection = SplitAttributes.LayoutDirection.RIGHT_TO_LEFT;
        } else if (layoutDirection2 == 3) {
            layoutDirection = SplitAttributes.LayoutDirection.LOCALE;
        } else if (layoutDirection2 == 4) {
            layoutDirection = SplitAttributes.LayoutDirection.TOP_TO_BOTTOM;
        } else if (layoutDirection2 == 5) {
            layoutDirection = SplitAttributes.LayoutDirection.BOTTOM_TO_TOP;
        } else {
            throw new IllegalArgumentException("Unknown layout direction: " + layoutDirection2);
        }
        SplitAttributes.Builder layoutDirection3 = splitType2.setLayoutDirection(layoutDirection);
        int extensionVersion = getExtensionVersion();
        if (5 <= extensionVersion && extensionVersion < 7) {
            EmbeddingAnimationParams.Builder builder2 = new EmbeddingAnimationParams.Builder();
            AnimationBackground animationBackground = splitAttributes.getAnimationBackground();
            Intrinsics.checkNotNullExpressionValue(animationBackground, "getAnimationBackground(...)");
            layoutDirection3.setAnimationParams(builder2.setAnimationBackground(translateToJetpackAnimationBackground(animationBackground)).build());
        }
        if (getExtensionVersion() >= 7) {
            EmbeddingAnimationParams.Builder builder3 = new EmbeddingAnimationParams.Builder();
            AnimationBackground animationBackground2 = splitAttributes.getAnimationParams().getAnimationBackground();
            Intrinsics.checkNotNullExpressionValue(animationBackground2, "getAnimationBackground(...)");
            layoutDirection3.setAnimationParams(builder3.setAnimationBackground(translateToJetpackAnimationBackground(animationBackground2)).setOpenAnimation(translateToJetpackAnimationSpec(splitAttributes.getAnimationParams().getOpenAnimationResId())).setCloseAnimation(translateToJetpackAnimationSpec(splitAttributes.getAnimationParams().getCloseAnimationResId())).setChangeAnimation(translateToJetpackAnimationSpec(splitAttributes.getAnimationParams().getChangeAnimationResId())).build());
        }
        if (getExtensionVersion() >= 6) {
            layoutDirection3.setDividerAttributes(translateToJetpackDividerAttributes(splitAttributes.getDividerAttributes()));
        }
        return layoutDirection3.build();
    }

    public final ParentContainerInfo translate$window_release(androidx.window.extensions.embedding.ParentContainerInfo parentContainerInfo) {
        Intrinsics.checkNotNullParameter(parentContainerInfo, "parentContainerInfo");
        Configuration configuration = parentContainerInfo.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        DensityCompatHelper companion = DensityCompatHelper.INSTANCE.getInstance();
        Configuration configuration2 = parentContainerInfo.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "getConfiguration(...)");
        WindowMetrics windowMetrics = parentContainerInfo.getWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(windowMetrics, "getWindowMetrics(...)");
        float fDensity = companion.density(configuration2, windowMetrics);
        WindowMetricsCalculator.Companion companion2 = WindowMetricsCalculator.INSTANCE;
        WindowMetrics windowMetrics2 = parentContainerInfo.getWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(windowMetrics2, "getWindowMetrics(...)");
        androidx.window.layout.WindowMetrics windowMetricsTranslateWindowMetrics$window_release = companion2.translateWindowMetrics$window_release(windowMetrics2, fDensity);
        Bounds bounds = new Bounds(windowMetricsTranslateWindowMetrics$window_release.getBounds());
        ExtensionsWindowLayoutInfoAdapter extensionsWindowLayoutInfoAdapter = ExtensionsWindowLayoutInfoAdapter.INSTANCE;
        WindowLayoutInfo windowLayoutInfo = parentContainerInfo.getWindowLayoutInfo();
        Intrinsics.checkNotNullExpressionValue(windowLayoutInfo, "getWindowLayoutInfo(...)");
        return new ParentContainerInfo(bounds, extensionsWindowLayoutInfoAdapter.translate$window_release(windowMetricsTranslateWindowMetrics$window_release, windowLayoutInfo), configuration, fDensity);
    }

    public final JFunction2<androidx.window.extensions.embedding.SplitAttributesCalculatorParams, androidx.window.extensions.embedding.SplitAttributes> translateSplitAttributesCalculator(final Function1<? super SplitAttributesCalculatorParams, SplitAttributes> calculator) {
        Intrinsics.checkNotNullParameter(calculator, "calculator");
        return new JFunction2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda1
            @Override // androidx.window.reflection.JFunction2
            public final Object apply(Object obj) {
                return EmbeddingAdapter.translateSplitAttributesCalculator$lambda$1(this.f$0, calculator, (androidx.window.extensions.embedding.SplitAttributesCalculatorParams) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributesCalculator$lambda$1(EmbeddingAdapter embeddingAdapter, Function1 function1, androidx.window.extensions.embedding.SplitAttributesCalculatorParams oemParams) {
        Intrinsics.checkNotNullParameter(oemParams, "oemParams");
        return embeddingAdapter.translateSplitAttributes((SplitAttributes) function1.invoke(embeddingAdapter.translate(oemParams)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.window.embedding.SplitAttributesCalculatorParams translate(androidx.window.extensions.embedding.SplitAttributesCalculatorParams r10) {
        /*
            r9 = this;
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = r9
            androidx.window.embedding.EmbeddingAdapter r0 = (androidx.window.embedding.EmbeddingAdapter) r0
            android.view.WindowMetrics r0 = r10.getParentWindowMetrics()
            java.lang.String r1 = "getParentWindowMetrics(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.content.res.Configuration r4 = r10.getParentConfiguration()
            java.lang.String r1 = "getParentConfiguration(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            androidx.window.extensions.layout.WindowLayoutInfo r1 = r10.getParentWindowLayoutInfo()
            java.lang.String r2 = "getParentWindowLayoutInfo(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            androidx.window.extensions.embedding.SplitAttributes r2 = r10.getDefaultSplitAttributes()
            java.lang.String r3 = "getDefaultSplitAttributes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r7 = r10.areDefaultConstraintsSatisfied()
            java.lang.String r3 = r10.getSplitRuleTag()
            if (r3 == 0) goto L4b
            androidx.window.embedding.EmbeddingAdapter$Companion r3 = androidx.window.embedding.EmbeddingAdapter.INSTANCE
            java.lang.String r5 = r10.getSplitRuleTag()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            boolean r3 = r3.isTagGenerated(r5)
            if (r3 == 0) goto L46
            goto L4b
        L46:
            java.lang.String r10 = r10.getSplitRuleTag()
            goto L4c
        L4b:
            r10 = 0
        L4c:
            r8 = r10
            androidx.window.layout.util.DensityCompatHelper$Companion r10 = androidx.window.layout.util.DensityCompatHelper.INSTANCE
            androidx.window.layout.util.DensityCompatHelper r10 = r10.getInstance()
            float r10 = r10.density(r4, r0)
            androidx.window.layout.WindowMetricsCalculator$Companion r3 = androidx.window.layout.WindowMetricsCalculator.INSTANCE
            androidx.window.layout.WindowMetrics r3 = r3.translateWindowMetrics$window_release(r0, r10)
            r10 = r2
            androidx.window.embedding.SplitAttributesCalculatorParams r2 = new androidx.window.embedding.SplitAttributesCalculatorParams
            androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter r0 = androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter.INSTANCE
            androidx.window.layout.WindowLayoutInfo r5 = r0.translate$window_release(r3, r1)
            androidx.window.embedding.SplitAttributes r6 = r9.translate$window_release(r10)
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.EmbeddingAdapter.translate(androidx.window.extensions.embedding.SplitAttributesCalculatorParams):androidx.window.embedding.SplitAttributesCalculatorParams");
    }

    private final androidx.window.extensions.embedding.SplitPairRule translateSplitPairRule(final Context context, final SplitPairRule rule, Class<?> predicateClass) {
        if (getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPairRuleCompat(context, rule, predicateClass);
        }
        Predicate2 predicate2 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda5
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPairRule$lambda$4(rule, (Pair) obj);
            }
        };
        Predicate2 predicate22 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda6
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPairRule$lambda$6(rule, (Pair) obj);
            }
        };
        Predicate2 predicate23 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda7
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPairRule$lambda$7(rule, context, (WindowMetrics) obj);
            }
        };
        String tag = rule.getTag();
        SplitPairRule.Builder shouldClearTop = new SplitPairRule.Builder(predicate2, predicate22, predicate23).setDefaultSplitAttributes(translateSplitAttributes(rule.getDefaultSplitAttributes())).setFinishPrimaryWithSecondary(translateFinishBehavior(rule.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(translateFinishBehavior(rule.getFinishSecondaryWithPrimary())).setShouldClearTop(rule.getClearTop());
        Intrinsics.checkNotNullExpressionValue(shouldClearTop, "setShouldClearTop(...)");
        if (tag == null) {
            tag = INSTANCE.generateTag(rule);
        }
        shouldClearTop.setTag(tag);
        androidx.window.extensions.embedding.SplitPairRule splitPairRuleBuild = shouldClearTop.build();
        Intrinsics.checkNotNullExpressionValue(splitPairRuleBuild, "build(...)");
        return splitPairRuleBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateSplitPairRule$lambda$4(SplitPairRule splitPairRule, Pair activitiesPair) {
        Intrinsics.checkNotNullParameter(activitiesPair, "activitiesPair");
        Set<SplitPairFilter> filters = splitPairRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (SplitPairFilter splitPairFilter : filters) {
            Object first = activitiesPair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Object second = activitiesPair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            if (splitPairFilter.matchesActivityPair((Activity) first, (Activity) second)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateSplitPairRule$lambda$6(SplitPairRule splitPairRule, Pair activityIntentPair) {
        Intrinsics.checkNotNullParameter(activityIntentPair, "activityIntentPair");
        Set<SplitPairFilter> filters = splitPairRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (SplitPairFilter splitPairFilter : filters) {
            Object first = activityIntentPair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Object second = activityIntentPair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            if (splitPairFilter.matchesActivityIntentPair((Activity) first, (Intent) second)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateSplitPairRule$lambda$7(SplitPairRule splitPairRule, Context context, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        return splitPairRule.checkParentMetrics$window_release(context, windowMetrics);
    }

    public final androidx.window.extensions.embedding.SplitPinRule translateSplitPinRule(final Context context, final SplitPinRule splitPinRule) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(splitPinRule, "splitPinRule");
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(5);
        SplitPinRule.Builder builder = new SplitPinRule.Builder(translateSplitAttributes(splitPinRule.getDefaultSplitAttributes()), new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda0
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPinRule$lambda$8(splitPinRule, context, (WindowMetrics) obj);
            }
        });
        builder.setSticky(splitPinRule.getIsSticky());
        String tag = splitPinRule.getTag();
        if (tag == null) {
            tag = INSTANCE.generateTag(splitPinRule);
        }
        builder.setTag(tag);
        androidx.window.extensions.embedding.SplitPinRule splitPinRuleBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(splitPinRuleBuild, "build(...)");
        return splitPinRuleBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateSplitPinRule$lambda$8(SplitPinRule splitPinRule, Context context, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        return splitPinRule.checkParentMetrics$window_release(context, windowMetrics);
    }

    public final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributes(SplitAttributes splitAttributes) {
        int i;
        Intrinsics.checkNotNullParameter(splitAttributes, "splitAttributes");
        if (getExtensionVersion() < 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        SplitAttributes.Builder splitType = new SplitAttributes.Builder().setSplitType(translateSplitType(splitAttributes.getSplitType()));
        SplitAttributes.LayoutDirection layoutDirection = splitAttributes.getLayoutDirection();
        if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LOCALE)) {
            i = 3;
        } else if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LEFT_TO_RIGHT)) {
            i = 0;
        } else if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.RIGHT_TO_LEFT)) {
            i = 1;
        } else if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.TOP_TO_BOTTOM)) {
            i = 4;
        } else {
            if (!Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.BOTTOM_TO_TOP)) {
                throw new IllegalArgumentException("Unsupported layoutDirection:" + splitAttributes + ".layoutDirection");
            }
            i = 5;
        }
        SplitAttributes.Builder layoutDirection2 = splitType.setLayoutDirection(i);
        Intrinsics.checkNotNullExpressionValue(layoutDirection2, "setLayoutDirection(...)");
        if (getExtensionVersion() >= 5) {
            layoutDirection2.setWindowAttributes(translateWindowAttributes$window_release());
        }
        int extensionVersion = getExtensionVersion();
        if (5 <= extensionVersion && extensionVersion < 7) {
            layoutDirection2.setAnimationBackground(translateToOemAnimationBackground(splitAttributes.getAnimationParams().getAnimationBackground()));
        }
        if (getExtensionVersion() >= 7) {
            AnimationParams animationParamsBuild = new AnimationParams.Builder().setAnimationBackground(translateToOemAnimationBackground(splitAttributes.getAnimationParams().getAnimationBackground())).setOpenAnimationResId(translateToOemAnimationResId(splitAttributes.getAnimationParams().getOpenAnimation())).setCloseAnimationResId(translateToOemAnimationResId(splitAttributes.getAnimationParams().getCloseAnimation())).setChangeAnimationResId(translateToOemAnimationResId(splitAttributes.getAnimationParams().getChangeAnimation())).build();
            Intrinsics.checkNotNullExpressionValue(animationParamsBuild, "build(...)");
            layoutDirection2.setAnimationParams(animationParamsBuild);
        }
        if (getExtensionVersion() >= 6) {
            layoutDirection2.setDividerAttributes(translateToOemDividerAttributes(splitAttributes.getDividerAttributes()));
        }
        androidx.window.extensions.embedding.SplitAttributes splitAttributesBuild = layoutDirection2.build();
        Intrinsics.checkNotNullExpressionValue(splitAttributesBuild, "build(...)");
        return splitAttributesBuild;
    }

    public final WindowAttributes translateWindowAttributes$window_release() {
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(5);
        EmbeddingConfiguration embeddingConfiguration = this.embeddingConfiguration;
        return new WindowAttributes(Intrinsics.areEqual(embeddingConfiguration != null ? embeddingConfiguration.getDimAreaBehavior() : null, EmbeddingConfiguration.DimAreaBehavior.ON_ACTIVITY_STACK) ? 1 : 2);
    }

    private final SplitAttributes.SplitType translateSplitType(SplitAttributes.SplitType splitType) {
        if (getExtensionVersion() < 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (Intrinsics.areEqual(splitType, SplitAttributes.SplitType.SPLIT_TYPE_HINGE)) {
            return new SplitAttributes.SplitType.HingeSplitType(translateSplitType(SplitAttributes.SplitType.SPLIT_TYPE_EQUAL));
        }
        if (Intrinsics.areEqual(splitType, SplitAttributes.SplitType.SPLIT_TYPE_EXPAND)) {
            return new SplitAttributes.SplitType.ExpandContainersSplitType();
        }
        float value = splitType.getValue();
        double d2 = value;
        if (d2 > 0.0d && d2 < 1.0d) {
            return new SplitAttributes.SplitType.RatioSplitType(value);
        }
        throw new IllegalArgumentException("Unsupported SplitType: " + splitType + " with value: " + splitType.getValue());
    }

    private final androidx.window.extensions.embedding.SplitPlaceholderRule translateSplitPlaceholderRule(final Context context, final SplitPlaceholderRule rule, Class<?> predicateClass) {
        if (getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPlaceholderRuleCompat(context, rule, predicateClass);
        }
        Predicate2 predicate2 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda2
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$11(rule, (Activity) obj);
            }
        };
        Predicate2 predicate22 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda3
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$13(rule, (Intent) obj);
            }
        };
        Predicate2 predicate23 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda4
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$14(rule, context, (WindowMetrics) obj);
            }
        };
        String tag = rule.getTag();
        SplitPlaceholderRule.Builder finishPrimaryWithPlaceholder = new SplitPlaceholderRule.Builder(rule.getPlaceholderIntent(), predicate2, predicate22, predicate23).setSticky(rule.getIsSticky()).setDefaultSplitAttributes(translateSplitAttributes(rule.getDefaultSplitAttributes())).setFinishPrimaryWithPlaceholder(translateFinishBehavior(rule.getFinishPrimaryWithPlaceholder()));
        Intrinsics.checkNotNullExpressionValue(finishPrimaryWithPlaceholder, "setFinishPrimaryWithPlaceholder(...)");
        if (tag == null) {
            tag = INSTANCE.generateTag(rule);
        }
        finishPrimaryWithPlaceholder.setTag(tag);
        androidx.window.extensions.embedding.SplitPlaceholderRule splitPlaceholderRuleBuild = finishPrimaryWithPlaceholder.build();
        Intrinsics.checkNotNullExpressionValue(splitPlaceholderRuleBuild, "build(...)");
        return splitPlaceholderRuleBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateSplitPlaceholderRule$lambda$11(SplitPlaceholderRule splitPlaceholderRule, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Set<ActivityFilter> filters = splitPlaceholderRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        Iterator<T> it = filters.iterator();
        while (it.hasNext()) {
            if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateSplitPlaceholderRule$lambda$13(SplitPlaceholderRule splitPlaceholderRule, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Set<ActivityFilter> filters = splitPlaceholderRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        Iterator<T> it = filters.iterator();
        while (it.hasNext()) {
            if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateSplitPlaceholderRule$lambda$14(SplitPlaceholderRule splitPlaceholderRule, Context context, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        return splitPlaceholderRule.checkParentMetrics$window_release(context, windowMetrics);
    }

    public final int translateFinishBehavior(SplitRule.FinishBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        if (Intrinsics.areEqual(behavior, SplitRule.FinishBehavior.NEVER)) {
            return 0;
        }
        if (Intrinsics.areEqual(behavior, SplitRule.FinishBehavior.ALWAYS)) {
            return 1;
        }
        if (Intrinsics.areEqual(behavior, SplitRule.FinishBehavior.ADJACENT)) {
            return 2;
        }
        throw new IllegalArgumentException("Unknown finish behavior:" + behavior);
    }

    private final androidx.window.extensions.embedding.ActivityRule translateActivityRule(final ActivityRule rule, Class<?> predicateClass) {
        if (getExtensionVersion() < 2) {
            return this.api1Impl.translateActivityRuleCompat(rule, predicateClass);
        }
        ActivityRule.Builder shouldAlwaysExpand = new ActivityRule.Builder(new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda8
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateActivityRule$lambda$16(rule, (Activity) obj);
            }
        }, new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda9
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateActivityRule$lambda$18(rule, (Intent) obj);
            }
        }).setShouldAlwaysExpand(rule.getAlwaysExpand());
        Intrinsics.checkNotNullExpressionValue(shouldAlwaysExpand, "setShouldAlwaysExpand(...)");
        String tag = rule.getTag();
        if (tag == null) {
            tag = INSTANCE.generateTag(rule);
        }
        shouldAlwaysExpand.setTag(tag);
        androidx.window.extensions.embedding.ActivityRule activityRuleBuild = shouldAlwaysExpand.build();
        Intrinsics.checkNotNullExpressionValue(activityRuleBuild, "build(...)");
        return activityRuleBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateActivityRule$lambda$16(ActivityRule activityRule, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Set<ActivityFilter> filters = activityRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        Iterator<T> it = filters.iterator();
        while (it.hasNext()) {
            if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean translateActivityRule$lambda$18(ActivityRule activityRule, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Set<ActivityFilter> filters = activityRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        Iterator<T> it = filters.iterator();
        while (it.hasNext()) {
            if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(Context context, Set<? extends EmbeddingRule> rules) {
        androidx.window.extensions.embedding.SplitPairRule splitPairRuleTranslateActivityRule;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Class<?> clsPredicateClassOrNull$window_release = this.predicateAdapter.predicateClassOrNull$window_release();
        if (clsPredicateClassOrNull$window_release == null) {
            return SetsKt.emptySet();
        }
        Set<? extends EmbeddingRule> set = rules;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        for (EmbeddingRule embeddingRule : set) {
            if (embeddingRule instanceof SplitPairRule) {
                splitPairRuleTranslateActivityRule = translateSplitPairRule(context, (SplitPairRule) embeddingRule, clsPredicateClassOrNull$window_release);
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                splitPairRuleTranslateActivityRule = translateSplitPlaceholderRule(context, (SplitPlaceholderRule) embeddingRule, clsPredicateClassOrNull$window_release);
            } else {
                if (!(embeddingRule instanceof ActivityRule)) {
                    throw new IllegalArgumentException("Unsupported rule type");
                }
                splitPairRuleTranslateActivityRule = translateActivityRule((ActivityRule) embeddingRule, clsPredicateClassOrNull$window_release);
            }
            arrayList.add((androidx.window.extensions.embedding.EmbeddingRule) splitPairRuleTranslateActivityRule);
        }
        return CollectionsKt.toSet(arrayList);
    }

    private final AnimationBackground translateToOemAnimationBackground(EmbeddingAnimationBackground animationBackground) {
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(5);
        if (animationBackground instanceof EmbeddingAnimationBackground.ColorBackground) {
            AnimationBackground animationBackgroundCreateColorBackground = AnimationBackground.createColorBackground(((EmbeddingAnimationBackground.ColorBackground) animationBackground).getColor());
            Intrinsics.checkNotNull(animationBackgroundCreateColorBackground);
            return animationBackgroundCreateColorBackground;
        }
        AnimationBackground animationBackground2 = AnimationBackground.ANIMATION_BACKGROUND_DEFAULT;
        Intrinsics.checkNotNull(animationBackground2);
        return animationBackground2;
    }

    private final EmbeddingAnimationBackground translateToJetpackAnimationBackground(AnimationBackground animationBackground) {
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(5);
        if (animationBackground instanceof AnimationBackground.ColorBackground) {
            return EmbeddingAnimationBackground.INSTANCE.createColorBackground(((AnimationBackground.ColorBackground) animationBackground).getColor());
        }
        return EmbeddingAnimationBackground.DEFAULT;
    }

    private final int translateToOemAnimationResId(EmbeddingAnimationParams.AnimationSpec animationSpec) {
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(7);
        return Intrinsics.areEqual(animationSpec, EmbeddingAnimationParams.AnimationSpec.JUMP_CUT) ? 0 : -1;
    }

    private final EmbeddingAnimationParams.AnimationSpec translateToJetpackAnimationSpec(int animationResId) {
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(7);
        if (animationResId == 0) {
            return EmbeddingAnimationParams.AnimationSpec.JUMP_CUT;
        }
        return EmbeddingAnimationParams.AnimationSpec.DEFAULT;
    }

    public final androidx.window.extensions.embedding.DividerAttributes translateToOemDividerAttributes(DividerAttributes dividerAttributes) {
        int i;
        Intrinsics.checkNotNullParameter(dividerAttributes, "dividerAttributes");
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(6);
        if (dividerAttributes == DividerAttributes.NO_DIVIDER) {
            return null;
        }
        if (dividerAttributes instanceof DividerAttributes.FixedDividerAttributes) {
            i = 1;
        } else {
            if (!(dividerAttributes instanceof DividerAttributes.DraggableDividerAttributes)) {
                throw new IllegalArgumentException("Unknown divider attributes " + dividerAttributes);
            }
            i = 2;
        }
        DividerAttributes.Builder widthDp = new DividerAttributes.Builder(i).setDividerColor(dividerAttributes.getColor()).setWidthDp(dividerAttributes.getWidthDp());
        Intrinsics.checkNotNullExpressionValue(widthDp, "setWidthDp(...)");
        if (dividerAttributes instanceof DividerAttributes.DraggableDividerAttributes) {
            DividerAttributes.DraggableDividerAttributes draggableDividerAttributes = (DividerAttributes.DraggableDividerAttributes) dividerAttributes;
            if (draggableDividerAttributes.getPrimaryContainerDragRange() instanceof DividerAttributes.DragRange.SplitRatioDragRange) {
                widthDp.setPrimaryMinRatio(((DividerAttributes.DragRange.SplitRatioDragRange) draggableDividerAttributes.getPrimaryContainerDragRange()).getMinRatio()).setPrimaryMaxRatio(((DividerAttributes.DragRange.SplitRatioDragRange) draggableDividerAttributes.getPrimaryContainerDragRange()).getMaxRatio());
            }
            if (getExtensionVersion() >= 7) {
                widthDp.setDraggingToFullscreenAllowed(draggableDividerAttributes.getIsDraggingToFullscreenAllowed());
            }
        }
        if (getExtensionVersion() == 7 && dividerAttributes.getWidthDp() == 0) {
            widthDp.setWidthDp(1);
        }
        return widthDp.build();
    }

    public final DividerAttributes translateToJetpackDividerAttributes(androidx.window.extensions.embedding.DividerAttributes oemDividerAttributes) {
        DividerAttributes.DragRange.SplitRatioDragRange splitRatioDragRange;
        WindowSdkExtensions.INSTANCE.getInstance().requireExtensionVersion$window_release(6);
        if (oemDividerAttributes == null) {
            return DividerAttributes.NO_DIVIDER;
        }
        int dividerType = oemDividerAttributes.getDividerType();
        if (dividerType == 1) {
            return new DividerAttributes.FixedDividerAttributes.Builder().setWidthDp(oemDividerAttributes.getWidthDp()).setColor(oemDividerAttributes.getDividerColor()).build();
        }
        if (dividerType == 2) {
            DividerAttributes.DraggableDividerAttributes.Builder color = new DividerAttributes.DraggableDividerAttributes.Builder().setWidthDp(oemDividerAttributes.getWidthDp()).setColor(oemDividerAttributes.getDividerColor());
            if (oemDividerAttributes.getPrimaryMinRatio() == -1.0f && oemDividerAttributes.getPrimaryMaxRatio() == -1.0f) {
                splitRatioDragRange = DividerAttributes.DragRange.DRAG_RANGE_SYSTEM_DEFAULT;
            } else {
                splitRatioDragRange = new DividerAttributes.DragRange.SplitRatioDragRange(oemDividerAttributes.getPrimaryMinRatio(), oemDividerAttributes.getPrimaryMaxRatio());
            }
            return color.setDragRange(splitRatioDragRange).setDraggingToFullscreenAllowed(getExtensionVersion() >= 7 && oemDividerAttributes.isDraggingToFullscreenAllowed()).build();
        }
        Log.w(TAG, "Unknown divider type " + oemDividerAttributes + ".dividerType, default to fixed divider type");
        return new DividerAttributes.FixedDividerAttributes.Builder().setWidthDp(oemDividerAttributes.getWidthDp()).setColor(oemDividerAttributes.getDividerColor()).build();
    }

    /* JADX INFO: compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class VendorApiLevel3Impl {
        public VendorApiLevel3Impl() {
        }

        public final SplitInfo translateCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            VendorApiLevel1Impl vendorApiLevel1Impl = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
            ActivityStack activityStackTranslateCompat = vendorApiLevel1Impl.translateCompat(primaryActivityStack);
            VendorApiLevel1Impl vendorApiLevel1Impl2 = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
            ActivityStack activityStackTranslateCompat2 = vendorApiLevel1Impl2.translateCompat(secondaryActivityStack);
            EmbeddingAdapter embeddingAdapter = EmbeddingAdapter.this;
            androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(splitAttributes, "getSplitAttributes(...)");
            SplitAttributes splitAttributesTranslate$window_release = embeddingAdapter.translate$window_release(splitAttributes);
            IBinder token = splitInfo.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            return new SplitInfo(activityStackTranslateCompat, activityStackTranslateCompat2, splitAttributesTranslate$window_release, token);
        }
    }

    /* JADX INFO: compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class VendorApiLevel2Impl {
        public VendorApiLevel2Impl() {
        }

        public final SplitInfo translateCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            VendorApiLevel1Impl vendorApiLevel1Impl = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
            ActivityStack activityStackTranslateCompat = vendorApiLevel1Impl.translateCompat(primaryActivityStack);
            VendorApiLevel1Impl vendorApiLevel1Impl2 = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
            ActivityStack activityStackTranslateCompat2 = vendorApiLevel1Impl2.translateCompat(secondaryActivityStack);
            EmbeddingAdapter embeddingAdapter = EmbeddingAdapter.this;
            androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(splitAttributes, "getSplitAttributes(...)");
            return new SplitInfo(activityStackTranslateCompat, activityStackTranslateCompat2, embeddingAdapter.translate$window_release(splitAttributes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u001c2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\u0016\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0003J\u0016\u0010!\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0003J\u0014\u0010\u0017\u001a\u00020\"*\u00020\"2\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\tH\u0002J\u0016\u0010*\u001a\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001fH\u0003J\u0016\u0010-\u001a\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001fH\u0003J\u0018\u0010.\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010/\u001a\u000200H\u0003J\u000e\u00101\u001a\u0002022\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u00101\u001a\u0002032\u0006\u00104\u001a\u000205R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u00066"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "", "predicateAdapter", "Landroidx/window/core/PredicateAdapter;", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;Landroidx/window/core/PredicateAdapter;)V", "getPredicateAdapter", "()Landroidx/window/core/PredicateAdapter;", "getSplitAttributesCompat", "Landroidx/window/embedding/SplitAttributes;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "translateActivityRuleCompat", "Landroidx/window/extensions/embedding/ActivityRule;", AMPExtension.Rule.ELEMENT, "Landroidx/window/embedding/ActivityRule;", "predicateClass", "Ljava/lang/Class;", "translateSplitPlaceholderRuleCompat", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "context", "Landroid/content/Context;", "Landroidx/window/embedding/SplitPlaceholderRule;", "setDefaultSplitAttributesCompat", "Landroidx/window/extensions/embedding/SplitPlaceholderRule$Builder;", "defaultAttrs", "translateSplitPairRuleCompat", "Landroidx/window/extensions/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitPairRule;", "translateActivityPairPredicates", "splitPairFilters", "", "Landroidx/window/embedding/SplitPairFilter;", "translateActivityIntentPredicates", "Landroidx/window/extensions/embedding/SplitPairRule$Builder;", "translateSplitAttributesCompatInternal", "Lkotlin/Pair;", "", "", "attrs", "isSplitAttributesSupported", "", "translateActivityPredicates", "activityFilters", "Landroidx/window/embedding/ActivityFilter;", "translateIntentPredicates", "translateParentMetricsPredicate", "splitRule", "Landroidx/window/embedding/SplitRule;", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "Landroidx/window/embedding/ActivityStack;", "activityStack", "Landroidx/window/extensions/embedding/ActivityStack;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    final class VendorApiLevel1Impl {
        private final PredicateAdapter predicateAdapter;
        final /* synthetic */ EmbeddingAdapter this$0;

        public VendorApiLevel1Impl(EmbeddingAdapter embeddingAdapter, PredicateAdapter predicateAdapter) {
            Intrinsics.checkNotNullParameter(predicateAdapter, "predicateAdapter");
            this.this$0 = embeddingAdapter;
            this.predicateAdapter = predicateAdapter;
        }

        public final PredicateAdapter getPredicateAdapter() {
            return this.predicateAdapter;
        }

        public final SplitAttributes getSplitAttributesCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            return new SplitAttributes.Builder().setSplitType(SplitAttributes.SplitType.INSTANCE.buildSplitTypeFromValue$window_release(splitInfo.getSplitRatio())).setLayoutDirection(SplitAttributes.LayoutDirection.LOCALE).build();
        }

        public final androidx.window.extensions.embedding.ActivityRule translateActivityRuleCompat(ActivityRule rule, Class<?> predicateClass) {
            Intrinsics.checkNotNullParameter(rule, "rule");
            Intrinsics.checkNotNullParameter(predicateClass, "predicateClass");
            androidx.window.extensions.embedding.ActivityRule activityRuleBuild = ((ActivityRule.Builder) ActivityRule.Builder.class.getConstructor(predicateClass, predicateClass).newInstance(translateActivityPredicates(rule.getFilters()), translateIntentPredicates(rule.getFilters()))).setShouldAlwaysExpand(rule.getAlwaysExpand()).build();
            Intrinsics.checkNotNullExpressionValue(activityRuleBuild, "build(...)");
            return activityRuleBuild;
        }

        public final androidx.window.extensions.embedding.SplitPlaceholderRule translateSplitPlaceholderRuleCompat(Context context, SplitPlaceholderRule rule, Class<?> predicateClass) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rule, "rule");
            Intrinsics.checkNotNullParameter(predicateClass, "predicateClass");
            SplitPlaceholderRule.Builder finishPrimaryWithSecondary = ((SplitPlaceholderRule.Builder) SplitPlaceholderRule.Builder.class.getConstructor(Intent.class, predicateClass, predicateClass, predicateClass).newInstance(rule.getPlaceholderIntent(), translateActivityPredicates(rule.getFilters()), translateIntentPredicates(rule.getFilters()), translateParentMetricsPredicate(context, rule))).setSticky(rule.getIsSticky()).setFinishPrimaryWithSecondary(this.this$0.translateFinishBehavior(rule.getFinishPrimaryWithPlaceholder()));
            Intrinsics.checkNotNullExpressionValue(finishPrimaryWithSecondary, "setFinishPrimaryWithSecondary(...)");
            androidx.window.extensions.embedding.SplitPlaceholderRule splitPlaceholderRuleBuild = setDefaultSplitAttributesCompat(finishPrimaryWithSecondary, rule.getDefaultSplitAttributes()).build();
            Intrinsics.checkNotNullExpressionValue(splitPlaceholderRuleBuild, "build(...)");
            return splitPlaceholderRuleBuild;
        }

        private final SplitPlaceholderRule.Builder setDefaultSplitAttributesCompat(SplitPlaceholderRule.Builder builder, SplitAttributes splitAttributes) {
            kotlin.Pair<Float, Integer> pairTranslateSplitAttributesCompatInternal = translateSplitAttributesCompatInternal(splitAttributes);
            float fFloatValue = pairTranslateSplitAttributesCompatInternal.component1().floatValue();
            int iIntValue = pairTranslateSplitAttributesCompatInternal.component2().intValue();
            builder.setSplitRatio(fFloatValue);
            builder.setLayoutDirection(iIntValue);
            return builder;
        }

        public final androidx.window.extensions.embedding.SplitPairRule translateSplitPairRuleCompat(Context context, SplitPairRule rule, Class<?> predicateClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rule, "rule");
            Intrinsics.checkNotNullParameter(predicateClass, "predicateClass");
            Object objNewInstance = SplitPairRule.Builder.class.getConstructor(predicateClass, predicateClass, predicateClass).newInstance(translateActivityPairPredicates(rule.getFilters()), translateActivityIntentPredicates(rule.getFilters()), translateParentMetricsPredicate(context, rule));
            Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
            androidx.window.extensions.embedding.SplitPairRule splitPairRuleBuild = setDefaultSplitAttributesCompat((SplitPairRule.Builder) objNewInstance, rule.getDefaultSplitAttributes()).setShouldClearTop(rule.getClearTop()).setFinishPrimaryWithSecondary(this.this$0.translateFinishBehavior(rule.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(this.this$0.translateFinishBehavior(rule.getFinishSecondaryWithPrimary())).build();
            Intrinsics.checkNotNullExpressionValue(splitPairRuleBuild, "build(...)");
            return splitPairRuleBuild;
        }

        private final Object translateActivityPairPredicates(final Set<SplitPairFilter> splitPairFilters) {
            return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Activity.class), new Function2() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateActivityPairPredicates$lambda$2(splitPairFilters, (Activity) obj, (Activity) obj2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean translateActivityPairPredicates$lambda$2(Set set, Activity first, Activity second) {
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            Set set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            Iterator it = set2.iterator();
            while (it.hasNext()) {
                if (((SplitPairFilter) it.next()).matchesActivityPair(first, second)) {
                    return true;
                }
            }
            return false;
        }

        private final Object translateActivityIntentPredicates(final Set<SplitPairFilter> splitPairFilters) {
            return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Intent.class), new Function2() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateActivityIntentPredicates$lambda$4(splitPairFilters, (Activity) obj, (Intent) obj2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean translateActivityIntentPredicates$lambda$4(Set set, Activity first, Intent second) {
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            Set set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            Iterator it = set2.iterator();
            while (it.hasNext()) {
                if (((SplitPairFilter) it.next()).matchesActivityIntentPair(first, second)) {
                    return true;
                }
            }
            return false;
        }

        private final SplitPairRule.Builder setDefaultSplitAttributesCompat(SplitPairRule.Builder builder, SplitAttributes splitAttributes) {
            kotlin.Pair<Float, Integer> pairTranslateSplitAttributesCompatInternal = translateSplitAttributesCompatInternal(splitAttributes);
            float fFloatValue = pairTranslateSplitAttributesCompatInternal.component1().floatValue();
            int iIntValue = pairTranslateSplitAttributesCompatInternal.component2().intValue();
            builder.setSplitRatio(fFloatValue);
            builder.setLayoutDirection(iIntValue);
            return builder;
        }

        private final kotlin.Pair<Float, Integer> translateSplitAttributesCompatInternal(SplitAttributes attrs) {
            int i = 3;
            if (!isSplitAttributesSupported(attrs)) {
                return new kotlin.Pair<>(Float.valueOf(0.0f), 3);
            }
            Float fValueOf = Float.valueOf(attrs.getSplitType().getValue());
            SplitAttributes.LayoutDirection layoutDirection = attrs.getLayoutDirection();
            if (!Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LOCALE)) {
                if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LEFT_TO_RIGHT)) {
                    i = 0;
                } else {
                    if (!Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.RIGHT_TO_LEFT)) {
                        throw new IllegalStateException("Unsupported layout direction must be covered in @isSplitAttributesSupported!");
                    }
                    i = 1;
                }
            }
            return new kotlin.Pair<>(fValueOf, Integer.valueOf(i));
        }

        private final boolean isSplitAttributesSupported(SplitAttributes attrs) {
            double value = attrs.getSplitType().getValue();
            return 0.0d <= value && value <= 1.0d && attrs.getSplitType().getValue() != 1.0f && ArraysKt.contains(new SplitAttributes.LayoutDirection[]{SplitAttributes.LayoutDirection.LEFT_TO_RIGHT, SplitAttributes.LayoutDirection.RIGHT_TO_LEFT, SplitAttributes.LayoutDirection.LOCALE}, attrs.getLayoutDirection());
        }

        private final Object translateActivityPredicates(final Set<ActivityFilter> activityFilters) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Activity.class), new Function1() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateActivityPredicates$lambda$7(activityFilters, (Activity) obj));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean translateActivityPredicates$lambda$7(Set set, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Set set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            Iterator it = set2.iterator();
            while (it.hasNext()) {
                if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                    return true;
                }
            }
            return false;
        }

        private final Object translateIntentPredicates(final Set<ActivityFilter> activityFilters) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Intent.class), new Function1() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateIntentPredicates$lambda$9(activityFilters, (Intent) obj));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean translateIntentPredicates$lambda$9(Set set, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Set set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            Iterator it = set2.iterator();
            while (it.hasNext()) {
                if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                    return true;
                }
            }
            return false;
        }

        private final Object translateParentMetricsPredicate(final Context context, final SplitRule splitRule) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(WindowMetrics.class), new Function1() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateParentMetricsPredicate$lambda$10(splitRule, context, (WindowMetrics) obj));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean translateParentMetricsPredicate$lambda$10(SplitRule splitRule, Context context, WindowMetrics windowMetrics) {
            Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
            return splitRule.checkParentMetrics$window_release(context, windowMetrics);
        }

        public final SplitInfo translateCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
            ActivityStack activityStackTranslateCompat = translateCompat(primaryActivityStack);
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
            return new SplitInfo(activityStackTranslateCompat, translateCompat(secondaryActivityStack), getSplitAttributesCompat(splitInfo));
        }

        public final ActivityStack translateCompat(androidx.window.extensions.embedding.ActivityStack activityStack) {
            Intrinsics.checkNotNullParameter(activityStack, "activityStack");
            List activities = activityStack.getActivities();
            Intrinsics.checkNotNullExpressionValue(activities, "getActivities(...)");
            return new ActivityStack(activities, activityStack.isEmpty());
        }
    }

    /* JADX INFO: compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$Companion;", "", "<init>", "()V", "TAG", "", "RULE_TAG_PREFIX", "getRULE_TAG_PREFIX", "()Ljava/lang/String;", "INVALID_SPLIT_INFO_TOKEN", "Landroid/os/Binder;", "getINVALID_SPLIT_INFO_TOKEN", "()Landroid/os/Binder;", "generateTag", AMPExtension.Rule.ELEMENT, "Landroidx/window/embedding/EmbeddingRule;", "isTagGenerated", "", "tag", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getRULE_TAG_PREFIX() {
            return EmbeddingAdapter.RULE_TAG_PREFIX;
        }

        public final Binder getINVALID_SPLIT_INFO_TOKEN() {
            return EmbeddingAdapter.INVALID_SPLIT_INFO_TOKEN;
        }

        public final String generateTag(EmbeddingRule rule) {
            Intrinsics.checkNotNullParameter(rule, "rule");
            return getRULE_TAG_PREFIX() + Integer.toHexString(rule.hashCode());
        }

        public final boolean isTagGenerated(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            String strRemovePrefix = StringsKt.removePrefix(tag, (CharSequence) getRULE_TAG_PREFIX());
            return (Intrinsics.areEqual(strRemovePrefix, tag) || StringsKt.toIntOrNull(strRemovePrefix, 16) == null) ? false : true;
        }
    }
}
