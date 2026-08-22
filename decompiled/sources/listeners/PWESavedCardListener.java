package listeners;

import datamodels.CardDataModel;

/* JADX INFO: loaded from: classes10.dex */
public interface PWESavedCardListener {
    void deleteCard(CardDataModel cardDataModel, int i);

    boolean getDefaultCardSelectionFlag();

    void selectCard(CardDataModel cardDataModel, int i);

    void updateCVV(CardDataModel cardDataModel, int i);

    void updateDefaultCardSelectionFlag(boolean z);
}
