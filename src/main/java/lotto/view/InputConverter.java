package lotto.view;

import java.util.Arrays;
import java.util.List;

public class InputConverter {
    private static final String DELIMITER = ",";

    public static int mapToInt(final String input) {
        return Integer.parseInt(input);
    }

    // "1,2,3,4"
    // -> List[1, 2, 3, 4]
    public static List<Integer> mapToIntegerList(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}