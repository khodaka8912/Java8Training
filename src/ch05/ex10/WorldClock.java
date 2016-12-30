package ch05.ex10;

import java.time.*;

/**
 * @author hodaka
 */
public class WorldClock {

    static LocalDateTime arrivalTime(ZoneId from, ZoneId to, LocalDateTime timeOfDeparture, Duration timeToTravel) {
        return timeOfDeparture.atZone(from).plus(timeToTravel).withZoneSameInstant(to).toLocalDateTime();
    }

    public static void main(String[] args) {
        ZoneId from;
        ZoneId to;
        LocalDateTime timeToDeparture;
        Duration travelTime;
        if (args.length == 4) {
            from = ZoneId.of(args[0]);
            to = ZoneId.of(args[1]);
            timeToDeparture = LocalDateTime.parse(args[2]);
            travelTime = Duration.parse(args[3]);
        } else {
            from = ZoneId.of("America/Los_Angeles");
            to = ZoneId.of("CET");
            LocalDate today = LocalDate.now();
            timeToDeparture = LocalDateTime.of(today, LocalTime.of(15, 05));
            travelTime = Duration.ofHours(10).plusMinutes(50);
        }
        System.out.println("Arrive at : " + arrivalTime(from, to, timeToDeparture, travelTime));
    }
}
