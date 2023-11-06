/*
 * Hides the enum behind an interface, preventing the client from prematurely instantiating the Singleton
 * Makes this a 'lazy' singleton
 */

package gov.irs;

import java.util.ArrayList;
import java.util.Collection;

/*public*/ enum IRSEnum implements IRS {
    INSTANCE;

    // BUSINESS CODE

    // Field
    private Collection<TaxPayer> payers = new ArrayList<>();


    // Methods
    public void collectTaxes() {
        for (TaxPayer payer : payers) {
            payer.payTaxes();
        }
    }

    public void register(TaxPayer payer) {
        payers.add(payer);
    }


    // constructor - just so we can see when INSTANCE is created
//    IRSEnum() { // 'private' is redundant for enum constructors
//        System.out.println("--IRSEnum ctor: the instance has been created");
//    }

    // not needed - just makes the enum look more like a regular singleton
//    public static IRSEnum getInstance() {
//        return INSTANCE;
//    }

    // static initializer block - just so we can see when IRSEnum.class is loaded
    // a class load triggers creation of ALL of an enum's instances (only one in this case - INSTANCE)
    // Every enum gets .values() and .valueOf() methods; you cannot prevent this
    // If the client calls .values() or .valueOf() then the classloader fires off and instance is created
//    static {
//        System.out.println("--IRSEnum class loaded");
//    }

//    // superfluous static method that shouldn't be here
//    // if it gets called, IRSEnum.class is loaded and INSTANCE is created (prematurely)
//    // Making the singleton not lazy
//    public static void touch() {
//        // no-op
//    }
}