package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes6.dex */
public interface TransitionFactory<R> {
    Transition<R> build(DataSource dataSource, boolean z);
}
