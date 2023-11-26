package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.DrawLottoDto;
import lotto.domain.dto.DrawLottosDto;

public class DrawLottos {
    private final List<DrawLotto> lottos;

    private DrawLottos(final List<DrawLotto> lottos) {
        this.lottos = lottos;
    }

    public static DrawLottos from(final PurchaseAmount purchaseAmount) {
        List<DrawLotto> lottos = new ArrayList<>();

        for (int count = 0; count < purchaseAmount.getAmount(); count++) {
            lottos.add(DrawLotto.from());
        }

        return new DrawLottos(lottos);
    }

    public DrawLottosDto toDrawLottosDto() {
        List<DrawLottoDto> lottoDtos = new ArrayList<>();

        for (DrawLotto lotto : lottos) {
            lottoDtos.add(lotto.toDrawLottoDto());
        }

        return new DrawLottosDto(lottoDtos);
    }

    public List<DrawLotto> getLottos() {
        return lottos;
    }
}
