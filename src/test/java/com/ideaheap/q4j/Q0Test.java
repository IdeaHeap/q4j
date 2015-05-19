package com.ideaheap.q4j;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 */
public class Q0Test {

    private boolean hasRun;

    @Before
    public void setUp() {
        hasRun = false;
    }

    @Test
    public void Q_canCreateDeferredObjects() {
        Deferred deferred = Q.defer();
        Promise<String> p = deferred.promise();
        deferred.resolve("hi");

        p.then((String val) -> {
            assertEquals("hi", val);
            hasRun = true;
        });

        assertTrue(hasRun);
    }

    @Test
    public void Q_canChainDeferredObjects() {
        Deferred<Integer> deferred = Q.defer();

        Promise<Integer> p = deferred.promise();
        deferred.resolve(5);

        p.then((number) -> "" + number + " cats.")
         .then((cats) -> {
             assertEquals("5 cats.", cats);
             hasRun = true;
         })
         .then((cats) -> {
             assertEquals("5 cats.", cats);
             hasRun = true;
         });
        assertTrue(hasRun);
    }
}
