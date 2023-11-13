/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

    public static void main(String[] args) {
        // TODO: create two instances of your thread subclass and start them up
        MessagePrinter printer1 = new MessagePrinter(
                "Roses are red", 10, 5000);
        printer1.start();

        MessagePrinter printer2 = new MessagePrinter(
                "Violets are blue", 90, 500);
        printer2.start();

        MessagePrinter printer3 = new MessagePrinter(
                "Sugar is sweet", 160, 250);
        printer3.start();

        MessagePrinter printer4 = new MessagePrinter(
                "and so are you.", 30, 1000);
        printer4.start();
    }
}