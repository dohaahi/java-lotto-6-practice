package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Rank;

public record LottoResultDto(Map<Rank, Integer> results) {
}