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

	Workout addWorkout(Workout workout);

	Workout editWorkout(Workout workout);

	void deleteWorkout(Long id);

	ActiveWorkout startActiveWorkout(ActiveWorkout activeWorkout);

	ActiveWorkout endActiveWorkout(ActiveWorkout activeWorkout);

	Workout getWorkout(Long id);

	List<ActiveWorkout> getActiveWorkouts();

}
