package com.ideaheap.q4j;

/**
 * Created by nwertzberger on 5/18/15.
 */
public interface Promise <T> {
    <K> Promise<K> then(ThenCallback<T, K> result);
    Promise<T> then(ThenVoidCallback<T> result);
    void done();
}
