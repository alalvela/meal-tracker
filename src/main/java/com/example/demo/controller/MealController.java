package com.example.demo.controller;

import com.example.demo.domain.entity.Meal;
import com.example.demo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    MealService mealService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMeal(@RequestBody Meal meal) {
        Meal m = mealService.createMeal(meal);
        if (m == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(m);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getDays() {
        return ResponseEntity.ok(mealService.listDailyIntake());
    }

    @RequestMapping(value = "/{desc}", method=RequestMethod.GET)
    public ResponseEntity<?> getMealsByDescription(@PathVariable("desc") String description){
        return ResponseEntity.ok(mealService.listByDescription(description));
    }


}
