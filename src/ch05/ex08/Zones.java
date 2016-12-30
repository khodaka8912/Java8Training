package ch05.ex08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hodaka
 */
public class Zones {

    static Map<ZoneId, ZoneOffset> getAvailableZoneOffsets() {
        LocalDateTime now = LocalDateTime.now();
        Map<ZoneId, ZoneOffset> map = ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of).map(id -> ZonedDateTime.of(now, id))
                .collect(Collectors.toMap(ZonedDateTime::getZone, ZonedDateTime::getOffset));
        return map;
    }

    public static void main(String[] args) {
        String[] ids = ZoneId.getAvailableZoneIds().toArray(new String[0]);
        Arrays.sort(ids, Comparator.naturalOrder());
        for (String id : ids) {
            System.out.println(id);
        }
//        getAvailableZoneOffsets().forEach((id, offset) -> System.out.println(id + ": " + offset));
    }
}
