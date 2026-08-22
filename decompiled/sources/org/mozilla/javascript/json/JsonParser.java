package org.mozilla.javascript.json;

import java.util.ArrayList;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: loaded from: classes10.dex */
public class JsonParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Context cx;
    private int length;
    private int pos;
    private Scriptable scope;
    private String src;

    private int fromHex(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return c2 - '7';
        }
        if (c2 < 'a' || c2 > 'f') {
            return -1;
        }
        return c2 - 'W';
    }

    public JsonParser(Context context, Scriptable scriptable) {
        this.cx = context;
        this.scope = scriptable;
    }

    public synchronized Object parseValue(String str) throws ParseException {
        Object value;
        try {
            if (str == null) {
                throw new ParseException("Input string may not be null");
            }
            this.pos = 0;
            this.length = str.length();
            this.src = str;
            value = readValue();
            consumeWhitespace();
            if (this.pos < this.length) {
                throw new ParseException("Expected end of stream at char " + this.pos);
            }
        } catch (Throwable th) {
            throw th;
        }
        return value;
    }

    private Object readValue() throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i < this.length) {
            String str = this.src;
            this.pos = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                return readString();
            }
            if (cCharAt != '-') {
                if (cCharAt == '[') {
                    return readArray();
                }
                if (cCharAt == 'f') {
                    return readFalse();
                }
                if (cCharAt == 'n') {
                    return readNull();
                }
                if (cCharAt == 't') {
                    return readTrue();
                }
                if (cCharAt == '{') {
                    return readObject();
                }
                switch (cCharAt) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        break;
                    default:
                        throw new ParseException("Unexpected token: " + cCharAt);
                }
            }
            return readNumber(cCharAt);
        }
        throw new ParseException("Empty JSON string");
    }

    private Object readObject() throws ParseException {
        consumeWhitespace();
        Scriptable scriptableNewObject = this.cx.newObject(this.scope);
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == '}') {
            this.pos++;
            return scriptableNewObject;
        }
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 < this.length) {
                String str = this.src;
                this.pos = i2 + 1;
                char cCharAt = str.charAt(i2);
                if (cCharAt != '\"') {
                    if (cCharAt != ',') {
                        if (cCharAt != '}') {
                            throw new ParseException("Unexpected token in object literal");
                        }
                        if (z) {
                            return scriptableNewObject;
                        }
                        throw new ParseException("Unexpected comma in object literal");
                    }
                    if (!z) {
                        throw new ParseException("Unexpected comma in object literal");
                    }
                    z = false;
                } else {
                    if (z) {
                        throw new ParseException("Missing comma in object literal");
                    }
                    String string = readString();
                    consume(':');
                    Object value = readValue();
                    long jIndexFromString = ScriptRuntime.indexFromString(string);
                    if (jIndexFromString < 0) {
                        scriptableNewObject.put(string, scriptableNewObject, value);
                    } else {
                        scriptableNewObject.put((int) jIndexFromString, scriptableNewObject, value);
                    }
                    z = true;
                }
                consumeWhitespace();
            } else {
                throw new ParseException("Unterminated object literal");
            }
        }
    }

    private Object readArray() throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == ']') {
            this.pos++;
            return this.cx.newArray(this.scope, 0);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 < this.length) {
                char cCharAt = this.src.charAt(i2);
                if (cCharAt != ',') {
                    if (cCharAt == ']') {
                        if (!z) {
                            throw new ParseException("Unexpected comma in array literal");
                        }
                        this.pos++;
                        return this.cx.newArray(this.scope, arrayList.toArray());
                    }
                    if (z) {
                        throw new ParseException("Missing comma in array literal");
                    }
                    arrayList.add(readValue());
                    z = true;
                } else {
                    if (!z) {
                        throw new ParseException("Unexpected comma in array literal");
                    }
                    this.pos++;
                    z = false;
                }
                consumeWhitespace();
            } else {
                throw new ParseException("Unterminated array literal");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0037, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String readString() throws org.mozilla.javascript.json.JsonParser.ParseException {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.json.JsonParser.readString():java.lang.String");
    }

    private Number readNumber(char c2) throws ParseException {
        char cCharAt;
        int i = this.pos - 1;
        if (c2 == '-' && ((c2 = nextOrNumberError(i)) < '0' || c2 > '9')) {
            throw numberError(i, this.pos);
        }
        if (c2 != '0') {
            readDigits();
        }
        int i2 = this.pos;
        if (i2 < this.length && this.src.charAt(i2) == '.') {
            this.pos++;
            char cNextOrNumberError = nextOrNumberError(i);
            if (cNextOrNumberError < '0' || cNextOrNumberError > '9') {
                throw numberError(i, this.pos);
            }
            readDigits();
        }
        int i3 = this.pos;
        if (i3 < this.length && ((cCharAt = this.src.charAt(i3)) == 'e' || cCharAt == 'E')) {
            this.pos++;
            char cNextOrNumberError2 = nextOrNumberError(i);
            if (cNextOrNumberError2 == '-' || cNextOrNumberError2 == '+') {
                cNextOrNumberError2 = nextOrNumberError(i);
            }
            if (cNextOrNumberError2 < '0' || cNextOrNumberError2 > '9') {
                throw numberError(i, this.pos);
            }
            readDigits();
        }
        double d2 = Double.parseDouble(this.src.substring(i, this.pos));
        int i4 = (int) d2;
        if (i4 == d2) {
            return Integer.valueOf(i4);
        }
        return Double.valueOf(d2);
    }

    private ParseException numberError(int i, int i2) {
        return new ParseException("Unsupported number format: " + this.src.substring(i, i2));
    }

    private char nextOrNumberError(int i) throws ParseException {
        int i2 = this.pos;
        int i3 = this.length;
        if (i2 >= i3) {
            throw numberError(i, i3);
        }
        String str = this.src;
        this.pos = i2 + 1;
        return str.charAt(i2);
    }

    private void readDigits() {
        char cCharAt;
        while (true) {
            int i = this.pos;
            if (i >= this.length || (cCharAt = this.src.charAt(i)) < '0' || cCharAt > '9') {
                return;
            } else {
                this.pos++;
            }
        }
    }

    private Boolean readTrue() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 3 || this.src.charAt(i2) != 'r' || this.src.charAt(this.pos + 1) != 'u' || this.src.charAt(this.pos + 2) != 'e') {
            throw new ParseException("Unexpected token: t");
        }
        this.pos += 3;
        return Boolean.TRUE;
    }

    private Boolean readFalse() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 4 || this.src.charAt(i2) != 'a' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 's' || this.src.charAt(this.pos + 3) != 'e') {
            throw new ParseException("Unexpected token: f");
        }
        this.pos += 4;
        return Boolean.FALSE;
    }

    private Object readNull() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 3 || this.src.charAt(i2) != 'u' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 'l') {
            throw new ParseException("Unexpected token: n");
        }
        this.pos += 3;
        return null;
    }

    private void consumeWhitespace() {
        while (true) {
            int i = this.pos;
            if (i >= this.length) {
                return;
            }
            char cCharAt = this.src.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                return;
            } else {
                this.pos++;
            }
        }
    }

    private void consume(char c2) throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i >= this.length) {
            throw new ParseException("Expected " + c2 + " but reached end of stream");
        }
        String str = this.src;
        this.pos = i + 1;
        char cCharAt = str.charAt(i);
        if (cCharAt != c2) {
            throw new ParseException("Expected " + c2 + " found " + cCharAt);
        }
    }

    public static class ParseException extends Exception {
        static final long serialVersionUID = 4804542791749920772L;

        ParseException(String str) {
            super(str);
        }

        ParseException(Exception exc) {
            super(exc);
        }
    }
}
