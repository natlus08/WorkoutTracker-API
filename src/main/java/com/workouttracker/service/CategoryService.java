/**
 * 
 */
package com.workouttracker.service;

import java.util.List;

import com.workouttracker.model.Category;

/**
 * @author hameedu sultan
 *
 */
public interface CategoryService {
	
	List<Category> getCategories();

	Category addCategory(Category category);
	
}
