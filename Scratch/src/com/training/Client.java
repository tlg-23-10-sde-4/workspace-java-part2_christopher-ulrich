/*
 * Some header text
 */

package com.training;

class Client {
    public static void main(String[] args) {
        // classloader loads Instructor.class which initializes that static (shared) Projector object
//        Instructor inst1 = new Instructor("Jay", 28);
//        Instructor inst2 = new Instructor("Ed", 24);
        Instructor.touch();
        Instructor.touch();

    }
    /**
     * For the CLIENT Side
     * ENTRY-POINT or starting point for a standalone Java application
     *      public static void main(String[] args) {}
     *
     * Create an instance and set its properties 
     *     NameOfClass nameOfObject1 = new NameOfClass();
     *
     * Call methods
     *     nameOfObject1.doSomething();
     *
     * show their toString() methods in action
     *      sout(nameOfObject1.toString());
     */

}