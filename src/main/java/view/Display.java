package view;

import model.dto.RoundDTO;
import model.car.Car;

import java.util.List;
import java.util.stream.IntStream;

public class Display implements Displayable {
    private static final String DISTANCE_SYMBOL = "-";
    private static final String DELIMITER = ",";

    @Override
    public void alertInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Override
    public void alertInputRacingRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    @Override
    public void showStart() {
        System.out.println("\n실행결과\n");
    }

    @Override
    public void showRoundResult(RoundDTO roundResult) {
        IntStream.range(0, roundResult.getCarNames().size())
                .forEach(index -> System.out.println(roundResult.getCarNames().get(index) + " : "
                        + DISTANCE_SYMBOL.repeat(roundResult.getDistances().get(index))));
    }

    @Override
    public void showFinalResult(List<Car> winner) {
        StringBuilder result = new StringBuilder();
        String lastWords = "가 최종 우승했습니다.";
        IntStream.range(0, winner.size())
                .forEach(index -> result.append(winner.get(index).getCarName()).append(DELIMITER));
        result.deleteCharAt(result.lastIndexOf(DELIMITER));
        System.out.print(result.append(lastWords));
    }
}
