package ua.zhenya.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
public class UserMeal {
    private final LocalDateTime createAt;
    private final String description;
    private final int calories;
}