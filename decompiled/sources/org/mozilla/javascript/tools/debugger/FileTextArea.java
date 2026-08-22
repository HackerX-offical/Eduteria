package org.mozilla.javascript.tools.debugger;

import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.BadLocationException;

/* JADX INFO: compiled from: SwingGui.java */
/* JADX INFO: loaded from: classes10.dex */
class FileTextArea extends JTextArea implements ActionListener, PopupMenuListener, KeyListener, MouseListener {
    private static final long serialVersionUID = -25032065448563720L;
    private FilePopupMenu popup;
    private FileWindow w;

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }

    public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
    }

    public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
    }

    public FileTextArea(FileWindow fileWindow) {
        this.w = fileWindow;
        FilePopupMenu filePopupMenu = new FilePopupMenu(this);
        this.popup = filePopupMenu;
        filePopupMenu.addPopupMenuListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFont(new Font("Monospaced", 0, 12));
    }

    public void select(int i) {
        if (i >= 0) {
            try {
                int lineOfOffset = getLineOfOffset(i);
                Rectangle rectangleModelToView = modelToView(i);
                if (rectangleModelToView == null) {
                    select(i, i);
                    return;
                }
                try {
                    Rectangle rectangleModelToView2 = modelToView(getLineStartOffset(lineOfOffset + 1));
                    if (rectangleModelToView2 != null) {
                        rectangleModelToView = rectangleModelToView2;
                    }
                } catch (Exception unused) {
                }
                Rectangle viewRect = getParent().getViewRect();
                if (viewRect.y + viewRect.height > rectangleModelToView.y) {
                    select(i, i);
                    return;
                }
                rectangleModelToView.y += (viewRect.height - rectangleModelToView.height) / 2;
                scrollRectToVisible(rectangleModelToView);
                select(i, i);
            } catch (BadLocationException unused2) {
                select(i, i);
            }
        }
    }

    private void checkPopup(MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.popup.show(this, mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        checkPopup(mouseEvent);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        checkPopup(mouseEvent);
        requestFocus();
        getCaret().setVisible(true);
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        checkPopup(mouseEvent);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        int lineOfOffset;
        int iViewToModel = viewToModel(new Point(this.popup.x, this.popup.y));
        this.popup.setVisible(false);
        String actionCommand = actionEvent.getActionCommand();
        try {
            lineOfOffset = getLineOfOffset(iViewToModel);
        } catch (Exception unused) {
            lineOfOffset = -1;
        }
        if (actionCommand.equals("Set Breakpoint")) {
            this.w.setBreakPoint(lineOfOffset + 1);
        } else if (actionCommand.equals("Clear Breakpoint")) {
            this.w.clearBreakPoint(lineOfOffset + 1);
        } else if (actionCommand.equals("Run")) {
            this.w.load();
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 127) {
            switch (keyCode) {
            }
            return;
        }
        keyEvent.consume();
    }

    public void keyTyped(KeyEvent keyEvent) {
        keyEvent.consume();
    }

    public void keyReleased(KeyEvent keyEvent) {
        keyEvent.consume();
    }
}
