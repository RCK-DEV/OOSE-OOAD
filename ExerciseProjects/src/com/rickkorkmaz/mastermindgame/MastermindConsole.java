package com.rickkorkmaz.mastermindgame;

import java.util.Scanner;

public class MastermindConsole {

    public static void main(String[] args) {
        MastermindGame mastermindGame = new MastermindGame();
        Scanner scanner = new Scanner(System.in);

        while (mastermindGame.currentlyPlaying()) {
            System.out.println("Guess please: ");
            mastermindGame.checkCombination(scanner.next());
        }

    }
}
