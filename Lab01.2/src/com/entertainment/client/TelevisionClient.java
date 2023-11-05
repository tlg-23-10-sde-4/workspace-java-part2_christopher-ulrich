/*
 * Some header text
 */

package com.entertainment.client;

import com.entertainment.Television;

import java.util.Set;
import java.util.TreeSet;

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
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        System.out.println("tvA == tvB: " + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));
        System.out.println();

//        System.out.println(tvA.hashCode());
//        System.out.println(tvB.hashCode());
//        System.out.println();

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);   // Should be rejected as a duplicate
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the set is: " + tvs.size());
        for (Television tv : tvs) {
            System.out.println(tv);
        }
    }
}