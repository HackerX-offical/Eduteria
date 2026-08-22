package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: Global.java */
/* JADX INFO: loaded from: classes10.dex */
class Runner implements Runnable, ContextAction {
    private Object[] args;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function f1507f;
    ContextFactory factory;
    private Script s;
    private Scriptable scope;

    Runner(Scriptable scriptable, Function function, Object[] objArr) {
        this.scope = scriptable;
        this.f1507f = function;
        this.args = objArr;
    }

    Runner(Scriptable scriptable, Script script) {
        this.scope = scriptable;
        this.s = script;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.factory.call(this);
    }

    @Override // org.mozilla.javascript.ContextAction
    public Object run(Context context) {
        Function function = this.f1507f;
        if (function != null) {
            Scriptable scriptable = this.scope;
            return function.call(context, scriptable, scriptable, this.args);
        }
        return this.s.exec(context, this.scope);
    }
}
