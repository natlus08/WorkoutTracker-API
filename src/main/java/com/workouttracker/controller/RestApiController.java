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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@CrossOrigin(origins = "*", maxAge = 3600)
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
	 * POST --> Add a category
	 */
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category newCategory = categoryService.addCategory(category);
		if (null == newCategory) {
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
	}
	
	/**
	 * PUT --> Edit a category
	 */
	@PutMapping("/category")
	public ResponseEntity<Category> editCategory(@RequestBody Category category) {
		Category newCategory = categoryService.editCategory(category);
		if (null == newCategory) {
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
	}
	
	/**
	 * Delete --> remove a category
	 */
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Category> editCategory(@PathVariable Long id) {
		categoryService.removeCategory(id);
		return new ResponseEntity<Category>(HttpStatus.OK);
	}
	
	/**
	 * GET --> Get workout
	 */
	@GetMapping("/workout/{id}")
	public ResponseEntity<Workout> getWorkout(@PathVariable Long id) {
		Workout workout = workoutService.getWorkout(id);
		if (null == workout) {
			return new ResponseEntity<Workout>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Workout>(workout, HttpStatus.OK);
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
	 * POST --> Add a workout
	 */
	@PostMapping("/workout")
	public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {
		Workout newWorkout = workoutService.addWorkout(workout);
		if (null == newWorkout) {
			return new ResponseEntity<Workout>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Workout>(newWorkout, HttpStatus.CREATED);
	}
	
	/**
	 * PUT --> Edit a workout
	 */
	@PutMapping("/workout")
	public ResponseEntity<Workout> editWorkout(@RequestBody Workout workout) {
		Workout newWorkout = workoutService.editWorkout(workout);
		if (null == newWorkout) {
			return new ResponseEntity<Workout>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Workout>(newWorkout, HttpStatus.OK);
	}
	
	/**
	 * DELETE --> Delete a workout
	 */
	@DeleteMapping("/workout/{id}")
	public ResponseEntity<Workout> deleteWorkout(@PathVariable Long id) {
		workoutService.deleteWorkout(id);
		return new ResponseEntity<Workout>(HttpStatus.OK);
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
	
	/**
	 * GET --> Get active workout
	 */
	@GetMapping("/active-workouts")
	public ResponseEntity<List<ActiveWorkout>> getActiveWorkouts() {
		List<ActiveWorkout> workouts = workoutService.getActiveWorkouts();
		if (workouts.isEmpty()) {
			return new ResponseEntity<List<ActiveWorkout>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActiveWorkout>>(workouts, HttpStatus.OK);
	}
	
	/**
	 * POST --> create/modify active workout
	 */
	@PostMapping("/active-workout/{action}")
	public ResponseEntity<ActiveWorkout> ActiveWorkout(@RequestBody ActiveWorkout activeWorkout, @PathVariable String action) {
		ActiveWorkout newActiveWorkout = null;
		if(action.equalsIgnoreCase("start")){
			newActiveWorkout = workoutService.startActiveWorkout(activeWorkout);
		} else if (action.equalsIgnoreCase("end")){
			newActiveWorkout = workoutService.endActiveWorkout(activeWorkout);
		}
		if (null == newActiveWorkout) {
			return new ResponseEntity<ActiveWorkout>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ActiveWorkout>(newActiveWorkout, HttpStatus.OK);
	}
	
}
