package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.dto.DrawResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawResultTest {
    @DisplayName("")
    @Test
    void test() {
        // given
        DrawResult drawResult = new DrawResult();

        // when
        drawResult.matchRank(3, false);
        DrawResultDto drawResultDto = drawResult.mapToDrawResultDto();
        Integer first = drawResultDto.results()
                .get(Rank.FIFTH);

        // then
        assertThat(first.equals(1));

    }
}