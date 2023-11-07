package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void numberInGenre_shouldReturnCorrectResult() {
        int result = catalog.numberInGenre(MusicCategory.POP);

        assertEquals(4, result);    // But what if
    }

    @Test
    public void findSelfTitled_shouldReturnCollection_whereArtistSameAsTitle() {
        Collection<MusicItem> items = catalog.findSelfTitled();

        assertEquals(2, items.size());

        for (MusicItem item : items) {
            // assertTrue(item.getTitle().equals(item.getArtist()));    // Same same
            assertEquals(item.getArtist(), item.getTitle());
        }
    }

    @Test
    public void findByCategory_shouldReturnCollection() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);

        assertEquals(4, items.size());
        for (MusicItem item : items) {
            // assertTrue(MusicCategory.POP == item.getMusicCategory());   // ok to use == for enum
            assertSame(MusicCategory.POP, item.getMusicCategory()); // another method
            // assertEquals(MusicCategory.POP, item.getMusicCategory()); // another valid method; uses .equals
        }
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.JAZZ);

        assertEquals(0, items.size());
        // assertTrue(items.isEmpty()); // Another method
    }

    @Test
    public void findByID_shouldReturnMusicItem_idFound() {
        MusicItem item = catalog.findById(1L);
        assertNotNull(item);
        // assertEquals(1L, (long)item.getId());    // Works, but Jay doesn't like it
        assertEquals(1L, item.getId().longValue());
    }

    @Test
    public void findByID_shouldReturnNull_whenIDNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
        // assertTrue(item == null);    // Same Same
    }
}