package com.arthmetic.own.queue;

import java.util.Scanner;

/**
 * 解决ArrayQueue不能重复使用的问题。
 **/
public class CircleArrayTest
{
    public static void main(String[] args)
    {
        CircleArray circleArray = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop)
        {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            /**
             * 接收一个字符
             */
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    try
                    {
                        System.out.println("请输入一个数字:");
                        circleArray.addQueue(scanner.nextInt());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try
                    {
                        System.out.println("取出的数字是：" + circleArray.getQueue());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try
                    {
                        System.out.println("头节点的数字是：" + circleArray.showHead());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class CircleArray
{
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头部
     * 初始值为0，指向队列的第一个位置。
     */
    private int head;
    /**
     * 队列尾部
     * 初始值为0，指向队列最后一个位置的后一个位置。（所以队列中最大能放的元素个数为maxsize-1个）
     */
    private int rear;
    /**
     * 数组
     */
    private int[] circleQueue;

    /**
     * 构造器
     *
     * @param maxSize
     */
    public CircleArray(int maxSize)
    {
        this.maxSize = maxSize;
        circleQueue = new int[maxSize];
    }

    /**
     * 添加到队列
     */
    public void addQueue(int n)
    {
        if (isFull())
        {
            throw new RuntimeException("队列满，无法添加");
        }
        circleQueue[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    private boolean isFull()
    {
        return (rear + 1) % maxSize == head;
    }

    /**
     * 从队列取元素
     */
    public int getQueue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列不能为空");
        }
        /**
         * 1.先把头结点的数据取出来保存到临时变量
         * 2.把头结点向后移动一位
         * 3.返回刚才的临时变量。
         */
        int temp = circleQueue[head];
        head = (head + 1) % maxSize;
        return temp;
    }

    private boolean isEmpty()
    {
        return head == rear;
    }

    /**
     * 显示队列元素
     */
    public void showQueue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列为空");
        }
        for (int i = head; i < head + size(); i++)
        {
            System.out.printf("queue[%d]=%d\n", i % maxSize, circleQueue[i % maxSize]);
        }
    }


    /**
     * 求出当前队列环形队列的有效数据的个数
     *
     * @return
     */
    private int size()
    {
        return (rear + maxSize - head) % maxSize;
    }

    /**
     * 显示队列头的数据
     *
     * @return
     */
    public int showHead()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列为空");
        }
        return circleQueue[head];
    }

}