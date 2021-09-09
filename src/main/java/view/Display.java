package view;

import model.car.Car;

import java.util.List;

public interface Display {
    String[] inputCarNames();

    int inputRacingRound();

    void showRoundResult(List<Car> cars);

    void showFinalResult(String[] winners);
}
