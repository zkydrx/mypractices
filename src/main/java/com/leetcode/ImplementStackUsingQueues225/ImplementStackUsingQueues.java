package com.leetcode.ImplementStackUsingQueues225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-26
 * Time: 22:33:45
 * Description:
 * <p>
 * 225. Implement Stack using Queues
 * <p>
 * <p>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and
 * is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty
 * stack).
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and all test cases.
 */
public class ImplementStackUsingQueues
{
        private Queue<Integer> q1 ;
        private Queue<Integer> q2 ;

        private int top;
        public ImplementStackUsingQueues()
        {
            this.q1 = new LinkedList<>();
            this.q2 = new LinkedList<>();
            this.top=0;
        }

        // remove the element on the top of the stack
        public void pop()
        {
            while (q1.size() > 1)
            {
                top = q1.remove();
                q2.add(top);
            }

            q1.remove();
            Queue<Integer> tem = q1;
            q1 = q2;
            q2 = tem;
        }

        public void push(int x)
        {
            q2.add(x);
            top = x;
            while (!q1.isEmpty())
            {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;

            q1 = q2;
            q2 = temp;

        }

        //return whether the stack is empty.
        public boolean empty()
        {
            return q1.isEmpty();
        }


        public int top()
        {
            return q1.peek();
        }


    public static void main(String[] args)
    {
        ImplementStackUsingQueues queue = new ImplementStackUsingQueues();
        queue.top=10;
    }

}
