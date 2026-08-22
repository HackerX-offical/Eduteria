package org.mozilla.javascript.tools.debugger;

import com.appnew.android.home.Constants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

/* JADX INFO: compiled from: SwingGui.java */
/* JADX INFO: loaded from: classes10.dex */
class FileHeader extends JPanel implements MouseListener {
    private static final long serialVersionUID = -2858905404778259127L;
    private FileWindow fileWindow;
    private int pressLine = -1;

    public void mouseClicked(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }

    public FileHeader(FileWindow fileWindow) {
        this.fileWindow = fileWindow;
        addMouseListener(this);
        update();
    }

    public void update() {
        FileTextArea fileTextArea = this.fileWindow.textArea;
        Font font = fileTextArea.getFont();
        setFont(font);
        FontMetrics fontMetrics = getFontMetrics(font);
        int height = fontMetrics.getHeight();
        int lineCount = fileTextArea.getLineCount() + 1;
        String string = Integer.toString(lineCount);
        if (string.length() < 2) {
            string = Constants.LEFT_NAV_KEY.custom_payment;
        }
        Dimension dimension = new Dimension();
        dimension.width = fontMetrics.stringWidth(string) + 16;
        dimension.height = (lineCount * height) + 100;
        setPreferredSize(dimension);
        setSize(dimension);
    }

    public void paint(Graphics graphics) {
        int lineStartOffset;
        super.paint(graphics);
        FileTextArea fileTextArea = this.fileWindow.textArea;
        Font font = fileTextArea.getFont();
        graphics.setFont(font);
        FontMetrics fontMetrics = getFontMetrics(font);
        Rectangle clipBounds = graphics.getClipBounds();
        graphics.setColor(getBackground());
        graphics.fillRect(clipBounds.x, clipBounds.y, clipBounds.width, clipBounds.height);
        int maxAscent = fontMetrics.getMaxAscent();
        int height = fontMetrics.getHeight();
        int lineCount = fileTextArea.getLineCount() + 1;
        Integer.toString(lineCount).length();
        int i = clipBounds.y / height;
        int i2 = ((clipBounds.y + clipBounds.height) / height) + 1;
        int width = getWidth();
        if (i2 <= lineCount) {
            lineCount = i2;
        }
        while (i < lineCount) {
            try {
                lineStartOffset = fileTextArea.getLineStartOffset(i);
            } catch (BadLocationException unused) {
                lineStartOffset = -2;
            }
            int i3 = i + 1;
            boolean zIsBreakPoint = this.fileWindow.isBreakPoint(i3);
            String str = Integer.toString(i3) + " ";
            int i4 = i * height;
            graphics.setColor(Color.blue);
            int i5 = i4 + maxAscent;
            graphics.drawString(str, 0, i5);
            int i6 = width - maxAscent;
            if (zIsBreakPoint) {
                graphics.setColor(new Color(128, 0, 0));
                int i7 = i5 - 9;
                graphics.fillOval(i6, i7, 9, 9);
                graphics.drawOval(i6, i7, 8, 8);
                graphics.drawOval(i6, i7, 9, 9);
            }
            if (lineStartOffset == this.fileWindow.currentPos) {
                Polygon polygon = new Polygon();
                int i8 = i4 + (maxAscent - 10);
                int i9 = i8 + 3;
                polygon.addPoint(i6, i9);
                int i10 = i6 + 5;
                polygon.addPoint(i10, i9);
                int i11 = i8;
                int i12 = i10;
                while (i12 <= i6 + 10) {
                    polygon.addPoint(i12, i11);
                    i12++;
                    i11++;
                }
                int i13 = i6 + 9;
                while (i13 >= i10) {
                    polygon.addPoint(i13, i11);
                    i13--;
                    i11++;
                }
                int i14 = i8 + 7;
                polygon.addPoint(i10, i14);
                polygon.addPoint(i6, i14);
                graphics.setColor(Color.yellow);
                graphics.fillPolygon(polygon);
                graphics.setColor(Color.black);
                graphics.drawPolygon(polygon);
            }
            i = i3;
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        this.pressLine = mouseEvent.getY() / getFontMetrics(this.fileWindow.textArea.getFont()).getHeight();
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getComponent() != this || (mouseEvent.getModifiers() & 16) == 0) {
            return;
        }
        int y = mouseEvent.getY() / getFontMetrics(this.fileWindow.textArea.getFont()).getHeight();
        if (y == this.pressLine) {
            this.fileWindow.toggleBreakPoint(y + 1);
        } else {
            this.pressLine = -1;
        }
    }
}
