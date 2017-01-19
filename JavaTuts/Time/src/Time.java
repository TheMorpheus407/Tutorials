import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;




public class Time {

	public static void main(String[] args) {
		Clock myClock = Clock.systemUTC();
		Instant start = myClock.instant();
		Instant end = myClock.instant();
		Duration elapsed = Duration.between(start, end);
		
		LocalDate dateTime = LocalDate.of(1900, Month.FEBRUARY, 1);
		LocalDate dt2 = LocalDate.of(1993, 3, 2);
		Period between = Period.between(dateTime, dt2);
		
		LocalDateTime dt = LocalDateTime.now();
		String pattern = "dd-MM-yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		System.out.println(dtf.format(dt));
		}

}
