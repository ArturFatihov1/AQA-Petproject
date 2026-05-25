package tests.demoqa.data;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateGenerator {
    private static final Faker faker = new Faker();

    public static String getRandomSimpleDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthday = faker.timeAndDate().birthday(18, 60);
        return birthday.format(formatter);
    }

    public static String getRandomDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a", Locale.ENGLISH);

        java.time.Instant instantFuture = faker.timeAndDate().future(30, TimeUnit.DAYS);
        LocalDateTime futureDate = instantFuture.atZone(ZoneId.systemDefault()).toLocalDateTime();

        return futureDate.format(formatter);
    }
}