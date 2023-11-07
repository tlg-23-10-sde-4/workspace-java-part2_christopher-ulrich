/*
 * Some header text
 */

package com.duckrace;

import java.util.Collection;

class DuckRacerTest {

    public static void main(String[] args) {
        DuckRacer racer1 = new DuckRacer(1, "Aaron");  // DuckRacer racer = new DuckRacer(14, "Scott");
        DuckRacer racer14 = new DuckRacer(14, "Scott");

        System.out.println(racer14);

        // make it win a couple of times
        racer14.win(Reward.PRIZES);
        racer14.win(Reward.DEBIT_CARD);
        racer14.win(Reward.PRIZES);
        racer14.win(Reward.PRIZES);
        System.out.println(racer14);

        // We can "cheat" here and get more rewards without calling win()
//        Collection<Reward> rewards = racer14.getRewards();  // Creates a path to the referenced Collection
//        rewards.add(Reward.DEBIT_CARD); // Allowing the Client to modify the Collection without win()
//        rewards.add(Reward.DEBIT_CARD); // How to fix?
//        rewards.add(Reward.PRIZES);
//        System.out.println(racer14);

        // to show the read-only view to the underlying collection
        Collection<Reward> rewards = racer14.getRewards();
        System.out.println(rewards);    // Should see 4


        racer14.win(Reward.DEBIT_CARD);
        racer14.win(Reward.DEBIT_CARD);

        System.out.println(rewards);
        System.out.println(racer14);
    }

}