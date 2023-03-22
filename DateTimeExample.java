import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeExample {
    public static void main(String[] args) {

        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("Date: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        System.out.println("Month: " + month + ", Day: " + day);

        LocalTime time = currentTime.toLocalTime();
        System.out.println("Time: " + time);

        LocalDateTime customDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 13, 30);
        System.out.println("Custom DateTime: " + customDateTime);
    }
}
