/**
 * 
 */
package com.workouttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.workouttracker.model.Category;

/**
 * @author hameedu Sultan
 *
 */
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
