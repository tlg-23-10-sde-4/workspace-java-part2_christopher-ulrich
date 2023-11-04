/*
 * Some header text
 */

package org.veggie;

import java.util.Comparator;

// Sort key is 'guysOnTop' (int).
// Wrapper.compare for primitive types.
class RadishGuysOnTopComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish radish1, Radish radish2) {
        return Integer.compare(radish1.getGuysOnTop(), radish2.getGuysOnTop());
    }
}