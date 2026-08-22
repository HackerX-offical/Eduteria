package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes7.dex */
@Immutable
interface HpkeKdf {
    byte[] extractAndExpand(byte[] salt, byte[] ikm, String ikmLabel, byte[] info2, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException;

    byte[] getKdfId() throws GeneralSecurityException;

    byte[] labeledExpand(byte[] prk, byte[] info2, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException;

    byte[] labeledExtract(byte[] salt, byte[] ikm, String ikmLabel, byte[] suiteId) throws GeneralSecurityException;
}
