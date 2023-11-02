/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import java.util.Arrays;
import java.util.List;

import com.entertainment.Television;
import com.entertainment.TelevisionBrandChannelComparator;
import com.entertainment.TelevisionChannelComparator;

public class TelevisionTestSort {

    public static void main(String[] args) {
        // dataset for testing
        List<Television> tvList = createTelevisionList();

        dump(tvList);
        System.out.println();

        // sort by natural order and print
        // Except object Television does not have natural order
        // Passing 'null' will cause it to blow up
        System.out.println("Sorted by natural order (brand)");
        tvList.sort(null);
        dump(tvList);
        System.out.println();

//        TODO: uncomment this to test your comparator class
        // sort by supplied Comparator and print
        tvList.sort(new TelevisionChannelComparator());

         //This is one method, another method is directly under this one
//         System.out.println("Sorted by channel");
//        for (Television tv : tvList) {
//          System.out.println(tv);
//        }

        System.out.println("Sorted by channel");
        tvList.sort(new TelevisionChannelComparator());
        dump(tvList);

        System.out.println();

        System.out.println("Sorted by brand, then channel ");
        tvList.sort(new TelevisionBrandChannelComparator());
        dump(tvList);
        System.out.println();

    }

    private static void dump(List<Television> tvList) {
        for(Television television : tvList) {
            System.out.println(television); // toString() automatically called
        }
    }

    // dataset for testing
    private static List<Television> createTelevisionList() {
        Television tv1 = new Television("Zenith", 30);
        tv1.changeChannel(44);

        Television tv2 = new Television("Hitachi", 10);
        tv2.changeChannel(9);

        Television tv3 = new Television("Sony", 50);
        tv3.changeChannel(13);

        Television tv4 = new Television("RCA", 25);

        Television tv5 = new Television("Hitachi", 5);

        Television tv6 = new Television("Sony", 40);

        return Arrays.asList(tv1, tv2, tv3, tv4, tv5, tv6);
    }
}