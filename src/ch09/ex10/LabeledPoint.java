package ch09.ex10;

import java.util.Objects;

/**
 * @author hodaka
 */
public class LabeledPoint implements Comparable<LabeledPoint> {

    private String label;
    private int x;
    private int y;

    public LabeledPoint(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LabeledPoint other = (LabeledPoint) obj;
        return Objects.equals(label, other.label) && x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, x, y);
    }

    @Override
    public int compareTo(LabeledPoint other) {
        int comp;
        if ((comp = label.compareTo(other.label)) != 0) {
            return comp;
        }
        if ((comp = Integer.compare(x, other.x)) != 0) {
            return comp;
        }
        return Integer.compare(y, other.y);
    }
}
