package com.rickkorkmaz.dicegame;

public class DiceGame {
    private Dice[] dices;

    public DiceGame() {
        dices = new Dice[]{new Dice(), new Dice()};
    }

    public void play(){
        int total = 0;

        for (Dice dice : dices) {
            dice.roll();
            total += dice.getFaceValue();
        }

        if (total == 7) {
            System.out.println("You rolled " + total + ". You won!");
        } else {
            System.out.println("You rolled " + total + ". You lost!");
        }
    }
}
