package Hotel_Challenge.util;

import java.time.LocalTime;

public class ReservationIdGenerator {
    private static int fiveZ = 10000;

    public static String generateId(){
        StringBuilder id = new StringBuilder();
        LocalTime now = LocalTime.now();

        id.append("HT").append(now.getSecond()).append("-");
        id.append(now.getMinute()).append("-");
        id.append(fiveZ);

        fiveZ++;

        return id.toString();
    }
}
