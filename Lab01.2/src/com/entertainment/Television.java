/*
 * Some header text
 */

package com.entertainment;

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

    // public String toString() {}  // For output
    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand()
                + ", volume=" + getVolume()
                + ", currentChannel=" + getCurrentChannel();    // Better to use this or tuner.getChannel() ?
    }
}