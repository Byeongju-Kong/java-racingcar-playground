package view;

import model.car.Car;
import model.dto.RoundDTO;

import java.util.List;

public interface Displayable {
    void alertInputCarNames();

    void alertInputRacingRound();

    void showStart();

    void showRoundResult(RoundDTO roundResult);

    void showFinalResult(List<Car> winner);
}
