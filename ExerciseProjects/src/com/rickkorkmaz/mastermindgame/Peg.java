package com.rickkorkmaz.mastermindgame;

public class Peg {
    private String color;

    public Peg(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peg peg = (Peg) o;
        return color.equals(peg.color);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Peg{" +
                "color='" + color + '\'' +
                '}';
    }
}
