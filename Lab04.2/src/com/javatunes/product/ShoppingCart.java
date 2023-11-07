/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* At runtime, this will really be CONCRETE TYPE
 * ShoppingCart<MusicItem>
 * ShoppingCart<MediaPlayer>,
 * ShoppingCart<Product> - this one holds both kinds of Products
 */

public class ShoppingCart<T extends Product> {  // Shopping cart of anything AS LONG AS that thing is a product
    // storage for the cart's contents - this is a classic HAS-A
    // Shopping cart HAS-A collection of Product items
    private final Collection<T> items = new ArrayList<T>();  // diamond not used here just to emphasize the T

    // This is the only method that doesn't use a super method
    // Therefore it will redline if you don't constrain <T> to extend Product, thus giving <T> the methods that come from Product
    public double total() {
        double result = 0.0;

        for (T item : items) {
            result += item.getPrice();
        }
        return result;
    }

    public Collection<T> allItems() {
        return Collections.unmodifiableCollection(items);
    }

    public int size() {
        return items.size();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }
}