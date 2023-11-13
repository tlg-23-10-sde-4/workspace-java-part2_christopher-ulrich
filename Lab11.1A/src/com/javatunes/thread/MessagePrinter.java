/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinter extends Thread{
    private final String message;
    private  int count = 10;
    private  int sleepTime = 1000;
    private static final threadNamePrefix = "thread-message-";

    public MessagePrinter(String message) {

    }

    public MessagePrinter(String message, int count, int sleepTime) {
        this.message = message;
        this.count = count;
        this.sleepTime = sleepTime;
        setName("Message Printer");

    }

    /**
     * TODO: implement run() as follows:
     * It should loop 10 times, printing the 'message' field to stdout,
     * then pausing for some interval (in millis) that you choose.
     * <p>
     * Use a try/catch to call Thread.sleep(interval) for the pause.
     * The sleep() method throws InterruptedException, which you need to catch.
     * You can either leave the catch block empty, or print the exception to stdout.
     */
    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(getName() + ": " + message);
         try {
             Thread.sleep(sleepTime);
         }
         catch (InterruptedException e) {

         }
        }

    }
}