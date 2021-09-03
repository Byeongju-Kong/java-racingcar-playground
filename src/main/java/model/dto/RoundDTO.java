package model.dto;

import java.util.List;

public class RoundDTO {
    private final List<String> carNames;
    private final List<Integer> distances;

    public RoundDTO(final List<String> carNames, final List<Integer> distances) {
        this.carNames = carNames;
        this.distances = distances;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getDistances() {
        return distances;
    }
}
