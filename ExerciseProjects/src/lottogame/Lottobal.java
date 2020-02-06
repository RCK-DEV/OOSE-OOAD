package lottogame;

public class Lottobal {
    private int balnummer;

    Lottobal(int balnummer) {
        this.balnummer = balnummer;
    }

    public int getBalnummer() {
        return balnummer;
    }

    @Override
    public String toString() {
        return "Lottobal{" +
                "balnummer=" + balnummer +
                '}';
    }
}
