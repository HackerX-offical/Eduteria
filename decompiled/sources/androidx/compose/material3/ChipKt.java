package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.clevertap.android.sdk.Constants;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a¨\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a°\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001a°\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001aÇ\u0001\u0010 \u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\"\u001a\u0091\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a\u0091\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a¸\u0001\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b1\u00102\u001aÍ\u0001\u00103\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b4\u00105\u001a\u0091\u0001\u00106\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b9\u0010:\u001a\u0091\u0001\u0010;\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b<\u0010:\u001aN\u0010=\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,H\u0003¢\u0006\u0004\b>\u0010?\u001a9\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00108\u001a\u00020,H\u0003¢\u0006\u0004\bA\u0010B\u001a%\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HE0D\"\u0004\b\u0000\u0010E2\b\u0010F\u001a\u0004\u0018\u0001HEH\u0003¢\u0006\u0002\u0010G\u001a&\u0010L\u001a\u0002002\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\tH\u0002\"\u0018\u0010H\u001a\u00020\u000f*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K\"\u0010\u0010P\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Q\"\u000e\u0010R\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "", ChipKt.LeadingIconLayoutId, ChipKt.TrailingIconLayoutId, "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", Constants.KEY_BORDER, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedAssistChip", "FilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedFilterChip", "InputChip", "avatar", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ElevatedSuggestionChip", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "Landroidx/compose/ui/unit/Dp;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "AnimatingChipContent", "AnimatingChipContent-fe0OD_I", "leadingContent", "leadingContent-XO-JAsU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "trailingContent", "trailingContent-RPmYEkk", "(Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRetainedState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "targetValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "defaultSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "HorizontalElementsPadding", "F", "AssistChipPadding", "FilterChipPadding", "SuggestionChipPadding", "LeadingIconLayoutId", "", "LabelLayoutId", "TrailingIconLayoutId", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    private static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatingChipContent_fe0OD_I$lambda$24(Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Function2 function24, long j2, long j3, float f2, PaddingValues paddingValues, int i, Composer composer, int i2) {
        m2586AnimatingChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f2, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssistChip$lambda$0(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        AssistChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssistChip$lambda$2(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        AssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipContent_fe0OD_I$lambda$23(Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Function2 function24, long j2, long j3, float f2, PaddingValues paddingValues, int i, Composer composer, int i2) {
        m2588ChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f2, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip_nkUnTEs$lambda$18(Modifier modifier, Function0 function0, boolean z, Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, float f2, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m2587ChipnkUnTEs(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f2, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ElevatedAssistChip$lambda$3(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedAssistChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ElevatedAssistChip$lambda$5(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedAssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ElevatedFilterChip$lambda$7(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedFilterChip(z, function0, function2, modifier, z2, function22, function23, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ElevatedSuggestionChip$lambda$12(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        ElevatedSuggestionChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ElevatedSuggestionChip$lambda$14(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        ElevatedSuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChip$lambda$6(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        FilterChip(z, function0, function2, modifier, z2, function22, function23, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputChip$lambda$8(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Function2 function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        InputChip(z, function0, function2, modifier, z2, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectableChip_u0RnIRE$lambda$22(boolean z, Modifier modifier, Function0 function0, boolean z2, Function2 function2, TextStyle textStyle, Function2 function22, Function2 function23, Function2 function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, float f2, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m2589SelectableChipu0RnIRE(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f2, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuggestionChip$lambda$11(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        SuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuggestionChip$lambda$9(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        SuggestionChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AssistChip(final kotlin.jvm.functions.Function0<kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.foundation.BorderStroke r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.AssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void AssistChip(final kotlin.jvm.functions.Function0 r35, final kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.material3.ChipBorder r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 875
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.AssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ElevatedAssistChip(final kotlin.jvm.functions.Function0<kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.foundation.BorderStroke r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedAssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void ElevatedAssistChip(final kotlin.jvm.functions.Function0 r35, final kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.material3.ChipBorder r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedAssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilterChip(final boolean r41, final kotlin.jvm.functions.Function0<kotlin.Unit> r42, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.ui.Modifier r44, boolean r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.ui.graphics.Shape r48, androidx.compose.material3.SelectableChipColors r49, androidx.compose.material3.SelectableChipElevation r50, androidx.compose.foundation.BorderStroke r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.FilterChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ElevatedFilterChip(final boolean r36, final kotlin.jvm.functions.Function0<kotlin.Unit> r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.ui.graphics.Shape r43, androidx.compose.material3.SelectableChipColors r44, androidx.compose.material3.SelectableChipElevation r45, androidx.compose.foundation.BorderStroke r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedFilterChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void InputChip(final boolean r43, final kotlin.jvm.functions.Function0<kotlin.Unit> r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.ui.Modifier r46, boolean r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.ui.graphics.Shape r51, androidx.compose.material3.SelectableChipColors r52, androidx.compose.material3.SelectableChipElevation r53, androidx.compose.foundation.BorderStroke r54, androidx.compose.foundation.interaction.MutableInteractionSource r55, androidx.compose.runtime.Composer r56, final int r57, final int r58, final int r59) {
        /*
            Method dump skipped, instruction units count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.InputChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ChipKt$InputChip$1, reason: invalid class name */
    /* JADX INFO: compiled from: Chip.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
        final /* synthetic */ float $avatarOpacity;
        final /* synthetic */ Shape $avatarShape;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(float f2, Shape shape, Function2<? super Composer, ? super Integer, Unit> function2) {
            this.$avatarOpacity = f2;
            this.$avatarShape = shape;
            this.$avatar = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C656@32117L180,654@32034L388:Chip.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-570452295, i, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:654)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1551161805, "CC(remember):Chip.kt#9igjgp");
            boolean zChanged = composer.changed(this.$avatarOpacity) | composer.changed(this.$avatarShape);
            final float f2 = this.$avatarOpacity;
            final Shape shape = this.$avatarShape;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ChipKt$InputChip$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.AnonymousClass1.invoke$lambda$1$lambda$0(f2, shape, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue);
            Alignment center = Alignment.INSTANCE.getCenter();
            Function2<Composer, Integer, Unit> function2 = this.$avatar;
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1351092324, "C663@32396L8:Chip.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(float f2, Shape shape, GraphicsLayerScope graphicsLayerScope) {
            graphicsLayerScope.setAlpha(f2);
            graphicsLayerScope.setShape(shape);
            graphicsLayerScope.setClip(true);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SuggestionChip(final kotlin.jvm.functions.Function0<kotlin.Unit> r32, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.SuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    /* JADX WARN: Type inference failed for: r5v16, types: [androidx.compose.runtime.State] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v31 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void SuggestionChip(final kotlin.jvm.functions.Function0 r32, final kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.SuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ElevatedSuggestionChip(final kotlin.jvm.functions.Function0<kotlin.Unit> r32, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedSuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void ElevatedSuggestionChip(final kotlin.jvm.functions.Function0 r32, final kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedSuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: Chip-nkUnTEs, reason: not valid java name */
    private static final void m2587ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final float f2, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Composer composerStartRestartGroup = composer.startRestartGroup(892465622);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Chip)N(modifier,onClick,enabled,label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)1962@97212L22,1969@97509L478,1960@97138L849:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function24 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(textStyle) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i3 |= composerStartRestartGroup.changed(chipColors) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(chipElevation) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(borderStroke) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 9363) == 9362) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892465622, i3, i5, "androidx.compose.material3.Chip (Chip.kt:1957)");
            }
            if (mutableInteractionSource2 == null) {
                composerStartRestartGroup.startReplaceGroup(1596346437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1959@97094L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1333978275, "CC(remember):Chip.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1333978926);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1333974516, "CC(remember):Chip.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.Chip_nkUnTEs$lambda$17$lambda$16((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State<Dp> stateShadowElevation$material3 = null;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue2, 1, null);
            long jM2562containerColorvNxB06k$material3 = chipColors.m2562containerColorvNxB06k$material3(z);
            if (chipElevation == null) {
                composerStartRestartGroup.startReplaceGroup(1596621344);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1333969407);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1966@97371L43");
                stateShadowElevation$material3 = chipElevation.shadowElevation$material3(z, mutableInteractionSource2, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i5 << 6) & 896));
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            int i6 = i3;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
            SurfaceKt.m3534Surfaceo_FOJdg(function0, modifierSemantics$default, z, shape, jM2562containerColorvNxB06k$material3, 0L, 0.0f, stateShadowElevation$material3 != null ? stateShadowElevation$material3.getValue().m8844unboximpl() : Dp.m8830constructorimpl(0), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-70915349, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C1970@97519L462:Chip.kt#uh7d8r");
                    if (composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-70915349, i7, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1970)");
                        }
                        ChipKt.m2588ChipContentfe0OD_I(function25, textStyle, j, function22, null, function23, chipColors.m2573leadingIconContentColorvNxB06k$material3(z), chipColors.m2574trailingIconContentColorvNxB06k$material3(z), f2, paddingValues, composer3, 24576);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composer2, 54), composer2, ((i6 >> 15) & 7168) | ((i6 >> 3) & 14) | (i6 & 896) | ((i5 << 21) & 234881024), 6, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip_nkUnTEs$lambda$18(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f2, paddingValues, mutableInteractionSource, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip_nkUnTEs$lambda$17$lambda$16(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8013getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    private static final void m2589SelectableChipu0RnIRE(final boolean z, final Modifier modifier, final Function0<Unit> function0, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f2, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2;
        State<Dp> stateShadowElevation$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1786844928);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectableChip)N(selected,modifier,onClick,enabled,label,labelTextStyle,leadingIcon,avatar,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)2009@98774L24,2016@99083L670,2006@98671L1082:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changed(textStyle) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(selectableChipColors) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(selectableChipElevation) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(borderStroke) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (74899 & i5) == 74898) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1786844928, i3, i5, "androidx.compose.material3.SelectableChip (Chip.kt:2003)");
            }
            if (mutableInteractionSource == null) {
                composerStartRestartGroup.startReplaceGroup(73215547);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2005@98627L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -828922201, "CC(remember):Chip.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(-828922852);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = mutableInteractionSource;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -828917512, "CC(remember):Chip.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.SelectableChip_u0RnIRE$lambda$21$lambda$20((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = i3;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue2, 1, null);
            long jM3402containerColorWaAFU9c$material3 = selectableChipColors.m3402containerColorWaAFU9c$material3(z2, z);
            if (selectableChipElevation == null) {
                composerStartRestartGroup.startReplaceGroup(73531126);
                composerStartRestartGroup.endReplaceGroup();
                stateShadowElevation$material3 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-828912021);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2013@98945L43");
                stateShadowElevation$material3 = selectableChipElevation.shadowElevation$material3(z2, mutableInteractionSource2, composerStartRestartGroup, ((i6 >> 9) & 14) | ((i5 << 3) & 896));
                composerStartRestartGroup.endReplaceGroup();
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.m3532Surfaced85dljk(z, function0, modifierSemantics$default, z2, shape, jM3402containerColorWaAFU9c$material3, 0L, 0.0f, stateShadowElevation$material3 != null ? stateShadowElevation$material3.getValue().m8844unboximpl() : Dp.m8830constructorimpl(0), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-990050154, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C2019@99228L519:Chip.kt#uh7d8r");
                    if (composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-990050154, i7, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:2019)");
                        }
                        ChipKt.m2586AnimatingChipContentfe0OD_I(function2, textStyle, selectableChipColors.m3404labelColorWaAFU9c$material3(z2, z), function22, function23, function24, selectableChipColors.m3405leadingIconContentColorWaAFU9c$material3(z2, z), selectableChipColors.m3406trailingIconContentColorWaAFU9c$material3(z2, z), f2, paddingValues, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composer2, 54), composer2, (i6 & 14) | ((i6 >> 3) & 112) | (i6 & 7168) | ((i6 >> 15) & 57344) | ((i5 << 21) & 1879048192), 48, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.SelectableChip_u0RnIRE$lambda$22(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f2, paddingValues, mutableInteractionSource, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectableChip_u0RnIRE$lambda$21$lambda$20(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8015getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    public static final void m2588ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f2, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        long j4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j5;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1105630840);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2056@100480L1721,2053@100353L1848:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            j4 = j;
            i2 |= composerStartRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j;
        }
        if ((i & 3072) == 0) {
            function25 = function22;
            i2 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((i & 24576) == 0) {
            function26 = function23;
            i2 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((196608 & i) == 0) {
            function27 = function24;
            i2 |= composerStartRestartGroup.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function24;
        }
        if ((1572864 & i) == 0) {
            j5 = j2;
            i2 |= composerStartRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((12582912 & i) == 0) {
            i3 = i2 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i3 |= composerStartRestartGroup.changed(paddingValues) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105630840, i3, -1, "androidx.compose.material3.ChipContent (Chip.kt:2052)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final long j6 = j5;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(-2130105544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    int i5;
                    String str;
                    ComposerKt.sourceInformation(composer2, "C2093@102146L38,2057@100490L1705:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2130105544, i4, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:2057)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m1206defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f2, 1, null), paddingValues);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1668025758, "CC(remember):Chip.kt#9igjgp");
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ChipLayoutMeasurePolicy();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ChipLayoutMeasurePolicy chipLayoutMeasurePolicy = (ChipLayoutMeasurePolicy) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Function2<Composer, Integer, Unit> function211 = function29;
                    Function2<Composer, Integer, Unit> function212 = function28;
                    Function2<Composer, Integer, Unit> function213 = function210;
                    long j7 = j6;
                    Function2<Composer, Integer, Unit> function214 = function2;
                    long j8 = j3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                    Updater.m5077setimpl(composerM5069constructorimpl, chipLayoutMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -411001482, "C2073@101229L326:Chip.kt#uh7d8r");
                    if (function211 == null && function212 == null) {
                        composer2.startReplaceGroup(-410471693);
                        composer2.endReplaceGroup();
                        str = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                        i5 = -692256719;
                    } else {
                        composer2.startReplaceGroup(-410987750);
                        ComposerKt.sourceInformation(composer2, "2061@100697L497");
                        Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "leadingIcon");
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composer2);
                        Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1737582560, "C2066@100955L53:Chip.kt#uh7d8r");
                        i5 = -692256719;
                        str = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                        Function2 function2M2594leadingContentXOJAsU = ChipKt.m2594leadingContentXOJAsU(function211, function212, j7, composer2, 0);
                        if (function2M2594leadingContentXOJAsU != null) {
                            composer2.startReplaceGroup(-1737425918);
                            ComposerKt.sourceInformation(composer2, "2068@101099L16");
                            function2M2594leadingContentXOJAsU.invoke(composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-1737349038);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    }
                    Modifier modifierM1152paddingVpY3zN4 = PaddingKt.m1152paddingVpY3zN4(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), ChipKt.HorizontalElementsPadding, Dp.m8830constructorimpl(0));
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1152paddingVpY3zN4);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, i5, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composer2);
                    Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1437742697, "C2078@101527L7:Chip.kt#uh7d8r");
                    function214.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (function213 != null) {
                        composer2.startReplaceGroup(-410073157);
                        ComposerKt.sourceInformation(composer2, "2081@101620L464");
                        Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "trailingIcon");
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId2);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1073567083, "C2085@101848L48:Chip.kt#uh7d8r");
                        Function2 function2M2595trailingContentRPmYEkk = ChipKt.m2595trailingContentRPmYEkk(function213, j8, composer2, 0);
                        if (function2M2595trailingContentRPmYEkk != null) {
                            composer2.startReplaceGroup(1073690090);
                            ComposerKt.sourceInformation(composer2, "2087@101988L17");
                            function2M2595trailingContentRPmYEkk.invoke(composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1073767931);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-409588813);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j7 = j4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.ChipContent_fe0OD_I$lambda$23(function2, textStyle, j7, function22, function23, function24, j2, j3, f2, paddingValues, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: AnimatingChipContent-fe0OD_I, reason: not valid java name */
    public static final void m2586AnimatingChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f2, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        long j4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j5;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2070754602);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatingChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2118@102851L4086,2115@102724L4213:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            j4 = j;
            i2 |= composerStartRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j;
        }
        if ((i & 3072) == 0) {
            function25 = function22;
            i2 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((i & 24576) == 0) {
            function26 = function23;
            i2 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((196608 & i) == 0) {
            function27 = function24;
            i2 |= composerStartRestartGroup.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function24;
        }
        if ((1572864 & i) == 0) {
            j5 = j2;
            i2 |= composerStartRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((12582912 & i) == 0) {
            i3 = i2 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i3 |= composerStartRestartGroup.changed(paddingValues) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070754602, i3, -1, "androidx.compose.material3.AnimatingChipContent (Chip.kt:2114)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final long j6 = j5;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(-668234218, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C2120@102988L14,2121@103063L14,2122@103137L16,2123@103216L16,2197@106882L38,2124@103241L3690:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-668234218, i4, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous> (Chip.kt:2120)");
                    }
                    FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composer2, 6);
                    FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer2, 6);
                    FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer2, 6);
                    FiniteAnimationSpec finiteAnimationSpecValue4 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m1206defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f2, 1, null), paddingValues);
                    ComposerKt.sourceInformationMarkerStart(composer2, 2072139932, "CC(remember):Chip.kt#9igjgp");
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ChipLayoutMeasurePolicy();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ChipLayoutMeasurePolicy chipLayoutMeasurePolicy = (ChipLayoutMeasurePolicy) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    final Function2<Composer, Integer, Unit> function211 = function29;
                    final Function2<Composer, Integer, Unit> function212 = function28;
                    final Function2<Composer, Integer, Unit> function213 = function210;
                    final long j7 = j6;
                    Function2<Composer, Integer, Unit> function214 = function2;
                    final long j8 = j3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                    Updater.m5077setimpl(composerM5069constructorimpl, chipLayoutMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -564817408, "C2141@104124L826,2128@103442L1508,2158@104967L362,2179@106014L824,2168@105407L1431:Chip.kt#uh7d8r");
                    AnimatedVisibilityKt.AnimatedVisibility((function211 == null && function212 == null) ? false : true, LayoutIdKt.layoutId(Modifier.INSTANCE, "leadingIcon"), EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpecValue3, Alignment.INSTANCE.getStart(), false, null, 12, null).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpecValue, 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(finiteAnimationSpecValue4, Alignment.INSTANCE.getStart(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpecValue2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(687705959, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1$2$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C2147@104553L53,2146@104488L144,2150@104654L278:Chip.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(687705959, i5, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous>.<anonymous>.<anonymous> (Chip.kt:2145)");
                            }
                            State stateRememberRetainedState = ChipKt.rememberRetainedState(ChipKt.m2594leadingContentXOJAsU(function211, function212, j7, composer3, 0), composer3, 0);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, companion);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composer3);
                            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -1538137033, "C:Chip.kt#uh7d8r");
                            Function2 function215 = (Function2) stateRememberRetainedState.getValue();
                            if (function215 == null) {
                                composer3.startReplaceGroup(-1538103400);
                            } else {
                                composer3.startReplaceGroup(-326710903);
                                ComposerKt.sourceInformation(composer3, "2154@104875L8");
                                function215.invoke(composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 196656, 16);
                    Modifier modifierM1153paddingVpY3zN4$default = PaddingKt.m1153paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), ChipKt.HorizontalElementsPadding, 0.0f, 2, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1153paddingVpY3zN4$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composer2);
                    Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 75607137, "C2164@105301L7:Chip.kt#uh7d8r");
                    function214.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    AnimatedVisibilityKt.AnimatedVisibility(function213 != null, LayoutIdKt.layoutId(Modifier.INSTANCE, "trailingIcon"), EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpecValue3, Alignment.INSTANCE.getEnd(), false, null, 12, null).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpecValue, 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(finiteAnimationSpecValue4, Alignment.INSTANCE.getEnd(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpecValue2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1905252304, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1$2$3
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C2185@106445L48,2184@106380L139,2188@106541L279:Chip.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1905252304, i5, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous>.<anonymous>.<anonymous> (Chip.kt:2183)");
                            }
                            State stateRememberRetainedState = ChipKt.rememberRetainedState(ChipKt.m2595trailingContentRPmYEkk(function213, j8, composer3, 0), composer3, 0);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, companion);
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composer3);
                            Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2101817907, "C:Chip.kt#uh7d8r");
                            Function2 function215 = (Function2) stateRememberRetainedState.getValue();
                            if (function215 == null) {
                                composer3.startReplaceGroup(-2101783313);
                            } else {
                                composer3.startReplaceGroup(-344894126);
                                ComposerKt.sourceInformation(composer3, "2192@106763L8");
                                function215.invoke(composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 196656, 16);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j7 = j4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.AnimatingChipContent_fe0OD_I$lambda$24(function2, textStyle, j7, function22, function23, function24, j2, j3, f2, paddingValues, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: leadingContent-XO-JAsU, reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m2594leadingContentXOJAsU(Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final long j, Composer composer, int i) {
        Function2 function23;
        ComposerKt.sourceInformationMarkerStart(composer, 1330309098, "C(leadingContent)N(avatar,leadingIcon,leadingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330309098, i, -1, "androidx.compose.material3.leadingContent (Chip.kt:2212)");
        }
        if (function2 != null) {
            composer.startReplaceGroup(-1473203984);
            composer.endReplaceGroup();
            function23 = function2;
        } else if (function22 != null) {
            composer.startReplaceGroup(1575390813);
            ComposerKt.sourceInformation(composer, "2215@107394L183");
            Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-237350650, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$leadingContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C2216@107412L151:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-237350650, i2, -1, "androidx.compose.material3.leadingContent.<anonymous> (Chip.kt:2216)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j)), function22, composer2, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
            composer.endReplaceGroup();
            function23 = function2RememberComposableLambda;
        } else {
            composer.startReplaceGroup(1575618259);
            composer.endReplaceGroup();
            function23 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: trailingContent-RPmYEkk, reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m2595trailingContentRPmYEkk(final Function2<? super Composer, ? super Integer, Unit> function2, final long j, Composer composer, int i) {
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposerKt.sourceInformationMarkerStart(composer, -165980551, "C(trailingContent)N(trailingIcon,trailingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-165980551, i, -1, "androidx.compose.material3.trailingContent (Chip.kt:2231)");
        }
        if (function2 != null) {
            composer.startReplaceGroup(-1219055576);
            ComposerKt.sourceInformation(composer, "2232@107914L165");
            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-566924201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$trailingContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C2233@107928L141:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-566924201, i2, -1, "androidx.compose.material3.trailingContent.<anonymous> (Chip.kt:2233)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j)), function2, composer2, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1218863531);
            composer.endReplaceGroup();
            composableLambdaRememberComposableLambda = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return composableLambdaRememberComposableLambda;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> State<T> rememberRetainedState(T t, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -618198444, "C(rememberRetainedState)N(targetValue)2249@108434L40:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-618198444, i, -1, "androidx.compose.material3.rememberRetainedState (Chip.kt:2248)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1383214468, "CC(remember):Chip.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (t != null) {
            mutableState.setValue(t);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme colorScheme) {
        ChipColors defaultSuggestionChipColorsCached = colorScheme.getDefaultSuggestionChipColorsCached();
        if (defaultSuggestionChipColorsCached != null) {
            return defaultSuggestionChipColorsCached;
        }
        ChipColors chipColors = new ChipColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6004getUnspecified0d7_KjU(), null);
        colorScheme.setDefaultSuggestionChipColorsCached$material3(chipColors);
        return chipColors;
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean z, boolean z2, boolean z3) {
        return PaddingKt.m1148PaddingValuesa9UjIt4$default(Dp.m8830constructorimpl((z || !z2) ? 4 : 8), 0.0f, Dp.m8830constructorimpl(z3 ? 8 : 4), 0.0f, 10, null);
    }

    static {
        float fM8830constructorimpl = Dp.m8830constructorimpl(8);
        HorizontalElementsPadding = fM8830constructorimpl;
        AssistChipPadding = PaddingKt.m1146PaddingValuesYgX7TsA$default(fM8830constructorimpl, 0.0f, 2, null);
        FilterChipPadding = PaddingKt.m1146PaddingValuesYgX7TsA$default(fM8830constructorimpl, 0.0f, 2, null);
        SuggestionChipPadding = PaddingKt.m1146PaddingValuesYgX7TsA$default(fM8830constructorimpl, 0.0f, 2, null);
    }
}
