/*
 * Some header text
 */

package com.training;

class Instructor {

    // CLASS (static or public) variables - these are shared among all instances
    // Exists even if there are no Instructor objects
    private static final Projector projector = new Projector();

    // PROPERTIES or ATTRIBUTES, generally called "fields" or "instance variables"
    // these live *inside each instance* and are generally private

    private final String name;
    private final int yearsExperience;

    // CONSTRUCTORS - special methods that get called when the client says "new"

    public Instructor(String name, int yearsExperience) {
        this.name = name;
        this.yearsExperience = yearsExperience;
        System.out.println("Instructor ctor called");
    }

    public static void touch() {
        System.out.println("Instructor's touch() method called");
    }

    // BUSINESS METHODS (functions) - what operations can com.entertainment.Television objects do?

    // ACCESSOR METHODS - these provide "controlled access" to the variables/properties/attributes

    public String getName() {
        return name;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    static {
        System.out.println("Static fields initialized, Instructor.class loaded into memory");
    }

    // public String toString() {}  // For output

}