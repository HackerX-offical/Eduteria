package org.jivesoftware.smack.fsm;

/* JADX INFO: loaded from: classes10.dex */
public abstract class StateTransitionResult {
    private final String message;

    protected StateTransitionResult(String str) {
        this.message = str;
    }

    public String toString() {
        return this.message;
    }

    public static abstract class AttemptResult extends StateTransitionResult {
        protected AttemptResult(String str) {
            super(str);
        }
    }

    public static class Success extends AttemptResult {
        public static final Success EMPTY_INSTANCE = new Success();

        private Success() {
            super("");
        }

        public Success(String str) {
            super(str);
        }
    }

    public static class Failure extends AttemptResult {
        public Failure(String str) {
            super(str);
        }
    }

    public static final class FailureCausedByException<E extends Exception> extends Failure {
        private final E exception;

        public FailureCausedByException(E e2) {
            super(e2.getMessage());
            this.exception = e2;
        }

        public E getException() {
            return this.exception;
        }
    }

    public static final class FailureCausedByTimeout extends Failure {
        public FailureCausedByTimeout(String str) {
            super(str);
        }
    }

    public static abstract class TransitionImpossible extends StateTransitionResult {
        protected TransitionImpossible(String str) {
            super(str);
        }
    }

    public static class TransitionImpossibleReason extends TransitionImpossible {
        public TransitionImpossibleReason(String str) {
            super(str);
        }
    }

    public static class TransitionImpossibleBecauseNotImplemented extends TransitionImpossibleReason {
        public TransitionImpossibleBecauseNotImplemented(StateDescriptor stateDescriptor) {
            super(stateDescriptor.getFullStateName(false) + " is not implemented (yet)");
        }
    }
}
