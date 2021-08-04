package edu.bit.designing.limiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class RateLimiterTest {
    @Test
    void testAcquireResourceWithNoRequestPermitted() {
        RateLimiter rateLimiter = new RateLimiter(0, TimeUnit.SECONDS);
        Assertions.assertFalse(rateLimiter.acquireResource());
    }

    @Test
    void testAcquiringResourceSuccessfully() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(3, TimeUnit.MILLISECONDS);
        Assertions.assertAll(
                () -> Assertions.assertTrue(rateLimiter.acquireResource()),
                () -> Assertions.assertTrue(rateLimiter.acquireResource()),
                () -> Assertions.assertTrue(rateLimiter.acquireResource()),
                () -> Assertions.assertFalse(rateLimiter.acquireResource())
        );
        Thread.sleep(100);
        Assertions.assertTrue(rateLimiter.acquireResource());
    }

    @Test
    void testAcquiringResourceAndStoppingToLimit() throws InterruptedException {
        int maxPermittedRequest = 2;
        RateLimiter rateLimiter = new RateLimiter(maxPermittedRequest, TimeUnit.SECONDS);
        Assertions.assertAll(
                () -> Assertions.assertTrue(rateLimiter.acquireResource()),
                () -> Assertions.assertTrue(rateLimiter.acquireResource()),
                () -> Assertions.assertFalse(rateLimiter.acquireResource())
        );
        rateLimiter.stopLimiter();
        Thread.sleep(1000);
        Assertions.assertFalse(rateLimiter.acquireResource());
    }
}