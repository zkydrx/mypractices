package com.hundsun.practices.dateutil;
import org.apache.commons.lang.time.StopWatch;
/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.dateutil
 * @Description: note
 * @Author: zhouky36626
 * @CreateDate: 2023-12-13 10:55:23
 * @date: 2023-12-13 10:55:23
 * @UpdateUser: zhouky36626
 * @UpdateDate: 2023-12-13 10:55:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @since 1.0
 * Copyright © 2023 Hundsun Technologies Inc. All Rights Reserved
 **/


public class TimingExample {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 步骤1
        // ...

        // 记录第一个分割点
        stopWatch.split();
        System.out.println("Step 1 Time: " + stopWatch.getSplitTime() + " milliseconds");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 步骤2
        // ...
        stopWatch.unsplit();
        // 记录第二个分割点
        stopWatch.split();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Step 2 Time: " + stopWatch.getSplitTime()+ " milliseconds");
        // 步骤3
        // ...

        // 恢复到第二个分割点之前的状态
        stopWatch.unsplit();

        // 执行额外的操作（其他处理、日志记录等）
        // ...

//        // 继续剩余的计时
//        stopWatch.start();

        // 步骤4
        // ...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();

        // 打印每个步骤的耗时
        System.out.println("Step 4 Time: " + stopWatch.getTime() + " milliseconds");

        // 打印总耗时
        System.out.println("Total Time: " + stopWatch.getTime() + " milliseconds");
    }


}

