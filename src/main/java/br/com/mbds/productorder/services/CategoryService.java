package br.com.mbds.productorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mbds.productorder.entities.Category;
import br.com.mbds.productorder.repositories.CategoryRepository;
import br.com.mbds.productorder.services.exceptions.DatabaseException;
import br.com.mbds.productorder.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Category insert(Category obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Category update(Long id, Category obj) {
		try {
			Category entity = repository.getReferenceById(id);
			setData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void setData(Category entity, Category obj) {
		entity.setName(obj.getName());
	}

}
