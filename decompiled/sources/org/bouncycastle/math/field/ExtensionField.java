package org.bouncycastle.math.field;

/* JADX INFO: loaded from: classes10.dex */
public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
