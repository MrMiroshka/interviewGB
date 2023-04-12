package ru.miroshka.threads.z1;

public class PingPong implements Runnable{
    private final String name;
    private static final Object monitor  = new Object() ;
    public static volatile PingPong lastStepped;

    public PingPong(String name){
        this.name = name;
    }
    public void run() {
        try{
            while (true) {
                synchronized (monitor) {
                    monitor.notifyAll();
                    while (lastStepped==this) monitor.wait();
                    lastStepped=this;
                    System.out.println(name);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Error in PingPong class - " + e.getMessage());
        }
    }
}
