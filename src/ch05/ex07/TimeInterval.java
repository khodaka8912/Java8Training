package ch05.ex07;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author hodaka
 */
public class TimeInterval {

    private final LocalDateTime start;
    private final LocalDateTime end;

    TimeInterval(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public static TimeInterval between(LocalDateTime start, LocalDateTime end) {
        return new TimeInterval(start, end);
    }

    public static TimeInterval of(LocalDateTime start, Duration duration) {
        return new TimeInterval(start, start.plus(duration));
    }

    public boolean hasOverlap(TimeInterval other) {
        return start.isAfter(other.end) || start.isEqual(other.end) || end.isBefore(other.start) || end.isEqual(other.start);
    }
}
