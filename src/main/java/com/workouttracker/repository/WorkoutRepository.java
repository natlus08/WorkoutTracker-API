/**
 * 
 */
package com.workouttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.workouttracker.model.Workout;

/**
 * @author hameedu Sultan
 *
 */
@Transactional
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
