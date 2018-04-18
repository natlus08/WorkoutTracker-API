/**
 * 
 */
package com.workouttracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workouttracker.model.Category;
import com.workouttracker.repository.CategoryRepository;

/**
 * @author hameedu sultan
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRespository;

	@Override
	public List<Category> getCategories() {
		return categoryRespository.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		return categoryRespository.save(category);
	}

	@Override
	public Category editCategory(Category category) {
		if(categoryRespository.existsById(category.getId())){
			return categoryRespository.save(category);
		}
		return null;
	}

	@Override
	public void removeCategory(Long id) {
		categoryRespository.deleteById(id);	
	}	

}
