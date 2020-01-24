package com.rickkorkmaz.dicegame;

import java.util.Random;

public class Dice {
    private int faceValue;

    public Dice() {
        faceValue = 1;
    }

    public void roll(){
        faceValue = new Random().nextInt(7);
    }

    public int getFaceValue() {
        return faceValue;
    }
}