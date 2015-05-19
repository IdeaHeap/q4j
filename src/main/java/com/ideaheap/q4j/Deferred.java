package com.ideaheap.q4j;

/**
 * Created by nwertzberger on 5/18/15.
 */
public class Deferred<T> implements Promise<T> {
    private boolean isResolved = false;
    private T val;

    public Promise<T> promise() {
        return this;
    }

    public Deferred<T> resolve(T val) {
        if (isResolved) {
            throw new QException("Already resolved!");
        }
        synchronized (this) {
            this.val = val;
            isResolved = true;
        }
        return this;
    }

    @Override
    public <K> Promise<K> then(ThenCallback<T, K> result) {
        Promise<K> res = null;
        if (isResolved) {
            res = result.onDonePromise(val);
        }
        return res;
    }

    @Override
    public Promise<T> then(ThenVoidCallback<T> result) {
        if (isResolved) {
            result.onDone(val);
        }
        return this;
    }

    @Override
    public void done() {

    }
}
