package lottogame;

import java.util.Arrays;

public class Scorebord {
    private Lottobal[] ballen;
    private Lottobal bonusbal;
    private int huidigePositie;

    public Scorebord(int aantalBallen) {
        ballen = new Lottobal[aantalBallen];
    }

    public void plaatsBal(Lottobal bal) {
        ballen[huidigePositie] = bal;
        huidigePositie++;
    }

    public void plaatsBonusbal(Lottobal bal) {
        bonusbal = bal;
    }

    public void maakLeeg() {
        for (Lottobal lottobal : ballen) {
            lottobal = null;
        }
    }

    public void sorteerBallen() {
        for (int i = 1; i < ballen.length; i++) {
            Lottobal current = ballen[i];
            int j = i - 1;
            while(j >= 0 && current.getBalnummer() < ballen[j].getBalnummer()) {
                ballen[j+1] = ballen[j];
                j--;
            }
            ballen[j+1] = current;
        }
    }

    @Override
    public String toString() {
        return "Scorebord{" +
                "ballen=" + Arrays.toString(ballen) +
                ", bonusbal=" + bonusbal +
                '}';
    }
}
