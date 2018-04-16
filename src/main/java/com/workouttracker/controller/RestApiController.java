/**
 * 
 */
package com.workouttracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workouttracker.model.ActiveWorkout;
import com.workouttracker.model.Category;
import com.workouttracker.model.Workout;
import com.workouttracker.service.CategoryService;
import com.workouttracker.service.WorkoutService;


/**
 * @author hameedu sultan
 *
 */

@RestController
@RequestMapping("/tracker/api")
public class RestApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private WorkoutService workoutService;
	
	/**
	 * GET --> Get all categories
	 */
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> categories = categoryService.getCategories();
		if (categories.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	/**
	 * GET --> Get all workouts
	 */
	@GetMapping("/workouts")
	public ResponseEntity<List<Workout>> getWorkouts() {
		List<Workout> workouts = workoutService.getWorkouts();
		if (workouts.isEmpty()) {
			return new ResponseEntity<List<Workout>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Workout>>(workouts, HttpStatus.OK);
	}
	
	
	/**
	 * GET --> Get active workout
	 */
	@GetMapping("/active-workout")
	public ResponseEntity<ActiveWorkout> getActiveWorkout() {
		ActiveWorkout workout = workoutService.getActiveWorkout();
		if (null == workout) {
			return new ResponseEntity<ActiveWorkout>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ActiveWorkout>(workout, HttpStatus.OK);
	}
	
	
}
