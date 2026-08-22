package com.github.kotvertolet.youtubejextractor.exception;

/* JADX INFO: loaded from: classes7.dex */
public class ExtractionException extends Exception {
    private static final String ERROR_MESSAGE = "Extraction failed. Please, report here: https://github.com/kotvertolet/youtube-jextractor/issues. Error details: ";

    public ExtractionException(String str) {
        super(ERROR_MESSAGE + str);
    }

    public ExtractionException(String str, Throwable th) {
        super(ERROR_MESSAGE + str, th);
    }

    public ExtractionException(Throwable th) {
        super(th);
    }
}
