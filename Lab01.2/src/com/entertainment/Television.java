/*
 * To be consistent with equals (TreeSet(), for example), whatever fields we use for equals() and hashCode()
 * MUST be the same as those for natural order.
 *
 * That means we must switch to a primary sort key 'brand' and when tied on 'brand'
 * we break the tie via a secondary sort key 'volume'
 */

package com.entertainment;

import java.util.Objects;
// Natural order is defined by sort key 'brand' (String) and 'volume (int)
public class Television implements Comparable<Television> { // Private or Public or public/private (default)?

    // CLASS (static or public) variables - these are shared among all instances
    private String brand;
    private int volume;

    // PROPERTIES or ATTRIBUTES, generally called "fields" or "instance variables"
    // these live *inside each instance* and are generally private
    private Tuner tuner = new Tuner();

    // CONSTRUCTORS - special methods that get called when the client says "new"
    public Television() {
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    // BUSINESS METHODS (functions) - what operations can com.entertainment.Television objects do?
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }
    // ACCESSOR METHODS - these provide "controlled access" to the variables/properties/attributes

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    // Natural order is defined by sort key 'brand' (String). - that was the first method, TreeSet() breaks it
    // because TreeSet() uses 'equals()' instead of compareTo(), and equals() works off of a single sort key rather than 2.
    @Override
    public int compareTo(Television other) {
//        return this.getBrand().compareTo(other.getBrand());
        int result = this.getBrand().compareTo(other.getBrand());
        if (result == 0) {  // Brands are the same
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;   // Check to see if the obj being passed is the exact obj as the one doing the checking
//
//        if (obj == null || getClass() != obj.getClass()) return false;  // Check to make sure it's the same type of Class - NOT an IS-A
//        Television that = (Television) obj;
//
//        return this.getVolume() == that.getVolume() &&
//               Objects.equals(this.getBrand(), that.getBrand());
//    }

     @Override
    public int hashCode() {

//        /* This is a poorly written hash function because it easily yields "hash collisions."
//         * A hash collision is when "different" objects have the same hash code (just by coincidence).
//         * Given our poor initial hash function below,
//         * "Sony" 50 and "LG" 52 both have hash codes of 54, as does "Samsung" 47.
//         * These are "different" objects per the equals() method, but have the same hash code
//
//        return getBrand().length() + getVolume();

        // Instead we rely on Objects.hash() to give us a valid hash function
         return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {

        boolean result = false;
        // Proceed ONLY IF obj is referencing a Television object
        // if (obj instanceof Television) {    // Check to make sure Objects are of the same type, but can be IS-A
        if (obj != null && this.getClass() == obj.getClass()) {    // This makes sure that one obj isn't a subclass of another, throws out false if null
            // Downcast obj reference to more specific Person type
            Television other = (Television) obj;

            // Do the checks: (ignoring case if name is null...bad)
            // Is my name the same as the other one's name? &&
            // Is my age the same, too?
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // Null safe check
                    this.getVolume() == other.getVolume();  // Primitives cannot be null
        }
        return result;
    }

    // public String toString() {}  // For output
    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand()
                + ", volume=" + getVolume()
                + ", currentChannel=" + getCurrentChannel();    // Better to use this or tuner.getChannel() ?
    }
}