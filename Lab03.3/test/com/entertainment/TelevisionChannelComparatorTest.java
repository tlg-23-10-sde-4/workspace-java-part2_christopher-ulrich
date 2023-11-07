package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television("Sony", 50, DisplayType.OLED);
        tv2 = new Television("Sony", 50, DisplayType.OLED);
    }

    @Test
    public void compare_shouldReturnFalse_whenChannelsAreDifferent() throws InvalidChannelException {
        tv.changeChannel(3);
        tv2.changeChannel(4);
        assertNotEquals(tv.getCurrentChannel(), tv2.getCurrentChannel());
    }

    @Test
    public void compare_shouldReturnTrue_whenChannelsAreSame() throws InvalidChannelException{
        tv.changeChannel(3);
        tv2.changeChannel(3);
        assertEquals(tv.getCurrentChannel(), tv2.getCurrentChannel());
    }
}