package ch09.ex08;

/**
 * @author hodaka
 */
public class Point implements Comparable<Point> {

    final int x;
    final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    @Override
    public int compareTo(Point other) {
        if (x > other.x) {
            return 1;
        } else if (x < other.x) {
            return -1;
        } else if (y > other.y) {
            return 1;
        } else if (y < other.y) {
            return -1;
        } else {
            return 0;
        }
    }
}
