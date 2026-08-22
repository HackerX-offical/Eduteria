package com.csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class CsvReader {
    public static final int ESCAPE_MODE_BACKSLASH = 2;
    public static final int ESCAPE_MODE_DOUBLED = 1;
    private Charset charset;
    private boolean closed;
    private ColumnBuffer columnBuffer;
    private int columnsCount;
    private long currentRecord;
    private DataBuffer dataBuffer;
    private String fileName;
    private boolean hasMoreData;
    private boolean hasReadNextLine;
    private HeadersHolder headersHolder;
    private boolean initialized;
    private Reader inputStream;
    private boolean[] isQualified;
    private char lastLetter;
    private RawRecordBuffer rawBuffer;
    private String rawRecord;
    private boolean startedColumn;
    private boolean startedWithQualifier;
    private boolean useCustomRecordDelimiter;
    private UserSettings userSettings;
    private String[] values;

    private static char hexToDec(char c2) {
        return (char) (c2 >= 'a' ? c2 - 'W' : c2 >= 'A' ? c2 - '7' : c2 - '0');
    }

    public CsvReader(String str, char c2, Charset charset) throws FileNotFoundException {
        this.inputStream = null;
        this.fileName = null;
        this.userSettings = new UserSettings();
        this.charset = null;
        this.useCustomRecordDelimiter = false;
        this.dataBuffer = new DataBuffer();
        this.columnBuffer = new ColumnBuffer();
        this.rawBuffer = new RawRecordBuffer();
        this.isQualified = null;
        this.rawRecord = "";
        this.headersHolder = new HeadersHolder();
        this.startedColumn = false;
        this.startedWithQualifier = false;
        this.hasMoreData = true;
        this.lastLetter = (char) 0;
        this.hasReadNextLine = false;
        this.columnsCount = 0;
        this.currentRecord = 0L;
        this.values = new String[10];
        this.initialized = false;
        this.closed = false;
        if (str == null) {
            throw new IllegalArgumentException("Parameter fileName can not be null.");
        }
        if (charset == null) {
            throw new IllegalArgumentException("Parameter charset can not be null.");
        }
        if (!new File(str).exists()) {
            throw new FileNotFoundException("File " + str + " does not exist.");
        }
        this.fileName = str;
        this.userSettings.Delimiter = c2;
        this.charset = charset;
        this.isQualified = new boolean[this.values.length];
    }

    public CsvReader(String str, char c2) throws FileNotFoundException {
        this(str, c2, Charset.forName("ISO-8859-1"));
    }

    public CsvReader(String str) throws FileNotFoundException {
        this(str, Letters.COMMA);
    }

    public CsvReader(Reader reader, char c2) {
        this.inputStream = null;
        this.fileName = null;
        this.userSettings = new UserSettings();
        this.charset = null;
        this.useCustomRecordDelimiter = false;
        this.dataBuffer = new DataBuffer();
        this.columnBuffer = new ColumnBuffer();
        this.rawBuffer = new RawRecordBuffer();
        this.isQualified = null;
        this.rawRecord = "";
        this.headersHolder = new HeadersHolder();
        this.startedColumn = false;
        this.startedWithQualifier = false;
        this.hasMoreData = true;
        this.lastLetter = (char) 0;
        this.hasReadNextLine = false;
        this.columnsCount = 0;
        this.currentRecord = 0L;
        this.values = new String[10];
        this.initialized = false;
        this.closed = false;
        if (reader == null) {
            throw new IllegalArgumentException("Parameter inputStream can not be null.");
        }
        this.inputStream = reader;
        this.userSettings.Delimiter = c2;
        this.initialized = true;
        this.isQualified = new boolean[this.values.length];
    }

    public CsvReader(Reader reader) {
        this(reader, Letters.COMMA);
    }

    public CsvReader(InputStream inputStream, char c2, Charset charset) {
        this(new InputStreamReader(inputStream, charset), c2);
    }

    public CsvReader(InputStream inputStream, Charset charset) {
        this(new InputStreamReader(inputStream, charset));
    }

    public boolean getCaptureRawRecord() {
        return this.userSettings.CaptureRawRecord;
    }

    public void setCaptureRawRecord(boolean z) {
        this.userSettings.CaptureRawRecord = z;
    }

    public String getRawRecord() {
        return this.rawRecord;
    }

    public boolean getTrimWhitespace() {
        return this.userSettings.TrimWhitespace;
    }

    public void setTrimWhitespace(boolean z) {
        this.userSettings.TrimWhitespace = z;
    }

    public char getDelimiter() {
        return this.userSettings.Delimiter;
    }

    public void setDelimiter(char c2) {
        this.userSettings.Delimiter = c2;
    }

    public char getRecordDelimiter() {
        return this.userSettings.RecordDelimiter;
    }

    public void setRecordDelimiter(char c2) {
        this.useCustomRecordDelimiter = true;
        this.userSettings.RecordDelimiter = c2;
    }

    public char getTextQualifier() {
        return this.userSettings.TextQualifier;
    }

    public void setTextQualifier(char c2) {
        this.userSettings.TextQualifier = c2;
    }

    public boolean getUseTextQualifier() {
        return this.userSettings.UseTextQualifier;
    }

    public void setUseTextQualifier(boolean z) {
        this.userSettings.UseTextQualifier = z;
    }

    public char getComment() {
        return this.userSettings.Comment;
    }

    public void setComment(char c2) {
        this.userSettings.Comment = c2;
    }

    public boolean getUseComments() {
        return this.userSettings.UseComments;
    }

    public void setUseComments(boolean z) {
        this.userSettings.UseComments = z;
    }

    public int getEscapeMode() {
        return this.userSettings.EscapeMode;
    }

    public void setEscapeMode(int i) throws IllegalArgumentException {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Parameter escapeMode must be a valid value.");
        }
        this.userSettings.EscapeMode = i;
    }

    public boolean getSkipEmptyRecords() {
        return this.userSettings.SkipEmptyRecords;
    }

    public void setSkipEmptyRecords(boolean z) {
        this.userSettings.SkipEmptyRecords = z;
    }

    public boolean getSafetySwitch() {
        return this.userSettings.SafetySwitch;
    }

    public void setSafetySwitch(boolean z) {
        this.userSettings.SafetySwitch = z;
    }

    public int getColumnCount() {
        return this.columnsCount;
    }

    public long getCurrentRecord() {
        return this.currentRecord - 1;
    }

    public int getHeaderCount() {
        return this.headersHolder.Length;
    }

    public String[] getHeaders() throws IOException {
        checkClosed();
        if (this.headersHolder.Headers == null) {
            return null;
        }
        String[] strArr = new String[this.headersHolder.Length];
        System.arraycopy(this.headersHolder.Headers, 0, strArr, 0, this.headersHolder.Length);
        return strArr;
    }

    public void setHeaders(String[] strArr) {
        this.headersHolder.Headers = strArr;
        this.headersHolder.IndexByName.clear();
        if (strArr != null) {
            this.headersHolder.Length = strArr.length;
        } else {
            this.headersHolder.Length = 0;
        }
        for (int i = 0; i < this.headersHolder.Length; i++) {
            this.headersHolder.IndexByName.put(strArr[i], new Integer(i));
        }
    }

    public String[] getValues() throws IOException {
        checkClosed();
        int i = this.columnsCount;
        String[] strArr = new String[i];
        System.arraycopy(this.values, 0, strArr, 0, i);
        return strArr;
    }

    public String get(int i) throws IOException {
        checkClosed();
        if (i > -1 && i < this.columnsCount) {
            return this.values[i];
        }
        return "";
    }

    public String get(String str) throws IOException {
        checkClosed();
        return get(getIndex(str));
    }

    public static CsvReader parse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter data can not be null.");
        }
        return new CsvReader(new StringReader(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:266:0x0402. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03a5 A[PHI: r9
      0x03a5: PHI (r9v23 char) = (r9v22 char), (r9v28 char), (r9v32 char) binds: [B:234:0x03a3, B:231:0x0398, B:228:0x038d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb A[PHI: r5
      0x00fb: PHI (r5v76 char) = (r5v75 char), (r5v81 char), (r5v84 char), (r5v85 char) binds: [B:48:0x00f9, B:45:0x00ed, B:42:0x00e2, B:39:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean readRecord() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.csvreader.CsvReader.readRecord():boolean");
    }

    private void checkDataLength() throws IOException {
        if (!this.initialized) {
            if (this.fileName != null) {
                this.inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(this.fileName), this.charset), 4096);
            }
            this.charset = null;
            this.initialized = true;
        }
        updateCurrentValue();
        if (this.userSettings.CaptureRawRecord && this.dataBuffer.Count > 0) {
            if (this.rawBuffer.Buffer.length - this.rawBuffer.Position < this.dataBuffer.Count - this.dataBuffer.LineStart) {
                char[] cArr = new char[this.rawBuffer.Buffer.length + Math.max(this.dataBuffer.Count - this.dataBuffer.LineStart, this.rawBuffer.Buffer.length)];
                System.arraycopy(this.rawBuffer.Buffer, 0, cArr, 0, this.rawBuffer.Position);
                this.rawBuffer.Buffer = cArr;
            }
            System.arraycopy(this.dataBuffer.Buffer, this.dataBuffer.LineStart, this.rawBuffer.Buffer, this.rawBuffer.Position, this.dataBuffer.Count - this.dataBuffer.LineStart);
            this.rawBuffer.Position += this.dataBuffer.Count - this.dataBuffer.LineStart;
        }
        try {
            DataBuffer dataBuffer = this.dataBuffer;
            dataBuffer.Count = this.inputStream.read(dataBuffer.Buffer, 0, this.dataBuffer.Buffer.length);
            if (this.dataBuffer.Count == -1) {
                this.hasMoreData = false;
            }
            this.dataBuffer.Position = 0;
            this.dataBuffer.LineStart = 0;
            this.dataBuffer.ColumnStart = 0;
        } catch (IOException e2) {
            close();
            throw e2;
        }
    }

    public boolean readHeaders() throws IOException {
        boolean record = readRecord();
        this.headersHolder.Length = this.columnsCount;
        this.headersHolder.Headers = new String[this.columnsCount];
        for (int i = 0; i < this.headersHolder.Length; i++) {
            String str = get(i);
            this.headersHolder.Headers[i] = str;
            this.headersHolder.IndexByName.put(str, new Integer(i));
        }
        if (record) {
            this.currentRecord--;
        }
        this.columnsCount = 0;
        return record;
    }

    public String getHeader(int i) throws IOException {
        checkClosed();
        if (i > -1 && i < this.headersHolder.Length) {
            return this.headersHolder.Headers[i];
        }
        return "";
    }

    public boolean isQualified(int i) throws IOException {
        checkClosed();
        if (i >= this.columnsCount || i <= -1) {
            return false;
        }
        return this.isQualified[i];
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void endColumn() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.csvreader.CsvReader.endColumn():void");
    }

    private void appendLetter(char c2) {
        if (this.columnBuffer.Position == this.columnBuffer.Buffer.length) {
            char[] cArr = new char[this.columnBuffer.Buffer.length * 2];
            System.arraycopy(this.columnBuffer.Buffer, 0, cArr, 0, this.columnBuffer.Position);
            this.columnBuffer.Buffer = cArr;
        }
        char[] cArr2 = this.columnBuffer.Buffer;
        ColumnBuffer columnBuffer = this.columnBuffer;
        int i = columnBuffer.Position;
        columnBuffer.Position = i + 1;
        cArr2[i] = c2;
        DataBuffer dataBuffer = this.dataBuffer;
        dataBuffer.ColumnStart = dataBuffer.Position + 1;
    }

    private void updateCurrentValue() {
        if (this.startedColumn && this.dataBuffer.ColumnStart < this.dataBuffer.Position) {
            if (this.columnBuffer.Buffer.length - this.columnBuffer.Position < this.dataBuffer.Position - this.dataBuffer.ColumnStart) {
                char[] cArr = new char[this.columnBuffer.Buffer.length + Math.max(this.dataBuffer.Position - this.dataBuffer.ColumnStart, this.columnBuffer.Buffer.length)];
                System.arraycopy(this.columnBuffer.Buffer, 0, cArr, 0, this.columnBuffer.Position);
                this.columnBuffer.Buffer = cArr;
            }
            System.arraycopy(this.dataBuffer.Buffer, this.dataBuffer.ColumnStart, this.columnBuffer.Buffer, this.columnBuffer.Position, this.dataBuffer.Position - this.dataBuffer.ColumnStart);
            this.columnBuffer.Position += this.dataBuffer.Position - this.dataBuffer.ColumnStart;
        }
        DataBuffer dataBuffer = this.dataBuffer;
        dataBuffer.ColumnStart = dataBuffer.Position + 1;
    }

    private void endRecord() throws IOException {
        this.hasReadNextLine = true;
        this.currentRecord++;
    }

    public int getIndex(String str) throws IOException {
        checkClosed();
        Object obj = this.headersHolder.IndexByName.get(str);
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return -1;
    }

    public boolean skipRecord() throws IOException {
        checkClosed();
        if (!this.hasMoreData) {
            return false;
        }
        boolean record = readRecord();
        if (record) {
            this.currentRecord--;
        }
        return record;
    }

    public boolean skipLine() throws IOException {
        boolean z;
        checkClosed();
        this.columnsCount = 0;
        if (this.hasMoreData) {
            boolean z2 = false;
            z = false;
            do {
                if (this.dataBuffer.Position == this.dataBuffer.Count) {
                    checkDataLength();
                } else {
                    char c2 = this.dataBuffer.Buffer[this.dataBuffer.Position];
                    if (c2 == '\r' || c2 == '\n') {
                        z2 = true;
                    }
                    this.lastLetter = c2;
                    if (!z2) {
                        this.dataBuffer.Position++;
                    }
                    z = true;
                }
                if (!this.hasMoreData) {
                    break;
                }
            } while (!z2);
            this.columnBuffer.Position = 0;
            DataBuffer dataBuffer = this.dataBuffer;
            dataBuffer.LineStart = dataBuffer.Position + 1;
        } else {
            z = false;
        }
        this.rawBuffer.Position = 0;
        this.rawRecord = "";
        return z;
    }

    public void close() {
        if (this.closed) {
            return;
        }
        close(true);
        this.closed = true;
    }

    private void close(boolean z) {
        if (this.closed) {
            return;
        }
        if (z) {
            this.charset = null;
            this.headersHolder.Headers = null;
            this.headersHolder.IndexByName = null;
            this.dataBuffer.Buffer = null;
            this.columnBuffer.Buffer = null;
            this.rawBuffer.Buffer = null;
        }
        try {
            if (this.initialized) {
                this.inputStream.close();
            }
        } catch (Exception unused) {
        }
        this.inputStream = null;
        this.closed = true;
    }

    private void checkClosed() throws IOException {
        if (this.closed) {
            throw new IOException("This instance of the CsvReader class has already been closed.");
        }
    }

    protected void finalize() {
        close(false);
    }

    private class ComplexEscape {
        private static final int DECIMAL = 3;
        private static final int HEX = 4;
        private static final int OCTAL = 2;
        private static final int UNICODE = 1;

        private ComplexEscape() {
        }
    }

    private class DataBuffer {
        public char[] Buffer = new char[1024];
        public int Position = 0;
        public int Count = 0;
        public int ColumnStart = 0;
        public int LineStart = 0;

        public DataBuffer() {
        }
    }

    private class ColumnBuffer {
        public char[] Buffer = new char[50];
        public int Position = 0;

        public ColumnBuffer() {
        }
    }

    private class RawRecordBuffer {
        public char[] Buffer = new char[500];
        public int Position = 0;

        public RawRecordBuffer() {
        }
    }

    private class Letters {
        public static final char ALERT = 7;
        public static final char BACKSLASH = '\\';
        public static final char BACKSPACE = '\b';
        public static final char COMMA = ',';
        public static final char CR = '\r';
        public static final char ESCAPE = 27;
        public static final char FORM_FEED = '\f';
        public static final char LF = '\n';
        public static final char NULL = 0;
        public static final char POUND = '#';
        public static final char QUOTE = '\"';
        public static final char SPACE = ' ';
        public static final char TAB = '\t';
        public static final char VERTICAL_TAB = 11;

        private Letters() {
        }
    }

    private class UserSettings {
        public char TextQualifier = '\"';
        public boolean TrimWhitespace = true;
        public boolean UseTextQualifier = true;
        public char Delimiter = Letters.COMMA;
        public char RecordDelimiter = 0;
        public char Comment = Letters.POUND;
        public boolean UseComments = false;
        public int EscapeMode = 1;
        public boolean SafetySwitch = true;
        public boolean SkipEmptyRecords = true;
        public boolean CaptureRawRecord = true;

        public UserSettings() {
        }
    }

    private class HeadersHolder {
        public String[] Headers = null;
        public int Length = 0;
        public HashMap IndexByName = new HashMap();

        public HeadersHolder() {
        }
    }

    private class StaticSettings {
        public static final int INITIAL_COLUMN_BUFFER_SIZE = 50;
        public static final int INITIAL_COLUMN_COUNT = 10;
        public static final int MAX_BUFFER_SIZE = 1024;
        public static final int MAX_FILE_BUFFER_SIZE = 4096;

        private StaticSettings() {
        }
    }
}
