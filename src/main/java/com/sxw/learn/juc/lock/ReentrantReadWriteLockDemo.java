package com.sxw.learn.juc.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    static class ReadThread extends Thread {
        private ReentrantReadWriteLock rrwLock;

        public ReadThread(String name, ReentrantReadWriteLock rrwLock) {
            super(name);
            this.rrwLock = rrwLock;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " trying to lock");
            try {
                rrwLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " lock successfully");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rrwLock.readLock().unlock();
                System.out.println(Thread.currentThread().getName() + " unlock successfully");
            }
        }
    }

    static class WriteThread extends Thread {
        private ReentrantReadWriteLock rrwLock;

        public WriteThread(String name, ReentrantReadWriteLock rrwLock) {
            super(name);
            this.rrwLock = rrwLock;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " trying to lock");
            try {
                rrwLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " lock successfully");
            } finally {
                rrwLock.writeLock().unlock();
                System.out.println(Thread.currentThread().getName() + " unlock successfully");
            }
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();
        ReadThread rt1 = new ReadThread("rt1", rrwLock);
        ReadThread rt2 = new ReadThread("rt2", rrwLock);
        WriteThread wt1 = new WriteThread("wt1", rrwLock);
        rt1.start();
        rt2.start();
        wt1.start();
    }

}
