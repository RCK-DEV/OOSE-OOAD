package lottogame;

public class LottoMachine {
    private Scorebord bord;
    private GlazenBol bol;

    LottoMachine(int aantalScorebordBallen,
                 int glazenBolCapaciteit) {
        bord = new Scorebord(aantalScorebordBallen);
        bol = new GlazenBol(glazenBolCapaciteit);
    }

    public void voerTrekkingUit() {
        bol.verzamelAlleBallen();
        bord.maakLeeg();

        for (int i = 0; i < 6; i++) {
            bord.plaatsBal(bol.schepBal());
        }

        bord.plaatsBonusbal(bol.schepBal());

        bord.sorteerBallen();

        System.out.println(bord);
    }

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(6, 50);
        lottoMachine.voerTrekkingUit();
    }
}
