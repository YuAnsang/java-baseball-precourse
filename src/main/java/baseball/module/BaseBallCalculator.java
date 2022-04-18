package baseball.module;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallCalculator {

    private boolean[] strikeResult = {false, false, false};

    private int strike = 0;

    private int ball = 0;

    private final List<Integer> computerNumbers;

    public BaseBallCalculator(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void calculate(String input) {
        String[] sliced = input.split("");
        calculateStrike(sliced);
        calculateBall(sliced);
    }

    private void calculateStrike(String[] sliced) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int slicedInt = Integer.parseInt(sliced[i]);
            if (slicedInt == computerNumbers.get(i)) {
                strike++;
                strikeResult[i] = true;
            }
        }
    }

    private void calculateBall(String[] sliced) {
        Set<Integer> notStrikeValues = getNotStrikeValues();
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (strikeResult[i]) { // isStrike
                continue;
            }

            int slicedInt = Integer.parseInt(sliced[i]);
            if (notStrikeValues.contains(slicedInt)) {
                ball++;
            }
        }
    }

    private Set<Integer> getNotStrikeValues() {
        HashSet<Integer> sets = new HashSet<>(computerNumbers);
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (strikeResult[i]) { // isStrike
                sets.remove(computerNumbers.get(i));
            }
        }
        return sets;
    }

    public void clear() {
        this.strike = 0;
        this.ball = 0;
        this.strikeResult = new boolean[]{false, false, false};
    }

    public boolean isRightAnswer() {
        return this.strike == 3;
    }

    public void print() {
        // 해당 메서드는 10줄 이하로 줄이는게 리소스 낭비라고 판단.
        if (this.strike == 0 && this.ball == 0) {
            System.out.println("낫싱");
        }

        if (this.strike != 0 && this.ball == 0) {
            System.out.format("%s스트라이크\n", this.strike);
        }

        if (this.strike == 0 && this.ball != 0) {
            System.out.format("%s볼\n", this.ball);
        }

        if (this.strike != 0 && this.ball != 0) {
            System.out.format("%s볼 %s스트라이크\n", this.ball, this.strike);
        }

        if (this.strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
