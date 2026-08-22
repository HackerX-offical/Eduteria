package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class MessagesItem implements Serializable {
    private MealbarPromoRenderer mealbarPromoRenderer;

    public MealbarPromoRenderer getMealbarPromoRenderer() {
        return this.mealbarPromoRenderer;
    }

    public void setMealbarPromoRenderer(MealbarPromoRenderer mealbarPromoRenderer) {
        this.mealbarPromoRenderer = mealbarPromoRenderer;
    }

    public String toString() {
        return "MessagesItem{mealbarPromoRenderer = '" + this.mealbarPromoRenderer + "'}";
    }
}
