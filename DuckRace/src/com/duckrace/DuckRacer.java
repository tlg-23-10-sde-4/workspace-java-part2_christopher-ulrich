/*
 * Everything here executes INSIDE OF an existing DuckRacer object
 */

package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DuckRacer {

    // CLASS (static or public) variables - these are shared among all instances
    private final int id;
    private String name;
//    private int wins; //
    private final Collection<Reward> rewards = new ArrayList<>();

    // PROPERTIES or ATTRIBUTES, generally called "fields" or "instance variables"
    // these live *inside each instance* and are generally private

    // CONSTRUCTORS - special methods that get called when the client says "new"

    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    // BUSINESS METHODS (functions) - what operations can com.entertainment.Television objects do?

    public void win(Reward reward) {
        rewards.add(reward);
    }

    // ACCESSOR METHODS - these provide "controlled access" to the variables/properties/attributes

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // derived property
    public int getWins() {
        return rewards.size();
    }

    // NOTE: Instead of returning a direct reference to the collection, we might want to return a ready-only view
    public Collection<Reward> getRewards() {
//        return rewards; // Returns a direct reference to the collection
        // return List.copyOf(rewards);    // Creates a copy of the original rewards and will only return that copy
                                        // EVEN if the original is changed; it doesn't "read through"
        return Collections.unmodifiableCollection(rewards);  // Surrounds the rewards with a bubble that cannot access
                                                                // but CAN SEE what's inside of rewards; "read through"
    }

    // public String toString() {}  // For output
    @Override
    public String toString() {
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());

    }
}