package com.anychart.core.stock;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.axes.StockDateTime;
import com.anychart.core.stock.indicators.ADL;
import com.anychart.core.stock.indicators.AMA;
import com.anychart.core.stock.indicators.AO;
import com.anychart.core.stock.indicators.ATR;
import com.anychart.core.stock.indicators.Aroon;
import com.anychart.core.stock.indicators.BBands;
import com.anychart.core.stock.indicators.BBandsB;
import com.anychart.core.stock.indicators.BBandsWidth;
import com.anychart.core.stock.indicators.CCI;
import com.anychart.core.stock.indicators.CHO;
import com.anychart.core.stock.indicators.CMF;
import com.anychart.core.stock.indicators.DMI;
import com.anychart.core.stock.indicators.EMA;
import com.anychart.core.stock.indicators.HA;
import com.anychart.core.stock.indicators.KDJ;
import com.anychart.core.stock.indicators.KeltnerChannels;
import com.anychart.core.stock.indicators.MACD;
import com.anychart.core.stock.indicators.MFI;
import com.anychart.core.stock.indicators.MMA;
import com.anychart.core.stock.indicators.Momentum;
import com.anychart.core.stock.indicators.OBV;
import com.anychart.core.stock.indicators.PSAR;
import com.anychart.core.stock.indicators.PriceChannels;
import com.anychart.core.stock.indicators.RSI;
import com.anychart.core.stock.indicators.RoC;
import com.anychart.core.stock.indicators.SMA;
import com.anychart.core.stock.indicators.Stochastic;
import com.anychart.core.stock.indicators.TRIX;
import com.anychart.core.stock.indicators.VolumeMA;
import com.anychart.core.stock.indicators.WilliamsR;
import com.anychart.core.stock.scrollerseries.Area;
import com.anychart.core.stock.scrollerseries.Base;
import com.anychart.core.stock.scrollerseries.Hilo;
import com.anychart.core.stock.scrollerseries.Line;
import com.anychart.core.stock.scrollerseries.OHLC;
import com.anychart.core.ui.scroller.Thumbs;
import com.anychart.data.Set;
import com.anychart.data.Table;
import com.anychart.data.TableMapping;
import com.anychart.data.View;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.Orientation;
import com.anychart.enums.ScatterScaleTypes;
import com.anychart.enums.StockSeriesType;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Rect;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import com.anychart.palettes.DistinctColors;
import com.anychart.palettes.HatchFills;
import com.anychart.palettes.RangeColors;
import com.anychart.scales.ScatterBase;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Scroller extends JsObject {
    protected Scroller() {
    }

    public static Scroller instantiate() {
        return new Scroller("new anychart.core.stock.scroller()");
    }

    public Scroller(String str) {
        StringBuilder sb = new StringBuilder("scroller");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void addSeries(View view) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addSeries(%s);", view != null ? view.getJsBase() : null));
    }

    public void addSeries(Set set) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addSeries(%s);", set != null ? set.getJsBase() : null));
    }

    public void addSeries(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addSeries(%s);", arrayToStringWrapQuotes(strArr)));
    }

    public ADL adl(TableMapping tableMapping, StockSeriesType stockSeriesType) {
        return new ADL(String.format(Locale.US, this.jsBase + ".adl(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public ADL adl(TableMapping tableMapping, String str) {
        return new ADL(String.format(Locale.US, this.jsBase + ".adl(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, wrapQuotes(str)));
    }

    public void allowRangeChange() {
        APIlib.getInstance().addJSLine(this.jsBase + ".allowRangeChange();");
    }

    public Scroller allowRangeChange(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".allowRangeChange(%s);", bool));
        return this;
    }

    public AMA ama(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType) {
        return new AMA(String.format(Locale.US, this.jsBase + ".ama(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public AMA ama(TableMapping tableMapping, Number number, Number number2, Number number3, String str) {
        return new AMA(String.format(Locale.US, this.jsBase + ".ama(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str)));
    }

    public AO ao(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, StockSeriesType stockSeriesType) {
        return new AO(String.format(Locale.US, this.jsBase + ".ao(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public AO ao(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, String str) {
        return new AO(String.format(Locale.US, this.jsBase + ".ao(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str)));
    }

    public AO ao(TableMapping tableMapping, Number number, Number number2, String str, StockSeriesType stockSeriesType) {
        return new AO(String.format(Locale.US, this.jsBase + ".ao(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public AO ao(TableMapping tableMapping, Number number, Number number2, String str, String str2) {
        return new AO(String.format(Locale.US, this.jsBase + ".ao(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2)));
    }

    public Area area(Table table) {
        return new Area(String.format(Locale.US, this.jsBase + ".area(%s)", table != null ? table.getJsBase() : null));
    }

    public Aroon aroon(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new Aroon(String.format(Locale.US, this.jsBase + ".aroon(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public Aroon aroon(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType, String str) {
        return new Aroon(String.format(Locale.US, this.jsBase + ".aroon(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str)));
    }

    public Aroon aroon(TableMapping tableMapping, Number number, String str, StockSeriesType stockSeriesType) {
        return new Aroon(String.format(Locale.US, this.jsBase + ".aroon(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public Aroon aroon(TableMapping tableMapping, Number number, String str, String str2) {
        return new Aroon(String.format(Locale.US, this.jsBase + ".aroon(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2)));
    }

    public ATR atr(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new ATR(String.format(Locale.US, this.jsBase + ".atr(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public ATR atr(TableMapping tableMapping, Number number, String str) {
        return new ATR(String.format(Locale.US, this.jsBase + ".atr(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public void autoHide() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoHide();");
    }

    public Scroller autoHide(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoHide(%s);", bool));
        return this;
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, StockSeriesType stockSeriesType3) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, stockSeriesType3 != null ? stockSeriesType3.getJsBase() : null));
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, String str) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, wrapQuotes(str)));
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, StockSeriesType stockSeriesType, String str, StockSeriesType stockSeriesType2) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, StockSeriesType stockSeriesType, String str, String str2) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2)));
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, String str, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, String str, StockSeriesType stockSeriesType, String str2) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, String str, String str2, StockSeriesType stockSeriesType) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public BBands bbands(TableMapping tableMapping, Number number, Number number2, String str, String str2, String str3) {
        return new BBands(String.format(Locale.US, this.jsBase + ".bbands(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public BBandsB bbandsB(TableMapping tableMapping, Number number, Number number2, StockSeriesType stockSeriesType) {
        return new BBandsB(String.format(Locale.US, this.jsBase + ".bbandsB(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public BBandsB bbandsB(TableMapping tableMapping, Number number, Number number2, String str) {
        return new BBandsB(String.format(Locale.US, this.jsBase + ".bbandsB(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str)));
    }

    public BBandsWidth bbandsWidth(TableMapping tableMapping, Number number, Number number2, StockSeriesType stockSeriesType) {
        return new BBandsWidth(String.format(Locale.US, this.jsBase + ".bbandsWidth(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public BBandsWidth bbandsWidth(TableMapping tableMapping, Number number, Number number2, String str) {
        return new BBandsWidth(String.format(Locale.US, this.jsBase + ".bbandsWidth(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str)));
    }

    public CCI cci(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new CCI(String.format(Locale.US, this.jsBase + ".cci(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public CCI cci(TableMapping tableMapping, Number number, String str) {
        return new CCI(String.format(Locale.US, this.jsBase + ".cci(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public CHO cho(TableMapping tableMapping, Number number, Number number2, String str, StockSeriesType stockSeriesType) {
        return new CHO(String.format(Locale.US, this.jsBase + ".cho(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public CHO cho(TableMapping tableMapping, Number number, Number number2, String str, String str2) {
        return new CHO(String.format(Locale.US, this.jsBase + ".cho(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2)));
    }

    public CMF cmf(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new CMF(String.format(Locale.US, this.jsBase + ".cmf(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public CMF cmf(TableMapping tableMapping, Number number, String str) {
        return new CMF(String.format(Locale.US, this.jsBase + ".cmf(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public void defaultSeriesType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".defaultSeriesType();");
    }

    public Scroller defaultSeriesType(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public Scroller defaultSeriesType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", wrapQuotes(str)));
        return this;
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, StockSeriesType stockSeriesType3) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, stockSeriesType3 != null ? stockSeriesType3.getJsBase() : null));
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, String str) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, wrapQuotes(str)));
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, StockSeriesType stockSeriesType, String str, StockSeriesType stockSeriesType2) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, StockSeriesType stockSeriesType, String str, String str2) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2)));
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, String str, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, String str, StockSeriesType stockSeriesType, String str2) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, String str, String str2, StockSeriesType stockSeriesType) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public DMI dmi(TableMapping tableMapping, Number number, Number number2, Boolean bool, String str, String str2, String str3) {
        return new DMI(String.format(Locale.US, this.jsBase + ".dmi(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, bool, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public EMA ema(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new EMA(String.format(Locale.US, this.jsBase + ".ema(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public EMA ema(TableMapping tableMapping, Number number, String str) {
        return new EMA(String.format(Locale.US, this.jsBase + ".ema(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    public Scroller enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void fill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fill();");
    }

    public Scroller fill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Scroller fill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Scroller fill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Scroller fill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Scroller fill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Scroller fill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Scroller fill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Scroller fill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Scroller fill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Scroller fill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Scroller fill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Scroller fill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Base getSeries(Number number) {
        return new Base(String.format(Locale.US, this.jsBase + ".getSeries(%s)", number));
    }

    public Base getSeries(String str) {
        return new Base(String.format(Locale.US, this.jsBase + ".getSeries(%s)", wrapQuotes(str)));
    }

    public Base getSeriesAt(Number number) {
        return new Base(String.format(Locale.US, this.jsBase + ".getSeriesAt(%s)", number));
    }

    public void getSeriesCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getSeriesCount();");
    }

    public HA ha(TableMapping tableMapping, StockSeriesType stockSeriesType) {
        return new HA(String.format(Locale.US, this.jsBase + ".ha(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public HA ha(TableMapping tableMapping, String str) {
        return new HA(String.format(Locale.US, this.jsBase + ".ha(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, wrapQuotes(str)));
    }

    public HatchFills hatchFillPalette() {
        return new HatchFills(this.jsBase + ".hatchFillPalette()");
    }

    public Scroller hatchFillPalette(HatchFillType[] hatchFillTypeArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", arrayToString(hatchFillTypeArr)));
        return this;
    }

    public Scroller hatchFillPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Scroller hatchFillPalette(HatchFills hatchFills) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", hatchFills != null ? hatchFills.getJsBase() : null));
        return this;
    }

    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    public Scroller height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    public Scroller height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public Hilo hilo(Table table) {
        return new Hilo(String.format(Locale.US, this.jsBase + ".hilo(%s)", table != null ? table.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, StockSeriesType stockSeriesType3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, stockSeriesType3 != null ? stockSeriesType3.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, String str) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, wrapQuotes(str)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, StockSeriesType stockSeriesType, String str, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, StockSeriesType stockSeriesType, String str, String str2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, String str, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, String str, StockSeriesType stockSeriesType, String str2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, String str, String str2, StockSeriesType stockSeriesType) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, Number number4, Number number5, String str, String str2, String str3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, number4, number5, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, StockSeriesType stockSeriesType3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, stockSeriesType3 != null ? stockSeriesType3.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, String str2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, wrapQuotes(str2)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, StockSeriesType stockSeriesType, String str2, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2), stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, StockSeriesType stockSeriesType, String str2, String str3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, String str2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, String str2, StockSeriesType stockSeriesType, String str3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str3)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, String str2, String str3, StockSeriesType stockSeriesType) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, wrapQuotes(str2), wrapQuotes(str3), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, Number number4, Number number5, String str2, String str3, String str4) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), number4, number5, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, StockSeriesType stockSeriesType3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, stockSeriesType3 != null ? stockSeriesType3.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, String str2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, wrapQuotes(str2)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, StockSeriesType stockSeriesType, String str2, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2), stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, StockSeriesType stockSeriesType, String str2, String str3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, String str2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, String str2, StockSeriesType stockSeriesType, String str3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str3)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, String str2, String str3, StockSeriesType stockSeriesType) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, wrapQuotes(str2), wrapQuotes(str3), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, Number number4, Number number5, String str2, String str3, String str4) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, number4, number5, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, StockSeriesType stockSeriesType3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, stockSeriesType3 != null ? stockSeriesType3.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, String str3) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, wrapQuotes(str3)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, StockSeriesType stockSeriesType, String str3, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str3), stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, StockSeriesType stockSeriesType, String str3, String str4) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, String str3, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, wrapQuotes(str3), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, String str3, StockSeriesType stockSeriesType, String str4) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, wrapQuotes(str3), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str4)));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, String str3, String str4, StockSeriesType stockSeriesType) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, wrapQuotes(str3), wrapQuotes(str4), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public KDJ kdj(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, Number number4, Number number5, String str3, String str4, String str5) {
        return new KDJ(String.format(Locale.US, this.jsBase + ".kdj(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4, number5, wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public KeltnerChannels keltnerChannels(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, Number number3, StockSeriesType stockSeriesType) {
        return new KeltnerChannels(String.format(Locale.US, this.jsBase + ".keltnerChannels(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public KeltnerChannels keltnerChannels(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, Number number3, String str) {
        return new KeltnerChannels(String.format(Locale.US, this.jsBase + ".keltnerChannels(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, number3, wrapQuotes(str)));
    }

    public KeltnerChannels keltnerChannels(TableMapping tableMapping, Number number, Number number2, String str, Number number3, StockSeriesType stockSeriesType) {
        return new KeltnerChannels(String.format(Locale.US, this.jsBase + ".keltnerChannels(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public KeltnerChannels keltnerChannels(TableMapping tableMapping, Number number, Number number2, String str, Number number3, String str2) {
        return new KeltnerChannels(String.format(Locale.US, this.jsBase + ".keltnerChannels(%s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), number3, wrapQuotes(str2)));
    }

    public Line line(Table table) {
        return new Line(String.format(Locale.US, this.jsBase + ".line(%s)", table != null ? table.getJsBase() : null));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, StockSeriesType stockSeriesType3) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, stockSeriesType3 != null ? stockSeriesType3.getJsBase() : null));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2, String str) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null, wrapQuotes(str)));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType, String str, StockSeriesType stockSeriesType2) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType, String str, String str2) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2)));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, String str, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, String str, StockSeriesType stockSeriesType, String str2) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, StockSeriesType stockSeriesType) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public MACD macd(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, String str3) {
        return new MACD(String.format(Locale.US, this.jsBase + ".macd(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    public Scroller maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    public Scroller maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public MFI mfi(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new MFI(String.format(Locale.US, this.jsBase + ".mfi(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public MFI mfi(TableMapping tableMapping, Number number, String str) {
        return new MFI(String.format(Locale.US, this.jsBase + ".mfi(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    public Scroller minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    public Scroller minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public MMA mma(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new MMA(String.format(Locale.US, this.jsBase + ".mma(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public MMA mma(TableMapping tableMapping, Number number, String str) {
        return new MMA(String.format(Locale.US, this.jsBase + ".mma(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public Momentum momentum(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new Momentum(String.format(Locale.US, this.jsBase + ".momentum(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public Momentum momentum(TableMapping tableMapping, Number number, String str) {
        return new Momentum(String.format(Locale.US, this.jsBase + ".momentum(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public OBV obv(TableMapping tableMapping, StockSeriesType stockSeriesType) {
        return new OBV(String.format(Locale.US, this.jsBase + ".obv(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public OBV obv(TableMapping tableMapping, String str) {
        return new OBV(String.format(Locale.US, this.jsBase + ".obv(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, wrapQuotes(str)));
    }

    public OHLC ohlc(Table table) {
        return new OHLC(String.format(Locale.US, this.jsBase + ".ohlc(%s)", table != null ? table.getJsBase() : null));
    }

    public void orientation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".orientation();");
    }

    public Scroller orientation(Orientation orientation) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".orientation(%s);", orientation != null ? orientation.getJsBase() : null));
        return this;
    }

    public Scroller orientation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".orientation(%s);", wrapQuotes(str)));
        return this;
    }

    public void outlineStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".outlineStroke();");
    }

    public Scroller outlineStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Scroller outlineStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Scroller outlineStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Scroller outlineStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Scroller outlineStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Scroller outlineStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Scroller outlineStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Scroller outlineStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Scroller outlineStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Scroller outlineStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Scroller outlineStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    public Scroller outlineStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Scroller outlineStroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".outlineStroke(%s);", wrapQuotes(str)));
        return this;
    }

    public RangeColors palette() {
        return new RangeColors(this.jsBase + ".palette()");
    }

    public Scroller palette(RangeColors rangeColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", rangeColors != null ? rangeColors.getJsBase() : null));
        return this;
    }

    public Scroller palette(DistinctColors distinctColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", distinctColors != null ? distinctColors.getJsBase() : null));
        return this;
    }

    public Scroller palette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", wrapQuotes(str)));
        return this;
    }

    public Scroller palette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public PriceChannels priceChannels(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new PriceChannels(String.format(Locale.US, this.jsBase + ".priceChannels(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public PriceChannels priceChannels(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType, String str) {
        return new PriceChannels(String.format(Locale.US, this.jsBase + ".priceChannels(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str)));
    }

    public PriceChannels priceChannels(TableMapping tableMapping, Number number, String str, StockSeriesType stockSeriesType) {
        return new PriceChannels(String.format(Locale.US, this.jsBase + ".priceChannels(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public PriceChannels priceChannels(TableMapping tableMapping, Number number, String str, String str2) {
        return new PriceChannels(String.format(Locale.US, this.jsBase + ".priceChannels(%s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2)));
    }

    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    public PSAR psar(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType) {
        return new PSAR(String.format(Locale.US, this.jsBase + ".psar(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public PSAR psar(TableMapping tableMapping, Number number, Number number2, Number number3, String str) {
        return new PSAR(String.format(Locale.US, this.jsBase + ".psar(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str)));
    }

    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Scroller removeAllSeries() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeAllSeries();");
        return this;
    }

    public Scroller removeSeries(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", number));
        return this;
    }

    public Scroller removeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public Scroller removeSeriesAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeriesAt(%s);", number));
        return this;
    }

    public RoC roc(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new RoC(String.format(Locale.US, this.jsBase + ".roc(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public RoC roc(TableMapping tableMapping, Number number, String str) {
        return new RoC(String.format(Locale.US, this.jsBase + ".roc(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public RSI rsi(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new RSI(String.format(Locale.US, this.jsBase + ".rsi(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public RSI rsi(TableMapping tableMapping, Number number, String str) {
        return new RSI(String.format(Locale.US, this.jsBase + ".rsi(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public void selectedFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectedFill();");
    }

    public Scroller selectedFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Scroller selectedFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Scroller selectedFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Scroller selectedFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Scroller selectedFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Scroller selectedFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Scroller selectedFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Scroller selectedFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Scroller selectedFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Scroller selectedFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Scroller selectedFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Scroller selectedFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public SMA sma(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new SMA(String.format(Locale.US, this.jsBase + ".sma(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public SMA sma(TableMapping tableMapping, Number number, String str) {
        return new SMA(String.format(Locale.US, this.jsBase + ".sma(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, StockSeriesType stockSeriesType, String str) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, String str, StockSeriesType stockSeriesType) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, String str, String str2) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, StockSeriesType stockSeriesType, String str2) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, String str2, StockSeriesType stockSeriesType) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, MovingAverageType movingAverageType, String str, String str2, String str3) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, StockSeriesType stockSeriesType, String str2) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, String str2, StockSeriesType stockSeriesType) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, MovingAverageType movingAverageType, String str2, String str3) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, StockSeriesType stockSeriesType, String str3) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str3)));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, String str3, StockSeriesType stockSeriesType) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public Stochastic stochastic(TableMapping tableMapping, Number number, Number number2, Number number3, String str, String str2, String str3, String str4) {
        return new Stochastic(String.format(Locale.US, this.jsBase + ".stochastic(%s, %s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Thumbs thumbs() {
        return new Thumbs(this.jsBase + ".thumbs()");
    }

    public Scroller thumbs(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".thumbs(%s);", bool));
        return this;
    }

    public Scroller thumbs(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".thumbs(%s);", wrapQuotes(str)));
        return this;
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, StockSeriesType stockSeriesType, String str) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str)));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, String str, StockSeriesType stockSeriesType) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, MovingAverageType movingAverageType2, String str, String str2) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, movingAverageType2 != null ? movingAverageType2.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2)));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, String str, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, String str, StockSeriesType stockSeriesType, String str2) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, String str, String str2, StockSeriesType stockSeriesType) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, String str, String str2, String str3) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, MovingAverageType movingAverageType, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, MovingAverageType movingAverageType, StockSeriesType stockSeriesType, String str2) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, MovingAverageType movingAverageType, String str2, StockSeriesType stockSeriesType) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, MovingAverageType movingAverageType, String str2, String str3) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, String str2, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, String str2, StockSeriesType stockSeriesType, String str3) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str3)));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, String str2, String str3, StockSeriesType stockSeriesType) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public TRIX trix(TableMapping tableMapping, Number number, Number number2, String str, String str2, String str3, String str4) {
        return new TRIX(String.format(Locale.US, this.jsBase + ".trix(%s, %s, %s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public void setOnClickListener(ListenersInterface.OnClickListener onClickListener) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jsBase).append(".listen('pointClick', function(e) {");
        if (onClickListener.getFields() != null) {
            sb.append("var result = ");
            for (String str : onClickListener.getFields()) {
                sb.append(String.format(Locale.US, "'%1$s' + ':' + e.point.get('%1$s') + ',' +", str));
            }
            sb.setLength(sb.length() - 8);
            sb.append(";");
            sb.append("android.onClick(result);");
        } else {
            sb.append("android.onClick(null);");
        }
        sb.append("});");
        ListenersInterface.getInstance().setOnClickListener(onClickListener);
        APIlib.getInstance().addJSLine(sb.toString());
    }

    public void setOnClickListener(ListenersInterface.OnClickListener onClickListener, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jsBase).append(String.format(Locale.US, ".listen('%1$s', function(e) {", str));
        if (onClickListener.getFields() != null) {
            String str3 = str2 != null ? str2 + InstructionFileId.DOT : "";
            sb.append("var result = ");
            for (String str4 : onClickListener.getFields()) {
                sb.append(String.format(Locale.US, "'%1$s' + ':' + e.%2$s%1$s + ',' +", str4, str3));
            }
            sb.setLength(sb.length() - 8);
            sb.append(";");
            sb.append("android.onClick(result);");
        } else {
            sb.append("android.onClick(null);");
        }
        sb.append("});");
        ListenersInterface.getInstance().setOnClickListener(onClickListener);
        APIlib.getInstance().addJSLine(sb.toString());
    }

    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, MovingAverageType movingAverageType, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, MovingAverageType movingAverageType, StockSeriesType stockSeriesType, String str) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str)));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, MovingAverageType movingAverageType, String str, StockSeriesType stockSeriesType) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, MovingAverageType movingAverageType, String str, String str2) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2)));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, String str, StockSeriesType stockSeriesType, StockSeriesType stockSeriesType2) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, stockSeriesType2 != null ? stockSeriesType2.getJsBase() : null));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, String str, StockSeriesType stockSeriesType, String str2) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), stockSeriesType != null ? stockSeriesType.getJsBase() : null, wrapQuotes(str2)));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, String str, String str2, StockSeriesType stockSeriesType) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public VolumeMA volumeMa(TableMapping tableMapping, Number number, String str, String str2, String str3) {
        return new VolumeMA(String.format(Locale.US, this.jsBase + ".volumeMa(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public WilliamsR williamsR(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new WilliamsR(String.format(Locale.US, this.jsBase + ".williamsR(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public WilliamsR williamsR(TableMapping tableMapping, Number number, String str) {
        return new WilliamsR(String.format(Locale.US, this.jsBase + ".williamsR(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public StockDateTime xAxis() {
        return new StockDateTime(this.jsBase + ".xAxis()");
    }

    public Scroller xAxis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", wrapQuotes(str)));
        return this;
    }

    public Scroller xAxis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", bool));
        return this;
    }

    public ScatterBase yScale() {
        return new ScatterBase(this.jsBase + ".yScale()");
    }

    public Scroller yScale(ScatterScaleTypes scatterScaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scatterScaleTypes != null ? scatterScaleTypes.getJsBase() : null));
        return this;
    }

    public Scroller yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Scroller yScale(ScatterBase scatterBase) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scatterBase != null ? scatterBase.getJsBase() : null));
        return this;
    }

    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    public Scroller zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    public Scroller container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    public Scroller container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    public Scroller container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.math.Rect parentBounds() {
        return new com.anychart.math.Rect(this.jsBase + ".parentBounds()");
    }

    public Scroller parentBounds(com.anychart.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    public Scroller parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    public Scroller parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    public Scroller parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Area area(TableMapping tableMapping) {
        return new Area(String.format(Locale.US, this.jsBase + ".area(%s)", tableMapping != null ? tableMapping.getJsBase() : null));
    }

    public Line line(TableMapping tableMapping) {
        return new Line(String.format(Locale.US, this.jsBase + ".line(%s)", tableMapping != null ? tableMapping.getJsBase() : null));
    }

    public Hilo hilo(TableMapping tableMapping) {
        return new Hilo(String.format(Locale.US, this.jsBase + ".hilo(%s)", tableMapping != null ? tableMapping.getJsBase() : null));
    }

    public OHLC ohlc(TableMapping tableMapping) {
        return new OHLC(String.format(Locale.US, this.jsBase + ".ohlc(%s)", tableMapping != null ? tableMapping.getJsBase() : null));
    }

    public Object yScale(Class cls) {
        try {
            return cls.getDeclaredConstructor(String.class).newInstance(this.jsBase + ".yScale()");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public Scroller fill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", wrapQuotes(str)));
        return this;
    }
}
