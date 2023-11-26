package lotto.view;

import java.text.DecimalFormat;
import java.util.stream.Collectors;
import lotto.domain.Rank;
import lotto.domain.dto.DrawLottoDto;
import lotto.domain.dto.DrawLottosDto;
import lotto.domain.dto.DrawResultDto;

public class OutputView {
    private static final String PURCHASE_LOTTO_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String RANK_HAS_BONUS_NUMBER_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String RANK__MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String PROFIT__MESSAGE = "총 수익률은 %s입니다.";
    public static final String MONEY_FORMAT = "###,###";
    public static final String PROFIT_FORMAT = "###,###.#%";

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

    public static void printDrawResult(final DrawResultDto drawResultDto) {
        System.out.println(WINNING_RESULT_MESSAGE);

        drawResultDto.results()
                .forEach(OutputView::printResultMatchRank);

        System.out.printf(PROFIT__MESSAGE,
                mapToProfitFormat(drawResultDto.profit()));
    }

    private static String mapToMoneyFormat(final int price) {
        final DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);
        return decimalFormat.format(price);
    }

    private static String mapToProfitFormat(final double price) {
        final DecimalFormat decimalFormat = new DecimalFormat(PROFIT_FORMAT);
        return decimalFormat.format(price);
    }

    private static void printResultMatchRank(Rank rank, Integer value) {
        if (rank.hasBonusNumber()) {
            System.out.printf(RANK_HAS_BONUS_NUMBER_MESSAGE,
                    rank.getMatchingNumbers(),
                    mapToMoneyFormat(rank.getPrizeAmount()),
                    value);
            return;
        }

        System.out.printf(RANK__MESSAGE,
                rank.getMatchingNumbers(),
                mapToMoneyFormat(rank.getPrizeAmount()),
                value);
    }
}