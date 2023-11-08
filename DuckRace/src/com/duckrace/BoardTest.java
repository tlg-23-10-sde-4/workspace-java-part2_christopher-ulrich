/*
 * Some header text
 */

package com.duckrace;

import static com.duckrace.Reward.*;

class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();

        board.addWin(4, DEBIT_CARD);
        board.addWin(4, DEBIT_CARD);
        board.addWin(14, DEBIT_CARD);
        board.addWin(14, PRIZES);
        board.addWin(1, PRIZES);
        board.addWin(8, PRIZES);
        board.addWin(9, DEBIT_CARD);
        board.addWin(8, PRIZES);
        board.addWin(3, DEBIT_CARD);

        board.showResults();
    }

    /**
     * For the CLIENT Side
     * ENTRY-POINT or starting point for a standalone Java application
     *      public static void main(String[] args) {}
     *
     * Create an instance and set its properties 
     *     NameOfClass nameOfObject1 = new NameOfClass();
     *
     * Call methods
     *     nameOfObject1.doSomething();
     *
     * show their toString() methods in action
     *      sout(nameOfObject1.toString());
     */

}