package edu.bit.designing.limiter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    // can consider using a Map<String, Resource> mapping for limiting
    // each resource with the logic of acquire and released moved to a common class
    private final int maxPermittedRequests;
    private final TimeUnit timeUnit;
    private final Semaphore semaphore;
    private ScheduledExecutorService scheduledExecutorService;

    public RateLimiter(int maxPermittedRequests, TimeUnit timeUnit) {
        this.maxPermittedRequests = maxPermittedRequests;
        this.timeUnit = timeUnit;
        this.semaphore = new Semaphore(maxPermittedRequests);
        this.scheduleReleasedLocks();
    }

    public boolean acquireResource() {
        return semaphore.tryAcquire();
    }

    private void scheduleReleasedLocks() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable scheduledCommand = () -> semaphore.release(maxPermittedRequests - semaphore.availablePermits());
        scheduledExecutorService.schedule(scheduledCommand, 1, timeUnit);
    }

    public void stopLimiter() {
        scheduledExecutorService.shutdownNow();
    }
}