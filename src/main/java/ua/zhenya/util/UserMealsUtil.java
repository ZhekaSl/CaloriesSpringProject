package ua.zhenya.util;

import ua.zhenya.model.Meal;
import ua.zhenya.model.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<Meal> mealList = Arrays.asList(
                new Meal(LocalDateTime.of(2022, Month.AUGUST, 18, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2021, Month.MARCH, 24, 20, 12), "Завтрак", 637),
                new Meal(LocalDateTime.of(2022, Month.APRIL, 18, 15, 56), "Завтрак", 100),
                new Meal(LocalDateTime.of(2022, Month.JULY, 12, 14, 3), "Завтрак", 600),
                new Meal(LocalDateTime.of(2022, Month.AUGUST, 17, 9, 25), "Завтрак", 537),
                new Meal(LocalDateTime.of(2022, Month.MAY, 25, 11, 22), "Завтрак", 327),
                new Meal(LocalDateTime.of(2022, Month.MAY, 25, 11, 22), "Обед", 2000)
        );

        List<MealTo> filteredMealsWithExceeded = getFilteredMealsWithExceeded(mealList, LocalTime.of(20, 0), LocalTime.of(22, 0), 1000);
        filteredMealsWithExceeded.forEach(System.out::println);
    }

    public static List<MealTo> getFilteredMealsWithExceeded(List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = mealList.stream()
                .collect(Collectors.groupingBy(meal -> meal.getCreateAt().toLocalDate(),
                        Collectors.summingInt(Meal::getCalories)));

        return mealList.stream()
                .filter(meal -> DateTimeUtil.isBetween(meal.getCreatedTime(), startTime, endTime))
                .map(meal -> new MealTo(meal.getCreateAt(), meal.getDescription(), meal.getCalories(), caloriesSumByDate.get(meal.getCreatedDate()) > caloriesPerDay))
                .collect(Collectors.toList());

    }

    public static List<MealTo> getFilteredWithExcess(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(Collectors.groupingBy(Meal::getCreatedDate, Collectors.summingInt(Meal::getCalories)));

        return meals.stream()
                .filter(meal -> DateTimeUtil.isBetween(meal.getCreatedTime(), startTime, endTime))
                .map(meal ->
                        new MealTo(
                                meal.getCreateAt(),
                                meal.getDescription(),
                                meal.getCalories(),
                                caloriesSumByDate.get(meal.getCreatedDate()) > caloriesPerDay
                        )
                )
                .collect(Collectors.toList());
    }



}