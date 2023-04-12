package ru.miroshka.threads.z1;


public class App {
    public static void main(String[] args) throws InterruptedException {
        PingPong ping =  new PingPong("ping");
        PingPong pong =  new PingPong("pong");

        PingPong.lastStepped = pong;

        new Thread(ping).start();
        new Thread(pong).start();
    }
}
