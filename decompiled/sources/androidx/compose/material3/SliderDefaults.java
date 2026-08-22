package androidx.compose.material3;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.window.core.layout.WindowSizeClass;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#JG\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0001¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010+J3\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010,J\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108J\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010;J\u009d\u0001\u0010<\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002052\b\b\u0002\u00109\u001a\u000205H\u0001¢\u0006\u0004\b=\u0010>J\u009d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001fH\u0003¢\u0006\u0004\bB\u0010CJ3\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010FJ\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u0010GJ\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010HJ\u008d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0003¢\u0006\u0004\bI\u0010JJï\u0001\u0010K\u001a\u00020\u0019*\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020O2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u0002052\u0006\u0010S\u001a\u0002052\u0006\u0010T\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00109\u001a\u0002052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u0010U\u001a\u00020\u001f2\b\b\u0002\u0010@\u001a\u00020\u001f2\b\b\u0002\u0010V\u001a\u00020W2\b\b\u0002\u0010A\u001a\u00020\u001fH\u0002¢\u0006\u0004\bX\u0010YJC\u0010Z\u001a\u00020\u0019*\u00020/2\u0006\u0010V\u001a\u00020W2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020O2\u0006\u0010`\u001a\u00020OH\u0002¢\u0006\u0004\ba\u0010bJ)\u0010-\u001a\u00020\u0019*\u00020/2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u0002052\u0006\u0010^\u001a\u00020\b¢\u0006\u0004\bc\u0010dR\u0018\u0010\u0014\u001a\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010e\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010gR\u0013\u0010i\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010gR\u000e\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SliderColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "defaultSliderColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "Thumb-HwbPF3A$material3", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "thumbTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "trackCornerSize", "Track-mnvyFg4$material3", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "CenteredTrack", "CenteredTrack-7LSsfP0$material3", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFFLandroidx/compose/runtime/Composer;II)V", "TrackImpl", "enableCornerShrinking", "isCentered", "TrackImpl-VvwgllI", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFZZLandroidx/compose/runtime/Composer;II)V", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "TrackImpl-xlyIBlM", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;I)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "startThumbWidth", "startThumbHeight", "endThumbWidth", "endThumbHeight", "isRangeSlider", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "drawTrack-GVD57ws", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;ZZLandroidx/compose/foundation/gestures/Orientation;Z)V", "drawTrackPath", "offset", "size", "Landroidx/compose/ui/geometry/Size;", "color", "startCornerRadius", "endCornerRadius", "drawTrackPath-zXTsYAs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/foundation/gestures/Orientation;JJJFF)V", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "()F", "F", "TickSize", "getTickSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    private static final float TrackStopIndicatorSize = SliderTokens.INSTANCE.m4794getStopIndicatorSizeD9Ej5fM();
    private static final float TickSize = SliderTokens.INSTANCE.m4794getStopIndicatorSizeD9Ej5fM();
    private static final Path trackPath = AndroidPath_androidKt.Path();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenteredTrack_7LSsfP0$lambda$25(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, float f4, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3466CenteredTrack7LSsfP0$material3(sliderState, modifier, z, sliderColors, function2, function3, f2, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumb_9LiSoMs$lambda$3(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3467Thumb9LiSoMs(mutableInteractionSource, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumb_HwbPF3A$lambda$6(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3468ThumbHwbPF3A$material3(mutableInteractionSource, sliderState, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$12(SliderDefaults sliderDefaults, SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(sliderPositions, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$13(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(sliderState, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$33(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(rangeSliderState, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_VvwgllI$lambda$32(SliderDefaults sliderDefaults, SliderState sliderState, float f2, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f3, float f4, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3461TrackImplVvwgllI(sliderState, f2, modifier, z, sliderColors, function2, function3, f3, f4, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_xlyIBlM$lambda$47(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f2, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f3, float f4, int i, Composer composer, int i2) {
        sliderDefaults.m3462TrackImplxlyIBlM(rangeSliderState, f2, modifier, z, sliderColors, function2, function3, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$17(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3470Track4EFweAY(sliderState, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$37(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3469Track4EFweAY(rangeSliderState, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$21(SliderDefaults sliderDefaults, SliderState sliderState, float f2, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f3, float f4, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3472TrackmnvyFg4$material3(sliderState, f2, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$41(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f2, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f3, float f4, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m3471TrackmnvyFg4$material3(rangeSliderState, f2, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1376295968, "C(colors)1107@48675L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1107)");
        }
        SliderColors defaultSliderColors$material3 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSliderColors$material3;
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m3473colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 885588574, "C(colors)N(thumbColor:c#ui.graphics.Color,activeTrackColor:c#ui.graphics.Color,activeTickColor:c#ui.graphics.Color,inactiveTrackColor:c#ui.graphics.Color,inactiveTickColor:c#ui.graphics.Color,disabledThumbColor:c#ui.graphics.Color,disabledActiveTrackColor:c#ui.graphics.Color,disabledActiveTickColor:c#ui.graphics.Color,disabledInactiveTrackColor:c#ui.graphics.Color,disabledInactiveTickColor:c#ui.graphics.Color)1149@50999L11:Slider.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        long jM6004getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j9;
        long jM6004getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1149)");
        }
        SliderColors sliderColorsM3439copyK518z4 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3439copyK518z4(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8, jM6004getUnspecified0d7_KjU9, jM6004getUnspecified0d7_KjU10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sliderColorsM3439copyK518z4;
    }

    public final SliderColors getDefaultSliderColors$material3(ColorScheme colorScheme) {
        SliderColors defaultSliderColorsCached = colorScheme.getDefaultSliderColorsCached();
        if (defaultSliderColorsCached != null) {
            return defaultSliderColorsCached;
        }
        SliderColors sliderColors = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorKt.m6013compositeOverOWjLjI(Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultSliderColorsCached$material3(sliderColors);
        return sliderColors;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0135  */
    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3467Thumb9LiSoMs(final androidx.compose.foundation.interaction.MutableInteractionSource r26, androidx.compose.ui.Modifier r27, androidx.compose.material3.SliderColors r28, boolean r29, long r30, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3467Thumb9LiSoMs(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e6  */
    /* JADX INFO: renamed from: Thumb-HwbPF3A$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3468ThumbHwbPF3A$material3(final androidx.compose.foundation.interaction.MutableInteractionSource r25, final androidx.compose.material3.SliderState r26, androidx.compose.ui.Modifier r27, androidx.compose.material3.SliderColors r28, boolean r29, long r30, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3468ThumbHwbPF3A$material3(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017b  */
    @kotlin.Deprecated(message = "Use version that supports slider state")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Track(final androidx.compose.material3.SliderPositions r18, androidx.compose.ui.Modifier r19, androidx.compose.material3.SliderColors r20, boolean r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderPositions, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$11$lambda$10(long j, SliderPositions sliderPositions, long j2, long j3, long j4, DrawScope drawScope) {
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6548getCenterF1C5BW0() & 4294967295L)))) & 4294967295L));
        long jM5715constructorimpl2 = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6548getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)))) << 32));
        long j5 = jM5715constructorimpl;
        long j6 = z ? jM5715constructorimpl2 : j5;
        if (!z) {
            j5 = jM5715constructorimpl2;
        }
        float f2 = drawScope.mo488toPx0680j_4(TickSize);
        float f3 = drawScope.mo488toPx0680j_4(SliderKt.getTrackHeight());
        DrawScope.m6535drawLineNGM6Ib0$default(drawScope, j, j6, j5, f3, StrokeCap.INSTANCE.m6345getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        int i = (int) (j6 >> 32);
        int i2 = (int) (j5 >> 32);
        long j7 = j6;
        long j8 = j5;
        DrawScope.m6535drawLineNGM6Ib0$default(drawScope, j2, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getStart().floatValue()))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6548getCenterF1C5BW0() & 4294967295L)))) & 4294967295L)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getEndInclusive().floatValue()))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6548getCenterF1C5BW0() & 4294967295L)))) & 4294967295L)), f3, StrokeCap.INSTANCE.m6345getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        float[] tickFractions = sliderPositions.getTickFractions();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i3 = 0; i3 < length; i3++) {
            float f4 = tickFractions[i3];
            Boolean boolValueOf = Boolean.valueOf(f4 > sliderPositions.getActiveRange().getEndInclusive().floatValue() || f4 < sliderPositions.getActiveRange().getStart().floatValue());
            Object obj = linkedHashMap.get(boolValueOf);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(boolValueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f4));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                arrayList.add(Offset.m5712boximpl(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6548getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (OffsetKt.m5746lerpWko1d7g(j7, j8, ((Number) list.get(i4)).floatValue()) >> 32)))) << 32))));
                i4++;
                zBooleanValue = zBooleanValue;
                list = list;
            }
            long j9 = j7;
            j8 = j8;
            DrawScope.m6540drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m6290getPointsr_lszbg(), zBooleanValue ? j3 : j4, f2, StrokeCap.INSTANCE.m6345getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            j7 = j9;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "Track(sliderState, modifier, enabled, colors, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void Track(final androidx.compose.material3.SliderState r15, androidx.compose.ui.Modifier r16, androidx.compose.material3.SliderColors r17, boolean r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$15$lambda$14(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM3452trackColorWaAFU9c$material3 = sliderColors.m3452trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m3474drawStopIndicatorx3O1jOs(drawScope, offset.m5733unboximpl(), TrackStopIndicatorSize, jM3452trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3470Track4EFweAY(final androidx.compose.material3.SliderState r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.SliderColors r25, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r26, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r27, float r28, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3470Track4EFweAY(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$19$lambda$18(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM3452trackColorWaAFU9c$material3 = sliderColors.m3452trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m3474drawStopIndicatorx3O1jOs(drawScope, offset.m5733unboximpl(), TrackStopIndicatorSize, jM3452trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX INFO: renamed from: Track-mnvyFg4$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3472TrackmnvyFg4$material3(final androidx.compose.material3.SliderState r24, final float r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.SliderColors r28, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r30, float r31, float r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3472TrackmnvyFg4$material3(androidx.compose.material3.SliderState, float, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenteredTrack_7LSsfP0$lambda$23$lambda$22(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM3452trackColorWaAFU9c$material3 = sliderColors.m3452trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m3474drawStopIndicatorx3O1jOs(drawScope, offset.m5733unboximpl(), TrackStopIndicatorSize, jM3452trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX INFO: renamed from: CenteredTrack-7LSsfP0$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3466CenteredTrack7LSsfP0$material3(final androidx.compose.material3.SliderState r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.material3.SliderColors r27, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r29, float r30, float r31, float r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3466CenteredTrack7LSsfP0$material3(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x025f  */
    /* JADX INFO: renamed from: TrackImpl-VvwgllI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m3461TrackImplVvwgllI(final androidx.compose.material3.SliderState r33, final float r34, final androidx.compose.ui.Modifier r35, final boolean r36, final androidx.compose.material3.SliderColors r37, final kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r38, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r39, final float r40, final float r41, final boolean r42, final boolean r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3461TrackImplVvwgllI(androidx.compose.material3.SliderState, float, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TrackImpl_VvwgllI$lambda$29$lambda$28(float f2, SliderState sliderState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        int height;
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(constraints.getValue());
        if (Dp.m8835equalsimpl0(f2, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM())) {
            if (sliderState.getOrientation() == Orientation.Vertical) {
                height = placeableMo7445measureBRTryo0.getWidth() / 2;
            } else {
                height = placeableMo7445measureBRTryo0.getHeight() / 2;
            }
        } else {
            height = measureScope.mo482roundToPx0680j_4(f2);
        }
        return measureScope.layout(placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(height))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_VvwgllI$lambda$31$lambda$30(float f2, SliderState sliderState, long j, long j2, long j3, long j4, float f3, float f4, Function2 function2, Function3 function3, boolean z, boolean z2, DrawScope drawScope) {
        float f5;
        float fIntBitsToFloat;
        if (Dp.m8835equalsimpl0(f2, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM())) {
            if (sliderState.getOrientation() == Orientation.Vertical) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32));
            } else {
                fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L));
            }
            f5 = fIntBitsToFloat / 2;
        } else {
            f5 = drawScope.mo488toPx0680j_4(f2);
        }
        INSTANCE.m3463drawTrackGVD57ws(drawScope, sliderState.getTickFractions(), 0.0f, sliderState.getCoercedValueAsFraction(), j, j2, j3, j4, drawScope.mo485toDpu2uoSUM(0), drawScope.mo485toDpu2uoSUM(0), drawScope.mo485toDpu2uoSUM(sliderState.getThumbWidth$material3()), drawScope.mo485toDpu2uoSUM(sliderState.getThumbHeight$material3()), f3, f4, drawScope.mo484toDpu2uoSUM(f5), function2, function3, false, z, sliderState.getOrientation(), z2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "Track(rangeSliderState, modifier, colors, enabled, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void Track(final androidx.compose.material3.RangeSliderState r15, androidx.compose.ui.Modifier r16, androidx.compose.material3.SliderColors r17, boolean r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$35$lambda$34(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM3452trackColorWaAFU9c$material3 = sliderColors.m3452trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m3474drawStopIndicatorx3O1jOs(drawScope, offset.m5733unboximpl(), TrackStopIndicatorSize, jM3452trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3469Track4EFweAY(final androidx.compose.material3.RangeSliderState r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.SliderColors r25, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r26, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r27, float r28, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3469Track4EFweAY(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$39$lambda$38(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM3452trackColorWaAFU9c$material3 = sliderColors.m3452trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m3474drawStopIndicatorx3O1jOs(drawScope, offset.m5733unboximpl(), TrackStopIndicatorSize, jM3452trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX INFO: renamed from: Track-mnvyFg4$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3471TrackmnvyFg4$material3(final androidx.compose.material3.RangeSliderState r24, final float r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.SliderColors r28, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r30, float r31, float r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3471TrackmnvyFg4$material3(androidx.compose.material3.RangeSliderState, float, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: TrackImpl-xlyIBlM, reason: not valid java name */
    private final void m3462TrackImplxlyIBlM(final RangeSliderState rangeSliderState, final float f2, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2<? super DrawScope, ? super Offset, Unit> function2, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, final float f3, final float f4, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1719396904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrackImpl)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1817@80714L449,1828@81174L1310,1816@80643L1841:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(f4) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1719396904, i2, -1, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1811)");
            }
            final long jM3452trackColorWaAFU9c$material3 = sliderColors.m3452trackColorWaAFU9c$material3(z, false);
            int i3 = i2;
            final long jM3452trackColorWaAFU9c$material32 = sliderColors.m3452trackColorWaAFU9c$material3(z, true);
            final long jM3451tickColorWaAFU9c$material3 = sliderColors.m3451tickColorWaAFU9c$material3(z, false);
            final long jM3451tickColorWaAFU9c$material32 = sliderColors.m3451tickColorWaAFU9c$material3(z, true);
            Modifier modifierM1207height3ABfNKs = SizeKt.m1207height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SliderKt.getTrackHeight());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1222010201, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$44$lambda$43((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout = LayoutModifierKt.layout(modifierM1207height3ABfNKs, (Function3) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1222025782, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(rangeSliderState) | composerStartRestartGroup.changed(jM3452trackColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM3452trackColorWaAFU9c$material32) | composerStartRestartGroup.changed(jM3451tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM3451tickColorWaAFU9c$material32) | ((i3 & 29360128) == 8388608) | ((i3 & 234881024) == 67108864) | ((i3 & 458752) == 131072) | ((i3 & 3670016) == 1048576);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                modifier2 = modifierLayout;
                composer2 = composerStartRestartGroup;
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$46$lambda$45(f2, rangeSliderState, jM3452trackColorWaAFU9c$material3, jM3452trackColorWaAFU9c$material32, jM3451tickColorWaAFU9c$material3, jM3451tickColorWaAFU9c$material32, f3, f4, function2, function3, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            } else {
                modifier2 = modifierLayout;
                composer2 = composerStartRestartGroup;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifier2, (Function1) objRememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.TrackImpl_xlyIBlM$lambda$47(this.f$0, rangeSliderState, f2, modifier, z, sliderColors, function2, function3, f3, f4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TrackImpl_xlyIBlM$lambda$44$lambda$43(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(constraints.getValue());
        return measureScope.layout(placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(placeableMo7445measureBRTryo0.getHeight() / 2))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_xlyIBlM$lambda$46$lambda$45(float f2, RangeSliderState rangeSliderState, long j, long j2, long j3, long j4, float f3, float f4, Function2 function2, Function3 function3, DrawScope drawScope) {
        float fIntBitsToFloat;
        if (!Dp.m8835equalsimpl0(f2, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM())) {
            fIntBitsToFloat = drawScope.mo488toPx0680j_4(f2);
        } else {
            fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L)) / 2;
        }
        m3464drawTrackGVD57ws$default(INSTANCE, drawScope, rangeSliderState.getTickFractions(), rangeSliderState.getCoercedActiveRangeStartAsFraction$material3(), rangeSliderState.getCoercedActiveRangeEndAsFraction$material3(), j, j2, j3, j4, drawScope.mo484toDpu2uoSUM(rangeSliderState.getStartThumbWidth$material3()), drawScope.mo484toDpu2uoSUM(rangeSliderState.getStartThumbHeight$material3()), drawScope.mo484toDpu2uoSUM(rangeSliderState.getEndThumbWidth$material3()), drawScope.mo484toDpu2uoSUM(rangeSliderState.getEndThumbHeight$material3()), f3, f4, drawScope.mo484toDpu2uoSUM(fIntBitsToFloat), function2, function3, true, false, null, false, 917504, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawTrack-GVD57ws$default, reason: not valid java name */
    static /* synthetic */ void m3464drawTrackGVD57ws$default(SliderDefaults sliderDefaults, DrawScope drawScope, float[] fArr, float f2, float f3, long j, long j2, long j3, long j4, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Function2 function2, Function3 function3, boolean z, boolean z2, Orientation orientation, boolean z3, int i, Object obj) {
        sliderDefaults.m3463drawTrackGVD57ws(drawScope, fArr, f2, f3, j, j2, j3, j4, f4, f5, f6, f7, f8, f9, f10, function2, function3, z, (i & 131072) != 0 ? false : z2, (i & 262144) != 0 ? Orientation.Horizontal : orientation, (i & 524288) != 0 ? false : z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0121  */
    /* JADX INFO: renamed from: drawTrack-GVD57ws, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m3463drawTrackGVD57ws(androidx.compose.ui.graphics.drawscope.DrawScope r34, float[] r35, float r36, float r37, long r38, long r40, long r42, long r44, float r46, float r47, float r48, float r49, float r50, float r51, float r52, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r53, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r54, boolean r55, boolean r56, androidx.compose.foundation.gestures.Orientation r57, boolean r58) {
        /*
            Method dump skipped, instruction units count: 1494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m3463drawTrackGVD57ws(androidx.compose.ui.graphics.drawscope.DrawScope, float[], float, float, long, long, long, long, float, float, float, float, float, float, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, boolean, boolean, androidx.compose.foundation.gestures.Orientation, boolean):void");
    }

    /* JADX INFO: renamed from: drawStopIndicator-x3O1jOs, reason: not valid java name */
    public final void m3474drawStopIndicatorx3O1jOs(DrawScope drawScope, long j, float f2, long j2) {
        DrawScope.m6530drawCircleVaOC9Bg$default(drawScope, j2, drawScope.mo488toPx0680j_4(f2) / 2.0f, j, 0.0f, null, null, 0, 120, null);
    }

    /* JADX INFO: renamed from: getTrackStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m3476getTrackStopIndicatorSizeD9Ej5fM() {
        return TrackStopIndicatorSize;
    }

    /* JADX INFO: renamed from: getTickSize-D9Ej5fM, reason: not valid java name */
    public final float m3475getTickSizeD9Ej5fM() {
        return TickSize;
    }

    /* JADX INFO: renamed from: drawTrackPath-zXTsYAs, reason: not valid java name */
    private final void m3465drawTrackPathzXTsYAs(DrawScope drawScope, Orientation orientation, long j, long j2, long j3, float f2, float f3) {
        RoundRect roundRectM5775RoundRectZAM2FJo;
        long jM5677constructorimpl = CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        long jM5677constructorimpl2 = CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        if (orientation == Orientation.Vertical) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            roundRectM5775RoundRectZAM2FJo = RoundRectKt.m5775RoundRectZAM2FJo(RectKt.m5763Recttz77jQw(j, Size.m5783constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32))), jM5677constructorimpl, jM5677constructorimpl, jM5677constructorimpl2, jM5677constructorimpl2);
        } else {
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 >> 32));
            roundRectM5775RoundRectZAM2FJo = RoundRectKt.m5775RoundRectZAM2FJo(RectKt.m5763Recttz77jQw(j, Size.m5783constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32))), jM5677constructorimpl, jM5677constructorimpl2, jM5677constructorimpl2, jM5677constructorimpl);
        }
        Path path = trackPath;
        Path.addRoundRect$default(path, roundRectM5775RoundRectZAM2FJo, null, 2, null);
        DrawScope.m6539drawPathLG529CI$default(drawScope, path, j3, 0.0f, null, null, 0, 60, null);
        path.rewind();
    }
}
