package ua.zhenya.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Meal {
    private final LocalDateTime createAt;
    private final String description;
    private final int calories;

    public LocalDate getCreatedDate() {
        return createAt.toLocalDate();
    }

    public LocalTime getCreatedTime() {
        return createAt.toLocalTime();

    }
}
