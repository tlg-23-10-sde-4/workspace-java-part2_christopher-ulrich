/*
 * Some header text
 */

package org.veggie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red", 2.1, 1.0, 0));
        radishes.add(new Radish("black", 1.0, 0.0, 3));
        radishes.add(new Radish("red", 2.5, 4.2, 0));
        radishes.add(new Radish("pink", 0.7, 3.2, 2));

        // Original order
        dump(radishes);
        System.out.println();

        // Natural order
        System.out.println("natural order (size)");
        radishes.sort(null); // Passing null implements natural order sorting
        dump(radishes);
        System.out.println();

        System.out.println("color via anonymous class");
        //radishes.sort(new RadishColorComparator());   // edited out to allow for anonymous class
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return r1.getColor().compareTo(r2.getColor());
            }
        });
        dump(radishes);
        System.out.println();

        System.out.println("guysOnTop via the comparator");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);
        System.out.println();

        System.out.println("sort by tailLength, via anonymous Class");  // Giterdun
        radishes.sort(new Comparator<Radish>() {    // anonymous class passing an instance of an unnamed class
            // instead of writing a new class definition

            @Override
            public int compare(Radish r1, Radish r2) {
                return Double.compare(r1.getTailLength(), r2.getTailLength());
            }
        });
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radishes) {
        for(Radish radish : radishes) {
            System.out.println(radish); // toString() automatically called
        }
    }
}