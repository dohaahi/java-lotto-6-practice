package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Rank;

public record DrawResultDto(Map<Rank, Integer> results) {
}
