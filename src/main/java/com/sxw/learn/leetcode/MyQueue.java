package com.sxw.learn.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-22 8:28 下午
 */
public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;// 输出栈 用来翻转顺序，只要不为空，栈中的元素就是当前情况下最先入队的，为空剩下的元素翻转后栈顶的就是最先入栈的元素

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) in2out();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) in2out();
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void in2out(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
