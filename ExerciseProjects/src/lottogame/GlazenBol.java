package lottogame;

public class GlazenBol {
    private int capaciteit;
    private Lottobal[] ballen;

    GlazenBol(int capaciteit) {
        this.capaciteit = capaciteit;
        ballen = new Lottobal[this.capaciteit];
    }

    public void verzamelAlleBallen() {
        for (int i = 0; i < ballen.length; i++) {
            ballen[i] = new Lottobal(i);
        }
    }

    public Lottobal schepBal() {
        capaciteit--;
        return ballen[capaciteit];
    }
}
