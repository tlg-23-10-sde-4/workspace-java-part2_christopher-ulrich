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

        MessagePrinter printer1 = new MessagePrinter(
                "Roses are red", 10, 5000);
        Thread thd1 = new Thread(printer1, "Message-Printer-1");
        thd1.start();

        MessagePrinter printer2 = new MessagePrinter(
                "Violets are blue", 90, 500);
        Thread thd2 = new Thread(printer2, "Message-Printer-2");
        thd2.start();

        MessagePrinter printer3 = new MessagePrinter(
                "Sugar is sweet", 160, 250);
        Thread thd3 = new Thread(printer3, "Message-Printer-3");
        thd3.start();

        MessagePrinter printer4 = new MessagePrinter(
                "and so are you.", 30, 1000);
        Thread thd4 = new Thread(printer4, "Message-Printer-4");
        thd4.start();
    }
}