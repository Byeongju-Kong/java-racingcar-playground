package model;

public class RacingRound {
    private int leftRound;

    public RacingRound(final int round) {
        validateRacingRound(round);
        leftRound = round;
    }

    private void validateRacingRound(final int round) {
        if(round <= 0) {
            throw new IllegalArgumentException("경주 횟수는 양수여야합니다.");
        }
    }

    public void decreaseLeftRound() {
        leftRound--;
    }

    public boolean isOver() {
        return leftRound == 0;
    }
}
