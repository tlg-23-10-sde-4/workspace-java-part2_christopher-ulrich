package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television();
        tv2 = new Television();
    }

    @Test
    public void hashCode_equalObjectsMustHaveSameHashCode() {
        Television tv = new Television("Sony", 51, DisplayType.OLED);
        Television tv2 = new Television("Sony", 51, DisplayType.OLED);
        assertEquals(tv.hashCode(), tv2.hashCode());
    }

    @Test   // Should do a separate one of these for each field that can be different
    public void equals_ShouldReturnFalse_whenDifferentVolume() {
        Television tv = new Television("Sony", 51, DisplayType.OLED);
        Television tv2 = new Television("Sony", 100, DisplayType.OLED);
        assertNotEquals(tv, tv2);
    }

    @Test
    public void equals_shouldReturnTrue_whenAllFieldsEqual() throws InvalidChannelException {
        tv.setBrand("Sony");
        tv.changeChannel(3);
        tv.setVolume(50);
        tv2.setBrand("Sony");
        tv2.changeChannel(3);
        tv2.setVolume(50);
        assertEquals(tv, tv2);
    }

    @Test
    public void compareTo_shouldReturnFalse_whenBrandsDifferent() {
        tv.setBrand("Sony");
        tv2.setBrand("Pioneer");
        assertNotEquals(tv.compareTo(tv2), 0);
    }

    @Test
    public void compareTo_shouldBeEqual_whenBrandsSame() {
        tv.setBrand("Sony");
        tv2.setBrand("Sony");
        assertEquals(tv.compareTo(tv2), 0);
    }

    @Test(expected = InvalidChannelException.class)   // Checked exception
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() throws InvalidChannelException{
        try {
            tv.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        }
        catch (IllegalArgumentException e) {
            String expected = "Invalid channel: 1000. Allowed range: [1,999].";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv.changeChannel(99);
        assertEquals(99, tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class) // Checked exception
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(0);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test   // Unchecked exception
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        try {
            tv.setVolume(101);  // Should trigger the exception causing the test to pass
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            // assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage()); // This is one way to do it
            String expected = "Invalid volume: 101. Allowed range: [0,100].";
            assertEquals(expected, e.getMessage()); // These two lines are another method
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1);   // Should trigger the exception causing the test to pass
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }


}