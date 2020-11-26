package com.xmmems.common.utils;

import java.util.concurrent.*;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.11.12 16:14
 */
public class PoolExecutor{
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    //执行需要返回值的任务
    public static <V> Future<V> submit(Callable<V> callable) {
        return executorService.submit(callable);
    }

    //执行不需要返回值的任务
    public static void submit(Runnable runnable) {
        executorService.submit(runnable);
    }
}
