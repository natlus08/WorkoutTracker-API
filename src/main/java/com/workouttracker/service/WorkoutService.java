/**
 * 
 */
package com.workouttracker.service;

import java.util.List;

import com.workouttracker.model.ActiveWorkout;
import com.workouttracker.model.Workout;

/**
 * @author hameedu sultan
 *
 */
public interface WorkoutService {
	
	List<Workout> getWorkouts();
	
	ActiveWorkout getActiveWorkout();

}
