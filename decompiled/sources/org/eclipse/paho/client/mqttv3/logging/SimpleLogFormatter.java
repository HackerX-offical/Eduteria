package org.eclipse.paho.client.mqttv3.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: classes10.dex */
public class SimpleLogFormatter extends Formatter {
    private static final String LS = System.getProperty("line.separator");

    @Override // java.util.logging.Formatter
    public String format(LogRecord logRecord) throws Throwable {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(logRecord.getLevel().getName()).append("\t");
        stringBuffer.append(String.valueOf(MessageFormat.format("{0, date, yy-MM-dd} {0, time, kk:mm:ss.SSSS} ", new Date(logRecord.getMillis()))) + "\t");
        String sourceClassName = logRecord.getSourceClassName();
        if (sourceClassName == null) {
            string = "";
        } else {
            int length = sourceClassName.length();
            if (length > 20) {
                string = logRecord.getSourceClassName().substring(length - 19);
            } else {
                string = new StringBuffer().append(sourceClassName).append(new char[]{' '}, 0, 1).toString();
            }
        }
        stringBuffer.append(string).append("\t ");
        stringBuffer.append(left(logRecord.getSourceMethodName(), 23, ' ')).append("\t");
        stringBuffer.append(logRecord.getThreadID()).append("\t");
        stringBuffer.append(formatMessage(logRecord)).append(LS);
        if (logRecord.getThrown() != null) {
            stringBuffer.append("Throwable occurred: ");
            Throwable thrown = logRecord.getThrown();
            PrintWriter printWriter = null;
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter2 = new PrintWriter(stringWriter);
                try {
                    thrown.printStackTrace(printWriter2);
                    stringBuffer.append(stringWriter.toString());
                    try {
                        printWriter2.close();
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return stringBuffer.toString();
    }

    public static String left(String str, int i, char c2) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length >= 0) {
                stringBuffer.append(c2);
            } else {
                return stringBuffer.toString();
            }
        }
    }
}
