package com.github.mikephil.charting.formatter;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultAxisValueFormatter extends ValueFormatter {
    protected int digits;
    protected DecimalFormat mFormat;

    public DefaultAxisValueFormatter(int i) {
        this.digits = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(InstructionFileId.DOT);
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f2) {
        return this.mFormat.format(f2);
    }

    public int getDecimalDigits() {
        return this.digits;
    }
}
