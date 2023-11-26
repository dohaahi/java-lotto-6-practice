package lotto.domain;

import static lotto.domain.PurchaseAmount.AMOUNT_UNIT;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lotto.domain.dto.DrawResultDto;

public class DrawResult {
    private static final int INIT_MATCH_COUNT = 0;
    private final Map<Rank, Integer> results;
    private double profit = 0;

    public DrawResult() {
        Map<Rank, Integer> results = new LinkedHashMap<>();

        Rank.getRanks().forEach(rank -> {
            results.put(rank, INIT_MATCH_COUNT);
        });

        this.results = results;
    }

    public void matchRank(final int matchCount, final boolean matchBonusNumber) {
        Rank rank = Rank.getRank(matchCount, matchBonusNumber);

        if (rank != null) {
            results.computeIfPresent(rank, (key, value) -> value + 1);
        }
    }

    private void calculateRateOfReturn(final PurchaseAmount purchaseAmount) {
        Set<Entry<Rank, Integer>> results = this.results.entrySet();
        int profit = 0;

        for (Entry<Rank, Integer> result : results) {
            profit += result.getKey().getPrizeAmount() * result.getValue();
        }

        this.profit = (double) profit / (purchaseAmount.getAmount() * AMOUNT_UNIT);
    }

    public DrawResultDto mapToDrawResultDto(final PurchaseAmount purchaseAmount) {
        calculateRateOfReturn(purchaseAmount);

        return new DrawResultDto(results, profit);
    }
}