package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: compiled from: FontVariation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005\u0015\u0004\u001e\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0013J1\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001b\"\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation;", "", "<init>", "()V", "Setting", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "name", "", "value", "", "italic", "opticalSizing", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "opticalSizing--R2X_6o", "(J)Landroidx/compose/ui/text/font/FontVariation$Setting;", "slant", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "weight", "", "grade", "Settings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "settings", "", "Settings-6EWAqTQ", "(Landroidx/compose/ui/text/font/FontWeight;I[Landroidx/compose/ui/text/font/FontVariation$Setting;)Landroidx/compose/ui/text/font/FontVariation$Settings;", "SettingFloat", "SettingTextUnit", "SettingInt", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontVariation {
    public static final int $stable = 0;
    public static final FontVariation INSTANCE = new FontVariation();

    /* JADX INFO: compiled from: FontVariation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0003\u000e\u000f\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$Setting;", "", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "axisName", "", "getAxisName", "()Ljava/lang/String;", "Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Setting {
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(Density density);
    }

    private FontVariation() {
    }

    /* JADX INFO: compiled from: FontVariation.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$Settings;", "", "settings", "", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "<init>", "([Landroidx/compose/ui/text/font/FontVariation$Setting;)V", "", "getSettings", "()Ljava/util/List;", "needsDensity", "", "getNeedsDensity$ui_text", "()Z", "equals", "other", "hashCode", "", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Settings {
        public static final int $stable = 0;
        private final boolean needsDensity;
        private final List<Setting> settings;

        public Settings(Setting... settingArr) {
            boolean z = false;
            for (Setting setting : settingArr) {
                String axisName = setting.getAxisName();
                int i = 0;
                for (Setting setting2 : settingArr) {
                    if (Intrinsics.areEqual(setting2.getAxisName(), axisName)) {
                        i++;
                    }
                }
                if (!(i == 1)) {
                    StringBuilder sbAppend = new StringBuilder("'").append(axisName).append("' must be unique. Actual [");
                    ArrayList arrayList = new ArrayList();
                    for (Setting setting3 : settingArr) {
                        if (Intrinsics.areEqual(setting3.getAxisName(), axisName)) {
                            arrayList.add(setting3);
                        }
                    }
                    InlineClassHelperKt.throwIllegalArgumentException(sbAppend.append(arrayList).append(']').toString());
                }
                z = z || setting.getNeedsDensity();
            }
            this.settings = ArraysKt.toList(settingArr);
            this.needsDensity = z;
        }

        public final List<Setting> getSettings() {
            return this.settings;
        }

        /* JADX INFO: renamed from: getNeedsDensity$ui_text, reason: from getter */
        public final boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Settings) && Intrinsics.areEqual(this.settings, ((Settings) other).settings);
        }

        public int hashCode() {
            return this.settings.hashCode();
        }
    }

    /* JADX INFO: compiled from: FontVariation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "<init>", "(Ljava/lang/String;F)V", "getAxisName", "()Ljava/lang/String;", "getValue", "()F", "toVariationValue", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class SettingFloat implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public SettingFloat(String str, float f2) {
            this.axisName = str;
            this.value = f2;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        public final float getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density density) {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingFloat)) {
                return false;
            }
            SettingFloat settingFloat = (SettingFloat) other;
            return Intrinsics.areEqual(getAxisName(), settingFloat.getAxisName()) && this.value == settingFloat.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + Float.hashCode(this.value);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }
    }

    /* JADX INFO: compiled from: FontVariation.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0013\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "Landroidx/compose/ui/unit/TextUnit;", "<init>", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAxisName", "()Ljava/lang/String;", "getValue-XSAIIZE", "()J", "J", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class SettingTextUnit implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final long value;

        public /* synthetic */ SettingTextUnit(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j);
        }

        private SettingTextUnit(String str, long j) {
            this.axisName = str;
            this.value = j;
            this.needsDensity = true;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        /* JADX INFO: renamed from: getValue-XSAIIZE, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density density) {
            if (density != null) {
                return TextUnit.m9024getValueimpl(this.value) * density.getFontScale();
            }
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("density must not be null");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingTextUnit)) {
                return false;
            }
            SettingTextUnit settingTextUnit = (SettingTextUnit) other;
            return Intrinsics.areEqual(getAxisName(), settingTextUnit.getAxisName()) && TextUnit.m9021equalsimpl0(this.value, settingTextUnit.value);
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + TextUnit.m9025hashCodeimpl(this.value);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + ((Object) TextUnit.m9031toStringimpl(this.value)) + ')';
        }
    }

    /* JADX INFO: compiled from: FontVariation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getAxisName", "()Ljava/lang/String;", "getValue", "()I", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class SettingInt implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public SettingInt(String str, int i) {
            this.axisName = str;
            this.value = i;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        public final int getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density density) {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingInt)) {
                return false;
            }
            SettingInt settingInt = (SettingInt) other;
            return Intrinsics.areEqual(getAxisName(), settingInt.getAxisName()) && this.value == settingInt.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + this.value;
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }
    }

    public final Setting Setting(String name, float value) {
        if (!(name.length() == 4)) {
            InlineClassHelperKt.throwIllegalArgumentException("Name must be exactly four characters. Actual: '" + name + '\'');
        }
        return new SettingFloat(name, value);
    }

    public final Setting italic(float value) {
        boolean z = false;
        if (0.0f <= value && value <= 1.0f) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("'ital' must be in 0.0f..1.0f. Actual: " + value);
        }
        return new SettingFloat("ital", value);
    }

    /* JADX INFO: renamed from: opticalSizing--R2X_6o, reason: not valid java name */
    public final Setting m8411opticalSizingR2X_6o(long textSize) {
        if (!TextUnit.m9027isSpimpl(textSize)) {
            InlineClassHelperKt.throwIllegalArgumentException("'opsz' must be provided in sp units");
        }
        return new SettingTextUnit("opsz", textSize, null);
    }

    public final Setting slant(float value) {
        boolean z = false;
        if (-90.0f <= value && value <= 90.0f) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("'slnt' must be in -90f..90f. Actual: " + value);
        }
        return new SettingFloat("slnt", value);
    }

    public final Setting width(float value) {
        if (!(value > 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("'wdth' must be strictly > 0.0f. Actual: " + value);
        }
        return new SettingFloat("wdth", value);
    }

    public final Setting weight(int value) {
        boolean z = false;
        if (1 <= value && value < 1001) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("'wght' value must be in [1, 1000]. Actual: " + value);
        }
        return new SettingInt("wght", value);
    }

    public final Setting grade(int value) {
        boolean z = false;
        if (-1000 <= value && value < 1001) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("'GRAD' must be in -1000..1000");
        }
        return new SettingInt("GRAD", value);
    }

    /* JADX INFO: renamed from: Settings-6EWAqTQ, reason: not valid java name */
    public final Settings m8410Settings6EWAqTQ(FontWeight weight, int style, Setting... settings) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(weight(weight.getWeight()));
        spreadBuilder.add(italic(style));
        spreadBuilder.addSpread(settings);
        return new Settings((Setting[]) spreadBuilder.toArray(new Setting[spreadBuilder.size()]));
    }
}
