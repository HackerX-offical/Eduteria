package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes9.dex */
final class TextEncoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 2;
    }

    TextEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int encodeChar(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) (c2 - ','));
            return 1;
        }
        if (c2 >= 'a' && c2 <= 'z') {
            sb.append((char) (c2 - 'S'));
            return 1;
        }
        if (c2 < ' ') {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        }
        if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        }
        if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) (c2 - '+'));
            return 2;
        }
        if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) (c2 - 'E'));
            return 2;
        }
        if (c2 == '`') {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) (c2 - '@'));
            return 2;
        }
        if (c2 >= '{' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return encodeChar((char) (c2 - 128), sb) + 2;
    }
}
