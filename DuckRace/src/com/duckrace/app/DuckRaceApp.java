/*
 * This is the controller - it controls the overall sequence of the operation,
 * it does all the user prompting, and
 */

package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceApp {
    private final Board board = board.getInstance();
    private final BoardView boardview = new BoardView(board);
    private final Scanner scanner = new Scanner(System.in);
    private final int maxId = board.maxId();


    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.addWin(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please select [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                validInput = true;
                if ("D".equals(input)) {
                    reward = Reward.DEBIT_CARD;
                }
                else {
                    reward = Reward.PRIZES;
                }
            }
        }
        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while(!validInput) {
            System.out.println("Please enter the id of the winner [1-%s]: ", ); //TODO: don't harcode the 19
            String input = scanner.nextLine().trim();  // Application will hang until the user presses ENTER. .trim() removes any hanging spaces
            if (input.matches("\\d{1,2}")) {    // After this, we are safe to Integer.parseInt()
                id = Integer.parseInt(input);
                Reward reward = ("D".equals(input)) ? Reward.DEBIT_CARD : Reward.PRIZES;
//                if (1 <= id && id <= 19) {  //TODO: don't hardcode the 19
//                    validInput = true;
//                }
//                else {
//                    System.out.println("Please enter a number between 1 - %s", );
//                }
            }
        }
        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println();
        System.out.println("- - - - - - -  - -  - - -  - - - -  - - - - - - - - - - - - - - - -");
        System.out.println("W E L C O M E  T O  T H E  D U C K  R A C E");
        System.out.println("- - - - - - -  - -  - - -  - - - -  - - - -");
        System.out.println();
        System.out.println();

        return;
    }

}