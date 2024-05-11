package ua.zhenya.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MealTo {
    private final LocalDateTime createdAt;
    private final String description;
    private final int calories;
    private final boolean exceed;
}
