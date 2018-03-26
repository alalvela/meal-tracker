package com.example.demo.repository;

import com.example.demo.domain.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query(value = "select date, sum(calorie_count) from meal group by date order by date desc", nativeQuery = true)
    List<Object[]> findAllDays();

    List<Meal> findByDescriptionContainingIgnoreCase(String desc);

}
