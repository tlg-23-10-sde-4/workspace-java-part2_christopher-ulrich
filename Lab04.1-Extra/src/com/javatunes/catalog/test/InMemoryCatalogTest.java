/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

import static com.javatunes.catalog.MusicCategory.POP;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {

        // FINISHED
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        // testSize();
        // testGetAll();

        // FINISHED TASK method tests
        // testFindSelfTitled();
        testFindByKeyword();

        // PARTIALLY FINISHED

        // TASK method tests
        // testFindCheapRock();
        // testNumberInGenre();
        // testFindCheapestByGenre();
        // testHasGenre();
    }

/*    private static void testHasGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        boolean hasBlues = catalog.hasGenre(MusicCategory.BLUES);
        System.out.println(hasBlues);

        boolean hasJazz = catalog.
    }*/

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.size());
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicItem found = catalog.findById(9L);
        System.out.println(found);
        MusicItem notFound = catalog.findById(20L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> anything = catalog.findByKeyword("the");
        dump(anything);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.CLASSIC_ROCK);
        dump(popItems);
        // System.out.println(popItems);   // toString() automatically called; terrible to read. Make a for-each or a private method called 'dump'
    }

    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }

    public static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.getAll());
        //allItems.clear();   // Correct behavior is that this should throw a collection
    }

    private static void testFindSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> selfTitled = catalog.findSelfTitled();
        dump(selfTitled);
    }
}