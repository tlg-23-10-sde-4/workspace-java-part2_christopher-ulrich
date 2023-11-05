package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

//import static org.jun

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // fixture: business object(s) under testing
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Amilia", Date.valueOf("2020-06-02"), 25.0, 30.0);
    }

    @Test
    public void testPay() {
        assertEquals(750.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(187.5, emp.payTaxes(), .001);
    }

}