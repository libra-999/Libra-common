package com.common.commonutil.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Thread {

    private static final Logger log = LoggerFactory.getLogger(Thread.class);

    public static void sleep(long milliseconds) {
        try {
            java.lang.Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }

    public static void shutdownAndAwaitTermination(ExecutorService pool) {
        if (pool != null && !pool.isShutdown()) {
            pool.shutdown();
            try { // 2mins for timeout thread
                if (!pool.awaitTermination(120, TimeUnit.SECONDS)) {
                    pool.shutdownNow();
                    if (!pool.awaitTermination(120, TimeUnit.SECONDS)) {
                        log.info("Pool did not terminate");
                    }
                }
            } catch (InterruptedException ie) {
                log.error("Interrupted while waiting for pool to terminate", ie);
                pool.shutdownNow();
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

}
