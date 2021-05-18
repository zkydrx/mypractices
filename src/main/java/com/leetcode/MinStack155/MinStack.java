package com.leetcode.MinStack155;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-24
 * Time: 22:11:58
 * Description:
 * 155. Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * <p>
 * <p>
 * 这道题是关于栈的题目，实现一个栈的基本功能，外加一个获得最小元素的操作。正常情况下top，pop和push操作都是常量时间的，
 * 而主要问题就在于这个getMin上面，如果遍历一遍去找最小值，那么getMin操作就是O(n)
 * 的，既然出出来了这道题就肯定不是这么简单的哈。比较容易想到就是要追溯这个最小值，在push的时候维护最小值，但是如果pop
 * 出最小值的时候该如何处理呢，如何获得第二小的值呢？如果要去寻找又不是常量时间了。解决的方案是再维护一个栈，我们称为最小栈，
 * 如果遇到更小的值则插入最小栈，
 * 否则就不需要插入最小栈（注意这里正常栈是怎么都要插进去的）。这里的正确性在于，如果后来得到的值是大于当前最小栈顶的值的，
 * 那么接下来pop都会先出去，而最小栈顶的值会一直在，而当pop到最小栈顶的值时，
 * 一起出去后接下来第二小的就在pop之后最小栈的顶端了。如此push时最多插入两个栈一个元素，是O(1)，top是取正常栈顶，
 * 自然是O(1)，而pop时也是最多抛出两个栈的栈顶元素，O(1)。最后getMin只需要peek最小栈顶栈顶即可，
 * 所以仍是O(1)，实现了所有操作的常量操作，空间复杂度是O(n)，最小栈的大小。代码如下：
 */
public class MinStack
{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack()
    {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x)
    {
        stack.add(x);
        if (minStack.isEmpty() || minStack.get(minStack.size() - 1) >= x)
        {
            minStack.add(x);
        }
    }

    public void pop()
    {
        if (stack.isEmpty())
        {
            return;
        }
        int elem = stack.remove(stack.size() - 1);
        if (!minStack.isEmpty() && elem == minStack.get(minStack.size() - 1))
        {
            minStack.remove(minStack.size() - 1);
        }
    }

    public int top()
    {
        if (!stack.isEmpty())
        {
            return stack.get(stack.size() - 1);
        }
        return 0;

    }

    public int getMin()
    {
        if (!minStack.isEmpty())
        {
            return minStack.get(minStack.size() - 1);
        }
        return 0;
    }

}
