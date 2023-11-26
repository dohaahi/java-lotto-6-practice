package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.DrawLottoDto;
import lotto.domain.dto.DrawLottosDto;

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

    public List<DrawLotto> getLottos() {
        return List.copyOf(lottos);
    }

    public DrawLottosDto toDrawLottosDto() {
        List<DrawLottoDto> lottoDtos = lottos.stream()
                .map(DrawLotto::toDrawLottoDto)
                .toList();

        return new DrawLottosDto(lottoDtos);
    }
}