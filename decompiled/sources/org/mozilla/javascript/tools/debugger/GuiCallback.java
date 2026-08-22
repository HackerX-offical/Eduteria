package org.mozilla.javascript.tools.debugger;

import org.mozilla.javascript.tools.debugger.Dim;

/* JADX INFO: loaded from: classes10.dex */
public interface GuiCallback {
    void dispatchNextGuiEvent() throws InterruptedException;

    void enterInterrupt(Dim.StackFrame stackFrame, String str, String str2);

    boolean isGuiEventThread();

    void updateSourceText(Dim.SourceInfo sourceInfo);
}
