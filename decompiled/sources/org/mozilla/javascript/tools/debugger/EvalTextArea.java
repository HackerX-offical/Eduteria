package org.mozilla.javascript.tools.debugger;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Segment;

/* JADX INFO: compiled from: SwingGui.java */
/* JADX INFO: loaded from: classes10.dex */
class EvalTextArea extends JTextArea implements KeyListener, DocumentListener {
    private static final long serialVersionUID = -3918033649601064194L;
    private SwingGui debugGui;
    private int outputMark;
    private int historyIndex = -1;
    private List<String> history = Collections.synchronizedList(new ArrayList());

    public EvalTextArea(SwingGui swingGui) {
        this.debugGui = swingGui;
        Document document = getDocument();
        document.addDocumentListener(this);
        addKeyListener(this);
        setLineWrap(true);
        setFont(new Font("Monospaced", 0, 12));
        append("% ");
        this.outputMark = document.getLength();
    }

    public void select(int i, int i2) {
        super.select(i, i2);
    }

    private synchronized void returnPressed() {
        Document document = getDocument();
        int length = document.getLength();
        Segment segment = new Segment();
        try {
            int i = this.outputMark;
            document.getText(i, length - i, segment);
        } catch (BadLocationException e2) {
            e2.printStackTrace();
        }
        String string = segment.toString();
        if (this.debugGui.dim.stringIsCompilableUnit(string)) {
            if (string.trim().length() > 0) {
                this.history.add(string);
                this.historyIndex = this.history.size();
            }
            append("\n");
            String strEval = this.debugGui.dim.eval(string);
            if (strEval.length() > 0) {
                append(strEval);
                append("\n");
            }
            append("% ");
            this.outputMark = document.getLength();
        } else {
            append("\n");
        }
    }

    public synchronized void write(String str) {
        insert(str, this.outputMark);
        int length = this.outputMark + str.length();
        this.outputMark = length;
        select(length, length);
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 8 || keyCode == 37) {
            if (this.outputMark == getCaretPosition()) {
                keyEvent.consume();
                return;
            }
            return;
        }
        if (keyCode == 36) {
            int caretPosition = getCaretPosition();
            int i = this.outputMark;
            if (caretPosition == i) {
                keyEvent.consume();
                return;
            }
            if (caretPosition <= i || keyEvent.isControlDown()) {
                return;
            }
            if (keyEvent.isShiftDown()) {
                moveCaretPosition(this.outputMark);
            } else {
                setCaretPosition(this.outputMark);
            }
            keyEvent.consume();
            return;
        }
        if (keyCode == 10) {
            returnPressed();
            keyEvent.consume();
            return;
        }
        if (keyCode == 38) {
            int i2 = this.historyIndex;
            int i3 = i2 - 1;
            this.historyIndex = i3;
            if (i3 >= 0) {
                if (i3 >= this.history.size()) {
                    this.historyIndex = this.history.size() - 1;
                }
                int i4 = this.historyIndex;
                if (i4 >= 0) {
                    String str = this.history.get(i4);
                    replaceRange(str, this.outputMark, getDocument().getLength());
                    int length = this.outputMark + str.length();
                    select(length, length);
                } else {
                    this.historyIndex = i4 + 1;
                }
            } else {
                this.historyIndex = i2;
            }
            keyEvent.consume();
            return;
        }
        if (keyCode == 40) {
            int length2 = this.outputMark;
            if (this.history.size() > 0) {
                int i5 = this.historyIndex + 1;
                this.historyIndex = i5;
                if (i5 < 0) {
                    this.historyIndex = 0;
                }
                int length3 = getDocument().getLength();
                if (this.historyIndex < this.history.size()) {
                    String str2 = this.history.get(this.historyIndex);
                    replaceRange(str2, this.outputMark, length3);
                    length2 = str2.length() + this.outputMark;
                } else {
                    this.historyIndex = this.history.size();
                    replaceRange("", this.outputMark, length3);
                }
            }
            select(length2, length2);
            keyEvent.consume();
        }
    }

    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == '\b') {
            if (this.outputMark == getCaretPosition()) {
                keyEvent.consume();
            }
        } else {
            int caretPosition = getCaretPosition();
            int i = this.outputMark;
            if (caretPosition < i) {
                setCaretPosition(i);
            }
        }
    }

    public synchronized void keyReleased(KeyEvent keyEvent) {
    }

    public synchronized void insertUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        int offset = documentEvent.getOffset();
        int i = this.outputMark;
        if (i > offset) {
            this.outputMark = i + length;
        }
    }

    public synchronized void removeUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        int offset = documentEvent.getOffset();
        int i = this.outputMark;
        if (i > offset) {
            if (i >= offset + length) {
                this.outputMark = i - length;
            } else {
                this.outputMark = offset;
            }
        }
    }

    public synchronized void postUpdateUI() {
        setCaret(getCaret());
        int i = this.outputMark;
        select(i, i);
    }

    public synchronized void changedUpdate(DocumentEvent documentEvent) {
    }
}
