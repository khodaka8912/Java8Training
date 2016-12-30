package ch05.ex09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hodaka
 */
public class Zones {

    private static final int THRESHOLD_SECONDS = 60 * 60;

    static Map<ZoneId, ZoneOffset> getShortZoneOffsets() {
        LocalDateTime now = LocalDateTime.now();
        Map<ZoneId, ZoneOffset> map = ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of).map(id -> ZonedDateTime.of(now, id))
                .filter(z -> z.getOffset().getTotalSeconds() < THRESHOLD_SECONDS
                        && z.getOffset().getTotalSeconds() > -THRESHOLD_SECONDS)
                .collect(Collectors.toMap(ZonedDateTime::getZone, ZonedDateTime::getOffset));
        return map;
    }

    public static void main(String[] args) {
        getShortZoneOffsets().forEach((id, offset) -> System.out.println(id + ": " + offset));
    }
}
