package com.nextstep.lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0L, 1),
    FIFTH(3, 5_000L, 2),
    FOURTH(4, 50_000L, 3),
    THIRD(5, 1_500_000L, 4),
    SECOND(5, 30_000_000L, 5),
    FIRST(6, 2_000_000_000L, 6);

    private final int numberOfMatchedNumber;
    private final Money money;
    private final int rankValue;

    Rank(final Integer numberOfMatchedNumber, final Long moneyValue, final int rankValue) {
      this.numberOfMatchedNumber = numberOfMatchedNumber;
      this.money = new Money(moneyValue);
      this.rankValue = rankValue;
    }

    public static Rank find(final int numberOfMatchedNumber, final boolean hasBonus) {
        Rank candidateRank = Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchedNumber(numberOfMatchedNumber, rank))
                .findAny()
                .orElse(NOTHING);
        return confirmRank(candidateRank, hasBonus);
    }

    public Money multiplyPrize(final Long count) {
        return this.money.multiplyCount(count);
    }

    public Long getMoneyValue() {
        return money.getAmount();
    }

    public int getNumberOfMatchedNumber() {
        return numberOfMatchedNumber;
    }

    public int getRankValue() {
        return rankValue;
    }

    private static boolean isSameMatchedNumber(final int numberOfMatchedNumber, final Rank rank) {
        return rank.numberOfMatchedNumber == numberOfMatchedNumber;
    }

    private static Rank confirmRank(final Rank candidateRank, final boolean hasBonus) {
        if (candidateRank == Rank.THIRD || candidateRank == Rank.SECOND) {
            return judgeIsSecond(hasBonus);
        }
        return candidateRank;
    }

    private static Rank judgeIsSecond(final boolean hasBonus) {
        if (hasBonus) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }
}
