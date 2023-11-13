/*
 * Some header text
 */

package com.javatunes.personnel;


import com.fastjava.engine.FastEngine;

class EmployeeClient {
    public static void main(String[] args) {
        // initialize the Fast engine
        FastEngine engine = new FastEngine(Employee.class); // Class engine for employee
        engine.analyzeClasses();

        // Now work with the employees as usual
        Employee emp = new Employee();
        emp.work();
        emp.pay();

    }
}