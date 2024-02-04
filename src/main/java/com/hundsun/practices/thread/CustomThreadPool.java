package com.hundsun.practices.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.thread
 * @Description: note
 * @Author: zhouky36626
 * @CreateDate: 2024-02-01 16:11:10
 * @date: 2024-02-01 16:11:10
 * @UpdateUser: zhouky36626
 * @UpdateDate: 2024-02-01 16:11:10
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @since 1.0
 * Copyright © 2023 Hundsun Technologies Inc. All Rights Reserved
 **/


public class CustomThreadPool {
    private final int poolSize;
    private final WorkerThread[] workers;
    private final BlockingQueue<Runnable> taskQueue;

    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        taskQueue = new LinkedBlockingQueue<>();
        workers = new WorkerThread[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private class WorkerThread extends Thread {
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        CustomThreadPool threadPool = new CustomThreadPool(3);

        // 提交任务
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            threadPool.submit(() -> {
                System.out.println("Task " + taskNumber + " is running.threadId="+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // 模拟任务执行
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }


        /**
         * 双重校验，线程更安全
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executorService.execute(() -> {
                System.out.println("Executors-Task " + taskNumber + " is running. threadId="+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
}


