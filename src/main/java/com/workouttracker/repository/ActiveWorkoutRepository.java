package com.workouttracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.workouttracker.model.ActiveWorkout;

/**
 * @author hameedu Sultan
 *
 */
@Transactional
public interface ActiveWorkoutRepository extends JpaRepository<ActiveWorkout, Long> {
	
	ActiveWorkout findByStatus(boolean status);
	
	List<ActiveWorkout> findAllByStatus(boolean status);

}
