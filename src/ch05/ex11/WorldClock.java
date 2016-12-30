package ch05.ex11;

import java.time.*;

/**
 * @author hodaka
 */
public class WorldClock {

    static LocalDateTime arrivalTime(ZoneId from, ZoneId to, LocalDateTime timeOfDeparture, Duration timeToTravel) {
        return timeOfDeparture.atZone(from).plus(timeToTravel).withZoneSameInstant(to).toLocalDateTime();
    }

    static Duration timeToTravel(ZoneId from, ZoneId to, LocalDateTime timeOfDeparture, LocalDateTime arrivalTime) {
        return Duration.between(timeOfDeparture.atZone(from), arrivalTime.atZone(to));
    }

    public static void main(String[] args) {
        ZoneId from;
        ZoneId to;
        LocalDateTime timeOfDeparture;
        LocalDateTime arrivalTime;
        if (args.length == 4) {
            from = ZoneId.of(args[0]);
            to = ZoneId.of(args[1]);
            timeOfDeparture = LocalDateTime.parse(args[2]);
            arrivalTime = LocalDateTime.parse(args[3]);
        } else {
            from = ZoneId.of("CET");
            to = ZoneId.of("America/Los_Angeles");
            LocalDate today = LocalDate.now();
            timeOfDeparture = LocalDateTime.of(today, LocalTime.of(14, 05));
            arrivalTime = LocalDateTime.of(today, LocalTime.of(16, 40));
        }
        System.out.println("Time to travel is : " + timeToTravel(from, to, timeOfDeparture, arrivalTime));
    }
}
