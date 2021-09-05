package view;

import model.dto.RoundDTO;
import model.car.Car;

import java.util.List;
import java.util.stream.IntStream;

public class Display implements Displayable{
    public void alertInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void alertInputRacingRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void showStart() {
        System.out.println("\n실행결과\n");
    }

    public void showRoundResult(RoundDTO roundResult) {
        String distanceSymbol = "-";
        List<String> carNames = roundResult.getCarNames();
        List<Integer> distances = roundResult.getDistances();
        IntStream.range(0, carNames.size())
                .forEach(index -> System.out.println(carNames.get(index) + " : " + distanceSymbol.repeat(distances.get(index))));
    }

    public void showFinalResult(List<Car> winner) {
        String delimiter = ",";
        StringBuilder result = new StringBuilder();
        String lastWords = "가 최종 우승했습니다.";
        IntStream.range(0, winner.size())
                .forEach(index -> result.append(winner.get(index).getCarName()).append(delimiter));
        result.deleteCharAt(result.lastIndexOf(delimiter));
        System.out.print(result.append(lastWords));
    }
}
