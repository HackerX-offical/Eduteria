package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: loaded from: classes6.dex */
public final class QuizQuestionControlBinding implements ViewBinding {
    public final ImageView attemptedIV;
    public final RecyclerView controllerRV;
    public final DrawerLayout drawerLayout;
    public final LinearLayout lowerFooter;
    public final NavigationView navView2;
    public final ImageView notattemptedIV;
    private final DrawerLayout rootView;

    private QuizQuestionControlBinding(DrawerLayout rootView, ImageView attemptedIV, RecyclerView controllerRV, DrawerLayout drawerLayout, LinearLayout lowerFooter, NavigationView navView2, ImageView notattemptedIV) {
        this.rootView = rootView;
        this.attemptedIV = attemptedIV;
        this.controllerRV = controllerRV;
        this.drawerLayout = drawerLayout;
        this.lowerFooter = lowerFooter;
        this.navView2 = navView2;
        this.notattemptedIV = notattemptedIV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static QuizQuestionControlBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static QuizQuestionControlBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.quiz_question_control, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static QuizQuestionControlBinding bind(View rootView) {
        int i = R.id.attemptedIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.attemptedIV);
        if (imageView != null) {
            i = R.id.controllerRV;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.controllerRV);
            if (recyclerView != null) {
                DrawerLayout drawerLayout = (DrawerLayout) rootView;
                i = R.id.lowerFooter;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lowerFooter);
                if (linearLayout != null) {
                    i = R.id.nav_view2;
                    NavigationView navigationView = (NavigationView) ViewBindings.findChildViewById(rootView, R.id.nav_view2);
                    if (navigationView != null) {
                        i = R.id.notattemptedIV;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notattemptedIV);
                        if (imageView2 != null) {
                            return new QuizQuestionControlBinding(drawerLayout, imageView, recyclerView, drawerLayout, linearLayout, navigationView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
