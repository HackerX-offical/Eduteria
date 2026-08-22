package com.anychart.data;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.data.tree.DataItem;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Tree extends Base {
    protected Tree() {
    }

    public static Tree instantiate() {
        return new Tree("new anychart.data.tree()");
    }

    public Tree(String str) {
        StringBuilder sb = new StringBuilder("tree");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public DataItem addChild(String str) {
        return new DataItem(String.format(Locale.US, this.jsBase + ".addChild(%s)", wrapQuotes(str)));
    }

    public DataItem addChildAt(String str, Number number) {
        return new DataItem(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s)", wrapQuotes(str), number));
    }

    public DataItem addChildAt(DataItem dataItem, Number number) {
        return new DataItem(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s)", dataItem != null ? dataItem.getJsBase() : null, number));
    }

    public DataItem addChildAt(com.anychart.data.treeview.DataItem dataItem, Number number) {
        return new DataItem(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s)", dataItem != null ? dataItem.getJsBase() : null, number));
    }

    public Tree addData(List<DataEntry> list) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addData(%s);", arrayToString(list)));
        return this;
    }

    public void dispatchEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispatchEvents();");
    }

    public Tree dispatchEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dispatchEvents(%s);", bool));
        return this;
    }

    public DataItem getChildAt(Number number) {
        return new DataItem(String.format(Locale.US, this.jsBase + ".getChildAt(%s)", number));
    }

    public void getChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getChildren();");
    }

    public Traverser getTraverser() {
        return new Traverser(this.jsBase + ".getTraverser()");
    }

    public void indexOfChild(DataItem dataItem) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".indexOfChild(%s);", dataItem != null ? dataItem.getJsBase() : null));
    }

    public void indexOfChild(com.anychart.data.treeview.DataItem dataItem) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".indexOfChild(%s);", dataItem != null ? dataItem.getJsBase() : null));
    }

    public TreeView mapAs(String str) {
        return new TreeView(String.format(Locale.US, this.jsBase + ".mapAs(%s)", wrapQuotes(str)));
    }

    public void numChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".numChildren();");
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public DataItem removeChild(DataItem dataItem) {
        return new DataItem(String.format(Locale.US, this.jsBase + ".removeChild(%s)", dataItem != null ? dataItem.getJsBase() : null));
    }

    public DataItem removeChildAt(Number number) {
        return new DataItem(String.format(Locale.US, this.jsBase + ".removeChildAt(%s)", number));
    }

    public Tree removeChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeChildren();");
        return this;
    }

    public Tree removeIndexOn(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeIndexOn(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Base
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

    @Override // com.anychart.core.Base
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

    @Override // com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }
}
