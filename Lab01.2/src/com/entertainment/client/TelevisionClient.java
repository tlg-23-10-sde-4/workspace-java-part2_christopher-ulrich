/*
 * Some header text
 */

package com.entertainment.client;

import com.entertainment.Television;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television("Samsung", 12);

        System.out.println(tv1);
        System.out.println(tv2);

        tv2.changeChannel(42);  // toString() automatically called
        System.out.println(tv2);
        System.out.println();   // Blank line

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        System.out.println("tvA == tvB: " + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));
    }

    /**
     * For the CLIENT Side
     * ENTRY-POINT or starting point for a standalone Java application
     *      public static void main(String[] args) {}
     *
     * Create an instance and set its properties 
     *     NameOfClass nameOfObject1 = new NameOfClass();
     *
     * Call methods
     *     nameOfObject1.doSomething();
     *
     * show their toString() methods in action
     *      sout(nameOfObject1.toString());
     */

}