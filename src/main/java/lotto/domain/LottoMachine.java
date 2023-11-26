package lotto.domain;

public class LottoMachine {
    public  DrawLottos purchase(final PurchaseAmount purchaseAmount) {
        return DrawLottos.from(purchaseAmount);
    }

    public  void draw(final PurchaseAmount purchaseAmount, final Lotto lotto) {

    }
}
