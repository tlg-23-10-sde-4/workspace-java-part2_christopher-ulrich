/*
 * Some header text
 */

package org.veggie;

import java.util.Comparator;

// Sort key is color (String)
// Not primitive; use object.getAttribute().compareTo(obj2.getAttribute())
class RadishColorComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish radish1, Radish radish2) {
        return radish1.getColor().compareTo(radish2.getColor());
    }
}