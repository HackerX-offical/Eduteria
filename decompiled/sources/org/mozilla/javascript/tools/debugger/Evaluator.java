package org.mozilla.javascript.tools.debugger;

import javax.swing.JTable;

/* JADX INFO: compiled from: SwingGui.java */
/* JADX INFO: loaded from: classes10.dex */
class Evaluator extends JTable {
    private static final long serialVersionUID = 8133672432982594256L;
    MyTableModel tableModel;

    public Evaluator(SwingGui swingGui) {
        super(new MyTableModel(swingGui));
        this.tableModel = getModel();
    }
}
