package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap; // K: Integer, V: DuckRacer
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board {
    // Fields
    private final Map<Integer,String> studentIdMap = loadStudentIDMap();
    private final Map<Integer,DuckRacer> racerMap = new TreeMap<>();

    public int maxId() {
        return studentIdMap.size();
    }

    /*
     * Updates the board (racerMap) by making a duck racer object "win".
     * This could mean fetching an existing DuckRacer from racerMap (id is in the map)
     * Or we might need to create a new DuckRacer (id is not in the map)
     * then we need to put that new DuckRacer in the map, and make it "win"
     *
     * Either way, it needs to win.
     */

    public void addWin(int id, Reward reward) {
        DuckRacer racer;

        if (racerMap.containsKey(id)) {
            racer = racerMap.get(id);
        }
        else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
    }

    /*
     * TODO: Render the data so it shows like the board
     *
     * String builder
     * Duck Race Results
     * =================
     *
     * id   name    wins    rewards
     * --   ----    ----    -------
     * 1    Aaron   1       PRIZES
     * 2    Bullen  2       DEBIT_CARD, PRIZES
     * ETC
     *
     * System.out.printf("%s   %s   %s    %s", racer.get(id), racer.getName(), racer.getRewards());
     * Intro course session 5
     */

    public void show() {
        // title and headings
        StringBuilder display = new StringBuilder();
        display.append("\nDuck Race Results\n");
        display.append("===============\n");
        display.append("\n");

        if(racerMap.isEmpty()) {
            display.append("The board is empty");
        }
    }
    void showResults() {
        // This kinda works, but includes all the racers that haven't won yet
//        for (int i = 0; i <= 19; i++) {
//            System.out.println(racerMap.get(i) );
//    }
        // This returns only the racers that have won thus far
        Collection<DuckRacer> racers = racerMap.values();
        for (DuckRacer racer : racers) {
            System.out.println(racer);
        }
    }

    // TESTING PURPOSES ONLY
    void dumpStudentIDMap() {
        System.out.println(studentIdMap);
    }

    // Class Fields

    // Constructor
    // In the absence of defined constructors, we get the free one

    // Methods
    private Map<Integer, String> loadStudentIDMap() {
        Map<Integer,String> idMap = new HashMap<>();

        // read all lines from conf/student-ids.csv into a List<String>
        // Can throw a IOException (checked); only real way this would happen is if you typed the path wrong
        // If you throw, the redline moves up to loadStudentIDMap; surround with try/catch
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            // for each line, split it into tokens. "1,Aaron" is split into "1" and "Aaron"

            for (String line : lines) {
                String[] tokens = line.split(",");  // tokens [0] is the id, tokens[1] is the name

                // convert tokens as necessary
                // Integer.parseInt() also works
//                Integer id = Integer.valueOf(tokens[0]);
//                String name = tokens[1];
//                idMap.put(id, name);
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }
}