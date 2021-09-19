package com.vinaylogics.problems;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimeDurationDemo {

    public static final ThreadLocalRandom LOCAL_RANDOM = ThreadLocalRandom.current();

    public List<LocalTime> getSlots(LocalTime localTime) {
        List<LocalTime> slots = new ArrayList<>();
        LocalTime newLocalTime;
        for (newLocalTime = LocalTime.of(localTime.getHour(), localTime.getMinute(), 0); LocalTime.MAX.getHour() - newLocalTime.getHour() > 1; newLocalTime = newLocalTime.plusHours(localTime.getHour()).plusMinutes(localTime.getMinute())) {
            slots.add(newLocalTime);
        }
        if (newLocalTime.isBefore(LocalTime.MAX) || newLocalTime.equals(LocalTime.MAX)) {
            slots.add(newLocalTime);
        }
        return slots;
    }

    public LocalDateTime getRandomLocalDateTime() {
        return LocalDateTime.of(2021, LOCAL_RANDOM.nextInt(1, 12), LOCAL_RANDOM.nextInt(1, 30), LOCAL_RANDOM.nextInt(1, 24), LOCAL_RANDOM.nextInt(0, 50));
    }

    public static void main(String[] args) {
        TimeDurationDemo timeDurationDemo = new TimeDurationDemo();
        List<LocalTime> localTimes = timeDurationDemo.getSlots(LocalTime.of(1, 30));
        System.out.println(localTimes);
        /*System.out.println(timeDurationDemo.getSlots(LocalTime.of(1, 50)));
        System.out.println(timeDurationDemo.getSlots(LocalTime.of(2, 0)));*/
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> localDateTimes.add(timeDurationDemo.getRandomLocalDateTime()));
        System.out.println(localDateTimes);
        List<LocalDateTime> processedLocalDateTime = timeDurationDemo.processDateTime(localDateTimes, localTimes);
        System.out.println(processedLocalDateTime);
    }

    private List<LocalDateTime> processDateTime(List<LocalDateTime> localDateTimes, List<LocalTime> localTimes) {
        List<LocalDateTime> processedDateTime = new ArrayList<>();
        localDateTimes.forEach(localDateTime ->
                processedDateTime.add(processTime(localDateTime, localTimes)));
        return processedDateTime;
    }

    private LocalDateTime processTime(LocalDateTime localDateTime, List<LocalTime> localTimes) {
        LocalTime refTime = localDateTime.toLocalTime();
        List<Long> timeDifference = localTimes.stream().map(time -> ChronoUnit.MINUTES.between(refTime, time)).collect(Collectors.toList());
        Long minValue = timeDifference.stream().mapToLong(i -> i < 0 ? -1 * i : i).min().orElse(0);
//        System.out.println(minValue);
        int index = 0;
        if (timeDifference.contains(minValue)) {
            index = timeDifference.indexOf(minValue);
        } else {
            index = timeDifference.indexOf(-1 * minValue);
        }
        LocalTime actual = localTimes.get(index);
        if (actual.getHour() > refTime.getHour() && index > 0) {
            actual = localTimes.get(index - 1);
        } else if (actual.getHour() == refTime.getHour()) {
            if (!(refTime.getMinute() >= actual.getMinute()) && index > 0) {
                actual = localTimes.get(index - 1);
            }
        } else {
            if(index > 0) {
                actual = localTimes.get(index - 1);
            }
        }
        return localDateTime.withHour(actual.getHour()).withMinute(actual.getMinute());
        /*for (LocalTime localTime : localTimes){
            if(refTime.isAfter(localTime)){
                System.out.println(refTime);
                System.out.println(localTime);
                if (refTime.getHour() >= localTime.getHour()){
                    if(refTime.getMinute() >= localTime.getMinute()){
                        return localDateTime.withHour(localTime.getHour()).withMinute(localTime.getMinute());
                    }else {
                        int index = localTimes.indexOf(localTime);
                        if(index ==0 ){
                            return localDateTime.withHour(localTime.getHour()).withMinute(localTime.getMinute());
                        }
                        LocalTime newRefTime = localTimes.get(localTimes.indexOf(localTime)-1);
                        return localDateTime.withHour(newRefTime.getHour()).withMinute(newRefTime.getMinute());
                    }
                }
            }
        }
*/
        /*  return null;*/
    }

}
