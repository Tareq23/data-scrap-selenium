package com.thread.multitasking;

public class WaitNotifyExample {
    private static final Object lock = new Object();
    private static boolean isReady = false;

    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                while (!isReady) {
                    try {
                        System.out.println("Waiting for notification...");
                        lock.wait(); // Wait until notified
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Got the notification!");
            }
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000); // Simulate some task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isReady = true; // Change the condition
                lock.notify(); // Notify waiting thread
                System.out.println("Notification sent.");
            }
        });

        waitingThread.start();
        notifyingThread.start();
    }
}
