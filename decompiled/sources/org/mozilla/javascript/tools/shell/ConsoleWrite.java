package org.mozilla.javascript.tools.shell;

/* JADX INFO: compiled from: ConsoleTextArea.java */
/* JADX INFO: loaded from: classes10.dex */
class ConsoleWrite implements Runnable {
    private String str;
    private ConsoleTextArea textArea;

    public ConsoleWrite(ConsoleTextArea consoleTextArea, String str) {
        this.textArea = consoleTextArea;
        this.str = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.textArea.write(this.str);
    }
}
