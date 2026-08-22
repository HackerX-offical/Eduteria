package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;

/* JADX INFO: loaded from: classes3.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    protected State.Chain mStyle;

    public ChainReference(State state, State.Helper helper2) {
        super(state, helper2);
        this.mBias = 0.5f;
        this.mStyle = State.Chain.SPREAD;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public ChainReference style(State.Chain chain) {
        this.mStyle = chain;
        return this;
    }

    public float getBias() {
        return this.mBias;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ChainReference bias(float f2) {
        this.mBias = f2;
        return this;
    }
}
