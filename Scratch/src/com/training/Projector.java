/*
 * Some header text
 */

package com.training;

class Projector { // Private or Public or public/private (default)?

    // CLASS (static or public) variables - these are shared among all instances

    // PROPERTIES or ATTRIBUTES, generally called "fields" or "instance variables"
    // these live *inside each instance* and are generally private

    // CONSTRUCTORS - special methods that get called when the client says "new"

    // BUSINESS METHODS (functions) - what operations can com.entertainment.Television objects do?
    public Projector() {
        System.out.println("Projector ctor called");
    }

    // This executes when the ClassLoader loads Projector.class into memory
    static {    // Static initializer block
        System.out.println("Projector.class loaded into memory");
    }

    // ACCESSOR METHODS - these provide "controlled access" to the variables/properties/attributes

    // public String toString() {}  // For output


}