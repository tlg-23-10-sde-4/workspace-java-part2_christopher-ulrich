/*
 * Some header text
 */

package com.fastjava.engine;

import com.fastjava.annotation.Fast;

class FastEngine {

    public void analyzeClasses() {
        for (Class<?> klass : classes) {
            Fast fastAnnotation = klass.getAnnotation(Fast.class);
            System.out.println("\n- - - - - - -F A S T ");
        }
    }

    private void reportClassLevel(Class<?> klass, Fast fastAnnotation) {
        System.out.println("The F@st has been declared on class " + klass.getName());

        double boostFactor
    }
}