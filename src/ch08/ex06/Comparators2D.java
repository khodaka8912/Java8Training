package ch08.ex06;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Comparator;

import static java.util.Comparator.comparing;

/**
 * @author hodaka
 */
public class Comparators2D {

    static final Comparator<Point2D> pointComparator = comparing(Point2D::getX)
            .thenComparing(Point2D::getY);
    static final Comparator<Rectangle2D> rectangleComparator = comparing(Rectangle2D::getX)
            .thenComparing(Rectangle2D::getY);

    static <T> void compareAndShow(T t1, T t2, Comparator<T> comparator) {
        String comp = comparator.compare(t1, t2) == 0 ? " = "
                : comparator.compare(t1, t2) > 0 ? " > "
                : " < ";
        System.out.println(t1 + comp + t2);
    }

    public static void main(String[] args) {
        Point2D[] points = {new Point(0, 3), new Point(2, 1), new Point(2, 3), new Point(0, 3)};
        for (int i = 0; i < points.length; i++) {
            compareAndShow(points[i], points[(i + 1) % points.length], pointComparator);
        }
    }
}
