/*
 * Some header text
 */

package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {
/*        Television tv1 = new Television();
        Television tv2 = new Television("Samsung", 12);

        System.out.println(tv1);
        System.out.println(tv2);

        tv2.changeChannel(42);  // toString() automatically called
        System.out.println(tv2);
        System.out.println();   // Blank line*/

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        System.out.println("tvA == tvB: " + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));
        System.out.println();

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());
        System.out.println();

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);   // Should be rejected as a duplicate
        System.out.println("The size of the set is: " + tvs.size());
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