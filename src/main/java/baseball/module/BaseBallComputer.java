package baseball.module;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallComputer {

    private final List<Integer> computerNumbers = new ArrayList<>(3);

    public List<Integer> init() {
        // loop를 정확하게 3번 안돌수도 있는게 마음에 걸리지만 요구사항에 Randoms.pickNumberInRange를 사용하라고 명시되어 있음.
        while (computerNumbers.size() != 3) {
            int picked = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(picked)) {
                computerNumbers.add(picked);
            }
        }

        return computerNumbers;
    }
}
