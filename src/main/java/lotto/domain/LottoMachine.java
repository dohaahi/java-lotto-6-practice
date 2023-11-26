package lotto.domain;

public class LottoMachine {
    private final DrawResult drawResult = new DrawResult();

    public DrawLottos purchase(final PurchaseAmount purchaseAmount) {
        return DrawLottos.from(purchaseAmount);
    }

    public DrawResult draw(final Lotto lotto, final DrawLottos drawLottos, final BonusNumber bonusNumber) {
        drawLottos.getLottos()
                .forEach(drawLotto -> {
                    int matchNumberCount = lotto.matchNumberCount(drawLotto);
                    boolean matchBonusNumber = lotto.isMatchBonusNumber(bonusNumber);
                    drawResult.matchRank(matchNumberCount ,matchBonusNumber);
                });

        return drawResult;
    }
}
