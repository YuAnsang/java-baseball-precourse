package baseball;

import baseball.module.BaseBallCalculator;
import baseball.module.BaseBallComputer;
import baseball.module.BaseBallNumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static BaseBallCalculator calculator;

    public static void main(String[] args) {
        boolean isRunning = true;

        initialize();

        while (isRunning) {
            System.out.print("숫자를입력해주세요 : ");
            String input = Console.readLine();

            boolean inputValidate = BaseBallNumberValidator.validate(input);
            if (!inputValidate) {
                throw new IllegalArgumentException("wrong input. : " + input);
            }

            calculator.calculate(input);
            calculator.print();
            if (calculator.isRightAnswer()) {
                isRunning = selectContinue();
            }
            calculator.clear();
        }
    }

    private static void initialize() {
        BaseBallComputer computer = new BaseBallComputer();
        List<Integer> computerNumbers = computer.init();

        boolean validate = BaseBallNumberValidator.validate(computerNumbers);

        if (!validate) {
            throw new RuntimeException("Generated Wrong Number");
        }

//        computerNumbers.forEach(System.out::println); // 정답 확인 용

        calculator = new BaseBallCalculator(computerNumbers);
    }

    private static boolean selectContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInput = Console.readLine();

        if (!"1".equals(restartInput) && !"2".equals(restartInput)) {
            throw new IllegalArgumentException("input value must be 1 or 2 : " + restartInput);
        }

        if ("1".equals(restartInput)) {
            initialize();
            return true;
        }

        return false;
    }
}
