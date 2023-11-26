package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.dto.LottoResultDto;

public class DrawResult {
    private final Map<Rank, Integer> results;
    private int initMatchCount = 0;

    public DrawResult() {
        LinkedHashMap<Rank, Integer> results = new LinkedHashMap<>();

        Rank.getRanks()
                .forEach(rank -> {
                    results.put(rank, initMatchCount);
                });

        this.results = results;
    }

    public void matchRank(final int matchNumberCount, final boolean hasBonusNumber) {
        Rank matcedhRank = Rank.getRank(matchNumberCount, hasBonusNumber);

        results.entrySet()
                .forEach(result -> {
                    if (result.getKey().equals(matcedhRank)) {
                        result.setValue(initMatchCount += 1);
                    }
                });
    }

    public LottoResultDto toLottoResultDto() {
        return new LottoResultDto(results);
    }
}