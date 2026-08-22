package com.anychart.core.stock;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.NoDataSettings;
import com.anychart.core.VisualBaseWithBounds;
import com.anychart.core.annotations.PlotController;
import com.anychart.core.axes.Linear;
import com.anychart.core.axes.StockDateTime;
import com.anychart.core.axismarkers.CurrentPriceIndicator;
import com.anychart.core.axismarkers.Range;
import com.anychart.core.axismarkers.Text;
import com.anychart.core.grids.Stock;
import com.anychart.core.stock.eventmarkers.Controller;
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
import com.anychart.core.stock.series.Area;
import com.anychart.core.stock.series.Base;
import com.anychart.core.stock.series.Hilo;
import com.anychart.core.stock.series.Line;
import com.anychart.core.stock.series.OHLC;
import com.anychart.core.ui.Background;
import com.anychart.core.ui.Crosshair;
import com.anychart.core.ui.DataArea;
import com.anychart.core.ui.Legend;
import com.anychart.core.ui.Title;
import com.anychart.core.utils.Bounds;
import com.anychart.data.Table;
import com.anychart.data.TableMapping;
import com.anychart.enums.MarkerType;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.ScatterScaleTypes;
import com.anychart.enums.Statistics;
import com.anychart.enums.StockSeriesType;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import com.anychart.math.Rect;
import com.anychart.palettes.DistinctColors;
import com.anychart.palettes.HatchFills;
import com.anychart.palettes.Markers;
import com.anychart.palettes.RangeColors;
import com.anychart.scales.ScatterBase;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Plot extends VisualBaseWithBounds {
    protected Plot() {
    }

    public static Plot instantiate() {
        return new Plot("new anychart.core.stock.plot()");
    }

    public Plot(String str) {
        StringBuilder sb = new StringBuilder("plot");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void addSeries(TableMapping tableMapping) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addSeries(%s);", tableMapping != null ? tableMapping.getJsBase() : null));
    }

    public ADL adl(TableMapping tableMapping, StockSeriesType stockSeriesType) {
        return new ADL(String.format(Locale.US, this.jsBase + ".adl(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public ADL adl(TableMapping tableMapping, String str) {
        return new ADL(String.format(Locale.US, this.jsBase + ".adl(%s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, wrapQuotes(str)));
    }

    public AMA ama(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType) {
        return new AMA(String.format(Locale.US, this.jsBase + ".ama(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public AMA ama(TableMapping tableMapping, Number number, Number number2, Number number3, String str) {
        return new AMA(String.format(Locale.US, this.jsBase + ".ama(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str)));
    }

    public PlotController annotations() {
        return new PlotController(this.jsBase + ".annotations()");
    }

    public Plot annotations(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".annotations(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
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

    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    public Plot background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot background(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", bool));
        return this;
    }

    public void baseline() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseline();");
    }

    public Plot baseline(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseline(%s);", number));
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

    @Override // com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public CCI cci(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new CCI(String.format(Locale.US, this.jsBase + ".cci(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public CCI cci(TableMapping tableMapping, Number number, String str) {
        return new CCI(String.format(Locale.US, this.jsBase + ".cci(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    public CHO cho(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, StockSeriesType stockSeriesType) {
        return new CHO(String.format(Locale.US, this.jsBase + ".cho(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public CHO cho(TableMapping tableMapping, Number number, Number number2, MovingAverageType movingAverageType, String str) {
        return new CHO(String.format(Locale.US, this.jsBase + ".cho(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, movingAverageType != null ? movingAverageType.getJsBase() : null, wrapQuotes(str)));
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

    public Crosshair crosshair() {
        return new Crosshair(this.jsBase + ".crosshair()");
    }

    public Plot crosshair(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot crosshair(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", bool));
        return this;
    }

    public DataArea dataArea() {
        return new DataArea(this.jsBase + ".dataArea()");
    }

    public Plot dataArea(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dataArea(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot dataArea(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dataArea(%s);", bool));
        return this;
    }

    public void defaultSeriesType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".defaultSeriesType();");
    }

    public Plot defaultSeriesType(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public Plot defaultSeriesType(String str) {
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

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public Controller eventMarkers() {
        return new Controller(this.jsBase + ".eventMarkers()");
    }

    public Plot eventMarkers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".eventMarkers(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot eventMarkers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".eventMarkers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
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

    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
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

    public HatchFills hatchFillPalette(HatchFillType[] hatchFillTypeArr) {
        return new HatchFills(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s)", arrayToString(hatchFillTypeArr)));
    }

    public HatchFills hatchFillPalette(String str) {
        return new HatchFills(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s)", wrapQuotes(str)));
    }

    public HatchFills hatchFillPalette(HatchFills hatchFills) {
        return new HatchFills(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s)", hatchFills != null ? hatchFills.getJsBase() : null));
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot height(String str) {
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

    @Override // com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend legend() {
        return new Legend(this.jsBase + ".legend()");
    }

    public Plot legend(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot legend(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", bool));
        return this;
    }

    public Line line(Table table) {
        return new Line(String.format(Locale.US, this.jsBase + ".line(%s)", table != null ? table.getJsBase() : null));
    }

    public com.anychart.core.axismarkers.Line lineMarker(Number number) {
        return new com.anychart.core.axismarkers.Line(String.format(Locale.US, this.jsBase + ".lineMarker(%s)", number));
    }

    public Plot lineMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot lineMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", bool));
        return this;
    }

    public Plot lineMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot lineMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, bool));
        return this;
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

    public Markers markerPalette() {
        return new Markers(this.jsBase + ".markerPalette()");
    }

    public Plot markerPalette(Markers markers) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markers != null ? markers.getJsBase() : null));
        return this;
    }

    public Plot markerPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot markerPalette(MarkerType markerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markerType != null ? markerType.getJsBase() : null));
        return this;
    }

    public Plot markerPalette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public void maxPointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxPointWidth();");
    }

    public Plot maxPointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", number));
        return this;
    }

    public Plot maxPointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public MFI mfi(TableMapping tableMapping, Number number, StockSeriesType stockSeriesType) {
        return new MFI(String.format(Locale.US, this.jsBase + ".mfi(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public MFI mfi(TableMapping tableMapping, Number number, String str) {
        return new MFI(String.format(Locale.US, this.jsBase + ".mfi(%s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, wrapQuotes(str)));
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public void minPointLength() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minPointLength();");
    }

    public Plot minPointLength(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", number));
        return this;
    }

    public Plot minPointLength(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
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

    public NoDataSettings noData() {
        return new NoDataSettings(this.jsBase + ".noData()");
    }

    public Plot noData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".noData(%s);", wrapQuotes(str)));
        return this;
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

    public RangeColors palette() {
        return new RangeColors(this.jsBase + ".palette()");
    }

    public Plot palette(RangeColors rangeColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", rangeColors != null ? rangeColors.getJsBase() : null));
        return this;
    }

    public Plot palette(DistinctColors distinctColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", distinctColors != null ? distinctColors.getJsBase() : null));
        return this;
    }

    public Plot palette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot palette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void pointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pointWidth();");
    }

    public Plot pointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", number));
        return this;
    }

    public Plot pointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", wrapQuotes(str)));
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

    public CurrentPriceIndicator priceIndicator(Number number) {
        return new CurrentPriceIndicator(String.format(Locale.US, this.jsBase + ".priceIndicator(%s)", number));
    }

    public Plot priceIndicator(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".priceIndicator(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot priceIndicator(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".priceIndicator(%s);", bool));
        return this;
    }

    public Plot priceIndicator(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".priceIndicator(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot priceIndicator(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".priceIndicator(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    public PSAR psar(TableMapping tableMapping, Number number, Number number2, Number number3, StockSeriesType stockSeriesType) {
        return new PSAR(String.format(Locale.US, this.jsBase + ".psar(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public PSAR psar(TableMapping tableMapping, Number number, Number number2, Number number3, String str) {
        return new PSAR(String.format(Locale.US, this.jsBase + ".psar(%s, %s, %s, %s, %s)", tableMapping != null ? tableMapping.getJsBase() : null, number, number2, number3, wrapQuotes(str)));
    }

    public Range rangeMarker(Number number) {
        return new Range(String.format(Locale.US, this.jsBase + ".rangeMarker(%s)", number));
    }

    public Plot rangeMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot rangeMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", bool));
        return this;
    }

    public Plot rangeMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot rangeMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Plot removeAllSeries() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeAllSeries();");
        return this;
    }

    public Plot removeSeries(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", number));
        return this;
    }

    public Plot removeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot removeSeriesAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeriesAt(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
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

    public Text textMarker(Number number) {
        return new Text(String.format(Locale.US, this.jsBase + ".textMarker(%s)", number));
    }

    public Plot textMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot textMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", bool));
        return this;
    }

    public Plot textMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot textMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, bool));
        return this;
    }

    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    public Plot title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    public Plot title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
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

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds
    public Plot width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
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

    public Plot xAxis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot xAxis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", bool));
        return this;
    }

    public Stock xGrid(Number number) {
        return new Stock(String.format(Locale.US, this.jsBase + ".xGrid(%s)", number));
    }

    public Plot xGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot xGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s);", bool));
        return this;
    }

    public Plot xGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot xGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s, %s);", number, bool));
        return this;
    }

    public Stock xMinorGrid(Number number) {
        return new Stock(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s)", number));
    }

    public Plot xMinorGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot xMinorGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s);", bool));
        return this;
    }

    public Plot xMinorGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot xMinorGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s, %s);", number, bool));
        return this;
    }

    public Linear yAxis(Number number) {
        return new Linear(String.format(Locale.US, this.jsBase + ".yAxis(%s)", number));
    }

    public Plot yAxis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot yAxis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s);", bool));
        return this;
    }

    public Plot yAxis(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot yAxis(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s, %s);", number, bool));
        return this;
    }

    public Stock yGrid(Number number) {
        return new Stock(String.format(Locale.US, this.jsBase + ".yGrid(%s)", number));
    }

    public Plot yGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot yGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s);", bool));
        return this;
    }

    public Plot yGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot yGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s, %s);", number, bool));
        return this;
    }

    public Stock yMinorGrid(Number number) {
        return new Stock(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s)", number));
    }

    public Plot yMinorGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot yMinorGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s);", bool));
        return this;
    }

    public Plot yMinorGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Plot yMinorGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s, %s);", number, bool));
        return this;
    }

    public ScatterBase yScale() {
        return new ScatterBase(this.jsBase + ".yScale()");
    }

    public Plot yScale(ScatterScaleTypes scatterScaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scatterScaleTypes != null ? scatterScaleTypes.getJsBase() : null));
        return this;
    }

    public Plot yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Plot yScale(ScatterBase scatterBase) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scatterBase != null ? scatterBase.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Plot parentBounds(Number number, Number number2, Number number3, Number number4) {
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
}
