package ua.zhenya.util;

import ua.zhenya.model.UserMeal;
import ua.zhenya.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2022, Month.AUGUST, 18, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2021, Month.MARCH, 24, 20, 12), "Завтрак", 637),
                new UserMeal(LocalDateTime.of(2022, Month.APRIL, 18, 15, 56), "Завтрак", 100),
                new UserMeal(LocalDateTime.of(2022, Month.JULY, 12, 14, 3), "Завтрак", 600),
                new UserMeal(LocalDateTime.of(2022, Month.AUGUST, 17, 9, 25), "Завтрак", 537),
                new UserMeal(LocalDateTime.of(2022, Month.MAY, 25, 11, 22), "Завтрак", 327),
                new UserMeal(LocalDateTime.of(2022, Month.MAY, 25, 11, 22), "Обед", 2000)
        );

        List<UserMealWithExceed> filteredMealsWithExceeded = getFilteredMealsWithExceeded(mealList, LocalTime.of(20, 0), LocalTime.of(22, 0), 1000);
        filteredMealsWithExceeded.forEach(System.out::println);
    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = mealList.stream()
                .collect(Collectors.groupingBy(userMeal -> userMeal.getCreateAt().toLocalDate(),
                        Collectors.summingInt(UserMeal::getCalories)));

        List<UserMealWithExceed> list = mealList.stream()
                .filter(userMeal -> DateTimeUtil.isBetween(userMeal.getCreateAt().toLocalTime(), startTime, endTime))
                .map(userMeal -> new UserMealWithExceed(userMeal.getCreateAt(), userMeal.getDescription(), userMeal.getCalories(), caloriesSumByDate.get(userMeal.getCreateAt().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
        return list;

    }


}