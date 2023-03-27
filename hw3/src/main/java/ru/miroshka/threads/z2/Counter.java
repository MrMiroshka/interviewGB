package ru.miroshka.threads.z2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock lock = new ReentrantLock();
    private int value;

    public int getValue() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " -(получаем значение) value = " + value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void setValue(int value) {

        lock.lock();
        try {
            this.value = value;
            System.out.println(Thread.currentThread().getName() + " - value = " + value);
        } finally {
            lock.unlock();
        }

    }

    int increment() {
        lock.lock();
        try {
            ++value;
            System.out.println(Thread.currentThread().getName() + " - value = " + value);
            return value;
        } finally {
            lock.unlock();
        }
    }


    int decrement() {
        lock.lock();
        try {
            --value;
            System.out.println(Thread.currentThread().getName() + " - value = " + value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    int increment(int i) {
        lock.lock();
        try {
            value = value + i;
            System.out.println(Thread.currentThread().getName() + " - value = " + value);
            return value;
        } finally {
            lock.unlock();
        }
    }


    int decrement(int i) {
        lock.lock();
        try {
            value = value - i;
            System.out.println(Thread.currentThread().getName() + " - value = " + value);
            return value;
        } finally {
            lock.unlock();
        }
    }
}
