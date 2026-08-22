package com.hbb20;

/* JADX INFO: compiled from: CCPTalkBackTextProvider.java */
/* JADX INFO: loaded from: classes9.dex */
class InternalTalkBackTextProvider implements CCPTalkBackTextProvider {
    InternalTalkBackTextProvider() {
    }

    @Override // com.hbb20.CCPTalkBackTextProvider
    public String getTalkBackTextForCountry(CCPCountry country) {
        if (country == null) {
            return null;
        }
        return country.name + " phone code is +" + country.phoneCode;
    }
}
