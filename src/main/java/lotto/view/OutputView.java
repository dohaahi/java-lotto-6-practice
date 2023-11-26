package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.dto.DrawLottoDto;
import lotto.domain.dto.DrawLottosDto;

public class OutputView {
    private static final String PURCHASE_LOTTO_MESSAGE = "\n%d개를 구매했습니다.\n";

    public static void printDrawLottos(final DrawLottosDto drawLottos) {
        System.out.printf(PURCHASE_LOTTO_MESSAGE, drawLottos.lottos().size());

        drawLottos.lottos()
                .forEach(lotto -> {
                    System.out.println("[" + mapToString(lotto) + "]");
                });
    }

    private static String mapToString(final DrawLottoDto lotto) {
        return lotto.numbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}