package com.example.demo.service;

import com.example.demo.domain.entity.Meal;
import com.example.demo.domain.dto.DailyIntakeDTO;

import java.util.List;

public interface MealService {

    Meal createMeal(Meal meal);

    List<DailyIntakeDTO> listDailyIntake();

    List<Meal> listByDescription(String desc);
}
