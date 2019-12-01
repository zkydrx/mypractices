package com.zhihei.basicknowledge.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-27
 * Time: 16:28:31
 * Description:
 * 阻塞队列版的生产者和消费者模式
 * 传接口，要有通用性，也就是适配更多的地方。
 */
class ResourceClassData
{
    /**
     * 默认开启进行生产
     * 利用volatile的可见性实现停止
     */
    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    /**
     * 传参传接口，适配性更强！
     * @param blockingQueue
     */
    public ResourceClassData(BlockingQueue<String> blockingQueue)
    {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    /**
     * 生产者生产方法
     * @throws InterruptedException
     */
    public void productProDucer() throws InterruptedException
    {
        String s = null;
        boolean returnValue;
        while (FLAG)
        {
            s = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(s, 2L, TimeUnit.SECONDS);
            if (returnValue)
            {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列成功，数据是:" + s);
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列失败，数据是:" + s);
            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产数据。，当前的状态是FLAG=" + FLAG);
    }


    /**
     * 消费者消费方法
     * @throws InterruptedException
     */
    public void myconsumer() throws InterruptedException
    {
        String poll = null;
        while (FLAG)
        {
            poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == poll || poll.equalsIgnoreCase(""))
            {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t队列为空，等待两秒钟没有取到数据，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "消费者消费队列成功,数据是：" + poll);
        }
    }

    /**
     * 停止生产方法
     */
    public void stop()
    {
        this.FLAG = false;
        System.out.println(Thread.currentThread().getName() + "\t 执行停止方法，停止生产");
    }


}

public class ProducerAndConsumerBlockQueueTest
{
    public static void main(String[] args) throws InterruptedException
    {
        ResourceClassData resourceClassData = new ResourceClassData(new LinkedBlockingQueue<>(3));

        new Thread(() -> {
            try
            {
                System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
                System.out.println();
                System.out.println();

                resourceClassData.productProDucer();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "producer").start();
        new Thread(() -> {
            try
            {
                System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
                System.out.println();
                System.out.println();
                resourceClassData.myconsumer();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "consumer").start();
        TimeUnit.SECONDS.sleep(10);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("10秒时间到，生产停止！！！");
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 停止线程启动");
            System.out.println();
            System.out.println();
            resourceClassData.stop();
        }, "stop").start();
    }
}
