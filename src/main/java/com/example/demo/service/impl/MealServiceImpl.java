package com.example.demo.service.impl;

import com.example.demo.domain.entity.Meal;
import com.example.demo.domain.dto.DailyIntakeDTO;
import com.example.demo.repository.MealRepository;
import com.example.demo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    MealRepository mealRepository;

    @Override
    public Meal createMeal(Meal meal) {
        final long millis = System.currentTimeMillis();
        meal.setDate(new Date(millis));
        meal.setTime(new Time(millis));
        return mealRepository.save(meal);
    }

    public List<DailyIntakeDTO> listDailyIntake() {
        List<Object[]> list = mealRepository.findAllDays();
        return list.stream()
                    .map(item -> new DailyIntakeDTO((Date)item[0], ((BigInteger)item[1]).intValue()))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Meal> listByDescription(String desc) {
        return mealRepository.findByDescriptionContainingIgnoreCase(desc);
    }

}
