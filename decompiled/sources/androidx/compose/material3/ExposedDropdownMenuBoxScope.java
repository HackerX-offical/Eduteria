package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntRect;
import com.clevertap.android.sdk.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\tH&J\u0095\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b*\u0010+J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0005H\u0007J\u009f\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b.\u0010/JU\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00100R\u0012\u0010\u000e\u001a\u00020\u0007X \u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\tX \u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u00011¨\u00062"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", StreamManagement.Enabled.ELEMENT, "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "exposedDropdownSize", "matchAnchorWidth", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", Constants.KEY_BORDER, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "matchTextFieldWidth", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public /* synthetic */ ExposedDropdownMenuBoxScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu$lambda$9(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, Function3 function3, int i, int i2, Composer composer, int i3) {
        exposedDropdownMenuBoxScope.ExposedDropdownMenu(z, function0, modifier, scrollState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_kbRbctU$lambda$8(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, boolean z2, boolean z3, Shape shape, long j, float f2, float f3, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        exposedDropdownMenuBoxScope.m2885ExposedDropdownMenukbRbctU(z, function0, modifier, scrollState, z2, z3, shape, j, f2, f3, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_vNxi1II$lambda$7(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, boolean z2, Shape shape, long j, float f2, float f3, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        exposedDropdownMenuBoxScope.m2886ExposedDropdownMenuvNxi1II(z, function0, modifier, scrollState, z2, shape, j, f2, f3, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    public abstract boolean getAlwaysFocusable$material3();

    /* JADX INFO: renamed from: getAnchorType-oYjWRB4$material3, reason: not valid java name */
    public abstract String mo2887getAnchorTypeoYjWRB4$material3();

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac, reason: not valid java name */
    public abstract Modifier mo2888menuAnchor2Hz36ac(Modifier modifier, String str, boolean z);

    private ExposedDropdownMenuBoxScope() {
    }

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2884menuAnchor2Hz36ac$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-2Hz36ac");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.mo2888menuAnchor2Hz36ac(modifier, str, z);
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX INFO: renamed from: ExposedDropdownMenu-vNxi1II, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2886ExposedDropdownMenuvNxi1II(final boolean r37, final kotlin.jvm.functions.Function0<kotlin.Unit> r38, androidx.compose.ui.Modifier r39, androidx.compose.foundation.ScrollState r40, boolean r41, androidx.compose.ui.graphics.Shape r42, long r43, float r45, float r46, androidx.compose.foundation.BorderStroke r47, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 1073
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m2886ExposedDropdownMenuvNxi1II(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(MutableState mutableState) {
        mutableState.setValue(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m6370boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes ExposedDropdownMenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(expression = "menuAnchor(type, enabled)", imports = {}))
    public final Modifier menuAnchor(Modifier modifier) {
        return m2884menuAnchor2Hz36ac$default(this, modifier, ExposedDropdownMenuAnchorType.INSTANCE.m2880getPrimaryNotEditableoYjWRB4(), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper ExposedDropdownMenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    /* JADX INFO: renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2885ExposedDropdownMenukbRbctU(final boolean r35, final kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.ScrollState r38, boolean r39, boolean r40, androidx.compose.ui.graphics.Shape r41, long r42, float r44, float r45, androidx.compose.foundation.BorderStroke r46, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m2885ExposedDropdownMenukbRbctU(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015a  */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.material3.ExposedDropdownMenuBoxScope] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void ExposedDropdownMenu(final boolean r27, final kotlin.jvm.functions.Function0 r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.ScrollState r30, final kotlin.jvm.functions.Function3 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
