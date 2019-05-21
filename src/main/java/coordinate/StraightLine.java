package coordinate;

import static util.NotNullValidator.validateNotNull;

public class StraightLine {
    private final Points points;

    public StraightLine(Points points) {
        validateNotNull(points);
        validateNumOf(points);
        validateDifferentPoint(points);
        this.points = points;
    }

    private void validateNumOf(Points points) {
        if (points.getSize() != 2) {
            throw new IllegalArgumentException("직선은 두 개의 점을 가져야합니다.");
        }
    }

    private void validateDifferentPoint(Points points) {
        if (points.get(0).equals(points.get(1))) {
            throw new IllegalArgumentException("직선의 두 점은 같을 수가 없습니다.");
        }
    }

    public double calculateDistance() {
        return Math.sqrt(Math.pow(calculateXDifference(), 2) + Math.pow(calculateYDifference(), 2));
    }

    private int calculateXDifference() {
        return points.getX(0) - points.getX(1);
    }

    private int calculateYDifference() {
        return points.getY(0) - points.getY(1);
    }
}