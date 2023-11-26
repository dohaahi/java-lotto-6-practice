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

        // 2. 로또 추첨
        DrawLottos drawLottos = machine.purchase(purchaseAmount);
        OutputView.printDrawLottos(drawLottos.toDrawLottosDto());
        DrawResult result = machine.draw(lotto, drawLottos, bonusNumber);

        // 3. 결과 출력
        OutputView.printDrawResult(result.toLottoResultDto());
    }
}