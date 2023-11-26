package lotto.controller;

import static lotto.util.RetryHandler.retryIfFailure;

import lotto.domain.BonusNumber;
import lotto.domain.DrawLottos;
import lotto.domain.DrawResult;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine machine = new LottoMachine();

    public void run() {
        // 1. 로또 구매
        PurchaseAmount purchaseAmount = retryIfFailure(InputView::readPurchaseAmount);
        Lotto lotto = retryIfFailure(InputView::readLottoNumbers);
        BonusNumber bonusNumber = retryIfFailure(InputView::readBonusNumber);
        DrawLottos drawLottos = machine.purchase(purchaseAmount);
        OutputView.printDrawLottos(drawLottos.toDrawLottosDto());

        // 2. 추첨
        DrawResult drawResult = machine.draw(lotto, drawLottos, bonusNumber);
        OutputView.printDrawResult(drawResult.mapToDrawResultDto());

        // 3. 당첨 결과 출력
    }
}