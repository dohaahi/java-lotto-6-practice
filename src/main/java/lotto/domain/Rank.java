package lotto.domain;


import java.util.List;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 10_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);
    private final int matchNumberCount;
    private final int winningAmount;
    private final boolean hasBonusNumber;

    Rank(int matchNumberCount, int winningAmount, boolean hasBonusNumber) {
        this.matchNumberCount = matchNumberCount;
        this.winningAmount = winningAmount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public final static List<Rank> ranks = List.of(values());

    public static List<Rank> getRanks() {
        return ranks;
    }

    public static Rank getRank(final int matchNumberCount, final boolean hasBonusNumber) {
        if (Rank.SECOND.matchNumberCount == matchNumberCount && Rank.SECOND.hasBonusNumber == hasBonusNumber) {
            return Rank.SECOND;
        }

        for (Rank rank : ranks) {
            if (rank.matchNumberCount == matchNumberCount) {
                return rank;
            }
        }

        return null;
    }
}
