package lotto.domain;

import java.util.List;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingNumbers;
    private final boolean hasBonusNumber;
    private final int prizeAmount;

    Rank(int matchingNumbers, boolean hasBonusNumber, int prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.hasBonusNumber = hasBonusNumber;
        this.prizeAmount = prizeAmount;
    }

    private static final List<Rank> ranks = List.of(values());

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static List<Rank> getRanks() {
        return ranks;
    }

    public static Rank getRank(final int matchNumberCount, final boolean matchBonusNumber) {
        if (matchBonusNumber) {
            return ranks.stream()
                    .filter(Rank::hasBonusNumber)
                    .findAny()
                    .get();
        }

        return ranks.stream()
                .filter(rank -> rank.getMatchingNumbers() == matchNumberCount)
                .findAny()
                .orElse(null);
    }
}
