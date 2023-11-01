/*
 * Some header text
 */

package com.entertainment;

import java.util.Objects;

public class Television { // Private or Public or public/private (default)?

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

    @Override
    public int hashCode() {
        /* This is a poorly written hash function because it easily yields "hash collisions."
         * A hash collision is when "different" objects have the same hash code (just by coincidence).
         */
        // return getBrand().length() + getVolume();

        // Instead we rely on Objects.hash() to give us a valid hash function
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        // Proceed ONLY IF obj is referencing a Television object
        if (obj instanceof Television) {
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