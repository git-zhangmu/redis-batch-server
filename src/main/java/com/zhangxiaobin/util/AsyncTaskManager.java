package com.zhangxiaobin.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Component("taskManager")
public class AsyncTaskManager {

    private ExecutorService executor;

    private int count;

    public AsyncTaskManager() {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 6, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName(AsyncTaskManager.class.getName() + (++count));
                return t;
            }
        });
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void shutdown() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
    }

    public void shutdownNow() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdownNow();
        }
    }
}