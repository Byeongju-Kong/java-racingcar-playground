package view;

import model.car.Car;

import java.util.List;

public interface Output {
    void showRoundResult(List<Car> cars);

    void showWinners(List<String> winners);
}
