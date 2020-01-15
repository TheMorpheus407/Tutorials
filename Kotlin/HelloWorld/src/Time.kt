import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun main(args: Array<String>) {
	val dateTime = LocalDateTime.now()
	println(dateTime)

	val date = LocalDate.now()
	println(date)

	val time = LocalTime.now()
	println(time)

	val then = LocalDateTime.of(2019, Month.NOVEMBER, 22, 16, 8, 52)
	println(then)
	println(then.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)))
	println(then.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)))
	println(then.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))


}