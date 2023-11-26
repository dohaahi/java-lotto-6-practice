package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.dto.DrawResultDto;

public class DrawResult {
    private final Map<Rank, Integer> results;
    private static final int INIT_MATCH_COUNT = 0;

    public DrawResult() {
        Map<Rank, Integer> results = new LinkedHashMap<>();

        Rank.getRanks()
                .forEach(rank -> {
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

    public DrawResultDto mapToDrawResultDto() {
        return new DrawResultDto(results);
    }
}