/*
 * Some header text
 */

package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        int tiedIfZero = tv1.getBrand().compareTo(tv2.getBrand());
        if (tiedIfZero != 0) {
            return tv1.getBrand().compareTo((tv2.getBrand()));
        } else {
            return Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
    }
}