package com.fitness.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.entity.FitnessActivity;
import com.fitness.service.FitnessActivityService;

@RestController
@RequestMapping("/api/activities")
public class FitnessActivityController {

    private FitnessActivityService activityService;
    
    public FitnessActivityController(FitnessActivityService activityService) {
    	this.activityService = activityService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FitnessActivity>> getUserActivities(@PathVariable Long userId) {
        List<FitnessActivity> activities = activityService.getUserActivities(userId);
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/weekly/{userId}")
    public ResponseEntity<List<FitnessActivity>> getWeeklyActivities(@PathVariable Long userId) {
        List<FitnessActivity> activities = activityService.getWeeklyActivities(userId);
        return ResponseEntity.ok(activities);
    }

    @PostMapping("/addActivity")
    public ResponseEntity<String> saveActivity(@RequestBody FitnessActivity activity) {
        activityService.saveActivity(activity);
        return ResponseEntity.ok("Activity saved successfully");
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<String> deleteActivity(@PathVariable Long activityId) {
        activityService.deleteActivity(activityId);
        return ResponseEntity.ok("Activity deleted successfully");
    }
}
