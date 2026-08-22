package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u007f\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u008b\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0016\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u007f\u0010\u001e\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0095\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b \u0010!\u001a¶\u0001\u0010\"\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b#\u0010$\u001a\u007f\u0010%\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0095\u0001\u0010%\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b&\u0010!\u001a¶\u0001\u0010'\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b(\u0010$\u001aà\u0001\u0010)\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062*\b\u0002\u0010\u0019\u001a$\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b.\u0010/\u001a\u0080\u0001\u00100\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b8\u00109\u001a\u008c\u0001\u00100\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:H\u0007¢\u0006\u0004\b;\u0010<\u001ai\u00100\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b>\u0010?\u001au\u00100\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b@\u0010A\u001a\u007f\u0010B\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0004\bE\u0010F\u001ay\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00142\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u0002072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0004\bI\u0010J\u001a+\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020N2\b\b\u0002\u0010P\u001a\u00020NH\u0007¢\u0006\u0002\u0010Q\u001a+\u0010R\u001a\u00020S2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020N2\b\b\u0002\u0010P\u001a\u00020NH\u0007¢\u0006\u0002\u0010T\u001a \u0010U\u001a\u00020S2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NH\u0007\u001a>\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020S2\u0006\u0010Y\u001a\u00020N2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0002\u0010^\u001a¬\u0001\u0010f\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bj\u0010k\u001aô\u0001\u0010)\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0006\u0010s\u001a\u00020\u00142\u0011\u0010t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010u\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\u0013\u0010v\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010w\u001a\u00020h2\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bx\u0010y\u001a\u0016\u0010~\u001a\u00020\u0006*\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u001aá\u0001\u0010\u007f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u0002032\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u0002032\u0007\u0010\u0085\u0001\u001a\u0002032\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020N0\u00032\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0007\u0010s\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020*2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0007\u0010\u008b\u0001\u001a\u00020\u0014H\u0003¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a@\u0010\u008e\u0001\u001a\u00020W2\u0006\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020N2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0003\u0010\u008f\u0001\u001a\u0016\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0091\u0001H\u0003¢\u0006\u0003\u0010\u0092\u0001\"\u0010\u0010_\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0016\u0010a\u001a\u00020\u0014X\u0080\u0004¢\u0006\n\n\u0002\u0010`\u001a\u0004\bb\u0010c\"\u0010\u0010d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\" \u0010l\u001a\b\u0012\u0004\u0012\u00020n0mX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bo\u0010p\u001a\u0004\bq\u0010r\" \u0010z\u001a\b\u0012\u0004\u0012\u00020{0mX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010p\u001a\u0004\b}\u0010r\"\u0018\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0011\u0010\u0097\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0098\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0099\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u009a\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`¨\u0006\u009b\u0001²\u0006\u000b\u0010\u009c\u0001\u001a\u00020*X\u008a\u0084\u0002"}, d2 = {"TopAppBar", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", Constants.KEY_ACTIONS, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "expandedHeight", "Landroidx/compose/ui/unit/Dp;", "TopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "CenterAlignedTopAppBar-GHTll3U", Const.SUBTITLE, "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "TopAppBar-cJHQLPU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumTopAppBar", "collapsedHeight", "MediumTopAppBar-oKE7A98", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumFlexibleTopAppBar", "MediumFlexibleTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LargeTopAppBar", "LargeTopAppBar-oKE7A98", "LargeFlexibleTopAppBar", "LargeFlexibleTopAppBar-eXZ4JBQ", "TwoRowsTopAppBar", "", "Lkotlin/ParameterName;", "name", "expanded", "TwoRowsTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "BottomAppBar", "floatingActionButton", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlexibleBottomAppBar", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "FlexibleBottomAppBar-wBhsO_E", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarLayout", "containerHeight", "BottomAppBarLayout-t5fmz9U", "(FLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "rememberBottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "BottomAppBarState", "settleAppBarBottom", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BottomAppBarHorizontalPadding", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "subtitleTextStyle", "SingleRowTopAppBar-wn8IZOc", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalSingleRowTopAppBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/SingleRowTopAppBarOverride;", "getLocalSingleRowTopAppBarOverride$annotations", "()V", "getLocalSingleRowTopAppBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "titleBottomPadding", "smallTitle", "smallTitleTextStyle", "smallSubtitle", "smallSubtitleTextStyle", "TwoRowsTopAppBar-pJA5dT0", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalTwoRowsTopAppBarOverride", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "getLocalTwoRowsTopAppBarOverride$annotations", "getLocalTwoRowsTopAppBarOverride", "adjustHeightOffsetLimit", "TopAppBarLayout", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "navigationIconContentColor", "titleContentColor", "subtitleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "hideTitleSemantics", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "TopAppBarLayout-lyUyIHI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/internal/FloatProducer;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;II)V", "settleAppBar", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rememberTouchExplorationService", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "MediumTitleBottomPadding", "LargeTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "material3", "touchExplorationServiceEnabled"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final ProvidableCompositionLocal<SingleRowTopAppBarOverride> LocalSingleRowTopAppBarOverride;
    private static final ProvidableCompositionLocal<TwoRowsTopAppBarOverride> LocalTwoRowsTopAppBarOverride;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppBar.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AppBarKt", f = "AppBar.kt", i = {0, 0, 0, 1}, l = {3464, 3480}, m = "settleAppBar", n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBar(null, 0.0f, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBarBottom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppBar.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AppBarKt", f = "AppBar.kt", i = {0, 0, 0, 1}, l = {2424, 2440}, m = "settleAppBarBottom", n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C03841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C03841(Continuation<? super C03841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBarBottom(null, 0.0f, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBarLayout_t5fmz9U$lambda$24(float f2, Arrangement.Horizontal horizontal, Modifier modifier, long j, long j2, float f3, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2457BottomAppBarLayoutt5fmz9U(f2, horizontal, modifier, j, j2, f3, paddingValues, windowInsets, bottomAppBarScrollBehavior, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBar_1oL4kX8$lambda$14(Modifier modifier, long j, long j2, float f2, PaddingValues paddingValues, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2453BottomAppBar1oL4kX8(modifier, j, j2, f2, paddingValues, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBar_Snr_uVM$lambda$12(Function3 function3, Modifier modifier, Function2 function2, long j, long j2, float f2, PaddingValues paddingValues, WindowInsets windowInsets, int i, int i2, Composer composer, int i3) {
        m2454BottomAppBarSnr_uVM(function3, modifier, function2, j, j2, f2, paddingValues, windowInsets, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBar_e_3WI5M$lambda$15(Modifier modifier, long j, long j2, float f2, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2455BottomAppBare3WI5M(modifier, j, j2, f2, paddingValues, windowInsets, bottomAppBarScrollBehavior, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBar_qhFBPw4$lambda$13(Function3 function3, Modifier modifier, Function2 function2, long j, long j2, float f2, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m2456BottomAppBarqhFBPw4(function3, modifier, function2, j, j2, f2, paddingValues, windowInsets, bottomAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenterAlignedTopAppBar$lambda$2(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        CenterAlignedTopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenterAlignedTopAppBar_GHTll3U$lambda$3(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m2458CenterAlignedTopAppBarGHTll3U(function2, modifier, function22, function3, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlexibleBottomAppBar_wBhsO_E$lambda$16(Modifier modifier, long j, long j2, PaddingValues paddingValues, Arrangement.Horizontal horizontal, float f2, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2459FlexibleBottomAppBarwBhsO_E(modifier, j, j2, paddingValues, horizontal, f2, windowInsets, bottomAppBarScrollBehavior, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeFlexibleTopAppBar_eXZ4JBQ$lambda$10(Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function3 function3, Alignment.Horizontal horizontal, float f2, float f3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m2460LargeFlexibleTopAppBareXZ4JBQ(function2, modifier, function22, function23, function3, horizontal, f2, f3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeTopAppBar$lambda$8(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        LargeTopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeTopAppBar_oKE7A98$lambda$9(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f2, float f3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m2461LargeTopAppBaroKE7A98(function2, modifier, function22, function3, f2, f3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediumFlexibleTopAppBar_eXZ4JBQ$lambda$7(Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function3 function3, Alignment.Horizontal horizontal, float f2, float f3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m2462MediumFlexibleTopAppBareXZ4JBQ(function2, modifier, function22, function23, function3, horizontal, f2, f3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediumTopAppBar$lambda$5(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        MediumTopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediumTopAppBar_oKE7A98$lambda$6(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f2, float f3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m2463MediumTopAppBaroKE7A98(function2, modifier, function22, function3, f2, f3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleRowTopAppBar_wn8IZOc$lambda$32(Modifier modifier, Function2 function2, TextStyle textStyle, Function2 function22, TextStyle textStyle2, Alignment.Horizontal horizontal, Function2 function23, Function3 function3, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m2464SingleRowTopAppBarwn8IZOc(modifier, function2, textStyle, function22, textStyle2, horizontal, function23, function3, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar$lambda$0(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        TopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$53(Modifier modifier, FloatProducer floatProducer, long j, long j2, long j3, long j4, Function2 function2, TextStyle textStyle, Function2 function22, TextStyle textStyle2, Function0 function0, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, boolean z, Function2 function23, Function2 function24, float f2, int i2, int i3, Composer composer, int i4) {
        m2467TopAppBarLayoutlyUyIHI(modifier, floatProducer, j, j2, j3, j4, function2, textStyle, function22, textStyle2, function0, vertical, horizontal, i, z, function23, function24, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_GHTll3U$lambda$1(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m2465TopAppBarGHTll3U(function2, modifier, function22, function3, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_cJHQLPU$lambda$4(Function2 function2, Function2 function22, Modifier modifier, Function2 function23, Function3 function3, Alignment.Horizontal horizontal, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m2466TopAppBarcJHQLPU(function2, function22, modifier, function23, function3, horizontal, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TwoRowsTopAppBar_eXZ4JBQ$lambda$11(Function3 function3, Modifier modifier, Function3 function32, Function2 function2, Function3 function33, Alignment.Horizontal horizontal, float f2, float f3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m2468TwoRowsTopAppBareXZ4JBQ(function3, modifier, function32, function2, function33, horizontal, f2, f3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TwoRowsTopAppBar_pJA5dT0$lambda$35(Modifier modifier, Function2 function2, TextStyle textStyle, float f2, Function2 function22, TextStyle textStyle2, Function2 function23, TextStyle textStyle3, Function2 function24, TextStyle textStyle4, Alignment.Horizontal horizontal, Function2 function25, Function3 function3, float f3, float f4, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m2469TwoRowsTopAppBarpJA5dT0(modifier, function2, textStyle, f2, function22, textStyle2, function23, textStyle3, function24, textStyle4, horizontal, function25, function3, f3, f4, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalSingleRowTopAppBarOverride$annotations() {
    }

    public static /* synthetic */ void getLocalTwoRowsTopAppBarOverride$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of TopAppBar with expandedHeight parameter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void TopAppBar(final kotlin.jvm.functions.Function2 r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2 r22, kotlin.jvm.functions.Function3 r23, androidx.compose.foundation.layout.WindowInsets r24, androidx.compose.material3.TopAppBarColors r25, androidx.compose.material3.TopAppBarScrollBehavior r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.TopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX INFO: renamed from: TopAppBar-GHTll3U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2465TopAppBarGHTll3U(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, float r31, androidx.compose.foundation.layout.WindowInsets r32, androidx.compose.material3.TopAppBarColors r33, androidx.compose.material3.TopAppBarScrollBehavior r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2465TopAppBarGHTll3U(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void CenterAlignedTopAppBar(final kotlin.jvm.functions.Function2 r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2 r22, kotlin.jvm.functions.Function3 r23, androidx.compose.foundation.layout.WindowInsets r24, androidx.compose.material3.TopAppBarColors r25, androidx.compose.material3.TopAppBarScrollBehavior r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX INFO: renamed from: CenterAlignedTopAppBar-GHTll3U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2458CenterAlignedTopAppBarGHTll3U(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, float r31, androidx.compose.foundation.layout.WindowInsets r32, androidx.compose.material3.TopAppBarColors r33, androidx.compose.material3.TopAppBarScrollBehavior r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2458CenterAlignedTopAppBarGHTll3U(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0111  */
    /* JADX INFO: renamed from: TopAppBar-cJHQLPU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2466TopAppBarcJHQLPU(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Alignment.Horizontal r34, float r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.material3.TopAppBarColors r37, androidx.compose.material3.TopAppBarScrollBehavior r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 679
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2466TopAppBarcJHQLPU(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.ui.Alignment$Horizontal, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void MediumTopAppBar(final kotlin.jvm.functions.Function2 r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2 r23, kotlin.jvm.functions.Function3 r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.MediumTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX INFO: renamed from: MediumTopAppBar-oKE7A98, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2463MediumTopAppBaroKE7A98(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.ui.Modifier r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, float r38, float r39, androidx.compose.foundation.layout.WindowInsets r40, androidx.compose.material3.TopAppBarColors r41, androidx.compose.material3.TopAppBarScrollBehavior r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2463MediumTopAppBaroKE7A98(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    /* JADX INFO: renamed from: MediumFlexibleTopAppBar-eXZ4JBQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2462MediumFlexibleTopAppBareXZ4JBQ(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.ui.Alignment.Horizontal r43, float r44, float r45, androidx.compose.foundation.layout.WindowInsets r46, androidx.compose.material3.TopAppBarColors r47, androidx.compose.material3.TopAppBarScrollBehavior r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 861
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2462MediumFlexibleTopAppBareXZ4JBQ(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.ui.Alignment$Horizontal, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void LargeTopAppBar(final kotlin.jvm.functions.Function2 r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2 r23, kotlin.jvm.functions.Function3 r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.LargeTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX INFO: renamed from: LargeTopAppBar-oKE7A98, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2461LargeTopAppBaroKE7A98(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.ui.Modifier r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, float r38, float r39, androidx.compose.foundation.layout.WindowInsets r40, androidx.compose.material3.TopAppBarColors r41, androidx.compose.material3.TopAppBarScrollBehavior r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2461LargeTopAppBaroKE7A98(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    /* JADX INFO: renamed from: LargeFlexibleTopAppBar-eXZ4JBQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2460LargeFlexibleTopAppBareXZ4JBQ(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.ui.Alignment.Horizontal r43, float r44, float r45, androidx.compose.foundation.layout.WindowInsets r46, androidx.compose.material3.TopAppBarColors r47, androidx.compose.material3.TopAppBarScrollBehavior r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 861
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2460LargeFlexibleTopAppBareXZ4JBQ(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.ui.Alignment$Horizontal, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0112  */
    /* JADX INFO: renamed from: TwoRowsTopAppBar-eXZ4JBQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2468TwoRowsTopAppBareXZ4JBQ(final kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.ui.Alignment.Horizontal r43, float r44, float r45, androidx.compose.foundation.layout.WindowInsets r46, androidx.compose.material3.TopAppBarColors r47, androidx.compose.material3.TopAppBarScrollBehavior r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 894
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2468TwoRowsTopAppBareXZ4JBQ(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.ui.Alignment$Horizontal, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010b  */
    /* JADX INFO: renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2454BottomAppBarSnr_uVM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, long r30, long r32, float r34, androidx.compose.foundation.layout.PaddingValues r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2454BottomAppBarSnr_uVM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX INFO: renamed from: BottomAppBar-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2456BottomAppBarqhFBPw4(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, long r30, long r32, float r34, androidx.compose.foundation.layout.PaddingValues r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.material3.BottomAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2456BottomAppBarqhFBPw4(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX INFO: renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2453BottomAppBar1oL4kX8(androidx.compose.ui.Modifier r24, long r25, long r27, float r29, androidx.compose.foundation.layout.PaddingValues r30, androidx.compose.foundation.layout.WindowInsets r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2453BottomAppBar1oL4kX8(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010f  */
    /* JADX INFO: renamed from: BottomAppBar-e-3WI5M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2455BottomAppBare3WI5M(androidx.compose.ui.Modifier r28, long r29, long r31, float r33, androidx.compose.foundation.layout.PaddingValues r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.BottomAppBarScrollBehavior r36, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2455BottomAppBare3WI5M(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX INFO: renamed from: FlexibleBottomAppBar-wBhsO_E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2459FlexibleBottomAppBarwBhsO_E(androidx.compose.ui.Modifier r29, long r30, long r32, androidx.compose.foundation.layout.PaddingValues r34, androidx.compose.foundation.layout.Arrangement.Horizontal r35, float r36, androidx.compose.foundation.layout.WindowInsets r37, androidx.compose.material3.BottomAppBarScrollBehavior r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2459FlexibleBottomAppBarwBhsO_E(androidx.compose.ui.Modifier, long, long, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.Arrangement$Horizontal, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0117  */
    /* JADX INFO: renamed from: BottomAppBarLayout-t5fmz9U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m2457BottomAppBarLayoutt5fmz9U(final float r30, final androidx.compose.foundation.layout.Arrangement.Horizontal r31, androidx.compose.ui.Modifier r32, final long r33, final long r35, final float r37, final androidx.compose.foundation.layout.PaddingValues r38, final androidx.compose.foundation.layout.WindowInsets r39, final androidx.compose.material3.BottomAppBarScrollBehavior r40, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2457BottomAppBarLayoutt5fmz9U(float, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBarLayout_t5fmz9U$lambda$19$lambda$18(BottomAppBarScrollBehavior bottomAppBarScrollBehavior, float f2) {
        BottomAppBarState state = bottomAppBarScrollBehavior.getState();
        state.setHeightOffset(state.getHeightOffset() - f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22(BottomAppBarScrollBehavior bottomAppBarScrollBehavior, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        BottomAppBarState state;
        BottomAppBarState state2;
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(constraints.getValue());
        if (bottomAppBarScrollBehavior != null && (state2 = bottomAppBarScrollBehavior.getState()) != null) {
            state2.setHeightOffsetLimit(-placeableMo7445measureBRTryo0.getHeight());
        }
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), MathKt.roundToInt(RangesKt.coerceAtLeast(placeableMo7445measureBRTryo0.getHeight() + ((bottomAppBarScrollBehavior == null || (state = bottomAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getHeightOffset()), 0.0f)), null, new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppBarKt.BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22$lambda$21(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22$lambda$21(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final TopAppBarState rememberTopAppBarState(final float f2, final float f3, final float f4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1801969826, "C(rememberTopAppBarState)N(initialHeightOffsetLimit,initialHeightOffset,initialContentOffset)1858@91732L99,1858@91685L146:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, i, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1857)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, 821190565, "CC(remember):AppBar.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(f2)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f3)) || (i & 48) == 32);
        if ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(f4)) && (i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBarKt.rememberTopAppBarState$lambda$26$lambda$25(f2, f3, f4);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TopAppBarState rememberTopAppBarState$lambda$26$lambda$25(float f2, float f3, float f4) {
        return new TopAppBarState(f2, f3, f4);
    }

    public static final BottomAppBarState rememberBottomAppBarState(final float f2, final float f3, final float f4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1420874240, "C(rememberBottomAppBarState)N(initialHeightOffsetLimit,initialHeightOffset,initialContentOffset)2235@107287L102,2235@107237L152:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420874240, i, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:2234)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomAppBarState, ?> saver = BottomAppBarState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -339446298, "CC(remember):AppBar.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(f2)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f3)) || (i & 48) == 32);
        if ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(f4)) && (i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBarKt.BottomAppBarState(f2, f3, f4);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BottomAppBarState bottomAppBarState = (BottomAppBarState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return bottomAppBarState;
    }

    public static final BottomAppBarState BottomAppBarState(float f2, float f3, float f4) {
        return new BottomAppBarStateImpl(f2, f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object settleAppBarBottom(androidx.compose.material3.BottomAppBarState r21, float r22, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r23, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r25) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBarBottom(androidx.compose.material3.BottomAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit settleAppBarBottom$lambda$29(Ref.FloatRef floatRef, BottomAppBarState bottomAppBarState, Ref.FloatRef floatRef2, AnimationScope animationScope) {
        float fFloatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        float heightOffset = bottomAppBarState.getHeightOffset();
        bottomAppBarState.setHeightOffset(heightOffset + fFloatValue);
        float fAbs = Math.abs(heightOffset - bottomAppBarState.getHeightOffset());
        floatRef.element = ((Number) animationScope.getValue()).floatValue();
        floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
        if (Math.abs(fFloatValue - fAbs) > 0.5f) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit settleAppBarBottom$lambda$30(BottomAppBarState bottomAppBarState, AnimationScope animationScope) {
        bottomAppBarState.setHeightOffset(((Number) animationScope.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX INFO: renamed from: SingleRowTopAppBar-wn8IZOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m2464SingleRowTopAppBarwn8IZOc(androidx.compose.ui.Modifier r31, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, final androidx.compose.ui.text.TextStyle r33, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, final androidx.compose.ui.text.TextStyle r35, final androidx.compose.ui.Alignment.Horizontal r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, final float r39, final androidx.compose.foundation.layout.WindowInsets r40, final androidx.compose.material3.TopAppBarColors r41, final androidx.compose.material3.TopAppBarScrollBehavior r42, androidx.compose.runtime.Composer r43, final int r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2464SingleRowTopAppBarwn8IZOc(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, androidx.compose.ui.Alignment$Horizontal, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<SingleRowTopAppBarOverride> getLocalSingleRowTopAppBarOverride() {
        return LocalSingleRowTopAppBarOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleRowTopAppBarOverride LocalSingleRowTopAppBarOverride$lambda$33() {
        return DefaultSingleRowTopAppBarOverride.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0113  */
    /* JADX INFO: renamed from: TwoRowsTopAppBar-pJA5dT0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m2469TwoRowsTopAppBarpJA5dT0(androidx.compose.ui.Modifier r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final androidx.compose.ui.text.TextStyle r36, final float r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, final androidx.compose.ui.text.TextStyle r39, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, final androidx.compose.ui.text.TextStyle r41, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, final androidx.compose.ui.text.TextStyle r43, final androidx.compose.ui.Alignment.Horizontal r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, final float r47, final float r48, final androidx.compose.foundation.layout.WindowInsets r49, final androidx.compose.material3.TopAppBarColors r50, final androidx.compose.material3.TopAppBarScrollBehavior r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instruction units count: 765
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m2469TwoRowsTopAppBarpJA5dT0(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, androidx.compose.ui.Alignment$Horizontal, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TwoRowsTopAppBarOverride> getLocalTwoRowsTopAppBarOverride() {
        return LocalTwoRowsTopAppBarOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TwoRowsTopAppBarOverride LocalTwoRowsTopAppBarOverride$lambda$36() {
        return DefaultTwoRowsTopAppBarOverride.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier adjustHeightOffsetLimit(Modifier modifier, TopAppBarScrollBehavior topAppBarScrollBehavior) {
        final TopAppBarState state;
        Modifier modifierOnSizeChanged;
        return (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null || (modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifier, new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppBarKt.adjustHeightOffsetLimit$lambda$38$lambda$37(state, (IntSize) obj);
            }
        })) == null) ? modifier : modifierOnSizeChanged;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adjustHeightOffsetLimit$lambda$38$lambda$37(TopAppBarState topAppBarState, IntSize intSize) {
        topAppBarState.setHeightOffsetLimit(-(((int) (intSize.m9005unboximpl() & 4294967295L)) - topAppBarState.getHeightOffset()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TopAppBarLayout-lyUyIHI, reason: not valid java name */
    public static final void m2467TopAppBarLayoutlyUyIHI(final Modifier modifier, final FloatProducer floatProducer, final long j, final long j2, final long j3, final long j4, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final TextStyle textStyle2, final Function0<Float> function0, final Arrangement.Vertical vertical, Alignment.Horizontal horizontal, final int i, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final float f2, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        Alignment.Horizontal horizontal2;
        Composer composer2;
        int i7;
        String str;
        int i8;
        int i9;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function25;
        String str2;
        String str3;
        Modifier.Companion companionClearAndSetSemantics;
        boolean z2;
        String str4;
        String str5;
        Modifier.Companion companionClearAndSetSemantics2;
        Composer composerStartRestartGroup = composer.startRestartGroup(126395868);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBarLayout)N(modifier,scrolledOffset,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,subtitleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color,title,titleTextStyle,subtitle,subtitleTextStyle,titleAlpha,titleVerticalArrangement,titleHorizontalAlignment,titleBottomPadding,hideTitleSemantics,navigationIcon,actions,height:c#ui.unit.Dp)3053@144004L469,2995@141484L2996:AppBar.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? composerStartRestartGroup.changed(floatProducer) : composerStartRestartGroup.changedInstance(floatProducer) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 = i4 | (composerStartRestartGroup.changed(j2) ? 2048 : 1024);
        } else {
            i5 = i4;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(j3) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(j4) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changed(textStyle) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function22) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i5 |= composerStartRestartGroup.changed(textStyle2) ? 536870912 : 268435456;
        }
        int i11 = i5;
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(vertical) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= composerStartRestartGroup.changed(horizontal) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i6 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute(((i11 & 306783379) == 306783378 && (4793491 & i6) == 4793490) ? false : true, i11 & 1)) {
            horizontal2 = horizontal;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(126395868, i11, i6, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2994)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1207447665, "CC(remember):AppBar.kt#9igjgp");
            int i12 = i6 & 896;
            boolean z3 = ((i11 & 112) == 32 || ((i11 & 64) != 0 && composerStartRestartGroup.changed(floatProducer))) | ((i6 & 112) == 32) | (i12 == 256) | ((i6 & 7168) == 2048) | ((29360128 & i6) == 8388608);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                i7 = i12;
                str = "CC(remember):AppBar.kt#9igjgp";
                i8 = i6;
                i9 = i11;
                i10 = 0;
                function25 = function23;
                objRememberedValue = new TopAppBarMeasurePolicy(floatProducer, vertical, horizontal, i, f2, null);
                horizontal2 = horizontal;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                function25 = function23;
                str = "CC(remember):AppBar.kt#9igjgp";
                i8 = i6;
                i7 = i12;
                i9 = i11;
                i10 = 0;
                horizontal2 = horizontal;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TopAppBarMeasurePolicy topAppBarMeasurePolicy = (TopAppBarMeasurePolicy) objRememberedValue;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, i10);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, topAppBarMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1360991215, "C2997@141514L281,3044@143662L265:AppBar.kt#uh7d8r");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "navigationIcon");
            float f3 = TopAppBarHorizontalPadding;
            Modifier modifierM1155paddingqDBjuR0$default = PaddingKt.m1155paddingqDBjuR0$default(modifierLayoutId, f3, 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1155paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1301830080, "C2998@141617L164:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j)), function25, composerStartRestartGroup, ProvidedValue.$stable | ((i8 >> 12) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(-1360720648);
                ComposerKt.sourceInformation(composerStartRestartGroup, "3012@142259L24,3004@141848L997");
                Modifier modifierM1153paddingVpY3zN4$default = PaddingKt.m1153paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "title"), f3, 0.0f, 2, null);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(510303260);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "3009@142137L2");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    str5 = str;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 510303911, str5);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$51$lambda$41$lambda$40((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionClearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    str5 = str;
                    composerStartRestartGroup.startReplaceGroup(510305197);
                    composerStartRestartGroup.endReplaceGroup();
                    companionClearAndSetSemantics2 = Modifier.INSTANCE;
                }
                Modifier modifierThen = modifierM1153paddingVpY3zN4$default.then(companionClearAndSetSemantics2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 510307837, str5);
                z2 = (i8 & 14) == 4;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$51$lambda$43$lambda$42(function0, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierThen, (Function1) objRememberedValue3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), horizontal2, composerStartRestartGroup, (i7 >> 3) & 112);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composerStartRestartGroup);
                Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -190335683, "C3015@142393L202,3020@142616L211:AppBar.kt#uh7d8r");
                int i13 = i9 >> 18;
                int i14 = i9 >> 12;
                ProvideContentColorTextStyleKt.m4064ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, composerStartRestartGroup, ((i9 >> 9) & 14) | (i13 & 112) | (i14 & 896));
                composer2 = composerStartRestartGroup;
                str2 = "C72@3468L9:Box.kt#2w3rfo";
                str3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                ProvideContentColorTextStyleKt.m4064ProvideContentColorTextStyle3JVO9M(j3, textStyle2, function22, composer2, (i14 & 14) | ((i9 >> 24) & 112) | (i13 & 896));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            } else {
                str2 = "C72@3468L9:Box.kt#2w3rfo";
                composer2 = composerStartRestartGroup;
                String str6 = str;
                str3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                composer2.startReplaceGroup(-1359701523);
                ComposerKt.sourceInformation(composer2, "3035@143350L24,3027@142942L693");
                Modifier modifierM1153paddingVpY3zN4$default2 = PaddingKt.m1153paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "title"), f3, 0.0f, 2, null);
                if (z) {
                    composer2.startReplaceGroup(510338172);
                    ComposerKt.sourceInformation(composer2, "3032@143228L2");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 510338823, str6);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$51$lambda$46$lambda$45((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    companionClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) objRememberedValue4);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(510340109);
                    composer2.endReplaceGroup();
                    companionClearAndSetSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen2 = modifierM1153paddingVpY3zN4$default2.then(companionClearAndSetSemantics);
                ComposerKt.sourceInformationMarkerStart(composer2, 510342749, str6);
                z2 = (i8 & 14) == 4;
                Object objRememberedValue5 = composer2.rememberedValue();
                if (z2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$51$lambda$48$lambda$47(function0, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifierThen2, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str3);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str4);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierGraphicsLayer2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5069constructorimpl4 = Updater.m5069constructorimpl(composer2);
                Updater.m5077setimpl(composerM5069constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5069constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composerM5069constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM5069constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m5077setimpl(composerM5069constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, str2);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -314975490, "C3037@143415L202:AppBar.kt#uh7d8r");
                ProvideContentColorTextStyleKt.m4064ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, composer2, ((i9 >> 9) & 14) | ((i9 >> 18) & 112) | ((i9 >> 12) & 896));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            }
            Modifier modifierM1155paddingqDBjuR0$default2 = PaddingKt.m1155paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "actionIcons"), 0.0f, 0.0f, f3, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str4);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierM1155paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            Composer composerM5069constructorimpl5 = Updater.m5069constructorimpl(composer2);
            Updater.m5077setimpl(composerM5069constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                composerM5069constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composerM5069constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m5077setimpl(composerM5069constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, str2);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1525354718, "C3045@143760L153:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j4)), function24, composer2, ProvidedValue.$stable | ((i8 >> 15) & 112));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Alignment.Horizontal horizontal3 = horizontal2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$53(modifier, floatProducer, j, j2, j3, j4, function2, textStyle, function22, textStyle2, function0, vertical, horizontal3, i, z, function23, function24, f2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$41$lambda$40(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$43$lambda$42(Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$46$lambda$45(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$48$lambda$47(Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object settleAppBar(androidx.compose.material3.TopAppBarState r21, float r22, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r23, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r25) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit settleAppBar$lambda$54(Ref.FloatRef floatRef, TopAppBarState topAppBarState, Ref.FloatRef floatRef2, AnimationScope animationScope) {
        float fFloatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        float heightOffset = topAppBarState.getHeightOffset();
        topAppBarState.setHeightOffset(heightOffset + fFloatValue);
        float fAbs = Math.abs(heightOffset - topAppBarState.getHeightOffset());
        floatRef.element = ((Number) animationScope.getValue()).floatValue();
        floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
        if (Math.abs(fFloatValue - fAbs) > 0.5f) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit settleAppBar$lambda$55(TopAppBarState topAppBarState, AnimationScope animationScope) {
        topAppBarState.setHeightOffset(((Number) animationScope.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    private static final State<Boolean> rememberTouchExplorationService(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1660719518, "C(rememberTouchExplorationService)3498@163258L171:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1660719518, i, -1, "androidx.compose.material3.rememberTouchExplorationService (AppBar.kt:3498)");
        }
        State<Boolean> stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(true, false, false, composer, 438, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberAccessibilityServiceState;
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    private static final boolean BottomAppBarLayout_t5fmz9U$lambda$17(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float f2 = 16;
        float f3 = 12;
        float fM8830constructorimpl = Dp.m8830constructorimpl(Dp.m8830constructorimpl(f2) - Dp.m8830constructorimpl(f3));
        BottomAppBarHorizontalPadding = fM8830constructorimpl;
        float fM8830constructorimpl2 = Dp.m8830constructorimpl(Dp.m8830constructorimpl(f2) - Dp.m8830constructorimpl(f3));
        BottomAppBarVerticalPadding = fM8830constructorimpl2;
        FABHorizontalPadding = Dp.m8830constructorimpl(Dp.m8830constructorimpl(f2) - fM8830constructorimpl);
        FABVerticalPadding = Dp.m8830constructorimpl(Dp.m8830constructorimpl(f3) - fM8830constructorimpl2);
        LocalSingleRowTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppBarKt.LocalSingleRowTopAppBarOverride$lambda$33();
            }
        }, 1, null);
        LocalTwoRowsTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppBarKt.LocalTwoRowsTopAppBarOverride$lambda$36();
            }
        }, 1, null);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.m8830constructorimpl(24);
        LargeTitleBottomPadding = Dp.m8830constructorimpl(28);
        float fM8830constructorimpl3 = Dp.m8830constructorimpl(4);
        TopAppBarHorizontalPadding = fM8830constructorimpl3;
        TopAppBarTitleInset = Dp.m8830constructorimpl(Dp.m8830constructorimpl(f2) - fM8830constructorimpl3);
    }
}
