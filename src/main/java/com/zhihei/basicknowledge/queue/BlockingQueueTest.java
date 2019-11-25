package com.zhihei.basicknowledge.queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-23
 * Time: 23:09:21
 * Description:
 * ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按FIFO(先进先出)原则对元素进行排序
 * LinkedBlockingQUeue:一个基于链表结构的阻塞队列，此队列按FIFO(先进先出)排序元素，吞吐量通常要高于ArrayBlockingQueue
 * SynchronousQueue:一个不存储元素的阻塞队列。每次插入数据必须要等到另外一个线程调用移除操作，否则插入操作一直处于阻塞状态
 * 1.队列
 * 2.阻塞队列
 * 2.1阻塞队列有没有好的一面
 * 2.2.如果不得不阻塞，应该如何处理？
 */
public class BlockingQueueTest
{
    /**
     * 越界报异常
     */
    @Test
    public void testAddRemoveElement()
    {
        BlockingQueue<String> blockingQueue= new ArrayBlockingQueue<>(2);
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("2"));
        /**
         * 返回队列头的元素，若头元素不存在则抛异常
         * java.util.NoSuchElementException
         */
        System.out.println(blockingQueue.element());

        /**
         * 当队列满时再往队列里加新元素则会跑出异常
         *  java.lang.IllegalStateException: Queue full
         */
        // System.out.println(blockingQueue.add("3"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        /**
         * 当删除的元素超过队列长度时，将报异常：
         * java.util.NoSuchElementException
         */
        // System.out.println(blockingQueue.remove());

    }

    /**
     * 越界给出特殊值，
     * offer->false
     * poll->null
     * peek->null
     */
    @Test
    public void testOfferPollPeek()
    {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("x"));
        System.out.println(blockingQueue.offer("y"));
        System.out.println(blockingQueue.offer("z"));
        /**
         * 超出队列长度返回false
         */
        System.out.println(blockingQueue.offer("!"));
        /**
         * 返回队首元素，若为空返回null
         */
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        /**
         * 超出队列长度以后返回null
         */
        System.out.println(blockingQueue.poll());


    }

    /**
     * 阻塞
     */
    @Test
    public void testPutTake()
    {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        try
        {
            blockingQueue.put("a");
            blockingQueue.put("b");
            blockingQueue.put("c");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            /**
             * 如果放不下将一直阻塞
             */
            // blockingQueue.put("d");
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            /**
             * 取不到也将一直阻塞
             */
            // System.out.println(blockingQueue.take());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 超时退出
     */
    @Test
    public void testOutOfTime() throws InterruptedException
    {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a", 3, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 3, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 3, TimeUnit.SECONDS));
        /**
         * 超过设定的容量后，将会阻塞设定的时间，超过设定的时间，将自动退出
         */
        System.out.println(blockingQueue.offer("d", 3, TimeUnit.SECONDS));
    }


    /**
     * SynchronousQueue没有容量
     * 每一个put操作必须要等待以个take操作，否则不能继续添加元素，但是不阻塞
     * @throws InterruptedException
     */
    @Test
    public void testSynchronousQueue() throws InterruptedException
    {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try
            {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                blockingQueue.put("3");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        },"A").start();


        new Thread(()->{
            try
            {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t take"+blockingQueue.take());
                // TimeUnit.SECONDS.sleep(5);
                // System.out.println(Thread.currentThread().getName()+"\t take"+blockingQueue.take());
                // TimeUnit.SECONDS.sleep(5);
                // System.out.println(Thread.currentThread().getName()+"\t take"+blockingQueue.take());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        },"B").start();
        TimeUnit.SECONDS.sleep(20);

    }
}
