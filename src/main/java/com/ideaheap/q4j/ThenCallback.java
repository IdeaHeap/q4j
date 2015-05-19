package com.ideaheap.q4j;

/**
 * Created by nwertzberger on 5/18/15.
 */
public interface ThenCallback<T, K> {
    K onDone(T val);

    default <K> Promise<K> onDonePromise(T val) {
        return Q.defer().resolve(onDone(val)).promise();
    }
}
