package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.window.R;
import androidx.window.embedding.ActivityRule;
import androidx.window.embedding.EmbeddingAnimationParams;
import androidx.window.embedding.SplitAttributes;
import androidx.window.embedding.SplitPairRule;
import androidx.window.embedding.SplitPlaceholderRule;
import androidx.window.embedding.SplitRule;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* JADX INFO: compiled from: RuleParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ$\u0010\f\u001a\u00020\r*\u0012\u0012\u0004\u0012\u00020\u00060\u000ej\b\u0012\u0004\u0012\u00020\u0006`\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002¨\u0006%"}, d2 = {"Landroidx/window/embedding/RuleParser;", "", "<init>", "()V", "parseRules", "", "Landroidx/window/embedding/EmbeddingRule;", "context", "Landroid/content/Context;", "staticRuleResourceId", "", "parseRules$window_release", "addRuleWithDuplicatedTagCheck", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", AMPExtension.Rule.ELEMENT, "parseSplitPairRule", "Landroidx/window/embedding/SplitPairRule;", "parser", "Landroid/content/res/XmlResourceParser;", "parseSplitPlaceholderRule", "Landroidx/window/embedding/SplitPlaceholderRule;", "parseSplitPairFilter", "Landroidx/window/embedding/SplitPairFilter;", "parseActivityRule", "Landroidx/window/embedding/ActivityRule;", "parseActivityFilter", "Landroidx/window/embedding/ActivityFilter;", "parseDividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "buildClassName", "Landroid/content/ComponentName;", "pkg", "", "clsSeq", "", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RuleParser {
    public static final RuleParser INSTANCE = new RuleParser();

    private RuleParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Set<EmbeddingRule> parseRules$window_release(Context context, int staticRuleResourceId) {
        SplitPlaceholderRule splitPlaceholderRuleBuild;
        SplitPairRule splitPairRuleBuild;
        ActivityRule activityRulePlus$window_release;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            XmlResourceParser xml = context.getResources().getXml(staticRuleResourceId);
            Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
            HashSet<EmbeddingRule> hashSet = new HashSet<>();
            int depth = xml.getDepth();
            int next = xml.next();
            SplitPairRule splitPairRule = null;
            ActivityRule activityRule = null;
            SplitPlaceholderRule splitPlaceholderRule = null;
            while (next != 1 && (next != 3 || xml.getDepth() > depth)) {
                if (xml.getEventType() != 2 || Intrinsics.areEqual("split-config", xml.getName())) {
                    next = xml.next();
                } else {
                    String name = xml.getName();
                    if (name != null) {
                        switch (name.hashCode()) {
                            case 304713008:
                                if (name.equals("DividerAttributes")) {
                                    if (splitPairRule == null && splitPlaceholderRule == null) {
                                        throw new IllegalArgumentException("Found orphaned DividerAttributes");
                                    }
                                    DividerAttributes dividerAttributes = parseDividerAttributes(context, xml);
                                    if (splitPairRule != null) {
                                        hashSet.remove(splitPairRule);
                                        splitPairRuleBuild = new SplitPairRule.Builder(splitPairRule).setDefaultSplitAttributes(new SplitAttributes.Builder(splitPairRule.getDefaultSplitAttributes()).setDividerAttributes(dividerAttributes).build()).build();
                                        addRuleWithDuplicatedTagCheck(hashSet, splitPairRuleBuild);
                                        splitPairRule = splitPairRuleBuild;
                                    } else if (splitPlaceholderRule != null) {
                                        hashSet.remove(splitPlaceholderRule);
                                        splitPlaceholderRuleBuild = new SplitPlaceholderRule.Builder(splitPlaceholderRule).setDefaultSplitAttributes(new SplitAttributes.Builder(splitPlaceholderRule.getDefaultSplitAttributes()).setDividerAttributes(dividerAttributes).build()).build();
                                        addRuleWithDuplicatedTagCheck(hashSet, splitPlaceholderRuleBuild);
                                        splitPlaceholderRule = splitPlaceholderRuleBuild;
                                    }
                                }
                                break;
                            case 511422343:
                                if (name.equals("ActivityFilter")) {
                                    if (activityRule == null && splitPlaceholderRule == null) {
                                        throw new IllegalArgumentException("Found orphaned ActivityFilter");
                                    }
                                    ActivityFilter activityFilter = parseActivityFilter(context, xml);
                                    if (activityRule != null) {
                                        hashSet.remove(activityRule);
                                        activityRulePlus$window_release = activityRule.plus$window_release(activityFilter);
                                        addRuleWithDuplicatedTagCheck(hashSet, activityRulePlus$window_release);
                                        activityRule = activityRulePlus$window_release;
                                    } else if (splitPlaceholderRule != null) {
                                        hashSet.remove(splitPlaceholderRule);
                                        splitPlaceholderRuleBuild = splitPlaceholderRule.plus$window_release(activityFilter);
                                        addRuleWithDuplicatedTagCheck(hashSet, splitPlaceholderRuleBuild);
                                        splitPlaceholderRule = splitPlaceholderRuleBuild;
                                    }
                                }
                                break;
                            case 520447504:
                                if (name.equals("SplitPairRule")) {
                                    splitPairRuleBuild = parseSplitPairRule(context, xml);
                                    addRuleWithDuplicatedTagCheck(hashSet, splitPairRuleBuild);
                                    activityRule = null;
                                    splitPlaceholderRule = null;
                                    splitPairRule = splitPairRuleBuild;
                                }
                                break;
                            case 1579230604:
                                if (name.equals("SplitPairFilter")) {
                                    if (splitPairRule == null) {
                                        throw new IllegalArgumentException("Found orphaned SplitPairFilter outside of SplitPairRule");
                                    }
                                    SplitPairFilter splitPairFilter = parseSplitPairFilter(context, xml);
                                    hashSet.remove(splitPairRule);
                                    splitPairRuleBuild = splitPairRule.plus$window_release(splitPairFilter);
                                    addRuleWithDuplicatedTagCheck(hashSet, splitPairRuleBuild);
                                    splitPairRule = splitPairRuleBuild;
                                }
                                break;
                            case 1793077963:
                                if (name.equals("ActivityRule")) {
                                    activityRulePlus$window_release = parseActivityRule(context, xml);
                                    addRuleWithDuplicatedTagCheck(hashSet, activityRulePlus$window_release);
                                    splitPairRule = null;
                                    splitPlaceholderRule = null;
                                    activityRule = activityRulePlus$window_release;
                                }
                                break;
                            case 2050988213:
                                if (name.equals("SplitPlaceholderRule")) {
                                    splitPlaceholderRuleBuild = parseSplitPlaceholderRule(context, xml);
                                    addRuleWithDuplicatedTagCheck(hashSet, splitPlaceholderRuleBuild);
                                    splitPairRule = null;
                                    activityRule = null;
                                    splitPlaceholderRule = splitPlaceholderRuleBuild;
                                }
                                break;
                        }
                    }
                    next = xml.next();
                }
            }
            return hashSet;
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private final void addRuleWithDuplicatedTagCheck(HashSet<EmbeddingRule> hashSet, EmbeddingRule embeddingRule) {
        String tag = embeddingRule.getTag();
        for (EmbeddingRule embeddingRule2 : hashSet) {
            if (tag != null && Intrinsics.areEqual(tag, embeddingRule2.getTag())) {
                throw new IllegalArgumentException("Duplicated tag: " + tag + " for " + embeddingRule + ". The tag must be unique in XML rule definition.");
            }
        }
        hashSet.add(embeddingRule);
    }

    private final SplitPairRule parseSplitPairRule(Context context, XmlResourceParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(parser, R.styleable.SplitPairRule, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.SplitPairRule_tag);
        float f2 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitRatio, 0.5f);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.SplitPairRule_splitMinWidthDp, 600);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(R.styleable.SplitPairRule_splitMinHeightDp, 600);
        int integer3 = typedArrayObtainStyledAttributes.getInteger(R.styleable.SplitPairRule_splitMinSmallestWidthDp, 600);
        float f3 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue());
        float f4 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue());
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitLayoutDirection, SplitAttributes.LayoutDirection.LOCALE.getValue());
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPairRule_finishPrimaryWithSecondary, SplitRule.FinishBehavior.NEVER.getValue());
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPairRule_finishSecondaryWithPrimary, SplitRule.FinishBehavior.ALWAYS.getValue());
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_clearTop, false);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.SplitPairRule_animationBackgroundColor, 0);
        int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitOpenAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue());
        int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitCloseAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue());
        int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitChangeAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue());
        typedArrayObtainStyledAttributes.recycle();
        return new SplitPairRule.Builder((Set<SplitPairFilter>) SetsKt.emptySet()).setTag(string).setMinWidthDp(integer).setMinHeightDp(integer2).setMinSmallestWidthDp(integer3).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.INSTANCE.buildAspectRatioFromValue$window_release(f3)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.INSTANCE.buildAspectRatioFromValue$window_release(f4)).setFinishPrimaryWithSecondary(SplitRule.FinishBehavior.INSTANCE.getFinishBehaviorFromValue$window_release(i2)).setFinishSecondaryWithPrimary(SplitRule.FinishBehavior.INSTANCE.getFinishBehaviorFromValue$window_release(i3)).setClearTop(z).setDefaultSplitAttributes(new SplitAttributes.Builder().setSplitType(SplitAttributes.SplitType.INSTANCE.buildSplitTypeFromValue$window_release(f2)).setLayoutDirection(SplitAttributes.LayoutDirection.INSTANCE.getLayoutDirectionFromValue$window_release(i)).setAnimationParams(new EmbeddingAnimationParams.Builder().setAnimationBackground(EmbeddingAnimationBackground.INSTANCE.buildFromValue$window_release(color)).setOpenAnimation(EmbeddingAnimationParams.AnimationSpec.INSTANCE.getAnimationSpecFromValue$window_release(i4)).setCloseAnimation(EmbeddingAnimationParams.AnimationSpec.INSTANCE.getAnimationSpecFromValue$window_release(i5)).setChangeAnimation(EmbeddingAnimationParams.AnimationSpec.INSTANCE.getAnimationSpecFromValue$window_release(i6)).build()).build()).build();
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context context, XmlResourceParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(parser, R.styleable.SplitPlaceholderRule, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.SplitPlaceholderRule_tag);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.SplitPlaceholderRule_placeholderActivityName);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SplitPlaceholderRule_stickyPlaceholder, false);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_finishPrimaryWithPlaceholder, SplitRule.FinishBehavior.ALWAYS.getValue());
        if (i == SplitRule.FinishBehavior.NEVER.getValue()) {
            throw new IllegalArgumentException("Never is not a valid configuration for Placeholder activities. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API");
        }
        float f2 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitRatio, 0.5f);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.SplitPlaceholderRule_splitMinWidthDp, 600);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(R.styleable.SplitPlaceholderRule_splitMinHeightDp, 600);
        int integer3 = typedArrayObtainStyledAttributes.getInteger(R.styleable.SplitPlaceholderRule_splitMinSmallestWidthDp, 600);
        float f3 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue());
        float f4 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue());
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitLayoutDirection, SplitAttributes.LayoutDirection.LOCALE.getValue());
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.SplitPlaceholderRule_animationBackgroundColor, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitOpenAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue());
        int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitCloseAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue());
        int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitChangeAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue());
        typedArrayObtainStyledAttributes.recycle();
        SplitAttributes splitAttributesBuild = new SplitAttributes.Builder().setSplitType(SplitAttributes.SplitType.INSTANCE.buildSplitTypeFromValue$window_release(f2)).setLayoutDirection(SplitAttributes.LayoutDirection.INSTANCE.getLayoutDirectionFromValue$window_release(i2)).setAnimationParams(new EmbeddingAnimationParams.Builder().setAnimationBackground(EmbeddingAnimationBackground.INSTANCE.buildFromValue$window_release(color)).setOpenAnimation(EmbeddingAnimationParams.AnimationSpec.INSTANCE.getAnimationSpecFromValue$window_release(i3)).setCloseAnimation(EmbeddingAnimationParams.AnimationSpec.INSTANCE.getAnimationSpecFromValue$window_release(i4)).setChangeAnimation(EmbeddingAnimationParams.AnimationSpec.INSTANCE.getAnimationSpecFromValue$window_release(i5)).build()).build();
        String packageName = context.getApplicationContext().getPackageName();
        RuleParser ruleParser = INSTANCE;
        Intrinsics.checkNotNull(packageName);
        ComponentName componentNameBuildClassName = ruleParser.buildClassName(packageName, string2);
        Set setEmptySet = SetsKt.emptySet();
        Intent component = new Intent().setComponent(componentNameBuildClassName);
        Intrinsics.checkNotNullExpressionValue(component, "setComponent(...)");
        return new SplitPlaceholderRule.Builder(setEmptySet, component).setTag(string).setMinWidthDp(integer).setMinHeightDp(integer2).setMinSmallestWidthDp(integer3).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.INSTANCE.buildAspectRatioFromValue$window_release(f3)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.INSTANCE.buildAspectRatioFromValue$window_release(f4)).setSticky(z).setFinishPrimaryWithPlaceholder(SplitRule.FinishBehavior.INSTANCE.getFinishBehaviorFromValue$window_release(i)).setDefaultSplitAttributes(splitAttributesBuild).build();
    }

    private final SplitPairFilter parseSplitPairFilter(Context context, XmlResourceParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(parser, R.styleable.SplitPairFilter, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.SplitPairFilter_primaryActivityName);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityName);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityAction);
        String packageName = context.getApplicationContext().getPackageName();
        Intrinsics.checkNotNull(packageName);
        return new SplitPairFilter(buildClassName(packageName, string), buildClassName(packageName, string2), string3);
    }

    private final ActivityRule parseActivityRule(Context context, XmlResourceParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(parser, R.styleable.ActivityRule, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.ActivityRule_tag);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActivityRule_alwaysExpand, false);
        typedArrayObtainStyledAttributes.recycle();
        ActivityRule.Builder alwaysExpand = new ActivityRule.Builder(SetsKt.emptySet()).setAlwaysExpand(z);
        if (string != null) {
            alwaysExpand.setTag(string);
        }
        return alwaysExpand.build();
    }

    private final ActivityFilter parseActivityFilter(Context context, XmlResourceParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(parser, R.styleable.ActivityFilter, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.ActivityFilter_activityName);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.ActivityFilter_activityAction);
        String packageName = context.getApplicationContext().getPackageName();
        Intrinsics.checkNotNull(packageName);
        return new ActivityFilter(buildClassName(packageName, string), string2);
    }

    private final DividerAttributes parseDividerAttributes(Context context, XmlResourceParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(parser, R.styleable.DividerAttributes, 0, 0);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.DividerAttributes_embeddingDividerType, 0);
        DividerAttributes.INSTANCE.validateXmlDividerAttributes$window_release(i, typedArrayObtainStyledAttributes.hasValue(R.styleable.DividerAttributes_dragRangeMinRatio), typedArrayObtainStyledAttributes.hasValue(R.styleable.DividerAttributes_dragRangeMaxRatio), typedArrayObtainStyledAttributes.hasValue(R.styleable.DividerAttributes_isDraggingToFullscreenAllowed));
        return DividerAttributes.INSTANCE.createDividerAttributes$window_release(i, typedArrayObtainStyledAttributes.getInt(R.styleable.DividerAttributes_embeddingDividerWidthDp, -1), typedArrayObtainStyledAttributes.getColor(R.styleable.DividerAttributes_embeddingDividerColor, -16777216), typedArrayObtainStyledAttributes.getFloat(R.styleable.DividerAttributes_dragRangeMinRatio, -1.0f), typedArrayObtainStyledAttributes.getFloat(R.styleable.DividerAttributes_dragRangeMaxRatio, -1.0f), typedArrayObtainStyledAttributes.getBoolean(R.styleable.DividerAttributes_isDraggingToFullscreenAllowed, false));
    }

    private final ComponentName buildClassName(String pkg, CharSequence clsSeq) {
        if (clsSeq == null || clsSeq.length() == 0) {
            throw new IllegalArgumentException("Activity name must not be null");
        }
        String string = clsSeq.toString();
        if (string.charAt(0) == '.') {
            return new ComponentName(pkg, pkg + string);
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, '/', 0, false, 6, (Object) null);
        if (iIndexOf$default > 0) {
            pkg = string.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(pkg, "substring(...)");
            string = string.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        }
        if (!Intrinsics.areEqual(string, "*") && StringsKt.indexOf$default((CharSequence) string, '.', 0, false, 6, (Object) null) < 0) {
            return new ComponentName(pkg, pkg + '.' + string);
        }
        return new ComponentName(pkg, string);
    }
}
