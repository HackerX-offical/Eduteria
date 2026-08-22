package org.mozilla.javascript.tools.debugger;

import org.mozilla.javascript.tools.debugger.Dim;

/* JADX INFO: compiled from: SwingGui.java */
/* JADX INFO: loaded from: classes10.dex */
class RunProxy implements Runnable {
    static final int ENTER_INTERRUPT = 4;
    static final int LOAD_FILE = 2;
    static final int OPEN_FILE = 1;
    static final int UPDATE_SOURCE_TEXT = 3;
    String alertMessage;
    private SwingGui debugGui;
    String fileName;
    Dim.StackFrame lastFrame;
    Dim.SourceInfo sourceInfo;
    String text;
    String threadTitle;
    private int type;

    public RunProxy(SwingGui swingGui, int i) {
        this.debugGui = swingGui;
        this.type = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.type;
        if (i == 1) {
            try {
                this.debugGui.dim.compileScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e2) {
                MessageDialogWrapper.showMessageDialog(this.debugGui, e2.getMessage(), "Error Compiling " + this.fileName, 0);
                return;
            }
        }
        if (i == 2) {
            try {
                this.debugGui.dim.evalScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e3) {
                MessageDialogWrapper.showMessageDialog(this.debugGui, e3.getMessage(), "Run error for " + this.fileName, 0);
                return;
            }
        }
        if (i != 3) {
            if (i == 4) {
                this.debugGui.enterInterruptImpl(this.lastFrame, this.threadTitle, this.alertMessage);
                return;
            }
            throw new IllegalArgumentException(String.valueOf(this.type));
        }
        String strUrl = this.sourceInfo.url();
        if (this.debugGui.updateFileWindow(this.sourceInfo) || strUrl.equals("<stdin>")) {
            return;
        }
        this.debugGui.createFileWindow(this.sourceInfo, -1);
    }
}
