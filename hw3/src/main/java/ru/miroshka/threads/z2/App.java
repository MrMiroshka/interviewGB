package ru.miroshka.threads.z2;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread th1 = new Thread(() -> {
            counter.increment();
        },"inc +1 ");
        Thread th2 = new Thread(() -> {
            counter.decrement(3);
        },"dec -3 ");
        Thread th3 = new Thread(() -> {
            counter.increment(2);
        },"inc +2 ");
        Thread th4 = new Thread(() -> {
            counter.decrement();
        },"inc -1 ");

        Thread th5 = new Thread(() -> {
            counter.setValue(counter.getValue()*2);
        },"dec *2 ");

        th1.start();
        th4.start();
        th5.start();
        th3.start();
        th2.start();

        Thread.sleep(1000);
        System.out.println("Итоговое значение = " + counter.getValue());
    }
}
