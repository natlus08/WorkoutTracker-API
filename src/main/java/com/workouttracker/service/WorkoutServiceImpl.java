/**
 * 
 */
package com.workouttracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workouttracker.model.ActiveWorkout;
import com.workouttracker.model.Workout;
import com.workouttracker.repository.ActiveWorkoutRepository;
import com.workouttracker.repository.WorkoutRepository;

/**
 * @author hameedu sultan
 *
 */
@Service
public class WorkoutServiceImpl implements WorkoutService {
	
	@Autowired
	private ActiveWorkoutRepository activeWorkoutRepository;
	
	@Autowired
	private WorkoutRepository workoutRepository;

	@Override
	public List<Workout> getWorkouts() {
		return workoutRepository.findAll();
	}

	@Override
	public ActiveWorkout getActiveWorkout() {
		// TODO Auto-generated method stub
		/*activeWorkoutRepository.findAll().stream().filter(s -> { 
			return s.isStatus();
		});*/
		return activeWorkoutRepository.findByStatus(true);
	}

}
