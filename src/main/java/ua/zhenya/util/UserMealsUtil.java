package ua.zhenya.util;

import ua.zhenya.model.UserMeal;
import ua.zhenya.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2022, Month.AUGUST, 18, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2021, Month.MARCH, 24, 20, 12), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2022, Month.APRIL, 18, 15, 56), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2022, Month.JULY, 12, 14, 3), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2022, Month.AUGUST, 17, 9, 25), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2022, Month.MAY, 25, 11, 22), "Завтрак", 500)
        );
    }

}
