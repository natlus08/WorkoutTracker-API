/**
 * 
 */
package com.workouttracker.service;

import java.util.List;
import java.util.Optional;

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
		return activeWorkoutRepository.findByStatus(true);
	}

	@Override
	public Workout addWorkout(Workout workout) {
		return workoutRepository.save(workout);
	}

	@Override
	public Workout editWorkout(Workout workout) {
		if(workoutRepository.existsById(workout.getId())){
			return workoutRepository.save(workout);
		}
		return null;
	}

	@Override
	public void deleteWorkout(Long id) {
		workoutRepository.deleteById(id);
	}

	@Override
	public ActiveWorkout startActiveWorkout(ActiveWorkout activeWorkout) {
		return activeWorkoutRepository.save(activeWorkout);
	}

	@Override
	public ActiveWorkout endActiveWorkout(ActiveWorkout activeWorkout) {
		if(activeWorkoutRepository.existsById(activeWorkout.getId())){
			return activeWorkoutRepository.save(activeWorkout);
		}
		return null;
	}

	@Override
	public Workout getWorkout(Long id) {
		Optional<Workout> workouts = workoutRepository.findById(id);
		if(workouts.isPresent()){
			return workouts.get();
		}
		return null;
	}

	@Override
	public List<ActiveWorkout> getActiveWorkouts() {
		return activeWorkoutRepository.findAllByStatus(false);
	}

}
