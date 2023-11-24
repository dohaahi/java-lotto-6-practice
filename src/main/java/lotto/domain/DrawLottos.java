package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class DrawLottos {
    private final List<DrawLotto> lottos;

    private DrawLottos(List<DrawLotto> lottos) {
        this.lottos = lottos;
    }

    public static DrawLottos from(final PurchaseAmount purchaseAmount) {
        final List<DrawLotto> lottoStorage = new ArrayList<>();

        for (int count = 0; count < purchaseAmount.getAmount(); count++) {
            lottoStorage.add(DrawLotto.from());
        }

        return new DrawLottos(lottoStorage);
    }
}