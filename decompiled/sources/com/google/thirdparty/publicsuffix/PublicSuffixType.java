package com.google.thirdparty.publicsuffix;

import com.csvreader.CsvReader;

/* JADX INFO: loaded from: classes9.dex */
public enum PublicSuffixType {
    PRIVATE(':', CsvReader.Letters.COMMA),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char innerNodeCode, char leafNodeCode) {
        this.innerNodeCode = innerNodeCode;
        this.leafNodeCode = leafNodeCode;
    }

    char getLeafNodeCode() {
        return this.leafNodeCode;
    }

    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    static PublicSuffixType fromCode(char code) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == code || publicSuffixType.getLeafNodeCode() == code) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + code);
    }
}
