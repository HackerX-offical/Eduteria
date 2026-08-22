package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class ColorInfo implements Serializable {
    private String matrixCoefficients;
    private String primaries;
    private String transferCharacteristics;

    public String getPrimaries() {
        return this.primaries;
    }

    public void setPrimaries(String str) {
        this.primaries = str;
    }

    public String getMatrixCoefficients() {
        return this.matrixCoefficients;
    }

    public void setMatrixCoefficients(String str) {
        this.matrixCoefficients = str;
    }

    public String getTransferCharacteristics() {
        return this.transferCharacteristics;
    }

    public void setTransferCharacteristics(String str) {
        this.transferCharacteristics = str;
    }

    public String toString() {
        return "ColorInfo{primaries = '" + this.primaries + "',matrixCoefficients = '" + this.matrixCoefficients + "',transferCharacteristics = '" + this.transferCharacteristics + "'}";
    }
}
