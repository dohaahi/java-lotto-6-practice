package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.DrawLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    private final LottoMachine machine = new LottoMachine();

    public void run() {
        // 1. 로또 구매
        PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
        Lotto lotto = InputView.readLottoNumbers();
        BonusNumber bonusNumber = InputView.readBonusNumber();
        DrawLottos drawLottos = machine.purchase(purchaseAmount);

        // 2. 추첨
        machine.draw(purchaseAmount, lotto);

        // 3. 당첨 결과 출력
    }
}