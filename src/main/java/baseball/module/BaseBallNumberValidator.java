package baseball.module;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumberValidator {

    public static boolean validate(String input) {
        String numberPattern = "^[1-9]{3}";

        if (!input.matches(numberPattern)) {
            return false;
        }

        Set<Integer> sets = new HashSet<>();
        for (String sliced : input.split("")) {
            sets.add(Integer.valueOf(sliced));
        }

        if (sets.size() != 3) {
            return false;
        }

        return true;
    }

    public static boolean validate(List<Integer> numbers) {
        if (numbers.size() != 3) {
            return false;
        }

        if (isContainsZeroOrNegative(numbers)) {
            return false;
        }

        Set<Integer> sets = new HashSet<>(numbers);

        if (sets.size() != 3) {
            return false;
        }

        return true;
    }

    private static boolean isContainsZeroOrNegative(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                return true;
            }
        }
        return false;
    }

}
